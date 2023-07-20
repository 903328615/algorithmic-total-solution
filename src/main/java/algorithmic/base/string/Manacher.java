package algorithmic.base.string;


import org.apache.commons.lang3.StringUtils;

/**
 * @program: algorithmic-total-solution
 * @description: 最大回文子串算法 O(N)
 * @author: wangzibin
 * @create: 2023-07-12
 **/
public class Manacher {

    public static String longestPalindrome(String s) {

        if (s == null || s.length() < 1) {
            return s;
        }
        // 首先变换为替换 # 串
        char[] mCharArray = getManacherArray(s.toCharArray());
        // 回文半径大小
        int[] pArray = new int[mCharArray.length];
        // 对称中心点位置
        int c = -1;
        // 回文最右点位,最右不匹配点
        int r = -1;
        int star = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < mCharArray.length; i++) {

            // 现在的问题是找到一个可以直接进行比对的位置
            pArray[i] = i < r ? Math.min(pArray[2 * c - i], r - i) : 1;
            // 非常好，我找到了一个可比对位置，我开始比对了
            // 判断位置是否合法，比对当前位置
            while (i + pArray[i] < mCharArray.length && i - pArray[i] > -1
                    && mCharArray[i + pArray[i]] == mCharArray[i - pArray[i]]) {
                pArray[i]++;
            }
            // 判断是否可以更新最大位点
            if (i + pArray[i] > r) {
                c = i;
                r = i + pArray[i];
            }
            if (r - c > max) {
                max = r - c;
                star = c - max + 1;
                end = c + max - 1;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = star; i <= end; i++) {
            if (i % 2 != 0) {
                stringBuilder.append(mCharArray[i]);
            }
        }

        return stringBuilder.toString();
    }

    private static char[] getManacherArray(char[] array) {
        if (array == null || array.length < 1) {
            return array;
        }
        char[] result = new char[2 * array.length + 1];
        result[0] = '#';
        int k = 1;
        for (int i = 0; i < array.length; i++) {
            result[k++] = array[i];
            result[k++] = '#';
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(getManacherArray(new char[]{'1', '2', '3', '5', '3'}));
        System.out.println(longestPalindrome("babad"));
    }
}

