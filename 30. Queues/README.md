# 📚 Data Structures in Java: Queues, Deques & Advanced Applications

## 📚 Stack Data Structure in Java

### _Theory, Implementation, and Applications_

<p align="center">
  <img src="https://img.shields.io/badge/Language-Java-blue?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Topic-Data%20Structures-green?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Focus-Queue%20%26%20Deque-orange?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Level-Academic%20%2B%20Interview%20Ready-purple?style=for-the-badge" />
</p>

---

## 📖 Overview

This repository is a **comprehensive academic + practical exploration of Queue data structures in Java**, starting from **basic theory** to **advanced problem-solving and transformations**.

It includes:

- Multiple **implementations (Array, Linked List, JCF)**
- Advanced structures like **Circular Queue & Deque**
- **Stack ↔ Queue transformations**
- Real-world problem-solving patterns

---

# 🧠 1. QUEUE THEORY (Fundamentals → Advanced)

## 🔹 What is a Queue?

A **Queue** is a linear data structure that follows:

> **FIFO (First In First Out)**

- The element inserted first is removed first
- Similar to a **line/queue in real life**

---

## 🔹 Basic Operations

| Operation | Description               |
| --------- | ------------------------- |
| Enqueue   | Add element to rear       |
| Dequeue   | Remove element from front |
| Peek      | Get front element         |
| isEmpty   | Check if queue is empty   |

---

## 🔹 Types of Queues

### 1. Simple Queue

- Linear structure
- Inefficient in arrays due to shifting

---

### 2. Circular Queue

- Solves space wastage problem
- Uses **modulo arithmetic**

```
(rear + 1) % size
```

---

### 3. Deque (Double Ended Queue)

- Insert/delete from both ends
- Can behave as:
  - Queue
  - Stack

---

### 4. Priority Queue (Conceptual)

(Not implemented in this module)

- Elements processed based on priority

---

## 🔹 Internal Representation

### Array-based Queue

- Fixed size
- Needs shifting → O(n)

### Linked List Queue

- Dynamic size
- Efficient operations → O(1)

---

## 🔹 Advanced Concepts

### ✔ Circular Buffer

Efficient memory usage using wrap-around

### ✔ Amortized Complexity

Used in **Queue using 2 Stacks**

### ✔ Data Structure Conversion

- Stack → Queue
- Queue → Stack

---

# 💻 2. IMPLEMENTATIONS (WITH THEORY + CODE + COMPLEXITY)

---

## 🔹 2.1 Queue using Array

📄 Code:

### 🧠 Theory

- Uses a simple array
- Dequeue requires shifting elements

### ⚙️ Complexity

| Operation | Time                      |
| --------- | ------------------------- |
| Enqueue   | O(1)                      |
| Dequeue   | O(n) ❌ (due to shifting) |
| Peek      | O(1)                      |
| Space     | O(n)                      |

---

## 🔹 2.2 Circular Queue (Optimized Array)

📄 Code:

### 🧠 Theory

- Avoids shifting
- Uses front & rear pointers
- Wrap-around using modulo

### ⚙️ Complexity

| Operation | Time |
| --------- | ---- |
| Enqueue   | O(1) |
| Dequeue   | O(1) |
| Peek      | O(1) |
| Space     | O(n) |

---

## 🔹 2.3 Queue using Linked List

📄 Code:

### 🧠 Theory

- Uses nodes (head & tail)
- Dynamic memory allocation

### ⚙️ Complexity

| Operation | Time |
| --------- | ---- |
| Enqueue   | O(1) |
| Dequeue   | O(1) |
| Peek      | O(1) |
| Space     | O(n) |

---

## 🔹 2.4 Queue using Java Collection Framework

📄 Code:

### 🧠 Theory

- Uses `LinkedList` implementation of Queue
- Production-ready

### ⚙️ Complexity

| Operation | Time |
| --------- | ---- |
| Enqueue   | O(1) |
| Dequeue   | O(1) |
| Peek      | O(1) |

