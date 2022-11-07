package algorithmic.total.solution.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2022-11-02
 **/
public class Question1566 {

    public static Map<String, Integer> patternNumMap = new HashMap<>();

    public static boolean containsPattern(int[] arr, int m, int k) {
        if (m > arr.length || k > arr.length) {
            return false;
        }
        if (k == 1 && m < arr.length) {
            return true;
        }
        for (int i = 0; i <= arr.length - m; i++) {
            patternNumMap = new HashMap<>();
            for (int j = i; j <= arr.length - m; j += m) {
                String str = getString(arr, j, j + m);
                Integer num = patternNumMap.get(str);
                if (num == null) {
                    patternNumMap = new HashMap<>();
                    patternNumMap.put(str, 1);
                } else {
                    num += 1;
                    patternNumMap.put(str, num);
                    if (num >= k) {
                        return true;
                    }
                }
            }
            System.out.println(patternNumMap);
        }
        return false;
    }

    private static String getString(int[] arr, int start, int end) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = start; i < end; i++) {
            stringBuilder.append(arr[i]);
        }
        System.out.println(start + "," + end);
        return stringBuilder.toString();
    }


    public static boolean containsPattern2(int[] arr, int m, int k) {
        if (m > arr.length || k > arr.length) {
            return false;
        }
        if (k == 1 && m < arr.length) {
            return true;
        }
        int range = m * k;
        for (int i = 0; i <= arr.length - range; i++) {
            int offset;
            for ( offset = 0; offset < range; offset++) {
                if (arr[i + offset % m] != arr[i + offset]) {
                    break;
                }
            }
            if (offset == range){
                return true;
            }

        }
        return false;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 4, 4, 3, 4, 4, 4, 3, 4, 4, 4, 3, 4, 4, 4};
        System.out.println(containsPattern(arr, 1, 3));
        System.out.println(patternNumMap);

    }
}

