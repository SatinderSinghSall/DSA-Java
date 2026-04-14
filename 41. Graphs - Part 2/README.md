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
