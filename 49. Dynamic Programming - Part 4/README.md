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

## 📘 Comprehensive Dynamic Programming Implementations using Java

### Classical DP Problems • Academic Explanations • Complexity Analysis • Clean Java Implementations

</div>

---

# 📑 Table of Contents

- [📖 Introduction](#-introduction)
- [🧠 Dynamic Programming Theory](#-dynamic-programming-theory)
- [⚙️ DP Approaches Used](#️-dp-approaches-used)
- [📚 Problems Covered](#-problems-covered)
  - [1️⃣ Longest Common Substring](#1️⃣-longest-common-substring)
  - [2️⃣ Longest Increasing Subsequence](#2️⃣-longest-increasing-subsequence-lis)
  - [3️⃣ Edit Distance](#3️⃣-edit-distance)
  - [4️⃣ String Conversion](#4️⃣-string-conversion)
- [📊 Complexity Analysis](#-overall-complexity-analysis)
- [🗂️ Project Structure](#️-project-structure)
- [🎯 Learning Outcomes](#-learning-outcomes)
- [🛠️ Technologies Used](#️-technologies-used)
- [🎓 Academic Perspective](#-academic-perspective)
- [🚀 Future Enhancements](#-future-enhancements)
- [🌟 Conclusion](#-conclusion)

---

# 📖 Introduction

This repository contains a professional collection of **Dynamic Programming (DP)** problems implemented using **Java**.

The primary goal of this repository is to demonstrate how complex optimization problems evolve systematically from:

```text
Brute Force Recursion
        ↓
Memoization (Top-Down DP)
        ↓
Tabulation (Bottom-Up DP)
```

This repository is designed for:

- 🎓 Academic Learning
- 💼 Interview Preparation
- 🏆 Competitive Programming
- 🔬 Research & Algorithm Analysis
- 📚 University Coursework
- 🚀 Professional Portfolio Development

---

# 🧠 Dynamic Programming Theory

Dynamic Programming (DP) is an optimization technique used to solve problems with:

---

## ✅ Overlapping Subproblems

The same subproblem gets solved repeatedly.

Dynamic Programming avoids recalculating states by storing intermediate results.

---

## ✅ Optimal Substructure

The optimal solution can be constructed from optimal solutions of smaller subproblems.

---

# 🔄 DP Transformation Flow

```text
Recursive Brute Force
        ↓
Repeated States
        ↓
Memoization (Caching)
        ↓
Tabulation (Iterative DP)
        ↓
Space Optimization
```

---

# ⚙️ DP Approaches Used

| Approach       | Description                       | Optimization |
| -------------- | --------------------------------- | ------------ |
| 🔁 Recursion   | Brute-force recursive exploration | ❌           |
| 🧠 Memoization | Top-Down DP with caching          | ✅           |
| 📊 Tabulation  | Bottom-Up iterative DP            | ✅           |

---

# 📚 Problems Covered

| #   | Problem                        | Concepts              |
| --- | ------------------------------ | --------------------- |
| 1   | Longest Common Substring       | String DP             |
| 2   | Longest Increasing Subsequence | Sequence DP           |
| 3   | Edit Distance                  | String Transformation |
| 4   | String Conversion              | Insert/Delete DP      |

---

---

# 1️⃣ Longest Common Substring

<div align="center">

<img src="https://media.geeksforgeeks.org/wp-content/uploads/20231110113916/lcs.webp" width="75%" />

</div>

---

## 📌 Problem Statement

Given two strings:

```text
S1 = "ABCDE"
S2 = "ABGCE"
```

Determine the length of the **Longest Common Substring**.

> ⚠️ A substring must be contiguous.

---

# 🧠 Theory

Unlike subsequences, substrings require:

```text
Continuous matching characters
```

If characters match:

```text
dp[i][j] = dp[i-1][j-1] + 1
```

Else:

```text
dp[i][j] = 0
```

---

# 🧾 Example

```text
S1 = "ABCDE"
S2 = "ABGCE"

Longest Common Substring = "AB"

Length = 2
```

---

# 🪜 Algorithm

## Step 1

Compare characters from both strings.

## Step 2

If characters match:

- Extend substring length.

## Step 3

If characters mismatch:

- Reset current DP cell to 0.

## Step 4

Track the maximum substring length.

---

# 📝 Pseudocode

```text
LCS(s1, s2):

    for i from 1 to n:

        for j from 1 to m:

            if s1[i-1] == s2[j-1]:

                dp[i][j] =
                    dp[i-1][j-1] + 1

            else:

                dp[i][j] = 0

    return maximum value in dp
```

---

# 📈 Complexity Analysis

| Approach    | Time Complexity | Space Complexity |
| ----------- | --------------- | ---------------- |
| Recursion   | O(2^(n+m))      | O(n+m)           |
| Memoization | O(n × m)        | O(n × m)         |
| Tabulation  | O(n × m)        | O(n × m)         |

---

# 💻 Java Implementation

```java
public static int longestCommonSubstringTab(String s1, String s2) {

    int n = s1.length();
    int m = s2.length();

    int[][] dp = new int[n + 1][m + 1];

    int ans = 0;

    for (int i = 1; i <= n; i++) {

        for (int j = 1; j <= m; j++) {

            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

                dp[i][j] = dp[i - 1][j - 1] + 1;

                ans = Math.max(ans, dp[i][j]);

            } else {

                dp[i][j] = 0;
            }
        }
    }

    return ans;
}
```

---

---

# 2️⃣ Longest Increasing Subsequence (LIS)

<div align="center">

<img src="https://upload.wikimedia.org/wikipedia/commons/1/1b/Longest_increasing_subsequence.svg" width="75%" />

</div>

---

## 📌 Problem Statement

Given an array:

```text
[50, 3, 10, 7, 40, 80]
```

Find the length of the **Longest Increasing Subsequence**.

---

# 🧠 Theory

At every index:

- Include current element
- Exclude current element

This creates the classical:

```text
Include / Exclude DP Pattern
```

---

# 🔄 Recursive State

```text
(curr, prev)
```

Where:

| Variable | Meaning                   |
| -------- | ------------------------- |
| curr     | Current index             |
| prev     | Previously selected index |

---

# 🧾 Example

```text
LIS = [3, 7, 40, 80]

Length = 4
```

---

# 🪜 Algorithm

## Step 1

Exclude current element.

## Step 2

If increasing order is maintained:

- Include current element.

## Step 3

Return maximum of both choices.

---

# 📝 Pseudocode

```text
LIS(curr, prev):

    if curr == n:
        return 0

    exclude =
        LIS(curr + 1, prev)

    include = 0

    if arr[curr] > arr[prev]:

        include =
            1 + LIS(curr + 1, curr)

    return max(include, exclude)
```

---

# 📈 Complexity Analysis

| Approach    | Time Complexity | Space Complexity |
| ----------- | --------------- | ---------------- |
| Recursion   | O(2^n)          | O(n)             |
| Memoization | O(n²)           | O(n²)            |
| Tabulation  | O(n²)           | O(n)             |

---

# 💻 Java Implementation

```java
public static int lisTab(int[] arr) {

    int n = arr.length();

    int[] dp = new int[n];

    Arrays.fill(dp, 1);

    int ans = 1;

    for (int i = 1; i < n; i++) {

        for (int j = 0; j < i; j++) {

            if (arr[i] > arr[j]) {

                dp[i] =
                    Math.max(dp[i], dp[j] + 1);
            }
        }

        ans = Math.max(ans, dp[i]);
    }

    return ans;
}
```

---

---

# 3️⃣ Edit Distance

<div align="center">

<img src="https://miro.medium.com/v2/resize:fit:1400/1*6X8tM0mB6m7R8xjvD8Vw7Q.png" width="75%" />

</div>

---

## 📌 Problem Statement

Convert one string into another using:

- Insert
- Delete
- Replace

Determine the minimum operations required.

---

# 🧠 Theory

Edit Distance is a classical String DP problem.

Three operations are allowed:

| Operation | Meaning           |
| --------- | ----------------- |
| Insert    | Add character     |
| Delete    | Remove character  |
| Replace   | Replace character |

---

# 🔄 DP Transition

```text
dp[i][j] =
1 + min(
    insert,
    delete,
    replace
)
```

---

# 🧾 Example

```text
word1 = "intention"
word2 = "execution"

Answer = 5
```

---

# 🪜 Algorithm

## Step 1

If characters match:

- Move diagonally.

## Step 2

Else:

- Insert
- Delete
- Replace

## Step 3

Take minimum operations.

---

# 📝 Pseudocode

```text
EditDistance(i, j):

    if i == n:
        return m-j

    if j == m:
        return n-i

    if s1[i] == s2[j]:

        return EditDistance(i+1, j+1)

    insert =
        1 + EditDistance(i, j+1)

    delete =
        1 + EditDistance(i+1, j)

    replace =
        1 + EditDistance(i+1, j+1)

    return min(insert, delete, replace)
```

---

# 📈 Complexity Analysis

| Approach    | Time Complexity | Space Complexity |
| ----------- | --------------- | ---------------- |
| Recursion   | O(3^(n+m))      | O(n+m)           |
| Memoization | O(n × m)        | O(n × m)         |
| Tabulation  | O(n × m)        | O(n × m)         |

---

# 💻 Java Implementation

```java
int insert = 1 + dp[i][j + 1];

int delete = 1 + dp[i + 1][j];

int replace = 1 + dp[i + 1][j + 1];

dp[i][j] =
    Math.min(insert,
    Math.min(delete, replace));
```

---

---

# 4️⃣ String Conversion

<div align="center">

<img src="https://images.unsplash.com/photo-1516321318423-f06f85e504b3?q=80&w=1400&auto=format&fit=crop" width="75%" />

</div>

---

## 📌 Problem Statement

Convert one string into another using only:

- Insertions
- Deletions

Replacement is NOT allowed.

---

# 🧠 Theory

This is a restricted version of Edit Distance.

Allowed operations:

✅ Insert
✅ Delete
❌ Replace

---

# 🧾 Example

```text
str1 = "pear"
str2 = "sea"

Answer = 3
```

---

# 🔄 DP Transition

```text
dp[i][j] =
1 + min(
    insert,
    delete
)
```

---

# 🪜 Algorithm

## Step 1

If characters match:

- Move forward.

## Step 2

Otherwise:

- Insert
- Delete

## Step 3

Return minimum operations.

---

# 📝 Pseudocode

```text
Convert(i, j):

    if i == n:
        return m-j

    if j == m:
        return n-i

    if s1[i] == s2[j]:

        return Convert(i+1, j+1)

    insert =
        1 + Convert(i, j+1)

    delete =
        1 + Convert(i+1, j)

    return min(insert, delete)
```

---

# 📈 Complexity Analysis

| Approach    | Time Complexity | Space Complexity |
| ----------- | --------------- | ---------------- |
| Recursion   | O(2^(n+m))      | O(n+m)           |
| Memoization | O(n × m)        | O(n × m)         |
| Tabulation  | O(n × m)        | O(n × m)         |

---

# 💻 Java Implementation

```java
int insert = 1 + dp[i][j + 1];

int delete = 1 + dp[i + 1][j];

dp[i][j] =
    Math.min(insert, delete);
```

---

# 📊 Overall Complexity Analysis

| Problem                  | Recursion   | Memoization | Tabulation |
| ------------------------ | ----------- | ----------- | ---------- |
| Longest Common Substring | Exponential | O(n × m)    | O(n × m)   |
| LIS                      | Exponential | O(n²)       | O(n²)      |
| Edit Distance            | Exponential | O(n × m)    | O(n × m)   |
| String Conversion        | Exponential | O(n × m)    | O(n × m)   |

---

# 🗂️ Project Structure

```text
DynamicProgramming/
│
├── LCS.java
├── LIS.java
├── EditDistance.java
├── StringConversion.java
└── README.md
```

---

# 🎯 Learning Outcomes

After completing this module:

✅ Recursive Problem Solving
✅ Top-Down Dynamic Programming
✅ Bottom-Up Dynamic Programming
✅ DP State Design
✅ String DP Problems
✅ Sequence DP Problems
✅ Complexity Optimization
✅ Include/Exclude Recursion
✅ State Transition Analysis
✅ Space-Time Tradeoffs

---

# 🛠️ Technologies Used

| Technology                  | Purpose                   |
| --------------------------- | ------------------------- |
| Java                        | Core Programming Language |
| IntelliJ IDEA               | Development Environment   |
| Dynamic Programming         | Algorithm Design          |
| Object-Oriented Programming | Code Structure            |

---

# 🎓 Academic Perspective

This repository demonstrates:

- Mathematical recurrence formulation
- Recursive tree optimization
- Dynamic Programming state design
- Time-space complexity analysis
- Algorithm engineering
- Clean coding architecture
- Research-oriented implementation structure

Suitable for:

- University Coursework
- Coding Interviews
- Competitive Programming
- Research Preparation
- Technical Portfolio Projects

---

# 🚀 Future Enhancements

- Matrix Chain Multiplication
- Wildcard Matching
- 0/1 Knapsack
- DP on Trees
- Bitmask DP
- Space Optimized DP
- Advanced String DP

---

# 🤝 Contribution

Contributions are welcome.

Possible improvements:

- Add visualizations
- Add animations
- Add optimized implementations
- Add space-optimized DP
- Improve documentation

---

# 📜 License

This project is licensed under the MIT License.

---

# 🌟 Conclusion

This repository provides a complete academic and professional foundation for mastering Dynamic Programming using Java.

The implementations progress systematically from:

```text
Recursion
    ↓
Memoization
    ↓
Tabulation
```

while emphasizing:

- theoretical understanding
- algorithmic optimization
- mathematical reasoning
- professional coding practices
- research-oriented documentation

---

<div align="center">

# ⭐ If you found this repository useful, consider giving it a star ⭐

</div>

---

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

<div align="center">

# 🚀 Dynamic Programming in Java

### From Recursive Thinking to Optimized DP Solutions

<img src="https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=java" />
<img src="https://img.shields.io/badge/Topic-Dynamic%20Programming-blue?style=for-the-badge" />
<img src="https://img.shields.io/badge/Level-Intermediate%20to%20Advanced-success?style=for-the-badge" />
<img src="https://img.shields.io/badge/Paradigm-Recursion%20%7C%20Memoization%20%7C%20Tabulation-purple?style=for-the-badge" />

<br>
<br>

> A complete academic and research-oriented implementation of classical Dynamic Programming problems using Java.

</div>

---

# 📚 Overview

This repository contains a structured collection of **Dynamic Programming (DP)** problems implemented in Java using:

- 🔁 Recursion
- 🧠 Memoization (Top-Down DP)
- 📊 Tabulation (Bottom-Up DP)

The goal of this repository is not only to provide code implementations, but also to explain:

- Theoretical foundations
- Recursive state transitions
- DP optimization strategies
- Time & space complexity analysis
- Interview-oriented approaches
- Research-level algorithmic understanding

---

# 🧠 What is Dynamic Programming?

Dynamic Programming is an optimization technique used when a problem has:

## ✅ Overlapping Subproblems

The same subproblem gets solved multiple times.

## ✅ Optimal Substructure

The optimal solution can be constructed from optimal solutions of smaller subproblems.

---

# ⚡ DP Workflow

```text
Brute Force Recursion
        ↓
Overlapping Subproblems
        ↓
Memoization (Caching)
        ↓
Tabulation (Iterative DP)
        ↓
Space Optimization
```

---

# 🏗️ Repository Structure

```text
📦 Dynamic-Programming-Java
 ┣ 📄 LCS.java
 ┣ 📄 LIS.java
 ┣ 📄 EditDistance.java
 ┣ 📄 StringConversion.java
 ┗ 📄 README.md
```

---

# 📖 Problems Covered

| #   | Problem                        | Concepts              |
| --- | ------------------------------ | --------------------- |
| 1   | Longest Common Substring       | String DP             |
| 2   | Longest Increasing Subsequence | Sequence DP           |
| 3   | Edit Distance                  | String Transformation |
| 4   | String Conversion              | Insert/Delete DP      |

---

<br>

<div align="center">

# 🧩 1. Longest Common Substring

<img src="https://img.shields.io/badge/Problem-Longest%20Common%20Substring-0A66C2?style=for-the-badge" />

</div>

---

# 📌 Problem Statement

Given two strings:

```text
S1 = "ABCDE"
S2 = "ABGCE"
```

Find the length of the **longest common substring**.

> ⚠️ A substring must be contiguous.

---

# 🧠 Theory

Unlike subsequences, substrings require:

```text
Continuous matching characters
```

---

# 🔄 DP Transition

If characters match:

```text
dp[i][j] = dp[i-1][j-1] + 1
```

Otherwise:

```text
dp[i][j] = 0
```

---

# 🧪 Example

```text
S1 = "ABCDE"
S2 = "ABGCE"

Longest Common Substring = "AB"
Length = 2
```

---

# 🪜 Algorithm

## Step 1

Compare characters from both strings.

## Step 2

If characters match:

- Extend substring length.

## Step 3

If characters do not match:

- Reset DP cell to 0.

## Step 4

Track maximum length found.

---

# 🧾 Pseudocode

```text
function LCS(s1, s2):

    for i from 1 to n:
        for j from 1 to m:

            if s1[i-1] == s2[j-1]:
                dp[i][j] =
                    dp[i-1][j-1] + 1

            else:
                dp[i][j] = 0

    return maximum value in dp
```

---

# ⏱️ Complexity Analysis

| Approach    | Time       | Space   |
| ----------- | ---------- | ------- |
| Recursion   | O(2^(n+m)) | O(n+m)  |
| Memoization | O(n\*m)    | O(n\*m) |
| Tabulation  | O(n\*m)    | O(n\*m) |

---

# 💻 Code Implementation

```java
public static int longestCommonSubstringTab(String s1, String s2) {

    int n = s1.length();
    int m = s2.length();

    int[][] dp = new int[n + 1][m + 1];

    int ans = 0;

    for (int i = 1; i <= n; i++) {

        for (int j = 1; j <= m; j++) {

            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

                dp[i][j] = dp[i - 1][j - 1] + 1;

                ans = Math.max(ans, dp[i][j]);

            } else {

                dp[i][j] = 0;
            }
        }
    }

    return ans;
}
```

---

<br>

<div align="center">

# 📈 2. Longest Increasing Subsequence (LIS)

<img src="https://img.shields.io/badge/Problem-LIS-success?style=for-the-badge" />

</div>

---

# 📌 Problem Statement

Given an array:

```text
[50, 3, 10, 7, 40, 80]
```

Find the length of the longest increasing subsequence.

---

# 🧠 Theory

At every index:

- Include current element
- Exclude current element

This creates an:

```text
Include / Exclude DP Pattern
```

---

# 🔄 Recursive State

```text
(curr, prev)
```

Where:

- `curr` → current index
- `prev` → previously selected index

---

# 🧪 Example

```text
LIS = [3, 7, 40, 80]
Length = 4
```

---

# 🪜 Algorithm

## Step 1

Try excluding current element.

## Step 2

If increasing order is maintained:

- include current element.

## Step 3

Take maximum.

---

# 🧾 Pseudocode

```text
function LIS(curr, prev):

    if curr == n:
        return 0

    exclude =
        LIS(curr+1, prev)

    include = 0

    if arr[curr] > arr[prev]:
        include =
            1 + LIS(curr+1, curr)

    return max(include, exclude)
```

---

# ⏱️ Complexity Analysis

| Approach    | Time   | Space |
| ----------- | ------ | ----- |
| Recursion   | O(2^n) | O(n)  |
| Memoization | O(n²)  | O(n²) |
| Tabulation  | O(n²)  | O(n)  |

---

# 💻 Code Implementation

```java
public static int lisTab(int[] arr) {

    int n = arr.length;

    int[] dp = new int[n];

    Arrays.fill(dp, 1);

    int ans = 1;

    for (int i = 1; i < n; i++) {

        for (int j = 0; j < i; j++) {

            if (arr[i] > arr[j]) {

                dp[i] =
                    Math.max(dp[i], dp[j] + 1);
            }
        }

        ans = Math.max(ans, dp[i]);
    }

    return ans;
}
```

---

<br>

<div align="center">

# ✏️ 3. Edit Distance

<img src="https://img.shields.io/badge/Problem-Edit%20Distance-red?style=for-the-badge" />

</div>

---

# 📌 Problem Statement

Convert one string into another using:

- Insert
- Delete
- Replace

Find the minimum number of operations required.

---

# 🧠 Theory

This problem is based on:

```text
String Transformation using DP
```

Three operations are allowed:

| Operation | Meaning           |
| --------- | ----------------- |
| Insert    | Add character     |
| Delete    | Remove character  |
| Replace   | Replace character |

---

# 🔄 DP Transition

```text
dp[i][j] =
1 + min(
    insert,
    delete,
    replace
)
```

---

# 🧪 Example

```text
word1 = "intention"
word2 = "execution"

Answer = 5
```

---

# 🪜 Algorithm

## Step 1

If characters match:

- move both pointers.

## Step 2

Otherwise try:

- insert
- delete
- replace

## Step 3

Return minimum operation count.

---

# 🧾 Pseudocode

```text
function EditDistance(i, j):

    if i == n:
        return m-j

    if j == m:
        return n-i

    if s1[i] == s2[j]:
        return EditDistance(i+1, j+1)

    insert =
        1 + EditDistance(i, j+1)

    delete =
        1 + EditDistance(i+1, j)

    replace =
        1 + EditDistance(i+1, j+1)

    return min(insert, delete, replace)
```

---

# ⏱️ Complexity Analysis

| Approach    | Time       | Space   |
| ----------- | ---------- | ------- |
| Recursion   | O(3^(n+m)) | O(n+m)  |
| Memoization | O(n\*m)    | O(n\*m) |
| Tabulation  | O(n\*m)    | O(n\*m) |

---

# 💻 Code Implementation

```java
int insert = 1 + dp[i][j + 1];

int delete = 1 + dp[i + 1][j];

int replace = 1 + dp[i + 1][j + 1];

dp[i][j] =
    Math.min(insert,
    Math.min(delete, replace));
```

---

<br>

<div align="center">

# 🔄 4. String Conversion

<img src="https://img.shields.io/badge/Problem-String%20Conversion-orange?style=for-the-badge" />

</div>

---

# 📌 Problem Statement

Convert one string into another using only:

- Insertions
- Deletions

Replacement is NOT allowed.

---

# 🧠 Theory

This is a restricted version of Edit Distance.

Allowed operations:

✅ Insert
✅ Delete
❌ Replace

---

# 🧪 Example

```text
str1 = "pear"
str2 = "sea"

Answer = 3
```

---

# 🔄 DP Transition

```text
dp[i][j] =
1 + min(
    insert,
    delete
)
```

---

# 🪜 Algorithm

## Step 1

If characters match:

- move forward.

## Step 2

Otherwise:

- insert
- delete

## Step 3

Take minimum operations.

---

# 🧾 Pseudocode

```text
function Convert(i, j):

    if i == n:
        return m-j

    if j == m:
        return n-i

    if s1[i] == s2[j]:
        return Convert(i+1, j+1)

    insert =
        1 + Convert(i, j+1)

    delete =
        1 + Convert(i+1, j)

    return min(insert, delete)
```

---

# ⏱️ Complexity Analysis

| Approach    | Time       | Space   |
| ----------- | ---------- | ------- |
| Recursion   | O(2^(n+m)) | O(n+m)  |
| Memoization | O(n\*m)    | O(n\*m) |
| Tabulation  | O(n\*m)    | O(n\*m) |

---

# 💻 Code Implementation

```java
int insert = 1 + dp[i][j + 1];

int delete = 1 + dp[i + 1][j];

dp[i][j] =
    Math.min(insert, delete);
```

---

# 📊 Overall Complexity Summary

| Problem                  | Recursion   | Memoization | Tabulation |
| ------------------------ | ----------- | ----------- | ---------- |
| Longest Common Substring | Exponential | O(n\*m)     | O(n\*m)    |
| LIS                      | Exponential | O(n²)       | O(n²)      |
| Edit Distance            | Exponential | O(n\*m)     | O(n\*m)    |
| String Conversion        | Exponential | O(n\*m)     | O(n\*m)    |

---

# 🎯 Learning Outcomes

After completing this module, you will understand:

- Recursive state design
- DP state transitions
- Top-down vs bottom-up DP
- String DP problems
- Sequence DP problems
- Include/exclude recursion
- Optimization techniques
- Time-space tradeoffs
- Classical interview DP patterns

---

# 🛠️ Technologies Used

| Technology          | Purpose                 |
| ------------------- | ----------------------- |
| Java                | Programming Language    |
| IntelliJ IDEA       | Development Environment |
| Dynamic Programming | Algorithm Design        |

---

# 🚀 Future Improvements

- Space optimized DP
- Bitmask DP
- Digit DP
- Matrix Chain Multiplication
- Partition DP
- Advanced Graph DP
- DP on Trees

---

# 👨‍💻 Author

### Satinder Singh

Dynamic Programming implementations and academic documentation using Java.

---

<div align="center">

# ⭐ If you found this repository useful, consider giving it a star!

</div>
