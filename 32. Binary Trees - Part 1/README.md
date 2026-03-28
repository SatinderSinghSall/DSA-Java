# 🌳 Binary Trees in Java (DSA Module)

![Java](https://img.shields.io/badge/Language-Java-blue.svg)
![DSA](https://img.shields.io/badge/Topic-Data%20Structures%20%26%20Algorithms-green)
![Level](https://img.shields.io/badge/Level-Beginner%20to%20Intermediate-orange)
![Status](https://img.shields.io/badge/Status-Completed-success)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

# 📚 Data Structures & Algorithms: Greedy Algorithms (Java)

## 📚 Binary Tree Data Structure in Java

### _Theory, Implementation, and Applications_

## 📘 Overview

This repository contains implementations of fundamental **Binary Tree concepts** using Java, developed as part of the **Sigma 4.0 (DSA)** course.

It covers:

- Tree construction using preorder traversal
- Tree traversals (DFS & BFS)
- Structural properties (height, count, sum)
- Recursive problem-solving patterns

---

## 🧠 Concepts Covered

### 1. Binary Tree Basics

A **Binary Tree** is a hierarchical data structure where:

- Each node has **at most 2 children**
- Nodes are connected via **left** and **right** pointers

---

### 2. Tree Representation

```text
        1
      /   \
     2     3
    / \     \
   4   5     6
```

The tree is built using **preorder input with `-1` representing null nodes**.

Example:

```java
int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
```

---

## ⚙️ Implementation Details

### 🔹 Node Structure

All files follow a consistent node design:

```java
static class Node {
    int data;
    Node left;
    Node right;
}
```

---

### 🔹 Tree Construction (Preorder)

Implemented in:
👉

**Logic:**

- Read node
- If `-1` → return `null`
- Recursively build left and right

---

## 🌐 Tree Traversals

### 🔸 1. Preorder Traversal (Root → Left → Right)

👉

```java
print → left → right
```

---

### 🔸 2. Inorder Traversal (Left → Root → Right)

👉

```java
left → print → right
```

---

### 🔸 3. Postorder Traversal (Left → Right → Root)

👉

```java
left → right → print
```

---

### 🔸 4. Level Order Traversal (Breadth-First)

👉

- Uses **Queue (FIFO)**
- Prints nodes level by level
- Uses `null` as level separator

---

## 📊 Tree Properties

### 🔹 Height of Tree

👉

```java
height = max(left, right) + 1
```

- Measures longest path from root to leaf
- Time Complexity: **O(n)**

---

### 🔹 Count of Nodes

👉

```java
count = left + right + 1
```

- Total number of nodes in tree

---

### 🔹 Sum of Nodes

👉

```java
sum = left + right + root.data
```

- Adds all node values

---

## 🔁 Core Recursive Pattern

All major tree problems follow this structure:

```java
if (root == null) return base_value;

int left = recurse(root.left);
int right = recurse(root.right);

return combine(left, right, root);
```

| Problem      | Combine Logic              |
| ------------ | -------------------------- |
| Height       | `max(left, right) + 1`     |
| Count Nodes  | `left + right + 1`         |
| Sum of Nodes | `left + right + root.data` |

---

## 🧪 Execution

Each class contains its own `main()` method.

To run:

```bash
javac FileName.java
java FileName
```

Example:

```bash
javac PreOrderTraversal.java
java PreOrderTraversal
```

---

## 🛠️ Technologies Used

- Java (JDK 8+)
- IntelliJ IDEA / VS Code
- Standard Libraries (`Queue`, `LinkedList`)

---

## 📈 Learning Outcomes

After completing this module, you can:

- Build binary trees from traversal input
- Perform DFS & BFS traversals
- Apply recursion effectively
- Solve structural tree problems
- Understand tree depth and hierarchy

---

## 🚀 Future Scope

Next recommended topics:

- Diameter of Binary Tree (O(n) optimization)
- Balanced Binary Trees
- Binary Search Trees (BST)
- Lowest Common Ancestor (LCA)
- Tree Serialization

---

## 👨‍💻 Author

**Satinder Singh Sall**
DSA Learner | Java Developer

---

## 📌 Notes

- All implementations use **recursive approach**
- Input format is **preorder with null markers (-1)**
- Code is modular and beginner-friendly

---

Here’s a **fully upgraded, professional, GitHub-ready `README.md`** with badges, detailed explanations, theory, and code logic based on everything you studied (videos + all files):

---

# 🌳 Binary Trees in Java (DSA - Sigma 4.0)

![Java](https://img.shields.io/badge/Language-Java-blue.svg)
![DSA](https://img.shields.io/badge/Topic-Data%20Structures%20%26%20Algorithms-green)
![Level](https://img.shields.io/badge/Level-Beginner%20to%20Intermediate-orange)
![Status](https://img.shields.io/badge/Status-Completed-success)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

---

## 📌 Project Overview

This repository contains a complete implementation of **Binary Trees** in Java, developed as part of the **Sigma 4.0 DSA course**.

It includes:

- Tree construction using preorder
- All major traversals (DFS & BFS)
- Core tree properties (height, count, sum)
- Strong focus on **recursion-based problem solving**

---

## 🧠 What is a Binary Tree?

A **Binary Tree** is a hierarchical data structure where:

- Each node has **at most two children**
- Children are referred to as:
  - **Left Child**
  - **Right Child**

---

## 🌳 Tree Structure (From Your Input)

```text
        1
      /   \
     2     3
    / \     \
   4   5     6
```

### 📥 Input Representation

```java
int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
```

👉 `-1` represents **NULL nodes**

---

# ⚙️ Core Implementation

## 🔹 Node Class (Used Everywhere)

```java
static class Node {
    int data;
    Node left;
    Node right;
}
```

### 💡 Logic

- Each node stores:
  - Value (`data`)
  - Pointer to left subtree
  - Pointer to right subtree

---

# 🏗️ Building Tree (Preorder)

📄 File:

## 🔁 Algorithm

```text
1. Read current value
2. If value == -1 → return NULL
3. Create new node
4. Recursively build left subtree
5. Recursively build right subtree
```

## 💻 Code Logic

```java
Node newNode = new Node(nodes[index]);
newNode.left = buildTree(nodes);
newNode.right = buildTree(nodes);
```

### 🧠 Key Insight

- This works because input follows **Preorder (Root → Left → Right)**

---

# 🔄 Tree Traversals

---

## 🔸 1. Preorder Traversal

📄 File:

```text
Root → Left → Right
```

```java
print(root.data);
preOrder(root.left);
preOrder(root.right);
```

### 🧠 Use Case

- Used for **tree copying / serialization**

---

## 🔸 2. Inorder Traversal

📄 File:

```text
Left → Root → Right
```

```java
inOrder(root.left);
print(root.data);
inOrder(root.right);
```

### 🧠 Use Case

- Gives **sorted output in BST**

---

## 🔸 3. Postorder Traversal

📄 File:

```text
Left → Right → Root
```

```java
postOrder(root.left);
postOrder(root.right);
print(root.data);
```

### 🧠 Use Case

- Used in **tree deletion / memory cleanup**

---

## 🔸 4. Level Order Traversal (BFS)

📄 File:

### ⚙️ Logic

- Use **Queue**
- Process nodes level by level

```java
Queue<Node> q = new LinkedList<>();
q.add(root);
q.add(null);
```

### 🧠 Why `null`?

- Marks **end of one level**

---

# 📊 Tree Properties

---

## 🔹 Height of Tree

📄 File:

### 📌 Definition

Height = **Longest path from root to leaf**

### 💻 Logic

```java
return Math.max(leftHeight, rightHeight) + 1;
```

### ⏱ Complexity

- Time: **O(n)**
- Space: **O(h)** (recursion stack)

---

## 🔹 Count of Nodes

📄 File:

### 💻 Logic

```java
return leftCount + rightCount + 1;
```

### 🧠 Meaning

- Count left subtree
- Count right subtree
- Add current node

---

## 🔹 Sum of Nodes

📄 File:

### 💻 Logic

```java
return leftSum + rightSum + root.data;
```

---

# 🔁 Master Recursion Pattern (MOST IMPORTANT)

All problems follow:

```java
if (root == null) return base;

int left = func(root.left);
int right = func(root.right);

return combine(left, right, root);
```

---

## 📊 Pattern Table

| Problem      | Return Formula             |
| ------------ | -------------------------- |
| Height       | `max(left, right) + 1`     |
| Count Nodes  | `left + right + 1`         |
| Sum of Nodes | `left + right + root.data` |

---

# 🧪 How to Run

```bash
javac FileName.java
java FileName
```

---

# 📁 Project Structure

```text
Binary-Trees/
│
├── BuildTreePreorder.java
├── PreOrderTraversal.java
├── InOrderTraversal.java
├── PostOrderTraversal.java
├── LevelOrderTraversal.java
├── HeightOfaTree.java
├── CountNodesTree.java
├── SumOfNodes.java
└── Main.java
```

---

# 🎯 Key Learning Outcomes

✔ Strong understanding of Binary Trees
✔ Mastery of recursion patterns
✔ Ability to implement DFS & BFS
✔ Understanding of tree depth & structure
✔ Foundation for advanced topics

---

# 🚀 Next Topics (Recommended)

- Diameter of Binary Tree (🔥 Important)
- Balanced Trees
- Binary Search Trees (BST)
- Lowest Common Ancestor (LCA)
- Tree DP

---

# 👨‍💻 Author

**Satinder Singh Sall**
📚 DSA Learner | 💻 Java Developer

---

# ⭐ Final Notes

- All implementations are **clean and beginner-friendly**
- Focus is on **logic + recursion mastery**
- Code is aligned with **interview preparation standards**

---

---

# 🌳 Binary Trees in Java (DSA - Sigma 4.0)

![Java](https://img.shields.io/badge/Language-Java-blue.svg)
![DSA](https://img.shields.io/badge/Topic-Data%20Structures%20%26%20Algorithms-green)
![Level](https://img.shields.io/badge/Level-Beginner%20to%20Intermediate-orange)
![Status](https://img.shields.io/badge/Status-Completed-success)
![Focus](https://img.shields.io/badge/Focus-Recursion%20%26%20Trees-critical)

---

# 📌 Overview

This repository demonstrates **core Binary Tree concepts** implemented in Java as part of the **Sigma 4.0 DSA course**.

It focuses on:

- Tree construction
- Traversals (DFS & BFS)
- Recursive problem solving
- Tree properties (height, count, sum)

---

# 🌳 Visual Representation

## 📊 Binary Tree Structure

```
        1
      /   \
     2     3
    / \     \
   4   5     6
```

---

## 🔄 Traversal Visuals

### 🔹 Preorder (Root → Left → Right)

```
1 → 2 → 4 → 5 → 3 → 6
```

### 🔹 Inorder (Left → Root → Right)

```
4 → 2 → 5 → 1 → 3 → 6
```

### 🔹 Postorder (Left → Right → Root)

```
4 → 5 → 2 → 6 → 3 → 1
```

### 🔹 Level Order (BFS)

```
1
2 3
4 5 6
```

---

# 🏗️ Tree Construction Logic

📄 Reference:

## 🧠 Idea

- Input follows **Preorder traversal**
- `-1` represents NULL

## 🔁 Flow

```
Read value
   ↓
If -1 → return NULL
   ↓
Create node
   ↓
Build left subtree
   ↓
Build right subtree
```

---

# 🔄 Traversals Explained

## 🔹 DFS Traversals

| Traversal | Order               | Use Case                 |
| --------- | ------------------- | ------------------------ |
| Preorder  | Root → Left → Right | Copy tree, serialization |
| Inorder   | Left → Root → Right | Sorted output (BST)      |
| Postorder | Left → Right → Root | Deletion, cleanup        |

📄 Code References:

-
-
- ***

## 🔹 BFS Traversal (Level Order)

📄 Reference:

### ⚙️ Logic

- Uses Queue
- Level-by-level traversal
- `null` acts as level separator

---

# 📊 Complexity Analysis

## 🔹 Traversals

| Operation   | Time Complexity | Space Complexity |
| ----------- | --------------- | ---------------- |
| Preorder    | O(n)            | O(h)             |
| Inorder     | O(n)            | O(h)             |
| Postorder   | O(n)            | O(h)             |
| Level Order | O(n)            | O(n)             |

---

## 🔹 Tree Properties

| Problem      | Time Complexity | Space Complexity |
| ------------ | --------------- | ---------------- |
| Height       | O(n)            | O(h)             |
| Count Nodes  | O(n)            | O(h)             |
| Sum of Nodes | O(n)            | O(h)             |

Where:

- `n` = number of nodes
- `h` = height of tree

---

# 📐 Core Recursive Pattern

```java
if (root == null) return base;

int left = func(root.left);
int right = func(root.right);

return combine(left, right, root);
```

## 🔥 Pattern Mapping

| Problem      | Formula                    |
| ------------ | -------------------------- |
| Height       | `max(left, right) + 1`     |
| Count Nodes  | `left + right + 1`         |
| Sum of Nodes | `left + right + root.data` |

---

# 🧪 Code Modules

| File | Description           |
| ---- | --------------------- |
|      | Build Tree (Preorder) |
|      | Preorder Traversal    |
|      | Inorder Traversal     |
|      | Postorder Traversal   |
|      | Level Order Traversal |
|      | Height of Tree        |
|      | Count Nodes           |
|      | Sum of Nodes          |

---

# 🎯 Interview Questions (Must Practice)

## 🟢 Basic

- What is a Binary Tree?
- Difference between Binary Tree & BST?
- Explain all traversals.

---

## 🟡 Medium

- Find height of tree
- Count nodes
- Sum of nodes
- Level order traversal

---

## 🔴 Important (Next Level)

- Diameter of Binary Tree ⭐
- Check if tree is balanced
- Lowest Common Ancestor (LCA)
- Convert tree to mirror
- Left / Right view of tree

---

# 🚀 Advanced Insight (Very Important)

👉 **All tree problems = recursion + divide & conquer**

Think:

```
Problem(root) = Problem(left) + Problem(right) + self work
```

---

# 🧑‍💻 Author

**Satinder Singh Sall**
📚 DSA Learner | 💻 Java Developer

---

# ⭐ Final Thoughts

This project demonstrates:

- Strong recursion fundamentals
- Clear understanding of tree structures
- Interview-ready coding patterns

---
