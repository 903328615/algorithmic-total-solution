package algorithmic.total.solution.leetcode.offer;

import java.util.*;

/**
 * @program: algorithmic-total-solution
 * @description: 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * @author: wangzibin
 * @create: 2023-03-07
 **/
public class Offer38 {

    private static boolean[] use;

    public static String[] permutation(String s) {
        // 全排列
        List<String> result = new ArrayList<>();
        char[] arrs = s.toCharArray();
        Arrays.sort(arrs);
        use = new boolean[arrs.length];
        process(arrs, result, 0);
        System.out.println(Arrays.toString(use));
        return result.toArray(new String[result.size()]);
    }

    // 从 index 位置开始的全排列
    public static void process(char[] arrs, List<String> result, int start) {
        if (start == arrs.length) {
            result.add(String.valueOf(arrs));
        } else {

            for (int i = start; i < arrs.length; i++) {
                // 如果之前的换过，后续的重复的就不换了
                if (use[i] || (i > 0 && use[i - 1] && arrs[i - 1] == arrs[i])) {
                    continue;
                }
                use[i] = true;
                swap(arrs, start, i);
                process(arrs, result, start + 1);
                use[i] = false;
                swap(arrs, start, i);
            }
        }
    }

    public static void swap(char[] arrs, int i, int j) {
        char a = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = a;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(permutation("abb")));
    }
}

