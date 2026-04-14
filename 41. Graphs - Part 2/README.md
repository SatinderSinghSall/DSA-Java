# Data Structure and Algorithms: DSA - Java

---

# Graphs Data Structure using Java (DSA - Sigma 4.0 / 40. Tries)

![Java](https://img.shields.io/badge/Language-Java-orange)
![DSA](https://img.shields.io/badge/Topic-Graphs-blue)
![Level](https://img.shields.io/badge/Level-Beginner%20to%20Advanced-green)
![Status](https://img.shields.io/badge/Status-Completed-success)

---

# Graph Algorithms in Java (Sigma 4.0 – DSA)

This repository contains implementations and explanations of fundamental **Graph Algorithms** studied in the **Sigma 4.0 Data Structures & Algorithms course**.

The focus of this module is understanding how to represent graphs and apply classical algorithms such as:

- Breadth First Search (BFS)
- Depth First Search (DFS)
- Connected Components
- Bipartite Graph Detection
- Cycle Detection (Directed Graph)
- Cycle Detection (Undirected Graph)
- Topological Sorting (Conceptual Introduction)

All implementations are written in **Java** using an **Adjacency List representation**.

---

# Table of Contents

1. Graph Representation
2. Breadth First Search (BFS)
3. Depth First Search (DFS)
4. Connected Components
5. Bipartite Graph Detection
6. Cycle Detection in Undirected Graph
7. Cycle Detection in Directed Graph
8. Topological Sorting
9. Project Structure

---

# 1. Graph Representation

A **Graph** is a data structure consisting of:

- **Vertices (Nodes)**
- **Edges (Connections between vertices)**

### Types of Graphs

| Type             | Description                  |
| ---------------- | ---------------------------- |
| Directed Graph   | Edges have direction         |
| Undirected Graph | Edges are bidirectional      |
| Weighted Graph   | Edges contain weights        |
| Unweighted Graph | Edges do not contain weights |

---

## Adjacency List Representation

In this repository, graphs are represented using:

```
ArrayList<Edge> graph[]
```

Each vertex contains a list of edges connected to it.

Example edge class:

```java
static class Edge {
    int src;
    int dest;

    Edge(int s, int d) {
        src = s;
        dest = d;
    }
}
```

---

# 2. Breadth First Search (BFS)

## Problem

Traverse all vertices of a graph level by level starting from a source node.

Used for:

- Shortest path in unweighted graphs
- Connected components
- Bipartite graph checking

---

## Algorithm

1. Use a **Queue**
2. Mark the starting node as visited
3. Enqueue the starting node
4. Repeat until queue is empty
5. Dequeue node
6. Visit all unvisited neighbors
7. Add neighbors to queue

---

## Pseudocode

```
BFS(graph, start):

create queue
mark start as visited
enqueue start

while queue not empty
    node = dequeue

    for each neighbor of node
        if not visited
            mark visited
            enqueue neighbor
```

---

## Java Implementation

From the file:

```java
public static void BFS_Algorithm(ArrayList<Edge>[] graph) {
    boolean vis[] = new boolean[graph.length];

    for (int i = 0; i < graph.length; i ++) {
        if (!vis[i]) {
            BFS_Util_Algorithm(graph, vis);
        }
    }
}

public static void BFS_Util_Algorithm(ArrayList<Edge>[] graph, boolean vis[]) {
    Queue<Integer> q = new LinkedList<>();
    q.add(0);

    while (!q.isEmpty()) {
        int curr = q.remove();

        if (!vis[curr]) {
            System.out.print(curr + " ");
            vis[curr] = true;

            for (int i = 0; i < graph[curr].size(); i ++) {
                Edge e = graph[curr].get(i);
                q.add(e.destination);
            }
        }
    }
}
```

---

# 3. Depth First Search (DFS)

## Problem

Traverse graph nodes by exploring **as deep as possible** before backtracking.

Used for:

- Cycle detection
- Topological sorting
- Connected components
- Path finding

---

## Algorithm

1. Start from a node
2. Mark node as visited
3. Recursively visit all unvisited neighbors

---

## Pseudocode

```
DFS(node):

mark node visited

for each neighbor
    if neighbor not visited
        DFS(neighbor)
```

---

## Java Implementation

From:

```java
public static void DFS_Util_Algorithm(ArrayList<Edge>[] graph, int curr, boolean vis[]) {

    System.out.print(curr + " ");
    vis[curr] = true;

    for (int i = 0; i < graph[curr].size(); i++) {
        Edge e = graph[curr].get(i);

        if (!vis[e.destination]) {
            DFS_Util_Algorithm(graph, e.destination, vis);
        }
    }
}
```

---

# 4. Connected Components

## Problem

Determine how many **separate groups of connected vertices** exist in a graph.

Example:

```
Component 1: 0 - 1 - 2
Component 2: 3 - 4
```

---

## Algorithm

1. Create a visited array
2. Traverse all vertices
3. If vertex not visited → run DFS/BFS
4. That traversal forms one connected component

---

## Complexity

```
Time Complexity: O(V + E)
```

---

## Graph Structure Example

```
        1 -------- 3
       /           | \
      /            |  \
     0             |   5 -------- 6
      \            |  /
       \           | /
        2 -------- 4
```

Implementation from:

---

# 5. Bipartite Graph Detection

## Problem

Determine if a graph can be divided into **two sets of vertices** such that no edge connects vertices in the same set.

A graph is **bipartite if it can be colored using only two colors**.

---

## Example Graph

```
      0
     / \
    1   2
    |   |
    3---4
```

---

## Algorithm (BFS Coloring)

1. Assign first color to source
2. Traverse neighbors
3. Assign opposite color
4. If a neighbor has the same color → NOT bipartite

---

## Pseudocode

```
isBipartite(graph):

color all vertices = -1

for each vertex
    if not colored
        start BFS
        color vertex 0

        for neighbors
            if not colored
                color opposite
            else if same color
                return false

return true
```

---

## Java Implementation

From:

```java
public static boolean isBipartite(ArrayList<Edge>[] graph) {

    int col[] = new int[graph.length];

    for (int i = 0; i < col.length; i++) {
        col[i] = -1;
    }

    Queue<Integer> q = new LinkedList<>();

    for (int i = 0; i < graph.length; i++) {

        if (col[i] == -1) {

            q.add(i);
            col[i] = 0;

            while (!q.isEmpty()) {

                int curr = q.remove();

                for (int j = 0; j < graph[curr].size(); j++) {

                    Edge e = graph[curr].get(j);

                    if (col[e.dest] == -1) {

                        int nextCol = (col[curr] == 0) ? 1 : 0;

                        col[e.dest] = nextCol;
                        q.add(e.dest);
                    }

                    else if (col[e.dest] == col[curr]) {
                        return false;
                    }
                }
            }
        }
    }

    return true;
}
```

---

# 6. Cycle Detection in Undirected Graph

## Problem

Detect whether a cycle exists in an **undirected graph**.

Example cycle:

```
0 → 1 → 2 → 0
```

---

## Algorithm

Use **DFS with parent tracking**.

If a visited node is encountered that is **not the parent**, a cycle exists.

---

## Pseudocode

```
DFS(node, parent):

mark node visited

for each neighbor
    if not visited
        DFS(neighbor, node)

    else if neighbor != parent
        return true
```

---

## Java Implementation

From:

```java
public static boolean detectCycle_Util(ArrayList<Edge>[] graph,
                                       boolean vis[],
                                       int curr,
                                       int par) {

    vis[curr] = true;

    for (int i = 0; i < graph[curr].size(); i ++) {
        Edge e = graph[curr].get(i);

        if (!vis[e.dest]) {
            if (detectCycle_Util(graph, vis, e.dest, curr)) {
                return true;
            }
        }
        else if (vis[e.dest] && e.dest != par) {
            return true;
        }
    }

    return false;
}
```

---

# 7. Cycle Detection in Directed Graph

## Problem

Detect a cycle in a **directed graph**.

Example:

```
0 → 1 → 2
↑       ↓
└───────┘
```

---

## Algorithm

Use **DFS with recursion stack**.

If a node is encountered that is already in the recursion stack → cycle exists.

---

## Pseudocode

```
DFS(node):

mark visited
add to recursion stack

for each neighbor
    if neighbor in stack
        cycle found

    if not visited
        DFS(neighbor)

remove node from stack
```

---

## Java Implementation

From:

```java
public static boolean detectCycleUtil(ArrayList<Edge>[] graph,
                                      boolean vis[],
                                      boolean stack[],
                                      int curr) {

    vis[curr] = true;
    stack[curr] = true;

    for(Edge e : graph[curr]) {

        if(stack[e.dest]) {
            return true;
        }

        if(!vis[e.dest] &&
           detectCycleUtil(graph, vis, stack, e.dest)) {
            return true;
        }
    }

    stack[curr] = false;

    return false;
}
```

---

# 8. Topological Sorting

Topological sorting is used for **Directed Acyclic Graphs (DAGs)**.

It orders vertices such that:

```
For every edge U → V
U appears before V
```

---

## Applications

- Course prerequisite scheduling
- Build systems
- Task scheduling
- Dependency resolution

---

## Example

```
5 → 2 → 3
↓         ↓
4 → 0 → 1
```

Possible order:

```
5 4 2 3 1 0
```

---

Implementation placeholder from:

```java
public class TopologicalSorting {
    public static void main(String[] args) {
        System.out.println("Graphs: Topological Sorting.");
    }
}
```

---

# 9. Project Structure

```
Graphs/
│
├── BipartiteGraph.java
├── ConnectedComponents.java
├── CycleDetection_Directed_Graph.java
├── CycleDetection_UnDirected_Graph.java
├── TopologicalSorting.java
├── Main.java
│
└── README.md
```

Files referenced:

-
-
-
-
-
- ***

# Conclusion

This module builds a strong foundation in **graph theory and graph algorithms** using Java.

Key concepts covered include:

- Graph representation
- Graph traversal
- Connectivity
- Bipartite detection
- Cycle detection
- Topological ordering

These algorithms are widely used in:

- Operating systems
- Network routing
- Compiler design
- Dependency management
- Artificial intelligence

---

# 📘 Graph Algorithms in Java

---

- Graph diagrams
- Complexity tables
- Clean GitHub formatting
- Algorithm explanations
- Pseudocode
- Java implementations
- Interview notes
- Time & Space complexity tables

This version is structured like a **top-tier GitHub DSA repository used for professional portfolios**.

---

# 📘 Graph Algorithms in Java

### Data Structures & Algorithms — Sigma 4.0

![Java](https://img.shields.io/badge/Language-Java-orange)
![DSA](https://img.shields.io/badge/Topic-Graphs-blue)
![Algorithms](https://img.shields.io/badge/Algorithms-BFS%20%7C%20DFS%20%7C%20Cycle%20Detection-success)
![Level](https://img.shields.io/badge/Level-Beginner%20→%20Advanced-green)

---

# 📚 Overview

This repository provides a **complete academic and professional guide to Graph Algorithms using Java**.

The implementations progress **from fundamental graph theory to advanced traversal and graph analysis algorithms**.

The following topics are covered:

- Graph fundamentals
- Graph representation using **Adjacency Lists**
- Breadth First Search (BFS)
- Depth First Search (DFS)
- Connected Components
- Bipartite Graph Detection
- Cycle Detection (Undirected Graph)
- Cycle Detection (Directed Graph)
- Topological Sorting (Conceptual introduction)

Each concept includes:

✔ Theory
✔ Algorithm explanation
✔ Pseudocode
✔ Java implementation
✔ Complexity analysis

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
V = set of vertices
E = set of edges
```

---

# 🔹 Types of Graphs

| Type             | Description             |
| ---------------- | ----------------------- |
| Directed Graph   | Edges have direction    |
| Undirected Graph | Edges are bidirectional |
| Weighted Graph   | Edges contain weights   |
| Unweighted Graph | Edges have equal cost   |
| Cyclic Graph     | Contains cycles         |
| Acyclic Graph    | No cycles               |

---

# 📊 Graph Example Used in This Project

```
        1 -------- 3
       /           | \
      /            |  \
     0             |   5 -------- 6
      \            |  /
       \           | /
        2 -------- 4
```

Vertices

```
0,1,2,3,4,5,6
```

Edges

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

Two common approaches:

1️⃣ **Adjacency Matrix**
2️⃣ **Adjacency List** (used in this project)

---

# Adjacency List Representation

Each vertex stores a list of its neighbors.

Example:

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
3. Store connected neighbors in the list

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

ArrayList<Edge>[] graph = new ArrayList[vertices];

for(int i = 0; i < vertices; i++){
    graph[i] = new ArrayList<>();
}
```

---

# 🚶 Breadth First Search (BFS)

## Problem

Traverse a graph **level by level** starting from a source vertex.

---

## Concept

BFS explores nodes in this order:

```
current node
→ all neighbors
→ neighbors of neighbors
```

It uses a **Queue (FIFO)** data structure.

---

## Algorithm

1. Start from source node
2. Mark node as visited
3. Add node to queue
4. Visit neighbors
5. Repeat until queue is empty

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

## Java Implementation

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

## BFS Traversal Example

```
0 1 2 3 4 5 6
```

---

## Complexity

| Metric           | Value        |
| ---------------- | ------------ |
| Time Complexity  | **O(V + E)** |
| Space Complexity | **O(V)**     |

---

# 🌳 Depth First Search (DFS)

## Problem

Traverse graph **as deep as possible before backtracking**.

---

## Concept

DFS uses:

```
Recursion
or
Stack
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

## Java Implementation

```java
public static void DFS(ArrayList<Edge>[] graph, int curr, boolean vis[]) {

    System.out.print(curr + " ");
    vis[curr] = true;

    for (int i = 0; i < graph[curr].size(); i++) {

        Edge e = graph[curr].get(i);

        if (!vis[e.destination]) {
            DFS(graph, e.destination, vis);
        }
    }
}
```

---

## DFS Traversal Example

```
0 1 3 4 2 5 6
```

---

## Complexity

| Metric           | Value        |
| ---------------- | ------------ |
| Time Complexity  | **O(V + E)** |
| Space Complexity | **O(V)**     |

---

# 🔗 Connected Components

## Problem

Identify **separate groups of connected vertices** in a graph.

Example:

```
Component 1: 0 - 1 - 2
Component 2: 3 - 4
```

---

## Algorithm

1. Create visited array
2. Traverse all vertices
3. If vertex not visited → run DFS/BFS
4. That traversal forms one connected component

---

## Complexity

| Metric          | Value        |
| --------------- | ------------ |
| Time Complexity | **O(V + E)** |

---

# 🎨 Bipartite Graph Detection

## Problem

Determine if a graph can be divided into **two sets of vertices** such that no edge connects vertices in the same set.

---

## Example

```
      0
     / \
    1   2
    |   |
    3---4
```

---

## Algorithm

Use **BFS coloring**.

1. Assign color to first node
2. Assign opposite color to neighbors
3. If neighbor has same color → NOT bipartite

---

## Complexity

| Metric           | Value        |
| ---------------- | ------------ |
| Time Complexity  | **O(V + E)** |
| Space Complexity | **O(V)**     |

---

# 🔄 Cycle Detection (Undirected Graph)

## Problem

Detect if an **undirected graph contains a cycle**.

---

## Algorithm

Use **DFS with parent tracking**.

If a visited node is encountered that **is not the parent**, a cycle exists.

---

## Complexity

```
Time Complexity: O(V + E)
Space Complexity: O(V)
```

---

# 🔁 Cycle Detection (Directed Graph)

## Problem

Detect cycles in a **directed graph**.

---

## Algorithm

Use **DFS with recursion stack**.

If a node appears in the recursion stack again → cycle exists.

---

## Complexity

| Metric           | Value        |
| ---------------- | ------------ |
| Time Complexity  | **O(V + E)** |
| Space Complexity | **O(V)**     |

---

# 🔝 Topological Sorting

Topological sorting is used for **Directed Acyclic Graphs (DAGs)**.

It produces an ordering such that:

```
For every edge U → V
U appears before V
```

---

## Example

```
5 → 2 → 3
↓         ↓
4 → 0 → 1
```

Possible order

```
5 4 2 3 1 0
```

---

# 🧠 Complexity Summary

| Algorithm                    | Time Complexity | Space Complexity |
| ---------------------------- | --------------- | ---------------- |
| BFS                          | O(V + E)        | O(V)             |
| DFS                          | O(V + E)        | O(V)             |
| Bipartite Check              | O(V + E)        | O(V)             |
| Cycle Detection (Undirected) | O(V + E)        | O(V)             |
| Cycle Detection (Directed)   | O(V + E)        | O(V)             |

---

# 🌍 Real-World Applications

Graphs are widely used in:

- Google Maps navigation
- Social networks
- Network routing
- Recommendation systems
- Web crawling
- Dependency resolution
- Task scheduling

---

# 📁 Project Structure

```
Graphs-DSA/
│
├── BipartiteGraph.java
├── ConnectedComponents.java
├── CycleDetection_Directed_Graph.java
├── CycleDetection_UnDirected_Graph.java
├── TopologicalSorting.java
├── Main.java
│
└── README.md
```

---

# 🎯 Key Learning Outcomes

After completing this module, you can:

- Represent graphs using adjacency lists
- Implement BFS traversal
- Implement DFS traversal
- Detect graph cycles
- Identify bipartite graphs
- Understand connected components
- Apply graph algorithms to real-world problems

---

# 💡 Interview Notes

Common interview questions related to these topics:

- Difference between **BFS and DFS**
- Detect cycle in a graph
- Check if graph is bipartite
- Find connected components
- Perform topological sort
- Detect cycle in directed graph

---

# 👨‍💻 Author Notes

This README is designed for:

- **Academic documentation**
- **DSA interview preparation**
- **Professional GitHub portfolio**

---

# 🚀 Future Improvements

This project will later include:

- Dijkstra’s Algorithm
- Minimum Spanning Tree
- Union-Find
- Advanced graph problems

---
