# 🔁 Recursion — From Basics to Advanced (Java)

A complete guide to **recursion in Java** with clear theory, intuitive explanations, and practical code examples.  
Designed for **beginners → intermediate → advanced** learners.

---

## 📌 Table of Contents

1. [What is Recursion?](#what-is-recursion)
2. [Key Components of Recursion](#key-components-of-recursion)
3. [How Recursion Works (Call Stack)](#how-recursion-works-call-stack)
4. [Base Case vs Recursive Case](#base-case-vs-recursive-case)
5. [Simple Recursion Examples](#simple-recursion-examples)
6. [Recursion vs Iteration](#recursion-vs-iteration)
7. [Common Recursive Problems](#common-recursive-problems)
8. [Advanced Recursion Concepts](#advanced-recursion-concepts)
9. [Tail Recursion](#tail-recursion)
10. [Divide and Conquer](#divide-and-conquer)
11. [Backtracking](#backtracking)
12. [Dynamic Programming vs Recursion](#dynamic-programming-vs-recursion)
13. [Recursion Best Practices](#recursion-best-practices)
14. [Common Mistakes](#common-mistakes)

---

## 🔹 What is Recursion?

**Recursion** is a programming technique where a function **calls itself** to solve smaller instances of the same problem.

> A problem is recursive if it can be broken down into **simpler subproblems of the same type**.

📌 **Real-life analogy**

- Looking into two mirrors facing each other
- Opening nested boxes
- Folder inside a folder inside a folder

---

## 🔑 Key Components of Recursion

Every recursive solution has **two essential parts**:

1. **Base Case** → Stops recursion
2. **Recursive Case** → Function calls itself

Without a base case → ❌ **Infinite recursion**

---

## 🧠 How Recursion Works (Call Stack)

When a recursive function is called:

- Each call is stored in the **call stack**
- Execution resumes **after the recursive call returns**

### Example Call Stack (Factorial of 3)

```

factorial(3)
└── factorial(2)
└── factorial(1)
└── return 1
└── return 2
└── return 6

```

---

## ⚖ Base Case vs Recursive Case

| Part           | Purpose              |
| -------------- | -------------------- |
| Base Case      | Terminates recursion |
| Recursive Case | Reduces problem size |

---

## ✨ Simple Recursion Examples

---

### 1️⃣ Factorial of a Number

**Definition**

```

n! = n × (n-1)!
1! = 1

```

### Java Code

```java
static int factorial(int n) {
    if (n == 1) {          // Base case
        return 1;
    }
    return n * factorial(n - 1); // Recursive case
}

public static void main(String[] args) {
    System.out.println(factorial(5)); // 120
}
```

---

### 2️⃣ Sum of Natural Numbers

```java
static int sumN(int n) {
    if (n == 0) {
        return 0;
    }
    return n + sumN(n - 1);
}

public static void main(String[] args) {
    System.out.println(sumN(5)); // 15
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

⚠️ This solution is **inefficient** (explained later).

---

## 🔁 Recursion vs Iteration

| Recursion              | Iteration                 |
| ---------------------- | ------------------------- |
| Uses function calls    | Uses loops                |
| Cleaner & elegant      | Faster & memory-efficient |
| Uses call stack        | Uses constant memory      |
| Risk of stack overflow | Safer for large inputs    |

---

## 🧩 Common Recursive Problems

- Factorial
- Fibonacci
- Binary Search
- Tree Traversals
- Tower of Hanoi
- Power calculation
- String reversal

---

## 🚀 Advanced Recursion Concepts

---

## 🔹 Tail Recursion

A function is **tail recursive** if the recursive call is the **last operation**.

### Tail Recursive Factorial (Java)

```java
static int factorialTail(int n, int acc) {
    if (n == 0) {
        return acc;
    }
    return factorialTail(n - 1, acc * n);
}

public static void main(String[] args) {
    System.out.println(factorialTail(5, 1)); // 120
}
```

📌 **Java does NOT optimize tail recursion**, so deep recursion may still cause stack overflow.

---

## 🔹 Divide and Conquer

Break problem → solve subproblems → combine results.

### Example: Binary Search (Recursive)

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

Explore all possibilities → **undo (backtrack)** → try next option.

### Example: Generate All Subsets

```java
static void subsets(int[] nums, int index, List<Integer> path, List<List<Integer>> result) {
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

## 🧠 Dynamic Programming vs Recursion

### Problem with Naive Recursion

- Repeated calculations
- Exponential time complexity

---

### Optimization: **Memoization**

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

## ✅ Recursion Best Practices

✔ Always define a clear base case
✔ Reduce problem size every recursive call
✔ Use recursion when it improves clarity
✔ Avoid deep recursion in Java
✔ Prefer iteration when performance matters

---

## ❌ Common Mistakes

❌ Missing base case
❌ Incorrect base condition
❌ Not reducing input size
❌ StackOverflowError
❌ Using recursion where loops are simpler

---

## 📘 Final Thoughts

Recursion is:

- Powerful
- Elegant
- Essential for trees, graphs, and backtracking

But it must be used **wisely** in Java.

> “Recursion is not hard — thinking recursively is.”

---

⭐ If this helped you, **star the repository**
Happy Coding 🚀
