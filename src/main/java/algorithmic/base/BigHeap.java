package algorithmic.base;

import util.CommonUtil;
import util.RandomUtil;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: algorithmic-total-solution
 * @description: 大根堆的数组实现
 * @author: wangzibin
 * @create: 2022-11-15
 **/
public class BigHeap {

    private int[] data;
    private int heapSize;
    private int size;


    public BigHeap(int size) {
        // 0 位置弃置不用
        data = new int[size + 1];
        heapSize = 0;
        this.size = size;
    }

    public BigHeap(int[] arr) {
        // 0 位置弃置不用
        int size = arr.length + 1;
        data = new int[size];
        heapSize = arr.length;
        this.size = size;
        for (int i = 0; i < arr.length; i++) {
            data[i + 1] = arr[i];
        }
        for (int i = heapSize; i >= 1; i--) {
            downBalance(i);
        }
    }


    public void sort() {
        while (!isEmpty()) {
            swap(1, heapSize);
            heapSize--;
            downBalance(1);
        }
    }

    public void heapInsert(int num) {
        if (heapSize >= size) {
            throw new IllegalStateException("堆已满");
        }
        int currentIndex = ++heapSize;
        data[currentIndex] = num;
        // 这是一个向上比对交换的过程
        upBalance(currentIndex);

    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("empty heap");
        }
        int result = data[1];
        swap(1, heapSize--);
        downBalance(1);
        return result;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }


    /**
     * @Description: 向上平衡
     * @Param currentIndex
     * @Return void
     */
    private void upBalance(int currentIndex) {
        int parentIndex = findParent(currentIndex);
        while (data[currentIndex] > data[parentIndex] && parentIndex != 0) {
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
            parentIndex = findParent(currentIndex);
        }
    }

    private void downBalance(int currentIndex) {
        int left = findLeftChild(currentIndex);
        // 如果左孩子已经越界，则不需要调整
        while (left <= heapSize) {
            int right = findRightChild(currentIndex);
            int maxIndex = left;
            if (right <= heapSize) {
                maxIndex = data[left] > data[right] ? left : right;
            }
            if (data[currentIndex] >= data[maxIndex]) {
                return;
            }
            swap(maxIndex, currentIndex);
            currentIndex = maxIndex;
            left = findLeftChild(currentIndex);
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
        for (int i = 0; i < 10000; i++) {
            int[] arr = RandomUtil.randomArr();
            int[] arr2 = CommonUtil.copyArr(arr);
            BigHeap bigHeap = new BigHeap(arr);
            bigHeap.sort();
            MargeSort.sort(arr2);
            for (int j = 0; j < arr.length; j++) {
                if (arr2[j] != bigHeap.data[j + 1]) {
                    System.out.println(Arrays.toString(arr2));
                    System.out.println(Arrays.toString(bigHeap.data));
                    System.out.println("error");
                    return;
                }
            }
        }
        System.out.println("success");

        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
    }

}

