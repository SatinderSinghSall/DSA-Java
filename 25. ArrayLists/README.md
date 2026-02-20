# 📘 Java ArrayList & Two-Pointer Algorithms

## 📌 Project Overview

This project demonstrates **Java ArrayList fundamentals** and builds toward **problem-solving techniques** frequently used in academic coursework, coding interviews, and software development.

It covers:

- Core ArrayList operations
- Traversal & manipulation
- Sorting & searching
- Multidimensional ArrayLists
- Brute-force vs optimized solutions
- Two-pointer technique
- Circular array handling
- Classic algorithmic problems

---

# 🎯 Learning Objectives

After studying this project, you will understand:

✅ How Java ArrayLists work internally
✅ When to use ArrayList vs arrays
✅ Time complexity of common operations
✅ Multidimensional dynamic structures
✅ Problem-solving using brute force & optimized methods
✅ Two-pointer technique (important for interviews)
✅ Circular array logic
✅ Writing clean, reusable Java code

---

# 📚 What is an ArrayList?

## Definition

`ArrayList` is a **dynamic array implementation** in Java that can grow or shrink in size.

### Declaration

```java
ArrayList<Integer> list = new ArrayList<>();
```

---

## 🔍 Array vs ArrayList

| Feature          | Array  | ArrayList       |
| ---------------- | ------ | --------------- |
| Size             | Fixed  | Dynamic         |
| Performance      | Faster | Slight overhead |
| Built-in methods | ❌     | ✅              |
| Memory           | Static | Dynamic         |

---

## ⏱ Time Complexity of ArrayList Operations

| Operation  | Complexity |
| ---------- | ---------- |
| add()      | O(1)       |
| add(index) | O(n)       |
| get()      | O(1)       |
| remove()   | O(n)       |
| contains() | O(n)       |
| set()      | O(1)       |

---

# 📂 File Documentation

---

# 1️⃣ ArrayLists_Java.java

## 📌 Purpose

Demonstrates basic ArrayList operations.

## Concepts Covered

- Creating ArrayList
- Adding elements
- Inserting elements
- Accessing elements
- Removing elements
- Updating values
- Checking existence
- Iteration

## Example

```java
list.add(1, 9); // insert at index
list.remove(2); // remove element
list.set(2, 10); // update value
```

## Academic Importance

✔ Understanding dynamic collections
✔ Foundation for Java data structures

## Professional Relevance

Used in:

- backend systems
- data processing
- APIs & services

---

# 2️⃣ PrintReverse.java

## 📌 Purpose

Print Array elements in reverse order.

## Logic

Start from last index and iterate backward.

```java
for(int i=list.size()-1; i>=0; i--)
```

## Complexity

O(n)

## Use Cases

✔ reverse traversal
✔ stack-like behavior

---

# 3️⃣ MaxNumber.java

## 📌 Purpose

Find the maximum value in a list.

## Logic

Compare each element with current maximum.

## Complexity

O(n)

## Alternative

```java
Collections.max(list);
```

## Real Use

✔ analytics
✔ statistics
✔ data filtering

---

# 4️⃣ SwapNumbers.java

## 📌 Purpose

Swap elements at two indices.

## Logic

Use temporary variable.

```java
int temp = list.get(i);
list.set(i, list.get(j));
list.set(j, temp);
```

## Complexity

O(1)

## Real Use

✔ sorting algorithms
✔ data rearrangement

---

# 5️⃣ SortArrayList.java

## 📌 Purpose

Sort ArrayList elements.

```java
Collections.sort(list);
```

## Reverse Sort

```java
Collections.sort(list, Collections.reverseOrder());
```

## Complexity

O(n log n)

## Real Use

✔ ranking systems
✔ search optimization

---

# 6️⃣ MultidimensionalArrayList.java

## 📌 Purpose

Create and print a 2D ArrayList.

## Structure

```
[
 [1,2],
 [3,4]
]
```

## Key Concept

ArrayList inside ArrayList.

## Complexity

O(rows × columns)

## Real Use

✔ matrices
✔ seating layouts
✔ game boards

---

# 7️⃣ MultidimensionalArrayList2.java

## 📌 Purpose

Generate multiplication tables dynamically.

## Output Example

```
[1 2 3 4 5]
[2 4 6 8 10]
[3 6 9 12 15]
```

## Learning Value

✔ nested loops
✔ dynamic data generation

---

# 8️⃣ PairSum_BruteForce.java

## 📌 Problem

Find if any pair sums to a target value.

## Approach

Check all pairs.

## Complexity

❌ O(n²)

## Academic Importance

Teaches brute-force thinking.

