// Queue: Deque (Double Ended Queue) Basics.

import java.util.*;

public class DequeExample {
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();

        dq.addFirst(1);
        dq.addLast(2);
        dq.addFirst(0);

        System.out.println(dq); // [0,1,2]

        dq.removeFirst();
        dq.removeLast();

        System.out.println(dq); // [1]
    }
}
