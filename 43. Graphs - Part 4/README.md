# Data Structure and Algorithms: DSA - Java

---

# Graphs Data Structure using Java (DSA - Sigma 4.0 / 43. Graphs - Part 4)

![Java](https://img.shields.io/badge/Language-Java-orange)
![DSA](https://img.shields.io/badge/Topic-Graphs-blue)
![Level](https://img.shields.io/badge/Level-Beginner%20to%20Advanced-green)
![Status](https://img.shields.io/badge/Status-Completed-success)

---

# Graph Algorithms in Java

### Minimum Spanning Tree & Shortest Path Algorithms

This module documents my study and implementation of fundamental **Graph Algorithms** using **Java**.  
The implementations follow the **Apna College Sigma 4.0 (DSA)** curriculum and include theoretical explanations, algorithm design, pseudocode, and working Java implementations.

The goal of this module is to build a strong foundation in **graph theory and algorithmic problem solving**, progressing from basic graph representations to advanced algorithms used in real-world systems such as routing, networking, and optimization.

---

# Table of Contents

1. Introduction to Graphs
2. Graph Representation
3. Shortest Path Algorithms
   - Bellman-Ford Algorithm
4. Minimum Spanning Tree Algorithms
   - Prim's Algorithm
5. Priority Queue in Graph Algorithms
6. Complexity Analysis
7. Running the Code
8. Learning Outcomes

---

# 1. Introduction to Graphs

A **graph** is a non-linear data structure consisting of:

- **Vertices (Nodes)** → represent entities
- **Edges** → represent relationships between vertices

Graph algorithms are used in many domains:

- Computer networks
- GPS navigation
- Social networks
- Transportation systems
- Compiler design

---

# 2. Graph Representation

In this module, graphs are represented using an **Adjacency List**.

### Advantages

- Efficient memory usage
- Ideal for sparse graphs
- Faster traversal

### Java Representation

ArrayList<Edge> graph[] = new ArrayList[V];

Each index represents a **vertex**, and the list stores **edges connected to that vertex**.

---

### Edge Class

All graph algorithms use the following `Edge` abstraction:

```java
public static class Edge {
    int src;
    int dest;
    int wt;

    public Edge(int s, int d, int w) {
        this.src = s;
        this.dest = d;
        this.wt = w;
    }
}
```

This represents:

```
source → destination (weight)
```

---

# 3. Shortest Path Algorithms

Shortest path algorithms determine the **minimum cost path from a source vertex to all other vertices**.

---

# 3.1 Bellman-Ford Algorithm

## Problem

Find the **shortest distance from a source vertex to all other vertices**, even when the graph contains **negative edge weights**.

Unlike Dijkstra's algorithm, Bellman-Ford can **handle negative weights**.

---

## Key Idea

The algorithm repeatedly **relaxes all edges**.

Relaxation means:

```
If dist[u] + weight < dist[v]
update dist[v]
```

This process is repeated **V-1 times**, where V is the number of vertices.

---

## Why V-1 Iterations?

The longest possible shortest path in a graph with **V vertices** can contain **V-1 edges**.

---

## Pseudocode

```
initialize dist[source] = 0
initialize dist[others] = infinity

repeat V-1 times
    for each edge (u, v)
        if dist[u] + weight(u,v) < dist[v]
            dist[v] = dist[u] + weight(u,v)

return distance array
```

---

## Java Implementation

(From: BellmanFordAlgorithm.java)

```java
for (int i = 0; i < V - 1; i++) {

    for (int j = 0; j < graph.length; j++) {

        for (int k = 0; k < graph[j].size(); k++) {

            Edge e = graph[j].get(k);

            int u = e.src;
            int v = e.dest;
            int wt = e.wt;

            if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                dist[v] = dist[u] + wt;
            }
        }
    }
}
```

Reference implementation:

---

## Time Complexity

```
O(V × E)
```

Where

```
V = vertices
E = edges
```

---

## Advantages

- Handles **negative edge weights**
- Can detect **negative cycles**

---

# 4. Minimum Spanning Tree (MST)

A **Minimum Spanning Tree** is a subset of edges that:

- Connects all vertices
- Contains no cycles
- Has the **minimum total edge weight**

---

# 4.1 Prim's Algorithm

## Problem

Find the **Minimum Spanning Tree (MST)** of a weighted graph.

---

## Key Idea

Prim's algorithm grows the MST **one vertex at a time**.

Steps:

1. Start from an arbitrary vertex.
2. Select the **minimum weight edge** connecting the MST to a new vertex.
3. Repeat until all vertices are included.

---

## Data Structure Used

```
Priority Queue (Min Heap)
```

This ensures the **minimum weight edge** is always selected.

---

## Pseudocode

```
Initialize visited array
Insert source node into priority queue

while queue not empty
    remove smallest edge
    if node not visited
        add cost to MST
        mark node visited
        add neighbors to queue
```

---

## Java Implementation

```java
PriorityQueue<Pair> pq = new PriorityQueue<>();

pq.add(new Pair(0, 0));

while (!pq.isEmpty()) {

    Pair curr = pq.remove();

    if (!vis[curr.node]) {

        vis[curr.node] = true;

        finalCost += curr.cost;

        for (Edge e : graph[curr.node]) {
            if (!vis[e.dest]) {
                pq.add(new Pair(e.dest, e.wt));
            }
        }
    }
}
```

Reference implementation:

---

## Time Complexity

```
O(E log V)
```

Where

```
V = vertices
E = edges
```

---

# 5. Priority Queue Usage

Prim's algorithm uses Java's built-in **PriorityQueue**.

```java
PriorityQueue<Pair> pq = new PriorityQueue<>();
```

The queue stores nodes sorted by **minimum cost**.

Custom comparator implemented using `Comparable`.

```java
public int compareTo(Pair p2) {
    return this.cost - p2.cost;
}
```

---

# 6. Example Program

A simple Java entry program was used to verify IDE setup and execution.

Example:

```java
System.out.printf("Hello and welcome!");
```

Reference file:

---

# 7. How to Run the Code

### Requirements

```
Java JDK 17+
IntelliJ IDEA / VSCode
```

### Compile

```
javac BellmanFordAlgorithm.java
javac PrimsAlgorithm.java
```

### Run

```
java BellmanFordAlgorithm
java PrimsAlgorithm
```

---

# 8. Learning Outcomes

After completing this module I gained understanding of:

- Graph data structures
- Adjacency List representation
- Edge abstraction in graphs
- Shortest path algorithms
- Bellman-Ford algorithm
- Minimum Spanning Tree
- Prim's algorithm
- Priority Queue usage in graph problems
- Algorithmic complexity analysis

---

# Future Work

Next algorithms to implement:

- Dijkstra's Algorithm
- Kruskal's Algorithm
- Disjoint Set (Union-Find)
- Topological Sort
- Strongly Connected Components
- Network Flow Algorithms

---

# Author

**Satinder Singh Sall**

Data Structures and Algorithms Study Log
Sigma 4.0 DSA Program

Below is an **enhanced professional `README.md` template** you can directly use in your repository.
It includes:

- GitHub badges
- Graph diagrams (image placeholders)
- Algorithm comparison tables
- Complexity charts
- Visual step-by-step examples
- Interview notes
- 3–4 images per algorithm for visualization

You just need to **place images in a `/assets` folder** in your repo and keep the same filenames.

---

# Graph Algorithms in Java

### Shortest Path & Minimum Spanning Tree Algorithms

![Java](https://img.shields.io/badge/Language-Java-red)
![DSA](https://img.shields.io/badge/Topic-Data%20Structures%20%26%20Algorithms-blue)
![Graphs](https://img.shields.io/badge/Algorithms-Graphs-green)
![License](https://img.shields.io/badge/License-MIT-yellow)
![Status](https://img.shields.io/badge/Status-Learning-orange)

This repository documents my learning and implementation of **Graph Algorithms** using **Java** as part of the **Sigma 4.0 DSA program**.

The goal is to understand graph theory **from basic graph representation to advanced optimization algorithms** such as shortest path and minimum spanning tree.

---

# Repository Structure

```

Graph-Algorithms/
│
├── BellmanFordAlgorithm.java
├── PrimsAlgorithm.java
├── Main.java
│
├── assets/
│ ├── bellmanford-graph.png
│ ├── bellmanford-relaxation.png
│ ├── bellmanford-steps.png
│ ├── bellmanford-negative-cycle.png
│ │
│ ├── prims-graph.png
│ ├── prims-step1.png
│ ├── prims-step2.png
│ ├── prims-mst.png
│
└── README.md

```

---

# Graph Fundamentals

A **graph** is a data structure consisting of:

- **Vertices (nodes)**
- **Edges (connections between nodes)**

Graphs are used in:

- Network routing
- Social networks
- Maps and GPS
- Dependency resolution
- Scheduling systems

---

# Graph Representation

This repository uses **Adjacency List Representation**.

### Why adjacency list?

✔ Memory efficient
✔ Faster traversal
✔ Ideal for sparse graphs

### Graph structure

```

ArrayList<Edge> graph[]

```

Each vertex contains a list of edges connected to it.

---

# Edge Class

All graph algorithms use a shared **Edge abstraction**.

```java
public static class Edge {
    int src;
    int dest;
    int wt;

    public Edge(int s, int d, int w) {
        this.src = s;
        this.dest = d;
        this.wt = w;
    }
}
```

This represents:

```

source → destination (weight)

```

---

# Shortest Path Algorithms

## Bellman-Ford Algorithm

### Problem

Find the **shortest path from a source node to all other nodes**, even if the graph contains **negative edge weights**.

---

## Graph Example

![Graph Example](assets/bellmanford-graph.png)

Example weighted directed graph.

---

## Relaxation Concept

Bellman-Ford works by repeatedly **relaxing edges**.

![Relaxation](assets/bellmanford-relaxation.png)

Relaxation formula:

```

if dist[u] + weight(u,v) < dist[v]
update dist[v]

```

---

## Algorithm Steps

![BellmanFord Steps](assets/bellmanford-steps.png)

1. Initialize distances
2. Relax all edges
3. Repeat **V-1 times**
4. Detect negative cycles

---

## Negative Cycle Detection

![Negative Cycle](assets/bellmanford-negative-cycle.png)

If relaxation still occurs after **V-1 iterations**, a **negative cycle exists**.

---

## Pseudocode

```

Initialize dist[source] = 0
Initialize others = infinity

Repeat V-1 times
For each edge (u,v)
If dist[u] + weight < dist[v]
Update dist[v]

```

---

## Java Implementation

```java
for (int i = 0; i < V - 1; i++) {

    for (int j = 0; j < graph.length; j++) {

        for (Edge e : graph[j]) {

            int u = e.src;
            int v = e.dest;
            int wt = e.wt;

            if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                dist[v] = dist[u] + wt;
            }
        }
    }
}
```

---

## Complexity

| Operation | Complexity |
| --------- | ---------- |
| Time      | O(V × E)   |
| Space     | O(V)       |

---

# Minimum Spanning Tree

A **Minimum Spanning Tree (MST)** is a subset of edges that:

✔ Connects all vertices
✔ Contains no cycles
✔ Has minimum total edge weight

---

# Prim's Algorithm

## Problem

Find the **minimum spanning tree** of a weighted graph.

---

## Graph Example

![Prim Graph](assets/prims-graph.png)

---

## Algorithm Intuition

Prim's algorithm grows the MST **one vertex at a time**.

---

## Step 1

Start from an arbitrary vertex.

![Step1](assets/prims-step1.png)

---

## Step 2

Add the **minimum weight edge** connecting a new vertex.

![Step2](assets/prims-step2.png)

---

## Final MST

![Final MST](assets/prims-mst.png)

---

## Pseudocode

```

Initialize visited array
Insert source node into min priority queue

while queue not empty
remove smallest edge

if node not visited
add cost to MST
mark node visited

add neighbors to queue

```

---

## Java Implementation

```java
PriorityQueue<Pair> pq = new PriorityQueue<>();

pq.add(new Pair(0, 0));

while (!pq.isEmpty()) {

    Pair curr = pq.remove();

    if (!vis[curr.node]) {

        vis[curr.node] = true;

        finalCost += curr.cost;

        for (Edge e : graph[curr.node]) {
            if (!vis[e.dest]) {
                pq.add(new Pair(e.dest, e.wt));
            }
        }
    }
}
```

---

# Algorithm Comparison

| Algorithm    | Type                  | Negative Weights | Time Complexity |
| ------------ | --------------------- | ---------------- | --------------- |
| Dijkstra     | Shortest Path         | ❌               | O(E log V)      |
| Bellman-Ford | Shortest Path         | ✔                | O(VE)           |
| Prim's       | Minimum Spanning Tree | ✔                | O(E log V)      |

---

# Complexity Overview

| Algorithm    | Time       | Space |
| ------------ | ---------- | ----- |
| Bellman-Ford | O(VE)      | O(V)  |
| Prim's       | O(E log V) | O(V)  |

---

# Visual Complexity Chart

![Complexity Chart](assets/complexity-chart.png)

---

# Running the Code

### Compile

```

javac BellmanFordAlgorithm.java
javac PrimsAlgorithm.java

```

### Run

```

java BellmanFordAlgorithm
java PrimsAlgorithm

```

---

# Interview Notes

### Bellman-Ford

Key points:

✔ Works with negative weights
✔ Detects negative cycles
✔ Slower than Dijkstra

Common interview question:

**Why V-1 iterations?**

Because the longest simple path has **V-1 edges**.

---

### Prim's Algorithm

Key points:

✔ Greedy algorithm
✔ Used to build Minimum Spanning Tree
✔ Uses Priority Queue

---

# Learning Outcomes

After completing this module I learned:

✔ Graph representation
✔ Shortest path algorithms
✔ Minimum spanning tree algorithms
✔ Priority queues in graph problems
✔ Algorithm complexity analysis

---

# Future Algorithms

Next topics to implement:

- Dijkstra Algorithm
- Kruskal Algorithm
- Disjoint Set (Union Find)
- Topological Sort
- Strongly Connected Components
- Network Flow

---

# Author

**Satinder Singh**

DSA Learning Repository
Sigma 4.0 Program