---

# 9️⃣ PairSum_2PointersApproach.java

## 📌 Optimized Pair Sum

## Condition

Array must be sorted.

## Logic

- If sum too small → move left pointer
- If sum too large → move right pointer

## Complexity

✅ O(n)

## Professional Importance

Used in:

- financial analysis
- data matching systems

---

# 🔟 PairSum.java (Sorted & Rotaded Array)

## 📌 Advanced Problem

Find pair in sorted & rotated array.

### Example

```
11 15 6 8 9 10
```

## Steps

1. Find pivot point
2. Smallest = pivot + 1
3. Largest = pivot
4. Apply circular two-pointer search

## Complexity

O(n)

## Interview Importance ⭐

Common in coding interviews.

---

# 1️⃣1️⃣ ContainerProblem_BruteForce.java

## 📌 Problem

Find maximum water container.

## Formula

```
water = min(height) × width
```

## Complexity

❌ O(n²)

---

# 1️⃣2️⃣ ContainerProblem_2PointerApproach.java

## 📌 Optimized Container Solution

## Logic

- Start from both ends
- Move pointer with smaller height

## Complexity

✅ O(n)

## Interview Importance ⭐⭐⭐

Very frequently asked problem.

---

# 1️⃣3️⃣ Main.java

Default template file. Not related to algorithms.

---

# 🧠 Algorithmic Concepts Learned

## ✔ Brute Force Approach

Simple but inefficient.

## ✔ Two Pointer Technique

Efficient for sorted data.

Used in:

- pair sum
- container water
- palindrome checking
- sliding window problems

## ✔ Circular Two Pointer

Used for rotated arrays.

---

# 🏫 Academic Significance

This project strengthens:

✔ Data structure fundamentals
✔ Time complexity analysis
✔ Algorithm design
✔ Logical thinking

Suitable for:

- B.Tech / BCA / MCA coursework
- Data Structures & Algorithms labs
- Programming assignments

---

# 💼 Professional & Interview Relevance

Topics frequently asked in:

✅ Amazon
✅ Google
✅ Microsoft
✅ Infosys / TCS / Wipro
✅ Product-based companies

---

# 🧮 Complexity Summary

| Problem     | Approach         | Time       |
| ----------- | ---------------- | ---------- |
| Pair Sum    | Brute            | O(n²)      |
| Pair Sum    | 2-pointer        | O(n)       |
| Container   | Brute            | O(n²)      |
| Container   | 2-pointer        | O(n)       |
| Max Element | Linear           | O(n)       |
| Sorting     | Collections.sort | O(n log n) |

---

# 🚀 When to Use ArrayList in Real Projects

Use ArrayList when:

✔ size is dynamic
✔ frequent reads required
✔ indexing needed
✔ memory flexibility required

Avoid when:

❌ frequent insertions in middle
❌ thread safety needed

---

# ⭐ Best Practices

✔ Use meaningful method names
✔ Validate index inputs
✔ Use built-in methods when possible
✔ Follow Java naming conventions
✔ Write reusable functions

---

# 📈 Future Topics to Learn

Next recommended topics:

- LinkedList vs ArrayList
- HashMap
- Stack & Queue
- Recursion
- Sorting Algorithms
- Binary Search
- Sliding Window Technique

---

# 🏁 Conclusion

This project builds a **strong foundation in Java data structures and algorithmic thinking**.

It progresses from basic operations to optimized problem-solving techniques used in real-world software and technical interviews.

👉 Mastering these concepts prepares you for **advanced DSA, competitive coding, and technical interviews.**

---

# Java ArrayList — Complete Guide

## Table of Contents

1. Introduction
2. What is an ArrayList?
3. Array vs ArrayList
4. Internal Working of ArrayList
5. Creating an ArrayList
6. Common Methods
7. Iterating Through an ArrayList
8. Generics and Type Safety
9. Capacity vs Size
10. Performance & Time Complexity
11. Sorting and Searching
12. Converting ArrayList
13. Thread Safety
14. Best Practices
15. Real‑World Use Cases
16. Common Errors & Pitfalls
17. Interview Questions
18. Conclusion

---

## 1. Introduction

`ArrayList` is one of the most commonly used classes in Java’s **Collection Framework**. It provides a dynamic array that can grow or shrink as elements are added or removed.

Package:

```java
import java.util.ArrayList;
```

It is part of the **java.util** package and implements the **List** interface.

---

## 2. What is an ArrayList?

An **ArrayList** is a resizable array implementation of the List interface.

### Key Features

- Dynamic size
- Maintains insertion order
- Allows duplicate elements
- Allows null values
- Provides fast random access

