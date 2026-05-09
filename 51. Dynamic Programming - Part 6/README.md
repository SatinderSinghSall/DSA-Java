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

# Dynamic Programming (DP) — Advanced Module (Java)

This module covers advanced Dynamic Programming (DP) concepts and optimization problems implemented in Java. The focus is on understanding the transition from brute-force recursion to optimized memoization and tabulation approaches.

The implementations included in this module demonstrate:

- Recursive Problem Solving
- Overlapping Subproblems
- Memoization (Top-Down DP)
- Tabulation (Bottom-Up DP)
- State Transition Design
- Optimization Problems
- Matrix-Based DP Problems
- Partition DP
- Reachability & Minimum Cost Problems

The module includes practical implementations of:

1. Matrix Chain Multiplication (MCM)
2. Minimum Partitioning
3. Minimum Array Jumps

The source implementations are available in:

- Matrix Chain Multiplication →
- Minimum Array Jumps →
- Minimum Partitioning →

---

# Table of Contents

1. Introduction to Dynamic Programming
2. Dynamic Programming Paradigms
3. Matrix Chain Multiplication (MCM)
4. Minimum Partitioning
5. Minimum Array Jumps
6. Complexity Analysis
7. Key DP Observations
8. Advanced DP Insights
9. Conclusion

---

# 1. Introduction to Dynamic Programming

Dynamic Programming (DP) is an optimization technique used to solve problems exhibiting:

- Optimal Substructure
- Overlapping Subproblems

DP reduces redundant computations by storing previously computed results.

---

# Core DP Approaches

## 1. Recursion

Break the problem into smaller subproblems recursively.

### Characteristics

- Simple to write
- Exponential complexity
- Recomputes states repeatedly

---

## 2. Memoization (Top-Down DP)

Store recursive results in a cache (`dp[]`, `dp[][]`).

### Characteristics

- Avoids recomputation
- Recursive + caching
- Improves time complexity drastically

---

## 3. Tabulation (Bottom-Up DP)

Solve smaller states first and build toward the final answer.

### Characteristics

- Iterative
- Usually faster than memoization
- Eliminates recursion stack overhead

---

# 2. Matrix Chain Multiplication (MCM)

Source File:

---

# Problem Statement

Given matrices:

```text
A1, A2, A3 ... An
```

Find the minimum number of scalar multiplications needed to multiply the chain.

---

# Example

```text
arr[] = {1, 2, 3, 4, 3}
```

Matrices:

```text
A1 = 1x2
A2 = 2x3
A3 = 3x4
A4 = 4x3
```

Goal:

```text
Minimize multiplication cost
```

---

# Theory

Matrix multiplication is associative:

```text
(A × B) × C = A × (B × C)
```

But cost differs depending on parenthesization.

---

# Recursive Relation

For every partition `k`:

Cost(i,j)=Cost(i,k)+Cost(k+1,j)+arr[i-1]\times arr[k]\times arr[j]

---

# Recursive Algorithm

1. Partition matrix chain at every `k`
2. Solve left subproblem
3. Solve right subproblem
4. Add multiplication cost
5. Return minimum cost

---

# Pseudocode

```text
function MCM(i, j):

    if i == j:
        return 0

    minCost = INF

    for k = i to j-1:

        cost =
            MCM(i, k)
            + MCM(k+1, j)
            + arr[i-1] * arr[k] * arr[j]

        minCost = min(minCost, cost)

    return minCost
```

---

# Complexity Analysis

| Method      | Time        | Space |
| ----------- | ----------- | ----- |
| Recursion   | Exponential | O(n)  |
| Memoization | O(n³)       | O(n²) |
| Tabulation  | O(n³)       | O(n²) |

---

# Key DP Insight

The problem exhibits:

- Optimal Substructure
- Overlapping Subproblems

Thus DP is highly effective.

---

# Actual Java Implementation

Implemented using:

- Recursive Solution
- Memoization
- Bottom-Up Tabulation

See complete implementation in:

---

# 3. Minimum Partitioning

Source File:

---

# Problem Statement

Divide an array into two subsets such that:

```text
|sum1 - sum2|
```

is minimized.

---

# Example

```text
arr[] = {1, 6, 11, 5}
```

Possible partition:

```text
{1, 5, 6} = 12
{11} = 11
```

Minimum Difference:

```text
1
```

---

# Theory

This problem is derived from the:

```text
Subset Sum Problem
```

We aim to find the subset whose sum is closest to:

\frac{TotalSum}{2}

---

# Mathematical Relation

If:

```text
sum1 + sum2 = totalSum
```

Then:

Difference=|sum1-sum2|

