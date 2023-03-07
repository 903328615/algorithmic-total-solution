package algorithmic.total.solution.leetcode;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-03-06
 **/
public class Question1653 {

    public static int minimumDeletions(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int delRa = 0;
        int delLb = 0;
        // 全删 a
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a') {
                delRa++;
            }
        }
        // 删除 b 抓最小
        int result = delRa;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a') {
                delRa--;
            } else {
                delLb++;
            }
            result = Math.min(result, delRa + delLb);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(minimumDeletions("aababbab"));
        System.out.println(minimumDeletions("bbaaaaabb"));
    }
}

