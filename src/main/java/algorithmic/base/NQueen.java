package algorithmic.base;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-02-23
 **/
public class NQueen {


    public int getNum(int n) {
        if (n < 1) {
            return 0;
        }
        return process(0, new int[n], n);
    }

    // 每行只能放一个皇后 ，
    // 在 0-i 行摆满摆好后总共有多少种摆法
    public int process(int i, int[] record, int n) {
        // 所有格子都摆好了，则说明有一种摆法，返回
        if (i == n) {
            return 1;
        }
        int result = 0;
        // i 行所有列进行尝试
        for (int j = 0; j < n; j++) {
            if (isOk(record, i, j)) {
                record[i] = j;
                result += process(i + 1, record, n);
            }
        }
        return result;
    }

    private boolean isOk(int[] record, int i, int j) {
        return false;
    }

}