---

## 3. Array vs ArrayList

| Feature           | Array   | ArrayList       |
| ----------------- | ------- | --------------- |
| Size              | Fixed   | Dynamic         |
| Performance       | Faster  | Slight overhead |
| Methods           | Limited | Rich API        |
| Primitive support | Yes     | Objects only    |
| Resizable         | No      | Yes             |

---

## 4. Internal Working of ArrayList

ArrayList internally uses a **dynamic array**.

### Growth Mechanism

When capacity is exceeded:

1. A new array is created.
2. Size increases by **~50%**.
3. Elements are copied to the new array.

This ensures efficient memory usage and performance.

---

## 5. Creating an ArrayList

### Basic Syntax

```java
ArrayList<Type> list = new ArrayList<>();
```

### Examples

```java
ArrayList<String> names = new ArrayList<>();
ArrayList<Integer> numbers = new ArrayList<>();
```

### With Initial Capacity

```java
ArrayList<Integer> list = new ArrayList<>(100);
```

---

## 6. Common Methods

### Adding Elements

```java
list.add("Apple");
list.add(1, "Banana");
```

### Accessing Elements

```java
String item = list.get(0);
```

### Updating Elements

```java
list.set(0, "Mango");
```

### Removing Elements

```java
list.remove(0);
list.remove("Apple");
```

### Checking Elements

```java
list.contains("Apple");
list.isEmpty();
```

### Size

```java
list.size();
```

### Clearing

```java
list.clear();
```

---

## 7. Iterating Through an ArrayList

### Using for loop

```java
for (int i = 0; i < list.size(); i++) {
    System.out.println(list.get(i));
}
```

### Enhanced for loop

```java
for (String item : list) {
    System.out.println(item);
}
```

### Using Iterator

```java
import java.util.Iterator;

Iterator<String> it = list.iterator();
while(it.hasNext()) {
    System.out.println(it.next());
}
```

### Using forEach + Lambda

```java
list.forEach(item -> System.out.println(item));
```

---

## 8. Generics and Type Safety

ArrayList uses **Generics** to ensure type safety.

```java
ArrayList<Integer> list = new ArrayList<>();
list.add(10);
// list.add("hello"); ❌ compile-time error
```

---

## 9. Capacity vs Size

| Term     | Meaning                   |
| -------- | ------------------------- |
| Size     | Number of elements stored |
| Capacity | Allocated storage         |

Increase capacity manually:

```java
list.ensureCapacity(50);
```

Trim capacity:

```java
list.trimToSize();
```

---

## 10. Performance & Time Complexity

| Operation  | Complexity     |
| ---------- | -------------- |
| get()      | O(1)           |
| add()      | O(1) amortized |
| add(index) | O(n)           |
| remove()   | O(n)           |
| search     | O(n)           |

ArrayList is best when frequent access is required.

---

## 11. Sorting and Searching

### Sorting

```java
import java.util.Collections;

Collections.sort(list);
```

### Custom Sorting

```java
Collections.sort(list, (a, b) -> a - b);
```

### Binary Search

```java
Collections.binarySearch(list, 10);
```

---

## 12. Converting ArrayList

### ArrayList to Array

```java
String[] arr = list.toArray(new String[0]);
```

### Array to ArrayList

```java
ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
```

---

## 13. Thread Safety

ArrayList is **NOT synchronized**.

### Thread-safe alternative:

```java
List<String> list = Collections.synchronizedList(new ArrayList<>());
```

OR use:

- `Vector`
- `CopyOnWriteArrayList`

---

## 14. Best Practices

✔ Use ArrayList when fast access is needed
✔ Specify initial capacity for large data
✔ Use generics
✔ Prefer forEach for readability
✔ Avoid frequent middle insertions

---

## 15. Real‑World Use Cases

### Student Management

```java
ArrayList<String> students = new ArrayList<>();
students.add("Rahul");
students.add("Anita");
```

### Shopping Cart

```java
ArrayList<String> cart = new ArrayList<>();
cart.add("Laptop");
cart.add("Mouse");
```

---

## 16. Common Errors & Pitfalls

❌ IndexOutOfBoundsException

```java
list.get(5);
```

❌ ConcurrentModificationException (modifying during iteration)

---

## 17. Interview Questions

**Q1:** Difference between ArrayList and LinkedList?

**Q2:** Why is ArrayList not thread-safe?

**Q3:** What is the default capacity?

> 10

**Q4:** How does ArrayList grow?

> Increases by ~50% of current size.

---

## 18. Conclusion

