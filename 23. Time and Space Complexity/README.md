# ⏱️ Time and Space Complexity in Java — Complete Guide (Basics → Advanced)

A **detailed and practical README** to master **Time Complexity** and **Space Complexity** using **Java**, with:

- Beginner-friendly explanations
- Big-O / Big-Ω / Big-Θ theory
- Best / Average / Worst case analysis
- Tons of **Java code examples**
- Recursion + stack space
- Master Theorem (Divide & Conquer)
- Amortized analysis
- Data structure complexity table
- Interview patterns & cheat sheet

---

## 📌 Table of Contents

1. [What is Complexity?](#-what-is-complexity)
2. [Why Complexity Matters](#-why-complexity-matters)
3. [Time Complexity Basics](#-time-complexity-basics)
4. [Big-O, Big-Ω, Big-Θ](#-big-o-big-Ω-big-θ)
5. [Best / Average / Worst Case](#-best--average--worst-case)
6. [How to Calculate Time Complexity](#-how-to-calculate-time-complexity)
7. [Common Time Complexities](#-common-time-complexities)
8. [Space Complexity Basics](#-space-complexity-basics)
9. [Auxiliary Space vs Total Space](#-auxiliary-space-vs-total-space)
10. [Time Complexity of Loops](#-time-complexity-of-loops)
11. [Time Complexity of Recursion](#-time-complexity-of-recursion)
12. [Recursion Stack Space Complexity](#-recursion-stack-space-complexity)
13. [Master Theorem (Divide & Conquer)](#-master-theorem-divide--conquer)
14. [Amortized Analysis](#-amortized-analysis)
15. [Complexity of Common Algorithms](#-complexity-of-common-algorithms)
16. [Complexity of Data Structures (Java)](#-complexity-of-data-structures-java)
17. [How to Optimize Complexity](#-how-to-optimize-complexity)
18. [Interview Patterns](#-interview-patterns)
19. [Cheat Sheet Summary](#-cheat-sheet-summary)

---

## 🧠 What is Complexity?

**Complexity** describes how an algorithm performs when the input size increases.

Two major types:

### ⏱️ 1) Time Complexity

How many operations an algorithm performs as `n` grows.

### 💾 2) Space Complexity

How much memory (extra space) an algorithm uses as `n` grows.

> We usually express complexity using **Big-O notation**.

---

## 🎯 Why Complexity Matters

Even if two programs give the same output, one might be **too slow** or **too memory-heavy** for large input.

Example:

- Searching `1,000,000` items:
  - Linear Search → up to `1,000,000` comparisons
  - Binary Search → about `20` comparisons

---

## ⏱️ Time Complexity Basics

Time complexity focuses on **growth rate**, not exact runtime.

We ignore:

- CPU speed
- constant multipliers
- low-level optimizations

We measure:

- How runtime grows when `n` becomes large

---

## 📌 Big-O, Big-Ω, Big-Θ

### ✅ Big-O (O) — Upper Bound

Worst-case growth.

> “The algorithm will take at most this much time.”

Example: `O(n²)` means runtime grows **no faster than** `n²`.

---

### ✅ Big-Ω (Ω) — Lower Bound

Best-case growth.

> “The algorithm will take at least this much time.”

---

### ✅ Big-Θ (Θ) — Tight Bound

Exact growth.

> “The algorithm grows exactly like this.”

---

## 📉 Best / Average / Worst Case

### Example: Linear Search

```java
static int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) return i;
    }
    return -1;
}
```

- **Best case**: target at index 0 → `O(1)`
- **Worst case**: target at last / not found → `O(n)`
- **Average case**: random position → `O(n)`

---

## 🧮 How to Calculate Time Complexity

### ✅ Rule 1: Ignore constants

- `O(2n)` → `O(n)`
- `O(100)` → `O(1)`

---

### ✅ Rule 2: Keep the dominant term

- `O(n² + n)` → `O(n²)`
- `O(n log n + n)` → `O(n log n)`

---

### ✅ Rule 3: Sequential statements add

```java
for (int i = 0; i < n; i++) {} // O(n)
for (int i = 0; i < n; i++) {} // O(n)
```

Total: `O(n + n)` = `O(2n)` = `O(n)`

---

### ✅ Rule 4: Nested loops multiply

```java
for (int i = 0; i < n; i++) {      // n times
    for (int j = 0; j < n; j++) {  // n times
        // constant work
    }
}
```

Total operations: `n * n` → **O(n²)**

---

## 📈 Common Time Complexities

|   Complexity | Name         | Example            |
| -----------: | ------------ | ------------------ |
|       `O(1)` | Constant     | Array access       |
|   `O(log n)` | Logarithmic  | Binary Search      |
|       `O(n)` | Linear       | Linear Search      |
| `O(n log n)` | Linearithmic | Merge Sort         |
|      `O(n²)` | Quadratic    | Bubble Sort        |
|      `O(n³)` | Cubic        | Triple nested loop |
|     `O(2^n)` | Exponential  | Subsets            |
|      `O(n!)` | Factorial    | Permutations       |

---

# ✅ Java Examples (Time Complexity)

## ✅ Example 1: O(1) Constant Time

```java
static int getFirst(int[] arr) {
    return arr[0];
}
```

No matter how big `n` is, it's 1 operation → **O(1)**

---

## ✅ Example 2: O(n) Linear Time

```java
static int sum(int[] arr) {
    int s = 0;
    for (int x : arr) {
        s += x;
    }
    return s;
}
```

Loop runs `n` times → **O(n)**

---

## ✅ Example 3: O(n²) Quadratic Time

```java
static int countPairs(int[] arr) {
    int count = 0;
    int n = arr.length;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            count++;
        }
    }
    return count;
}
```

Nested loops: `n * n` → **O(n²)**

---

## ✅ Example 4: O(log n) Binary Search

```java
static int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) return mid;
        if (arr[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return -1;
}
```

Each step halves the search space → **O(log n)**

---

## ✅ Example 5: O(n log n) Merge Sort

```java
static void mergeSort(int[] arr) {
    if (arr.length <= 1) return;

    int mid = arr.length / 2;
    int[] left = new int[mid];
    int[] right = new int[arr.length - mid];

    System.arraycopy(arr, 0, left, 0, mid);
    System.arraycopy(arr, mid, right, 0, arr.length - mid);

    mergeSort(left);
    mergeSort(right);

    merge(arr, left, right);
}

static void merge(int[] arr, int[] left, int[] right) {
    int i = 0, j = 0, k = 0;

    while (i < left.length && j < right.length) {
        if (left[i] <= right[j]) arr[k++] = left[i++];
        else arr[k++] = right[j++];
    }

    while (i < left.length) arr[k++] = left[i++];
    while (j < right.length) arr[k++] = right[j++];
}
```

Merge sort complexity:

- Divide: `log n`
- Merge work each level: `n`
- Total: **O(n log n)**

Space: uses extra arrays → **O(n)**

---

# 💾 Space Complexity Basics

Space complexity measures memory usage growth with input size.

It includes:

- input memory
- extra arrays, variables
- recursion call stack

---

## 📌 Auxiliary Space vs Total Space

### ✅ Total Space

Input + extra memory.

### ✅ Auxiliary Space

Extra memory **excluding input**.

Example:

```java
static int sum(int[] arr) {
    int s = 0; // O(1) extra space
    for (int x : arr) s += x;
    return s;
}
```

- Auxiliary space: **O(1)**
- Total space: input `O(n)` + extra `O(1)`

---

# 🔁 Time Complexity of Loops

## ✅ Single loop → O(n)

```java
for (int i = 0; i < n; i++) {
    // constant work
}
```

---

## ✅ Nested loops → O(n²)

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        // constant work
    }
}
```

---

## ✅ Loop with half iterations → O(n)

```java
for (int i = 0; i < n; i += 2) {}
```

Runs `n/2` times → still **O(n)**

---

## ✅ Logarithmic loop → O(log n)

```java
for (int i = 1; i < n; i *= 2) {}
```

Values: 1,2,4,8,... → about `log₂(n)` iterations → **O(log n)**

---

## ✅ Mixed nested loops → O(n log n)

```java
for (int i = 0; i < n; i++) {
    for (int j = 1; j < n; j *= 2) {
        // work
    }
}
```

Outer: `n`, inner: `log n` → **O(n log n)**

---

# 🔁 Time Complexity of Recursion

Recursion often forms equations called **recurrence relations**.

---

## ✅ Example 1: Factorial

```java
static long factorial(int n) {
    if (n <= 1) return 1;
    return n * factorial(n - 1);
}
```

- Time: `T(n) = T(n-1) + O(1)` → **O(n)**
- Space (stack): **O(n)**

---

## ✅ Example 2: Fibonacci (Naive)

```java
static int fib(int n) {
    if (n <= 1) return n;
    return fib(n - 1) + fib(n - 2);
}
```

- Time: **O(2^n)** (very slow)
- Space: recursion depth → **O(n)**

---

## ✅ Optimized Fibonacci (DP) → O(n)

```java
static int fibDP(int n) {
    if (n <= 1) return n;

    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
}
```

- Time: **O(n)**
- Space: **O(n)**

---

## ✅ Space-Optimized Fibonacci → O(1) Space

```java
static int fibOptimized(int n) {
    if (n <= 1) return n;

    int prev2 = 0, prev1 = 1;

    for (int i = 2; i <= n; i++) {
        int cur = prev1 + prev2;
        prev2 = prev1;
        prev1 = cur;
    }
    return prev1;
}
```

- Time: **O(n)**
- Space: **O(1)**

---

# 🧠 Recursion Stack Space Complexity

Even if recursion does not create arrays, it uses **stack frames**.

Example:

```java
static void printN(int n) {
    if (n == 0) return;
    System.out.println(n);
    printN(n - 1);
}
```

- Time: **O(n)**
- Space: recursion depth → **O(n)**

---

# 📌 Master Theorem (Divide & Conquer)

Used for recurrence relations like:

> `T(n) = aT(n/b) + f(n)`

Where:

- `a` = number of subproblems
- `n/b` = size of each subproblem
- `f(n)` = extra work (merge, partition, etc.)

---

## 🔥 Master Theorem Cases

Let `n^(log_b(a)) = n^k`

### Case 1: f(n) smaller

If `f(n) = O(n^(k - ε))`
➡️ `T(n) = Θ(n^k)`

---

### Case 2: f(n) same

If `f(n) = Θ(n^k log^p n)`
➡️ `T(n) = Θ(n^k log^(p+1) n)`

---

### Case 3: f(n) bigger

If `f(n) = Ω(n^(k + ε))` and regularity condition holds
➡️ `T(n) = Θ(f(n))`

---

## ✅ Example: Merge Sort

Recurrence:
`T(n) = 2T(n/2) + O(n)`

- a = 2
- b = 2
- f(n) = n
- n^(log₂2) = n

Same case → **Θ(n log n)**

---

# ⚡ Amortized Analysis

Amortized analysis = average cost over a sequence of operations.

Even if some operations are expensive, overall cost is small.

---

## ✅ Example: Dynamic Array (ArrayList)

`ArrayList.add()` is usually O(1), but sometimes resizing happens:

- Most adds: **O(1)**
- Occasionally: resize → **O(n)**

But across `n` adds:
➡️ Total time = **O(n)**
➡️ Amortized per add = **O(1)**

---

# 📚 Complexity of Common Algorithms

## 🔍 Searching

| Algorithm     | Time     | Space |
| ------------- | -------- | ----- |
| Linear Search | O(n)     | O(1)  |
| Binary Search | O(log n) | O(1)  |

---

## 🧾 Sorting

| Algorithm      | Best       | Average    | Worst      | Space    |
| -------------- | ---------- | ---------- | ---------- | -------- |
| Bubble Sort    | O(n)       | O(n²)      | O(n²)      | O(1)     |
| Selection Sort | O(n²)      | O(n²)      | O(n²)      | O(1)     |
| Insertion Sort | O(n)       | O(n²)      | O(n²)      | O(1)     |
| Merge Sort     | O(n log n) | O(n log n) | O(n log n) | O(n)     |
| Quick Sort     | O(n log n) | O(n log n) | O(n²)      | O(log n) |

---

## 📌 Why QuickSort Space is O(log n)?

Because recursion depth average is `log n`.

Worst-case recursion depth is `O(n)`.

---

# 🧱 Complexity of Data Structures (Java)

## ✅ Arrays

| Operation       | Time |
| --------------- | ---- |
| Access by index | O(1) |
| Search          | O(n) |
| Insert (end)    | O(1) |
| Insert (middle) | O(n) |
| Delete (middle) | O(n) |

---

## ✅ ArrayList

| Operation     | Time           |
| ------------- | -------------- |
| get(i)        | O(1)           |
| add(end)      | O(1) amortized |
| add(index)    | O(n)           |
| remove(index) | O(n)           |

---

## ✅ LinkedList

| Operation             | Time                    |
| --------------------- | ----------------------- |
| Access by index       | O(n)                    |
| Insert/Delete at head | O(1)                    |
| Insert/Delete at tail | O(1) (if doubly linked) |
| Search                | O(n)                    |

---

## ✅ HashMap / HashSet

| Operation          | Average | Worst |
| ------------------ | ------- | ----- |
| put / get / remove | O(1)    | O(n)  |

Worst-case happens due to hash collisions (rare with good hashing).

---

## ✅ Stack / Queue

| Operation       | Time |
| --------------- | ---- |
| push/pop        | O(1) |
| enqueue/dequeue | O(1) |

---

## ✅ Tree (BST)

| Operation            | Average  | Worst |
| -------------------- | -------- | ----- |
| insert/search/delete | O(log n) | O(n)  |

Worst case happens when BST becomes skewed.

---

## ✅ Heap (PriorityQueue)

| Operation      | Time     |
| -------------- | -------- |
| insert         | O(log n) |
| remove min/max | O(log n) |
| peek           | O(1)     |

---

# 🚀 How to Optimize Complexity

## ✅ 1) Replace nested loops with hashing

Instead of `O(n²)` pair search:

- Use HashSet → `O(n)`

Example: Two Sum

### ❌ Brute force O(n²)

```java
static boolean twoSumBrute(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[i] + arr[j] == target) return true;
        }
    }
    return false;
}
```

### ✅ Optimized O(n)

```java
import java.util.HashSet;

static boolean twoSumOptimized(int[] arr, int target) {
    HashSet<Integer> set = new HashSet<>();
    for (int x : arr) {
        int need = target - x;
        if (set.contains(need)) return true;
        set.add(x);
    }
    return false;
}
```

---

## ✅ 2) Use two pointers

Example: Check if array has pair with sum `k` (sorted)

```java
static boolean twoSumSorted(int[] arr, int k) {
    int i = 0, j = arr.length - 1;
    while (i < j) {
        int sum = arr[i] + arr[j];
        if (sum == k) return true;
        if (sum < k) i++;
        else j--;
    }
    return false;
}
```

Time: **O(n)**
Space: **O(1)**

---

## ✅ 3) Use prefix sums

Example: range sum queries

```java
static int[] prefixSum(int[] arr) {
    int n = arr.length;
    int[] pref = new int[n];
    pref[0] = arr[0];
    for (int i = 1; i < n; i++) {
        pref[i] = pref[i - 1] + arr[i];
    }
    return pref;
}

static int rangeSum(int[] pref, int l, int r) {
    return l == 0 ? pref[r] : pref[r] - pref[l - 1];
}
```

- Precompute: O(n)
- Each query: O(1)

---

# 🧩 Interview Patterns

## Common patterns and their usual complexity:

| Pattern        | Typical Time            | Typical Space |
| -------------- | ----------------------- | ------------- |
| Two pointers   | O(n)                    | O(1)          |
| Sliding window | O(n)                    | O(1) / O(k)   |
| Hashing        | O(n)                    | O(n)          |
| Sorting + scan | O(n log n)              | O(1)/O(n)     |
| BFS/DFS graph  | O(V+E)                  | O(V)          |
| DP             | O(states × transitions) | O(states)     |

---

# 🧾 Cheat Sheet Summary

## ⏱️ Time Complexity Cheat Sheet

- `O(1)` → constant
- `O(log n)` → divide by 2 each step
- `O(n)` → single loop
- `O(n log n)` → sort / divide & conquer
- `O(n²)` → nested loops
- `O(2^n)` → subsets / recursion branching
- `O(n!)` → permutations

---

## 💾 Space Complexity Cheat Sheet

- No extra structures → `O(1)`
- Extra array of size n → `O(n)`
- Recursion depth n → `O(n)`
- Merge sort extra arrays → `O(n)`
- BFS queue / DFS stack → `O(V)`

---

# ✅ Practice Questions (Recommended)

### Easy

- Find max in array → O(n)
- Reverse array → O(n)
- Linear search → O(n)

### Medium

- Two Sum (HashSet) → O(n)
- Subarray sum (prefix) → O(n)
- Binary search → O(log n)

### Hard

- Merge sort → O(n log n)
- Quick sort worst-case analysis
- Fibonacci optimized DP

---

# 📌 Final Notes

✅ Always analyze:

1. **Loops**
2. **Nested loops**
3. **Recursion calls**
4. **Extra memory**
5. **Dominant term**

🎯 For interviews, your goal is usually:

- **Time: O(n) or O(n log n)**
- **Space: O(1) or O(n)** depending on problem
