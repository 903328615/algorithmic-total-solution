package algorithmic.base.string;

import java.util.Arrays;

/**
 * @program: algorithmic-total-solution
 * @description: kmp 算法，开头比对 + next 数组，向后移动 O(N)
 * @author: wangzibin
 * @create: 2023-06-26
 **/
public class Kmp {


    // 计算 next 数组
    // next 数组含义 对于 i 位置 其 [0,i-1] 位置两端对称的最大长度 ： 如  ascasb  对于 i = 5 next[i]=2
    // aaaab
    public static int[] getNextArray(String str) {
        if (str == null || str.length() < 1) {
            return null;
        }
        char[] strArray = str.toCharArray();
        int length = str.length();
        int[] nextArray = new int[length];
        nextArray[0] = -1;
        nextArray[1] = 0;
        // aaabcacaa
        // 核心思想，对于任意 i 位置，关注 i - 1 位置的 next 值
        // 记录当前需要比对的位置，初始位置是 0
        int cn = 0;
        int i = 2;
        while (i < length) {
            // 当前可比对位置相等，则直接赋值
            if (strArray[cn] == strArray[i - 1]) {
                nextArray[i++] = ++cn;
            } else if (cn > 0) {
                // 如果不等，对于要比对位置，获取其 next 数组位置再进行循环比对，直至拿到最小的对称组，或者直至为 0
                cn = nextArray[cn];
            } else {
                nextArray[i++] = 0;
            }
        }

        return nextArray;

    }

    public static int[] getNextArray2(String str) {

        if (str == null || str.length() < 1) {
            return null;
        }
        char[] chars = str.toCharArray();
        int[] next = new int[str.length()];
        next[0] = -1;
        next[1] = 0;
        // 比对位置
        int cn = 0;
        int i = 2;
        while (i < str.length()) {
            if (chars[i - 1] == chars[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                // 如果还有找之前的分隔比对
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;

    }

    public static int indexOf2(String sourceStr, String matchStr) {
        return -1;
    }


    public static int indexOf(String sourceStr, String matchStr) {
        if (matchStr == null || sourceStr == null || sourceStr.length() < 1 || matchStr.length() < 1) {
            return -1;
        }
        char[] source = sourceStr.toCharArray();
        char[] match = matchStr.toCharArray();
        // x 中比对到的位置
        int x = 0;
        // match 中比对到的位置
        int y = 0;
        int[] next = getNextArray(matchStr);
        while (x < source.length && y < match.length) {
            if (source[x] == match[y]) {
                x++;
                y++;
            } else if (y == 0) {
                x++;
            } else {
                // 这里如果不匹配找到之前可以利用的匹配点
                y = next[y];
            }
        }
        // 最后看匹配点
        return y == match.length ? x - y : -1;
    }

    public static void main(String[] args) {

        String str = "acddacddsdcccseedd";
        System.out.println(Arrays.toString(getNextArray(str)));
        System.out.println(Arrays.toString(getNextArray2(str)));
        System.out.println(indexOf("sscc", "ssqsssdf"));
        System.out.println(indexOf("ssccqqxxxxd", "ccq"));

    }


}