ArrayList is a powerful and flexible data structure widely used in Java applications. Understanding its internal working, performance characteristics, and best practices helps build efficient and scalable applications.

---

## 19. Operations on ArrayList (Detailed)

### Insert Elements

```java
list.add("A");        // end
list.add(1, "B");     // specific index
```

### Update Elements

```java
list.set(0, "Updated");
```

### Delete Elements

```java
list.remove(0);        // by index
list.remove("A");     // by value
```

### Search Elements

```java
boolean exists = list.contains("A");
int index = list.indexOf("A");
```

---

## 20. Finding Size of ArrayList

```java
ArrayList<Integer> numbers = new ArrayList<>();
numbers.add(10);
numbers.add(20);

System.out.println(numbers.size());  // Output: 2
```

**size()** returns the number of elements present.

---

## 21. Print ArrayList in Reverse Order

### Using Loop

```java
for (int i = list.size() - 1; i >= 0; i--) {
    System.out.println(list.get(i));
}
```

### Using Collections.reverse()

```java
Collections.reverse(list);
System.out.println(list);
```

---

## 22. Find Maximum Element in ArrayList

### Using Collections

```java
int max = Collections.max(numbers);
```

### Manual Method

```java
int max = numbers.get(0);
for (int num : numbers) {
    if (num > max) max = num;
}
```

---

## 23. Swap Two Elements in ArrayList

```java
Collections.swap(list, 0, 2);
```

### Manual Swap

```java
String temp = list.get(0);
list.set(0, list.get(2));
list.set(2, temp);
```

---

## 24. Sorting an ArrayList

### Ascending Order

```java
Collections.sort(numbers);
```

### Descending Order

```java
Collections.sort(numbers, Collections.reverseOrder());
```

### Sorting Objects with Comparator

```java
Collections.sort(students, (a, b) -> a.age - b.age);
```

---

## 25. ArrayList Implementation in Java (Under the Hood)

ArrayList is implemented using a resizable array.

### Core Fields

- `Object[] elementData` → stores elements
- `int size` → number of elements

### Growth Formula

New Capacity = Old Capacity + (Old Capacity >> 1)

This increases size by 50% to balance memory & performance.

---

## 26. Multi-Dimensional ArrayLists

Used to store matrix-like or nested data.

### Creating 2D ArrayList

```java
ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

for (int i = 0; i < 3; i++) {
    matrix.add(new ArrayList<>());
}

matrix.get(0).add(10);
matrix.get(1).add(20);
```

### Traversing 2D ArrayList

```java
for (ArrayList<Integer> row : matrix) {
    for (int val : row) {
        System.out.print(val + " ");
    }
}
```

---

## 27. Practice Problems

Try implementing:

✔ Reverse an ArrayList
✔ Find second largest element
✔ Remove duplicates
✔ Rotate elements by k positions
✔ Merge two ArrayLists

---

## 28. Quick Revision Cheat Sheet

**Create** → `new ArrayList<>()`

**Add** → `add()`

**Access** → `get(index)`

**Update** → `set(index, value)`

**Remove** → `remove()`

**Size** → `size()`

**Sort** → `Collections.sort()`

**Reverse** → `Collections.reverse()`

**Max** → `Collections.max()`

---

### Author Notes

This guide now covers all ArrayList topics commonly taught in:

- Data Structures & Algorithms courses
- University exams
- Coding interviews
- Professional Java development

# Java ArrayList — Complete Guide

## Table of Contents

1. Introduction
2. What is an ArrayList?
3. Array vs ArrayList
4. Internal Working of ArrayList
5. Creating an ArrayList
6. Common Methods
7. Iterating Through an ArrayList
8. Generics and Type Safety
9. Capacity vs Size
10. Performance & Time Complexity
11. Sorting and Searching
12. Converting ArrayList
13. Thread Safety
14. Best Practices
15. Real‑World Use Cases
16. Common Errors & Pitfalls
17. Interview Questions
18. Conclusion

---

## 1. Introduction

`ArrayList` is one of the most commonly used classes in Java’s **Collection Framework**. It provides a dynamic array that can grow or shrink as elements are added or removed.

Package:

```java
import java.util.ArrayList;
```

It is part of the **java.util** package and implements the **List** interface.

---

## 2. What is an ArrayList?

An **ArrayList** is a resizable array implementation of the List interface.

### Key Features

- Dynamic size
- Maintains insertion order
- Allows duplicate elements
- Allows null values
- Provides fast random access

---

## 3. Array vs ArrayList

| Feature           | Array   | ArrayList       |
| ----------------- | ------- | --------------- |
| Size              | Fixed   | Dynamic         |
| Performance       | Faster  | Slight overhead |
| Methods           | Limited | Rich API        |
| Primitive support | Yes     | Objects only    |
| Resizable         | No      | Yes             |

