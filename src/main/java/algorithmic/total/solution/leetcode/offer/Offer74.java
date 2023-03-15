package algorithmic.total.solution.leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: algorithmic-total-solution
 * @description: 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * @author: wangzibin
 * @create: 2023-03-15
 **/
public class Offer74 {
    public static int[][] merge(int[][] intervals) {

        // 首先是排序，跟进区间开头排序
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        sort(intervals);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        one.add(intervals[0][0]);
        one.add(intervals[0][1]);
        result.add(one);
        int maxEnd = intervals[0][1];
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (maxEnd >= intervals[i][0]) {
                // 可以合并
                maxEnd = Math.max(maxEnd, intervals[i][1]);
                result.get(index).set(1, maxEnd);
            } else {
                List<Integer> item = new ArrayList<>();
                item.add(intervals[i][0]);
                item.add(intervals[i][1]);
                result.add(item);
                maxEnd = intervals[i][1];
                index++;
            }
        }
        int[][] arr = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            arr[i][0] = result.get(i).get(0);
            arr[i][1] = result.get(i).get(1);
        }
        return arr;
    }

    private static void sort(int[][] intervals) {
        processSort(intervals, 0, intervals.length - 1);
    }

    private static void processSort(int[][] intervals, int left, int right) {
        if (intervals.length < 2 || left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        processSort(intervals, left, mid);
        processSort(intervals, mid + 1, right);
        marge(intervals, left, mid, right);
    }

    private static void marge(int[][] intervals, int left, int mid, int right) {
        // [l,m] [m+1,right]
        int[][] help = new int[right - left + 1][2];
        int lStart = left;
        int rStart = mid + 1;
        int index = 0;
        while (lStart <= mid && rStart <= right) {
            if (intervals[lStart][0] > intervals[rStart][0]) {
                help[index][0] = intervals[rStart][0];
                help[index][1] = intervals[rStart][1];
                rStart++;
            } else {
                help[index][0] = intervals[lStart][0];
                help[index][1] = intervals[lStart][1];
                lStart++;
            }
            index++;
        }
        while (lStart <= mid) {
            help[index][0] = intervals[lStart][0];
            help[index][1] = intervals[lStart][1];
            lStart++;
            index++;
        }
        while (rStart <= right) {
            help[index][0] = intervals[rStart][0];
            help[index][1] = intervals[rStart][1];
            rStart++;
            index++;
        }
        index = 0;
        for (int i = left; i <= right; i++) {
            intervals[i][0] = help[index][0];
            intervals[i][1] = help[index][1];
            index++;
        }
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{7, 8}, {5, 9}, {1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
}

