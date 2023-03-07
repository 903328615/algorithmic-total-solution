package algorithmic;

import org.apache.commons.lang3.StringUtils;

/**
 * @program: algorithmic-total-solution
 * @description: ["abc","bbc","ab"]  abbbc  需要怎么拼，数组字符串随便拆,无限用，最少需要用几个字符串
 * @author: wangzibin
 * @create: 2023-03-06
 **/
public class UseMinCard {

    public static int minCard(String[] arr, String target) {

        if (StringUtils.isBlank(target)) {
            return 0;
        }
        int n = arr.length;
        int[][] map = new int[n][26];
        for (int i = 0; i < n; i++) {
            char[] chars = arr[i].toCharArray();
            for (char c : chars) {
                map[i][c - 'a']++;
            }
        }
        char[] targetChar = target.toCharArray();

        int[] targetMap = new int[26];
        for (int i = 0; i < targetChar.length; i++) {
            targetMap[targetChar[i] - 'a']++;
        }
        int process = process(map, targetMap);
        return process == Integer.MAX_VALUE ? -1 : process;
    }

    public static int process(int[][] map, int[] targetMap) {

        boolean allEmp = true;
        int first = 0;
        for (int i = 0; i < targetMap.length; i++) {
            if (targetMap[i] > 0) {
                first = i;
                allEmp = false;
                break;
            }
        }
        if (allEmp) {
            return 0;
        }

        // 对于当前 target 我首先选哪个来拼
        int result = Integer.MAX_VALUE;
        // 使用每个贴纸的方案抓一个结果
        for (int i = 0; i < map.length; i++) {
            if (map[i][first] == 0) {
                continue;
            }
            int[] targetMapNext = new int[26];
            for (int j = 0; j < 26; j++) {
                if (targetMap[j] > 0) {
                    int num = targetMap[j] - map[i][j];
                    num = Math.max(num, 0);
                    targetMapNext[j] = num;
                }
            }
            int process = process(map, targetMapNext);
            if (process != Integer.MAX_VALUE) {
                result = Math.min(process + 1, result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(minCard(new String[]{"abbc", "qdc"}, "qabc"));
        System.out.println(minCard(new String[]{"abbc", "qdc"}, "qaddfbc"));
        System.out.println(minCard(new String[]{"aaaa", "bbbb","cccc"}, "aaaaabbbbbcc"));
    }
}

