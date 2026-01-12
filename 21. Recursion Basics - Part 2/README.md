# 🔁 Recursion — Complete Guide (Basic to Advanced) | Java

A comprehensive guide to **Recursion in Java** covering theory, intuition, examples, and optimized solutions.  
Ideal for **students, interview prep, and competitive programming**.

---

## 📚 Table of Contents

- [Introduction](#introduction)
- [What is Recursion?](#what-is-recursion)
- [Why Use Recursion?](#why-use-recursion)
- [Key Components of Recursion](#key-components-of-recursion)
- [How Recursion Works (Call Stack)](#how-recursion-works-call-stack)
- [Basic Recursion Examples](#basic-recursion-examples)
- [Recursion vs Iteration](#recursion-vs-iteration)
- [Common Recursive Problems](#common-recursive-problems)
- [Advanced Recursion](#advanced-recursion)
  - [Tail Recursion](#tail-recursion)
  - [Divide and Conquer](#divide-and-conquer)
  - [Backtracking](#backtracking)
- [Recursion Optimization](#recursion-optimization)
- [Best Practices](#best-practices)
- [Common Mistakes](#common-mistakes)
- [Conclusion](#conclusion)

---

## 📖 Introduction

Recursion is one of the most important problem-solving techniques in computer science.  
It is heavily used in **trees, graphs, dynamic programming, and backtracking problems**.

Understanding recursion deeply improves:

- Logical thinking
- Code readability
- Algorithm design skills

---

## ❓ What is Recursion?

**Recursion** is a technique where a function **calls itself** to solve a smaller version of the same problem.

> A recursive solution works by breaking a problem into **smaller subproblems** until a simple case is reached.

---

## 🤔 Why Use Recursion?

✔ Cleaner and more readable code  
✔ Natural fit for hierarchical data (trees, graphs)  
✔ Simplifies complex problems  
✔ Core concept in advanced algorithms

---

## 🧩 Key Components of Recursion

Every recursive function must have:

### 1️⃣ Base Case

Stops the recursion and prevents infinite calls.

### 2️⃣ Recursive Case

The function calls itself with a **smaller input**.

❗ Without a base case → **StackOverflowError (Java)**

---

## 🧠 How Recursion Works (Call Stack)

Each recursive call is pushed onto the **call stack**.

### Example: `factorial(3)`

```

factorial(3)
└── factorial(2)
└── factorial(1)
└── return 1
└── return 2
└── return 6

```

Calls resolve **from bottom to top**.

---

## 🔰 Basic Recursion Examples

---

### 1️⃣ Factorial of a Number

**Definition**

```

n! = n × (n-1)!
1! = 1

```

```java
static int factorial(int n) {
    if (n == 1) {          // Base case
        return 1;
    }
    return n * factorial(n - 1);
}

public static void main(String[] args) {
    System.out.println(factorial(5)); // 120
}
```

---

### 2️⃣ Sum of First N Natural Numbers

```java
static int sumN(int n) {
    if (n == 0) {
        return 0;
    }
    return n + sumN(n - 1);
}

public static void main(String[] args) {
    System.out.println(sumN(10)); // 55
}
```

---

### 3️⃣ Fibonacci Series (Naive)

```java
static int fibonacci(int n) {
    if (n <= 1) {
        return n;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
}

public static void main(String[] args) {
    System.out.println(fibonacci(6)); // 8
}
```

⚠️ Inefficient due to repeated calculations.

---

## 🔁 Recursion vs Iteration

| Feature | Recursion      | Iteration       |
| ------- | -------------- | --------------- |
| Code    | Cleaner        | More verbose    |
| Memory  | Uses stack     | Constant memory |
| Speed   | Slower         | Faster          |
| Risk    | Stack overflow | Safe            |

---

## 🧩 Common Recursive Problems

- Factorial
- Fibonacci
- Power of a number
- Binary Search
- Tree Traversals
- Tower of Hanoi
- String reversal

---

## 🚀 Advanced Recursion

---

## 🔹 Tail Recursion

A recursive function where the **last statement** is the recursive call.

```java
static int factorialTail(int n, int result) {
    if (n == 0) {
        return result;
    }
    return factorialTail(n - 1, result * n);
}

public static void main(String[] args) {
    System.out.println(factorialTail(5, 1)); // 120
}
```

📌 Java **does NOT perform tail-call optimization**, so deep recursion can still cause stack overflow.

---

## 🔹 Divide and Conquer

Split → Solve → Combine

### Example: Binary Search

```java
static int binarySearch(int[] arr, int low, int high, int target) {
    if (low > high) {
        return -1;
    }

    int mid = (low + high) / 2;

    if (arr[mid] == target) {
        return mid;
    } else if (target < arr[mid]) {
        return binarySearch(arr, low, mid - 1, target);
    } else {
        return binarySearch(arr, mid + 1, high, target);
    }
}
```

---

## 🔹 Backtracking

Try → Undo → Try next option

### Example: Generate All Subsets

```java
static void subsets(
        int[] nums,
        int index,
        List<Integer> path,
        List<List<Integer>> result) {

    result.add(new ArrayList<>(path));

    for (int i = index; i < nums.length; i++) {
        path.add(nums[i]);
        subsets(nums, i + 1, path, result);
        path.remove(path.size() - 1); // Backtrack
    }
}

public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    List<List<Integer>> result = new ArrayList<>();
    subsets(nums, 0, new ArrayList<>(), result);
    System.out.println(result);
}
```

---

## ⚡ Recursion Optimization

### Problem

Naive recursion repeats calculations.

### Solution: Memoization

```java
static int fibonacci(int n, int[] memo) {
    if (n <= 1) {
        return n;
    }
    if (memo[n] != 0) {
        return memo[n];
    }

    memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
    return memo[n];
}

public static void main(String[] args) {
    int n = 6;
    int[] memo = new int[n + 1];
    System.out.println(fibonacci(n, memo)); // 8
}
```

⏱ Time Complexity improves from `O(2^n)` → `O(n)`

---

## ✅ Best Practices

✔ Always define a base case
✔ Reduce problem size every call
✔ Use recursion only when it simplifies logic
✔ Avoid deep recursion in Java
✔ Prefer iteration for large inputs

---

## ❌ Common Mistakes

❌ Missing base case
❌ Infinite recursion
❌ Wrong base condition
❌ Excessive stack usage
❌ Using recursion where loops are better

---

## 🏁 Conclusion

Recursion is a **powerful and elegant** problem-solving technique.

> If you can think recursively, you can solve complex problems easily.

Master recursion and you'll unlock:

- Tree algorithms
- Graph traversal
- Backtracking
- Dynamic Programming

---

⭐ **If this helped you, consider starring the repository!**
Happy Coding 🚀