---

## 4. Internal Working of ArrayList

ArrayList internally uses a **dynamic array**.

### Growth Mechanism

When capacity is exceeded:

1. A new array is created.
2. Size increases by **~50%**.
3. Elements are copied to the new array.

This ensures efficient memory usage and performance.

---

## 5. Creating an ArrayList

### Basic Syntax

```java
ArrayList<Type> list = new ArrayList<>();
```

### Examples

```java
ArrayList<String> names = new ArrayList<>();
ArrayList<Integer> numbers = new ArrayList<>();
```

### With Initial Capacity

```java
ArrayList<Integer> list = new ArrayList<>(100);
```

---

## 6. Common Methods

### Adding Elements

```java
list.add("Apple");
list.add(1, "Banana");
```

### Accessing Elements

```java
String item = list.get(0);
```

### Updating Elements

```java
list.set(0, "Mango");
```

### Removing Elements

```java
list.remove(0);
list.remove("Apple");
```

### Checking Elements

```java
list.contains("Apple");
list.isEmpty();
```

### Size

```java
list.size();
```

### Clearing

```java
list.clear();
```

---

## 7. Iterating Through an ArrayList

### Using for loop

```java
for (int i = 0; i < list.size(); i++) {
    System.out.println(list.get(i));
}
```

### Enhanced for loop

```java
for (String item : list) {
    System.out.println(item);
}
```

### Using Iterator

```java
import java.util.Iterator;

Iterator<String> it = list.iterator();
while(it.hasNext()) {
    System.out.println(it.next());
}
```

### Using forEach + Lambda

```java
list.forEach(item -> System.out.println(item));
```

---

## 8. Generics and Type Safety

ArrayList uses **Generics** to ensure type safety.

```java
ArrayList<Integer> list = new ArrayList<>();
list.add(10);
// list.add("hello"); ❌ compile-time error
```

---

## 9. Capacity vs Size

| Term     | Meaning                   |
| -------- | ------------------------- |
| Size     | Number of elements stored |
| Capacity | Allocated storage         |

Increase capacity manually:

```java
list.ensureCapacity(50);
```

Trim capacity:

```java
list.trimToSize();
```

---

## 10. Performance & Time Complexity

| Operation  | Complexity     |
| ---------- | -------------- |
| get()      | O(1)           |
| add()      | O(1) amortized |
| add(index) | O(n)           |
| remove()   | O(n)           |
| search     | O(n)           |

ArrayList is best when frequent access is required.

---

## 11. Sorting and Searching

### Sorting

```java
import java.util.Collections;

Collections.sort(list);
```

### Custom Sorting

```java
Collections.sort(list, (a, b) -> a - b);
```

### Binary Search

```java
Collections.binarySearch(list, 10);
```

---

## 12. Converting ArrayList

### ArrayList to Array

```java
String[] arr = list.toArray(new String[0]);
```

### Array to ArrayList

```java
ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
```

---

## 13. Thread Safety

ArrayList is **NOT synchronized**.

### Thread-safe alternative:

```java
List<String> list = Collections.synchronizedList(new ArrayList<>());
```

OR use:

- `Vector`
- `CopyOnWriteArrayList`

---

## 14. Best Practices

✔ Use ArrayList when fast access is needed
✔ Specify initial capacity for large data
✔ Use generics
✔ Prefer forEach for readability
✔ Avoid frequent middle insertions

---

## 15. Real‑World Use Cases

### Student Management

```java
ArrayList<String> students = new ArrayList<>();
students.add("Rahul");
students.add("Anita");
```

### Shopping Cart

```java
ArrayList<String> cart = new ArrayList<>();
cart.add("Laptop");
cart.add("Mouse");
```

---

## 16. Common Errors & Pitfalls

❌ IndexOutOfBoundsException

```java
list.get(5);
```

❌ ConcurrentModificationException (modifying during iteration)

---

## 17. Interview Questions

**Q1:** Difference between ArrayList and LinkedList?

**Q2:** Why is ArrayList not thread-safe?

**Q3:** What is the default capacity?

> 10

**Q4:** How does ArrayList grow?

> Increases by ~50% of current size.

---

## 18. Conclusion

ArrayList is a powerful and flexible data structure widely used in Java applications. Understanding its internal working, performance characteristics, and best practices helps build efficient and scalable applications.

---

### Author Notes

- Satinder Singh Sall

This guide is suitable for:

- Academic study
- Interview preparation
- Professional development
- Java beginners to advanced developers
