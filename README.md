# ☕ Java Programming and Data Structures & Algorithms

Welcome to the **Java Programming, Data Structures, and Algorithms** repository!

This repository is a **complete guide** for learning **Java programming**, understanding **core data structures**, and mastering **essential algorithms** — all in one place.
It’s designed for **students**, **beginners**, and **professionals** revisiting fundamental computer science concepts.

---

## 🚀 Features

- ✅ Step-by-step Java examples
- 🧩 Data Structures implemented from scratch
- ⚙️ Core and advanced Algorithms
- 💡 Clear explanations and code comments
- 🧪 Example inputs/outputs for clarity
- 🏗️ Well-organized modular project structure
- ⚡ Beginner-friendly and ready to run

---

## 🧰 Tech Stack

| Component       | Description                               |
| --------------- | ----------------------------------------- |
| **Language**    | Java (JDK 17 or later)                    |
| **Compiler**    | `javac` (Java Compiler)                   |
| **IDE Support** | IntelliJ IDEA, VS Code, Eclipse, NetBeans |
| **Build Tools** | `Maven` / `Gradle` (optional)             |

---

## 📂 Repository Structure

```
Java-Programming-DataStructures-Algorithms/
├── README.md
├── 01_Basics/
│   ├── HelloWorld.java
│   ├── Operators.java
│   ├── ControlStatements.java
│   ├── Loops.java
│   ├── ArraysIntro.java
│   └── InputOutput.java
│
├── 02_ObjectOrientedProgramming/
│   ├── ClassesObjects.java
│   ├── InheritanceDemo.java
│   ├── Polymorphism.java
│   ├── Encapsulation.java
│   └── Abstraction.java
│
├── 03_Data_Structures/
│   ├── Arrays/
│   │   ├── LinearSearch.java
│   │   └── BinarySearch.java
│   ├── LinkedLists/
│   │   ├── SinglyLinkedList.java
│   │   ├── DoublyLinkedList.java
│   │   └── CircularLinkedList.java
│   ├── Stacks/
│   │   ├── StackUsingArray.java
│   │   └── StackUsingLinkedList.java
│   ├── Queues/
│   │   ├── QueueUsingArray.java
│   │   └── QueueUsingLinkedList.java
│   ├── Trees/
│   │   ├── BinaryTree.java
│   │   ├── BinarySearchTree.java
│   │   └── TreeTraversal.java
│   ├── Graphs/
│   │   ├── GraphAdjacencyList.java
│   │   └── GraphAdjacencyMatrix.java
│   ├── Hashing/
│   │   ├── HashMapDemo.java
│   │   └── HashSetDemo.java
│   └── Heaps/
│       ├── MinHeap.java
│       └── MaxHeap.java
│
├── 04_Algorithms/
│   ├── Searching/
│   │   ├── LinearSearch.java
│   │   └── BinarySearch.java
│   ├── Sorting/
│   │   ├── BubbleSort.java
│   │   ├── SelectionSort.java
│   │   ├── InsertionSort.java
│   │   ├── MergeSort.java
│   │   └── QuickSort.java
│   ├── Recursion/
│   │   ├── Factorial.java
│   │   ├── Fibonacci.java
│   │   └── TowerOfHanoi.java
│   ├── DivideAndConquer/
│   │   └── BinarySearchRecursive.java
│   ├── Greedy/
│   │   ├── ActivitySelection.java
│   │   └── FractionalKnapsack.java
│   ├── DynamicProgramming/
│   │   ├── FibonacciDP.java
│   │   ├── LongestCommonSubsequence.java
│   │   ├── Knapsack01.java
│   │   └── CoinChange.java
│   ├── GraphAlgorithms/
│   │   ├── BFS.java
│   │   ├── DFS.java
│   │   ├── Dijkstra.java
│   │   ├── Kruskal.java
│   │   ├── Prim.java
│   │   └── TopologicalSort.java
│   └── Backtracking/
│       ├── NQueens.java
│       └── SudokuSolver.java
│
└── 05_Extras/
    ├── FileHandling.java
    ├── ExceptionHandling.java
    ├── LambdaExpressions.java
    └── CollectionsFrameworkDemo.java
```

---

## 📘 Topics Covered

### 🔹 Java Fundamentals

- Variables, Data Types, Operators
- Control Statements (`if`, `switch`, `loops`)
- Methods and Recursion
- Arrays and Strings
- Input/Output and Exception Handling

### 🔹 Object-Oriented Programming (OOP)

- Classes and Objects
- Constructors, `this` & `super` keywords
- Inheritance, Polymorphism, Encapsulation, Abstraction
- Interfaces and Abstract Classes
- Packages and Access Modifiers

### 🔹 Data Structures

- Arrays & Strings
- Linked Lists (Singly, Doubly, Circular)
- Stacks and Queues
- Trees (Binary Tree, BST, Traversals)
- Heaps (Min/Max)
- Graphs (Adjacency List / Matrix, BFS, DFS)
- Hash Maps, Sets, and Priority Queues

### 🔹 Algorithms

#### 🧠 Searching Algorithms

- Linear Search
- Binary Search (Iterative & Recursive)

#### 🌀 Sorting Algorithms

- Bubble Sort
- Selection Sort
- Insertion Sort
- Merge Sort
- Quick Sort
- Heap Sort
- Counting Sort
- Radix Sort

#### 🔁 Recursion & Backtracking

- Factorial, Fibonacci
- Tower of Hanoi
- N-Queens Problem
- Sudoku Solver

#### 🔗 Divide and Conquer

- Binary Search
- Merge Sort
- Quick Sort

#### 💰 Greedy Algorithms

- Activity Selection
- Fractional Knapsack
- Huffman Coding
- Job Sequencing

#### ⚙️ Dynamic Programming

- Fibonacci (DP Approach)
- Longest Common Subsequence (LCS)
- 0/1 Knapsack
- Coin Change Problem
- Matrix Chain Multiplication
- Longest Increasing Subsequence

#### 🌐 Graph Algorithms

- Breadth First Search (BFS)
- Depth First Search (DFS)
- Dijkstra’s Algorithm
- Kruskal’s Minimum Spanning Tree
- Prim’s Algorithm
- Topological Sorting
- Bellman-Ford Algorithm
- Floyd-Warshall Algorithm

---

## ⚡ Quick Start

```bash
# Clone the repository
git clone https://github.com/SatinderSinghSall/Java-Programming-DataStructures-Algorithms.git

# Navigate to the project folder
cd Java-Programming-DataStructures-Algorithms

# Compile and run an example
javac 03_Data_Structures/LinkedLists/SinglyLinkedList.java
java 03_Data_Structures.LinkedLists.SinglyLinkedList
```

---

## 🧪 Example Program

**`SinglyLinkedList.java`**

```java
public class SinglyLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);

        printList(head);
    }
}
```

**Output:**

```
10 -> 20 -> 30 -> NULL
```

---

## 🧑‍💻 Author

**Satinder Singh Sall**
💼 Full-Stack Developer | Programmer | Code Enthusiast
🔗 [Portfolio](https://satinder-portfolio.vercel.app/)
🔗 [GitHub](https://github.com/SatinderSinghSall)
📧 [satindersinghsall111@gmail.com](mailto:satindersinghsall111@gmail.com)

---

## ⭐ Contributing

Contributions are always welcome!
To contribute:

1. Fork the repository 🍴
2. Create a new branch (`feature/your-feature`)
3. Commit your changes
4. Submit a Pull Request 🚀

---

> 💡 _"First, solve the problem. Then, write the code."_ — John Johnson

---
