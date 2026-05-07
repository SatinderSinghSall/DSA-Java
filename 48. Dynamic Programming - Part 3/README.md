# Data Structure and Algorithms: DSA - Java

---

# 🚀 Dynamic Programming in Java

<div align="center">

![Java](https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=openjdk)
![DSA](https://img.shields.io/badge/Data%20Structures%20%26%20Algorithms-Dynamic%20Programming-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Completed-success?style=for-the-badge)
![Level](https://img.shields.io/badge/Level-Advanced-red?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)
![Research](https://img.shields.io/badge/Focus-Academic%20%26%20Research-purple?style=for-the-badge)

<br>

<img src="https://images.unsplash.com/photo-1515879218367-8466d910aaa4?q=80&w=1400&auto=format&fit=crop" width="100%" />

### 📘 Comprehensive Dynamic Programming Implementations using Java

### From Recursion ➜ Memoization ➜ Tabulation

---

</div>

# 📑 Table of Contents

- [Introduction](#-introduction)
- [Dynamic Programming Theory](#-dynamic-programming-theory)
- [Approaches Used](#-approaches-used)
- [Problems Covered](#-problems-covered)
  - [Coin Change Problem](#-1-coin-change-problem)
  - [Rod Cutting Problem](#-2-rod-cutting-problem)
  - [Longest Common Subsequence](#-3-longest-common-subsequence-lcs)
- [Complexity Analysis](#-complexity-analysis)
- [Project Structure](#-project-structure)
- [Learning Outcomes](#-learning-outcomes)
- [Technologies Used](#-technologies-used)
- [Academic Perspective](#-academic-perspective)
- [Conclusion](#-conclusion)

---

# 📖 Introduction

This repository contains professional implementations of classical **Dynamic Programming (DP)** problems using **Java**.

The project demonstrates the complete evolution of solving DP problems:

```text
Recursion ➜ Memoization ➜ Tabulation
```

This repository is designed for:

- 🎓 Academic Learning
- 💼 Interview Preparation
- 🧠 Algorithmic Thinking
- 🏆 Competitive Programming
- 🔬 Research & Analysis
- 📚 University Coursework
- 🚀 Professional Portfolio Development

---

# 🧠 Dynamic Programming Theory

Dynamic Programming (DP) is an algorithmic optimization technique used to solve problems by dividing them into overlapping subproblems and storing intermediate results.

---

## ✅ Characteristics of DP Problems

### 1. Overlapping Subproblems

Same subproblems are solved multiple times.

### 2. Optimal Substructure

Optimal solution can be constructed from optimal solutions of subproblems.

---

# ⚙️ Approaches Used

| Approach       | Description                       | Optimization |
| -------------- | --------------------------------- | ------------ |
| 🔁 Recursion   | Brute-force recursive exploration | ❌           |
| 🧠 Memoization | Top-Down DP with caching          | ✅           |
| 📊 Tabulation  | Bottom-Up iterative DP            | ✅           |

---

# 📚 Problems Covered

---

# 🪙 1. Coin Change Problem

<div align="center">

<img src="https://miro.medium.com/v2/resize:fit:1200/1*0T5L5cW0XkyRjO6jwxKF1Q.png" width="70%" />

</div>

---

## 📌 Problem Statement

Given an array of coin denominations and a target sum, determine the number of possible ways to make the target sum.

---

## 🧾 Example

```text
Coins = [1, 2, 3]
Sum = 4

Ways:
(1,1,1,1)
(1,1,2)
(2,2)
(1,3)

Answer = 4
```

---

# 🧠 Algorithm

For every coin:

- Include the current coin
- Exclude the current coin

Final answer:

```text
include + exclude
```

---

# 📝 Pseudocode

```text
coinChange(coins, n, sum):

    if sum == 0:
        return 1

    if n == 0:
        return 0

    include = 0

    if coins[n-1] <= sum:
        include = coinChange(coins, n, sum - coins[n-1])

    exclude = coinChange(coins, n-1, sum)

    return include + exclude
```

---

# 📈 Complexity Analysis

| Approach    | Time Complexity | Space Complexity |
| ----------- | --------------- | ---------------- |
| Recursion   | Exponential     | O(sum)           |
| Memoization | O(n × sum)      | O(n × sum)       |
| Tabulation  | O(n × sum)      | O(n × sum)       |

---

# 💻 Java Implementation

```java
// CoinChange.java
```

---

# ✂️ 2. Rod Cutting Problem

<div align="center">

<img src="https://www.boardinfinity.com/blog/content/images/2023/01/Rod-Cutting-Problem.png" width="70%" />

</div>

---

## 📌 Problem Statement

Given a rod of length `n` and prices of different rod pieces, determine the maximum obtainable profit.

---

## 🧾 Example

```text
Length = [1,2,3,4,5,6,7,8]
Price  = [1,5,8,9,10,17,17,20]

Rod Length = 8

Maximum Profit = 22
```

---

# 🔄 Relation with Unbounded Knapsack

| Rod Cutting      | Knapsack |
| ---------------- | -------- |
| Rod Piece Length | Weight   |
| Piece Price      | Value    |
| Rod Length       | Capacity |

---

# 🧠 Algorithm

For every rod piece:

- Include current piece
- Exclude current piece

Return:

```text
max(include, exclude)
```

---

# 📝 Pseudocode

```text
rodCutting(length, price, n, rodLength):

    if n == 0 or rodLength == 0:
        return 0

    include = 0

    if length[n-1] <= rodLength:
        include = price[n-1]
                 + rodCutting(
                     length,
                     price,
                     n,
                     rodLength - length[n-1]
                   )

    exclude = rodCutting(length, price, n-1, rodLength)

    return max(include, exclude)
```

---

# 📈 Complexity Analysis

| Approach    | Time Complexity  | Space Complexity |
| ----------- | ---------------- | ---------------- |
| Recursion   | Exponential      | O(rodLength)     |
| Memoization | O(n × rodLength) | O(n × rodLength) |
| Tabulation  | O(n × rodLength) | O(n × rodLength) |

---

# 💻 Java Implementation

```java
// RodCutting.java
```

---

# 🔤 3. Longest Common Subsequence (LCS)

<div align="center">

<img src="https://media.geeksforgeeks.org/wp-content/uploads/20231110113916/lcs.webp" width="70%" />

</div>

---

## 📌 Problem Statement

Given two strings, determine the length of the Longest Common Subsequence.

---

## 🧾 Example

```text
str1 = "abcde"
str2 = "ace"

LCS = "ace"

Length = 3
```

---

# 🧠 Algorithm

If characters match:

- Move diagonally
- Add 1

Else:

- Move left
- Move up

Take maximum.

---

# 📝 Pseudocode

```text
LCS(str1, str2, n, m):

    if n == 0 or m == 0:
        return 0

    if str1[n-1] == str2[m-1]:
        return 1 + LCS(str1, str2, n-1, m-1)

    else:
        return max(
            LCS(str1, str2, n-1, m),
            LCS(str1, str2, n, m-1)
        )
```

---

# 📈 Complexity Analysis

| Approach    | Time Complexity | Space Complexity |
| ----------- | --------------- | ---------------- |
| Recursion   | O(2^(n+m))      | O(n+m)           |
| Memoization | O(n × m)        | O(n × m)         |
| Tabulation  | O(n × m)        | O(n × m)         |

---

# 💻 Java Implementations

```java
// LCS_Recursion.java
// LCS_Memoization.java
// LCS_Tabulation.java
```

---

# 📊 Overall Complexity Analysis

| Problem     | Recursion   | Memoization | Tabulation |
| ----------- | ----------- | ----------- | ---------- |
| Coin Change | Exponential | Polynomial  | Polynomial |
| Rod Cutting | Exponential | Polynomial  | Polynomial |
| LCS         | Exponential | Polynomial  | Polynomial |

---

# 🗂️ Project Structure

```text
DynamicProgramming/
│
├── CoinChange.java
├── RodCutting.java
├── LCS_Recursion.java
├── LCS_Memoization.java
├── LCS_Tabulation.java
└── README.md
```

---

# 🎯 Learning Outcomes

After completing this module, the following concepts are mastered:

✅ Recursive Problem Solving  
✅ Dynamic Programming Fundamentals  
✅ Overlapping Subproblems  
✅ Optimal Substructure  
✅ State Transition Design  
✅ Top-Down DP  
✅ Bottom-Up DP  
✅ String DP Problems  
✅ Unbounded Knapsack Variants  
✅ Complexity Optimization  
✅ Space-Time Tradeoffs

---

# 🛠️ Technologies Used

| Technology                  | Purpose                   |
| --------------------------- | ------------------------- |
| Java                        | Core Programming Language |
| IntelliJ IDEA               | Development Environment   |
| Dynamic Programming         | Algorithm Design          |
| Object-Oriented Programming | Code Organization         |

---

# 🎓 Academic Perspective

This repository demonstrates:

- Mathematical recurrence formulation
- Recursive tree optimization
- Dynamic Programming state design
- Complexity analysis
- Optimization techniques
- Algorithm engineering
- Clean code architecture

Suitable for:

- University Assignments
- Research Preparation
- Coding Interviews
- Technical Documentation
- Portfolio Projects
- Competitive Programming

---

# 🚀 Future Enhancements

- Matrix Chain Multiplication
- 0/1 Knapsack
- Edit Distance
- Wildcard Matching
- DP on Trees
- Bitmask DP
- Space Optimized DP
- Advanced String DP

---

# 🤝 Contribution

Contributions are welcome.

Feel free to:

- Improve documentation
- Add optimized solutions
- Add visualizations
- Improve explanations

---

# 📜 License

This project is licensed under the MIT License.

---

# 🌟 Conclusion

This repository provides a complete academic and professional foundation for mastering Dynamic Programming using Java.

The implementations progress systematically from:

```text
Recursion ➜ Memoization ➜ Tabulation
```

while emphasizing:

- theoretical understanding
- mathematical reasoning
- algorithmic optimization
- clean coding practices
- research-level documentation

---

<div align="center">

## ⭐ If you found this repository useful, consider giving it a star ⭐

</div>

---

# 🚀 Dynamic Programming in Java

### _From Recursion → Memoization → Tabulation_

![Java](https://img.shields.io/badge/Language-Java-orange)
![DSA](https://img.shields.io/badge/Focus-Data%20Structures%20%26%20Algorithms-blue)
![DP](https://img.shields.io/badge/Topic-Dynamic%20Programming-green)
![Level](https://img.shields.io/badge/Level-Beginner%20to%20Advanced-purple)
![Status](https://img.shields.io/badge/Status-Completed-success)

# Dynamic Programming in Java

## Overview

This repository contains implementations of fundamental and advanced Dynamic Programming (DP) problems using Java.

The project demonstrates multiple approaches for solving classical DP problems:

1. Recursion
2. Memoization (Top-Down DP)
3. Tabulation (Bottom-Up DP)

The goal of this repository is to build a strong foundation in Dynamic Programming from basic recursive thinking to optimized DP solutions.

---

# Topics Covered

## 1. Coin Change Problem

- Recursion
- Memoization
- Tabulation

## 2. Rod Cutting Problem

- Recursion
- Memoization
- Tabulation

## 3. Longest Common Subsequence (LCS)

- Recursion
- Memoization
- Tabulation

---

# Dynamic Programming Theory

Dynamic Programming (DP) is an optimization technique used to solve problems by breaking them into overlapping subproblems and storing previously computed results.

DP is mainly used when:

- Problems have overlapping subproblems
- Problems exhibit optimal substructure

---

# Approaches Used

| Approach    | Description                    |
| ----------- | ------------------------------ |
| Recursion   | Brute force recursive solution |
| Memoization | Top-down DP with caching       |
| Tabulation  | Bottom-up iterative DP         |

---

# 1. Coin Change Problem

## Problem Statement

Given an array of coin denominations and a target sum, determine the number of possible ways to make the target sum.

Example:

```text
Coins = [1, 2, 3]
Sum = 4

Possible Ways:
(1,1,1,1)
(1,1,2)
(2,2)
(1,3)

Answer = 4
```

---

# Algorithm

## Recursive Idea

For every coin:

1. Include the coin
2. Exclude the coin

Return:

```text
include + exclude
```

---

# Pseudocode

```text
function coinChange(coins, n, sum):

    if sum == 0:
        return 1

    if n == 0:
        return 0

    include = 0

    if coins[n-1] <= sum:
        include = coinChange(coins, n, sum - coins[n-1])

    exclude = coinChange(coins, n-1, sum)

    return include + exclude
```

---

# Complexity Analysis

| Approach    | Time Complexity | Space Complexity |
| ----------- | --------------- | ---------------- |
| Recursion   | Exponential     | O(sum)           |
| Memoization | O(n × sum)      | O(n × sum)       |
| Tabulation  | O(n × sum)      | O(n × sum)       |

---

# Java Implementation

```java
// CoinChange.java
```

---

# 2. Rod Cutting Problem

## Problem Statement

Given a rod of length `n` and an array of prices that contains prices of all pieces of size smaller than `n`, determine the maximum obtainable value by cutting up the rod.

Example:

```text
Length = [1,2,3,4,5,6,7,8]
Price  = [1,5,8,9,10,17,17,20]

Rod Length = 8

Maximum Profit = 22
```

---

# Relation with Unbounded Knapsack

Rod Cutting is a variation of the Unbounded Knapsack Problem.

| Rod Cutting | Knapsack |
| ----------- | -------- |
| Length      | Weight   |
| Price       | Value    |
| Rod Length  | Capacity |

---

# Algorithm

For every rod piece:

1. Include current piece
2. Exclude current piece

Return maximum profit.

---

# Pseudocode

```text
function rodCutting(length, price, n, rodLength):

    if n == 0 or rodLength == 0:
        return 0

    include = 0

    if length[n-1] <= rodLength:
        include = price[n-1]
                 + rodCutting(length, price,
                               n,
                               rodLength - length[n-1])

    exclude = rodCutting(length, price,
                         n-1,
                         rodLength)

    return max(include, exclude)
```

---

# Complexity Analysis

| Approach    | Time Complexity  | Space Complexity |
| ----------- | ---------------- | ---------------- |
| Recursion   | Exponential      | O(rodLength)     |
| Memoization | O(n × rodLength) | O(n × rodLength) |
| Tabulation  | O(n × rodLength) | O(n × rodLength) |

---

# Java Implementation

```java
// RodCutting.java
```

---

# 3. Longest Common Subsequence (LCS)

## Problem Statement

Given two strings, determine the length of the Longest Common Subsequence.

Example:

```text
str1 = "abcde"
str2 = "ace"

LCS = "ace"

Length = 3
```

---

# Algorithm

If characters match:

- Move diagonally
- Add 1

Else:

- Move left
- Move up

Take maximum.

---

# Recursive Formula

```text
if str1[n-1] == str2[m-1]:
    1 + LCS(n-1, m-1)

else:
    max(
        LCS(n-1, m),
        LCS(n, m-1)
    )
```

---

# Pseudocode

```text
function LCS(str1, str2, n, m):

    if n == 0 or m == 0:
        return 0

    if str1[n-1] == str2[m-1]:
        return 1 + LCS(str1, str2, n-1, m-1)

    else:
        return max(
            LCS(str1, str2, n-1, m),
            LCS(str1, str2, n, m-1)
        )
```

---

# Complexity Analysis

| Approach    | Time Complexity | Space Complexity |
| ----------- | --------------- | ---------------- |
| Recursion   | O(2^(n+m))      | O(n+m)           |
| Memoization | O(n × m)        | O(n × m)         |
| Tabulation  | O(n × m)        | O(n × m)         |

---

# Java Implementations

```java
// LCS_Recursion.java
// LCS_Memoization.java
// LCS_Tabulation.java
```

---

# Key Learning Outcomes

After completing this module, the following concepts are understood:

- Recursive Problem Solving
- Overlapping Subproblems
- Optimal Substructure
- Top-Down Dynamic Programming
- Bottom-Up Dynamic Programming
- State Transition Design
- DP Table Construction
- Unbounded Knapsack Variations
- String Dynamic Programming
- Complexity Optimization

---

# Folder Structure

```text
DynamicProgramming/
│
├── CoinChange.java
├── RodCutting.java
├── LCS_Recursion.java
├── LCS_Memoization.java
├── LCS_Tabulation.java
└── README.md
```

---

# Technologies Used

- Java
- IntelliJ IDEA
- Dynamic Programming
- Object-Oriented Programming

---

# Academic Perspective

This repository demonstrates:

- Theoretical understanding of Dynamic Programming
- Mathematical recurrence formulation
- Recursive tree optimization
- State transition derivation
- Time-space complexity analysis

The implementations are suitable for:

- University coursework
- Coding interviews
- Research preparation
- Competitive programming
- Technical portfolio building

---

# Conclusion

This module builds a complete foundation in Dynamic Programming using Java, beginning with recursion and progressing toward optimized DP solutions using memoization and tabulation.

The repository emphasizes:

- clean code structure
- algorithmic thinking
- theoretical clarity
- practical implementation

---
