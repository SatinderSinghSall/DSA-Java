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

Here is a **professional, academic-quality `README.md`** tailored to everything you’ve studied (based on all your code + screenshots + topics). It is structured exactly like a strong GitHub project submission for DSA.

---

# 📘 Heap Data Structures & Sliding Window Algorithms (Java)

## 📌 Overview

This repository contains implementations and problem-solving approaches related to:

- Heap Data Structure (Min Heap & Max Heap)
- Priority Queue (Java Collection Framework)
- Heap Sort Algorithm
- Greedy + Heap Problems
- Sliding Window Technique (Deque Optimization)

All implementations are written in **Java** and follow clean, modular, and well-commented coding practices.

---

## 📚 Topics Covered

1. Heap Implementation (Custom)
2. Priority Queue (JCF)
3. Priority Queue with Objects
4. Heap Sort Algorithm
5. Connect N Ropes (Greedy + Min Heap)
6. Nearest K Cars (Max Heap)
7. Weakest Soldier (Min Heap + Comparator)
8. Sliding Window Maximum (Deque)

---

# 🧠 1. Heap Data Structure (Custom Implementation)

📄 Source:

## 📌 Problem

Implement a **Min Heap** from scratch using an ArrayList.

## 💡 Algorithm

- Insert → Add at end → Bubble up
- Delete → Swap root with last → Remove → Heapify down

## 🧾 Pseudocode

```
ADD(x):
    insert at end
    while child < parent:
        swap

REMOVE():
    swap root with last
    remove last
    heapify(0)

HEAPIFY(i):
    find smallest among root, left, right
    if smallest != root:
        swap and recurse
```

## ⏱ Complexity

- Insert: O(log n)
- Remove: O(log n)
- Peek: O(1)

---

# ⚙️ 2. Priority Queue (Java JCF)

📄 Source:

## 📌 Concept

Java provides built-in **PriorityQueue**:

- Default → Min Heap
- Custom → Max Heap using Comparator

## 💡 Example

```java
PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
```

## ⏱ Complexity

- Insert: O(log n)
- Remove: O(log n)

---

# 🧑‍🎓 3. Priority Queue with Objects

📄 Source:

## 📌 Problem

Store custom objects in heap.

## 💡 Approach

- Implement `Comparable`
- Define `compareTo()`

## 🧾 Pseudocode

```
class Student implements Comparable:
    compareTo(other):
        return this.rank - other.rank
```

---

# 🔄 4. Heap Sort Algorithm

📄 Source:

## 📌 Problem

Sort an array using Heap.

## 💡 Algorithm

1. Build Max Heap
2. Swap root with last
3. Reduce heap size
4. Heapify again

## 🧾 Pseudocode

```
HEAP_SORT(arr):
    build max heap
    for i from n-1 to 1:
        swap(arr[0], arr[i])
        heapify(0)
```

## ⏱ Complexity

- Time: O(n log n)
- Space: O(1)

---

# 🪢 5. Connect N Ropes (Greedy + Min Heap)

📄 Source:

## 📌 Problem

Connect ropes with minimum cost.

## 💡 Algorithm

- Always connect **2 smallest ropes**
- Add cost and push back

## 🧾 Pseudocode

```
insert all ropes into minHeap

while size > 1:
    a = extract min
    b = extract min
    cost += a + b
    insert (a + b)
```

## ⏱ Complexity

- O(n log n)

---

# 🚗 6. Nearest K Cars (Max Heap)

📄 Source:

## 📌 Problem

Find K closest points to origin.

## 💡 Algorithm

- Use Max Heap of size K
- Remove farthest when size exceeds K

## 🧾 Pseudocode

```
for each point:
    compute distance
    add to maxHeap
    if size > k:
        remove max
```

## ⏱ Complexity

- O(n log k)

---

# 🪖 7. Weakest Soldier

📄 Source:

## 📌 Problem

Find K weakest rows in matrix.

## 💡 Algorithm

- Count soldiers (1s)
- Store (count, index) in Min Heap

## 🧾 Pseudocode

```
for each row:
    count soldiers
    push (count, index)

repeat k times:
    pop min → answer
```

## ⏱ Complexity

- O(n log n)

---

# 📈 8. Sliding Window Maximum (Deque)

📄 Source:

## 📌 Problem

Find max of all subarrays of size K.

## 💡 Optimal Algorithm (Deque)

- Maintain decreasing order
- Remove:
  - smaller elements (back)
  - out-of-window elements (front)

## 🧾 Pseudocode

```
for j in array:
    remove smaller elements from back
    add current index

    remove elements out of window

    if window formed:
        result = front element
```

## ⏱ Complexity

- Time: O(n)
- Space: O(k)

---

# 🧪 Sample Output

