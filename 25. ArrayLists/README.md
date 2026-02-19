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
