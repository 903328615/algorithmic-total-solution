package algorithmic.total.solution.leetcode;

import java.util.*;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-02-28
 **/
public class Question2363 {

    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < items1.length; i++) {
            map.put(items1[i][0], items1[i][1]);
        }
        for (int i = 0; i < items2.length; i++) {
            int key = items2[i][0];
            int weight = map.getOrDefault(key, 0);
            map.put(key, weight + items2[i][1]);
        }
        List<List<Integer>> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            List<Integer> item = new ArrayList<>();
            item.add(entry.getKey());
            item.add(entry.getValue());
            list.add(item);
        }
        return list;
    }


    public static void main(String[] args) {

    }
}

