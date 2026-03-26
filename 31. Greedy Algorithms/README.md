# 📚 Data Structures & Algorithms: Greedy Algorithms (Java)

## 📚 Stack Data Structure in Java

### _Theory, Implementation, and Applications_

<p align="center">
  <img src="https://img.shields.io/badge/Language-Java-blue?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Topic-Greedy%20Algorithms-green?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Level-Academic%20%2B%20Interview%20Ready-purple?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Focus-Optimization-orange?style=for-the-badge" />
</p>

---

# Greedy Algorithms in Java

A comprehensive academic and practical guide to **Greedy Algorithms**, covering theoretical foundations, algorithm design principles, pseudocode, and Java implementations.

This repository is designed for:

- Computer Science students
- Software engineering interviews
- Competitive programming
- Algorithm coursework

---

# Table of Contents

1. Introduction to Greedy Algorithms
2. Properties of Greedy Algorithms
3. When Greedy Algorithms Work
4. Algorithm Design Template
5. Problems and Implementations
   - Coin Change (Greedy Approach)
   - Activity Selection
   - Fractional Knapsack
   - Huffman Coding
   - Minimum Spanning Tree (Kruskal)

6. Greedy vs Dynamic Programming
7. Time Complexity Analysis
8. References

---

# 1. Introduction

A **Greedy Algorithm** is an algorithmic paradigm that builds up a solution piece by piece, **always choosing the locally optimal option at each step** with the expectation that this will lead to a **globally optimal solution**.

Unlike dynamic programming, greedy algorithms **do not reconsider earlier decisions**.

### Core Principle

At each step, choose the option that provides the **best immediate benefit**.

---

# 2. Properties of Greedy Algorithms

A problem can typically be solved using a greedy approach if it satisfies two properties.

## Greedy Choice Property

A globally optimal solution can be obtained by **making locally optimal choices**.

## Optimal Substructure

An optimal solution contains **optimal solutions to its subproblems**.

---

# 3. When Greedy Algorithms Work

Greedy algorithms are effective in problems involving:

- Optimization
- Scheduling
- Graphs
- Resource allocation

Common techniques used with greedy algorithms:

- Sorting
- Priority queues
- Graph traversal

---

# 4. Greedy Algorithm Design Template

General greedy strategy:

```
1. Define the objective function.
2. Sort or structure the data.
3. Repeatedly choose the locally optimal option.
4. Add it to the solution if feasible.
5. Continue until the solution is complete.
```

---

# 5. Problem Implementations

---

# Problem 1: Coin Change (Greedy Approach)

## Problem Statement

Given a set of coin denominations and a target amount, determine the minimum number of coins required to make that amount using a greedy approach.

Example:

```
Coins: 1, 2, 5, 10, 20, 50, 100, 500
Amount: 275
```

Goal: Minimize the number of coins.

---

## Algorithm

1. Sort coins in descending order.
2. Pick the largest coin smaller than or equal to the remaining amount.
3. Subtract it from the total.
4. Repeat until the amount becomes zero.

---

## Pseudocode

```
GreedyCoinChange(coins, amount):

    result = empty list

    for coin from largest to smallest:
        while amount >= coin:
            add coin to result
            amount = amount - coin

    return result
```

---

## Java Implementation

```java
import java.util.*;

public class CoinChangeGreedy {

    public static void main(String[] args) {

        int amount = 275;

        int[] coins = {1,2,5,10,20,50,100,500};

        List<Integer> result = new ArrayList<>();

        for(int i = coins.length - 1; i >= 0; i--) {

            while(amount >= coins[i]) {
                amount -= coins[i];
                result.add(coins[i]);
            }

        }

        System.out.println("Coins used: " + result);
    }
}
```

---

# Problem 2: Activity Selection

## Problem Statement

Given a set of activities with start and finish times, select the **maximum number of activities** that can be performed without overlapping.

Example:

```
Activity  Start  End
A1        1      4
A2        3      5
A3        0      6
A4        5      7
A5        8      9
```

---

## Algorithm

1. Sort activities by **finish time**.
2. Select the first activity.
3. For each remaining activity:
   - If its start time ≥ finish time of last selected activity → select it.

---

## Pseudocode

```
ActivitySelection(activities):

    sort activities by finish time

    select first activity
    lastFinish = finish time of first activity

    for each activity in activities:
        if activity.start >= lastFinish:
            select activity
            lastFinish = activity.finish
```

---

## Java Implementation

```java
import java.util.*;

class Activity {
    int start;
    int end;

    Activity(int s, int e) {
        start = s;
        end = e;
    }
}

public class ActivitySelection {

    public static void main(String[] args) {

        Activity[] activities = {
            new Activity(1,4),
            new Activity(3,5),
            new Activity(0,6),
            new Activity(5,7),
            new Activity(8,9)
        };

        Arrays.sort(activities, Comparator.comparingInt(a -> a.end));

        int count = 1;
        int lastEnd = activities[0].end;

        for(int i=1;i<activities.length;i++) {

            if(activities[i].start >= lastEnd) {
                count++;
                lastEnd = activities[i].end;
            }

        }

        System.out.println("Maximum activities: " + count);
    }
}
```

