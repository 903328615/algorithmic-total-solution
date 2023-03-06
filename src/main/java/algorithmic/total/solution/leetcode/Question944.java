package algorithmic.total.solution.leetcode;

import java.util.Arrays;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-02-27
 **/
public class Question944 {

    public static int minDeletionSize(String[] strs) {
        if (strs == null || strs.length <= 1) {
            return 0;
        }
        int length = strs[0].length();
        int high = strs.length;
        char[][] str = new char[high][length];
        for (int i = 0; i < high; i++) {
            for (int j = 0; j < length; j++) {
                str[i][j] = strs[i].charAt(j);
            }
        }
        int needDel = 0;
        for (int j = 0; j < length; j++) {
            for (int i = 0; i < high - 1; i++) {
                if (str[i][j] > str[i + 1][j]) {
                    needDel++;
                    break;
                }
            }
        }

        return needDel;
    }

    public static void main(String[] args) {
        System.out.println(minDeletionSize(new String[]{"qbc", "cde", "efg"}));
    }
}

