# Data Structure and Algorithms: DSA - Java

# 🧠 Heap Data Structure in Java (From Scratch to Advanced)

![Java](https://img.shields.io/badge/Language-Java-orange)
![DSA](https://img.shields.io/badge/Topic-Data%20Structures%20%26%20Algorithms-blue)
![Level](https://img.shields.io/badge/Level-Beginner%20to%20Advanced-green)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

---

## 📚 Table of Contents

1. Introduction
2. Types of Heap
3. Properties of Heap
4. Array Representation
5. Basic Operations
6. Heap Implementation in Java
7. Heapify Process
8. Priority Queue (Java Built-in)
9. Complexity Analysis
10. Advanced Concepts
11. Problems with Solutions
12. Conclusion

---

## 📌 1. Introduction

A **Heap** is a specialized **tree-based data structure** that satisfies the _heap property_. It is widely used in:

- Priority Queues
- Scheduling Algorithms
- Graph Algorithms (Dijkstra, Prim)

📷 _Conceptual Diagram_

```
        10
      /    \
     20     30
    /  \   /  \
   40  50 60  70
```

---

## 🔺 2. Types of Heap

### 🔹 Min Heap

- Parent ≤ Children
- Root contains **minimum element**

```
       5
     /   \
    10   15
```

### 🔹 Max Heap

- Parent ≥ Children
- Root contains **maximum element**

```
       50
     /    \
    30     40
```

---

## ⚙️ 3. Properties of Heap

- ✅ Complete Binary Tree
- ✅ Heap Property maintained
- ✅ Height = **O(log n)**

---

## 📐 4. Array Representation

| Node        | Formula       |
| ----------- | ------------- |
| Left Child  | `2i + 1`      |
| Right Child | `2i + 2`      |
| Parent      | `(i - 1) / 2` |

📷 _Array Mapping_

```
Index: 0 1 2 3 4
Value: 5 10 15 20 25
```

---

## 🔧 5. Basic Operations

| Operation | Description                  |
| --------- | ---------------------------- |
| Insert    | Add element maintaining heap |
| Extract   | Remove root                  |
| Peek      | View root                    |
| Heapify   | Fix heap property            |

---

## 💻 6. Heap Implementation in Java

### 📌 Problem

Implement a Min Heap from scratch.

### 🧠 Algorithm

1. Insert element at end
2. Bubble up
3. Maintain heap property

### 🧾 Pseudocode

```
insert(key):
    add at end
    while parent > current:
        swap
```

### ✅ Java Code

```java
class MinHeap {
    int[] heap;
    int size;
    int capacity;

    MinHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    int parent(int i) { return (i - 1) / 2; }
    int left(int i) { return 2 * i + 1; }
    int right(int i) { return 2 * i + 2; }

    void insert(int key) {
        if (size == capacity) return;

        heap[size] = key;
        int i = size;
        size++;

        while (i != 0 && heap[parent(i)] > heap[i]) {
            int temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = parent(i);
        }
    }
}
```

---

## 🔁 7. Heapify Process

### 📌 Problem

Restore heap property after deletion.

### 🧠 Algorithm

- Compare node with children
- Swap with smallest/largest
- Recursively fix

### 🧾 Pseudocode

```
heapify(i):
    find smallest
    swap
    recurse
```

### ✅ Java Code

```java
void heapify(int i) {
    int smallest = i;
    int l = left(i);
    int r = right(i);

    if (l < size && heap[l] < heap[smallest]) smallest = l;
    if (r < size && heap[r] < heap[smallest]) smallest = r;

    if (smallest != i) {
        int temp = heap[i];
        heap[i] = heap[smallest];
        heap[smallest] = temp;
        heapify(smallest);
    }
}
```

---

## 📦 8. Priority Queue (Java Built-in)

### 📌 Problem

Use built-in heap structure.

### 🧠 Algorithm

Java uses **Min Heap by default**

### ✅ Code

```java
import java.util.*;

PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.add(10);
pq.add(5);
pq.add(20);

System.out.println(pq.poll());
```

---

## 📊 9. Complexity Analysis

| Operation | Time Complexity |
| --------- | --------------- |
| Insert    | O(log n)        |
| Delete    | O(log n)        |
| Peek      | O(1)            |

---

## 🚀 10. Advanced Concepts

- Heap Sort
- Kth Largest / Smallest
- Sliding Window Median
- Merge K Sorted Lists

---

## 🧩 11. Problems with Solutions

### 🔹 Problem 1: Kth Smallest Element

#### 📌 Problem

Find kth smallest element.

#### 🧠 Algorithm

Use Max Heap of size k.

#### 🧾 Pseudocode

```
for num:
    add
    if size > k:
        remove max
```

#### ✅ Code

```java
import java.util.*;

public class KthSmallest {
    public static int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }
}
```

---

### 🔹 Problem 2: Heap Sort

#### 📌 Problem

Sort using heap.

#### 🧠 Algorithm

1. Build Max Heap
2. Swap root
3. Heapify

#### 🧾 Pseudocode

```
build heap
swap root
heapify
```

#### ✅ Code

```java
class HeapSort {
    void sort(int arr[]) {
        int n = arr.length;

        for (int i = n/2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n-1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < n && arr[l] > arr[largest]) largest = l;
        if (r < n && arr[r] > arr[largest]) largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
}
```

---

## 🎯 12. Conclusion

Heaps are essential for **efficient priority handling**. Mastering them unlocks many high-level DSA problems.

---

## ⭐ Contribution

Feel free to fork, improve, and add more problems!

---

# 🧠 Heap Data Structure in Java (Academic + Professional README)

![Java](https://img.shields.io/badge/Language-Java-orange)
![DSA](https://img.shields.io/badge/Domain-Data%20Structures-blue)
![Level](https://img.shields.io/badge/Level-Beginner%20to%20Advanced-green)
![Status](https://img.shields.io/badge/Progress-Completed-success)

---

## 📌 Overview

This repository documents my complete learning of **Heap & Priority Queue** from the **Sigma 4.0 (DSA)** course. It covers theory, implementation, and problem-solving with a structured academic approach.

---

## 🎯 Topics Covered

### 🔹 Priority Queue

- Introduction to Priority Queues
- Implementation using Java Collection Framework (JCF)
- Priority Queue with custom objects

### 🔹 Heap Fundamentals

- Introduction to Heaps
- Complete Binary Tree (CBT)
- Min Heap vs Max Heap
- Array Representation of Heap

### 🔹 Heap Operations

- Insert in Heap
- Peek (Access root)
- Remove (Delete root)

### 🔹 Heap Applications

- Heap Sort
- Nearby Cars Problem
- Connect N Ropes (Greedy)
- Weakest Soldier
- Sliding Window Maximum

---

## 🧠 Theory Section

### What is a Heap?

A **Heap** is a **Complete Binary Tree** that satisfies the **Heap Property**.

- **Min Heap:** Parent ≤ Children
- **Max Heap:** Parent ≥ Children

### Why Heap?

- Efficient priority handling
- Used in Greedy & Graph algorithms
- Backbone of Priority Queue

---

## ⚙️ Array Representation

| Relation    | Formula       |
| ----------- | ------------- |
| Left Child  | `2i + 1`      |
| Right Child | `2i + 2`      |
| Parent      | `(i - 1) / 2` |

---

## 🔧 Core Operations

### 1. Insert in Heap

#### Algorithm

- Insert at last
- Perform **Up-Heapify (Bubble Up)**

#### Pseudocode

```
insert(x):
  add x at end
  while parent > x:
    swap
```

---

### 2. Peek Operation

#### Problem

Return minimum (or maximum) element

#### Complexity

O(1)

---

### 3. Remove Operation

#### Algorithm

- Replace root with last element
- Perform **Down-Heapify**

#### Pseudocode

```
remove():
  swap root with last
  delete last
  heapify(0)
```

---

## 💻 Java Implementation (From Scratch)

```java
class Heap {
    int[] arr;
    int size;

    Heap(int n) {
        arr = new int[n];
        size = 0;
    }

    void insert(int val) {
        arr[size] = val;
        int i = size;
        size++;

        while (i > 0 && arr[(i-1)/2] > arr[i]) {
            int temp = arr[i];
            arr[i] = arr[(i-1)/2];
            arr[(i-1)/2] = temp;
            i = (i-1)/2;
        }
    }

    int peek() {
        return arr[0];
    }
}
```

---

## 📦 Java Priority Queue (JCF)

```java
PriorityQueue<Integer> pq = new PriorityQueue<>(); // Min Heap
pq.add(5);
pq.add(1);
pq.add(10);

System.out.println(pq.peek());
```

---

## 🚀 Problem Solving Section

---

### 🔹 Problem 1: Nearby Cars

#### Problem

Find k closest points to origin.

#### Approach

- Use Min Heap based on distance

#### Code

```java
class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
```

---

### 🔹 Problem 2: Connect N Ropes

#### Problem

Minimize cost to connect ropes

#### Algorithm

- Use Min Heap
- Always pick two smallest

#### Code

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
```

---

### 🔹 Problem 3: Weakest Soldier

#### Problem

Find weakest rows in matrix

#### Approach

- Count soldiers
- Use Heap for sorting

---

### 🔹 Problem 4: Sliding Window Maximum

#### Problem

Find max in each window

#### Approach

- Use Max Heap

---

### 🔹 Problem 5: Heap Sort

#### Algorithm

1. Build Max Heap
2. Swap root with last
3. Heapify

#### Code

```java
void heapify(int arr[], int n, int i) {
    int largest = i;
    int l = 2*i + 1;
    int r = 2*i + 2;

    if (l < n && arr[l] > arr[largest]) largest = l;
    if (r < n && arr[r] > arr[largest]) largest = r;

    if (largest != i) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
        heapify(arr, n, largest);
    }
}
```

---

## 📊 Complexity Analysis

| Operation | Time     |
| --------- | -------- |
| Insert    | O(log n) |
| Delete    | O(log n) |
| Peek      | O(1)     |

---

## 🎓 Key Learnings

- Understanding of Complete Binary Trees
- Heap as optimized structure for priority problems
- Real-world problem solving using heaps
- Java PriorityQueue mastery

---

## 🏁 Conclusion

This module provided a strong foundation in **Heap & Priority Queue**, enabling efficient handling of optimization and greedy problems.

---

## ⭐ Acknowledgment

Course: **Sigma 4.0 DSA**
Satinder Singh Sall

---

# Heap Data Structure in Java (From Scratch to Advanced)

## Table of Contents

1. Introduction
2. Types of Heap
3. Properties of Heap
4. Array Representation
5. Basic Operations
6. Heap Implementation in Java (From Scratch)
7. Heapify Process
8. Priority Queue (Java Built-in)
9. Time & Space Complexity
10. Advanced Concepts
11. Problems with Solutions

---

## 1. Introduction

A Heap is a specialized tree-based data structure that satisfies the heap property. It is a complete binary tree, meaning all levels are fully filled except possibly the last level.

---

## 2. Types of Heap

### Min Heap

- Parent node is smaller than its children

### Max Heap

- Parent node is greater than its children

---

## 3. Properties of Heap

- Complete Binary Tree
- Heap Property (Min or Max)
- Efficient insertion and deletion

---

## 4. Array Representation

For index `i`:

- Left Child → `2i + 1`
- Right Child → `2i + 2`
- Parent → `(i - 1) / 2`

---

## 5. Basic Operations

- Insert
- Delete (Extract Min/Max)
- Peek
- Heapify

---

## 6. Heap Implementation in Java (From Scratch)

```java
class MinHeap {
    int[] heap;
    int size;
    int capacity;

    MinHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    int parent(int i) { return (i - 1) / 2; }
    int left(int i) { return 2 * i + 1; }
    int right(int i) { return 2 * i + 2; }

    void insert(int key) {
        if (size == capacity) return;
        heap[size] = key;
        int i = size;
        size++;

        while (i != 0 && heap[parent(i)] > heap[i]) {
            int temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = parent(i);
        }
    }

    int extractMin() {
        if (size <= 0) return Integer.MAX_VALUE;
        if (size == 1) return heap[--size];

        int root = heap[0];
        heap[0] = heap[--size];
        heapify(0);
        return root;
    }

    void heapify(int i) {
        int smallest = i;
        int l = left(i);
        int r = right(i);

        if (l < size && heap[l] < heap[smallest]) smallest = l;
        if (r < size && heap[r] < heap[smallest]) smallest = r;

        if (smallest != i) {
            int temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;
            heapify(smallest);
        }
    }
}
```

---

## 7. Heapify Process

Heapify is used to maintain heap property.

---

## 8. Priority Queue (Java Built-in)

```java
import java.util.PriorityQueue;

PriorityQueue<Integer> pq = new PriorityQueue<>(); // Min Heap
pq.add(10);
pq.add(5);
pq.add(20);

System.out.println(pq.poll());
```

---

## 9. Time & Space Complexity

| Operation | Time Complexity |
| --------- | --------------- |
| Insert    | O(log n)        |
| Delete    | O(log n)        |
| Peek      | O(1)            |

---

## 10. Advanced Concepts

- Heap Sort
- Kth Largest Element
- Merge K Sorted Arrays
- Median in Stream

---

## 11. Problems with Solutions

### Problem 1: Kth Smallest Element

#### Problem

Find the kth smallest element in an array.

#### Algorithm

Use a Max Heap of size k.

#### Pseudocode

```
for each element:
    add to heap
    if size > k:
        remove max
return top
```

#### Java Code

```java
import java.util.*;

public class KthSmallest {
    public static int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }
}
```

---

### Problem 2: Heap Sort

#### Problem

Sort an array using Heap.

#### Algorithm

1. Build Max Heap
2. Swap root with last
3. Heapify reduced heap

#### Pseudocode

```
build heap
for i = n-1 to 1:
    swap(0, i)
    heapify(0)
```

#### Java Code

```java
class HeapSort {
    void sort(int arr[]) {
        int n = arr.length;

        for (int i = n/2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n-1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < n && arr[l] > arr[largest]) largest = l;
        if (r < n && arr[r] > arr[largest]) largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
}
```

---

## Conclusion

Heaps are powerful for priority-based problems. Mastering them helps in solving many advanced DSA problems efficiently.