---

# Problem 3: Fractional Knapsack

## Problem Statement

Given items with values and weights and a knapsack with capacity **W**, maximize the total value.

Unlike the 0/1 knapsack problem, **fractions of items can be taken**.

---

## Algorithm

1. Compute value/weight ratio for each item.
2. Sort items in descending order of ratio.
3. Pick items fully until capacity is reached.
4. Take fraction of the next item if necessary.

---

## Pseudocode

```
FractionalKnapsack(items, capacity):

    sort items by value/weight ratio

    totalValue = 0

    for each item:
        if capacity >= item.weight:
            capacity -= item.weight
            totalValue += item.value
        else:
            totalValue += ratio * capacity
            break

    return totalValue
```

---

## Java Implementation

```java
import java.util.*;

class Item {
    int value;
    int weight;

    Item(int v, int w) {
        value = v;
        weight = w;
    }
}

public class FractionalKnapsack {

    public static void main(String[] args) {

        Item[] items = {
            new Item(60,10),
            new Item(100,20),
            new Item(120,30)
        };

        int capacity = 50;

        Arrays.sort(items, (a,b) ->
                Double.compare((double)b.value/b.weight,
                               (double)a.value/a.weight));

        double totalValue = 0;

        for(Item item : items) {

            if(capacity >= item.weight) {
                capacity -= item.weight;
                totalValue += item.value;
            }
            else {
                totalValue += ((double)item.value/item.weight) * capacity;
                break;
            }

        }

        System.out.println("Maximum value: " + totalValue);
    }
}
```

---

# Problem 4: Huffman Coding

## Problem Statement

Given characters and their frequencies, construct a **binary tree that minimizes the weighted path length**, enabling optimal data compression.

Used in:

- ZIP
- JPEG
- MP3

---

## Algorithm

1. Insert all characters into a **min-heap based on frequency**.
2. Extract two nodes with smallest frequency.
3. Merge them into a new node.
4. Insert the new node back into the heap.
5. Repeat until only one node remains.

---

## Pseudocode

```
HuffmanCoding(chars, freq):

    create minHeap

    insert all nodes into heap

    while heap size > 1:

        left = extractMin()
        right = extractMin()

        newNode.freq = left.freq + right.freq
        newNode.left = left
        newNode.right = right

        insert newNode

    return root
```

---

## Java Implementation

```java
import java.util.*;

class Node {
    int freq;
    char ch;
    Node left;
    Node right;

    Node(char c, int f) {
        ch = c;
        freq = f;
    }
}

public class HuffmanCoding {

    public static void main(String[] args) {

        char[] chars = {'a','b','c','d','e','f'};
        int[] freq = {5,9,12,13,16,45};

        PriorityQueue<Node> pq =
                new PriorityQueue<>(Comparator.comparingInt(n -> n.freq));

        for(int i=0;i<chars.length;i++) {
            pq.add(new Node(chars[i], freq[i]));
        }

        while(pq.size() > 1) {

            Node left = pq.poll();
            Node right = pq.poll();

            Node parent = new Node('-', left.freq + right.freq);
            parent.left = left;
            parent.right = right;

            pq.add(parent);
        }

        System.out.println("Huffman Tree constructed.");
    }
}
```

---

# Problem 5: Minimum Spanning Tree (Kruskal Algorithm)

## Problem Statement

Given a connected weighted graph, find a subset of edges that:

- Connects all vertices
- Has **minimum total weight**
- Contains **no cycles**

---

## Algorithm

1. Sort edges by weight.
2. Initialize disjoint sets.
3. Pick smallest edge.
4. If it does not form a cycle, add it to MST.
5. Continue until V−1 edges are selected.

---

## Pseudocode

```
Kruskal(graph):

    sort edges by weight

    initialize disjoint sets

    for each edge:
        if find(u) != find(v):
            add edge to MST
            union(u, v)
```

---

## Java Implementation

```java
import java.util.*;

class Edge {
    int src;
    int dest;
    int weight;

    Edge(int s, int d, int w) {
        src = s;
        dest = d;
        weight = w;
    }
}

public class Kruskal {

    static int find(int parent[], int i) {

        if(parent[i] == i)
            return i;

        return parent[i] = find(parent, parent[i]);
    }

    static void union(int parent[], int x, int y) {
        parent[find(parent,x)] = find(parent,y);
    }

    public static void main(String[] args) {

        Edge[] edges = {
            new Edge(0,1,10),
            new Edge(0,2,6),
            new Edge(0,3,5),
            new Edge(1,3,15),
            new Edge(2,3,4)
        };

        Arrays.sort(edges, Comparator.comparingInt(e -> e.weight));

        int[] parent = new int[4];

        for(int i=0;i<4;i++)
            parent[i] = i;

        int mstWeight = 0;

        for(Edge edge : edges) {

            int x = find(parent, edge.src);
            int y = find(parent, edge.dest);

            if(x != y) {
                mstWeight += edge.weight;
                union(parent, x, y);
            }

        }

        System.out.println("MST Weight: " + mstWeight);
    }
}
```

