package algorithmic.total.solution.leetcode;

/**
 * @program: algorithmic-total-solution
 * @description: 模拟行走机器人
 * @author: wangzibin
 * @create: 2023-07-20
 **/
public class Question874 {

    public static int robotSim(int[] commands, int[][] obstacles) {

        int x0 = obstacles[0][0];
        int y0 = obstacles[0][1];

        int[][] map = new int[30000][];
        // 负数的问题
        for (int i = 0; i < obstacles.length; i++) {
            map[obstacles[i][0]][obstacles[i][1]] = 1;
        }

        // 1 上 2 下 3 左 4 右
        int toward = 1;
        int max = 0;
        int curX = 0;
        int curY = 0;
        for (int i = 0; i < commands.length; i++) {
            int command = commands[i];
            if (command == -2) {
                toward = turnLeft(toward);
            } else if (command == -1) {
                toward = turnRight(toward);
            } else {
                switch (toward) {
                    case 1:
                        for (int j = 0; j < command; j++) {
                            if (map[curX][curY] == 1){
                                continue;
                            }
                        }
                        break;
                }
            }

        }

        return max;
    }

    private static int turnLeft(int toward) {
        toward--;
        return toward < 1 ? 4 : toward;
    }

    private static int turnRight(int toward) {
        toward++;
        return toward > 4 ? 1 : toward;
    }
}

