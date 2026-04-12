# Data Structure and Algorithms: DSA - Java

---

# Graphs Data Structure using Java (DSA - Sigma 4.0 / 40. Tries)

![Java](https://img.shields.io/badge/Language-Java-orange)
![DSA](https://img.shields.io/badge/Topic-Graphs-blue)
![Level](https://img.shields.io/badge/Level-Beginner%20to%20Advanced-green)
![Status](https://img.shields.io/badge/Status-Completed-success)

# Graphs Data Structure (Java) — From Basics to Advanced

---

# Data Structure and Algorithms: DSA - Java

---

# 📘 Graph Algorithms in Java (DSA - Sigma 4.0 / 40. Graphs Part-1)

![Java](https://img.shields.io/badge/Language-Java-orange)
![DSA](https://img.shields.io/badge/Topic-Graphs-blue)
![Level](https://img.shields.io/badge/Level-Beginner%20to%20Advanced-green)
![Status](https://img.shields.io/badge/Status-Completed-success)

# Graph Algorithms (Java) — From Basics to Traversal Techniques

---

# 📌 Overview

This repository provides a **complete academic and professional guide to Graphs using Java**.

It covers:

- Graph theory fundamentals
- Graph representation (Adjacency List)
- Breadth First Search (BFS)
- Depth First Search (DFS)
- Path detection using DFS

Each concept includes:

- Theory and intuition
- Algorithms
- Pseudocode
- Java implementation

---

# 📖 What is a Graph?

A **Graph** is a non-linear data structure consisting of:

- **Vertices (Nodes)**
- **Edges (Connections between vertices)**

### Mathematical Representation

```
G = (V, E)
```

Where

```
V = Vertices
E = Edges
```

---

## 🔹 Types of Graphs

| Type             | Description             |
| ---------------- | ----------------------- |
| Directed Graph   | Edges have direction    |
| Undirected Graph | Edges have no direction |
| Weighted Graph   | Edges contain weights   |
| Unweighted Graph | Edges have equal cost   |

---

# 🔹 Graph Example Used in This Project

```
        1 -------- 3
       /           | \
      /            |  \
     0             |   5 -------- 6
      \            |  /
       \           | /
        2 -------- 4
```

Vertices:

```
0,1,2,3,4,5,6
```

Edges:

```
0–1
0–2
1–3
2–4
3–4
3–5
4–5
5–6
```

---

# 🧱 Graph Representation

## Problem

Design an efficient way to represent a graph in memory.

Two common methods:

1. Adjacency Matrix
2. **Adjacency List (used here)**

---

# Adjacency List Representation

Each vertex stores a list of its neighbors.

### Example

```
0 → 1,2
1 → 0,3
2 → 0,4
3 → 1,4,5
4 → 2,3,5
5 → 3,4,6
6 → 5
```

---

## Algorithm Idea

1. Create an array of lists
2. Each index represents a vertex
3. Store neighbors inside the list

---

## Pseudocode

```
create graph[V]

for each vertex i
    graph[i] = empty list

add edges
```

---

## Java Implementation

```java
static class Edge {
    int source;
    int destination;
    int weight;

    Edge(int s, int d, int w) {
        source = s;
        destination = d;
        weight = w;
    }
}
```

```java
ArrayList<Edge>[] graph = new ArrayList[vertices];

for (int i = 0; i < vertices; i++) {
    graph[i] = new ArrayList<>();
}
```

Implementation reference:

---

# ➡️ Breadth First Search (BFS)

## Problem

Traverse a graph **level by level** starting from a source vertex.

---

## Concept

BFS explores:

```
current node
→ all neighbors
→ neighbors of neighbors
```

Uses **Queue (FIFO)**.

---

## Algorithm

1. Start from source node
2. Add it to queue
3. Mark visited
4. Process neighbors
5. Continue until queue empty

---

## Pseudocode

```
BFS(graph):

create queue
create visited array

enqueue start vertex

while queue not empty
    node = dequeue

    if node not visited
        mark visited
        print node

        for each neighbour
            enqueue neighbour
```

---

## Java Code

```java
Queue<Integer> q = new LinkedList<>();
boolean vis[] = new boolean[graph.length];

q.add(0);

while (!q.isEmpty()) {

    int curr = q.remove();

    if (!vis[curr]) {

        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            q.add(e.destination);
        }
    }
}
```

Implementation reference:

---

## BFS Output

```
0 1 2 3 4 5 6
```

---

## Time Complexity

| Component | Complexity |
| --------- | ---------- |
| BFS       | O(V + E)   |

Where

```
V = vertices
E = edges
```

---

# ⬇️ Depth First Search (DFS)

## Problem

Traverse graph **as deep as possible before backtracking**.

---

## Concept

DFS uses:

```
Recursion or Stack
```

Traversal order goes **deep first**.

---

## Algorithm

1. Visit node
2. Mark visited
3. Recursively visit neighbors

---

## Pseudocode

```
DFS(node)

mark node visited
print node

for each neighbour
    if not visited
        DFS(neighbour)
```

---

## Java Code

```java
public static void DFS_Algorithm(ArrayList<Edge>[] graph, int curr, boolean vis[]) {

    System.out.print(curr + " ");
    vis[curr] = true;

    for (int i = 0; i < graph[curr].size(); i++) {

        Edge e = graph[curr].get(i);

        if (!vis[e.destination]) {
            DFS_Algorithm(graph, e.destination, vis);
        }
    }
}
```

Implementation reference:

---

## DFS Output

```
0 1 3 4 2 5 6
```

---

## Time Complexity

```
O(V + E)
```

---

# 🔎 Has Path Using DFS

## Problem

Determine whether a path exists between two vertices.

Example:

```
Is there a path from 0 → 5 ?
```

---

## Algorithm

1. If source == destination → return true
2. Mark node visited
3. Recursively explore neighbors
4. If any neighbor leads to destination → return true

---

## Pseudocode

```
hasPath(graph, src, dest)

if src == dest
    return true

mark src visited

for neighbour in graph[src]
    if not visited
        if hasPath(neighbour, dest)
            return true

return false
```

---

## Java Implementation

```java
public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean vis[]) {

    if(src == dest){
        return true;
    }

    vis[src] = true;

    for(int i = 0; i < graph[src].size(); i++){

        Edge e = graph[src].get(i);

        if(!vis[e.destination] && hasPath(graph, e.destination, dest, vis)){
            return true;
        }
    }

    return false;
}
```

Implementation reference:

---

## Example Output

```
true
```

Because path exists:

```
0 → 1 → 3 → 5
```

or

```
0 → 2 → 4 → 5
```

---

# 🧠 Complexity Summary

| Algorithm      | Time Complexity |
| -------------- | --------------- |
| BFS            | O(V + E)        |
| DFS            | O(V + E)        |
| Path Detection | O(V + E)        |

---

# 🎯 Applications of Graphs

Graphs are used in many real-world systems:

- Social networks
- Google Maps navigation
- Network routing
- Recommendation systems
- Web crawling
- Dependency resolution

---

# 📁 Suggested GitHub Project Structure

```
Graphs-DSA/
│
├── Graph_AdjacencyList.java
├── BreadthFirstSearch_Algorithm.java
├── DepthFirstSearch_Algorithm.java
├── HasPath_DFS.java
└── README.md
```

---

# 🚀 Conclusion

Graphs are one of the **most important data structures in computer science**.
Understanding BFS, DFS, and path detection builds the foundation for solving advanced graph problems such as:

- Dijkstra’s Algorithm
- Minimum Spanning Tree
- Topological Sorting
- Cycle Detection

---

# 👨‍💻 Author Notes

This document is structured for:

- Academic documentation
- Interview preparation
- Professional GitHub portfolio

---

**End of Document**

---

# Data Structure and Algorithms: DSA - Java

---

# Graphs Data Structure using Java (DSA - Sigma 4.0 / 40. Tries)

![Java](https://img.shields.io/badge/Language-Java-orange)
![DSA](https://img.shields.io/badge/Topic-Graphs-blue)
![Level](https://img.shields.io/badge/Level-Beginner%20to%20Advanced-green)
![Status](https://img.shields.io/badge/Status-Completed-success)

# Graphs Data Structure (Java) — From Basics to Advanced

---

# Graph Algorithms in Java (From Fundamentals to Traversal Techniques)

## Overview

This project demonstrates the **fundamentals of graph theory and traversal algorithms using Java**.
The implementation progresses from **basic graph representation to traversal and path-finding algorithms**.

The following topics are covered:

1. Graph fundamentals
2. Graph representation using **Adjacency List**
3. **Breadth First Search (BFS)**
4. **Depth First Search (DFS)**
5. **Path detection using DFS**

All implementations follow the same graph structure and coding style for clarity and consistency.

---

# Graph Structure Used

The algorithms operate on the following graph:

```
        1 -------- 3
       /           | \
      /            |  \
     0             |   5 -------- 6
      \            |  /
       \           | /
        2 -------- 4
```

Vertices:

```
0,1,2,3,4,5,6
```

Edges:

```
0–1
0–2
1–3
2–4
3–4
3–5
4–5
5–6
```

---

# 1. Graph Theory Basics

## What is a Graph?

A **graph** is a non-linear data structure consisting of:

- **Vertices (Nodes)**
- **Edges (Connections between nodes)**

Graph representation:

```
G = (V, E)
```

Where:

```
V = set of vertices
E = set of edges
```

---

# 2. Graph Representation

## Problem

We need an efficient way to represent graph relationships.

## Common Approaches

1. Adjacency Matrix
2. Adjacency List

This project uses **Adjacency List**, which is memory efficient.

---

# Adjacency List Representation

### Algorithm Idea

Each vertex maintains a list of its neighbors.

### Pseudocode

```
create array of lists graph[V]

for each vertex i:
    graph[i] = empty list

add edges using graph[source].add(destination)
```

---

### Java Implementation

Example based on your implementation:

```java
ArrayList<Edge>[] graph = new ArrayList[vertices];

for (int i = 0; i < vertices; i++) {
    graph[i] = new ArrayList<>();
}

graph[0].add(new Edge(0,1,5));
graph[1].add(new Edge(1,3,3));
```

---

# Edge Class Design

All algorithms use the same edge structure:

```java
static class Edge {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}
```

This allows storing:

```
source → destination with weight
```

---

# 3. Breadth First Search (BFS)

## Problem

Traverse all vertices in a graph **level by level**.

## Concept

BFS explores neighbors first before going deeper.

Uses **Queue (FIFO)**.

---

## Algorithm

1. Start from source node
2. Mark node as visited
3. Add neighbors to queue
4. Repeat until queue is empty

---

## Pseudocode

```
BFS(graph):

create queue
create visited array

enqueue start node

while queue not empty
    node = dequeue

    if node not visited
        mark visited
        print node

        for each neighbour
            enqueue neighbour
```

---

## Java Implementation

Based on your BFS implementation:

```java
Queue<Integer> q = new LinkedList<>();
boolean vis[] = new boolean[graph.length];

q.add(0);

while (!q.isEmpty()) {

    int curr = q.remove();

    if (!vis[curr]) {
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            q.add(e.destination);
        }
    }
}
```

---

## BFS Output

```
0 1 2 3 4 5 6
```

---

## Time Complexity

```
O(V + E)
```

Where

```
V = vertices
E = edges
```

---

# 4. Depth First Search (DFS)

## Problem

Traverse graph by going **as deep as possible before backtracking**.

## Concept

DFS uses:

```
Recursion or Stack
```

---

## Algorithm

1. Start from source node
2. Mark node visited
3. Recursively visit neighbors

---

## Pseudocode

```
DFS(node):

mark node visited
print node

for each neighbour
    if neighbour not visited
        DFS(neighbour)
```

---

## Java Implementation

Based on your DFS code:

```java
public static void DFS_Algorithm(ArrayList<Edge>[] graph, int curr, boolean vis[]) {

    System.out.print(curr + " ");
    vis[curr] = true;

    for (int i = 0; i < graph[curr].size(); i++) {
        Edge e = graph[curr].get(i);

        if (!vis[e.destination]) {
            DFS_Algorithm(graph, e.destination, vis);
        }
    }
}
```

---

## DFS Output

```
0 1 3 4 2 5 6
```

---

## Time Complexity

```
O(V + E)
```

---

# 5. Path Finding using DFS

## Problem

Determine whether a path exists between two vertices.

Example:

```
Is there a path from 0 to 5?
```

---

## Concept

Use DFS traversal until the destination is found.

---

## Algorithm

1. If source equals destination → return true
2. Mark node visited
3. Recursively check neighbors
4. If any recursive call returns true → path exists

---

## Pseudocode

```
hasPath(graph, src, dest)

if src == dest
    return true

mark src visited

for each neighbour
    if not visited
        if hasPath(neighbour, dest)
            return true

return false
```

---

## Java Implementation

From your implementation:

```java
public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean vis[]) {

    if(src == dest){
        return true;
    }

    vis[src] = true;

    for(int i = 0; i < graph[src].size(); i++){
        Edge e = graph[src].get(i);

        if(!vis[e.destination] && hasPath(graph, e.destination, dest, vis)){
            return true;
        }
    }

    return false;
}
```

---

## Example Output

```
true
```

Because the path exists:

```
0 → 1 → 3 → 5
```

or

```
0 → 2 → 4 → 5
```

---

# Project Structure

```
Graphs/
│
├── Graph_AdjacencyList.java
├── BreadthFirstSearch_Algorithm.java
├── DepthFirstSearch_Algorithm.java
├── HasPath_DFS.java
└── Main.java
```

---

# Concepts Learned

This module covered:

```
Graph fundamentals
Graph representation
Adjacency List implementation
Breadth First Search
Depth First Search
Recursive graph traversal
Path detection in graphs
```

---

# Key Learning Outcomes

After completing this module, you can:

- Represent graphs in Java
- Implement adjacency lists
- Perform BFS traversal
- Perform DFS traversal
- Detect paths between nodes
- Understand recursion in graph algorithms

---