---

# 6. Greedy vs Dynamic Programming

| Feature                     | Greedy        | Dynamic Programming |
| --------------------------- | ------------- | ------------------- |
| Decision making             | Local optimal | Global optimal      |
| Reconsideration             | No            | Yes                 |
| Speed                       | Faster        | Slower              |
| Guarantees optimal solution | Not always    | Yes                 |

---

# 7. Time Complexity

| Algorithm           | Time Complexity |
| ------------------- | --------------- |
| Coin Change         | O(n)            |
| Activity Selection  | O(n log n)      |
| Fractional Knapsack | O(n log n)      |
| Huffman Coding      | O(n log n)      |
| Kruskal             | O(E log E)      |

---

# 8. References

- Thomas H. Cormen — _Introduction to Algorithms_
- Kleinberg & Tardos — _Algorithm Design_
- CLRS Greedy Algorithms Chapter
- Stanford Algorithms Course
- MIT OpenCourseWare Algorithms

---

If you'd like, I can also help you **turn this into a complete GitHub repository with**:

- Proper **directory structure**
- **Separate Java files**
- **Complexity analysis**
- **algorithm diagrams**
- **20–30 additional greedy problems**
- **GitHub badges + academic formatting**.

---

Here is a **professional, academic-quality `README.md`** based on all your uploaded files and topics. I carefully reviewed each file line-by-line and incorporated every concept.

---

# 📘 Greedy Algorithms in Java

## 📌 Overview

This repository contains implementations of **Greedy Algorithms** in Java, covering a wide range of classical optimization problems. Each problem demonstrates how locally optimal choices lead to globally optimal solutions under specific conditions.

The repository is designed for:

- 📚 Academic learning (Data Structures & Algorithms)
- 💼 Interview preparation
- 🧠 Conceptual clarity in Greedy techniques

---

## 🧠 Topics Covered

- Activity Selection Problem
- Fractional Knapsack Problem
- Job Sequencing with Deadlines
- Minimum Number of Coins (Indian Currency System)
- Chocolate Cutting Problem (Minimum Cost)
- Maximum Length Chain of Pairs
- Minimum Absolute Difference Pairs
- Sorting & Greedy Strategy Integration

---

## 📂 Project Structure

```
├── ActivitySelection.java
├── ActivitySelection2.java
├── FractionalKnapsack.java
├── JobSequencing.java
├── IndianCoins.java
├── ChocolateProblem.java
├── MaxLenChainPairs.java
├── MinAbsDiffPairs.java
├── Main.java
```

---

## 🚀 Implemented Problems

### 1️⃣ Activity Selection Problem

📄 File:

- Select maximum number of non-overlapping activities.
- Assumes activities are sorted by end time.
- Time Complexity: **O(n)**

🔹 Approach:

- Always pick the activity with the earliest finishing time.
- Continue selecting compatible activities.

---

### 2️⃣ Activity Selection (Unsorted Input)

📄 File:

- Handles unsorted input using sorting.
- Uses **2D array + Comparator (Lambda)**.

🔹 Key Concepts:

- Sorting by end time
- Greedy selection after sorting

---

### 3️⃣ Fractional Knapsack Problem

📄 File:

- Maximizes value with fractional item inclusion.

🔹 Approach:

- Compute **value/weight ratio**
- Sort in descending order
- Take full or fractional items accordingly

⏱ Time Complexity: **O(n log n)**

---

### 4️⃣ Job Sequencing Problem

📄 File:

- Schedule jobs to maximize profit within deadlines.

🔹 Approach:

- Sort jobs by profit (descending)
- Assign jobs to latest available slot before deadline

---

### 5️⃣ Minimum Number of Coins (Indian Coins)

📄 File:

- Finds minimum coins for a given value.

🔹 Approach:

- Use largest denomination first
- Greedy works due to canonical coin system

---

### 6️⃣ Chocolate Cutting Problem

📄 File:

- Minimize cost of breaking chocolate into 1×1 pieces.

🔹 Approach:

- Sort cut costs in descending order
- Multiply cost by current segments

---

### 7️⃣ Maximum Length Chain of Pairs

📄 File:

- Find longest chain where next pair starts after previous ends.

🔹 Approach:

- Sort pairs by end value
- Apply activity selection logic

---

### 8️⃣ Minimum Absolute Difference Pairs

📄 File:

- Minimize sum of absolute differences between pairs.

🔹 Approach:

- Sort both arrays
- Pair corresponding elements

---

### 9️⃣ Main File (Execution Template)

📄 File:

