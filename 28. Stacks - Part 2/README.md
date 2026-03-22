# 📚 Stack Data Structure in Java

### _Theory, Implementation, and Applications_

---

## 📌 Abstract

The **Stack** is a fundamental linear data structure that follows the **Last-In-First-Out (LIFO)** principle. It plays a crucial role in algorithm design, particularly in recursion, expression evaluation, and memory management.

This project presents a structured exploration of stacks through:

- Conceptual theory
- Custom implementations
- Classical algorithmic problems

The objective is to bridge theoretical understanding with practical coding proficiency.

---

## 🧠 1. Theoretical Foundations

### 🔹 Definition

A **Stack** is an abstract data type where insertion and deletion occur at a single end called the **top**.

### 🔹 Principle: LIFO

> The last element inserted is the first one to be removed.

---

## ⚙️ Core Operations

| Operation   | Description               |
| ----------- | ------------------------- |
| `push()`    | Insert element at the top |
| `pop()`     | Remove top element        |
| `peek()`    | View top element          |
| `isEmpty()` | Check if stack is empty   |

---

## 🏗️ 2. Stack Implementation Approaches

### 🔹 A. Array-Based Stack

Implemented using dynamic arrays (ArrayList).

**From your code:**

**Characteristics:**

- Dynamic resizing
- Easy implementation
- Amortized O(1) operations

---

### 🔹 B. Linked List-Based Stack

Implemented using nodes and pointers.

**From your code:**

**Characteristics:**

- No size limitation
- Efficient memory usage
- True O(1) push/pop

---

## 🧭 3. Learning Roadmap (Progression Model)

Your work follows a **well-structured academic roadmap**:

---

### 🟢 Level 1: Fundamentals

- Stack definition and operations
- Implementation using ArrayList and Linked List

✔ Covered in:

-
- ***

### 🟡 Level 2: Basic Applications

- Reverse string using stack
- Push element at bottom

✔ Covered in:

-
- ***

### 🟠 Level 3: Recursion + Stack

- Reverse stack using recursion

✔ Covered in:

- ***

### 🔵 Level 4: Monotonic Stack Algorithms

- Next Greater Element
- Stock Span Problem

✔ Covered in:

-
- ***

### 🔴 Level 5: Expression & Parentheses Problems

- Valid parentheses
- Duplicate parentheses detection

✔ Covered in:

-
- ***

### 🟣 Level 6: Advanced Applications

- Maximum Histogram Area

✔ Covered in:

- ***

## 🧩 4. Algorithmic Concepts Demonstrated

### 🔹 Recursion + Stack Simulation

- Reversing stack without extra data structures

### 🔹 Monotonic Stack

- Used in:
  - Next Greater Element
  - Stock Span
  - Histogram problems

### 🔹 Pattern Recognition

- Matching symbols (parentheses)
- Range queries using stacks

---

## ⏱️ 5. Complexity Analysis

| Category             | Time Complexity | Space Complexity |
| -------------------- | --------------- | ---------------- |
| Basic Stack Ops      | O(1)            | O(n)             |
| Reverse Stack        | O(n²)           | O(n)             |
| Next Greater Element | O(n)            | O(n)             |
| Stock Span           | O(n)            | O(n)             |
| Parentheses Problems | O(n)            | O(n)             |
| Histogram Area       | O(n)            | O(n)             |

---

## 💻 6. Codebase Overview

### 📂 Structure

```id="cb2yl8"
Stack_ArrayList.java       → Array-based stack
Stack_LinkedList.java      → Linked list stack
Bottom_Stack.java          → Insert at bottom
ReverseStack.java          → Reverse stack
ReverseString.java         → Reverse string
NextGreaterElement.java    → Monotonic stack problem
StockSpan.java             → Span calculation
ValidParentheses.java      → Balanced brackets
DuplicateParentheses.java  → Redundant brackets
MaxHistogramArea.java      → Advanced stack problem
Main.java                  → Test/demo file
```

---

## 🔍 7. Critical Evaluation of Implementation

### ✅ Strengths

- Covers **complete stack curriculum**
- Includes **interview-level problems**
- Demonstrates **algorithmic thinking**
- Uses **modular and readable code**

---

### ⚠️ Limitations

#### 1. Overuse of `static`

- Reduces flexibility
- Not suitable for scalable systems

#### 2. Minor Logical Issues

- Unsafe `peek()` usage in some cases
- LinkedList stack not used correctly in `main()`

#### 3. Naming Conventions

- Methods like `Push()` should follow Java standards → `push()`

