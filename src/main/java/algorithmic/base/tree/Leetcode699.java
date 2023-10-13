package algorithmic.base.tree;

import java.util.*;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-08-07
 **/
public class Leetcode699 {

    public static void main(String[] args) {
        // 9-16 7  7
        // 1-10 9  16
        // 3-4 1   17
        // 7 16 17
        // 映射后
        // 1 3 4 9 10 16
        // 1 2 3 4 5  6
        // 4-6 7 7
        // 1-5 9 16
        // 2-3 1 17
        int[][] positions = new int[][]{{9, 7}, {1, 9}, {3, 1}};
        List<Integer> integers = fallingSquares(positions);
        System.out.println(integers);
    }

    public static class Info {
        public int r;
        public int h;

        public Info(int r, int h) {
            this.r = r;
            this.h = h;
        }
    }


    public static List<Integer> fallingSquares(int[][] positions) {

        // 下落可以抽象理解为一个区域的累加模型，保持获取一个最高高度，思路是线段树的变体，获取维护范围上最大的高度
        // 那答案就是取整个范围的最大高度
        // 因为整个 positions 边界无限，需要做一个映射处理，使得维护线段树的空间成本降低到可控范围
        TreeSet<Integer> posList = new TreeSet<>();
        // 排序所有位置
        // 101 192  192 298
        for (int i = 0; i < positions.length; i++) {
            posList.add(positions[i][0]);
            posList.add(positions[i][0] + positions[i][1] - 1);
        }
        Map<Integer, Integer> posMap = new HashMap<>();
        int count = 1;
        for (Integer pos : posList) {
            posMap.put(pos, count++);
        }
        ArrayList<Integer> result = new ArrayList<>();
        SegmentTree segmentTree = new SegmentTree(count);
        int max = 0;
        for (int i = 0; i < positions.length; i++) {
            int l = posMap.get(positions[i][0]);
            // 左边界 + 高度为 右边界，统一右边界做插缝处理 -1
            int r = posMap.get(positions[i][0] + positions[i][1] - 1);
            int h = positions[i][1];
            int height = segmentTree.query(l, r) + h;
            max = Math.max(max, height);
            result.add(max);
            segmentTree.update(l, r, height);
        }
        return result;
    }


    public static class SegmentTree {


        private int orgLength;
        private int helpLength;
        private int[] maxHigh;
        private int[] lazyUpdate;

        public SegmentTree(int n) {
            orgLength = n;
            helpLength = orgLength << 2;
            // 下标从 1 开始
            lazyUpdate = new int[helpLength];
            maxHigh = new int[helpLength];
        }

        public int query(int queryL, int queryR) {
            return query(queryL, queryR, 1, orgLength - 1, 1);
        }

        private int query(int queryL, int queryR, int chooseL, int chooseR, int chooseIndex) {

            if (queryL <= chooseL && chooseR <= queryR) {
                return maxHigh[chooseIndex];
            }
            int mid = (chooseL + chooseR) >> 1;

            pushDownLazyTask(chooseIndex);
            int max = 0;
            if (queryL <= mid) {
                max = Math.max(query(queryL, queryR, chooseL, mid, chooseIndex << 1), max);
            }
            if (queryR > mid) {
                max = Math.max(query(queryL, queryR, mid + 1, chooseR, chooseIndex << 1 | 1), max);
            }
            return max;
        }

        public void update(int l, int r, int updateNum) {
            update(l, r, 1, orgLength - 1, 1, updateNum);
        }

        public void update(int addL, int addR, int chooseL, int chooseR, int chooseIndex, int updateNum) {

            if (addL <= chooseL && chooseR <= addR) {
                maxHigh[chooseIndex] = updateNum;
                lazyUpdate[chooseIndex] = updateNum;
                return;
            }
            // 如果包不住，需要分隔下发
            int mid = (chooseL + chooseR) >> 1;
            // 分发前先将当前的懒任务下发下去
            pushDownLazyTask(chooseIndex);
            if (addL <= mid) {
                update(addL, addR, chooseL, mid, chooseIndex << 1, updateNum);
            }
            if (addR > mid) {
                update(addL, addR, mid + 1, chooseR, chooseIndex << 1 | 1, updateNum);
            }
            // 添加后更新当前节点懒信息
            maxHigh[chooseIndex] = Math.max(maxHigh[chooseIndex << 1], maxHigh[chooseIndex << 1 | 1]);

        }

        private void pushDownLazyTask(int index) {

            if (lazyUpdate[index] != 0) {
                int lazyMaxNum = lazyUpdate[index];
                lazyUpdate[index] = 0;
                lazyUpdate[index << 1] = lazyMaxNum;
                lazyUpdate[index << 1 | 1] = lazyMaxNum;
                maxHigh[index << 1] = lazyMaxNum;
                maxHigh[index << 1 | 1] = lazyMaxNum;
            }

        }


    }


}

