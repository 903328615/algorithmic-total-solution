package algorithmic.total.solution.leetcode;

/**
 * @program: algorithmic-total-solution
 * @description: 给你一个长度为 5 的字符串 time ，表示一个电子时钟当前的时间，格式为 "hh:mm" 。最早 可能的时间是 "00:00" ，最晚 可能的时间是 "23:59" 。
 * <p>
 * 在字符串 time 中，被字符 ? 替换掉的数位是 未知的 ，被替换的数字可能是 0 到 9 中的任何一个。
 * <p>
 * 请你返回一个整数 answer ，将每一个 ? 都用 0 到 9 中一个数字替换后，可以得到的有效时间的数目。
 * @author: wangzibin
 * @create: 2023-05-10
 **/
public class Question2437 {

    public int countTime(String time) {

        char[] timeChar = time.toCharArray();
        int h = 0;
        int m = 0;
        for (int i = 0; i < 24; i++) {
            int h1 = i / 10; // 首位
            int h2 = i % 10; // 第二位
            boolean firstEq = timeChar[0] == '?' || timeChar[0] == h1 + '0';
            boolean secEq = timeChar[1] == '?' || timeChar[1] == h2 + '0';
            if (firstEq && secEq) {
                h++;
            }
        }
        for (int i = 0; i < 60; i++) {
            int h1 = i / 10; // 首位
            int h2 = i % 10; // 第二位
            boolean firstEq = timeChar[3] == '?' || timeChar[3] == h1 + '0';
            boolean secEq = timeChar[4] == '?' || timeChar[4] == h2 + '0';
            if (firstEq && secEq) {
                m++;
            }
        }
        return h * m;
    }

    public static void main(String[] args) {
        System.out.println(1 + '0');
        System.out.println('1');
    }

}

