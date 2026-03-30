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