- Basic Java execution structure
- Demonstrates loops and output formatting

---

## ⚙️ Key Concepts & Techniques

### ✅ Greedy Strategy

- Make the **locally optimal choice** at each step
- Works only when **optimal substructure + greedy choice property** holds

### ✅ Sorting as a Foundation

Many greedy problems rely on sorting:

- By end time
- By profit
- By ratio
- By cost

### ✅ Data Structures Used

- Arrays
- ArrayList
- 2D Arrays
- Custom Classes (Job objects)

### ✅ Java Features Used

- Lambda Expressions
- Comparator Interface
- Collections Framework
- Arrays Utility Methods

---

## 📊 Complexity Summary

| Problem             | Time Complexity   |
| ------------------- | ----------------- |
| Activity Selection  | O(n) / O(n log n) |
| Fractional Knapsack | O(n log n)        |
| Job Sequencing      | O(n²)             |
| Indian Coins        | O(n)              |
| Chocolate Problem   | O(n log n)        |
| Chain of Pairs      | O(n log n)        |
| Min Abs Difference  | O(n log n)        |

---

## 🧪 How to Run

1. Compile any file:

```bash
javac FileName.java
```

2. Run:

```bash
java FileName
```

Example:

```bash
javac FractionalKnapsack.java
java FractionalKnapsack
```

---

## 🎯 Learning Outcomes

By completing this module, you have:

- Understood when Greedy algorithms work
- Learned multiple classic greedy problems
- Implemented efficient Java solutions
- Gained insight into optimization strategies

---

## 📌 Conclusion

This repository demonstrates how **Greedy Algorithms** can efficiently solve optimization problems by making smart local decisions. It also highlights the importance of **sorting and problem structure** in determining whether a greedy approach is valid.

---

## 👨‍💻 Author

Satinder Singh Sall
Full-Stack Web/Mobile Engineer

---

---

# 🚀 Greedy Algorithms in Java

