# 🧮 2D Arrays in Java — Complete Guide (Basic to Advanced)

A comprehensive guide to **2D Arrays in Java**, covering:

- Core concepts & theory
- Memory representation
- Common operations
- Important patterns
- Matrix-based problems
- Clean and well-commented Java code

Ideal for **Java beginners, DSA learners, and interview preparation**.

---

## 📚 Table of Contents

- [Introduction](#introduction)
- [What is a 2D Array?](#what-is-a-2d-array)
- [Why Use 2D Arrays?](#why-use-2d-arrays)
- [Memory Representation](#memory-representation)
- [Declaring a 2D Array in Java](#declaring-a-2d-array-in-java)
- [Accessing Elements](#accessing-elements)
- [Traversing a 2D Array](#traversing-a-2d-array)
- [Common 2D Array Operations](#common-2d-array-operations)
- [Important Patterns](#important-patterns)
- [Matrix Problems](#matrix-problems)
- [Time & Space Complexity](#time--space-complexity)
- [Best Practices](#best-practices)
- [Common Mistakes](#common-mistakes)
- [Conclusion](#conclusion)

---

## 📖 Introduction

2D Arrays are one of the most widely used data structures in Java.  
They are used in:

- Matrix computations
- Grid-based problems
- Games & simulations
- Dynamic Programming
- Image processing

Understanding 2D arrays is **mandatory** before learning advanced DSA topics.

---

## ❓ What is a 2D Array?

A **2D Array** is an array of arrays arranged in **rows and columns**.

### Example

```

1 2 3
4 5 6
7 8 9

```

In Java:

- Rows → `matrix.length`
- Columns → `matrix[0].length`
- Element → `matrix[i][j]`

---

## 🤔 Why Use 2D Arrays?

✔ Represents tabular data
✔ Efficient for grid-based problems
✔ Used in matrices and DP
✔ Easy row-column access

---

## 🧠 Memory Representation

In Java:

- A 2D array is **not stored contiguously**
- It is an **array of references to row arrays**

```

matrix → [row0, row1, row2]
row0 → [1, 2, 3]
row1 → [4, 5, 6]
row2 → [7, 8, 9]

```

📌 Java supports **jagged arrays** (rows can have different lengths).

---

## 🧾 Declaring a 2D Array in Java

### 1️⃣ Declaration + Initialization

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
```

---

### 2️⃣ Using `new` Keyword

```java
int[][] matrix = new int[3][4];
```

---

### 3️⃣ Jagged Array

```java
int[][] matrix = new int[3][];
matrix[0] = new int[2];
matrix[1] = new int[4];
matrix[2] = new int[1];
```

---

## 🔍 Accessing Elements

```java
System.out.println(matrix[0][0]); // First element
System.out.println(matrix[2][1]); // Access row 3, col 2
```

---

## 🔄 Traversing a 2D Array

---

### Row-wise Traversal

```java
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}
```

---

### Using Enhanced For Loop

```java
for (int[] row : matrix) {
    for (int val : row) {
        System.out.print(val + " ");
    }
    System.out.println();
}
```

---

### Column-wise Traversal

```java
for (int j = 0; j < matrix[0].length; j++) {
    for (int i = 0; i < matrix.length; i++) {
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}
```

---

## 🧩 Common 2D Array Operations

---

### 1️⃣ Sum of All Elements

```java
int sum = 0;

for (int[] row : matrix) {
    for (int val : row) {
        sum += val;
    }
}

System.out.println(sum);
```

---

### 2️⃣ Find Maximum Element

```java
int max = matrix[0][0];

for (int[] row : matrix) {
    for (int val : row) {
        max = Math.max(max, val);
    }
}

System.out.println(max);
```

---

### 3️⃣ Search an Element

```java
static int[] search(int[][] matrix, int target) {
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
            if (matrix[i][j] == target) {
                return new int[]{i, j};
            }
        }
    }
    return new int[]{-1, -1};
}
```

---

## 🎯 Important Patterns

---

### 🔹 Main Diagonal

```java
for (int i = 0; i < matrix.length; i++) {
    System.out.print(matrix[i][i] + " ");
}
```

---

### 🔹 Reverse Each Row

```java
for (int[] row : matrix) {
    int left = 0, right = row.length - 1;
    while (left < right) {
        int temp = row[left];
        row[left] = row[right];
        row[right] = temp;
        left++;
        right--;
    }
}
```

---

### 🔹 Transpose of Matrix

```java
int rows = matrix.length;
int cols = matrix[0].length;
int[][] transpose = new int[cols][rows];

for (int i = 0; i < rows; i++) {
    for (int j = 0; j < cols; j++) {
        transpose[j][i] = matrix[i][j];
    }
}
```

---

### 🔹 Rotate Matrix 90° Clockwise

```java
// Step 1: Transpose
for (int i = 0; i < n; i++) {
    for (int j = i; j < n; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}

// Step 2: Reverse rows
for (int[] row : matrix) {
    int l = 0, r = n - 1;
    while (l < r) {
        int temp = row[l];
        row[l] = row[r];
        row[r] = temp;
        l++;
        r--;
    }
}
```

---

## 🧠 Matrix Problems

---

### 🔹 Matrix Addition

```java
static int[][] add(int[][] a, int[][] b) {
    int[][] result = new int[a.length][a[0].length];

    for (int i = 0; i < a.length; i++) {
        for (int j = 0; j < a[0].length; j++) {
            result[i][j] = a[i][j] + b[i][j];
        }
    }
    return result;
}
```

---

### 🔹 Matrix Multiplication

```java
static int[][] multiply(int[][] a, int[][] b) {
    int[][] result = new int[a.length][b[0].length];

    for (int i = 0; i < a.length; i++) {
        for (int j = 0; j < b[0].length; j++) {
            for (int k = 0; k < b.length; k++) {
                result[i][j] += a[i][k] * b[k][j];
            }
        }
    }
    return result;
}
```

---

### 🔹 Spiral Traversal

```java
static void spiral(int[][] matrix) {
    int top = 0, bottom = matrix.length - 1;
    int left = 0, right = matrix[0].length - 1;

    while (top <= bottom && left <= right) {
        for (int i = left; i <= right; i++)
            System.out.print(matrix[top][i] + " ");
        top++;

        for (int i = top; i <= bottom; i++)
            System.out.print(matrix[i][right] + " ");
        right--;

        if (top <= bottom) {
            for (int i = right; i >= left; i--)
                System.out.print(matrix[bottom][i] + " ");
            bottom--;
        }

        if (left <= right) {
            for (int i = bottom; i >= top; i--)
                System.out.print(matrix[i][left] + " ");
            left++;
        }
    }
}
```

---

## ⏱ Time & Space Complexity

| Operation      | Complexity     |
| -------------- | -------------- |
| Traversal      | O(rows × cols) |
| Search         | O(rows × cols) |
| Transpose      | O(rows × cols) |
| Rotation       | O(n²)          |
| Multiplication | O(n³)          |

---

## ✅ Best Practices

✔ Always check matrix dimensions
✔ Use `matrix.length` and `matrix[i].length`
✔ Prefer enhanced loops when possible
✔ Handle edge cases (1×N, N×1)
✔ Write reusable methods

---

## ❌ Common Mistakes

❌ Assuming equal row sizes
❌ Index out of bounds
❌ Confusing rows and columns
❌ Modifying matrix unintentionally
❌ Ignoring null checks

---

## 🏁 Conclusion

2D Arrays are a **core concept in Java DSA**.

> Mastering 2D arrays unlocks:

- Matrix algorithms
- Dynamic Programming
- Graph traversal
- Advanced problem solving

---

⭐ If this repository helped you, **give it a star**
Happy Coding 🚀
