# Data Structures & Algorithms — Dynamic Programming in Java

<div align="center">

# 🚀 Segment Trees in Java

![Java](https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=openjdk)
![DSA](https://img.shields.io/badge/Data%20Structures%20%26%20Algorithms-Dynamic%20Programming-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Completed-success?style=for-the-badge)
![Level](https://img.shields.io/badge/Level-Intermediate%20to%20Advanced-red?style=for-the-badge)
![Research](https://img.shields.io/badge/Focus-Academic%20%26%20Research-purple?style=for-the-badge)
![Java](https://img.shields.io/badge/OOP-Java-green?style=for-the-badge)

<br>

<img src="https://images.unsplash.com/photo-1515879218367-8466d910aaa4?q=80&w=1600&auto=format&fit=crop" width="100%" />

<br>
# Segment Trees in Java — Complete Academic & Professional Guide

This module provides a complete introduction to **Segment Trees** using Java, covering:

- Segment Tree Construction
- Range Sum Queries
- Point Updates
- Maximum Segment Trees
- Range Maximum Queries
- Efficient Tree-Based Range Processing

The implementations progress from fundamental theory to advanced query/update operations used in:

- Competitive Programming
- Databases
- Game Engines
- Query Optimization Systems
- Computational Geometry
- Real-Time Analytics
- Research-Level Algorithm Design

This repository demonstrates:

- Recursive Tree Construction
- Divide and Conquer
- Logarithmic Query Optimization
- Range Query Processing
- Efficient Update Propagation
- Advanced Data Structure Design

---

# Module Contents

| Topic                     | Description                       |
| ------------------------- | --------------------------------- |
| Segment Tree Introduction | Tree-based range query structure  |
| Segment Tree Construction | Build tree for efficient querying |
| Query on Segment Tree     | Range sum queries                 |
| Update on Segment Tree    | Point updates                     |
| Max Segment Tree          | Maximum element queries           |
| Max Query + Update        | Advanced range operations         |

---

# Source Files

- Segment Tree Construction →
- Segment Tree Query →
- Segment Tree Update →
- Max Segment Tree →

---

# 1. Introduction to Segment Trees

A Segment Tree is a binary tree used for:

- Range Queries
- Efficient Updates

Unlike brute force solutions:

```text id="g2um9v"
O(n)
```

Segment Trees perform operations in:

O(\log n)

---

# Why Segment Trees?

Suppose we need to repeatedly:

- Find sum in a range
- Find maximum in a range
- Update elements dynamically

Brute force becomes inefficient.

Segment Trees solve this efficiently.

---

# Tree Representation

For node at index `i`:

```text id="c2w7n0"
Left Child  = 2*i + 1
Right Child = 2*i + 2
```

---

# Space Requirement

Segment Tree array size:

4 \times n

---

# 2. Segment Tree Construction

Source File:

---

# Problem Statement

Construct a Segment Tree for:

```text id="pjlwmr"
Range Sum Queries
```

---

# Example

```text id="fgm4sk"
arr[] = {1, 2, 3, 4, 5, 6, 7, 8}
```

---

# Theory

Each node stores:

```text id="j0df2v"
sum of a segment
```

Leaf nodes store individual elements.

Internal nodes store:

leftSum + rightSum

---

# Recursive Construction

1. Divide array into two halves
2. Build left subtree
3. Build right subtree
4. Store combined result

---

# Pseudocode

```text id="6d4m5y"
buildST(i, start, end):

    if start == end:
        tree[i] = arr[start]
        return

    mid = (start + end) / 2

    build left subtree
    build right subtree

    tree[i] = left + right
```

---

# Complexity Analysis

| Operation  | Complexity |
| ---------- | ---------- |
| Build Tree | O(n)       |
| Space      | O(4n)      |

---

# Java Implementation

See full implementation:

---

# 3. Query on Segment Tree

Source File:

---

# Problem Statement

Find sum of elements in a range:

```text id="d3tgvs"
[qi, qj]
```

---

# Example

```text id="95b3u2"
Query: sum from index 2 to 5
```

---

# Query Cases

Segment Tree queries operate using 3 overlap conditions.

---

# Case 1: No Overlap

If current segment lies completely outside query range:

```text id="z1ry82"
return 0
```

---

# Case 2: Complete Overlap

If current segment lies completely inside query range:

```text id="ehl0qc"
return tree[i]
```

---

# Case 3: Partial Overlap

Split into left and right subtrees.

Combine results.

---

# Recursive Formula

Query(left)+Query(right)

---

# Pseudocode

```text id="c7bg9h"
getSum(i, si, sj, qi, qj):

    if no overlap:
        return 0

    if complete overlap:
        return tree[i]

    return leftQuery + rightQuery
```

---

# Complexity Analysis

| Operation   | Complexity |
| ----------- | ---------- |
| Range Query | O(log n)   |

---

# Java Implementation

See full implementation:

---

# 4. Update on Segment Tree

Source File:

---

# Problem Statement

Update an element at index:

```text id="9ylzba"
idx
```

and propagate changes efficiently.

---

# Example

```text id="i8zw6v"
arr[2] = 2
```

---

# Theory

Instead of rebuilding the entire tree:

- Update only affected nodes
- Propagate difference upward

---

# Difference Concept

diff = newValue - oldValue

---

# Update Logic

1. Find affected segment
2. Add difference
3. Recursively update ancestors

---

# Pseudocode

```text id="tyn2gc"
updateUtil(i, si, sj, idx, diff):

    if idx outside range:
        return

    tree[i] += diff

    recurse left
    recurse right
```

---

# Complexity Analysis

| Operation    | Complexity |
| ------------ | ---------- |
| Point Update | O(log n)   |

---

# Java Implementation

See full implementation:

---

# 5. Maximum Segment Tree

Source File:

---

# Problem Statement

Perform:

- Range Maximum Queries
- Point Updates

efficiently.

---

# Example

```text id="bjlwmu"
arr[] = {6, 8, -1, 2, 17, 1, 3, 2, 4}
```

---

# Theory

Instead of storing sums:

Each node stores:

```text id="0m4v0f"
maximum value in segment
```

---

# Recursive Relation

tree[i]=\max(left,right)

---

# Query Cases

Same 3 overlap cases apply:

- No Overlap
- Complete Overlap
- Partial Overlap

---

# No Overlap Return Value

For maximum queries:

```text id="4l9m2v"
Integer.MIN_VALUE
```

---

# Pseudocode

```text id="a4vxr6"
getMax(i, si, sj, qi, qj):

    if no overlap:
        return -INF

    if complete overlap:
        return tree[i]

    return max(left, right)
```

---

# Update Logic

After updating child:

Recompute current node using:

max(leftChild,rightChild)

---

# Complexity Analysis

| Operation  | Complexity |
| ---------- | ---------- |
| Build Tree | O(n)       |
| Max Query  | O(log n)   |
| Update     | O(log n)   |

---

# Java Implementation

See full implementation:

---

# 6. Segment Tree Design Strategy

---

# Step 1: Define Segment

Each node stores information about:

```text id="ff1we1"
[start, end]
```

---

# Step 2: Define Merge Operation

Examples:

| Query Type | Merge Operation  |
| ---------- | ---------------- |
| Sum Query  | left + right     |
| Max Query  | max(left, right) |
| Min Query  | min(left, right) |

---

# Step 3: Define Base Case

Leaf node:

```text id="f8r0f8"
start == end
```

---

# Step 4: Recursive Divide & Conquer

Split segment into:

```text id="6m06jv"
[start, mid]
[mid+1, end]
```

---

# 7. Important Observations

---

# Why Segment Trees are Efficient

Instead of traversing entire array:

- Only relevant segments are visited
- Tree height remains logarithmic

---

# Segment Tree Height

O(\log n)

---

# Number of Nodes

Approximate maximum nodes:

4n

---

# 8. Research & Industry Perspective

Segment Trees are widely used in:

- Database Query Optimization
- Real-Time Analytics
- Computational Geometry
- GIS Systems
- Game Development
- Financial Systems
- Interval Scheduling
- Competitive Programming
- Streaming Systems

---

# 9. Advanced Extensions

After mastering standard Segment Trees:

Advanced topics include:

- Lazy Propagation
- Persistent Segment Trees
- 2D Segment Trees
- Dynamic Segment Trees
- Merge Sort Trees
- Fenwick Trees (BIT)
- Sparse Segment Trees

---

# 10. Conclusion

This module provides a strong foundation in:

- Tree-Based Data Structures
- Recursive Divide & Conquer
- Efficient Range Queries
- Logarithmic Updates
- Optimization Techniques

The implementations demonstrate how Segment Trees transform:

```text id="j1s7vg"
O(n) brute force operations
```

into:

O(\log n)

efficient query/update systems.

This knowledge is fundamental for:

- Advanced Algorithms
- Competitive Programming
- System Design
- Research
- Real-Time Processing Systems
- High-Performance Software Engineering
