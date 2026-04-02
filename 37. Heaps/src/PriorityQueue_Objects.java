// Heaps / Priority Queue: Priority Queue for Objects.

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueue_Objects {
    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {
        System.out.println("Heaps / Priority Queue: Priority Queue for Objects.");

        PriorityQueue<Student> pq = new PriorityQueue<>();

        pq.add(new Student("A", 4)); // Time Complexity: O(logn)
        pq.add(new Student("B", 5));
        pq.add(new Student("C", 2));
        pq.add(new Student("d", 12));

        while (!pq.isEmpty()) {
            System.out.print(pq.peek().name + "-" + pq.peek().rank + " "); // Time Complexity: O(1)
            pq.remove(); // Time Complexity: O(logn)
        }
    }
}
