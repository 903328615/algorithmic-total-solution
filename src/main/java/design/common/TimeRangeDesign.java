/*
package design.common;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

*/
/**
 * @program: algorithmic-total-solution
 * @description: 时间范围离散点赞分布计算设计
 * @author: wangzibin
 * @create: 2023-01-06
 **//*

public class TimeRangeDesign {


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CmsFakeSubTaskDO {
        */
/**
         * 自增主键
         *//*

        private long id;
        */
/**
         * 创建时间
         *//*

        private Date addTime;
        */
/**
         * 更新时间
         *//*

        private Date updateTime;
        */
/**
         * 注水作品 id
         *//*

        private String formId;
        */
/**
         * 主任务id
         *//*

        private long fakeTaskId;
        */
/**
         * 虚拟用户id
         *//*

        private long randomUserId;
        */
/**
         * 操作类型  1 点赞 2 收藏 3 评论
         *//*

        private int operateType;
        */
/**
         * 内容，评论时为评论内容
         *//*

        private String content;
        */
/**
         * 实际的执行时间
         *//*

        private Date actualOperateTime;
        */
/**
         * 预计执行时间
         *//*

        private Date operateTime;
        */
/**
         * 1 待执行 2 已执行 3 取消执行
         *//*

        private int status;

    }
*/
/*

    private static List<CmsFakeSubTaskDO> doCalculationSubTask(int targetNum, int expTime) {
        List<CmsFakeSubTaskDO> result = Lists.newArrayList();
        if (targetNum <= 0) {
            return result;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long expTimeSec = expTime * 3600L;
        long expEndTime = currentTimeMillis + (expTimeSec * 1000L);
        System.out.println(new Date(expEndTime));
        // 计算每个操作所需要的最小时间块
        int perTimeRangeDo = 1;
        int doTimeRange = 1;
        if (targetNum > expTimeSec) {
            perTimeRangeDo = (int) Math.ceil(targetNum / (double) expTimeSec);
        } else {
            doTimeRange = (int) Math.floor(expTimeSec / (double) targetNum);
        }
        int doTimeRangeMillis = doTimeRange * 1000;
        System.out.println("perTimeRangeDo=" + perTimeRangeDo + " doTimeRange=" + doTimeRange);
        int alreadyDo = 0;
        int count = 0;
        Random random = new Random();
        while (currentTimeMillis < expEndTime) {
            for (int i = 0; i < perTimeRangeDo; i++) {
                // 随机浮动 2 分钟
                long randomDoTime = currentTimeMillis + random.nextInt(doTimeRangeMillis) + random.nextInt(120000);
                CmsFakeSubTaskDO cmsFakeSubTaskDO = CmsFakeSubTaskDO.builder()
                        .fakeTaskId(1)
                        .formId("formId")
                        .operateTime(new Date(randomDoTime))
                        .operateType(1)
                        .randomUserId(1)
                        .content(StringUtils.EMPTY)
                        .build();
                result.add(cmsFakeSubTaskDO);
                System.out.println(dateToStr(cmsFakeSubTaskDO.getOperateTime()));
            }
            alreadyDo += perTimeRangeDo;
            currentTimeMillis += doTimeRangeMillis;
        }
       return result;
    }
*//*




    public static String dateToStr(Date date){
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    public static void main(String[] args) {
        ThreadLocalRandom.current().nextInt(100);
        doCalculationSubTask(1, 4);
    }




}

*/
