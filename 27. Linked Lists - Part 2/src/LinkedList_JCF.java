// Linked List using Java Collection Framework: JCF

import java.util.LinkedList;

public class LinkedList_JCF {
    public static void main(String[] args) {
        // Create a Linked List:
        LinkedList<Integer> linkedList = new LinkedList<>();

        System.out.println(linkedList);

        // Add in a Linked List:
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addFirst(0);

        System.out.println(linkedList);

        // Remove from a Linked List:
        linkedList.removeFirst();

        System.out.println(linkedList);
    }
}
