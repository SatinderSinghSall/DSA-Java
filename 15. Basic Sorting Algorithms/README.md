# 🔢 Basic Sorting Algorithms — Complete Guide

A detailed guide to **basic sorting algorithms**, covering:

- Core theory
- How each algorithm works
- Step-by-step explanation
- Time & space complexity
- Well-commented code examples

This repository is ideal for **beginners**, **DSA learners**, and **interview preparation**.

---

## 📚 Table of Contents

- [Introduction](#introduction)
- [What is Sorting?](#what-is-sorting)
- [Why Sorting is Important](#why-sorting-is-important)
- [Types of Sorting Algorithms](#types-of-sorting-algorithms)
- [Bubble Sort](#bubble-sort-algorithm)
- [Selection Sort](#selection-sort-algorithm)
- [Insertion Sort](#insertion-sort-algorithm)
- [Counting Sort](#counting-sort-algorithm)
- [Inbuilt Sort](#inbuilt-sort)
- [Comparison Table](#comparison-table)
- [Stability in Sorting](#stability-in-sorting)
- [Best Practices](#best-practices)
- [Conclusion](#conclusion)

---

## 📖 Introduction

Sorting is one of the **most fundamental concepts** in computer science.  
Almost every real-world application depends on sorted data for efficiency.

Learning basic sorting algorithms builds:

- Strong problem-solving skills
- Algorithmic thinking
- Foundation for advanced algorithms

---

## ❓ What is Sorting?

**Sorting** is the process of arranging elements in a specific order:

- Ascending (small → large)
- Descending (large → small)

### Example

```

Input: [5, 1, 4, 2, 8]
Output: [1, 2, 4, 5, 8]

```

---

## 🚀 Why Sorting is Important?

✔ Faster searching (Binary Search)
✔ Efficient data processing
✔ Cleaner output for users
✔ Used in databases, OS, analytics, and AI

---

## 🧠 Types of Sorting Algorithms

### Comparison-Based

- Bubble Sort
- Selection Sort
- Insertion Sort

### Non-Comparison-Based

- Counting Sort

---

## 🔵 Bubble Sort Algorithm

### 📌 Concept

Bubble Sort repeatedly **compares adjacent elements** and swaps them if they are in the wrong order.

Largest elements **bubble up** to the end.

---

### 🔄 How It Works

```

[5, 1, 4, 2, 8]
→ [1, 5, 4, 2, 8]
→ [1, 4, 5, 2, 8]
→ [1, 4, 2, 5, 8]
→ [1, 2, 4, 5, 8]

```

---

### 🧪 Python Code

```python
def bubble_sort(arr):
    n = len(arr)

    for i in range(n):
        swapped = False
        for j in range(0, n - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
                swapped = True

        if not swapped:
            break

    return arr
```

---

### ⏱ Complexity

| Case    | Time  |
| ------- | ----- |
| Best    | O(n)  |
| Average | O(n²) |
| Worst   | O(n²) |
| Space   | O(1)  |

✔ Stable
❌ Slow for large datasets

---

## 🟡 Selection Sort Algorithm

### 📌 Concept

Selection Sort repeatedly **selects the minimum element** from the unsorted portion and places it at the beginning.

---

### 🔄 How It Works

```
[64, 25, 12, 22, 11]
→ [11, 25, 12, 22, 64]
→ [11, 12, 25, 22, 64]
→ [11, 12, 22, 25, 64]
```

---

### 🧪 Python Code

```python
def selection_sort(arr):
    n = len(arr)

    for i in range(n):
        min_index = i
        for j in range(i + 1, n):
            if arr[j] < arr[min_index]:
                min_index = j

        arr[i], arr[min_index] = arr[min_index], arr[i]

    return arr
```

---

### ⏱ Complexity

| Case    | Time  |
| ------- | ----- |
| Best    | O(n²) |
| Average | O(n²) |
| Worst   | O(n²) |
| Space   | O(1)  |

❌ Not stable
✔ Fewer swaps than Bubble Sort

---

## 🟢 Insertion Sort Algorithm

### 📌 Concept

Insertion Sort builds the sorted array **one element at a time**, similar to sorting cards in hand.

---

### 🔄 How It Works

```
[5, 3, 4, 1]
→ [3, 5, 4, 1]
→ [3, 4, 5, 1]
→ [1, 3, 4, 5]
```

---

### 🧪 Python Code

```python
def insertion_sort(arr):
    for i in range(1, len(arr)):
        key = arr[i]
        j = i - 1

        while j >= 0 and arr[j] > key:
            arr[j + 1] = arr[j]
            j -= 1

        arr[j + 1] = key

    return arr
```

---

### ⏱ Complexity

| Case    | Time  |
| ------- | ----- |
| Best    | O(n)  |
| Average | O(n²) |
| Worst   | O(n²) |
| Space   | O(1)  |

✔ Stable
✔ Efficient for small or nearly sorted arrays

---

## 🔴 Counting Sort Algorithm

### 📌 Concept

Counting Sort is a **non-comparison-based** algorithm.
It counts occurrences of each element and reconstructs the sorted array.

---

### ⚠ Limitation

Works only when:

- Elements are **non-negative integers**
- Range is **not too large**

---

### 🔄 How It Works

```
Input:  [4, 2, 2, 8, 3]
Count:  [0,0,2,1,1,0,0,0,1]
Output: [2, 2, 3, 4, 8]
```

---

### 🧪 Python Code

```python
def counting_sort(arr):
    max_val = max(arr)
    count = [0] * (max_val + 1)

    for num in arr:
        count[num] += 1

    index = 0
    for i in range(len(count)):
        while count[i] > 0:
            arr[index] = i
            index += 1
            count[i] -= 1

    return arr
```

---

### ⏱ Complexity

| Metric | Value    |
| ------ | -------- |
| Time   | O(n + k) |
| Space  | O(k)     |

✔ Very fast
❌ Not in-place

---

## ⚙ Inbuilt Sort

### 📌 Python Built-in Sorting

Python uses **Timsort**, a hybrid of:

- Merge Sort
- Insertion Sort

---

### Example

```python
arr = [5, 2, 9, 1, 5]
arr.sort()        # In-place
sorted_arr = sorted(arr)  # Returns new list
```

---

### ⏱ Complexity

| Case    | Time       |
| ------- | ---------- |
| Best    | O(n)       |
| Average | O(n log n) |
| Worst   | O(n log n) |

✔ Stable
✔ Highly optimized
✔ Recommended for real projects

---

## 📊 Comparison Table

| Algorithm      | Best   | Avg        | Worst      | Stable | In-place |
| -------------- | ------ | ---------- | ---------- | ------ | -------- |
| Bubble Sort    | O(n)   | O(n²)      | O(n²)      | ✔      | ✔        |
| Selection Sort | O(n²)  | O(n²)      | O(n²)      | ❌     | ✔        |
| Insertion Sort | O(n)   | O(n²)      | O(n²)      | ✔      | ✔        |
| Counting Sort  | O(n+k) | O(n+k)     | O(n+k)     | ✔      | ❌       |
| Inbuilt Sort   | O(n)   | O(n log n) | O(n log n) | ✔      | ✔        |

---

## 🔒 Stability in Sorting

A sorting algorithm is **stable** if it preserves the relative order of equal elements.

✔ Important when sorting objects with multiple keys.

---

## ✅ Best Practices

✔ Use **inbuilt sort** for real-world applications
✔ Use **Insertion Sort** for small inputs
✔ Use **Counting Sort** when range is small
✔ Learn basic sorts to understand advanced ones

---

## 🏁 Conclusion

Sorting algorithms are the **foundation of DSA**.

> Mastering basic sorting makes advanced algorithms easy to understand.

This repository gives you:

- Strong conceptual clarity
- Practical coding experience
- Interview readiness

---

⭐ If you found this helpful, **star the repository**
Happy Coding 🚀
