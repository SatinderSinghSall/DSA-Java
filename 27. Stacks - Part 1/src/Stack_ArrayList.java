// Stack Data Structure: Using Array List

import java.util.ArrayList;

public class Stack_ArrayList {
    static class Stack {
       static ArrayList<Integer> list = new ArrayList<>();

       // Check is Empty Method:
        public static boolean isEmpty() {
            return list.size() == 0;
        }

        // Push Method:
        public static void Push(int data) {
            list.add(data);
        }

        // Pop Method:
        public static int Pop() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is Empty.");
            }

            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        // Peek Method:
        public static int Peek() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is Empty.");
            }

            int top = list.get(list.size() - 1);
            return top;
        }
    }

    public static void main(String[] args) {
        System.out.println("Stack Data Structure:");

        Stack stack = new Stack();

        stack.Push(1);
        stack.Push(2);
        stack.Push(3);

        while (!stack.isEmpty()) {
            System.out.println(stack.Peek());
            stack.Pop();
        }
    }
}
