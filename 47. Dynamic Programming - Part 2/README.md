# Data Structure and Algorithms: DSA - Java

---

# 🚀 Dynamic Programming in Java

### _From Recursion → Memoization → Tabulation_

![Java](https://img.shields.io/badge/Language-Java-orange)
![DSA](https://img.shields.io/badge/Focus-Data%20Structures%20%26%20Algorithms-blue)
![DP](https://img.shields.io/badge/Topic-Dynamic%20Programming-green)
![Level](https://img.shields.io/badge/Level-Beginner%20to%20Advanced-purple)
![Status](https://img.shields.io/badge/Status-Completed-success)

---

# Dynamic Programming – Part 2 (Java)

## Advanced Dynamic Programming Concepts and Knapsack Variations

---

# Overview

This module focuses on some of the most important Dynamic Programming (DP) problems and optimization techniques in Java. The implementations demonstrate how recursive solutions evolve into optimized Dynamic Programming solutions using Memoization and Tabulation.

The topics covered include:

- 0/1 Knapsack Problem
- Memoization
- Tabulation
- Target Sum Subset
- Unbounded Knapsack

This repository is designed from:

- Academic Perspective
- Research Perspective
- Interview Preparation Perspective
- Software Engineering Perspective

---

# Learning Objectives

After completing this module, the learner should be able to:

- Understand Dynamic Programming fundamentals
- Identify overlapping subproblems
- Understand optimal substructure
- Convert recursive solutions into memoized solutions
- Convert memoized solutions into tabulated solutions
- Design DP states and transitions
- Solve optimization and subset problems
- Analyze time and space complexity
- Apply DP techniques to real-world optimization problems

---

# What is Dynamic Programming?

Dynamic Programming is an optimization technique used to solve complex problems by breaking them into smaller overlapping subproblems and storing previously computed results.

Dynamic Programming works efficiently when a problem exhibits:

1. Optimal Substructure
2. Overlapping Subproblems

---

# Types of Dynamic Programming

| Approach    | Description                           |
| ----------- | ------------------------------------- |
| Recursion   | Solves using repeated recursive calls |
| Memoization | Top-Down DP using caching             |
| Tabulation  | Bottom-Up iterative DP                |

---

# Project Structure

```text
src/
│
├── Knapsack01_Recursion.java
├── Knapsack01_Memoization.java
├── Knapsack01_Tabulation.java
├── TargetSumSubset.java
├── UnboundedKnapsack.java
└── Main.java
```

---

# 1. 0/1 Knapsack Problem using Recursion

Source Reference:

---

# Problem Statement

Given:

- `n` items
- Each item has:
  - Weight → `wt[i]`
  - Value → `val[i]`

- A knapsack with capacity `W`

Goal:

Maximize the total profit without exceeding the knapsack capacity.

Constraint:

Each item can be selected at most once.

This is known as the 0/1 Knapsack Problem.

---

# Recursive Thinking

For every item we have two choices:

1. Include the item
2. Exclude the item

Then recursively solve the remaining subproblem.

---

# Recursive Formula

If current item weight is less than or equal to capacity:

f(n,W)=\max\left(val[n-1]+f(n-1,W-wt[n-1]),\ f(n-1,W)\right)

Otherwise:

f(n,W)=f(n-1,W)

---

# Base Case

```text
If W == 0 or n == 0
return 0
```

---

# Algorithm

1. Start from the last item
2. Check whether the item fits
3. If it fits:
   - Include the item
   - Exclude the item
   - Take maximum profit

4. Otherwise skip the item
5. Continue recursively

---

# Pseudocode

```text
FUNCTION knapsack(val, wt, W, n)

    IF W == 0 OR n == 0
        RETURN 0

    IF wt[n-1] <= W

        include =
            val[n-1] +
            knapsack(val, wt, W-wt[n-1], n-1)

        exclude =
            knapsack(val, wt, W, n-1)

        RETURN max(include, exclude)

    ELSE

        RETURN knapsack(val, wt, W, n-1)
```

---

# Java Code

```java
public class Knapsack01_Recursion {

    public static int knapsack(int val[], int wt[],
                               int W, int n) {

        if (W == 0 || n == 0) {
            return 0;
        }

        if (wt[n - 1] <= W) {

            int ans =
                val[n - 1]
                + knapsack(val, wt,
                           W - wt[n - 1], n - 1);

            int ans2 =
                knapsack(val, wt, W, n - 1);

            return Math.max(ans, ans2);

        } else {

            return knapsack(val, wt, W, n - 1);
        }
    }
}
```

---

# Complexity Analysis

| Complexity       | Value                |
| ---------------- | -------------------- |
| Time Complexity  | O(2^n)               |
| Space Complexity | O(n) recursion stack |

---

# Drawbacks of Pure Recursion

- Repeated calculations
- Exponential complexity
- Slow for large inputs
- High recursive overhead

This motivates Memoization.

---

# 2. 0/1 Knapsack using Memoization

Source Reference:

---

# Memoization Concept

Memoization is a Top-Down Dynamic Programming approach.

Instead of recomputing subproblems repeatedly, previously computed results are stored inside a DP table.

---

# DP State Definition

dp[n][W]

Meaning:

Maximum profit using first `n` items and capacity `W`.

---

# Key Observation

The recursive solution repeatedly computes identical states.

Memoization eliminates repeated computations.

---

# Algorithm

1. Create DP table initialized with `-1`
2. Before solving a subproblem:
   - Check if answer already exists

3. If yes:
   - Return stored answer

4. Otherwise:
   - Compute recursively
   - Store answer

5. Return stored result

---

# Pseudocode

```text
FUNCTION knapsack(val, wt, W, n, dp)

    IF W == 0 OR n == 0
        RETURN 0

    IF dp[n][W] != -1
        RETURN dp[n][W]

    IF wt[n-1] <= W

        include =
            val[n-1]
            + knapsack(val, wt,
                       W-wt[n-1], n-1, dp)

        exclude =
            knapsack(val, wt, W, n-1, dp)

        dp[n][W] =
            max(include, exclude)

    ELSE

        dp[n][W] =
            knapsack(val, wt, W, n-1, dp)

    RETURN dp[n][W]
```

---

# Java Code

```java
import java.util.Arrays;

public class Knapsack01_Memoization {

    public static int knapsack(int val[], int wt[],
                               int W, int n,
                               int dp[][]) {

        if (W == 0 || n == 0) {
            return 0;
        }

        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (wt[n - 1] <= W) {

            int ans1 =
                val[n - 1]
                + knapsack(val, wt,
                           W - wt[n - 1],
                           n - 1, dp);

            int ans2 =
                knapsack(val, wt, W,
                         n - 1, dp);

            dp[n][W] =
                Math.max(ans1, ans2);

        } else {

            dp[n][W] =
                knapsack(val, wt, W,
                         n - 1, dp);
        }

        return dp[n][W];
    }
}
```

---

# Complexity Analysis

| Complexity       | Value    |
| ---------------- | -------- |
| Time Complexity  | O(n × W) |
| Space Complexity | O(n × W) |

---

# Advantages of Memoization

- Faster than recursion
- Avoids repeated calculations
- Easier conversion from recursive solutions
- Efficient for sparse subproblems

---

# 3. 0/1 Knapsack using Tabulation

Source Reference:

---

# Tabulation Concept

Tabulation is a Bottom-Up Dynamic Programming technique.

Instead of recursion:

- Build solutions iteratively
- Start from smallest subproblems
- Fill DP table step-by-step

---

# DP Table Definition

dp[i][j]

Meaning:

Maximum profit using first `i` items and capacity `j`.

---

# Transition Formula

If current item fits:

dp[i][j]=\max\left(v+dp[i-1][j-w],\ dp[i-1][j]\right)

Otherwise:

dp[i][j]=dp[i-1][j]

---

# Algorithm

1. Create DP table
2. Initialize first row and column
3. Traverse items
4. Traverse capacities
5. Apply transition relation
6. Final answer stored in:

dp[n][W]

---

# Pseudocode

```text
FUNCTION knapsack(val, wt, W)

    n = length(val)

    CREATE dp[n+1][W+1]

    FOR i = 1 to n

        FOR j = 1 to W

            value = val[i-1]
            weight = wt[i-1]

            IF weight <= j

                include =
                    value + dp[i-1][j-weight]

                exclude =
                    dp[i-1][j]

                dp[i][j] =
                    max(include, exclude)

            ELSE

                dp[i][j] =
                    dp[i-1][j]

    RETURN dp[n][W]
```

---

# Java Code

```java
public class Knapsack01_Tabulation {

    public static int knapsack(int val[],
                               int wt[],
                               int W) {

        int n = val.length;

        int dp[][] =
            new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= W; j++) {

                int v = val[i - 1];
                int w = wt[i - 1];

                if (w <= j) {

                    int includeProfit =
                        v + dp[i - 1][j - w];

                    int excludeProfit =
                        dp[i - 1][j];

                    dp[i][j] =
                        Math.max(includeProfit,
                                 excludeProfit);

                } else {

                    dp[i][j] =
                        dp[i - 1][j];
                }
            }
        }

        return dp[n][W];
    }
}
```

---

# Complexity Analysis

| Complexity       | Value    |
| ---------------- | -------- |
| Time Complexity  | O(n × W) |
| Space Complexity | O(n × W) |

---

# Memoization vs Tabulation

| Feature         | Memoization | Tabulation |
| --------------- | ----------- | ---------- |
| Approach        | Top-Down    | Bottom-Up  |
| Uses Recursion  | Yes         | No         |
| Stack Usage     | High        | Low        |
| Execution Speed | Moderate    | Faster     |
| Ease of Writing | Easier      | Moderate   |

---

# 4. Target Sum Subset Problem

Source Reference:

---

# Problem Statement

Given an array and a target sum:

Determine whether a subset exists whose sum equals the target.

---

# Example

Input:

```text
Array = {4, 2, 7, 1, 3}
Target = 10
```

Output:

```text
true
```

Subset:

```text
{4, 2, 1, 3}
```

---

# DP State

dp[i][j]

Meaning:

Whether sum `j` can be formed using first `i` elements.

---

# Transition Formula

If current value fits:

dp[i][j]=dp[i-1][j-v]\ ||\ dp[i-1][j]

---

# Initialization

dp[i][0]=true

Because sum 0 is always possible.

---

# Algorithm

1. Create boolean DP table
2. Initialize first column with true
3. Traverse array
4. Traverse target sums
5. Apply include/exclude logic
6. Final answer stored in:

dp[n][target]

---

# Pseudocode

```text
FUNCTION targetSumSubset(arr, target)

    CREATE dp[n+1][target+1]

    FOR i = 0 to n
        dp[i][0] = true

    FOR i = 1 to n

        FOR j = 1 to target

            value = arr[i-1]

            IF value <= j

                include =
                    dp[i-1][j-value]

                exclude =
                    dp[i-1][j]

                dp[i][j] =
                    include OR exclude

            ELSE

                dp[i][j] =
                    dp[i-1][j]

    RETURN dp[n][target]
```

---

# Java Code

```java
public class TargetSumSubset {

    public static boolean targetSumSubset(
            int arr[], int target) {

        int n = arr.length;

        boolean dp[][] =
            new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= target; j++) {

                int v = arr[i - 1];

                if (v <= j) {

                    boolean include =
                        dp[i - 1][j - v];

                    boolean exclude =
                        dp[i - 1][j];

                    dp[i][j] =
                        include || exclude;

                } else {

                    dp[i][j] =
                        dp[i - 1][j];
                }
            }
        }

        return dp[n][target];
    }
}
```

---

# Complexity Analysis

| Complexity       | Value         |
| ---------------- | ------------- |
| Time Complexity  | O(n × target) |
| Space Complexity | O(n × target) |

---

# Applications of Target Sum Subset

- Partition Equal Subset Sum
- Resource allocation
- Financial budgeting
- Constraint optimization
- Decision systems

---

# 5. Unbounded Knapsack Problem

Source Reference:

---

# Problem Statement

In Unbounded Knapsack:

Each item can be selected unlimited times.

Unlike 0/1 Knapsack:

- 0/1 Knapsack → select once
- Unbounded Knapsack → select multiple times

---

# Real-World Applications

- Coin Change Problem
- Rod Cutting
- Manufacturing optimization
- Inventory systems
- Resource planning

---

# Key Difference from 0/1 Knapsack

0/1 Knapsack:

include=value+dp[i-1][j-weight]

Unbounded Knapsack:

include=value+dp[i][j-weight]

Notice:

Same row is reused because the item can be selected again.

---

# DP State

dp[i][j]

Meaning:

Maximum profit using first `i` items and capacity `j`.

---

# Algorithm

1. Create DP table
2. Traverse items
3. Traverse capacities
4. If current item fits:
   - Include current item again
   - Exclude current item

5. Take maximum
6. Final answer stored in:

dp[n][W]

---

# Pseudocode

```text
FUNCTION unboundedKnapsack(val, wt, W)

    CREATE dp[n+1][W+1]

    FOR i = 1 to n

        FOR j = 1 to W

            value = val[i-1]
            weight = wt[i-1]

            IF weight <= j

                include =
                    value + dp[i][j-weight]

                exclude =
                    dp[i-1][j]

                dp[i][j] =
                    max(include, exclude)

            ELSE

                dp[i][j] =
                    dp[i-1][j]

    RETURN dp[n][W]
```

---

# Java Code

```java
public class UnboundedKnapsack {

    public static int unboundedKnapsack(
            int val[], int wt[], int W) {

        int n = val.length;

        int dp[][] =
            new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= W; j++) {

                int v = val[i - 1];
                int w = wt[i - 1];

                if (w <= j) {

                    int includeProfit =
                        v + dp[i][j - w];

                    int excludeProfit =
                        dp[i - 1][j];

                    dp[i][j] =
                        Math.max(includeProfit,
                                 excludeProfit);

                } else {

                    dp[i][j] =
                        dp[i - 1][j];
                }
            }
        }

        return dp[n][W];
    }
}
```

---

# Complexity Analysis

| Complexity       | Value    |
| ---------------- | -------- |
| Time Complexity  | O(n × W) |
| Space Complexity | O(n × W) |

---

# Comparative Analysis

| Problem            | Type             | Repetition Allowed |
| ------------------ | ---------------- | ------------------ |
| 0/1 Knapsack       | Optimization     | No                 |
| Target Sum Subset  | Decision Problem | No                 |
| Unbounded Knapsack | Optimization     | Yes                |

---

# Core Dynamic Programming Patterns Learned

## 1. Include-Exclude Pattern

Used in:

- Knapsack
- Subset Sum
- Partition Problems

---

## 2. State Transition Design

Core DP idea:

Current\ State\rightarrow Smaller\ Subproblem

---

## 3. DP Table Construction

Important observations:

- Rows represent items
- Columns represent capacities or targets
- Cells store subproblem answers

---

# Academic Insights

This module introduces core Dynamic Programming principles used in:

- Competitive Programming
- Technical Interviews
- Algorithm Research
- Artificial Intelligence
- Operations Research
- Optimization Theory

The Knapsack family of problems is one of the most important optimization models in Computer Science.

---

# Industry Applications

| Domain          | Application            |
| --------------- | ---------------------- |
| Finance         | Portfolio optimization |
| Logistics       | Cargo loading          |
| AI              | Resource allocation    |
| Cloud Computing | Resource optimization  |
| Gaming          | Inventory systems      |
| Manufacturing   | Cost optimization      |

---

# Key Takeaways

- Recursion is intuitive but inefficient
- Memoization optimizes recursion
- Tabulation provides iterative optimization
- DP problems require proper state design
- Knapsack problems are foundational optimization problems
- Subset problems derive from include-exclude DP patterns

---

# Conclusion

This module demonstrates the complete progression:

```text
Recursion → Memoization → Tabulation
```

while solving:

- 0/1 Knapsack
- Target Sum Subset
- Unbounded Knapsack

The implementations provide both theoretical understanding and practical Java coding experience.

This module forms a strong foundation for advanced DP topics such as:

- Longest Common Subsequence (LCS)
- Matrix Chain Multiplication
- DP on Trees
- Bitmask DP
- Digit DP
- Advanced Optimization Problems

---

# Technologies Used

| Technology          | Purpose                   |
| ------------------- | ------------------------- |
| Java                | Core Programming Language |
| IntelliJ IDEA       | Development Environment   |
| Dynamic Programming | Algorithm Design          |

---

# References

- Dynamic Programming by Richard Bellman
- Introduction to Algorithms (CLRS)
- Java Documentation
- Competitive Programming Resources
- Optimization Research Papers

---

# Repository Status

Module Completed Successfully.

Topics Covered:

- 0/1 Knapsack (Recursion)
- 0/1 Knapsack (Memoization)
- 0/1 Knapsack (Tabulation)
- Target Sum Subset
- Unbounded Knapsack

---

# 👨‍💻 Author

**Satinder Singh Sall**
Data Structures and Algorithms
Full-Stack Engineer Web / Mobile App

📍 DSA | Java | Problem Solving

---

# 🚀 Dynamic Programming – Part 2 (Java)

<div align="center">

![Java](https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=java)
![DSA](https://img.shields.io/badge/Focus-Data%20Structures%20%26%20Algorithms-blue?style=for-the-badge)
![Dynamic Programming](https://img.shields.io/badge/Topic-Dynamic%20Programming-success?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen?style=for-the-badge)
![Level](https://img.shields.io/badge/Level-Intermediate%20to%20Advanced-purple?style=for-the-badge)
![IDE](https://img.shields.io/badge/IDE-IntelliJ%20IDEA-black?style=for-the-badge&logo=intellijidea)

</div>

---

<div align="center">

# 📚 Advanced Dynamic Programming Concepts

### 0/1 Knapsack • Memoization • Tabulation • Target Sum Subset • Unbounded Knapsack

<img src="https://images.unsplash.com/photo-1515879218367-8466d910aaa4?q=80&w=1200&auto=format&fit=crop" width="100%" alt="Dynamic Programming Banner">

</div>

---

# 🌟 Overview

This repository contains a complete implementation of important **Dynamic Programming (DP)** concepts in **Java**.

The project demonstrates how brute-force recursive solutions evolve into optimized Dynamic Programming solutions using:

- ✅ Recursion
- ✅ Memoization (Top-Down DP)
- ✅ Tabulation (Bottom-Up DP)

The repository is designed from:

- 🎓 Academic Perspective
- 💼 Professional Software Engineering Perspective
- 🧠 Interview Preparation Perspective
- 🔬 Research and Algorithmic Perspective

---

# 🎯 Learning Objectives

After completing this module, you will be able to:

- Understand overlapping subproblems
- Understand optimal substructure
- Convert recursion into memoization
- Convert memoization into tabulation
- Design DP states and transitions
- Analyze time and space complexity
- Solve optimization problems efficiently
- Build strong foundations for advanced DP

---

# 🧠 What is Dynamic Programming?

Dynamic Programming is an optimization technique used to solve problems by breaking them into smaller overlapping subproblems and storing previously computed results.

---

<div align="center">
<img src="https://upload.wikimedia.org/wikipedia/commons/0/0a/Merge-sort-example-300px.gif" width="65%" alt="Dynamic Programming Visualization">
</div>

---

# 📂 Project Structure

```text
src/
│
├── Knapsack01_Recursion.java
├── Knapsack01_Memoization.java
├── Knapsack01_Tabulation.java
├── TargetSumSubset.java
├── UnboundedKnapsack.java
└── Main.java
```

---

# 🔥 1. 0/1 Knapsack Problem using Recursion

<div align="center">
<img src="https://upload.wikimedia.org/wikipedia/commons/f/fd/Knapsack.svg" width="55%" alt="Knapsack Problem">
</div>

---

## 📌 Problem Statement

Given:

- `n` items
- Each item has:
  - Weight → `wt[i]`
  - Value → `val[i]`

- A knapsack with capacity `W`

### Goal:

Maximize total profit while ensuring total weight does not exceed the knapsack capacity.

---

# 🧩 Recursive Thinking

For every item:

- Include the item
- Exclude the item

Then recursively solve the remaining subproblem.

---

# ⚙️ Recursive Formula

```text
f(n, W) = max(
    value[n-1] + f(n-1, W-wt[n-1]),
    f(n-1, W)
)
```

---

# 📋 Algorithm

1. Start from the last item
2. Check whether item fits
3. If yes:
   - Include item
   - Exclude item
   - Take maximum

4. Otherwise skip item
5. Continue recursively

---

# 🧾 Pseudocode

```text
FUNCTION knapsack(val, wt, W, n)

    IF W == 0 OR n == 0
        RETURN 0

    IF wt[n-1] <= W

        include = val[n-1] +
                  knapsack(W-wt[n-1])

        exclude =
                  knapsack(W)

        RETURN max(include, exclude)

    ELSE
        RETURN knapsack(W)
```

---

# 💻 Java Code

```java
public class Knapsack01_Recursion {

    public static int knapsack(int val[], int wt[],
                               int W, int n) {

        if (W == 0 || n == 0) {
            return 0;
        }

        if (wt[n - 1] <= W) {

            int ans = val[n - 1]
                    + knapsack(val, wt,
                    W - wt[n - 1], n - 1);

            int ans2 = knapsack(val, wt, W, n - 1);

            return Math.max(ans, ans2);

        } else {
            return knapsack(val, wt, W, n - 1);
        }
    }
}
```

---

# ⏱️ Complexity Analysis

| Complexity       | Value  |
| ---------------- | ------ |
| Time Complexity  | O(2^n) |
| Space Complexity | O(n)   |

---

# 🚀 2. 0/1 Knapsack using Memoization

<div align="center">
<img src="https://miro.medium.com/v2/resize:fit:1200/1*Jd2hB3M7Q0A6h0lKQx6hWQ.png" width="70%" alt="Memoization DP">
</div>

---

# 🧠 Memoization Concept

Memoization stores previously computed subproblem answers in a DP table.

This avoids repeated recursive calculations.

---

# 📌 DP State

```text
dp[n][W]
```

Meaning:

Maximum profit using first `n` items and capacity `W`.

---

# ⚙️ Memoization Algorithm

1. Create DP table initialized with `-1`
2. Before solving a state:
   - Check whether already computed

3. If computed:
   - Return stored answer

4. Otherwise compute recursively
5. Store result
6. Return result

---

# 💻 Java Code

```java
import java.util.Arrays;

public class Knapsack01_Memoization {

    public static int knapsack(int val[], int wt[],
                               int W, int n,
                               int dp[][]) {

        if (W == 0 || n == 0) {
            return 0;
        }

        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (wt[n - 1] <= W) {

            int ans1 = val[n - 1]
                    + knapsack(val, wt,
                    W - wt[n - 1], n - 1, dp);

            int ans2 = knapsack(val, wt, W,
                                n - 1, dp);

            dp[n][W] = Math.max(ans1, ans2);

        } else {

            dp[n][W] = knapsack(val, wt,
                                W, n - 1, dp);
        }

        return dp[n][W];
    }
}
```

---

# 📊 Memoization Complexity

| Complexity       | Value    |
| ---------------- | -------- |
| Time Complexity  | O(n × W) |
| Space Complexity | O(n × W) |

---

# 🚀 3. 0/1 Knapsack using Tabulation

<div align="center">
<img src="https://afteracademy.com/images/dynamic-programming-knapsack-problem-tabulation-approach-table-1.png" width="75%" alt="Tabulation DP Table">
</div>

---

# 🧠 Tabulation Concept

Tabulation is a Bottom-Up DP approach.

Instead of recursion:

- Build answers iteratively
- Start from smallest subproblems
- Fill DP table step-by-step

---

# 📌 DP State

```text
dp[i][j]
```

Meaning:

Maximum profit using first `i` items with capacity `j`.

---

# ⚙️ Transition Formula

```text
include = value + dp[i-1][j-weight]
exclude = dp[i-1][j]
```

Take maximum.

---

# 💻 Java Code

```java
public class Knapsack01_Tabulation {

    public static int knapsack(int val[],
                               int wt[], int W) {

        int n = val.length;

        int dp[][] = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= W; j++) {

                int v = val[i - 1];
                int w = wt[i - 1];

                if (w <= j) {

                    int includeProfit =
                            v + dp[i - 1][j - w];

                    int excludeProfit =
                            dp[i - 1][j];

                    dp[i][j] =
                            Math.max(includeProfit,
                                     excludeProfit);

                } else {

                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W];
    }
}
```

---

# ⚖️ Memoization vs Tabulation

| Feature        | Memoization | Tabulation |
| -------------- | ----------- | ---------- |
| Approach       | Top-Down    | Bottom-Up  |
| Uses Recursion | Yes         | No         |
| Stack Usage    | High        | Low        |
| Speed          | Moderate    | Faster     |
| Ease           | Easier      | Moderate   |

---

# 🎯 4. Target Sum Subset Problem

<div align="center">
<img src="https://www.simplilearn.com/ice9/free_resources_article_thumb/Subset_sum_problem.jpg" width="70%" alt="Subset Sum Problem">
</div>

---

# 📌 Problem Statement

Determine whether a subset exists whose sum equals the target.

---

# 📥 Example

```text
Array = {4, 2, 7, 1, 3}
Target = 10
```

Output:

```text
true
```

---

# 🧠 DP State

```text
dp[i][j]
```

Meaning:

Whether sum `j` can be formed using first `i` elements.

---

# 💻 Java Code

```java
public class TargetSumSubset {

    public static boolean targetSumSubset(
            int arr[], int target) {

        int n = arr.length;

        boolean dp[][] =
                new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= target; j++) {

                int v = arr[i - 1];

                if (v <= j) {

                    boolean include =
                            dp[i - 1][j - v];

                    boolean exclude =
                            dp[i - 1][j];

                    dp[i][j] =
                            include || exclude;

                } else {

                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][target];
    }
}
```

---

# 🚀 5. Unbounded Knapsack Problem

<div align="center">
<img src="https://media.geeksforgeeks.org/wp-content/uploads/unbounded-knapsack.png" width="70%" alt="Unbounded Knapsack">
</div>

---

# 📌 Problem Statement

In Unbounded Knapsack:

Each item can be selected unlimited times.

---

# 🔥 Key Difference

0/1 Knapsack:

```text
include = value + dp[i-1][j-weight]
```

Unbounded Knapsack:

```text
include = value + dp[i][j-weight]
```

Because the same item can be reused.

---

# 💻 Java Code

```java
public class UnboundedKnapsack {

    public static int unboundedKnapsack(
            int val[], int wt[], int W) {

        int n = val.length;

        int dp[][] =
                new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= W; j++) {

                int v = val[i - 1];
                int w = wt[i - 1];

                if (w <= j) {

                    int includeProfit =
                            v + dp[i][j - w];

                    int excludeProfit =
                            dp[i - 1][j];

                    dp[i][j] =
                            Math.max(includeProfit,
                                     excludeProfit);

                } else {

                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W];
    }
}
```

---

# 🌍 Real-World Applications

| Domain        | Application            |
| ------------- | ---------------------- |
| Finance       | Portfolio Optimization |
| AI            | Resource Allocation    |
| Logistics     | Cargo Loading          |
| Networking    | Bandwidth Optimization |
| Manufacturing | Cost Optimization      |
| Gaming        | Inventory Systems      |

---

# 🏆 Key Takeaways

✅ Recursion is intuitive but inefficient

✅ Memoization avoids repeated calculations

✅ Tabulation provides iterative optimization

✅ DP problems require proper state definition

✅ Knapsack problems are foundational optimization problems

✅ DP is heavily used in industry and research

---

# 🔮 Advanced Topics Ahead

After mastering this module, next topics include:

- Longest Common Subsequence (LCS)
- Matrix Chain Multiplication
- DP on Trees
- Bitmask DP
- Digit DP
- Advanced Optimization Problems

---

# 🛠️ Technologies Used

| Technology          | Purpose              |
| ------------------- | -------------------- |
| Java                | Programming Language |
| IntelliJ IDEA       | IDE                  |
| Dynamic Programming | Algorithm Design     |

---

# 📚 References

- Introduction to Algorithms (CLRS)
- Dynamic Programming by Richard Bellman
- GeeksforGeeks
- Competitive Programming Resources
- Java Documentation

---

# 👨‍💻 Repository Status

<div align="center">

![Completed](https://img.shields.io/badge/Module-Completed-success?style=for-the-badge)

</div>

Topics Covered:

- ✅ 0/1 Knapsack (Recursion)
- ✅ 0/1 Knapsack (Memoization)
- ✅ 0/1 Knapsack (Tabulation)
- ✅ Target Sum Subset
- ✅ Unbounded Knapsack

---
