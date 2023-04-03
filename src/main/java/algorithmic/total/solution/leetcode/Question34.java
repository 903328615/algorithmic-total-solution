package algorithmic.total.solution.leetcode;

import java.util.Arrays;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-03-27
 **/
public class Question34 {

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[]{-1, -1};
        }
        // 找目标值起始和终止位置，要求 logN  ， 非递减顺序排列， 二分查找
        int start = -1;
        int end = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                // 等于的情况 我嗅探一下看看能不能返回
                start = end = mid;
                // 就这个一个
                if (start > 0 && nums[start - 1] != target && start < nums.length - 1 && nums[start + 1] != target) {
                    return new int[]{start, end};
                }
                break;
            }
        }
        if (start > 0) {
            // 找到右侧第一个不等于 target 的位置
            left = 0;
            right = start - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (nums[mid] == target) {
                    start = mid;
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }
        }
        if (end < nums.length - 1 && end >= 0) {
            left = end + 1;
            right = nums.length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (nums[mid] == target) {
                    end = mid;
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }
        }

        return new int[]{start, end};
    }

    public static void main(String[] args) {
        /*System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));*/
        System.out.println(Arrays.toString(searchRange(new int[]{2, 2}, 2)));
        System.out.println(Arrays.toString(searchRange(new int[]{2}, 2)));
    }
}