---

## 🎓 8. Academic Significance

This project aligns with:

- **Core Data Structures curriculum**
- **Algorithm design principles**
- **Interview preparation standards**

It demonstrates:

- Abstract Data Type implementation
- Complexity-aware problem solving
- Transition from theory → application

---

## 🚀 9. Future Scope

To extend this work:

- Queue and Deque implementations
- Infix → Postfix conversion
- Expression evaluation
- Sliding window problems
- Advanced recursion patterns

---

## 🧾 Conclusion

This project successfully demonstrates:

- Theoretical understanding of stacks
- Practical implementation strategies
- Application of stacks in solving real-world algorithmic problems

It serves as a **strong academic and professional foundation in Data Structures and Algorithms**.

---

## 👤 Author

**Satinder Singh Sall**

---

# 📚 Stack Data Structure & Applications in Java

## 📌 Overview

This repository contains a comprehensive implementation of the **Stack data structure** in Java along with multiple classical problems that demonstrate its practical applications.

The project is designed to build a strong foundation in **Data Structures and Algorithms (DSA)**, progressing from basic stack operations to advanced problem-solving techniques commonly asked in technical interviews.

---

## 🎯 Objectives

- Understand the **LIFO (Last-In-First-Out)** principle
- Implement stacks using different approaches
- Solve real-world problems using stack-based logic
- Develop problem-solving skills using **efficient algorithms (O(n))**

---

## 🧱 Stack Implementations

### 1. Stack using ArrayList

- Dynamic resizing
- Implements core operations:
  - `push()`
  - `pop()`
  - `peek()`
  - `isEmpty()`

### 2. Stack using Linked List

- Efficient memory usage
- Constant time operations: **O(1)**
- Custom node-based implementation

---

## 🧠 Problems Implemented

### 🔹 Fundamental Stack Operations

- Push element at the bottom of a stack
- Reverse a stack using recursion
- Reverse a string using stack

### 🔹 Monotonic Stack Problems

- Next Greater Element (NGE)
- Stock Span Problem
- Maximum Area in Histogram

### 🔹 Parentheses-Based Problems

- Valid Parentheses Checker
- Duplicate Parentheses Detection

---

## ⚙️ Key Concepts Covered

- Stack operations and design
- Recursion with stack manipulation
- Monotonic stack technique
- Time complexity optimization
- Use of auxiliary data structures
- Problem decomposition strategies

---

## 🧮 Time Complexity Summary

| Problem               | Time Complexity | Space Complexity |
| --------------------- | --------------- | ---------------- |
| Stack Operations      | O(1)            | O(n)             |
| Reverse Stack         | O(n²)           | O(n)             |
| Reverse String        | O(n)            | O(n)             |
| Next Greater Element  | O(n)            | O(n)             |
| Stock Span            | O(n)            | O(n)             |
| Valid Parentheses     | O(n)            | O(n)             |
| Duplicate Parentheses | O(n)            | O(n)             |
| Max Histogram Area    | O(n)            | O(n)             |

---

## 📂 Project Structure

```
├── Stack_ArrayList.java
├── Stack_LinkedList.java
├── Bottom_Stack.java
├── ReverseStack.java
├── ReverseString.java
├── NextGreaterElement.java
├── StockSpan.java
├── ValidParentheses.java
├── DuplicateParentheses.java
├── MaxHistogramArea.java
└── Main.java
```

---

## 💡 Learning Outcomes

By completing this module, you will:

- Gain a strong understanding of stack-based algorithms
- Be able to solve **interview-level problems**
- Understand when and how to apply stacks efficiently
- Improve your logical and analytical thinking

---

## 🚀 How to Run

1. Clone the repository:

   ```bash
   git clone <repository-url>
   ```

2. Compile Java files:

   ```bash
   javac FileName.java
   ```

3. Run the program:

   ```bash
   java FileName
   ```

---

## 🛠️ Requirements

- Java JDK 8 or higher
- Any IDE (IntelliJ IDEA, Eclipse, VS Code) or terminal

---

## 📈 Future Improvements

- Add unit tests for each implementation
- Optimize recursive solutions
- Extend to advanced topics (Queues, Deques, Expression Evaluation)
- Improve error handling and edge case coverage

---

## 📖 References

- Standard Data Structures textbooks
- Online coding platforms (LeetCode, GeeksforGeeks)
- Academic lecture materials

---

## 👤 Author

**Satinder Singh Sall**

---

## 📜 License

This project is intended for **educational and academic purposes**.

---
