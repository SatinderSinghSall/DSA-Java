# Data Structure and Algorithms: DSA - Java

## 🌳 Binary Trees (Part 2) – DSA

![Java](https://img.shields.io/badge/Language-Java-blue)
![DSA](https://img.shields.io/badge/Topic-Data%20Structures-green)
![Level](https://img.shields.io/badge/Level-Intermediate-orange)
![Status](https://img.shields.io/badge/Progress-Completed-brightgreen)

---

## 📌 Overview

This repository contains implementations of important **Binary Tree problems** with a focus on:

- Recursive problem solving
- Optimization techniques
- Tree traversal strategies (DFS & BFS)
- Interview-oriented approaches

---

---

## 📂 Files Included

- ## Diameter (Multiple Approaches)
  - DiameterOfaTree.java

- ## Subtree Problem
  - SubtreeOfAnotherTree.java

- ## Top View Problem
  - TopViewOfTree.java

---

## 🧠 Concepts Covered

- Tree Construction
- Height, Count, Sum
- Diameter (Brute Force & Optimized)
- Subtree Checking
- Top View (Level Order + Hashing)

---

# 🌳 Tree Used in Examples

![Image](https://miro.medium.com/v2/resize%3Afit%3A1400/0%2Ad6-ghEeRxKbv47S_.png)

![Image](https://deen3evddmddt.cloudfront.net/uploads/content-images/binary-tree-in-dsa.webp)

![Image](https://www.crio.do/blog/content/images/2022/02/Diagram-of-Binary-Tree.png)

![Image](https://upload.wikimedia.org/wikipedia/commons/5/5e/Binary_tree_v2.svg)

---

# 📂 Project Structure

```bash
BinaryTrees/
│
├── DiameterOfaTree.java        # Tree building + diameter
├── DiameterOfaTree2.java       # Manual tree + diameter
├── DiameterOfaTree3.java       # Height, Count, Sum
├── DiameterOfaTree4.java       # Optimized diameter (O(n))
├── SubtreeOfAnotherTree.java   # Subtree check
├── TopViewOfTree.java          # Top view using BFS
```

---

# 🧮 1. Diameter of Binary Tree

---

## 📌 Problem

Find the **longest path between any two nodes** in a binary tree.

---

## 🧠 Intuition

At each node:

```
Diameter = max(
    left diameter,
    right diameter,
    left height + right height + 1
)
```

---

## ⚙️ Algorithm (Brute Force)

1. Calculate height of left subtree
2. Calculate height of right subtree
3. Compute diameter through root
4. Recursively compute left & right diameter

---

## 📝 Pseudocode

```text
diameter(root):
    if root == null:
        return 0

    leftD = diameter(root.left)
    rightD = diameter(root.right)

    leftH = height(root.left)
    rightH = height(root.right)

    return max(leftH + rightH + 1, leftD, rightD)
```

---

## 💻 Code Reference

👉

---

## ⚡ Optimized Approach (O(n))

---

## 🧠 Idea

Return **both height & diameter together**.

---

## 📝 Pseudocode

```text
diameter2(root):
    if root == null:
        return (0, 0)

    left = diameter2(root.left)
    right = diameter2(root.right)

    height = max(left.height, right.height) + 1

    diameter = max(
        left.height + right.height + 1,
        left.diameter,
        right.diameter
    )

    return (diameter, height)
```

---

## 💻 Code Reference

👉

---

## 📊 Complexity

| Approach    | Time  | Space |
| ----------- | ----- | ----- |
| Brute Force | O(n²) | O(h)  |
| Optimized   | O(n)  | O(h)  |

---

# 🌲 2. Subtree of Another Tree

---

## 📌 Problem

Check whether a binary tree **subRoot** is a subtree of another tree **root**.

---

## 🧠 Intuition

- Traverse main tree
- When values match → compare full structure

---

## ⚙️ Algorithm

1. Traverse root
2. If node matches → check identical
3. Otherwise recurse left & right

---

## 📝 Pseudocode

```text
isSubtree(root, subRoot):
    if root == null:
        return false

    if root.data == subRoot.data:
        if isIdentical(root, subRoot):
            return true

    return isSubtree(root.left, subRoot) OR
           isSubtree(root.right, subRoot)
```

---

## 💻 Code Reference

👉

---

## 📊 Complexity

- Time: O(n × m)
- Space: O(h)

---

# 🌄 3. Top View of Binary Tree

---

## 📌 Problem

Print nodes visible from the **top view** of a binary tree.

---

## 🧠 Intuition

Use **Horizontal Distance (HD)**:

- Root → 0
- Left → -1
- Right → +1

Store the **first node at each HD**.

---

## ⚙️ Algorithm

1. Use BFS (Queue)
2. Track HD
3. Store first occurrence in HashMap
4. Print from min → max HD

---

## 📝 Pseudocode

```text
topView(root):
    queue ← [(root, 0)]
    map ← empty

    while queue not empty:
        node, hd = dequeue

        if hd not in map:
            map[hd] = node

        enqueue left (hd - 1)
        enqueue right (hd + 1)

    print nodes from min to max hd
```

---

## 💻 Code Reference

👉

---

## 📊 Complexity

- Time: O(n)
- Space: O(n)

---

# 🧩 Key Patterns Learned

- 🔁 Recursion on Trees
- 📦 Returning multiple values (Info class)
- 🌐 BFS + HashMap usage
- ⚡ Optimization (O(n²) → O(n))
- 🌍 Horizontal Distance concept

---

# 🎯 Interview Readiness

After this module, you can:

✔ Solve tree recursion problems
✔ Optimize brute force solutions
✔ Handle BFS + mapping problems
✔ Explain time/space complexity clearly

---

# 🚀 Next Topics

- Bottom View of Tree
- Vertical Order Traversal
- Lowest Common Ancestor (LCA)
- Balanced Binary Tree

---

# ⭐ Final Note

This module builds a **strong foundation in trees**, which is one of the most important topics for coding interviews.

---

# 📘 Binary Trees (Part 2) – DSA Module

This repository contains implementations and theoretical explanations of core **Binary Tree problems**, following a structured progression from basic traversal concepts to optimized recursive solutions.

---

## 📂 Files Included

- ## Diameter (Multiple Approaches)
  - DiameterOfaTree.java

- ## Subtree Problem
  - SubtreeOfAnotherTree.java

- ## Top View Problem
  - TopViewOfTree.java

---

# 🌳 1. Diameter of a Binary Tree

---

## 📌 Problem

The **diameter** of a binary tree is the **number of nodes on the longest path between any two nodes**.

---

## 🧠 Key Idea

For every node:

- Path may pass through the node
- Or lie entirely in left subtree
- Or right subtree

---

## ⚙️ Algorithm (Brute Force – O(n²))

1. Compute height of left subtree
2. Compute height of right subtree
3. Diameter through root = `lh + rh + 1`
4. Recursively compute left & right diameter
5. Return maximum

---

## 📝 Pseudocode

```
function diameter(root):
    if root is null:
        return 0

    leftDiameter = diameter(root.left)
    rightDiameter = diameter(root.right)

    leftHeight = height(root.left)
    rightHeight = height(root.right)

    selfDiameter = leftHeight + rightHeight + 1

    return max(selfDiameter, leftDiameter, rightDiameter)
```

---

## 💻 Code

From your implementation:

```java
public static int diameter(Node root) {
    if (root == null) {
        return 0;
    }

    int leftDiameter = diameter(root.left);
    int rightDiameter = diameter(root.right);

    int leftHeight = height(root.left);
    int rightHeight = height(root.right);

    int selfDiameter = leftHeight + rightHeight + 1;

    return Math.max(selfDiameter, Math.max(leftDiameter, rightDiameter));
}
```

---

## ⚡ Optimized Approach – O(n)

---

## 🧠 Key Idea

Return **height + diameter together** using a helper class.

---

## 📝 Pseudocode

```
function diameter2(root):
    if root is null:
        return (0, 0)

    left = diameter2(root.left)
    right = diameter2(root.right)

    height = max(left.height, right.height) + 1

    diameter = max(
        left.height + right.height + 1,
        left.diameter,
        right.diameter
    )

    return (diameter, height)
```

---

## 💻 Code

From your optimized implementation:

```java
public static Info diameter2(Node root) {
    if (root == null) {
        return new Info(0, 0);
    }

    Info leftInfo = diameter2(root.left);
    Info rightInfo = diameter2(root.right);

    int height = Math.max(leftInfo.height, rightInfo.height) + 1;

    int selfDiameter = leftInfo.height + rightInfo.height + 1;

    int diameter = Math.max(selfDiameter,
            Math.max(leftInfo.diameter, rightInfo.diameter));

    return new Info(diameter, height);
}
```

---

## 📊 Complexity

| Approach    | Time  | Space |
| ----------- | ----- | ----- |
| Brute Force | O(n²) | O(h)  |
| Optimized   | O(n)  | O(h)  |

---

# 🌲 2. Subtree of Another Tree

---

## 📌 Problem

Determine whether a tree **subRoot** exists as a subtree within another tree **root**.

---

## 🧠 Key Idea

- Traverse main tree
- When node matches, check if trees are identical

---

## ⚙️ Algorithm

1. Traverse root
2. If node matches subRoot → check identical
3. Otherwise search left and right

---

## 📝 Pseudocode

```
function isSubtree(root, subRoot):
    if root is null:
        return false

    if root.data == subRoot.data:
        if isIdentical(root, subRoot):
            return true

    return isSubtree(root.left, subRoot) OR
           isSubtree(root.right, subRoot)
```

---

## 💻 Code

From your file:

```java
public static boolean isSubtree(Node root, Node subRoot) {
    if (root == null) {
        return false;
    }

    if (root.data == subRoot.data) {
        if (isIdentical(root, subRoot)) {
            return true;
        }
    }

    return isSubtree(root.left, subRoot) ||
           isSubtree(root.right, subRoot);
}
```

---

## 📊 Complexity

- Time: **O(n × m)**
- Space: **O(h)**

---

# 🌄 3. Top View of Binary Tree

---

## 📌 Problem

Print nodes visible when the tree is viewed from the **top**.

---

## 🧠 Key Idea

- Use **Horizontal Distance (HD)**
- Use **BFS (Level Order)**
- Store first node at each HD

---

## ⚙️ Algorithm

1. Use Queue for BFS
2. Track HD
3. Store first occurrence in HashMap
4. Print from min HD to max HD

---

## 📝 Pseudocode

```
function topView(root):
    queue ← [(root, 0)]
    map ← empty

    while queue not empty:
        node, hd = dequeue

        if hd not in map:
            map[hd] = node

        enqueue left with hd - 1
        enqueue right with hd + 1

    print map from min to max hd
```

---

## 💻 Code

From your file:

```java
public static void topView(Node root) {
    Queue<Info> q = new LinkedList<>();
    HashMap<Integer, Node> map = new HashMap<>();

    int min = 0, max = 0;

    q.add(new Info(root, 0));
    q.add(null);

    while (!q.isEmpty()) {
        Info curr = q.remove();

        if (curr == null) {
            if (q.isEmpty()) break;
            else q.add(null);
        } else {
            if (!map.containsKey(curr.hd)) {
                map.put(curr.hd, curr.node);
            }

            if (curr.node.left != null) {
                q.add(new Info(curr.node.left, curr.hd - 1));
                min = Math.min(min, curr.hd - 1);
            }

            if (curr.node.right != null) {
                q.add(new Info(curr.node.right, curr.hd + 1));
                max = Math.max(max, curr.hd + 1);
            }
        }
    }

    for (int i = min; i <= max; i++) {
        System.out.print(map.get(i).data + " ");
    }
}
```

---

## 📊 Complexity

- Time: **O(n)**
- Space: **O(n)**

---

# 🧩 Supporting Concepts Covered

From your progression:

- Tree construction using recursion
- DFS vs BFS
- Recursion design patterns
- Combining multiple values (Info class)
- Horizontal Distance (HD) concept

---

# 🎯 Learning Outcomes

After completing this module, you can:

✔ Understand recursive tree problems
✔ Convert brute force → optimized solutions
✔ Use BFS with HashMap
✔ Solve standard interview problems
✔ Analyze time complexity

---

# 🚀 Next Recommended Topics

- Bottom View of Tree
- Vertical Order Traversal
- Lowest Common Ancestor (LCA)
- Balanced Binary Tree

---
