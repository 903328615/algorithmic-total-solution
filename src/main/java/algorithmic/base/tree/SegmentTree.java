package algorithmic.base.tree;

import util.RandomUtil;

import java.util.Random;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-07-24
 **/
public class SegmentTree {


    private int orgLength;
    private int helpLength;
    private int[] ogArray;
    private int[] sum;
    private int[] lazyAdd;
    private int[] lazyUpdate;
    // 单独用一个数组标记是否进行了更新
    private boolean[] lazyUpdateFlag;

    public SegmentTree(int[] arr) {
        orgLength = arr.length + 1;
        helpLength = orgLength << 2;
        // 下标从 1 开始
        ogArray = new int[orgLength];
        for (int i = 0; i < arr.length; i++) {
            ogArray[i + 1] = arr[i];
        }
        lazyUpdate = new int[helpLength];
        lazyUpdateFlag = new boolean[helpLength];
        lazyAdd = new int[helpLength];
        sum = new int[helpLength];
        build(1, 1, orgLength - 1);
    }

    public void update(int updateL, int updateR, int updateNum) {
        update(updateL, updateR, 1, orgLength - 1, 1, updateNum);
    }


    /**
     * @param updateL   [updateL,updateR]
     * @param updateR
     * @param operateL
     * @param operateR
     * @param treeIndex
     * @return void
     * @description:
     */
    private void update(int updateL, int updateR, int operateL, int operateR, int treeIndex, int updateNum) {

        // 全包直接可以更新
        if (updateL <= operateL && operateR <= updateR) {
            lazyUpdate[treeIndex] = updateNum;
            lazyUpdateFlag[treeIndex] = true;
            // 直接更新 sum
            sum[treeIndex] = updateNum * (operateR - operateL + 1);
            // 清空覆盖懒增加
            lazyAdd[treeIndex] = 0;
            return;
        }

        // 如果包不住，需要进行下发处理
        int mid = (operateL + operateR) >> 1;
        // 懒任务下发
        pushDownLazyTask(treeIndex, mid - operateL + 1, operateR - mid);
        if (updateL <= mid) {
            update(updateL, updateR, operateL, mid, treeIndex << 1, updateNum);
        }
        if (updateR > mid) {
            update(updateL, updateR, mid + 1, operateR, treeIndex << 1 | 1, updateNum);
        }
        sum[treeIndex] = sum[treeIndex << 1] + sum[treeIndex << 1 | 1];
    }

    /**
     * @param index 从 index 位置开始构建左右子树的 sum 信息
     * @param l     源数组左范围
     * @param r     源数组右范围
     * @return void
     * @description: 对于 i 位置 二分左孩子是 2*i  i << 1 二分右孩子是  2*i+1 = i << 1 | 1
     */
    public void build(int index, int l, int r) {

        if (l == r) {
            sum[index] = ogArray[l];
            return;
        }
        int mid = (l + r) >> 1;
        // 递归调用把做孩子和有孩子都构建好
        build(index << 1, l, mid);
        build(index << 1 | 1, mid + 1, r);
        // 构建好后对当前 index 节点进行赋值
        sum[index] = sum[index << 1] + sum[index << 1 | 1];
    }

    public int query(int queryL, int queryR) {
        if (!checkIsLegal(queryL, queryR)) {
            return 0;
        }
        return query(queryL, queryR, 1, orgLength - 1, 1);
    }

    private boolean checkIsLegal(int l, int r) {
        if (l >= 1 && r < orgLength && l <= r) {
            return true;
        }
        return false;
    }

    /**
     * @param queryL      [queryL,queryR] 要查询的范围 这些范围都是 orgLength 的范围，跟扩充后的辅助线段树的范围没关系，
     *                    线段树的位置范围只需要根据 index 计算获取
     * @param queryR
     * @param chooseL     [chooseL,chooseR] 当前选择的表达范围(扩充后线段树数组范围)
     * @param chooseR
     * @param chooseIndex 表达范围的 index
     * @return long
     * @description:
     */
    private int query(int queryL, int queryR, int chooseL, int chooseR, int chooseIndex) {

        if (queryL <= chooseL && chooseR <= queryR) {
            return sum[chooseIndex];
        }

        //  1,2,3,4,5,6,7,8
        // 1+7 >> 1 = 4  为啥 queryL 是小于呢，因为左半边是 1-4 右半边是 5-8 右半边得 mid+1
        int mid = (chooseL + chooseR) >> 1;
        // 当前节点的数据不全包命中，则需要尝试将懒任务下发，不下发则会导致最终数据不准
        // 4-1 +1 = 4  8-4 = 4
        pushDownLazyTask(chooseIndex, mid - chooseL + 1, chooseR - mid);
        int ans = 0;
        if (queryL <= mid) {
            ans += query(queryL, queryR, chooseL, mid, chooseIndex << 1);
        }
        if (queryR > mid) {
            ans += query(queryL, queryR, mid + 1, chooseR, chooseIndex << 1 | 1);
        }
        return ans;
    }

    public void add(int l, int r, int addNum) {
        if (!checkIsLegal(l, r)) {
            return;
        }
        add(l, r, 1, orgLength - 1, 1, addNum);
    }

