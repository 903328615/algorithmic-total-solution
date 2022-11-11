package algorithmic.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class QueueByStack<T> {

    private Stack<T> addStack;

    private Stack<T> pollStack;

    public QueueByStack() {
        this.addStack = new Stack<>();
        this.pollStack = new Stack<>();
    }

    public void add(T t) {
        addStack.add(t);
    }

    public T poll() {
        addToPoll(); // 每次出队前保证 add 全到 pop
        return pollStack.pop();
    }

    public void addToPoll() {
        // 这里遵循 poll 不为空才用往里面倒数据
        if (addStack.empty() || !pollStack.isEmpty()) {
            return;
        }
        while (!addStack.isEmpty()) {
            pollStack.add(addStack.pop());
        }
    }


    @Override
    public String toString() {
        return "QueueByStack{" +
                "addStack=" + addStack +
                ", popStack=" + pollStack +
                '}';
    }

    public static void main(String[] args) {

        QueueByStack<Integer> queueByStack = new QueueByStack<>();
        Queue<Integer> queue = new LinkedList<>();
        Random random = new Random();
        for (int k = 0; k < 100; k++) {
            for (int i = 0; i < random.nextInt(2000); i+=random.nextInt(5)) {
                if (random.nextBoolean() || queue.isEmpty()) {
                    queue.add(i);
                    queueByStack.add(i);
                } else {
                    Integer poll = queue.poll();
                    Integer pop = queueByStack.poll();
                    //System.out.println("right:"+poll+" test:"+pop);
                    if (!poll.equals(pop)) {
                        System.out.println("error");
                        System.out.println(queue);
                        System.out.println(queueByStack);
                        return;
                    }
                }
            }
        }
        System.out.println("success");

    }

}
