package jdk17;

import java.util.Arrays;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-08-10
 **/
public class RandomTest {

    public static void main(String[] args) {
        RandomGenerator randomGenerator = RandomGeneratorFactory.getDefault().create();
        System.out.println(randomGenerator.nextInt(200));
        String na = "na";
    }
}

