# 🔤 Strings in Java — Complete Guide (Basic to Advanced)

A comprehensive guide to **Strings in Java**, covering:

- Core concepts & theory
- Memory behavior
- String methods
- StringBuilder vs StringBuffer
- Common string operations
- Interview-level problems
- Clean and well-commented Java code

Ideal for **Java beginners, DSA learners, and interview preparation**.

---

## 📚 Table of Contents

- [Introduction](#introduction)
- [What is a String?](#what-is-a-string)
- [Why Strings are Important](#why-strings-are-important)
- [String Memory Representation](#string-memory-representation)
- [Ways to Create Strings](#ways-to-create-strings)
- [String Immutability](#string-immutability)
- [Common String Operations](#common-string-operations)
- [String Comparison](#string-comparison)
- [StringBuilder vs StringBuffer](#stringbuilder-vs-stringbuffer)
- [Important String Problems](#important-string-problems)
- [Time & Space Complexity](#time--space-complexity)
- [Best Practices](#best-practices)
- [Common Mistakes](#common-mistakes)
- [Conclusion](#conclusion)

---

## 📖 Introduction

Strings are one of the **most frequently used data types** in Java.  
They are essential for:

- User input & output
- File handling
- Text processing
- Web & backend development
- Interview coding problems

A strong understanding of strings is **mandatory for mastering Java**.

---

## ❓ What is a String?

In Java, a **String** is an **object** that represents a sequence of characters.

```java
String s = "Hello";
```

````

📌 Internally, Java stores strings as a **character array**.

---

## 🤔 Why Strings are Important?

✔ Used in almost every Java application
✔ Immutable → thread-safe
✔ Rich API (`String` class methods)
✔ Core part of interviews & DSA

---

## 🧠 String Memory Representation

Java stores strings in a special memory area called the **String Constant Pool (SCP)**.

### Example

```java
String a = "Java";
String b = "Java";
```

✔ Both `a` and `b` refer to the **same object** in SCP.

---

### Using `new` Keyword

```java
String a = new String("Java");
String b = new String("Java");
```

❌ Creates **two different objects** in heap memory.

---

## 🧾 Ways to Create Strings

### 1️⃣ String Literal (Recommended)

```java
String s = "Hello";
```

---

### 2️⃣ Using `new` Keyword

```java
String s = new String("Hello");
```

---

### 3️⃣ From Character Array

```java
char[] ch = {'H','e','l','l','o'};
String s = new String(ch);
```

---

## 🔒 String Immutability

Strings in Java are **immutable**.

```java
String s = "Java";
s.concat(" World");
System.out.println(s); // Java
```

✔ Original string is unchanged
✔ A new object is created

📌 Reason:

- Security
- Caching
- Thread safety

---

## 🔧 Common String Operations

---

### 🔹 Length of String

```java
String s = "Hello";
System.out.println(s.length()); // 5
```

---

### 🔹 Access Characters

```java
char ch = s.charAt(1); // 'e'
```

---

### 🔹 Substring

```java
String sub = s.substring(1, 4); // ell
```

---

### 🔹 Convert Case

```java
s.toUpperCase();
s.toLowerCase();
```

---

### 🔹 Trim Spaces

```java
String s = "  Hello  ";
System.out.println(s.trim());
```

---

### 🔹 Replace Characters

```java
String s = "apple";
System.out.println(s.replace('p', 'b')); // abble
```

---

### 🔹 Split String

```java
String s = "Java is powerful";
String[] words = s.split(" ");
```

---

## ⚖ String Comparison

---

### ❌ Using `==`

```java
String a = "Java";
String b = "Java";
System.out.println(a == b); // true (same reference)
```

⚠ Not reliable for content comparison.

---

### ✅ Using `.equals()`

```java
System.out.println(a.equals(b)); // true
```

✔ Always use `.equals()` to compare content.

---

### Case-Insensitive Comparison

```java
a.equalsIgnoreCase(b);
```

---

## 🧵 StringBuilder vs StringBuffer

| Feature     | StringBuilder | StringBuffer |
| ----------- | ------------- | ------------ |
| Mutability  | Mutable       | Mutable      |
| Thread-safe | ❌ No         | ✔ Yes        |
| Performance | Faster        | Slower       |
| Introduced  | Java 1.5      | Java 1.0     |

---

### Example: StringBuilder

```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");
System.out.println(sb);
```

---

### Example: StringBuffer

```java
StringBuffer sb = new StringBuffer("Hello");
sb.append(" World");
System.out.println(sb);
```

---

## 🧠 Important String Problems

---

### 🔹 Reverse a String

```java
String s = "Java";
String reversed = "";

for (int i = s.length() - 1; i >= 0; i--) {
    reversed += s.charAt(i);
}

System.out.println(reversed);
```

---

### 🔹 Reverse Using StringBuilder

```java
String s = "Java";
String reversed = new StringBuilder(s).reverse().toString();
```

---

### 🔹 Check Palindrome

```java
static boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;

    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}
```

---

### 🔹 Count Vowels

```java
static int countVowels(String s) {
    int count = 0;
    s = s.toLowerCase();

    for (char ch : s.toCharArray()) {
        if ("aeiou".indexOf(ch) != -1) {
            count++;
        }
    }
    return count;
}
```

---

### 🔹 Anagram Check

```java
static boolean isAnagram(String a, String b) {
    if (a.length() != b.length()) return false;

    int[] count = new int[26];

    for (char c : a.toCharArray())
        count[c - 'a']++;

    for (char c : b.toCharArray())
        count[c - 'a']--;

    for (int i : count)
        if (i != 0) return false;

    return true;
}
```

---

## ⏱ Time & Space Complexity

| Operation           | Complexity |
| ------------------- | ---------- |
| Length              | O(1)       |
| Concatenation (`+`) | O(n)       |
| Substring           | O(n)       |
| Comparison          | O(n)       |
| Reverse             | O(n)       |

---

## ✅ Best Practices

✔ Use `.equals()` instead of `==`
✔ Prefer `StringBuilder` for modifications
✔ Avoid unnecessary string concatenation in loops
✔ Use meaningful variable names
✔ Normalize strings before comparison

---

## ❌ Common Mistakes

❌ Using `==` for comparison
❌ Excessive `+` in loops
❌ Forgetting immutability
❌ Ignoring case sensitivity
❌ Not handling null strings

---

## 🏁 Conclusion

Strings are a **core pillar of Java programming**.

> Mastering strings helps you:

- Write clean code
- Crack interviews
- Build real-world applications

---

⭐ If this repository helped you, **give it a star**
Happy Coding 🚀
````