```
Heap: 1 3 4 5
Heap Sort: 1 2 3 4 5
Connect Ropes: 29
Nearest Cars: (3,3), (-2,4)
Weakest Rows: 0 2
Sliding Window: 3 4 5 6 7 8 9 10
```

---

# 🏗 Project Structure

```
📁 DSA-Heaps
 ┣ 📄 Heap_DataStructure.java
 ┣ 📄 PriorityQueue_JCF.java
 ┣ 📄 PriorityQueue_Objects.java
 ┣ 📄 HeapSortAlgorithm.java
 ┣ 📄 ConnectNRopes.java
 ┣ 📄 NearestKCars.java
 ┣ 📄 WeakestSoldier.java
 ┣ 📄 SlidingWindowMaximum.java
 ┗ 📄 Main.java
```

---

# 🎯 Key Learnings

- Difference between **Min Heap & Max Heap**
- Real-world use of **Greedy + Heap**
- Efficient problem solving using **PriorityQueue**
- Optimization from **O(n log k) → O(n)** using Deque
- Writing **clean comparator logic for objects**

---

# 🚀 Conclusion

This module builds a strong foundation in:

- Heap-based problem solving
- Efficient data structure usage
- Interview-level problem patterns

---

Got it — I’ll upgrade your README into a **fully polished, GitHub-ready, professional + academic document** with:

✅ Clean formatting
✅ Badges
✅ Theory + intuition
✅ Diagrams (visual explanation)
✅ Interview notes
✅ Best practices

---

# 🚀 **FINAL PROFESSIONAL README.md**

---

# 🧠 Heap Data Structures & Sliding Window Algorithms (Java)