---

# 🔁 3. DEQUE (DOUBLE ENDED QUEUE)

## 🔹 Deque Basics

📄 Code:

## 🔹 Deque using JCF

📄 Code:

### 🧠 Theory

- Supports both ends
- Acts as both:
  - Queue
  - Stack

### ⚙️ Complexity

All operations:

- O(1)

---

# 🔄 4. QUEUE USING OTHER DATA STRUCTURES

---

## 🔹 4.1 Queue using 2 Stacks

📄 Code:

### 🧠 Theory

- Two stacks:
  - s1 → input
  - s2 → output

- Lazy transfer

### ⚙️ Complexity

| Operation | Time           |
| --------- | -------------- |
| Enqueue   | O(1)           |
| Dequeue   | Amortized O(1) |
| Peek      | Amortized O(1) |

---

## 🔹 4.2 Queue using Deque

📄 Code:

### 🧠 Theory

- Uses `addLast()` & `removeFirst()`

### ⚙️ Complexity

- All operations → O(1)

---

# 🔁 5. STACK USING QUEUE

---

## 🔹 5.1 Stack using 2 Queues

📄 Code:

### 🧠 Theory

- Push is costly (reordering elements)

### ⚙️ Complexity

| Operation | Time |
| --------- | ---- |
| Push      | O(n) |
| Pop       | O(1) |
| Peek      | O(1) |

---

## 🔹 5.2 Stack using Deque

📄 Code:

### 🧠 Theory

- Uses `addLast()` & `removeLast()`

### ⚙️ Complexity

- All operations → O(1)

---

# 🧩 6. PROBLEM-SOLVING (IMPORTANT FOR INTERVIEWS)

---

## 🔹 6.1 First Non-Repeating Character

📄 Code:

### 🧠 Theory

- Track frequency
- Maintain order using queue

### ⚙️ Complexity

- Time: O(n)
- Space: O(1) (fixed 26 array)

---

## 🔹 6.2 Interleave Queue

📄 Code:

### 🧠 Theory

- Split + merge alternately

### ⚙️ Complexity

- Time: O(n)
- Space: O(n)

---

## 🔹 6.3 Reverse Queue

📄 Code:

### 🧠 Theory

- Use stack as auxiliary

### ⚙️ Complexity

- Time: O(n)
- Space: O(n)

---

# 📊 7. COMPLETE COMPLEXITY SUMMARY

| Structure         | Enqueue | Dequeue        | Peek | Space |
| ----------------- | ------- | -------------- | ---- | ----- |
| Array Queue       | O(1)    | O(n)           | O(1) | O(n)  |
| Circular Queue    | O(1)    | O(1)           | O(1) | O(n)  |
| Linked List Queue | O(1)    | O(1)           | O(1) | O(n)  |
| JCF Queue         | O(1)    | O(1)           | O(1) | O(n)  |
| Queue via Stack   | O(1)    | Amortized O(1) | O(1) | O(n)  |
| Stack via Queue   | O(n)    | O(1)           | O(1) | O(n)  |
| Deque             | O(1)    | O(1)           | O(1) | O(n)  |

---

# 🚀 How to Run

```bash
javac FileName.java
java FileName
```

---

# 📌 Real-World Applications

- CPU Scheduling
- BFS (Graphs)
- Streaming systems
- Task queues (OS, servers)
- Message queues (Kafka, RabbitMQ concept)

---

# 🏆 Key Takeaways

✔ Circular Queue solves array inefficiency
✔ Deque is the most flexible structure
✔ Stack ↔ Queue conversion builds deep understanding
✔ JCF should be used in real-world applications

---

# 👨‍💻 Author

**Satinder Singh Sall**
Full-Stack Web/Mobile Engineer
📘 Data Structures (Java)
🎯 Academic + Interview Preparation

---

# 📄 License

This project is for **educational and portfolio purposes**

---

⭐ _If you found this useful, consider starring the repository!_
