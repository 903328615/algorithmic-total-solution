package algorithmic.total.solution.leetcode.offer;

import java.util.Arrays;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-02-21
 **/
public class Offer56 {

    public static int[] singleNumbers(int[] nums) {

        int sm = 0;
        // 首先算出数组中两个不同的数的 异或值
        for (int num : nums) {
            sm = sm ^ num;
        }
        int dev = 1;
        // 用 dev 记录 sm 第一个不为 0 的位
        while ((dev & sm) == 0) {
            dev <<= 1;
        }
        int a = sm,b = sm;
        for (int num : nums) {
            // 位运算 dev 进行分组
            if ((num & dev) != 0){
                a = num ^ a;
            }else {
                b = num ^ b;
            }
        }

        return new int[]{a, b};
    }


    public static void main(String[] args) {
        int[] result = new int[]{1, 2, 2, 6, 4, 4};

        // 1 ^ 6  = 5
        //
        System.out.println(Arrays.toString(singleNumbers(result)));
        // 10 10 00 01 10
        // 110 000
        // 110 ^ 011  =  101
        // ^ 不进位相加 110 110 = 000
        // 001  110 = 111 如何取数
        System.out.println(1 ^ 7);
        System.out.println(6 ^ 7);

    }
}

