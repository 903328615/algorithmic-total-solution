package util;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-02-01
 **/
public class UnsafeTestUtil {

    private static Unsafe unsafe;

    private static UnsafeTestUtil unsafeTestUtil = new UnsafeTestUtil();
    private static final long stateOffset;
    private static long state = 0;
    static {
        try {
            Field unsafeFile = Unsafe.class.getDeclaredField("theUnsafe");
            unsafeFile.setAccessible(true);
            //因为是静态属性
            unsafe = (Unsafe) unsafeFile.get(null);
        }catch (Exception e){
            throw new Error();
        }
        try {
            stateOffset = unsafe.objectFieldOffset(UnsafeTestUtil.class.getDeclaredField("state"));
        }catch (Exception e){
            throw new Error();
        }

    }

    public static boolean compareAndSwapState(int old, int now){
        return unsafe.compareAndSwapInt(unsafeTestUtil,stateOffset,old,now);
    }

    public static void main(String[] args) {
        System.out.println(compareAndSwapState(0,1));
        System.out.println(compareAndSwapState(1,2));
        System.out.println(compareAndSwapState(1,2));
        System.out.println(compareAndSwapState(2,4));
        System.out.println(compareAndSwapState(2,1));
    }

}

