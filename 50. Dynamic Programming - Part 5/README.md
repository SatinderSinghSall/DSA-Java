# Data Structures & Algorithms — Dynamic Programming in Java

<div align="center">

# 🚀 Dynamic Programming in Java

### From Recursive Thinking → Memoization → Advanced DP Optimization

![Java](https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=openjdk)
![DSA](https://img.shields.io/badge/Data%20Structures%20%26%20Algorithms-Dynamic%20Programming-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Completed-success?style=for-the-badge)
![Level](https://img.shields.io/badge/Level-Intermediate%20to%20Advanced-red?style=for-the-badge)
![Research](https://img.shields.io/badge/Focus-Academic%20%26%20Research-purple?style=for-the-badge)
![Java](https://img.shields.io/badge/OOP-Java-green?style=for-the-badge)

<br>

<img src="https://images.unsplash.com/photo-1515879218367-8466d910aaa4?q=80&w=1600&auto=format&fit=crop" width="100%" />

<br>

# Dynamic Programming (Part 5) — Professional README Guide in Java

This module focuses on advanced Dynamic Programming concepts and classic combinatorial problems implemented in Java. The topics include recursive solutions, memoization (top-down DP), and tabulation (bottom-up DP) approaches. The implementations cover pattern matching, Catalan number applications, counting Binary Search Trees, and Mountain Range problems. The codebase demonstrates the transition from brute-force recursive solutions to optimized dynamic programming solutions. The uploaded implementations include professional Java code structures with detailed comments and complexity analysis.

---

# Table of Contents

1. Introduction to Dynamic Programming
2. Wildcard Matching
3. Catalan Numbers
4. Count BSTs
5. Mountain Ranges
6. Recursion vs Memoization vs Tabulation
7. Time and Space Complexity Analysis
8. Key Learning Outcomes
9. References

---

# 1. Introduction to Dynamic Programming

Dynamic Programming (DP) is an optimization technique used to solve problems that exhibit:

- Overlapping Subproblems
- Optimal Substructure

The main objective of DP is to reduce redundant recursive calls by storing already computed results.

---

# Dynamic Programming Approaches

| Approach    | Description                                   |
| ----------- | --------------------------------------------- |
| Recursion   | Solves problem using repeated recursive calls |
| Memoization | Top-down DP using caching                     |
| Tabulation  | Bottom-up DP using iterative tables           |

---

# 2. Wildcard Matching

## Problem Statement

Given a text string and a wildcard pattern, determine whether the pattern matches the entire text.

### Wildcard Characters

| Symbol | Meaning                            |
| ------ | ---------------------------------- |
| `?`    | Matches any single character       |
| `*`    | Matches any sequence of characters |

Example:

```text
Text    = "baaabab"
Pattern = "*****ba*****ab"

Output = true
```

Implementation reference:

---

# Theory

Wildcard matching is a classical Dynamic Programming problem involving string pattern matching.

The challenge arises because:

- `?` matches exactly one character
- `*` may represent:
  - Empty string
  - One character
  - Multiple characters

This creates multiple recursive branching possibilities.

---

# Recursive Strategy

## Cases

### Case 1: Characters Match

```text
s[i] == p[j]
```

or

```text
p[j] == '?'
```

Move diagonally:

```text
(i-1, j-1)
```

---

### Case 2: Star Encountered

```text
p[j] == '*'
```

Two possibilities:

1. Ignore `*`
2. Match one character

---

# Recursive Formula

If:

```text
p[j] == '*'
```

Then:

```text
match(i, j) =
match(i, j-1)
OR
match(i-1, j)
```

---

# Pseudocode

```text
function wildcardMatch(s, p, n, m):

    if n == 0 and m == 0:
        return true

    if pattern exhausted:
        return false

    if string exhausted:
        check remaining pattern contains only '*'

    if characters match OR '?':
        return match(n-1, m-1)

    if '*':
        return match(n, m-1)
               OR
               match(n-1, m)

    return false
```

---

# Algorithms Used

## 1. Recursion

Brute force recursive exploration.

## 2. Memoization

Stores repeated states using DP matrix.

## 3. Tabulation

Builds DP table iteratively.

---

# Complexity Analysis

| Approach    | Time Complexity | Space Complexity |
| ----------- | --------------- | ---------------- |
| Recursion   | Exponential     | O(n + m)         |
| Memoization | O(n × m)        | O(n × m)         |
| Tabulation  | O(n × m)        | O(n × m)         |

---

# Code

See complete implementation in:

---

# 3. Catalan Numbers

## Problem Statement

Find the nth Catalan Number.

Catalan numbers appear in many combinatorial mathematics problems.

Implementation reference:

---

# Theory

Catalan numbers follow the recurrence relation:

C*n = \sum*{i=0}^{n-1} C*i \times C*{n-i-1}

Base cases:

```text
C0 = 1
C1 = 1
```

---

# Applications of Catalan Numbers

Catalan numbers are used in:

- Counting BSTs
- Parenthesis matching
- Mountain ranges
- Polygon triangulation
- Binary tree structures

---

# Recursive Idea

Choose each index as root and recursively compute:

- Left structures
- Right structures

Multiply both counts.

---

# Pseudocode

```text
function catalan(n):

    if n == 0 or n == 1:
        return 1

    ans = 0

    for i from 0 to n-1:
        ans += catalan(i) *
               catalan(n-i-1)

    return ans
```

---

# Approaches Implemented

| Approach    | Description           |
| ----------- | --------------------- |
| Recursion   | Brute force recursion |
| Memoization | DP caching            |
| Tabulation  | Bottom-up computation |

---

# Complexity Analysis

| Approach    | Time Complexity | Space Complexity |
| ----------- | --------------- | ---------------- |
| Recursion   | Exponential     | O(n)             |
| Memoization | O(n²)           | O(n)             |
| Tabulation  | O(n²)           | O(n)             |

---

# Code

See implementation:

---

# 4. Count BSTs

## Problem Statement

Find the number of unique Binary Search Trees possible using `n` nodes.

Implementation reference:

---

# Theory

This problem directly follows the Catalan Number pattern.

For every node:

- Left subtree uses smaller elements
- Right subtree uses larger elements

If root is selected:

```text
Left Subtree  -> i nodes
Right Subtree -> n-i-1 nodes
```

Total BSTs:

BST(n)=\sum\_{i=0}^{n-1} BST(i) \times BST(n-i-1)

---

# Pseudocode

```text
function countBST(n):

    if n == 0 or n == 1:
        return 1

    ans = 0

    for i from 0 to n-1:

        left = countBST(i)
        right = countBST(n-i-1)

        ans += left * right

    return ans
```

---

# Complexity Analysis

| Approach    | Time Complexity | Space Complexity |
| ----------- | --------------- | ---------------- |
| Recursion   | Exponential     | O(n)             |
| Memoization | O(n²)           | O(n)             |
| Tabulation  | O(n²)           | O(n)             |

---

# Code

See implementation:

---

# 5. Mountain Ranges

## Problem Statement

Find the number of valid mountain ranges using `n` up-strokes and `n` down-strokes.

Condition:

At no point should down-strokes exceed up-strokes.

Implementation reference:

---

# Theory

This problem is another direct application of Catalan Numbers.

A valid mountain range behaves similarly to balanced parentheses.

---

# Catalan Relation

MR(n)=\sum\_{i=0}^{n-1} MR(i) \times MR(n-i-1)

---

# Pseudocode

```text
function mountainRange(n):

    if n == 0 or n == 1:
        return 1

    ans = 0

    for i from 0 to n-1:

        inside = mountainRange(i)
        outside = mountainRange(n-i-1)

        ans += inside * outside

    return ans
```

---

# Complexity Analysis

| Approach    | Time Complexity | Space Complexity |
| ----------- | --------------- | ---------------- |
| Recursion   | Exponential     | O(n)             |
| Memoization | O(n²)           | O(n)             |
| Tabulation  | O(n²)           | O(n)             |

---

# Code

See implementation:

---

# 6. Recursion vs Memoization vs Tabulation

| Feature         | Recursion   | Memoization | Tabulation |
| --------------- | ----------- | ----------- | ---------- |
| Direction       | Top-down    | Top-down    | Bottom-up  |
| Repeated Calls  | Yes         | No          | No         |
| Speed           | Slow        | Fast        | Fastest    |
| Space Usage     | Stack-heavy | Moderate    | Efficient  |
| Ease of Writing | Easy        | Moderate    | Moderate   |

---

# 7. Key Dynamic Programming Insights

## Overlapping Subproblems

Repeated recursive states are recalculated multiple times.

DP stores results to eliminate recomputation.

---

# Optimal Substructure

The optimal solution depends on solutions of smaller subproblems.

---

# DP Transition

General DP workflow:

1. Define state
2. Identify recurrence relation
3. Handle base cases
4. Optimize overlapping calls
5. Build final solution

---

# 8. Academic Learning Outcomes

After completing this module, the learner understands:

- Recursive problem solving
- Dynamic Programming optimization
- Top-down and bottom-up DP
- String matching problems
- Catalan Number applications
- Combinatorial counting problems
- Complexity optimization
- State transition design

---

# 9. Files Included

| File                    | Description                        |
| ----------------------- | ---------------------------------- |
| `WildcardMatching.java` | Wildcard pattern matching using DP |
| `CatalanNumber.java`    | Catalan number implementations     |
| `CountBSTs.java`        | Counting unique BSTs               |
| `MountainRanges.java`   | Mountain range combinatorics       |
| `Main.java`             | Java execution template            |

References:

---

# Conclusion

This module demonstrates how Dynamic Programming transforms inefficient recursive solutions into optimized polynomial-time algorithms. The problems explored in this section showcase important DP patterns frequently used in:

- Competitive Programming
- Software Engineering Interviews
- Algorithm Design
- Research in Combinatorics
- Computational Optimization

The implementations provide a complete academic and professional understanding of advanced Dynamic Programming concepts using Java.

---

# 🚀 Dynamic Programming in Java — Part 5

<div align="center">

Advanced Dynamic Programming Concepts, Algorithms, and Optimized Implementations in Java.

---

![Java](https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=java)
![DSA](https://img.shields.io/badge/Topic-Dynamic_Programming-blue?style=for-the-badge)
![Algorithms](https://img.shields.io/badge/Algorithms-Advanced-success?style=for-the-badge)
![Difficulty](https://img.shields.io/badge/Level-Intermediate_to_Advanced-red?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge)

</div>

---

# 📚 Overview

This repository contains advanced Dynamic Programming problems implemented in Java using:

- ✅ Recursion
- ✅ Memoization (Top-Down DP)
- ✅ Tabulation (Bottom-Up DP)

The project focuses on understanding:

- Overlapping Subproblems
- Optimal Substructure
- Recursive Decomposition
- State Transitions
- DP Table Construction
- Combinatorial Dynamic Programming

---

# 🎯 Learning Objectives

After completing this module, you will understand:

- Advanced Dynamic Programming techniques
- Recursive problem solving
- Top-Down DP optimization
- Bottom-Up DP construction
- Catalan Number applications
- String Pattern Matching
- Combinatorial counting problems
- Complexity optimization
- State transition design

---

# 🧠 Dynamic Programming Workflow

```text
Recursion
   ↓
Overlapping Subproblems
   ↓
Memoization
   ↓
Tabulation
   ↓
Space Optimization
```

---

# 📂 Project Structure

```bash
Dynamic-Programming-Part5/
│
├── WildcardMatching.java
├── CatalanNumber.java
├── CountBSTs.java
├── MountainRanges.java
├── Main.java
└── README.md
```

---

# ⚡ Dynamic Programming Concepts

| Concept                 | Description                                    |
| ----------------------- | ---------------------------------------------- |
| Recursion               | Solving problems using recursive decomposition |
| Memoization             | Caching repeated recursive states              |
| Tabulation              | Iterative bottom-up solution                   |
| Optimal Substructure    | Solution depends on smaller subproblems        |
| Overlapping Subproblems | Same subproblem solved multiple times          |

---

# 🔥 Problems Covered

| #   | Problem           | Techniques                         |
| --- | ----------------- | ---------------------------------- |
| 1   | Wildcard Matching | Recursion, Memoization, Tabulation |
| 2   | Catalan Number    | Recursion, Memoization, Tabulation |
| 3   | Count BSTs        | Catalan DP                         |
| 4   | Mountain Ranges   | Catalan DP                         |

---

---

# 1️⃣ Wildcard Matching

# 📌 Problem Statement

Given a text and a wildcard pattern, determine whether the pattern matches the entire string.

### Wildcard Characters

| Symbol | Meaning                            |
| ------ | ---------------------------------- |
| `?`    | Matches any single character       |
| `*`    | Matches any sequence of characters |

---

# 🧩 Example

```text
Text    = "baaabab"
Pattern = "*****ba*****ab"

Output = true
```

---

# 🧠 Theory

Wildcard Matching is a classical Dynamic Programming problem.

The challenge occurs because:

- `?` can match exactly one character
- `*` can match:
  - Empty sequence
  - Single character
  - Multiple characters

This creates multiple recursive possibilities.

---

# 🔄 Recursive Transition

If characters match:

```text
s[i] == p[j]
OR
p[j] == '?'
```

Move diagonally:

```text
(i-1, j-1)
```

---

If pattern contains `*`:

```text
match(i, j) =
match(i, j-1)
OR
match(i-1, j)
```

---

# 📖 Pseudocode

```text
function wildcardMatch(s, p, n, m):

    if n == 0 and m == 0:
        return true

    if pattern exhausted:
        return false

    if string exhausted:
        check remaining pattern contains only '*'

    if characters match OR '?':
        return match(n-1, m-1)

    if '*':
        return match(n, m-1)
               OR
               match(n-1, m)

    return false
```

---

# ⏱ Complexity Analysis

| Approach    | Time Complexity | Space Complexity |
| ----------- | --------------- | ---------------- |
| Recursion   | Exponential     | O(n + m)         |
| Memoization | O(n × m)        | O(n × m)         |
| Tabulation  | O(n × m)        | O(n × m)         |

---

# 💻 Java Code

```java
// Wildcard Matching Java Implementation
// Recursion + Memoization + Tabulation
```

---

# 🌍 Real-World Applications

- Search engines
- File system pattern matching
- Linux wildcard expansion
- Regex engines
- Text filtering systems

---

---

# 2️⃣ Catalan Numbers

# 📌 Problem Statement

Find the nth Catalan Number.

---

# 🧠 Theory

Catalan Numbers appear in many combinatorial mathematics problems.

## Formula

\[
C*n = \sum*{i=0}^{n-1} C*i \times C*{n-i-1}
\]

---

# 📖 Base Cases

```text
C0 = 1
C1 = 1
```

---

# 🧩 Example

```text
C2 = C0.C1 + C1.C0 = 2

C3 = C0.C2 + C1.C1 + C2.C0 = 5
```

---

# 📖 Pseudocode

```text
function catalan(n):

    if n == 0 or n == 1:
        return 1

    ans = 0

    for i from 0 to n-1:
        ans += catalan(i) *
               catalan(n-i-1)

    return ans
```

---

# ⏱ Complexity Analysis

| Approach    | Time Complexity | Space Complexity |
| ----------- | --------------- | ---------------- |
| Recursion   | Exponential     | O(n)             |
| Memoization | O(n²)           | O(n)             |
| Tabulation  | O(n²)           | O(n)             |

---

# 💻 Java Code

```java
// Catalan Number Java Implementation
// Recursion + Memoization + Tabulation
```

---

# 🌍 Applications of Catalan Numbers

Catalan Numbers are used in:

- Counting BSTs
- Parentheses balancing
- Mountain ranges
- Polygon triangulation
- Binary tree structures
- Compiler parsing

---

---

# 3️⃣ Count BSTs

# 📌 Problem Statement

Find the number of unique Binary Search Trees possible using `n` nodes.

---

# 🧠 Theory

This problem directly follows the Catalan Number pattern.

For every root:

- Left subtree contains smaller elements
- Right subtree contains larger elements

Total BSTs:

\[
BST(n)=\sum\_{i=0}^{n-1} BST(i) \times BST(n-i-1)
\]

---

# 📖 Pseudocode

```text
function countBST(n):

    if n == 0 or n == 1:
        return 1

    ans = 0

    for i from 0 to n-1:

        left = countBST(i)
        right = countBST(n-i-1)

        ans += left * right

    return ans
```

---

# ⏱ Complexity Analysis

| Approach    | Time Complexity | Space Complexity |
| ----------- | --------------- | ---------------- |
| Recursion   | Exponential     | O(n)             |
| Memoization | O(n²)           | O(n)             |
| Tabulation  | O(n²)           | O(n)             |

---

# 💻 Java Code

```java
// Count BSTs Java Implementation
// Recursion + Memoization + Tabulation
```

---

# 🌍 Real-World Applications

- Database indexing
- Search optimization
- Binary search tree analysis
- AI decision trees

---

---

# 4️⃣ Mountain Ranges

# 📌 Problem Statement

Find the number of valid mountain ranges using `n` up-strokes and `n` down-strokes.

---

# 📌 Rule

At no point should down-strokes exceed up-strokes.

---

# 🧠 Theory

This problem is another application of Catalan Numbers.

It behaves similarly to balanced parentheses.

---

# 📖 Formula

\[
MR(n)=\sum\_{i=0}^{n-1} MR(i) \times MR(n-i-1)
\]

---

# 📖 Pseudocode

```text
function mountainRange(n):

    if n == 0 or n == 1:
        return 1

    ans = 0

    for i from 0 to n-1:

        inside = mountainRange(i)
        outside = mountainRange(n-i-1)

        ans += inside * outside

    return ans
```

---

# ⏱ Complexity Analysis

| Approach    | Time Complexity | Space Complexity |
| ----------- | --------------- | ---------------- |
| Recursion   | Exponential     | O(n)             |
| Memoization | O(n²)           | O(n)             |
| Tabulation  | O(n²)           | O(n)             |

---

# 💻 Java Code

```java
// Mountain Ranges Java Implementation
// Recursion + Memoization + Tabulation
```

---

# 🌍 Real-World Applications

- Balanced structures
- Compiler parsing
- Expression validation
- Syntax tree generation

---

# 📊 Recursion vs Memoization vs Tabulation

| Feature        | Recursion   | Memoization | Tabulation |
| -------------- | ----------- | ----------- | ---------- |
| Direction      | Top-Down    | Top-Down    | Bottom-Up  |
| Speed          | Slow        | Fast        | Fastest    |
| Repeated Calls | Yes         | No          | No         |
| Space Usage    | Stack-heavy | Moderate    | Efficient  |
| Optimization   | ❌          | ✅          | ✅         |

---

# 🏗 DP State Transition Strategy

```text
1. Define State
2. Identify Recurrence Relation
3. Handle Base Cases
4. Optimize Repeated Calls
5. Construct DP Table
6. Return Final Answer
```

---

# 💼 Interview Relevance

These problems are frequently asked in:

- Google
- Amazon
- Microsoft
- Adobe
- Atlassian
- Goldman Sachs
- Uber
- Flipkart

---

# 🔬 Academic Perspective

This repository demonstrates:

- Recursive decomposition
- Combinatorial mathematics
- State transition systems
- Polynomial-time optimization
- Computational complexity analysis
- Dynamic Programming theory

The implementations are suitable for:

- University coursework
- Research preparation
- Technical interviews
- Competitive programming
- Algorithmic studies

---

# 🚀 Future Improvements

Potential future additions:

- Matrix Chain Multiplication
- DP on Trees
- Bitmask DP
- Digit DP
- Space Optimized DP
- Advanced Graph DP

---

# 🤝 Contributions

Contributions, optimizations, and improvements are welcome.

Feel free to:

- Fork the repository
- Improve algorithms
- Add optimizations
- Enhance documentation
- Submit pull requests

---

# 📜 License

This project is licensed under the MIT License.

---

# 👨‍💻 Author

## Satinder Singh

Dynamic Programming | Algorithms | Java | DSA

---

# ⭐ Final Notes

This repository demonstrates how Dynamic Programming transforms inefficient recursive algorithms into optimized polynomial-time solutions.

The problems included showcase:

- String DP
- Catalan DP
- Combinatorial DP
- Recursive optimization
- State transition systems

This repository is intended to serve as:

- 📘 Academic Notes
- 💼 Interview Preparation Material
- 🚀 GitHub Portfolio Project
- 🧠 DSA Revision Handbook
- 🔬 Research-Oriented DP Reference

---

<div align="center">

# ⭐ If you found this repository useful, consider starring it!

</div>
