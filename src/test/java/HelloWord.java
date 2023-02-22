import org.apache.commons.lang3.StringUtils;
import util.DateUtil;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

/**
 * @description: 你好这世间
 * @author: wangzibin
 * @create: 2021-10-24
 **/
public class HelloWord {
    public static void main(String[] args) {
        System.out.println("Hello Word");
        System.out.println("你好 世界");
        Date timeOutStartDate = DateUtil.getDatePreDay(1);
        System.out.println(DateUtil.getWholeString(timeOutStartDate));
        Date timeOutEndDate = DateUtil.getDatePreMinutes(25);
        System.out.println(DateUtil.getWholeString(timeOutEndDate));
        //2023-02-15 14:25:00 当前时间
        //2023-02-14 00:00:00  ----- 2023-02-15 14:00:00

        System.out.println(Arrays.toString(StringUtils.split("23333,ssddsfsdf,23234,sdfs", ",")));
        int[] n =new int[]{1,3,4};
        for (int i=100;i<n.length;i++){
            System.out.println(n[i]);
        }
    }
}

