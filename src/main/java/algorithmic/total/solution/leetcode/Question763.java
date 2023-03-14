package algorithmic.total.solution.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: algorithmic-total-solution
 * @description: 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * 返回一个表示每个字符串片段的长度的列表。
 * 示例 1：
 * 输入：s = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
 * @author: wangzibin
 * @create: 2023-03-14
 **/
public class Question763 {

    public static List<Integer> partitionLabels(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        Map<Character, Integer> mapMaxEnd = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            mapMaxEnd.put(chars[i], i);
        }
        int start = 0;
        while (start <= chars.length - 1) {
            int count = 1;
            int end = mapMaxEnd.get(chars[start]);
            while (start < end) {
                start++;
                count++;
                end = Math.max(end, mapMaxEnd.get(chars[start]));
            }
            start++;
            result.add(count);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(partitionLabels("eccbbbbdec"));
        System.out.println(partitionLabels("eaaaabaaec"));
    }
}

