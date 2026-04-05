# Data Structure and Algorithms: DSA - Java

---

# 📘 Hashing & HashMap in Java (DSA - Sigma 4.0 / 38. Hashing)

![Java](https://img.shields.io/badge/Language-Java-orange)
![DSA](https://img.shields.io/badge/Topic-Hashing-blue)
![Level](https://img.shields.io/badge/Level-Beginner%20to%20Advanced-green)
![Status](https://img.shields.io/badge/Status-Completed-success)

---

## 📌 Overview

This repository documents my complete learning of **Hashing and HashMap** from the _Sigma 4.0 DSA Course_.

It covers:

- Hashing fundamentals
- HashMap & HashSet (Java)
- Internal implementation
- Collision handling
- Real-world problems
- Interview-level patterns

---

## 🧭 Topics Covered

1. Hashing Introduction
2. HashMap (Java)
3. HashMap Operations
4. Iteration on HashMaps
5. HashMap Implementation (From Scratch)
6. LinkedHashMap
7. TreeMap
8. HashSet & LinkedHashSet
9. TreeSet
10. Real Problem Solving

---

# 🧠 1. Hashing Fundamentals

## 📖 Theory

**Hashing** is a technique used to map data to a fixed-size table using a **hash function**.

### 🔑 Key Idea:

```
Key → Hash Function → Index
```

---

## ⚙️ Hash Function

- Converts key into index
- Should be:
  - Fast
  - Uniform
  - Deterministic

---

## ⚠️ Collision Handling

When two keys map to same index:

### Methods:

- Chaining (Linked List)
- Open Addressing

---

## ⏱ Complexity

| Operation | Average | Worst |
| --------- | ------- | ----- |
| Insert    | O(1)    | O(n)  |
| Search    | O(1)    | O(n)  |
| Delete    | O(1)    | O(n)  |

---

# ⚙️ 2. HashMap in Java

## 📌 Definition

`HashMap` stores **key-value pairs**.

```java
HashMap<String, Integer> map = new HashMap<>();
```

---

## 🔧 Operations

| Operation | Method        |
| --------- | ------------- |
| Insert    | put()         |
| Get       | get()         |
| Remove    | remove()      |
| Contains  | containsKey() |

---

## 💻 Example

```java
map.put("India", 100);
map.put("USA", 50);

System.out.println(map.get("India")); // 100
```

---

# 🔁 3. Iteration on HashMap

## 📌 Problem

Traverse all key-value pairs.

---

## 🧠 Algorithm

- Use `entrySet()` for efficient traversal

---

## 🧾 Pseudocode

```
for each entry in map:
    print key and value
```

---

## ✅ Code

```java
for (Map.Entry<String, Integer> e : map.entrySet()) {
    System.out.println(e.getKey() + " " + e.getValue());
}
```

---

# 🏗 4. HashMap Implementation (From Scratch)

## 📌 Problem

Implement a HashMap manually.

---

## 🧠 Algorithm

1. Create array of buckets
2. Compute hash index
3. Store key-value in bucket
4. Handle collisions using chaining

---

## 🧾 Pseudocode

```
put(key, value):
    index = hash(key)
    if bucket empty:
        insert
    else:
        handle collision

get(key):
    find in bucket
```

---

## ✅ Code (Simplified)

```java
class MyHashMap {
    class Node {
        int key, value;
        Node next;
    }

    Node[] buckets = new Node[10];

    int hash(int key) {
        return key % buckets.length;
    }

    void put(int key, int value) {
        int i = hash(key);
        Node head = buckets[i];

        while (head != null) {
            if (head.key == key) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        Node newNode = new Node();
        newNode.key = key;
        newNode.value = value;
        newNode.next = buckets[i];
        buckets[i] = newNode;
    }
}
```

---

# 🔗 5. LinkedHashMap

## 📌 Concept

Maintains **insertion order**

---

## ✅ Example

```java
LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
```

---

# 🌲 6. TreeMap

## 📌 Concept

- Sorted keys
- Uses **Red-Black Tree**

---

## ⏱ Complexity

- O(log n)

---

## ✅ Example

```java
TreeMap<Integer, String> map = new TreeMap<>();
```

---

# 📦 7. HashSet

## 📌 Concept

Stores **unique elements**

---

## ✅ Example

```java
HashSet<Integer> set = new HashSet<>();
set.add(1);
set.add(1); // ignored
```

---

# 🔗 8. LinkedHashSet

- Maintains insertion order

---

# 🌲 9. TreeSet

- Sorted set
- O(log n)

---

# 🚀 Problem Solving Section

---

## 🔹 Problem 1: Majority Element

### 📌 Problem

Find element appearing more than n/2 times.

---

### 🧠 Algorithm

- Use HashMap to count frequency

---

### 🧾 Pseudocode

```
for each element:
    count frequency

if count > n/2:
    return element
```

---

### ✅ Code

```java
HashMap<Integer, Integer> map = new HashMap<>();

for (int num : arr) {
    map.put(num, map.getOrDefault(num, 0) + 1);
}
```

---

## 🔹 Problem 2: Valid Anagram

### 📌 Problem

Check if two strings are anagrams.

---

### 🧠 Algorithm

- Count characters using HashMap

---

### 🧾 Pseudocode

```
count chars of s1
reduce using s2
if empty → anagram
```

---

### ✅ Code

```java
HashMap<Character, Integer> map = new HashMap<>();

for (char c : s.toCharArray()) {
    map.put(c, map.getOrDefault(c, 0) + 1);
}
```

---

## 🔹 Problem 3: Count Distinct Elements

### 📌 Problem

Count unique elements.

---

### 🧠 Algorithm

- Use HashSet

---

### 🧾 Pseudocode

```
add all elements to set
return size
```

---

### ✅ Code

```java
HashSet<Integer> set = new HashSet<>();
for (int num : arr) {
    set.add(num);
}
System.out.println(set.size());
```

---

## 🔹 Problem 4: Union & Intersection

### 📌 Problem

Find union and intersection of arrays.

---

### 🧠 Algorithm

- Use HashSet

---

### 🧾 Pseudocode

```
add all to set → union
check common → intersection
```

---

---

## 🔹 Problem 5: Largest Subarray with Sum 0

### 📌 Problem

Find largest subarray with sum = 0

---

### 🧠 Algorithm

- Use prefix sum + HashMap

---

### 🧾 Pseudocode

```
sum = 0
map stores sum index

if same sum appears:
    subarray exists
```

---

### ✅ Code

```java
HashMap<Integer, Integer> map = new HashMap<>();
int sum = 0, maxLen = 0;

for (int i = 0; i < arr.length; i++) {
    sum += arr[i];

    if (map.containsKey(sum)) {
        maxLen = Math.max(maxLen, i - map.get(sum));
    } else {
        map.put(sum, i);
    }
}
```

---

## 🔹 Problem 6: Subarray Sum Equals K

### 📌 Problem

Count subarrays with sum K

---

### 🧠 Algorithm

- Prefix sum + HashMap

---

### 🧾 Pseudocode

```
sum += arr[i]
check (sum - k) in map
```

---

### ✅ Code

```java
HashMap<Integer, Integer> map = new HashMap<>();
map.put(0, 1);

int sum = 0, count = 0;

for (int num : arr) {
    sum += num;

    if (map.containsKey(sum - k)) {
        count += map.get(sum - k);
    }

    map.put(sum, map.getOrDefault(sum, 0) + 1);
}
```

---

# 📊 Complexity Summary

| Structure     | Insert   | Search   | Order  |
| ------------- | -------- | -------- | ------ |
| HashMap       | O(1)     | O(1)     | No     |
| LinkedHashMap | O(1)     | O(1)     | Yes    |
| TreeMap       | O(log n) | O(log n) | Sorted |

---

# 🎯 Key Learnings

- Hashing enables **constant-time operations**
- Difference between:
  - HashMap vs TreeMap vs LinkedHashMap

- Prefix sum + hashing → powerful pattern
- HashSet for uniqueness problems
- Real-world problem-solving using hashing

---

# 🚀 Conclusion

This module builds a strong foundation in:

- Efficient data lookup
- Frequency-based problems
- Prefix sum optimization
- Interview-level DSA patterns

---

# 👨‍💻 Author

**Satinder Singh Sall**
Full-Stack Web/Mobile Engineer
DSA | Java | Problem Solving

---

# 📘 Hashing in Data Structures & Algorithms (Java)

## 📌 Overview

This repository contains a comprehensive implementation of **Hashing concepts in Data Structures & Algorithms (DSA)** using Java.
It covers both **theoretical foundations** and **practical problem-solving approaches**, including real-world coding patterns frequently asked in technical interviews.

The implementation includes:

- Core hashing data structures
- Custom HashMap implementation
- Standard library usage (`HashMap`, `HashSet`, `LinkedHashMap`, `TreeMap`, etc.)
- Problem-solving using hashing techniques

---

## 🧠 Topics Covered

### 🔹 1. HashMap Fundamentals

- Creation, insertion, deletion, search
- Time complexity: **O(1)** average
- Iteration using `keySet()` and `entrySet()`

📂 Reference:

---

### 🔹 2. Custom HashMap Implementation

- Built from scratch using:
  - Array of buckets
  - LinkedList (chaining)

- Includes:
  - `put()`, `get()`, `remove()`
  - Custom hash function

📂 Reference:

---

### 🔹 3. HashSet & Variants

- Unique element storage
- No duplicates allowed
- Variants:
  - `LinkedHashSet` → maintains insertion order
  - `TreeSet` → sorted order

📂 References:

-
- ***

### 🔹 4. LinkedHashMap & TreeMap

| Structure     | Ordering        | Complexity |
| ------------- | --------------- | ---------- |
| HashMap       | No order        | O(1)       |
| LinkedHashMap | Insertion order | O(1)       |
| TreeMap       | Sorted order    | O(log n)   |

📂 References:

-
- ***

## 💻 Problem Solving with Hashing

### ✅ 1. Count Distinct Elements

- Uses `HashSet` to remove duplicates
- Efficient solution: **O(n)**

📂 Code:

---

### ✅ 2. Union & Intersection of Arrays

- Union → combine unique elements
- Intersection → common elements

📂 Code:

---

### ✅ 3. Find Itinerary from Tickets

- Uses `HashMap` for mapping routes
- Key concept: **starting point = not a destination**

📂 Code:

---

### ✅ 4. Largest Subarray with Sum = 0

- Uses **prefix sum + HashMap**
- Stores: `sum → index`

📂 Code:

---

### ✅ 5. Subarray Sum Equal to K

- Uses **prefix sum + frequency map**
- Key formula:

  ```
  sum - K = previous sum
  ```

📂 Code:

---

### ✅ 6. Majority Element (> n/3 times)

- Uses frequency counting with `HashMap`

📂 Code:

---

### ✅ 7. Valid Anagram

- Uses character frequency comparison

📂 Code:

---

## ⚙️ Core Concepts Learned

### 🔸 Hashing Principles

- Hash function → index mapping
- Collision handling → chaining

### 🔸 Time Complexity

| Operation | Complexity |
| --------- | ---------- |
| Insert    | O(1) avg   |
| Search    | O(1) avg   |
| Delete    | O(1) avg   |

---

### 🔸 Prefix Sum Technique

Used in:

- Largest subarray with sum 0
- Subarray sum = K

---

### 🔸 Key Patterns

- **Set for uniqueness**
- **Map for frequency**
- **Prefix sum for subarrays**

---

## 🚀 How to Run

```bash
javac FileName.java
java FileName
```

Example:

```bash
javac CountDistinctElements.java
java CountDistinctElements
```

---

## 🧩 Project Structure

```
Hashing/
│
├── HashMap_Implementation.java
├── HashMap_Operations.java
├── LinkedHashMap_Operations.java
├── TreeMap_Operations.java
├── HashSet_Operations.java
├── LinkedHashSet_Example.java
├── TreeSet_Example.java
│
├── CountDistinctElements.java
├── UnionIntersection.java
├── FindItinerary.java
├── LargestSubarrayZeroSum.java
├── SubarraySumK.java
├── MajorityElement.java
├── ValidAnagram.java
│
└── Main.java
```

---

## 🎯 Learning Outcomes

After completing this module, you can:

- ✅ Understand and implement hashing concepts
- ✅ Use Java Collections effectively
- ✅ Solve interview-level problems using hashing
- ✅ Apply prefix sum techniques
- ✅ Analyze time & space complexity

---

## 📈 Future Scope

- Sliding Window vs Hashing problems
- Advanced hashing (rolling hash, Rabin-Karp)
- Graph problems using HashMap
- Competitive programming optimizations

---

## 👨‍💻 Author

**Satinder Singh Sall**
📚 DSA (Sigma 4.0 – Apna College)
💻 Java Developer | Problem Solver

**Satinder Singh Sall**
Full-Stack Web/Mobile Engineer
DSA | Java | Problem Solving

---

## ⭐ Final Note

This repository demonstrates a **strong foundation in hashing**, combining:

- Conceptual clarity
- Clean coding practices
- Efficient algorithms

---

# 🚀 Hashing in Data Structures & Algorithms (Java)

---

# 🚀 Hashing in Data Structures & Algorithms (Java)

<p align="center">
  <b>Efficient problem solving using HashMaps, HashSets & Prefix Sum techniques</b><br>
  📚 Sigma 4.0 (Apna College) | 💻 Java | ⚡ Interview Preparation
</p>

---

## 🏷️ Badges

<p align="center">
  <img src="https://img.shields.io/badge/Language-Java-blue.svg">
  <img src="https://img.shields.io/badge/DSA-Hashing-green.svg">
  <img src="https://img.shields.io/badge/Level-Intermediate-orange.svg">
  <img src="https://img.shields.io/badge/Status-Completed-brightgreen.svg">
</p>

---

## 📌 Overview

This repository contains a **complete implementation of Hashing concepts** in Java, covering:

- Core data structures (`HashMap`, `HashSet`, `TreeMap`, etc.)
- Custom HashMap implementation
- Real-world DSA problems
- Interview-focused patterns (Prefix Sum, Frequency Map)

---

## 🧠 Concepts Covered

### 🔹 HashMap

- Insert, Delete, Search → **O(1)**
- Iteration using `keySet()` & `entrySet()`

📂 Example:

---

### 🔹 HashSet & Variants

- Unique elements storage
- No duplicates

| Type          | Feature         |
| ------------- | --------------- |
| HashSet       | Unordered       |
| LinkedHashSet | Insertion order |
| TreeSet       | Sorted          |

📂 Examples:

-
- ***

### 🔹 Map Variants Comparison

| Structure     | Order           | Complexity |
| ------------- | --------------- | ---------- |
| HashMap       | No order        | O(1)       |
| LinkedHashMap | Insertion order | O(1)       |
| TreeMap       | Sorted          | O(log n)   |

📂 Examples:

-
- ***

### 🔹 Custom HashMap Implementation

- Built using:
  - Buckets (array)
  - Chaining (LinkedList)

- Includes: `put()`, `get()`, `remove()`

📂 Code:

---

## 💻 Problem Solving

### 🟢 Beginner

#### ✅ Count Distinct Elements

- Uses `HashSet`
- Removes duplicates efficiently

📂

---

### 🟡 Intermediate

#### ✅ Union & Intersection of Arrays

- Union → unique elements
- Intersection → common elements

📂

---

#### ✅ Valid Anagram

- Character frequency matching

📂

---

#### ✅ Majority Element (> n/3)

- Frequency-based hashing

📂

---

### 🔴 Advanced (Interview Level)

#### ✅ Find Itinerary from Tickets

- Graph-like traversal using HashMap

📂

---

#### ✅ Largest Subarray with Sum = 0

- Prefix Sum + HashMap

📂

---

#### ✅ Subarray Sum = K

- Prefix Sum + Frequency Map

📂

---

## 📊 Key Patterns

```text
1. HashSet → Uniqueness
2. HashMap → Frequency / Mapping
3. Prefix Sum → Subarray Problems
```

---

## ⚡ Complexity Summary

| Operation | Time Complexity |
| --------- | --------------- |
| Insert    | O(1) avg        |
| Search    | O(1) avg        |
| Delete    | O(1) avg        |
| TreeMap   | O(log n)        |

---

## 🧩 Project Structure

```bash
Hashing/
│
├── Core/
│   ├── HashMap_Implementation.java
│   ├── HashMap_Operations.java
│   ├── LinkedHashMap_Operations.java
│   ├── TreeMap_Operations.java
│
├── Sets/
│   ├── HashSet_Operations.java
│   ├── LinkedHashSet_Example.java
│   ├── TreeSet_Example.java
│
├── Problems/
│   ├── CountDistinctElements.java
│   ├── UnionIntersection.java
│   ├── FindItinerary.java
│   ├── LargestSubarrayZeroSum.java
│   ├── SubarraySumK.java
│   ├── MajorityElement.java
│   ├── ValidAnagram.java
│
└── Main.java
```

---

## ▶️ How to Run

```bash
javac FileName.java
java FileName
```

---

## 🎯 Learning Outcomes

✔ Strong understanding of hashing
✔ Ability to solve subarray problems efficiently
✔ Mastery of Java Collections
✔ Interview-ready problem-solving skills

---

## 📈 Future Improvements

- Sliding Window techniques
- Advanced hashing (Rabin-Karp)
- Graph problems with HashMap
- Competitive programming optimizations

---

## 👨‍💻 Author

**Satinder Singh Sall**
💻 Java | DSA | Problem Solving

---

## ⭐ Final Thoughts

> “Hashing is not just a data structure — it’s a problem-solving superpower.”

---
