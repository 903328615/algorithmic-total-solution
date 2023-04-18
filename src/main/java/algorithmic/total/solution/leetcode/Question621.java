package algorithmic.total.solution.leetcode;

import java.util.*;

/**
 * @program: algorithmic-total-solution
 * @description: 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，
 * 并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 * <p>
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * <p>
 * 你需要计算完成所有任务所需要的 最短时间 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：tasks = ["A","A","A","B","B","B"], n = 2
 * 输出：8
 * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
 * 在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
 * @author: wangzibin
 * @create: 2023-04-13
 **/
public class Question621 {

    public static void main(String[] args) {
        char[] tasks = new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        System.out.println(leastInterval(tasks, 2));
    }

    public int leastIntervalPlus(char[] tasks, int n) {
        if (tasks == null || tasks.length < 1) {
            return 0;
        }
        if (n == 0) {
            return tasks.length;
        }

        int[] taskCount = new int[26];
        for (char task : tasks) {
            taskCount[task - 'A']++;
        }

        Arrays.sort(taskCount);

        int maxVal = taskCount[25] - 1;
        int idleSlots = maxVal * n;

        for (int i = 24; i >= 0 && taskCount[i] > 0; i--) {
            idleSlots -= Math.min(taskCount[i], maxVal);
        }

        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }


    public static int leastInterval2(char[] tasks, int n) {
        if (tasks == null || tasks.length < 1) {
            return 0;
        }
        if (n == 0) {
            return tasks.length;
        }

        Map<Character, Integer> taskCount = new HashMap<>();
        for (char taskType : tasks) {
            taskCount.put(taskType, taskCount.getOrDefault(taskType, 0) + 1);
        }

        PriorityQueue<Integer> taskPriorityQueue = new PriorityQueue<>((a, b) -> b - a);
        taskPriorityQueue.addAll(taskCount.values());

        int time = 0;
        while (!taskPriorityQueue.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (!taskPriorityQueue.isEmpty()) {
                    tempList.add(taskPriorityQueue.poll());
                }
            }
            for (int count : tempList) {
                if (--count > 0) {
                    taskPriorityQueue.add(count);
                }
            }

            time += taskPriorityQueue.isEmpty() ? tempList.size() : n + 1;
        }

        return time;
    }


    public static int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length < 1) {
            return 0;
        }
        if (n == 0) {
            return tasks.length;
        }
        // 首先构建一个 任务种类的优先级队列，该种类中
        // 可执行的时间，越短的越靠前，其次 可执行的任务越多的越优先 （贪心）
        Map<Character, Task> initTask = new HashMap<>();
        for (char mask : tasks) {
            Task task = initTask.getOrDefault(mask, new Task());
            task.mask = mask;
            task.num++;
            initTask.put(mask, task);
        }
        TaskPriorityQueue taskPriorityQueue = new TaskPriorityQueue(initTask.size());
        for (Map.Entry<Character, Task> entry : initTask.entrySet()) {
            taskPriorityQueue.insert(entry.getValue());
        }
        int time = 0;
        while (taskPriorityQueue.getOneTask(n) != -1) {
            time++;
        }
        return time;
    }

    public static class Task {
        public Character mask;
        public int num;
        public int canDoTime;

        @Override
        public String toString() {
            return "Task{" +
                    "mask=" + mask +
                    ", num=" + num +
                    ", canDoTime=" + canDoTime +
                    '}';
        }
    }

    public static class TaskPriorityQueue {

        private Task[] queue;
        private Map<Character, Integer> map;
        private List<Character> haveCanDoTime;
        private int heapSize;
        private int size;

        public TaskPriorityQueue(int size) {
            queue = new Task[size + 1];
            map = new HashMap<>();
            heapSize = 0;
            this.size = size;
            haveCanDoTime = new ArrayList<>();
        }

        public void insert(Task task) {
            if (heapSize >= size) {
                throw new IllegalStateException("堆已满");
            }
            int currentIndex = ++heapSize;
            queue[currentIndex] = task;
            map.put(task.mask, currentIndex);
            upBalance(currentIndex);
        }

        public int getOneTask(int n) {
            if (isEmpty()) {
                return -1;
            }
            Task result = queue[1];
            boolean canTake = result.canDoTime == 0;
            if (canTake) {
                result.num--;
                // 更新需要等待时间
                result.canDoTime = n;
                System.out.println("do " + result);
            } else {
                System.out.println("wait");
            }
            if (result.num == 0) {
                swap(1, heapSize--);
                map.remove(result.mask);
                downBalance(1);
            } else {
                if (canTake) {
                    result.canDoTime++;
                    haveCanDoTime.add(result.mask);
                    downBalance(1);
                }
            }
            if (!haveCanDoTime.isEmpty()) {
                Iterator<Character> iterator = haveCanDoTime.iterator();
                // 拿出一个则进行时间调整
                while (iterator.hasNext()) {
                    Character next = iterator.next();
                    Integer index = map.get(next);
                    if (index == null) {
                        iterator.remove();
                        continue;
                    }
                    queue[index].canDoTime--;
                    if (queue[index].canDoTime == 0) {
                        iterator.remove();
                    }
                    downBalance(index);
                    upBalance(index);
                }
            }

            return 1;
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }


        private void downBalance(int currentIndex) {
            int leftChild = findLeftChild(currentIndex);
            while (leftChild <= heapSize) {
                int rightChild = findRightChild(currentIndex);
                int maxIndex = rightChild > heapSize ? leftChild : compareMax(leftChild, rightChild);
                if (maxIndex == compareMax(currentIndex, maxIndex)) {
                    swap(currentIndex, maxIndex);
                    currentIndex = maxIndex;
                    leftChild = findLeftChild(currentIndex);
                } else {
                    break;
                }
            }
        }

        private void upBalance(int currentIndex) {
            int parentIndex = findParent(currentIndex);
            while (parentIndex > 0) {
                if (currentIndex == compareMax(parentIndex, currentIndex)) {
                    swap(currentIndex, parentIndex);
                    currentIndex = parentIndex;
                    parentIndex = findParent(currentIndex);
                } else {
                    break;
                }
            }
        }

        private int compareMax(int index1, int index2) {
            return queue[index1].canDoTime < queue[index2].canDoTime ||
                    (queue[index1].canDoTime == queue[index2].canDoTime && queue[index1].num > queue[index2].num)
                    ? index1 : index2;
        }

        private void swap(int currentIndex, int parentIndex) {

            map.put(queue[currentIndex].mask, parentIndex);
            map.put(queue[parentIndex].mask, currentIndex);
            Task tmp = queue[currentIndex];
            queue[currentIndex] = queue[parentIndex];
            queue[parentIndex] = tmp;
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

    }

}


