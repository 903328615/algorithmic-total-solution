package algorithmic.total.solution.leetcode;

import java.util.*;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-07-04
 **/
public class Question1604 {

    public static class PeopleUseInfo {

        public PeopleUseInfo() {
            this.timeUse = new int[25];
            this.needAlert = false;
        }

        private int[] timeUse;
        private boolean needAlert;

        public void addTime(String time) {
            String[] split = time.split(":");
            Integer h = Integer.valueOf(split[0]);
            Integer m = Integer.valueOf(split[1]);

            timeUse[h]++;
            if (timeUse[h] >= 3) {
                needAlert = true;
            }
            if (m == 0 && h > 0) {
                timeUse[h - 1]++;
                if (timeUse[h - 1] >= 3) {
                    needAlert = true;
                }
            }


        }
    }


    public static List<String> alertNames(String[] keyName, String[] keyTime) {

        // 要求字典序升序返回
        // 首先要求 O(n) ， 聚合名字相同的，合并小时使用
        int length = keyName.length;
        List<String> result = new ArrayList<>();
        Map<String, PeopleUseInfo> nameNumMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            String key = keyName[i];
            PeopleUseInfo peopleUseInfo = nameNumMap.getOrDefault(key, new PeopleUseInfo());
            peopleUseInfo.addTime(keyTime[i]);
            nameNumMap.put(key, peopleUseInfo);
        }
        for (Map.Entry<String, PeopleUseInfo> entry : nameNumMap.entrySet()) {
            PeopleUseInfo value = entry.getValue();
            if (value.needAlert) {
                result.add(entry.getKey());
            }
        }
        result.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return result;
    }

    public static void main(String[] args) {

        String[] keyName = new String[]{"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"};
        String[] keyTime = new String[]{"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"};
        System.out.println(alertNames(keyName, keyTime));

    }


}

