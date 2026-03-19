// Merge Sort on Linked List:

class Node4 {
    int data;
    Node next;

    Node4(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MergeSortLinkedList {

    // Function to find middle of linked list
    public static Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Merge two sorted linked lists
    public static Node merge(Node left, Node right) {
        Node dummy = new Node(-1);
        Node temp = dummy;

        while (left != null && right != null) {
            if (left.data <= right.data) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }

        // remaining elements
        if (left != null) temp.next = left;
        if (right != null) temp.next = right;

        return dummy.next;
    }

    // Merge Sort function
    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;

        // Step 1: Find mid
        Node mid = getMid(head);

        // Step 2: Split
        Node rightHead = mid.next;
        mid.next = null;

        // Step 3: Recursively sort both halves
        Node left = mergeSort(head);
        Node right = mergeSort(rightHead);

        // Step 4: Merge sorted halves
        return merge(left, right);
    }

    // Print Linked List
    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        System.out.println("Merge Sort on Linked List...");

        Node head = new Node(5);
        head.next = new Node(9);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(8);

        System.out.print("Original: ");
        print(head);

        head = mergeSort(head);

        System.out.print("Sorted: ");
        print(head);
    }
}
