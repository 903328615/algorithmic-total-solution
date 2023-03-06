package algorithmic;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-02-24
 **/
public class RobotMoveQuestion {

    public static int walk(int N, int cur, int rest, int P) {
        if (rest == 0) {
            return cur == P ? 1 : 0;
        }
        if (cur == 1) {
            return walk(N, 2, rest - 1, P);
        }
        if (cur == N) {
            return walk(N, N - 1, rest - 1, P);
        }
        return walk(N, cur + 1, rest - 1, P) + walk(N, cur - 1, rest - 1, P);
    }

    // n 是数组长度 [1,2,3]
    // m 是当前位置 1<=m<=n
    // k 是可以走 k 步
    // p 是到达点
    // 问有多少种走法
    // dp[i][j]  i 当前位置 j 是剩余步数 dp[i][j] = i==1 ? dp[i+1][j] : i==n ? dp[i-1][j] : dp[i-1][j]+dp[i+1][j];
    public static int getMoveNum(int n, int m, int k, int p) {
        if (Math.abs(m - p) > k) {
            return 0;
        }
        if (k == 0 && m == p) {
            return 1;
        }
        int result = 0;
        if (m == 1) {
            // 只能往右走
            result += getMoveNum(n, m + 1, k - 1, p);
        } else if (m == n) {
            // 只能左走
            result += getMoveNum(n, m - 1, k - 1, p);
        } else {
            // 都可以尝试
            result = getMoveNum(n, m + 1, k - 1, p) + getMoveNum(n, m - 1, k - 1, p);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getMoveNum(10, 3, 5, 1));
        System.out.println(walk(10, 3, 5, 1));
        // 1 2 3 4 5 6 7 8 9 10
        // p   m
    }

}

