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
