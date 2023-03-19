public class Temp {
    public static int atMostNGivenDigitSet(String[] digits, int n) {
        if (digits == null || digits.length < 1) {
            return 0;
        }
        int[] digitsNum = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            digitsNum[i] = Integer.parseInt(digits[i]);
        }
        int maxWei = String.valueOf(n).length() - 1;
        // 对于数字 n 0 - wei 位数符合条件的
        // 1921
        //位 0 1 2 3
        return process(digitsNum, n, maxWei, false) + process(digitsNum, n, maxWei, true);
    }

    private static int process(int[] digits, int n, int wei, boolean eq) {
        int weiNum = getWie(n, wei);
        int result = 0;
        if (wei == 0) {
            for (int i = 0; i < digits.length; i++) {
                if (!eq && digits[i] < weiNum) {
                    result++;
                } else if (eq && digits[i] == weiNum) {
                    result++;
                }
            }
            return result;
        }

        // 0 - wei-1 有多少符合条件的值
        int pre = process(digits, n, wei - 1, eq);
        int low = 0;
        int eqNum = 0;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] < weiNum) {
                low++;
            } else if (eq && digits[i] == weiNum) {
                eqNum++;
            }
        }
        if (eq) {
            result = eqNum * pre;
        } else {
            int preEq = process(digits, n, wei - 1, true);
            // 两位的时候，已知 数组 <10 所以 digits.length 个数小于
            result = digits.length + digits.length * pre + low * preEq;
        }

        return result;
    }

    private static int getWie(int num, int wei) {

        String number = String.valueOf(num);
        if (wei >= number.length()) {
            System.out.println("fuck");
            return -1;
        }
        return Integer.parseInt(String.valueOf(number.charAt(wei)));
    }

    public static void main(String[] args) {
        System.out.println(atMostNGivenDigitSet(new String[]{"7"}, 8));
    }

}