![Java](https://img.shields.io/badge/Language-Java-orange)
![DSA](https://img.shields.io/badge/Topic-Data%20Structures%20%26%20Algorithms-blue)
![Status](https://img.shields.io/badge/Progress-Completed-brightgreen)
![Level](https://img.shields.io/badge/Difficulty-Intermediate-yellow)

---

## 📌 Overview

This repository contains a comprehensive implementation of **Heap-based data structures and advanced problem-solving techniques**, along with the **Sliding Window Maximum problem using Deque**.

It is part of a structured DSA learning path and covers both:

- **Fundamentals**
- **Interview-level problems**

---

## 🧭 Learning Roadmap Covered

```
Heaps → Priority Queue → Heap Sort → Greedy + Heap → Object Heaps
      → Real Problems → Sliding Window Optimization
```

---

# 📚 Table of Contents

1. Heap Data Structure (Custom)
2. Priority Queue (JCF)
3. Priority Queue with Objects
4. Heap Sort
5. Connect N Ropes
6. Nearest K Cars
7. Weakest Soldier
8. Sliding Window Maximum
9. Interview Questions
10. Key Notes & Observations

---

# 🌳 1. Heap Data Structure (Custom Implementation)

📄 Source:

## 📖 Theory

A **Heap** is a complete binary tree that satisfies:

- **Min Heap** → Parent ≤ Children
- **Max Heap** → Parent ≥ Children

### 📊 Heap Structure

![Image](https://content.codecademy.com/practice/art-for-practice/new-pngs/heaps-representation.png)

![Image](https://www.cse.hut.fi/en/research/SVG/TRAKLA2/tutorials/heap_tutorial/KekoTRAKLA-89_1.gif)

![Image](https://miro.medium.com/v2/resize%3Afit%3A1400/1%2AEU964HO0LZyypp7_MLkY8A.jpeg)

---

## ⚙️ Operations

| Operation | Time Complexity |
| --------- | --------------- |
| Insert    | O(log n)        |
| Delete    | O(log n)        |
| Peek      | O(1)            |

---

## 🧠 Algorithm Explanation

### ➤ Insert (Bubble Up)

- Insert at last
- Swap with parent until heap property satisfied

### ➤ Delete (Heapify Down)

- Replace root with last element
- Heapify downward

---

## 🧾 Pseudocode

```
ADD(x):
    add x at end
    while x < parent:
        swap

REMOVE():
    swap root with last
    delete last
    heapify(0)
```

---

# ⚙️ 2. Priority Queue (Java JCF)

📄 Source:

## 📖 Theory

Java provides built-in **PriorityQueue**:

- Default → Min Heap
- Custom → Max Heap using comparator

---

## 💡 Example

```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
```

---

# 🧑‍💻 3. Priority Queue with Objects

📄 Source:

## 📖 Theory

To store objects:

- Implement `Comparable`
- OR use `Comparator`

---

## 🧠 Key Insight

```
compareTo():
negative → higher priority
positive → lower priority
```

---

# 🔄 4. Heap Sort Algorithm

📄 Source:

## 📖 Theory

Heap Sort uses a **Max Heap** to sort elements.

---

## 📊 Visualization

![Image](https://he-s3.s3.amazonaws.com/media/uploads/e9d6f12.png)

![Image](https://www.btechsmartclass.com/data_structures/ds_images/Max%20Heap%20Del%203.png)

![Image](https://miro.medium.com/1%2A02r6G-ho8DPnfiaOIHA2OA.png)

---

## ⚙️ Steps

1. Build Max Heap
2. Swap root with last
3. Reduce size
4. Heapify

---

## ⏱ Complexity

| Case | Time       |
| ---- | ---------- |
| All  | O(n log n) |

---

# 🪢 5. Connect N Ropes (Greedy + Min Heap)

📄 Source:

## 📌 Problem

Connect ropes with **minimum cost**.

---

## 🧠 Intuition

👉 Always connect **smallest ropes first**

---

## 📊 Visualization

![Image](https://files.codingninjas.in/article_images/connect-n-ropes-7-1677496664.webp)

![Image](https://i.sstatic.net/1fEJE.png)

![Image](https://files.codingninjas.in/article_images/connect-n-ropes-with-minimum-cost-1-1635266127.webp)

---

## ⚙️ Algorithm

1. Insert all ropes in Min Heap
2. Pick 2 smallest
3. Add cost
4. Insert back

---

## ⏱ Complexity

- O(n log n)

---

# 🚗 6. Nearest K Cars (Max Heap)

📄 Source:

## 📌 Problem

Find **K closest points to origin**

---

## 🧠 Idea

👉 Keep only K closest using **Max Heap**

---

## ⚙️ Algorithm

- Store distance = x² + y²
- Maintain heap size = K

---

## ⏱ Complexity

- O(n log k)

---

# 🪖 7. Weakest Soldier

📄 Source:

## 📌 Problem

Find K weakest rows in matrix.

---

## 🧠 Logic

Weakness defined by:

1. Fewer soldiers
2. Smaller index

---

## ⚙️ Algorithm

- Count 1s
- Push (count, index)
- Extract k elements

---

## ⏱ Complexity

- O(n log n)

---

# 📈 8. Sliding Window Maximum (Deque)

📄 Source:

## 📌 Problem

Find max in every window of size K.

---

## 🧠 Optimal Idea (Deque)

👉 Maintain **decreasing order**

---

## 📊 Visualization

![Image](https://assets.algo.monster/sliding_window_maximum.png)

![Image](https://miro.medium.com/v2/resize%3Afit%3A936/1%2ADUW32Qg378JjfA-J8gRWhw.png)

![Image](https://www.preplaced.in/_next/image?q=75&url=https%3A%2F%2Ffirebasestorage.googleapis.com%2Fv0%2Fb%2Fpreplaced-upload-prod%2Fo%2Fimage%252Fmentor-blogs%252FScreenshot%25202024-01-11%2520at%25207.10.31%2520PM.png8og1Zmz5TY%3Falt%3Dmedia%26token%3D0a28c886-0a43-481f-9175-ef049c0cfcac&w=1920)

---

## ⚙️ Algorithm

1. Remove smaller elements from back
2. Remove out-of-window from front
3. Front = max

---

## ⏱ Complexity

| Approach | Time       |
| -------- | ---------- |
| Brute    | O(nk)      |
| Heap     | O(n log k) |
| Deque    | O(n) ✅    |

---

# 🧪 Sample Outputs

```
Heap: 1 3 4 5
Heap Sort: 1 2 3 4 5
Connect Ropes: 29
Nearest Cars: (3,3), (-2,4)
Weakest Rows: 0 2
Sliding Window: 3 4 5 6 7 8 9 10
```

---

# 📁 Project Structure

```
📦 DSA-Heaps
 ┣ 📄 Heap_DataStructure.java
 ┣ 📄 PriorityQueue_JCF.java
 ┣ 📄 PriorityQueue_Objects.java
 ┣ 📄 HeapSortAlgorithm.java
 ┣ 📄 ConnectNRopes.java
 ┣ 📄 NearestKCars.java
 ┣ 📄 WeakestSoldier.java
 ┣ 📄 SlidingWindowMaximum.java
 ┗ 📄 Main.java
```

---

# 🎯 Interview Questions

### 🔥 Must-Do

- Kth Largest Element
- Merge K Sorted Lists
- Top K Frequent Elements
- Median in Data Stream
- Task Scheduler

---

# 🧠 Key Notes

✔ Heap is used when:

- You need **min/max frequently**
- You process **top K elements**

✔ Sliding Window:

- Use **Deque when order matters**
- Use **Heap when dynamic max needed**

✔ Common Mistake:

- Using Heap instead of Deque → slower

---

# 🚀 Final Takeaways

- Mastered **Heap operations**
- Learned **real-world greedy applications**
- Understood **optimization patterns**
- Built **interview-ready solutions**

---

# 👨‍💻 Author

**Satinder Singh Sall**
Full-Stack Web/Mobile Engineer
DSA | Java | Problem Solving

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
