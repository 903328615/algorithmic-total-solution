import util.DateUtil;

import java.util.Date;

/**
 * @description: 你好这世间
 * @author: wangzibin
 * @create: 2021-10-24
 **/
public class HelloWord {
    public static void main(String[] args) {
        System.out.println("Hello Word");
        System.out.println("你好 世界");
        Date timeOutStartDate = DateUtil.getDatePreDay(7);
        System.out.println(DateUtil.getWholeString(timeOutStartDate));
    }
}

