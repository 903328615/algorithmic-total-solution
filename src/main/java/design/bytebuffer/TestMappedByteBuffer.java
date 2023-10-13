package design.bytebuffer;

import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2022-10-31
 **/
public class TestMappedByteBuffer {

    public static void main(String[] args) {

        byte[] arr = new byte[20];
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        System.out.println(byteBuffer.mark());
        byteBuffer.put("how are you".getBytes(StandardCharsets.UTF_8));
        byteBuffer.flip();
        System.out.println((char) byteBuffer.get());
        System.out.println(byteBuffer.hasArray());
       // System.out.println(Arrays.toString(byteBuffer.array()));
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.mark());
        System.out.println(byteBuffer.position());
        byteBuffer.remaining();
        byteBuffer.hasRemaining();
    }

}