![Java](https://img.shields.io/badge/Language-Java-blue)
![DSA](https://img.shields.io/badge/Topic-Data%20Structures%20%26%20Algorithms-green)
![Greedy](https://img.shields.io/badge/Technique-Greedy-orange)
![Level](https://img.shields.io/badge/Level-Academic%20%2B%20Interview-important)

---

## 📌 Overview

This repository contains a comprehensive implementation of **Greedy Algorithms** in Java. Each problem demonstrates how **locally optimal decisions** can lead to **globally optimal solutions**.

This project is designed for:

- 🎓 Academic coursework
- 💼 Coding interviews
- 🧠 Concept mastery

---

## 🧠 What is a Greedy Algorithm?

A **Greedy Algorithm** makes the best possible choice at each step **without reconsidering previous decisions**.

### ✅ Conditions for Greedy:

- **Optimal Substructure**
- **Greedy Choice Property**

---

## 📂 Problems Covered

1. Activity Selection
2. Fractional Knapsack
3. Job Sequencing
4. Indian Coins (Minimum Coins)
5. Chocolate Cutting Problem
6. Maximum Length Chain of Pairs
7. Minimum Absolute Difference Pairs

---

# 🧩 1. Activity Selection Problem

## 📖 Problem

Select the **maximum number of non-overlapping activities**.

---

## 🧠 Theory

- Choose activity with **earliest finish time**
- Ensures maximum remaining time for others

---

## 🔄 Flowchart

```
Start
  ↓
Sort activities by end time
  ↓
Select first activity
  ↓
For each activity:
    If start ≥ lastEnd:
        Select it
  ↓
End
```

---

## 🧾 Pseudocode

```
sort activities by end time
select first activity
lastEnd = end[0]

for i = 1 to n:
    if start[i] >= lastEnd:
        select activity
        lastEnd = end[i]
```

---

## 💻 Code Explanation

From your file:

- Uses arrays `start[]` and `end[]`
- Tracks last selected activity using `lastEnd`
- Stores results in `ArrayList`

---

# 🧩 2. Fractional Knapsack

## 📖 Problem

Maximize value with limited capacity (fractions allowed).

---

## 🧠 Theory

- Use **value/weight ratio**
- Pick highest ratio first

---

## 🔄 Flowchart

```
Start
  ↓
Compute ratio = value/weight
  ↓
Sort by ratio (descending)
  ↓
Take full items or fraction
  ↓
End
```

---

## 🧾 Pseudocode

```
calculate ratio for each item
sort items by ratio descending

for each item:
    if capacity allows:
        take full
    else:
        take fraction
        break
```

---

## 💻 Code Insight

- Uses `Double.compare()` for sorting
- Maintains `capacity`
- Adds fractional value when needed

---

# 🧩 3. Job Sequencing Problem

## 📖 Problem

Schedule jobs to **maximize profit** before deadlines.

---

## 🧠 Theory

- Pick highest profit jobs first
- Assign to latest possible slot

---

## 🔄 Flowchart

```
Start
  ↓
Sort jobs by profit
  ↓
Find max deadline
  ↓
For each job:
    place in latest free slot
  ↓
End
```

---

## 🧾 Pseudocode

```
sort jobs by profit descending
for each job:
    for slot = deadline to 1:
        if slot empty:
            assign job
            break
```

---

## 💻 Code Insight

- Uses custom `Job` class
- Slot array initialized with `-1`
- Greedy scheduling logic

---

# 🧩 4. Indian Coins Problem

## 📖 Problem

Find minimum number of coins to make value.

---

## 🧠 Theory

- Always pick **largest denomination first**
- Works due to canonical system

---

## 🔄 Flowchart

```
Start
  ↓
Take largest coin
  ↓
Subtract from value
  ↓
Repeat until zero
```

---

## 🧾 Pseudocode

```
coins = [2000, 500, ... ,1]

for coin in coins:
    while value >= coin:
        value -= coin
        count++
```

---

## 💻 Code Insight

- Uses loop + while condition
- Greedy guarantees optimal result

---

# 🧩 5. Chocolate Cutting Problem

## 📖 Problem

Minimize cost of breaking chocolate into 1×1 pieces.

---

## 🧠 Theory

- Always perform **costliest cut first**
- Multiply by current segments

---

## 🔄 Flowchart

```
Start
  ↓
Sort costs descending
  ↓
Pick higher cost cut
  ↓
Update pieces
  ↓
Repeat
```

---

## 🧾 Pseudocode

```
sort x and y descending

while both remain:
    if x[i] > y[j]:
        cost += x[i] * horizontalPieces
    else:
        cost += y[j] * verticalPieces
```

---

## 💻 Code Insight

- Uses `Collections.reverseOrder()`
- Tracks horizontal & vertical segments

---

# 🧩 6. Maximum Length Chain of Pairs

## 📖 Problem

Find longest chain where:

```
(a, b) → (c, d) if b < c
```

---

## 🧠 Theory

- Same as activity selection
- Sort by second element

---

## 🧾 Pseudocode

```
sort pairs by end

count = 1
lastEnd = first pair end

for each pair:
    if start > lastEnd:
        count++
```

---

## 💻 Code Insight

- Uses 2D array
- Greedy selection logic

---

# 🧩 7. Minimum Absolute Difference Pairs

## 📖 Problem

Minimize:

```
Σ |A[i] - B[i]|
```

---

## 🧠 Theory

- Sort both arrays
- Match corresponding elements

---

## 🧾 Pseudocode

```
sort A
sort B

for i:
    sum += abs(A[i] - B[i])
```

---

## 💻 Code Insight

- Uses `Arrays.sort()`
- Simple greedy pairing

---

# 📊 Complexity Summary

| Problem            | Complexity |
| ------------------ | ---------- |
| Activity Selection | O(n log n) |
| Knapsack           | O(n log n) |
| Job Sequencing     | O(n²)      |
| Coins              | O(n)       |
| Chocolate          | O(n log n) |

---

# 🧪 How to Run

```bash
javac FileName.java
java FileName
```

---

# 🎓 Viva / Interview Questions

## 🔹 Conceptual

1. What is a Greedy Algorithm?
2. When does Greedy fail?
3. Difference between Greedy and Dynamic Programming?
4. What is greedy choice property?

---

## 🔹 Problem-Based

1. Why does activity selection work greedily?
2. Why is fractional knapsack greedy but 0/1 is not?
3. Why does Indian coin system guarantee optimal solution?
4. Can job sequencing be optimized further?

---

## 🔹 Coding

1. Modify knapsack to print selected items
2. Convert activity selection to return indices
3. Optimize job sequencing using priority queue

---

# 🎯 Learning Outcomes

- Strong understanding of greedy paradigm
- Ability to identify greedy problems
- Implementation of classic optimization problems
- Improved problem-solving skills

---

# 👨‍💻 Author

Satinder Singh Sall
Full-Stack Web/Mobile Engineer

---

# 📖 Overview

This repository/module provides a **complete academic and practical understanding of Greedy Algorithms**, covering:

- Core theory and intuition
- When greedy works (and when it doesn’t)
- Classic interview problems
- Java-based implementations
- Time & space complexity analysis

---

# 🧠 1. GREEDY ALGORITHM THEORY (Fundamentals → Advanced)

## 🔹 What is a Greedy Algorithm?

A **Greedy Algorithm** is an approach where:

> At each step, we choose the **locally optimal solution**, hoping it leads to a **globally optimal solution**.

---

## 🔹 Key Characteristics

✔ Makes the best choice at each step
✔ Does NOT reconsider previous decisions
✔ Works efficiently for optimization problems

---

## 🔹 When Does Greedy Work?

A greedy algorithm works **only if**:

### 1. Greedy Choice Property

- A global optimal solution can be reached by making **local optimal choices**

### 2. Optimal Substructure

- Problem can be broken into smaller subproblems

---

## 🔹 When Greedy Fails

Greedy fails when:

- Local choices do NOT lead to global optimum
- Example: Some dynamic programming problems

---

## 🔹 Greedy vs Dynamic Programming

| Feature         | Greedy             | DP             |
| --------------- | ------------------ | -------------- |
| Decision Making | Local              | Global         |
| Backtracking    | ❌ No              | ✔ Yes          |
| Complexity      | Usually lower      | Higher         |
| Example         | Activity Selection | Knapsack (0/1) |

---

# ⚙️ 2. GREEDY DESIGN STRATEGY

### Steps to Solve Using Greedy:

1. Identify optimization goal (min/max)
2. Sort input (if needed)
3. Make locally optimal choice
4. Repeat until solution is complete

---

# 💻 3. CLASSIC GREEDY PROBLEMS (WITH THEORY + CODE + COMPLEXITY)

---

## 🔹 3.1 Activity Selection Problem

### 🧠 Theory

- Select maximum number of non-overlapping activities
- Sort by **end time**

### 💻 Java Code

```java
import java.util.*;

public class ActivitySelection {
    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[]   = {2, 4, 6, 7, 9, 9};

        int count = 1;
        int lastEnd = end[0];

        for (int i = 1; i < end.length; i++) {
            if (start[i] >= lastEnd) {
                count++;
                lastEnd = end[i];
            }
        }

        System.out.println("Max Activities: " + count);
    }
}
```

### ⚙️ Complexity

- Time: O(n log n) (sorting)
- Space: O(1)

---

## 🔹 3.2 Fractional Knapsack

### 🧠 Theory

- Take items based on **value/weight ratio**
- Fractions allowed → greedy works

### 💻 Java Code

```java
import java.util.*;

class Item {
    int value, weight;

    Item(int v, int w) {
        value = v;
        weight = w;
    }
}

public class FractionalKnapsack {
    public static void main(String[] args) {
        Item[] items = {
            new Item(60, 10),
            new Item(100, 20),
            new Item(120, 30)
        };

        Arrays.sort(items, (a, b) ->
            Double.compare((double)b.value/b.weight, (double)a.value/a.weight)
        );

        int capacity = 50;
        double total = 0;

        for (Item item : items) {
            if (capacity >= item.weight) {
                total += item.value;
                capacity -= item.weight;
            } else {
                total += (double)item.value/item.weight * capacity;
                break;
            }
        }

        System.out.println("Max Value: " + total);
    }
}
```

### ⚙️ Complexity

- Time: O(n log n)
- Space: O(1)

---

## 🔹 3.3 Minimum Number of Coins

### 🧠 Theory

- Use largest denomination first

### 💻 Java Code

```java
import java.util.*;

public class MinCoins {
    public static void main(String[] args) {
        int coins[] = {1, 2, 5, 10, 20, 50, 100};
        int amount = 590;

        int count = 0;

        for (int i = coins.length - 1; i >= 0; i--) {
            while (coins[i] <= amount) {
                amount -= coins[i];
                count++;
            }
        }

        System.out.println("Min coins: " + count);
    }
}
```

### ⚙️ Complexity

- Time: O(n)
- Space: O(1)

---

## 🔹 3.4 Job Sequencing Problem

### 🧠 Theory

- Maximize profit within deadlines
- Sort jobs by profit

### 💻 Java Code

```java
import java.util.*;

class Job {
    int id, deadline, profit;

    Job(int i, int d, int p) {
        id = i;
        deadline = d;
        profit = p;
    }
}

public class JobSequencing {
    public static void main(String[] args) {
        Job[] jobs = {
            new Job(1, 2, 100),
            new Job(2, 1, 50),
            new Job(3, 2, 10),
            new Job(4, 1, 20)
        };

        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int time = 0;
        int profit = 0;

        for (Job job : jobs) {
            if (job.deadline > time) {
                profit += job.profit;
                time++;
            }
        }

        System.out.println("Max Profit: " + profit);
    }
}
```

### ⚙️ Complexity

- Time: O(n log n)
- Space: O(n)

---

## 🔹 3.5 Chocola Problem (Minimum Cost Cutting)

### 🧠 Theory

- Choose highest cost cut first

### ⚙️ Complexity

- Time: O(n log n)
- Space: O(1)

---

# 📊 4. COMPLEXITY SUMMARY

| Problem             | Time       | Space |
| ------------------- | ---------- | ----- |
| Activity Selection  | O(n log n) | O(1)  |
| Fractional Knapsack | O(n log n) | O(1)  |
| Min Coins           | O(n)       | O(1)  |
| Job Sequencing      | O(n log n) | O(n)  |

---

# 🧠 5. KEY INSIGHTS

✔ Greedy is fast but not always correct
✔ Sorting is often the first step
✔ Works best for optimization problems
✔ Must verify greedy choice property

---

# 🚀 How to Run

```bash
javac FileName.java
java FileName
```

---

# 📌 Real-World Applications

- Scheduling (CPU, tasks)
- Resource allocation
- Networking (routing)
- Huffman Coding (compression)
- Finance optimization

---

# ⚠️ Common Mistakes

❌ Assuming greedy always works
❌ Not sorting input properly
❌ Ignoring constraints

---

# 👨‍💻 Author

**Satinder Singh Sall**
Full-Stack Web/Mobile Engineer
📘 Data Structures & Algorithms
🎯 Interview Preparation + Academic Learning

---

# 📄 License

Educational & portfolio use

---

⭐ _Star this repo if it helped you understand Greedy Algorithms deeply!_

Below is a **comprehensive guide to Greedy Algorithms in Java**, starting from the fundamentals and progressing to advanced patterns used in interviews and competitive programming.

---

# Greedy Algorithms in Java: Complete Guide (Beginner → Advanced)

## 1. What is a Greedy Algorithm?

A **Greedy Algorithm** builds a solution **step-by-step**, always choosing the **locally optimal choice** at each step with the hope that it leads to a **globally optimal solution**.

### Key Idea

> Make the best choice **right now** without reconsidering past decisions.

### Characteristics

Greedy algorithms work when the problem satisfies:

1. **Greedy Choice Property**
   A global optimum can be reached by choosing a local optimum.

2. **Optimal Substructure**
   Optimal solution of the problem contains optimal solutions to subproblems.

---

# 2. Basic Structure of Greedy Algorithm

General pattern:

```
1. Sort the input (often required)
2. Pick the best possible option
3. Update the solution
4. Repeat until problem solved
```

---

# 3. Simple Example: Coin Change (Greedy Version)

Goal: Use minimum coins to make an amount.

Coins:
`{1, 2, 5, 10, 20, 50, 100, 500}`

### Java Implementation

```java
import java.util.*;

public class CoinChangeGreedy {

    public static void main(String[] args) {

        int amount = 275;
        int coins[] = {1,2,5,10,20,50,100,500};

        List<Integer> result = new ArrayList<>();

        for(int i = coins.length - 1; i >= 0; i--) {
            while(amount >= coins[i]) {
                amount -= coins[i];
                result.add(coins[i]);
            }
        }

        System.out.println("Coins used: " + result);
    }
}
```

### Time Complexity

```
O(n)
```

---

# 4. Classic Greedy Problem: Activity Selection

Problem:
Select **maximum number of activities** that don't overlap.

### Steps

1. Sort by **finish time**
2. Pick first activity
3. Pick next activity with start ≥ last finish

---

### Java Implementation

```java
import java.util.*;

class Activity {
    int start, end;

    Activity(int s, int e) {
        start = s;
        end = e;
    }
}

public class ActivitySelection {

    public static void main(String[] args) {

        Activity[] arr = {
            new Activity(1,4),
            new Activity(3,5),
            new Activity(0,6),
            new Activity(5,7),
            new Activity(8,9)
        };

        Arrays.sort(arr, Comparator.comparingInt(a -> a.end));

        int count = 1;
        int lastEnd = arr[0].end;

        for(int i=1;i<arr.length;i++){
            if(arr[i].start >= lastEnd){
                count++;
                lastEnd = arr[i].end;
            }
        }

        System.out.println("Max activities: " + count);
    }
}
```

### Time Complexity

```
O(n log n)
```

---

# 5. Fractional Knapsack (Important Greedy Problem)

In this problem:
You **can take fractions of items**.

### Greedy Strategy

Choose item with **highest value/weight ratio**.

---

### Java Implementation

```java
import java.util.*;

class Item {
    int value, weight;

    Item(int v, int w){
        value = v;
        weight = w;
    }
}

public class FractionalKnapsack {

    public static void main(String[] args) {

        int capacity = 50;

        Item items[] = {
            new Item(60,10),
            new Item(100,20),
            new Item(120,30)
        };

        Arrays.sort(items, (a,b) ->
            Double.compare((double)b.value/b.weight, (double)a.value/a.weight));

        double totalValue = 0;

        for(Item item : items){

            if(capacity >= item.weight){
                capacity -= item.weight;
                totalValue += item.value;
            }
            else{
                totalValue += ((double)item.value/item.weight) * capacity;
                break;
            }
        }

        System.out.println("Max value: " + totalValue);
    }
}
```

### Time Complexity

```
O(n log n)
```

---

# 6. Huffman Coding (Advanced Greedy)

Used in **data compression**.

Examples:

- ZIP files
- JPEG
- MP3

### Idea

Characters with **higher frequency → shorter codes**

Uses:

```
Priority Queue (Min Heap)
```

---

### Java Implementation

```java
import java.util.*;

class Node {
    int freq;
    char ch;
    Node left, right;

    Node(char c, int f){
        ch = c;
        freq = f;
    }
}

public class HuffmanCoding {

    public static void main(String[] args){

        char[] chars = {'a','b','c','d','e','f'};
        int[] freq = {5,9,12,13,16,45};

        PriorityQueue<Node> pq =
            new PriorityQueue<>(Comparator.comparingInt(n -> n.freq));

        for(int i=0;i<chars.length;i++){
            pq.add(new Node(chars[i], freq[i]));
        }

        while(pq.size() > 1){

            Node left = pq.poll();
            Node right = pq.poll();

            Node parent = new Node('-', left.freq + right.freq);
            parent.left = left;
            parent.right = right;

            pq.add(parent);
        }

        System.out.println("Huffman Tree Built");
    }
}
```

---

# 7. Minimum Spanning Tree (Greedy)

Two major algorithms:

| Algorithm | Strategy    |
| --------- | ----------- |
| Kruskal   | Sort edges  |
| Prim      | Expand tree |

---

## Kruskal Algorithm

Uses:

```
Sorting + Union Find
```

### Java Code

```java
import java.util.*;

class Edge {
    int src, dest, weight;

    Edge(int s, int d, int w){
        src = s;
        dest = d;
        weight = w;
    }
}

public class Kruskal {

    static int find(int parent[], int i){
        if(parent[i] == i)
            return i;
        return parent[i] = find(parent, parent[i]);
    }

    static void union(int parent[], int x, int y){
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    public static void main(String[] args){

        Edge edges[] = {
            new Edge(0,1,10),
            new Edge(0,2,6),
            new Edge(0,3,5),
            new Edge(1,3,15),
            new Edge(2,3,4)
        };

        Arrays.sort(edges, Comparator.comparingInt(e -> e.weight));

        int parent[] = new int[4];

        for(int i=0;i<4;i++)
            parent[i] = i;

        int mstWeight = 0;

        for(Edge edge : edges){

            int x = find(parent, edge.src);
            int y = find(parent, edge.dest);

            if(x != y){
                mstWeight += edge.weight;
                union(parent, x, y);
            }
        }

        System.out.println("MST weight: " + mstWeight);
    }
}
```

---

# 8. Common Greedy Problem Patterns

## 1. Sorting + Selection

Examples:

- Activity selection
- Meeting rooms
- Job sequencing

---

## 2. Priority Queue

Examples:

- Huffman coding
- Merge k sorted lists
- Min cost ropes

---

## 3. Interval Scheduling

Examples:

- Non-overlapping intervals
- Minimum arrows to burst balloons

---

## 4. Graph Greedy

Examples:

- Prim's algorithm
- Kruskal algorithm
- Dijkstra algorithm

---

# 9. Important Greedy Interview Problems

| Problem                       | Platform  |
| ----------------------------- | --------- |
| Activity Selection            | Classic   |
| Fractional Knapsack           | Classic   |
| Job Sequencing with Deadlines | Interview |
| Minimum Platforms             | Interview |
| Gas Station                   | LeetCode  |
| Candy Distribution            | LeetCode  |
| Jump Game                     | LeetCode  |
| Minimum Arrows                | LeetCode  |
| Reorganize String             | LeetCode  |

---

# 10. Greedy vs Dynamic Programming

| Feature            | Greedy           | DP             |
| ------------------ | ---------------- | -------------- |
| Decision           | Local optimum    | Global optimum |
| Speed              | Faster           | Slower         |
| Complexity         | Often O(n log n) | Often O(n²)    |
| Guarantees optimal | Not always       | Always         |

Example:

```
Coin Change
Greedy → not always correct
DP → always correct
```

---

# 11. When Greedy Fails

Example:

Coins:

```
1, 3, 4
```

Amount:

```
6
```

Greedy:

```
4 + 1 + 1 = 3 coins
```

Optimal:

```
3 + 3 = 2 coins
```

---

# 12. Tips to Recognize Greedy Problems

Look for keywords:

- **Maximum number of tasks**
- **Minimum cost**
- **Earliest finish time**
- **Highest ratio**
- **Local optimal choice**

---

# 13. Greedy Template in Java

```java
Arrays.sort(arr);

for(Element e : arr){

    if(isSafe(e)){
        choose(e);
    }

}
```

---

# 14. Advanced Greedy Topics

### 1. Greedy with Heap

Example:

```
Reorganize String
Task Scheduler
```

### 2. Greedy + Binary Search

Example:

```
Aggressive Cows
Minimize Maximum Distance
```

### 3. Greedy + Graphs

Example:

```
Dijkstra
Prim
Kruskal
```

---

# 15. Best Practice Problems to Master Greedy

Beginner

```
Activity Selection
Assign Cookies
Minimum Coins
```

Intermediate

```
Job Sequencing
Gas Station
Jump Game
```

Advanced

```
Huffman Coding
Dijkstra
Minimum Spanning Tree
Candy Problem
```

---

# 16. Summary

Greedy algorithms:

✔ Choose **locally optimal choice**
✔ Often require **sorting or heap**
✔ Work when **greedy choice property holds**

Common complexity:

```
O(n log n)
```

---
