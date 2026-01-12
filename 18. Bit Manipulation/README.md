# 🔢 Bit Manipulation in Java — Complete Guide (Basic to Advanced)

A comprehensive guide to **Bit Manipulation in Java**, covering:

- Binary number system
- Bitwise operators
- Common bit tricks
- Important formulas
- Interview-level problems
- Clean and well-commented Java code

Perfect for **DSA learners, competitive programmers, and interview preparation**.

---

## 📚 Table of Contents

- [Introduction](#introduction)
- [Binary Number System](#binary-number-system)
- [Why Bit Manipulation?](#why-bit-manipulation)
- [Bitwise Operators in Java](#bitwise-operators-in-java)
- [Left Shift & Right Shift](#left-shift--right-shift)
- [Common Bit Operations](#common-bit-operations)
- [Important Bit Tricks](#important-bit-tricks)
- [Bit Manipulation Problems](#bit-manipulation-problems)
- [Time & Space Complexity](#time--space-complexity)
- [Best Practices](#best-practices)
- [Common Mistakes](#common-mistakes)
- [Conclusion](#conclusion)

---

## 📖 Introduction

Bit Manipulation is a powerful technique where we **directly work with bits (0 and 1)** of numbers.

It is widely used in:

- Low-level programming
- Cryptography
- Competitive programming
- Optimized algorithms
- Interview problem solving

---

## 🔢 Binary Number System

Computers store data in **binary (base-2)**.

Example:

```

Decimal: 13
Binary : 1101

```

Each position represents a power of 2:

```

1 1 0 1
8 4 2 1

```

---

## 🤔 Why Bit Manipulation?

✔ Faster than arithmetic operations
✔ Uses constant memory
✔ Elegant solutions for complex problems
✔ Essential for high-performance code

---

## ⚙ Bitwise Operators in Java

| Operator | Name                 | Description             |
| -------- | -------------------- | ----------------------- | ----------------- |
| `&`      | AND                  | 1 if both bits are 1    |
| `        | `                    | OR                      | 1 if any bit is 1 |
| `^`      | XOR                  | 1 if bits are different |
| `~`      | NOT                  | Inverts bits            |
| `<<`     | Left Shift           | Shifts bits left        |
| `>>`     | Right Shift          | Arithmetic right shift  |
| `>>>`    | Unsigned Right Shift | Logical shift           |

---

### Example

```java
int a = 5;  // 0101
int b = 3;  // 0011

System.out.println(a & b); // 1
System.out.println(a | b); // 7
System.out.println(a ^ b); // 6
```

---

## 🔄 Left Shift & Right Shift

### Left Shift (`<<`)

```java
int x = 3;       // 0011
System.out.println(x << 1); // 6 (0110)
```

👉 Multiplies number by `2^n`

---

### Right Shift (`>>`)

```java
int x = 8;       // 1000
System.out.println(x >> 1); // 4 (0100)
```

👉 Divides number by `2^n`

---

## 🧩 Common Bit Operations

---

### 🔹 Check Even or Odd

```java
static boolean isEven(int n) {
    return (n & 1) == 0;
}
```

---

### 🔹 Check ith Bit

```java
static boolean checkBit(int n, int i) {
    return (n & (1 << i)) != 0;
}
```

---

### 🔹 Set ith Bit

```java
static int setBit(int n, int i) {
    return n | (1 << i);
}
```

---

### 🔹 Clear ith Bit

```java
static int clearBit(int n, int i) {
    return n & ~(1 << i);
}
```

---

### 🔹 Toggle ith Bit

```java
static int toggleBit(int n, int i) {
    return n ^ (1 << i);
}
```

---

## 🔥 Important Bit Tricks

---

### 🔹 Check Power of Two

```java
static boolean isPowerOfTwo(int n) {
    return n > 0 && (n & (n - 1)) == 0;
}
```

---

### 🔹 Count Set Bits (Brian Kernighan’s Algorithm)

```java
static int countSetBits(int n) {
    int count = 0;
    while (n > 0) {
        n = n & (n - 1);
        count++;
    }
    return count;
}
```

---

### 🔹 Swap Two Numbers Without Temp Variable

```java
static void swap(int a, int b) {
    a = a ^ b;
    b = a ^ b;
    a = a ^ b;
}
```

---

### 🔹 Remove Rightmost Set Bit

```java
n = n & (n - 1);
```

---

### 🔹 Get Rightmost Set Bit

```java
int rightMost = n & -n;
```

---

## 🧠 Bit Manipulation Problems

---

### 🔹 Find Unique Element (Others Appear Twice)

```java
static int findUnique(int[] arr) {
    int result = 0;
    for (int num : arr) {
        result ^= num;
    }
    return result;
}
```

---

### 🔹 Find Missing Number

```java
static int missingNumber(int[] arr, int n) {
    int xor = 0;
    for (int i = 1; i <= n; i++)
        xor ^= i;

    for (int num : arr)
        xor ^= num;

    return xor;
}
```

---

### 🔹 Find Two Unique Numbers

```java
static void findTwoUnique(int[] arr) {
    int xor = 0;

    for (int num : arr)
        xor ^= num;

    int setBit = xor & -xor;
    int x = 0, y = 0;

    for (int num : arr) {
        if ((num & setBit) != 0)
            x ^= num;
        else
            y ^= num;
    }

    System.out.println(x + " " + y);
}
```

---

## ⏱ Time & Space Complexity

| Operation          | Complexity            |
| ------------------ | --------------------- |
| Bitwise operations | O(1)                  |
| Count set bits     | O(number of set bits) |
| XOR-based problems | O(n)                  |

---

## ✅ Best Practices

✔ Use parentheses for clarity
✔ Prefer bit tricks for optimization
✔ Comment complex bit operations
✔ Validate inputs
✔ Practice regularly

---

## ❌ Common Mistakes

❌ Confusing `>>` and `>>>`
❌ Negative number handling
❌ Off-by-one bit positions
❌ Overusing bit manipulation
❌ Ignoring readability

---

## 🏁 Conclusion

Bit Manipulation is a **must-have skill** for every Java developer.

> Mastering bits gives you:

- Faster solutions
- Cleaner logic
- Edge in interviews

---

⭐ If this repository helped you, **give it a star**
Happy Coding 🚀