---

# Recursive Algorithm

For every element:

- Include in subset 1
- Exclude from subset 1

Return minimum difference.

---

# Pseudocode

```text
function solve(n, sum1):

    if n == 0:
        sum2 = totalSum - sum1
        return abs(sum1 - sum2)

    include =
        solve(n-1, sum1 + arr[n-1])

    exclude =
        solve(n-1, sum1)

    return min(include, exclude)
```

---

# DP Optimization

Memoization stores:

```text
dp[n][sum1]
```

Tabulation converts the problem into subset sum feasibility.

---

# Complexity Analysis

| Method      | Time       | Space      |
| ----------- | ---------- | ---------- |
| Recursion   | O(2ⁿ)      | O(n)       |
| Memoization | O(n × sum) | O(n × sum) |
| Tabulation  | O(n × sum) | O(n × sum) |

---

# Key Observation

If we can achieve a subset sum close to:

```text
totalSum / 2
```

then the partition difference becomes minimum.

---

# Actual Java Implementation

Implemented using:

- Recursion
- Memoization
- Tabulation

See full source:

---

# 4. Minimum Array Jumps

Source File:

---

# Problem Statement

Given an array where each element represents the maximum jump length from that position:

Find minimum jumps required to reach the end.

---

# Example

```text
arr[] = {2, 3, 1, 1, 4}
```

Minimum jumps:

```text
2
```

Path:

```text
0 → 1 → 4
```

---

# Theory

At every index:

- Multiple future states are possible
- We choose the path with minimum jumps

This becomes a shortest path style DP problem.

---

# Recursive Relation

For every reachable index:

dp[i]=1+\min(dp[j])

where:

```text
j belongs to reachable positions from i
```

---

# Recursive Algorithm

1. Try every possible jump
2. Recursively solve future states
3. Return minimum jumps

---

# Pseudocode

```text
function minJumps(idx):

    if idx >= n-1:
        return 0

    ans = INF

    for jump = 1 to arr[idx]:

        ans = min(
            ans,
            1 + minJumps(idx + jump)
        )

    return ans
```

---

# Memoization

Store:

```text
dp[idx]
```

to avoid recomputation.

---

# Tabulation

Build solution from right to left.

---

# Complexity Analysis

| Method      | Time        | Space |
| ----------- | ----------- | ----- |
| Recursion   | Exponential | O(n)  |
| Memoization | O(n²)       | O(n)  |
| Tabulation  | O(n²)       | O(n)  |

---

# Key DP Insight

Each position depends on:

```text
future reachable states
```

Thus backward DP is highly effective.

---

# Actual Java Implementation

Implemented using:

- Recursive DP
- Memoization
- Bottom-Up Tabulation

See full source:

---

# 5. Dynamic Programming Design Strategy

When solving DP problems:

---

## Step 1: Identify State

Examples:

```text
dp[i]
dp[i][j]
dp[n][sum]
```

---

## Step 2: Define Decision

Examples:

- Include / Exclude
- Partition point
- Jump choices

---

## Step 3: Write Recurrence

Transition from smaller subproblems.

---

## Step 4: Optimize

Convert:

```text
Recursion → Memoization → Tabulation
```

---

# 6. Common DP Patterns Learned

| Pattern         | Example                     |
| --------------- | --------------------------- |
| Partition DP    | Matrix Chain Multiplication |
| Subset DP       | Minimum Partitioning        |
| Reachability DP | Minimum Array Jumps         |
| Optimization DP | All Problems                |

---

# 7. Advanced Research Perspective

These problems represent foundational concepts used in:

- Compiler Optimization
- Artificial Intelligence
- Graph Theory
- Operations Research
- Bioinformatics
- Computational Mathematics
- Resource Allocation
- Dynamic Scheduling

---

# 8. Software Engineering Perspective

The implementations demonstrate:

- Clean modular Java structure
- Reusable recursive decomposition
- State caching strategies
- DP table design
- Complexity reduction techniques
- Algorithmic optimization

---

# 9. Conclusion

This module provides deep exposure to advanced Dynamic Programming techniques through practical optimization problems.

The progression:

```text
Recursion
    ↓
Memoization
    ↓
Tabulation
```

demonstrates how brute-force algorithms can be transformed into highly optimized polynomial-time solutions.

The problems covered develop strong foundations in:

- State Transition Design
- Partition DP
- Optimization Problems
- Recursive Thinking
- Space-Time Tradeoffs
- Bottom-Up Computation

These concepts are fundamental for:

- Technical Interviews
- Competitive Programming
- Research
- Advanced Algorithm Design
- Software Engineering Optimization Systems
