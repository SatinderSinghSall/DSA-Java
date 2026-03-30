# Data Structure and Algorithms: DSA - Java

## 🌳 Binary Trees (Part 3) – DSA

# 🌳 Binary Trees – Advanced DSA (Sigma 4.0)

![Java](https://img.shields.io/badge/Language-Java-orange)
![DSA](https://img.shields.io/badge/Data%20Structures-Binary%20Trees-blue)
![Level](https://img.shields.io/badge/Level-Intermediate%20to%20Advanced-green)
![Status](https://img.shields.io/badge/Status-Completed-success)
![Practice](https://img.shields.io/badge/Practice-Interview%20Ready-purple)

---

## 📌 Overview

This repository contains a **comprehensive implementation and analysis of Binary Tree problems** studied in _Sigma 4.0 (Apna College)_.

It focuses on:

- Recursive problem-solving patterns
- Tree traversal strategies
- Optimization from brute-force → optimal
- Real-world interview questions

---

## 🧭 Visual Understanding (Top View Concept)

![Image](https://files.codingninjas.in/top_view-5246.jpg)

![Image](https://cdn.hashnode.com/res/hashnode/image/upload/v1680272245109/713820f2-e555-4104-b74e-e915a31a9570.png)

![Image](https://tutorialhorizon.com/static/media/algorithms/2015/01/Vertical-Order-Sum-Implementation.png)

👉 Key Idea:

- Root = HD 0
- Left = -1
- Right = +1
- First node at each HD = Top View

---

# 📚 Topics Covered

- Height, Count, Sum
- Diameter (O(n²) & O(n))
- Subtree of Another Tree
- Top View of Tree
- Kth Level
- Lowest Common Ancestor
- Minimum Distance Between Nodes
- Kth Ancestor
- Transform to Sum Tree

---

# 🧠 1. Diameter of Binary Tree

📂 Files:

-
-
-
- ***

## 🔹 Problem

Find the **longest path between any two nodes** in a binary tree.

---

## 🔹 Approaches

### 🟥 Naive (O(n²))

- Recompute height repeatedly

### 🟩 Optimized (O(n))

- Combine height + diameter in one recursion

---

## 🔹 Pseudocode (Optimized)

```
function diameter(root):
    if root == null:
        return (diameter=0, height=0)

    left = diameter(root.left)
    right = diameter(root.right)

    height = max(left.height, right.height) + 1

    selfDiameter = left.height + right.height + 1

    finalDiameter = max(selfDiameter, left.diameter, right.diameter)

    return (finalDiameter, height)
```

---

## 📊 Complexity

| Approach  | Time  | Space |
| --------- | ----- | ----- |
| Naive     | O(n²) | O(h)  |
| Optimized | O(n)  | O(h)  |

---

# 🧠 2. Height, Count, Sum

📂 File:

---

## 🔹 Concept

Basic recursive tree properties.

---

## 🔹 Complexity

| Operation | Time | Space |
| --------- | ---- | ----- |
| Height    | O(n) | O(h)  |
| Count     | O(n) | O(h)  |
| Sum       | O(n) | O(h)  |

---

# 🧠 3. Subtree of Another Tree

📂 File:

---

## 🔹 Problem

Check if one tree exists inside another.

---

## 🔹 Algorithm

- Traverse main tree
- Match subtree using identical check

---

## 📊 Complexity

| Case  | Time     |
| ----- | -------- |
| Worst | O(n × m) |

---

# 🧠 4. Top View of Binary Tree

📂 File:

---

## 🔹 Key Concept

Uses:

- BFS (Queue)
- Horizontal Distance (HD)
- HashMap

---

## 🔹 Algorithm Steps

1. Traverse level order
2. Track HD
3. Store first node for each HD

---

## 📊 Complexity

| Metric | Value |
| ------ | ----- |
| Time   | O(n)  |
| Space  | O(n)  |

---

# 🧠 5. Lowest Common Ancestor (LCA)

## 🔹 Optimal Logic

- If node matches → return
- If found in both sides → root is LCA

---

## 📊 Complexity

| Metric | Value |
| ------ | ----- |
| Time   | O(n)  |
| Space  | O(h)  |

---

# 🧠 6. Minimum Distance Between Nodes

## 🔹 Formula

```
Distance = d(LCA → n1) + d(LCA → n2)
```

---

# 🧠 7. Kth Ancestor

## 🔹 Idea

Backtrack and track distance from target node.

---

# 🧠 8. Transform to Sum Tree

## 🔹 Transformation

```
node = sum(left subtree + right subtree)
```

---

# 🧪 Sample Tree

```
        1
       / \
      2   3
     / \   \
    4   5   6
```

---

# 💻 Code Structure

- Modular Node class
- Recursive implementations
- BFS for level-based problems
- Helper classes for optimization

---

# 🧠 Interview Questions & Answers

### ❓ Why is diameter O(n²) in naive?

Because height is recomputed for every node.

---

### ❓ How is optimized better?

Height + diameter computed in one traversal → O(n)

---

### ❓ Why BFS for Top View?

Because we need the **first visible node at each level**.

---

### ❓ Difference between LCA approaches?

| Approach  | Idea             |
| --------- | ---------------- |
| Path      | Store paths      |
| Optimized | Single recursion |

---

### ❓ Most important pattern?

👉 **Divide → Solve → Combine**

---

# 🚀 Key Takeaways

- Trees = recursion mastery
- Avoid repeated work (optimize)
- Understand structure, not just code
- Practice dry runs

---

# 🛠️ How to Run

```bash
javac FileName.java
java FileName
```

---

# 🧑‍💻 Author

**Satinder Singh Sall**
DSA Learner | Java Developer

---

# ⭐ If you like this repo

Give it a ⭐ and keep practicing!

## 🌳 Binary Trees – Advanced Concepts (Sigma 4.0 DSA)

![Java](https://img.shields.io/badge/Language-Java-orange)
![DSA](https://img.shields.io/badge/Topic-Data%20Structures-blue)
![Trees](https://img.shields.io/badge/Concept-Binary%20Trees-green)
![Status](https://img.shields.io/badge/Status-Completed-success)

---

## 📌 Overview

This repository contains implementations and theoretical explanations of **advanced Binary Tree problems** studied in **Sigma 4.0 (Apna College)**.

The focus is on:

- Tree Traversals & Properties
- Recursive Problem Solving
- Optimization Techniques (O(n²) → O(n))
- Real Interview Problems

---

## 📚 Topics Covered

- Height, Count, Sum of Nodes
- Diameter of Tree (Naive & Optimized)
- Subtree Detection
- Top View of Binary Tree
- Kth Level
- Lowest Common Ancestor (LCA)
- Minimum Distance Between Nodes
- Kth Ancestor
- Sum Tree Transformation

---

# 🧠 1. Diameter of Binary Tree

📂 File References:

-
-
-
- ***

## 🔹 Problem

Find the **diameter of a binary tree**, defined as the number of nodes in the longest path between any two nodes.

---

## 🔹 Algorithm (Naive - O(n²))

1. Compute height of left subtree
2. Compute height of right subtree
3. Diameter = leftHeight + rightHeight + 1
4. Recursively compute diameter of left and right
5. Return max of all

---

## 🔹 Pseudocode

```
function diameter(root):
    if root == null:
        return 0

    leftDiameter = diameter(root.left)
    rightDiameter = diameter(root.right)

    leftHeight = height(root.left)
    rightHeight = height(root.right)

    selfDiameter = leftHeight + rightHeight + 1

    return max(selfDiameter, leftDiameter, rightDiameter)
```

---

## 🔹 Optimized Approach (O(n))

Uses a custom class storing:

- height
- diameter

---

## 🔹 Key Insight

👉 Avoid repeated height calculation
👉 Compute height & diameter in one traversal

---

# 🧠 2. Height, Count, Sum of Tree

📂 File:

---

## 🔹 Problem

Compute:

- Height of tree
- Total number of nodes
- Sum of all nodes

---

## 🔹 Algorithm

All use **recursion (DFS)**:

- Height → max(left, right) + 1
- Count → left + right + 1
- Sum → left + right + root.data

---

## 🔹 Pseudocode

```
height(root):
    if null → return 0
    return max(height(left), height(right)) + 1

count(root):
    return left + right + 1

sum(root):
    return left + right + root.data
```

---

# 🧠 3. Subtree of Another Tree

📂 File:

---

## 🔹 Problem

Check whether a tree is a subtree of another tree.

---

## 🔹 Algorithm

1. Traverse main tree
2. When node matches → check identical
3. Use helper function

---

## 🔹 Pseudocode

```
isSubtree(root, subRoot):
    if root == null → false

    if root.data == subRoot.data:
        if isIdentical(root, subRoot):
            return true

    return isSubtree(left) OR isSubtree(right)
```

---

## 🔹 Key Insight

👉 Combines **tree traversal + structure matching**

---

# 🧠 4. Top View of Binary Tree

📂 File:

---

## 🔹 Problem

Print nodes visible from the **top view** of the tree.

---

## 🔹 Algorithm

1. Use **Level Order Traversal (BFS)**
2. Track **Horizontal Distance (HD)**
3. Store first node at each HD using HashMap

---

## 🔹 Pseudocode

```
topView(root):
    queue ← (node, hd)
    map ← empty

    while queue not empty:
        node, hd = pop()

        if hd not in map:
            map[hd] = node

        push left with hd-1
        push right with hd+1
```

---

## 🔹 Key Insight

👉 First node at each horizontal distance = visible node

---

# 🧠 5. Lowest Common Ancestor (LCA)

## 🔹 Problem

Find the lowest node that has both nodes as descendants.

---

## 🔹 Optimized Algorithm

```
if root == null OR root == n1 OR root == n2:
    return root

left = lca(left subtree)
right = lca(right subtree)

if both exist → return root
else return non-null
```

---

## 🔹 Complexity

- Time: O(n)
- Space: O(h)

---

# 🧠 6. Minimum Distance Between Nodes

## 🔹 Formula

```
distance = dist(LCA → n1) + dist(LCA → n2)
```

---

## 🔹 Key Idea

👉 Convert problem into LCA + distance

---

# 🧠 7. Kth Ancestor

## 🔹 Problem

Find the k-th ancestor of a node.

---

## 🔹 Approach

- Use recursion
- Track distance while backtracking

---

# 🧠 8. Transform to Sum Tree

## 🔹 Problem

Convert tree such that:

```
node.data = sum(left subtree + right subtree)
```

---

## 🔹 Algorithm

```
leftSum = transform(left)
rightSum = transform(right)

old = root.data
root.data = leftSum + rightSum

return old + root.data
```

---

# 🧪 Sample Tree Used

```
        1
       / \
      2   3
     / \   \
    4   5   6
```

---

# ⚙️ How to Run

```bash
javac FileName.java
java FileName
```

---

# 🎯 Key Learning Outcomes

- Mastered recursion on trees
- Understood tree decomposition
- Learned optimization techniques
- Practiced real interview problems

---

# 📌 Conclusion

This module builds strong intuition for:

- Recursive thinking
- Tree-based problem solving
- Writing optimized solutions

---

# 🙌 Credits

- Course: **Sigma 4.0 – Apna College**
- Author: Satinder Singh Sall

---
