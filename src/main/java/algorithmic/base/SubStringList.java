package algorithmic.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-02-21
 **/
public class SubStringList {

    public static List<String> getSubStringList(String str) {
        List<String> result = new ArrayList<>();
        process(str.toCharArray(), 0, result, "");
        return result;
    }

    private static void process(char[] str, int i, List<String> result, String path) {
        if (i == str.length) {
            result.add(path);
            return;
        }
        String append = path + str[i];
        process(str, i + 1, result, append);
        process(str, i + 1, result, path);
    }

    public static void main(String[] args) {
        System.out.println(getSubStringList("abc"));
    }

}

