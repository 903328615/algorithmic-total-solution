package algorithmic.base;

import java.util.Arrays;

/**
 * @program: algorithmic-total-solution
 * @description: 大根堆的数组实现
 * @author: wangzibin
 * @create: 2022-11-15
 **/
public class BigHeap {

    private int[] data;

    private int heapSize;
    private int maxSize;


    public BigHeap(int size) {
        // 0 位置弃置不用
        data = new int[size + 1];
        heapSize = 1;
        maxSize = size + 1;
    }

    public void heapInsert(int num) {
        if (heapSize >= maxSize) {
            throw new IllegalStateException("堆已满");
        }
        int currentIndex = heapSize;
        data[heapSize++] = num;
        // 这是一个向上比对交换的过程
        int parentIndex = findParent(currentIndex);
        while (data[currentIndex] > data[parentIndex] && parentIndex != 0) {
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
            parentIndex = findParent(currentIndex);
        }

    }

    private int findLeftChild(int currentIndex) {
        return currentIndex << 1;
    }

    private int findRightChild(int currentIndex) {
        return currentIndex << 1 | 1;
    }

    private int findParent(int currentIndex) {
        return currentIndex >> 1;
    }

    private void swap(int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void main(String[] args) {
        BigHeap bigHeap = new BigHeap(20);
        bigHeap.heapInsert(1);
        bigHeap.heapInsert(2);
        bigHeap.heapInsert(3);
        bigHeap.heapInsert(4);
        bigHeap.heapInsert(5);
        bigHeap.heapInsert(6);
        System.out.println(Arrays.toString(bigHeap.data));
    }

}

