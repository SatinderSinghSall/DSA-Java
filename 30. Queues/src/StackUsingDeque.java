// Queue: Implement Stack using Deque.

import java.util.*;

public class StackUsingDeque {
    static class Stack {
        Deque<Integer> dq = new LinkedList<>();

        void push(int x) {
            dq.addLast(x);
        }

        int pop() {
            return dq.removeLast();
        }

        int peek() {
            return dq.peekLast();
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);

        System.out.println(s.pop()); // 20
    }
}
