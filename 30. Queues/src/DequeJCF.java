// Queue: Deque using Java Collection Framework. (JCF)

import java.util.*;

public class DequeJCF {
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();

        // Add elements
        dq.addFirst(10);
        dq.addLast(20);
        dq.addFirst(5);

        System.out.println("Deque: " + dq); // [5, 10, 20]

        // Access
        System.out.println("Front: " + dq.peekFirst()); // 5
        System.out.println("Rear: " + dq.peekLast());   // 20

        // Remove
        dq.removeFirst();
        dq.removeLast();

        System.out.println("After removal: " + dq); // [10]
    }
}
