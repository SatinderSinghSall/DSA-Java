# Data Structure and Algorithms: DSA - Java

## 🌳 Binary Search Trees (Part 2 / BST) – DSA

---

# 🌳 Binary Search Tree (BST) — Data Structures & Algorithms in Java

![Java](https://img.shields.io/badge/Language-Java-orange)
![DSA](https://img.shields.io/badge/Data%20Structures-Binary%20Search%20Tree-blue)
![Algorithms](https://img.shields.io/badge/Algorithms-Recursive-green)
![Status](https://img.shields.io/badge/Project-Complete-brightgreen)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

---

# Data Structure and Algorithms: DSA - Java

---

# 🌳 Advanced Binary Search Trees (BST Part 2)

![Java](https://img.shields.io/badge/Language-Java-orange)
![DSA](https://img.shields.io/badge/Data%20Structures-Binary%20Search%20Tree-blue)
![Algorithms](https://img.shields.io/badge/Algorithms-Tree%20Algorithms-green)
![Balanced Trees](https://img.shields.io/badge/Topic-Balanced%20BST-purple)
![Status](https://img.shields.io/badge/Module-Completed-brightgreen)

---

# 📚 Overview

This module extends the core **Binary Search Tree (BST)** concepts and introduces advanced algorithms used to maintain efficiency and handle complex operations on tree structures.

The implementations demonstrate important problems frequently asked in **technical interviews, competitive programming, and advanced data structures courses**.

The following topics are covered:

| Algorithm                   | Description                                         |
| --------------------------- | --------------------------------------------------- |
| Sorted Array → Balanced BST | Construct a height-balanced BST from a sorted array |
| Convert BST → Balanced BST  | Balance an existing skewed BST                      |
| Size of Largest BST in BT   | Find the largest BST inside a binary tree           |
| Merge Two BSTs              | Combine two BSTs into one balanced BST              |
| AVL Trees                   | Self-balancing BST using rotations                  |
| Red-Black Trees             | Balanced BST used in many libraries                 |

---

# 🌳 Why Balanced BSTs Are Important

A normal BST may become **skewed**, causing poor performance.

### Example of Skewed BST

```
1
 \
  2
   \
    3
     \
      4
```

Time Complexity becomes:

```
Search = O(n)
```

Balanced trees maintain:

```
Height ≈ log n
```

Ensuring efficient operations.

---

# ⏱ Complexity Comparison

| Structure      | Search   | Insert   | Delete   |
| -------------- | -------- | -------- | -------- |
| Normal BST     | O(log n) | O(log n) | O(log n) |
| Skewed BST     | O(n)     | O(n)     | O(n)     |
| AVL Tree       | O(log n) | O(log n) | O(log n) |
| Red-Black Tree | O(log n) | O(log n) | O(log n) |

---

# 1️⃣ Sorted Array → Balanced BST

## Problem

Convert a **sorted array into a balanced BST**.

Example input:

```
[1,2,3,4,5,6,7]
```

### Result

```
        4
      /   \
     2     6
    / \   / \
   1   3 5   7
```

This ensures **minimum height**.

---

## Algorithm

1. Select the **middle element** as root
2. Recursively build left subtree
3. Recursively build right subtree

---

## Pseudocode

```
function sortedArrayToBST(arr, start, end):

    if start > end
        return null

    mid = (start + end) / 2

    root = new Node(arr[mid])

    root.left = build(start, mid-1)
    root.right = build(mid+1, end)

    return root
```

---

## Java Implementation

```java
Node sortedArrayToBST(int arr[], int start, int end){

    if(start > end)
        return null;

    int mid = (start + end) / 2;

    Node root = new Node(arr[mid]);

    root.left = sortedArrayToBST(arr, start, mid-1);
    root.right = sortedArrayToBST(arr, mid+1, end);

    return root;
}
```

---

# 2️⃣ Convert BST → Balanced BST

## Problem

Given a BST that may be skewed, convert it into a **balanced BST**.

---

### Example

Skewed Tree

```
1
 \
  2
   \
    3
     \
      4
```

Balanced Result

```
      3
     / \
    2   4
   /
  1
```

---

## Algorithm

1. Perform **inorder traversal**
2. Store nodes in an array
3. Build balanced BST from sorted array

---

## Pseudocode

```
function balanceBST(root):

    list = inorderTraversal(root)

    return buildBalanced(list)
```

---

# 3️⃣ Size of Largest BST in Binary Tree

## Problem

Given a **binary tree**, find the size of the **largest BST inside it**.

---

### Example

```
        50
       /  \
      30   60
     / \   / \
    5  20 45 70
```

Largest BST

```
      60
     /  \
    45  70
```

Size = **3**

---

## Algorithm

Use **postorder traversal**.

Track:

- min value
- max value
- subtree size
- BST validity

---

## Pseudocode

```
function largestBST(root):

    if root == null
        return size = 0

    left = largestBST(root.left)
    right = largestBST(root.right)

    if BST condition satisfied
        size = left.size + right.size + 1

    else
        size = max(left.size, right.size)
```

---

# 4️⃣ Merge Two BSTs

## Problem

Merge two BSTs into a **single balanced BST**.

---

### Example

BST 1

```
   2
  / \
 1   4
```

BST 2

```
   9
  / \
 3  12
```

Merged BST

```
      4
     / \
    2   9
   / \ / \
  1  3 6 12
```

---

## Algorithm

1. Get inorder traversal of both trees
2. Merge sorted lists
3. Convert merged list to BST

---

# 5️⃣ AVL Trees

AVL Trees are **self-balancing BSTs**.

Height difference between subtrees must be:

```
|height(left) - height(right)| ≤ 1
```

---

## Rotations

### Left Rotation

```
   x
    \
     y
```

Becomes

```
     y
    /
   x
```

---

### Right Rotation

```
     y
    /
   x
```

Becomes

```
   x
    \
     y
```

---

# 6️⃣ Red-Black Trees

Red-Black Trees are balanced BSTs used in:

- Java TreeMap
- C++ STL map
- Linux kernel

---

## Properties

1. Every node is **red or black**
2. Root is **black**
3. No two red nodes adjacent
4. Every path has same number of black nodes

---

### Example

```
        10(B)
       /    \
     5(R)   20(R)
```

---

# 🌳 Visualization

Example BST used in this module:

```
        8
      /   \
     5     10
    / \      \
   3   6      11
  / \           \
 1   4           14
```

Range Example:

```
k1 = 5
k2 = 12

Output:
5 6 8 10 11
```

---

# 🧠 Key Concepts Learned

- Balanced tree construction
- Height optimization
- Tree rotations
- Tree validation
- Tree merging algorithms
- Recursive tree processing

---

# 💼 Applications

Balanced BSTs are used in:

- Database indexing
- File systems
- Compilers
- Network routing
- Operating systems
- Memory allocators

---

# 🚀 Skills Demonstrated

✔ Advanced Tree Algorithms
✔ Balanced Tree Construction
✔ Recursive Algorithm Design
✔ Data Structure Optimization
✔ Algorithm Complexity Analysis

---

# 📜 License

MIT License

---

# 👨‍💻 Author

**Satinder Singh**

Full-Stack Web/Mobile Engineer
Data Structures & Algorithms
Java | Problem Solving | Software Engineering

---
