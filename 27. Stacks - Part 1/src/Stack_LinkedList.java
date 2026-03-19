// Stack Data Structure: Using Linked List

public class Stack_LinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        static Node head = null;

        public static boolean isEmpty()  {
            return head == null;
        }

        // Push Method:
        public static void push(int data) {
            Node newNode = new Node(data);

            if (isEmpty()) {
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;

            return;
        }

        // Pop Method:
        public static int pop() {
            if (isEmpty()) {
                return -1;
            }

            int top = head.data;
            head = head.next;
            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                return -1;
            }

            return head.data;
        }
    }

    public static void main(String[] args) {
        System.out.println("Stack Data Structure: Using Linked List.");

        Stack_ArrayList.Stack stack = new Stack_ArrayList.Stack();

        stack.Push(1);
        stack.Push(2);
        stack.Push(3);

        while (!stack.isEmpty()) {
            System.out.println(stack.Peek());
            stack.Pop();
        }
    }
}
