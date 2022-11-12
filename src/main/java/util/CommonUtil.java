package util;

import java.util.Arrays;

public class CommonUtil {

    public static int[] copyArr(int[] og){
        return Arrays.copyOf(og,og.length);
    }
}
