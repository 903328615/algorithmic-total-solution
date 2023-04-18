package algorithmic.total.solution.leetcode;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-04-12
 **/
public class Question165 {

    public static int compareVersion(String version1, String version2) {
        if (version1 != null && version1 != "" && version2 != null && version2 != "") {


            String[] baseV1 = version1.split("\\.");
            String[] baseV2 = version2.split("\\.");
            int length = Math.max(baseV1.length, baseV2.length);
            for (int i = 0; i < length; i++) {
                int v1 = 0;
                int v2 = 0;
                if (i < baseV1.length) {
                    v1 = Integer.parseInt(baseV1[i]);
                }
                if (i < baseV2.length) {
                    v2 = Integer.parseInt(baseV2[i]);
                }
                if (v1 < v2) {
                    return -1;
                } else if (v1 > v2) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("", ""));
        System.out.println(compareVersion("1.01", "1.0001"));
        System.out.println(compareVersion("1.1", "0.1"));
    }

}

