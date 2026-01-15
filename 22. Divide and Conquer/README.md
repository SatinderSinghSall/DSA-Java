# 📘 Divide and Conquer (Java) — Complete Guide (Basics → Advanced)

Divide and Conquer (D&C) is one of the most powerful algorithmic paradigms.
It solves complex problems by:

1. **Dividing** the problem into smaller subproblems
2. **Conquering** (solving) each subproblem recursively
3. **Combining** the results to get the final answer

---

## 📌 Table of Contents

1. [What is Divide and Conquer?](#what-is-divide-and-conquer)
2. [Core Idea](#core-idea)
3. [Divide and Conquer Template (Java)](#divide-and-conquer-template-java)
4. [Recursion Basics in Java](#recursion-basics-in-java)
5. [Time Complexity & Recurrence](#time-complexity--recurrence)
6. [Master Theorem (Explained)](#master-theorem-explained)
7. [Common Divide & Conquer Patterns](#common-divide--conquer-patterns)
8. [Beginner Examples](#beginner-examples)

   - [Binary Search](#1-binary-search)

9. [Intermediate Examples](#intermediate-examples)

   - [Merge Sort](#2-merge-sort)
   - [Quick Sort](#3-quick-sort)

10. [Advanced Examples](#advanced-examples)

- [Inversion Count](#4-count-inversions)
- [Maximum Subarray Sum (D&C)](#5-maximum-subarray-sum-dc)
- [Kth Smallest Element (QuickSelect)](#6-kth-smallest-element-quickselect)

11. [Advanced Divide & Conquer Topics](#advanced-divide--conquer-topics)
12. [Tips & Common Mistakes](#tips--common-mistakes)
13. [Practice Problems](#practice-problems)

---

## ✅ What is Divide and Conquer?

Divide and Conquer is an algorithmic technique where we solve a problem by recursively breaking it down.

### Example (Sorting):

To sort an array:

- Split into two halves
- Sort each half recursively
- Merge the sorted halves

---

## 🧠 Core Idea

A typical D&C algorithm looks like:

```
solve(problem):
    if base case:
        return answer
    divide problem into subproblems
    solve subproblems recursively
    combine results
    return combined answer
```

---

## 🧩 Divide and Conquer Template (Java)

This is the most common Java recursion template:

```java
public class DivideAndConquerTemplate {

    public static int solve(int[] arr, int left, int right) {
        // Base case
        if (left == right) {
            return arr[left];
        }

        // Divide
        int mid = left + (right - left) / 2;

        // Conquer
        int leftAns = solve(arr, left, mid);
        int rightAns = solve(arr, mid + 1, right);

        // Combine (example: take max)
        return Math.max(leftAns, rightAns);
    }
}
```

---

## 🔁 Recursion Basics in Java

### Base Case

Stops recursion:

```java
if (n == 0) return 1;
```

### Recursive Case

Calls itself on smaller input:

```java
return n * factorial(n - 1);
```

Example:

```java
public static long factorial(int n) {
    if (n == 0) return 1;
    return n * factorial(n - 1);
}
```

---

## ⏱️ Time Complexity & Recurrence

Most D&C algorithms follow recurrence:

[
T(n) = aT(n/b) + f(n)
]

Where:

- `a` = number of subproblems
- `n/b` = size of each subproblem
- `f(n)` = cost to divide + combine

Example: Merge Sort

[
T(n) = 2T(n/2) + O(n)
\Rightarrow O(n \log n)
]

---

## 📌 Master Theorem (Explained)

Given:

[
T(n) = aT(n/b) + f(n)
]

Compute:

[
n^{\log_b a}
]

### Case 1: Subproblems dominate

If:

[
f(n) = O(n^{\log_b a - \epsilon})
]

Then:

[
T(n) = \Theta(n^{\log_b a})
]

### Case 2: Balanced

If:

[
f(n) = \Theta(n^{\log_b a}\log^k n)
]

Then:

[
T(n) = \Theta(n^{\log_b a}\log^{k+1} n)
]

### Case 3: Combine dominates

If:

[
f(n) = \Omega(n^{\log_b a + \epsilon})
]

Then:

[
T(n) = \Theta(f(n))
]

---

## 🧱 Common Divide & Conquer Patterns

### 🔹 Pattern 1: Divide into halves

- Merge Sort
- Binary Search
- Maximum Subarray Sum

### 🔹 Pattern 2: Partition around pivot

- Quick Sort
- Quick Select

### 🔹 Pattern 3: Divide by answer space

- Binary search on answer
- Min/max feasible value problems

---

# 🟢 Beginner Examples

---

## 1) Binary Search

### Problem:

Find an element `target` in a sorted array.

### Idea:

Keep dividing search space into halves.

### Java Code:

```java
public class BinarySearchExample {

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        System.out.println(binarySearch(arr, 7)); // Output: 3
    }
}
```

### Complexity:

- Time: `O(log n)`
- Space: `O(1)`

---

# 🟡 Intermediate Examples

---

## 2) Merge Sort

### Idea:

Split array into halves, sort each, merge.

### Java Code:

```java
import java.util.Arrays;

public class MergeSortExample {

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left;      // pointer for left half
        int j = mid + 1;   // pointer for right half
        int k = 0;         // pointer for temp

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        // copy temp back to original array
        for (int x = 0; x < temp.length; x++) {
            arr[left + x] = temp[x];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 3, 7};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 5, 7, 9]
    }
}
```

### Complexity:

- Time: `O(n log n)`
- Space: `O(n)`

---

## 3) Quick Sort

### Idea:

Pick a pivot, partition array, recursively sort partitions.

### Java Code:

```java
import java.util.Arrays;

public class QuickSortExample {

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int pivotIndex = partition(arr, left, right);

        quickSort(arr, left, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, right);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr)); // [1, 5, 7, 8, 9, 10]
    }
}
```

### Complexity:

- Average: `O(n log n)`
- Worst: `O(n^2)`
- Space: `O(log n)` recursion stack

---

# 🔴 Advanced Examples

---

## 4) Count Inversions (Using Merge Sort)

### Problem:

Count pairs `(i, j)` such that:

- `i < j`
- `arr[i] > arr[j]`

### Example:

`[2, 4, 1, 3, 5]` → inversions = 3
Pairs: `(2,1), (4,1), (4,3)`

### Java Code:

```java
public class InversionCountExample {

    public static long countInversions(int[] arr) {
        return mergeSortCount(arr, 0, arr.length - 1);
    }

    private static long mergeSortCount(int[] arr, int left, int right) {
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;

        long inv = 0;
        inv += mergeSortCount(arr, left, mid);
        inv += mergeSortCount(arr, mid + 1, right);
        inv += mergeCount(arr, left, mid, right);

        return inv;
    }

    private static long mergeCount(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left, j = mid + 1, k = 0;
        long inv = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inv += (mid - i + 1); // all remaining left elements form inversions
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int x = 0; x < temp.length; x++) {
            arr[left + x] = temp[x];
        }

        return inv;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        System.out.println(countInversions(arr)); // Output: 3
    }
}
```

### Complexity:

- Time: `O(n log n)`
- Space: `O(n)`

---

## 5) Maximum Subarray Sum (Divide & Conquer)

### Problem:

Find max sum of contiguous subarray.

Example:
`[-2,1,-3,4,-1,2,1,-5,4]` → answer = 6 (`[4,-1,2,1]`)

### Java Code:

```java
public class MaximumSubarrayDC {

    public static int maxSubArray(int[] arr) {
        return solve(arr, 0, arr.length - 1);
    }

    private static int solve(int[] arr, int left, int right) {
        if (left == right) return arr[left];

        int mid = left + (right - left) / 2;

        int leftBest = solve(arr, left, mid);
        int rightBest = solve(arr, mid + 1, right);
        int crossBest = maxCrossing(arr, left, mid, right);

        return Math.max(Math.max(leftBest, rightBest), crossBest);
    }

    private static int maxCrossing(int[] arr, int left, int mid, int right) {
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;

        for (int i = mid; i >= left; i--) {
            sum += arr[i];
            leftSum = Math.max(leftSum, sum);
        }

        sum = 0;
        int rightSum = Integer.MIN_VALUE;

        for (int i = mid + 1; i <= right; i++) {
            sum += arr[i];
            rightSum = Math.max(rightSum, sum);
        }

        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr)); // Output: 6
    }
}
```

### Complexity:

- Time: `O(n log n)`
- Space: `O(log n)` recursion stack

---

## 6) Kth Smallest Element (QuickSelect)

### Idea:

Similar to QuickSort partitioning, but only recurse into one side.

### Java Code:

```java
import java.util.Random;

public class QuickSelectExample {

    private static final Random rand = new Random();

    public static int quickSelect(int[] arr, int k) {
        // k is 1-based: k=1 means smallest
        return quickSelect(arr, 0, arr.length - 1, k - 1);
    }

    private static int quickSelect(int[] arr, int left, int right, int kIndex) {
        if (left == right) return arr[left];

        int pivotIndex = left + rand.nextInt(right - left + 1);
        pivotIndex = partition(arr, left, right, pivotIndex);

        if (kIndex == pivotIndex) return arr[kIndex];
        else if (kIndex < pivotIndex) return quickSelect(arr, left, pivotIndex - 1, kIndex);
        else return quickSelect(arr, pivotIndex + 1, right, kIndex);
    }

    private static int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, right);

        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < pivot) {
                swap(arr, storeIndex, i);
                storeIndex++;
            }
        }

        swap(arr, storeIndex, right);
        return storeIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        System.out.println(quickSelect(arr, 3)); // Output: 7 (3rd smallest)
    }
}
```

### Complexity:

- Average: `O(n)`
- Worst: `O(n^2)`

---

# 🚀 Advanced Divide & Conquer Topics

## ✅ 1) Binary Search on Answer

Used when answer lies in a range and we check feasibility.

Examples:

- Minimum speed to finish tasks
- Aggressive cows
- Allocate books

---

## ✅ 2) Divide & Conquer DP Optimization

Used in problems like:

[
dp[i][j] = min\_{k < j}(dp[i-1][k] + cost(k,j))
]

Reduces time from `O(k n^2)` → `O(k n log n)` or `O(k n)`.

---

# ⚠️ Tips & Common Mistakes

✅ Always write correct **base case**
✅ Ensure problem size reduces each recursion
✅ Avoid integer overflow for `mid`
Use:

```java
int mid = left + (right - left) / 2;
```

✅ Watch recursion depth (stack overflow for huge recursion)
✅ In merge sort, avoid frequent array allocations if optimizing

---

# 🧪 Practice Problems

### Beginner

- Binary Search
- First/Last occurrence
- Search insert position

### Intermediate

- Merge Sort
- Quick Sort
- Kth element

### Advanced

- Inversion count
- Maximum subarray sum (D&C)
- Closest pair of points
- Strassen multiplication
- Divide & Conquer DP optimization

---

# ✅ Final Summary

Divide and Conquer helps transform brute-force solutions into efficient algorithms:

- `O(n²)` → `O(n log n)`
- Powerful recursion + clean problem breakdown
- Core concept in interviews + competitive programming
