// Queue: Implementing a Queue using Java Collection Framework. (JCF)

import java.util.LinkedList;
import java.util.Queue;

public class QueueJCF {
    public static void main(String[] args) {
        System.out.println("Queue: Implementing a Queue using Java Collection Framework. (JCF)");

        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println(q.remove());
        q.add(4);

        System.out.println(q.remove());
        q.add(5);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
