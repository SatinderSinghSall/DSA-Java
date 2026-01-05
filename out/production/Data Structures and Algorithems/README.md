# 📘 Java Arrays – Complete Documentation

---

# 📑 Table of Contents (Index)

1. **Introduction to Arrays in Java**
   1.1 What is an Array
   1.2 Why Use Arrays

2. **Array Characteristics**

3. **Array Declaration in Java**
   3.1 Declaration Syntax
   3.2 Declaration Examples

4. **Array Creation (Memory Allocation)**
   4.1 Using `new` Keyword
   4.2 Memory Initialization

5. **Array Initialization**
   5.1 Static Initialization
   5.2 Dynamic Initialization

6. **Default Values in Arrays**

7. **Accessing Array Elements**
   7.1 Indexing Rules
   7.2 Examples

8. **Taking Input in Arrays**
   8.1 Using Scanner
   8.2 Storing User Input

9. **Printing Array Elements**
   9.1 Manual Printing
   9.2 Using Loops

10. **Updating Array Elements**

11. **Array Length Property**

12. **Traversing an Array**
    12.1 Using `for` Loop
    12.2 Using Enhanced `for-each` Loop

13. **Common Array Operations**
    13.1 Searching Elements
    13.2 Finding Maximum Value
    13.3 Finding Minimum Value
    13.4 Calculating Sum of Elements

14. **Common Errors in Arrays**

15. **Advantages of Arrays**

16. **Limitations of Arrays**

17. **Real-Life Use Cases of Arrays**

18. **Conclusion**

---

## 1. Introduction to Arrays in Java

An **array** in Java is a **fixed-size**, **indexed**, and **homogeneous** data structure used to store multiple values of the **same data type** under a single variable name.

### Why Use Arrays?

* Store multiple values efficiently
* Reduce the number of variables
* Easy traversal using loops
* Faster access using index

---

## 2. Array Characteristics

| Feature           | Description                           |
| ----------------- | ------------------------------------- |
| Fixed Size        | Size must be defined at creation      |
| Zero Indexed      | Index starts from `0`                 |
| Same Data Type    | All elements must be of the same type |
| Contiguous Memory | Stored in continuous memory locations |
| Random Access     | Access elements using index           |

---

## 3. Array Declaration in Java

### Syntax:

```java
datatype[] arrayName;
```

OR

```java
datatype arrayName[];
```

### Example:

```java
int[] marks;
String[] fruits;
```

---

## 4. Array Creation (Memory Allocation)

### Syntax:

```java
arrayName = new datatype[size];
```

### Example from Your Code:

```java
int marks[] = new int[50];
```

➡ Creates an array that can store **50 integers**, initialized with default value `0`.

---

## 5. Array Initialization

### 5.1 Static Initialization

Values are provided at compile time.

```java
int numbers[] = {1, 2, 3};
String fruits[] = {"Apple", "Mango", "Orange"};
```

✔ Java automatically determines the size.

---

### 5.2 Dynamic Initialization (Using new keyword)

```java
int arrMarks[] = new int[100];
```

✔ Size is fixed
✔ Values are initialized with **default values**

---

## 6. Default Values in Arrays

| Data Type       | Default Value |
| --------------- | ------------- |
| int             | 0             |
| float           | 0.0           |
| double          | 0.0           |
| char            | '\u0000'      |
| boolean         | false         |
| String / Object | null          |

---

## 7. Accessing Array Elements

### Syntax:

```java
arrayName[index]
```

### Example:

```java
arrMarks[0]
arrMarks[1]
arrMarks[2]
```

📌 **Index starts from 0**

---

## 8. Taking Input in Arrays (Your Code Explained)

```java
Scanner sc = new Scanner(System.in);

System.out.print("Enter Physics marks: ");
arrMarks[0] = sc.nextInt();

System.out.print("Enter Chemistry marks: ");
arrMarks[1] = sc.nextInt();

System.out.print("Enter Mathematics marks: ");
arrMarks[2] = sc.nextInt();
```

✔ Uses `Scanner`
✔ Stores input directly into array indices

---

## 9. Printing Array Elements

### Manual Printing:

```java
System.out.println(arrMarks[0]);
```

### Using Loop (Recommended):

```java
for(int i = 0; i < 3; i++) {
    System.out.println(arrMarks[i]);
}
```

---

## 10. Updating Array Elements

Arrays allow **modification** using index.

### Example:

```java
arrMarks[2] = 100;
```

✔ Updates Mathematics marks
✔ Original value is overwritten

---

## 11. Array Length Property

To get the size of an array:

```java
arrMarks.length
```

⚠ `length` is a **property**, not a method.

### Example:

```java
for(int i = 0; i < arrMarks.length; i++) {
    System.out.println(arrMarks[i]);
}
```

---

## 12. Traversing an Array

### 12.1 Using for loop

```java
for(int i = 0; i < arrMarks.length; i++) {
    System.out.println(arrMarks[i]);
}
```

### 12.2 Using enhanced for-each loop

```java
for(int mark : arrMarks) {
    System.out.println(mark);
}
```

✔ Read-only traversal
✔ Cleaner syntax

---

## 13. Common Array Operations

### ✔ Searching

```java
int key = 50;
for(int i = 0; i < arrMarks.length; i++) {
    if(arrMarks[i] == key) {
        System.out.println("Found at index " + i);
    }
}
```

---

### ✔ Finding Maximum

```java
int max = arrMarks[0];
for(int i = 1; i < arrMarks.length; i++) {
    if(arrMarks[i] > max) {
        max = arrMarks[i];
    }
}
```

---

### ✔ Finding Minimum

```java
int min = arrMarks[0];
for(int i = 1; i < arrMarks.length; i++) {
    if(arrMarks[i] < min) {
        min = arrMarks[i];
    }
}
```

---

### ✔ Sum of Elements

```java
int sum = 0;
for(int mark : arrMarks) {
    sum += mark;
}
```

---

## 14. Common Errors in Arrays

| Error                          | Cause                     |
| ------------------------------ | ------------------------- |
| ArrayIndexOutOfBoundsException | Accessing invalid index   |
| NullPointerException           | Using uninitialized array |
| Fixed Size Limitation          | Cannot resize array       |

---

## 15. Advantages of Arrays

✔ Fast access
✔ Easy traversal
✔ Memory efficient
✔ Useful for large data storage

---

## 16. Limitations of Arrays

❌ Fixed size
❌ No built-in methods for insertion/deletion
❌ Only homogeneous data

➡ For dynamic data, use **ArrayList**

---

## 17. Real-Life Use Cases

* Student marks
* Sensor readings
* Game scores
* Image pixels
* Data buffers

---

## 18. Conclusion

Arrays are the **foundation of data structures in Java**.
Understanding arrays helps in mastering:

* Sorting algorithms
* Searching algorithms
* Advanced data structures (Stack, Queue, ArrayList)

---
