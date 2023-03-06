package algorithmic.total.solution.leetcode;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-02-28
 **/
public class Question55 {

    public static boolean canJump(int[] nums) {
        // 无论怎样，我再 i 位置可以选择跳 0-i 步
        // 贪心，我选择当前位置可跳跃位置后的最大值位置
        if (nums == null || nums.length <= 1) {
            return true;
        }
        // [1,1,2,2,0,1,1]  7
        int cur = 0;
        while (cur < nums.length) {
            int canJumpTo = cur + nums[cur];
            if (canJumpTo >= nums.length - 1) {
                return true;
            }
            if (canJumpTo == cur) {
                return false;
            }
            int maxI = cur + 1;
            for (int i = cur + 1; i <= canJumpTo; i++) {
                // 找到可以跳的最大位置
                if ((nums[maxI] + maxI) < (nums[i] + i)) {
                    maxI = i;
                }
            }
            cur = maxI;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{1, 1, 2, 2, 0, 1, 1}));
    }
}