    /**
     * @param addL   addL-addR 任务的范围
     * @param addR
     * @param L      L-R 表达的范围
     * @param R
     * @param addNum 在哪个位置上找表达范围
     * @return void
     * @description: 给 [addL,addR] 范围上的数增加 addNum 个数
     */
    private void add(int addL, int addR, int L, int R, int index, int addNum) {
        // 如果全包则阻塞记录懒信息，更新当前范围位置 sum 值
        if (addL <= L && R <= addR) {
            sum[index] += addNum * (R - L + 1);
            lazyAdd[index] += addNum;
            return;
        }
        // 如果包不住，需要分隔下发
        int mid = (L + R) >> 1;
        // 分发前先将当前的懒任务下发下去
        pushDownLazyTask(index, mid - L + 1, R - mid);
        if (addL <= mid) {
            add(addL, addR, L, mid, index << 1, addNum);
        }
        if (addR > mid) {
            add(addL, addR, mid + 1, R, index << 1 | 1, addNum);
        }
        // 添加后更新当前节点懒信息
        sum[index] = sum[index << 1] + sum[index << 1 | 1];
    }

    private void pushDownLazyTask(int index, int leftRange, int rightRange) {

        // 根据更新标记数组判断是否有懒更新，不然更新 0 的时候没法判断
        if (lazyUpdateFlag[index]) {
            int lazyUpdateNum = lazyUpdate[index];
            lazyUpdate[index] = 0;
            lazyUpdateFlag[index] = false;
            int left = index << 1;
            int right = index << 1 | 1;
            lazyAdd[left] = 0;
            lazyAdd[right] = 0;
            lazyUpdate[left] = lazyUpdateNum;
            lazyUpdateFlag[left] = true;
            lazyUpdate[right] = lazyUpdateNum;
            lazyUpdateFlag[right] = true;
            sum[left] = leftRange * lazyUpdateNum;
            sum[right] = rightRange * lazyUpdateNum;
        }

        if (lazyAdd[index] != 0) {
            int lazyNum = lazyAdd[index];
            lazyAdd[index] = 0;
            lazyAdd[index << 1] += lazyNum;
            lazyAdd[index << 1 | 1] += lazyNum;
            sum[index << 1] += leftRange * lazyNum;
            sum[index << 1 | 1] += rightRange * lazyNum;
        }
    }


    public static void main(String[] args) {

        //对数器
        int testTimes = 5000;
        int addOrUpdateTimes = 5000;
        int maxAddOrUpdateNum = 5000;
        int testQueryTimes = 5000;
        Random random = new Random();
        //进行测试
        for (int i = 0; i < testTimes; i++) {
            int[] origin = RandomUtil.generateArray(30, 10);
            // System.out.println(Arrays.toString(origin));
            SegmentTree segmentTree = new SegmentTree(origin);
            SegmentTreeON segmentTreeON = new SegmentTreeON(origin);
            int originLength = origin.length;
            //每次测试进行添加更新操作次数
            for (int j = 0; j < addOrUpdateTimes; j++) {
                int num1 = random.nextInt(originLength) + 1;
                int num2 = random.nextInt(originLength) + 1;
                int L = Math.min(num1, num2);
                int R = Math.max(num1, num2);
                int num = random.nextInt(maxAddOrUpdateNum);
                if (random.nextInt(10) < 5) {
                    segmentTree.add(L, R, num);
                    segmentTreeON.add(L, R, num);
                } else {
                    segmentTree.update(L, R, num);
                    segmentTreeON.update(L, R, num);
                }
            }

            for (int k = 0; k < testQueryTimes; k++) {
                int num1 = random.nextInt(originLength) + 1;
                int num2 = random.nextInt(originLength) + 1;
                int L = Math.min(num1, num2);
                int R = Math.max(num1, num2);
                if (segmentTree.query(L, R) != segmentTreeON.query(L, R)) {
                    System.out.println("L-R=" + L + "-" + R);
                    System.out.println("segmentTree.query(L,R)=" + segmentTree.query(L, R));
                    System.out.println("segmentTreeON.query(L,R)=" + segmentTreeON.query(L, R));
                    System.out.println("error!!!!! testNum=" + k);
                    return;
                }
            }
            System.out.println("right " + (i + 1));
        }
    }

    //首先给个暴力解法，O(N) 的时间复杂度
    public static class SegmentTreeON {

        int[] arr;

        public SegmentTreeON(int[] origin) {
            this.arr = new int[origin.length + 1];
            for (int i = 0; i < origin.length; i++) {
                this.arr[i + 1] = origin[i];
            }
        }

        public void add(int L, int R, int num) {
            if (!checkIsLegal(L, R)) {
                return;
            }
            for (int i = L; i <= R; i++) {
                arr[i] += num;
            }
        }

        public void update(int L, int R, int num) {
            if (!checkIsLegal(L, R)) {
                return;
            }
            for (int i = L; i <= R; i++) {
                arr[i] = num;
            }
        }

        public long query(int L, int R) {
            if (!checkIsLegal(L, R)) {
                return 0;
            }
            int ans = 0;
            for (int i = L; i <= R; i++) {
                ans += arr[i];
            }
            return ans;
        }

        private boolean checkIsLegal(int l, int r) {
            if (l >= 1 && r < arr.length && l <= r) {
                return true;
            }
            return false;
        }

    }

}

