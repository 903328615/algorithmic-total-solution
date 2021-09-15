package algorithmic.total.solution.common;

/**
 * @program: algorithmic-total-solution
 * @description: 多少个 1 问题
 * 给你一个数 N 。问 1-N 之间有多少个 1
 * 数位 dp
 * @author: wangzibin
 * @create: 2021-09-14
 **/
public class Question3 {


    public static void main(String[] args) {
        /**
         * 对数器
         */
     /*   for (int i=10000;i<99999;i++){
            long oneNumberSimple = getOneNumberSimple(i);
            long oneNumber = getOneNumber(i);

            if (oneNumber!=oneNumberSimple){
                System.out.println(i+" 错误：oneNumberSimple="+oneNumberSimple+" oneNumber="+oneNumber);
            }
        }*/
        System.out.println(countDigitOneWithLog(999999999));
        System.out.println(getOneNumberWithLog(999999999));
    }


    public static long getOneNumberSimpleWithLog(long num){
        long start=System.currentTimeMillis();
        long oneNumberSimple = getOneNumberSimple(num);
        System.out.println("getOneNumberSimpleWithLog 耗时："+(System.currentTimeMillis()-start));
        return oneNumberSimple;
    }

    public static long getOneNumberWithLog(long num){
        long start=System.currentTimeMillis();
        long oneNumberSimple = getOneNumber(num);
        System.out.println("getOneNumberWithLog 耗时："+(System.currentTimeMillis()-start));
        return oneNumberSimple;
    }

    public static long countDigitOneWithLog(long num){
        long start=System.currentTimeMillis();
        long oneNumberSimple = countDigitOne(num);
        System.out.println("countDigitOneWithLog 耗时："+(System.currentTimeMillis()-start));
        return oneNumberSimple;
    }

    public static long countDigitOne(long n) {
        // mulk 表示 10^k
        // 在下面的代码中，可以发现 k 并没有被直接使用到（都是使用 10^k）
        // 但为了让代码看起来更加直观，这里保留了 k
        long mulk = 1;
        long ans = 0;
        for (long k = 0; n >= mulk; ++k) {
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return ans;
    }




    /**
     *  @Description: 计算 1-number 间有多少个 1
     *  时间复杂度 O（lgN^2）
     *  @Param number
     *  @Return: long
     */
    public static long getOneNumber(long number) {
        if (number < 10 && number > 0) {
            return 1;
        }else if (number<=0){
            return 0;
        }
        //对于任意的 number 分类讨论最高位是 1 的情况
        int firstNum = getFirstNum(number);
        int len = getNumberLength(number);
        long result = 0;
        long firstCountOne = 0;
        long otherCountOne = 0;
        long tenPowerX = tenPowerX(len - 1);
        if (firstNum == 1) {
            // 按位计算每一位为 1 所包含的数 假设 k 位
            // 最高位公式 N % 10^k-1 + 1
            // 其余位个数 (k-1) * 10^k-2 * 1
            firstCountOne = number % tenPowerX + 1;
        } else {
            // 非 1
            // 最高位公式 10^k-1
            // 其余位个数 (k-1) * 10^k-2 * firstNum
            firstCountOne = tenPowerX;
        }
        otherCountOne = (len - 1) * tenPowerX(len - 2) * firstNum;
        // 总的 1 的数量
        result = firstCountOne + otherCountOne;
        // 需要递归的下一个数 例如  5472 则 next 为 472
        long nextNum = number % tenPowerX;
        return result + getOneNumber(nextNum);
    }


    /**
     *  @Description: 计算 1-number 间有多少个 1
     *  时间复杂度 O（N * lgN）
     *  @Param number
     *  @Return: long
     */
    public static long getOneNumberSimple(long number) {
        long result = 0;
        for (int i = 1; i <= number; i++) {
            result += countOne(i);
        }
        return result;
    }

    /**
     *  @Description: 10 的 x 次方
     *  @Param x
     *  @Return: long
     */
    private static long tenPowerX(int x) {
        if (x == 0) {
            return 1;
        }
        long num = 10;
        for (int i = 1; i < x; i++) {
            num = num * 10;
        }
        return num;
    }

    /**
     *  @Description: 获取 num 的长度
     *  @Param num
     *  @Return: int
     */
    private static int getNumberLength(long num) {
        int len = 0;
        while (num > 0) {
            num = num / 10;
            len++;
        }
        return len;
    }

    /**
     * @Description: 获取最高位
     * @Param number
     * @Return: int
     */
    private static int getFirstNum(long num) {
        while (num >= 10) {
            num = num / 10;
        }
        return Math.toIntExact(num);
    }



    /**
     *  @Description: 计算 num 包含 1 的个数
     *  @Param num
     *  @Return: long
     */
    private static long countOne(int num) {
        long count = 0;
        while (num > 0) {
            if (num % 10 == 1) {
                count++;
            }
            num = num / 10;
        }
        return count;
    }

}

