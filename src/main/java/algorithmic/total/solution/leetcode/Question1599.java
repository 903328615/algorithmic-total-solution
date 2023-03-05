package algorithmic.total.solution.leetcode;

public class Question1599 {

    public static int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int maxRun = -1;
        if (customers != null && customers.length > 0) {
            int total = 0;
            int maxTotal = 0;
            int wait = 0;
            int index = 0;
            int runNum = 0;
            while (wait > 0 || index < customers.length) {
                runNum++;
                // 转一圈，用户进入排队
                if (index < customers.length) {
                    wait += customers[index++];
                }
                // 能上多少
                int canGo = wait >= 4 ? 4 : wait;
                wait -= canGo;
                // 上去算总利润
                total += boardingCost * canGo - runningCost;
                if (maxTotal < total) {
                    maxTotal = total;
                    maxRun = runNum;
                }
            }
        }
        return maxRun;
    }

    public static void main(String[] args) {
        System.out.println(minOperationsMaxProfit(new int[]{8,3},5,6));
        System.out.println(minOperationsMaxProfit(new int[]{10,9,6},6,4));
        System.out.println(minOperationsMaxProfit(new int[]{3,4,0,5,1},1,92));
    }
}
