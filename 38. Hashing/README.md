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
