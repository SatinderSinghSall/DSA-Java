# Data Structure and Algorithms: DSA - Java

## 🌳 Binary Search Trees (Part 1 / BST) – DSA

---

# 🌳 Binary Search Tree (BST) — Data Structures & Algorithms in Java

![Java](https://img.shields.io/badge/Language-Java-orange)
![DSA](https://img.shields.io/badge/Data%20Structures-Binary%20Search%20Tree-blue)
![Algorithms](https://img.shields.io/badge/Algorithms-Recursive-green)
![Status](https://img.shields.io/badge/Project-Complete-brightgreen)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

---

# 📚 Overview

This repository contains a **comprehensive implementation of Binary Search Tree (BST) algorithms in Java**.

The project demonstrates fundamental **data structure concepts and recursive algorithms** commonly used in:

- Computer Science coursework
- Technical interviews
- Competitive programming
- Software engineering problem solving

The repository includes implementations of:

| Algorithm          | Description                                    |
| ------------------ | ---------------------------------------------- |
| BST Construction   | Building a BST using insertion                 |
| Search in BST      | Finding an element efficiently                 |
| Delete Node        | Removing a node while maintaining BST property |
| Print in Range     | Printing nodes within a value range            |
| Root to Leaf Paths | Displaying all root-to-leaf paths              |
| Validate BST       | Checking if a tree is a valid BST              |
| Mirror BST         | Creating a mirror image of the tree            |

---

# 🌳 What is a Binary Search Tree?

A **Binary Search Tree (BST)** is a hierarchical data structure where:

```
Left Subtree  <  Node Value  <  Right Subtree
```

### Example BST

```
        8
      /   \
     5     10
    / \      \
   3   6      11
  / \           \
 1   4           14
```

### Key Properties

- Left child values are **smaller**
- Right child values are **greater**
- Enables **efficient searching**

---

# ⏱ Time Complexity

| Operation | Average Case | Worst Case |
| --------- | ------------ | ---------- |
| Search    | O(log n)     | O(n)       |
| Insert    | O(log n)     | O(n)       |
| Delete    | O(log n)     | O(n)       |
| Traversal | O(n)         | O(n)       |

Worst case occurs when the tree becomes **skewed**.

---

# 📁 Project Structure

```
BST-Algorithms/
│
├── BinarySearchTree.java
├── SearchBinarySearchTree.java
├── DeleteNode_BST.java
├── PrintRange_BST.java
├── RootToLeafPath_BST.java
├── ValidateBST.java
├── MirrorBST.java
└── Main.java
```

---

# 1️⃣ Constructing a Binary Search Tree

## Problem

Build a BST by inserting elements sequentially.

### Example Input

```
[5, 1, 3, 2, 4, 7]
```

### Resulting BST

```
      5
     / \
    1   7
     \
      3
     / \
    2   4
```

---

## Algorithm

1. Start with an empty tree
2. Insert the first value as root
3. For every next value:
   - If smaller → go left
   - If greater → go right

4. Repeat recursively

---

## Pseudocode

```
function insert(root, value):

    if root == null
        return new Node(value)

    if value < root.data
        root.left = insert(root.left, value)
    else
        root.right = insert(root.right, value)

    return root
```

---

## Java Code

```java
static class Node {
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
    }
}

public static Node insert(Node root, int val){
    if(root == null){
        return new Node(val);
    }

    if(root.data > val){
        root.left = insert(root.left, val);
    } else {
        root.right = insert(root.right, val);
    }

    return root;
}
```

---

# 2️⃣ Search in a Binary Search Tree

## Problem

Find whether a **key exists in the BST**.

---

### Example

Search for `1`

```
        5
       / \
      1   7
```

Traversal:

```
5 → go left
1 → found
```

---

## Algorithm

1. Compare key with root
2. If equal → return true
3. If smaller → search left
4. If larger → search right

---

## Pseudocode

```
function search(root, key):

    if root == null
        return false

    if root.data == key
        return true

    if key < root.data
        return search(root.left)
    else
        return search(root.right)
```

---

## Java Code

```java
public static boolean search(Node root, int key){

    if(root == null)
        return false;

    if(root.data == key)
        return true;

    if(root.data > key)
        return search(root.left, key);
    else
        return search(root.right, key);
}
```

---

# 3️⃣ Delete Node in BST

## Problem

Delete a node while preserving BST properties.

---

### Three Cases

### Case 1 — Leaf Node

```
   5
  /
 3
```

Delete `3`

```
   5
```

---

### Case 2 — One Child

```
  5
   \
    7
     \
      8
```

Delete `7`

```
 5
  \
   8
```

---

### Case 3 — Two Children

Replace node with **Inorder Successor**

```
      8
     / \
    5   10
```

Delete `8`

Replace with `10`.

---

## Algorithm

1. Find the node
2. Handle three cases
3. Replace using inorder successor if needed

---

# 4️⃣ Print Nodes in Range

## Problem

Print all nodes whose values lie in range:

```
[k1 , k2]
```

Example:

```
Range = 2 to 5
```

BST:

```
      5
     / \
    3   7
   / \
  2   4
```

Output

```
2 3 4 5
```

---

## Algorithm

Use BST property to skip unnecessary branches.

---

## Pseudocode

```
function printInRange(root,k1,k2)

    if root is null
        return

    if root.data between k1 and k2
        print left
        print root
        print right

    else if root.data < k1
        go right

    else
        go left
```

---

# 5️⃣ Root to Leaf Paths

## Problem

Print all possible paths from root node to leaf nodes.

---

Example

```
        8
      /   \
     5     10
    / \
   3   6
```

Paths

```
8 → 5 → 3
8 → 5 → 6
8 → 10
```

---

## Algorithm

Use **Backtracking**

1. Add node to path
2. If leaf → print path
3. Recurse left and right
4. Remove node from path

---

# 6️⃣ Validate a BST

## Problem

Check whether a binary tree satisfies BST properties.

---

### Valid BST

```
    8
   / \
  5   10
```

### Invalid BST

```
    8
   / \
 10   5
```

---

## Algorithm

Use **min / max boundaries**.

---

## Pseudocode

```
function isValidBST(root, min, max):

    if root == null
        return true

    if root.data <= min OR root.data >= max
        return false

    return check left AND right
```

---

# 7️⃣ Mirror a Binary Search Tree

## Problem

Convert BST into its **mirror image**.

---

Original

```
    4
   / \
  2   7
```

Mirror

```
    4
   / \
  7   2
```

---

## Algorithm

Swap left and right recursively.

---

## Pseudocode

```
function mirror(root)

    if root == null
        return null

    left = mirror(root.left)
    right = mirror(root.right)

    root.left = right
    root.right = left

    return root
```

---

# 🧠 Key Concepts Learned

- Recursive tree traversal
- Binary tree properties
- Backtracking algorithms
- Tree transformation
- Efficient searching
- Structural validation

---

# 💼 Applications of BST

Binary Search Trees are used in:

- Database indexing
- File systems
- Compilers
- Memory management
- Priority queues
- Searching algorithms

---

# 🚀 Skills Demonstrated

✔ Data Structures
✔ Recursive Algorithms
✔ Tree Traversals
✔ Problem Solving
✔ Algorithm Analysis

---

# 📜 License

This project is open-source under the **MIT License**.

---

# 👨‍💻 Author

**Satinder Singh**

Data Structures & Algorithms
Java | Problem Solving | Software Engineering

---

---

## 🌳 Binary Search Trees (Part 1 / BST) – DSA

---

# Binary Search Tree (BST) – Data Structures and Algorithms

## Overview

This repository contains Java implementations of fundamental **Binary Search Tree (BST)** operations.
The project demonstrates the theoretical concepts and practical implementations of BST algorithms including:

- BST Construction
- Searching in a BST
- Deleting a Node
- Printing Nodes in a Range
- Root-to-Leaf Path Traversal
- Validating a BST
- Mirroring a BST

These implementations follow **standard recursive algorithms** and illustrate important data structure concepts used in computer science, competitive programming, and technical interviews.

---

# What is a Binary Search Tree?

A **Binary Search Tree (BST)** is a binary tree data structure that maintains a specific ordering property.

### BST Property

For every node:

```
Left Subtree values  <  Node value  <  Right Subtree values
```

This property allows efficient searching, insertion, and deletion operations.

### Time Complexity

| Operation | Average Case | Worst Case |
| --------- | ------------ | ---------- |
| Search    | O(log n)     | O(n)       |
| Insert    | O(log n)     | O(n)       |
| Delete    | O(log n)     | O(n)       |

The worst case occurs when the BST becomes **skewed**.

---

# Project Structure

```
BinarySearchTree.java
SearchBinarySearchTree.java
DeleteNode_BST.java
PrintRange_BST.java
RootToLeafPath_BST.java
ValidateBST.java
MirrorBST.java
Main.java
```

---

# 1. Building a Binary Search Tree

## Problem

Construct a Binary Search Tree by inserting elements sequentially.

## Algorithm

1. Start with an empty root.
2. Insert elements one by one.
3. If the value is smaller than the current node, move left.
4. If the value is greater, move right.
5. Repeat recursively until an empty position is found.

## Pseudocode

```
function insert(root, value):
    if root is null
        return new Node(value)

    if value < root.data
        root.left = insert(root.left, value)
    else
        root.right = insert(root.right, value)

    return root
```

## Java Implementation

```java
static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}

public static Node insert(Node root, int val) {
    if (root == null) {
        return new Node(val);
    }

    if (root.data > val) {
        root.left = insert(root.left, val);
    } else {
        root.right = insert(root.right, val);
    }

    return root;
}
```

---

# 2. Searching in a BST

## Problem

Determine whether a given key exists in the BST.

## Algorithm

1. Compare key with root.
2. If equal → return true.
3. If smaller → search left subtree.
4. If greater → search right subtree.

## Pseudocode

```
function search(root, key):
    if root is null
        return false

    if root.data == key
        return true

    if key < root.data
        search(root.left)
    else
        search(root.right)
```

## Java Implementation

```java
public static boolean search(Node root, int key) {
    if (root == null) {
        return false;
    }

    if (root.data == key) {
        return true;
    }

    if (root.data > key) {
        return search(root.left, key);
    } else {
        return search(root.right, key);
    }
}
```

---

# 3. Delete a Node in BST

## Problem

Remove a node from the BST while maintaining BST properties.

## Cases

1. **Leaf Node** → delete directly
2. **One Child** → replace node with child
3. **Two Children** → replace with inorder successor

## Algorithm

1. Locate node to delete.
2. Handle deletion based on the three cases.
3. Maintain BST property.

## Pseudocode

```
function delete(root, value):

    if root is null
        return null

    if value < root.data
        root.left = delete(root.left)

    else if value > root.data
        root.right = delete(root.right)

    else
        if node is leaf
            return null

        if only one child
            return child

        successor = smallest in right subtree
        root.data = successor.data
        delete successor

    return root
```

## Java Implementation

```java
public static Node delete(Node root, int value) {

    if (root == null) {
        return null;
    }

    if (value < root.data) {
        root.left = delete(root.left, value);
    }

    else if (value > root.data) {
        root.right = delete(root.right, value);
    }

    else {

        if (root.left == null && root.right == null) {
            return null;
        }

        if (root.left == null) {
            return root.right;
        }

        if (root.right == null) {
            return root.left;
        }

        Node successor = findInorderSuccessor(root.right);
        root.data = successor.data;
        root.right = delete(root.right, successor.data);
    }

    return root;
}
```

---

# 4. Print Nodes in a Range

## Problem

Print all nodes whose values lie within a given range `[k1, k2]`.

## Algorithm

Use BST property to skip unnecessary branches.

## Pseudocode

```
function printInRange(root, k1, k2):

    if root is null
        return

    if root.data between k1 and k2
        print left subtree
        print root.data
        print right subtree

    else if root.data < k1
        explore right subtree

    else
        explore left subtree
```

---

# 5. Root to Leaf Paths

## Problem

Print all paths from root node to leaf nodes.

## Algorithm

1. Maintain a list for the current path.
2. Add nodes while traversing.
3. Print when leaf is reached.
4. Backtrack after visiting nodes.

---

# 6. Validate a BST

## Problem

Check if a binary tree satisfies BST properties.

## Algorithm

Use **min and max constraints**.

## Pseudocode

```
function isValidBST(root, min, max):

    if root is null
        return true

    if root.data <= min OR root.data >= max
        return false

    return validate left subtree AND validate right subtree
```

---

# 7. Mirror a BST

## Problem

Convert BST into its mirror image.

## Algorithm

Swap left and right subtrees recursively.

## Pseudocode

```
function mirror(root):

    if root is null
        return null

    left = mirror(root.left)
    right = mirror(root.right)

    root.left = right
    root.right = left

    return root
```

---

# Key Concepts Learned

- Tree recursion
- Binary Search Tree properties
- Tree traversal techniques
- Backtracking
- Structural tree transformations
- Algorithm design using recursion

---

# Applications of BST

Binary Search Trees are used in:

- Database indexing
- File systems
- Symbol tables
- Searching algorithms
- Priority queues
- Memory management

---

# Conclusion

This project demonstrates a comprehensive exploration of **Binary Search Tree operations** using Java.
Through these implementations, key algorithmic principles such as recursion, tree traversal, and structural manipulation are applied to solve fundamental problems in data structures.

These concepts are essential for **technical interviews, competitive programming, and advanced algorithm design**.

---

# Data Structure and Algorithms: DSA - Java

## 🌳 Binary Search Trees (Part 1 / BST) – DSA

---

# 📘 Binary Search Tree (BST) – Data Structures & Algorithms (Java)

![Java](https://img.shields.io/badge/Language-Java-blue)
![DSA](https://img.shields.io/badge/Topic-Data%20Structures-green)
![Level](https://img.shields.io/badge/Level-Intermediate-orange)
![Status](https://img.shields.io/badge/Module-Completed-brightgreen)
![Focus](https://img.shields.io/badge/Focus-Binary%20Search%20Tree-purple)

---

## 📑 Table of Contents

- 📌 Introduction
- 🌳 What is a Binary Search Tree
- 🔍 Searching in BST
- ➕ Insertion (Build BST)
- ❌ Deletion in BST
- 📊 Print in Range
- 🛤 Root to Leaf Paths
- ✅ Validate BST
- 🔁 Mirror BST
- 📎 Summary

---

![Java](https://img.shields.io/badge/Language-Java-blue)
![DSA](https://img.shields.io/badge/Data%20Structures-BST-green)
![Complexity](<https://img.shields.io/badge/Time-O(log%20n)-orange>)
![Recursion](https://img.shields.io/badge/Technique-Recursion-purple)
![Status](https://img.shields.io/badge/Project-Portfolio%20Ready-brightgreen)

---

## 📌 Introduction

![Image](https://deen3evddmddt.cloudfront.net/uploads/content-images/what-is-binary-search-tree.webp)

![Image](https://mathcenter.oxford.emory.edu/site/cs171/binarySearchTrees/vocabulary_of_trees.png)

![Image](https://i.sstatic.net/skwTP.png)

![Image](https://www.dundas.com/Support/images/dbi/support-articles/data-vis/tree-visualization-images.png)

A **Binary Search Tree (BST)** is a hierarchical data structure that allows **efficient searching, insertion, and deletion** operations.

### 🔑 Key Property:

For every node:

```
Left subtree < Node < Right subtree
```

### ⏱ Time Complexity (Average Case)

| Operation | Time     |
| --------- | -------- |
| Search    | O(log n) |
| Insert    | O(log n) |
| Delete    | O(log n) |

---

## 🌳 Structure of a BST

![Image](https://mathcenter.oxford.emory.edu/site/cs171/binarySearchTrees/vocabulary_of_trees.png)

![Image](https://i.sstatic.net/9jegh.png)

![Image](https://storage.googleapis.com/algodailyrandomassets/curriculum/trees/balanced-binary-tree-example1.png)

![Image](https://deen3evddmddt.cloudfront.net/uploads/content-images/balanced-binary-tree-height.webp)

---

## 🔍 Problem 1: Search in BST

### 🧠 Problem

Given a BST and a key, determine if the key exists.

### ⚙️ Algorithm

1. Start at root
2. If key == root → found
3. If key < root → go left
4. If key > root → go right

### 🧾 Pseudocode

```
search(root, key):
    if root == null:
        return false
    if root.data == key:
        return true
    if key < root.data:
        return search(root.left, key)
    else:
        return search(root.right, key)
```

### 💻 Java Code

```java
boolean search(Node root, int key) {
    if (root == null) return false;
    if (root.data == key) return true;

    if (key < root.data)
        return search(root.left, key);
    else
        return search(root.right, key);
}
```

---

## ➕ Problem 2: Build (Insert into BST)

### 🧠 Problem

Insert a value into BST while maintaining its properties.

### ⚙️ Algorithm

- Traverse tree recursively
- Insert at correct null position

### 🧾 Pseudocode

```
insert(root, val):
    if root == null:
        return new Node(val)

    if val < root.data:
        root.left = insert(root.left, val)
    else:
        root.right = insert(root.right, val)

    return root
```

### 💻 Java Code

```java
Node insert(Node root, int val) {
    if (root == null) {
        return new Node(val);
    }

    if (val < root.data) {
        root.left = insert(root.left, val);
    } else {
        root.right = insert(root.right, val);
    }

    return root;
}
```

---

## ❌ Problem 3: Delete a Node

### 🧠 Problem

Delete a node from BST.

### ⚙️ Cases

1. Leaf node
2. One child
3. Two children → replace with inorder successor

### 🧾 Pseudocode

```
delete(root, key):
    if root == null: return null

    if key < root.data:
        root.left = delete(root.left, key)
    else if key > root.data:
        root.right = delete(root.right, key)
    else:
        if root.left == null:
            return root.right
        if root.right == null:
            return root.left

        successor = findMin(root.right)
        root.data = successor.data
        root.right = delete(root.right, successor.data)

    return root
```

### 💻 Java Code

```java
Node delete(Node root, int key) {
    if (root == null) return null;

    if (key < root.data) {
        root.left = delete(root.left, key);
    } else if (key > root.data) {
        root.right = delete(root.right, key);
    } else {
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;

        Node successor = findMin(root.right);
        root.data = successor.data;
        root.right = delete(root.right, successor.data);
    }
    return root;
}

Node findMin(Node root) {
    while (root.left != null) root = root.left;
    return root;
}
```

---

## 📊 Problem 4: Print in Range

### 🧠 Problem

Print nodes within range `[k1, k2]`.

### ⚙️ Idea

Use **inorder traversal** and filter values.

### 💻 Java Code

```java
void printInRange(Node root, int k1, int k2) {
    if (root == null) return;

    if (root.data >= k1 && root.data <= k2) {
        printInRange(root.left, k1, k2);
        System.out.print(root.data + " ");
        printInRange(root.right, k1, k2);
    } else if (root.data < k1) {
        printInRange(root.right, k1, k2);
    } else {
        printInRange(root.left, k1, k2);
    }
}
```

---

## 🛤 Problem 5: Root to Leaf Paths

### 🧠 Problem

Print all paths from root to leaf.

### 💻 Java Code

```java
void printPaths(Node root, List<Integer> path) {
    if (root == null) return;

    path.add(root.data);

    if (root.left == null && root.right == null) {
        System.out.println(path);
    } else {
        printPaths(root.left, path);
        printPaths(root.right, path);
    }

    path.remove(path.size() - 1);
}
```

---

## ✅ Problem 6: Validate BST

### 🧠 Problem

Check if a tree is a valid BST.

### 💻 Java Code

```java
boolean isValidBST(Node root, int min, int max) {
    if (root == null) return true;

    if (root.data <= min || root.data >= max)
        return false;

    return isValidBST(root.left, min, root.data) &&
           isValidBST(root.right, root.data, max);
}
```

---

## 🔁 Problem 7: Mirror a BST

### 🧠 Problem

Convert BST into its mirror.

### 💻 Java Code

```java
Node mirror(Node root) {
    if (root == null) return null;

    Node left = mirror(root.left);
    Node right = mirror(root.right);

    root.left = right;
    root.right = left;

    return root;
}
```

---

## 🎯 Summary

![Image](https://algs4.cs.princeton.edu/32bst/images/bst-search.png)

![Image](https://miro.medium.com/1%2AXznnQDHcyOIeVRvE5_Rnpw.png)

![Image](https://faculty.cs.niu.edu/~mcmahon/CS241/Notes/Data_Structures/Images/inorder_rtol.png)

![Image](https://iq.opengenus.org/content/images/2019/07/treetraversal-1.png)

### 📌 Key Takeaways

- BST enables **fast lookup (O(log n))**
- Core operations:
  - Search
  - Insert
  - Delete

- Traversals are essential:
  - Inorder → Sorted output

- Advanced concepts:
  - Validation
  - Range queries
  - Path finding
  - Tree transformations

---

## 📎 Final Notes

This module demonstrates strong understanding of:

- Recursive problem solving
- Tree-based data structures
- Algorithm design and optimization

---

---

# 📘 Binary Search Tree (BST) – Complete DSA Module (Java)

![Java](https://img.shields.io/badge/Language-Java-blue)
![DSA](https://img.shields.io/badge/Data%20Structures-BST-green)
![Complexity](<https://img.shields.io/badge/Time-O(log%20n)-orange>)
![Recursion](https://img.shields.io/badge/Technique-Recursion-purple)
![Status](https://img.shields.io/badge/Project-Portfolio%20Ready-brightgreen)

---

## 📂 Project Structure (GitHub Ready)

```
BST-Java/
│
├── src/
│   ├── Main.java
│   ├── BST.java
│   ├── Node.java
│
├── README.md
└── .gitignore
```

---

## 🌳 What is a Binary Search Tree?

![Image](https://mathcenter.oxford.emory.edu/site/cs171/binarySearchTrees/vocabulary_of_trees.png)

![Image](https://algs4.cs.princeton.edu/32bst/images/bst-search.png)

![Image](https://visualgo.net/img/four_cases.png)

![Image](https://algs4.cs.princeton.edu/GrowingTree/screenshot.jpg)

A **Binary Search Tree (BST)** is a tree data structure where:

```
Left Subtree < Node < Right Subtree
```

### 🔑 Key Features

- Efficient search operations
- Sorted data via inorder traversal
- Recursive structure

---

# 🧱 Core Java Implementation

## 📌 Node Class

```java
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
```

---

## 📌 BST Class (All Operations)

```java
import java.util.*;

class BST {

    // 🔍 Search
    boolean search(Node root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;

        if (key < root.data)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    // ➕ Insert
    Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.data)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }

    // ❌ Delete
    Node delete(Node root, int key) {
        if (root == null) return null;

        if (key < root.data)
            root.left = delete(root.left, key);
        else if (key > root.data)
            root.right = delete(root.right, key);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            Node successor = findMin(root.right);
            root.data = successor.data;
            root.right = delete(root.right, successor.data);
        }
        return root;
    }

    Node findMin(Node root) {
        while (root.left != null) root = root.left;
        return root;
    }

    // 📊 Print in Range
    void printInRange(Node root, int k1, int k2) {
        if (root == null) return;

        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printInRange(root.right, k1, k2);
        } else {
            printInRange(root.left, k1, k2);
        }
    }

    // 🛤 Root to Leaf Paths
    void printPaths(Node root, List<Integer> path) {
        if (root == null) return;

        path.add(root.data);

        if (root.left == null && root.right == null) {
            System.out.println(path);
        } else {
            printPaths(root.left, path);
            printPaths(root.right, path);
        }

        path.remove(path.size() - 1);
    }

    // ✅ Validate BST
    boolean isValidBST(Node root, int min, int max) {
        if (root == null) return true;

        if (root.data <= min || root.data >= max)
            return false;

        return isValidBST(root.left, min, root.data) &&
               isValidBST(root.right, root.data, max);
    }

    // 🔁 Mirror BST
    Node mirror(Node root) {
        if (root == null) return null;

        Node left = mirror(root.left);
        Node right = mirror(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
```

---

## 🚀 Main Driver Code

```java
public class Main {
    public static void main(String[] args) {
        BST tree = new BST();
        Node root = null;

        int[] values = {8, 5, 3, 6, 10, 11, 14};

        for (int val : values) {
            root = tree.insert(root, val);
        }

        System.out.println(tree.search(root, 6)); // true

        tree.printInRange(root, 5, 10);

        tree.delete(root, 10);
    }
}
```

---

# 🔍 Detailed Problem Breakdown

---

## 🔍 1. Search in BST

### ⏱ Complexity

- Time: **O(h)** → O(log n) (balanced), O(n) (skewed)
- Space: **O(h)** (recursion stack)

---

## ➕ 2. Insert into BST

### ⏱ Complexity

- Time: **O(h)**
- Space: **O(h)**

---

## ❌ 3. Delete Node

### ⏱ Complexity

- Time: **O(h)**
- Space: **O(h)**

---

## 📊 4. Print in Range

### ⏱ Complexity

- Time: **O(n)** (worst case)
- Space: **O(h)**

---

## 🛤 5. Root to Leaf Paths

### ⏱ Complexity

- Time: **O(n)**
- Space: **O(h)**

---

## ✅ 6. Validate BST

### ⏱ Complexity

- Time: **O(n)**
- Space: **O(h)**

---

## 🔁 7. Mirror BST

### ⏱ Complexity

- Time: **O(n)**
- Space: **O(h)**

---

# 📊 Visual Summary of Operations

![Image](https://www.btechsmartclass.com/data_structures/ds_images/BST%20Construction.png)

![Image](https://baoqger.github.io/images/twochildren-delete-after.png)

![Image](https://storage.googleapis.com/algodailyrandomassets/curriculum/trees/bt-inorder-traversal-in.png)

![Image](https://storage.googleapis.com/algodailyrandomassets/curriculum/trees/bt-inorder-traversal-1.png)

---

# 🎯 Key Learning Outcomes

- Mastered **tree-based recursion**
- Understood **logarithmic performance**
- Learned **real-world data structure design**
- Built **modular, reusable Java code**

---

# 📌 How to Use (GitHub Ready)

```bash
git clone https://github.com/your-username/BST-Java.git
cd BST-Java
javac src/*.java
java src.Main
```

---

# 🏁 Final Notes

This project demonstrates:

✔ Strong understanding of **Data Structures**
✔ Clean and modular **Java design**
✔ Ability to explain **theory + implementation**
✔ Industry-level **documentation skills**

---

## ⭐ Bonus (Optional Improvements)

- Add **iterative versions**
- Add **level-order traversal (BFS)**
- Add **AVL Tree (self-balancing BST)**
- Add **JUnit tests**

---
