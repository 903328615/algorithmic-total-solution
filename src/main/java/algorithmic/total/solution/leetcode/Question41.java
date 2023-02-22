package algorithmic.total.solution.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-02-14
 **/
public class Question41 {

    public static int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = length + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int abs = Math.abs(nums[i]);
            if (abs <= length && nums[abs - 1] > 0) {
                nums[abs - 1] = -nums[abs - 1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return length + 1;
    }


    public static int firstMissingPositive2(int[] nums) {
       for (int i=1;true;i++){
           boolean have = false;
           for (int num:nums){
               if (num==i){
                   have=true;
                   break;
               }
           }
           if (!have){
               return i;
           }
       }
    }

    public static void main(String[] args) {

        System.out.println(firstMissingPositive(new int[]{1,2,0}));
    }
}

