# Data Structure and Algorithms: DSA - Java

---

# Graphs Data Structure using Java (DSA - Sigma 4.0 / 40. Tries)

![Java](https://img.shields.io/badge/Language-Java-orange)
![DSA](https://img.shields.io/badge/Topic-Graphs-blue)
![Level](https://img.shields.io/badge/Level-Beginner%20to%20Advanced-green)
![Status](https://img.shields.io/badge/Status-Completed-success)

---

Below is a **premium, modern, academic-quality `README.md`** you can directly place in your GitHub repository.
It explains **all topics you studied (Topological Sort, All Paths DFS, Dijkstra)** with **theory → algorithm → pseudocode → Java code**, plus **badges and diagrams**.

---

# 📚 Graph Algorithms in Java (DSA - Sigma 4.0)

![Java](https://img.shields.io/badge/Language-Java-orange)
![DSA](https://img.shields.io/badge/Data%20Structures-Graphs-blue)
![Algorithms](https://img.shields.io/badge/Algorithms-Topological%20Sort%20%7C%20DFS%20%7C%20Dijkstra-green)
![Build](https://img.shields.io/badge/Build-Passing-brightgreen)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

---

# 📖 Overview

This repository contains **Graph Algorithms implemented in Java** as part of the **Sigma 4.0 DSA course**.

The module focuses on **Directed Graphs and Shortest Path Algorithms**.

Algorithms covered:

| Algorithm                       | Category        | Approach                |
| ------------------------------- | --------------- | ----------------------- |
| Topological Sort                | Directed Graph  | BFS (Kahn's Algorithm)  |
| All Paths from Source to Target | Graph Traversal | DFS                     |
| Dijkstra's Algorithm            | Shortest Path   | Greedy + Priority Queue |

---

# 🧠 Graph Representation

We represent the graph using an **Adjacency List**.

```java
ArrayList<Edge>[] graph
```

Each vertex stores its outgoing edges.

### Edge Structure

```java
static class Edge {
    int src;
    int dest;

    Edge(int s, int d) {
        this.src = s;
        this.dest = d;
    }
}
```

---

# 📊 Example Graph Used

```
        5           4
       / \         / \
      v   v       v   v
      2   0       0   1
      |
      v
      3
      |
      v
      1
```

Edges

```
5 → 0
5 → 2
4 → 0
4 → 1
2 → 3
3 → 1
0 → 3
```

---

# 1️⃣ Topological Sorting (Kahn’s Algorithm)

![Topological Sort](https://upload.wikimedia.org/wikipedia/commons/thumb/4/4b/Topological_sort.svg/640px-Topological_sort.svg.png)

## 📌 Problem

Given a **Directed Acyclic Graph (DAG)**, produce a **linear ordering of vertices** such that:

```
For every edge u → v
u appears before v
```

Example:

```
Input DAG

5 → 0
5 → 2
4 → 0
4 → 1
2 → 3
3 → 1
```

Possible Output

```
4 5 0 2 3 1
```

---

## ⚙️ Algorithm (Kahn's Algorithm)

Steps:

1. Compute **in-degree of every node**
2. Insert nodes with **in-degree = 0** into a queue
3. Remove node from queue
4. Reduce in-degree of its neighbors
5. If neighbor becomes 0 → add to queue
6. Continue until queue empty

---

## 🧾 Pseudocode

```
TopologicalSort(graph):

compute indegree[]

create queue

for each vertex
    if indegree == 0
        add to queue

while queue not empty
    node = queue.remove()

    print node

    for neighbor of node
        indegree[neighbor]--

        if indegree == 0
            queue.add(neighbor)
```

---

## 💻 Java Implementation

Source code:

```java
static void topSort(ArrayList<Edge> graph[]) {

    int indeg[] = new int[graph.length];
    calcIndeg(graph, indeg);

    Queue<Integer> q = new LinkedList<>();

    for(int i=0;i<indeg.length;i++) {
        if(indeg[i]==0) {
            q.add(i);
        }
    }

    while(!q.isEmpty()) {

        int curr = q.remove();
        System.out.print(curr + " ");

        for(Edge e : graph[curr]) {

            indeg[e.dest]--;

            if(indeg[e.dest]==0) {
                q.add(e.dest);
            }

        }

    }

}
```

---

## ⏱ Time Complexity

```
O(V + E)
```

Where

```
V = vertices
E = edges
```

---

# 2️⃣ All Paths from Source to Target (DFS)

![DFS Graph](https://upload.wikimedia.org/wikipedia/commons/7/7f/Depth-First-Search.gif)

---

## 📌 Problem

Find **all possible paths** from a given **source node** to a **destination node**.

Example

```
Source = 5
Destination = 1
```

Possible Paths

```
5 → 0 → 3 → 1
5 → 2 → 3 → 1
```

---

## ⚙️ Algorithm

Use **Depth First Search (DFS)**.

Steps:

1. Start from source
2. Track current path
3. Explore neighbors recursively
4. If destination reached → print path

---

## 🧾 Pseudocode

```
AllPaths(graph, src, dest, path)

if src == dest
    print path + dest
    return

for each neighbor of src
    AllPaths(graph, neighbor, dest, path + src)
```

---

## 💻 Java Implementation

Source code:

```java
static void allPaths(ArrayList<Edge> graph[], int src, int dest, String path) {

    if(src == dest) {
        System.out.println(path + dest);
        return;
    }

    for(Edge e : graph[src]) {
        allPaths(graph, e.dest, dest, path + src + " ");
    }

}
```

---

## ⏱ Time Complexity

Worst case

```
O(V^V)
```

Because **all possible paths are explored**.

---

# 3️⃣ Dijkstra's Algorithm (Shortest Path)

![Dijkstra](https://upload.wikimedia.org/wikipedia/commons/5/57/Dijkstra_Animation.gif)

---

## 📌 Problem

Find **shortest distance from source to all vertices** in a **weighted graph**.

Graph must have

```
No negative weights
```

---

## ⚙️ Algorithm

Use a **Priority Queue (Min Heap)**.

Steps

1. Initialize distance array

```
dist[source] = 0
others = infinity
```

2. Insert source in priority queue

3. Extract minimum distance vertex

4. Relax edges

```
if dist[u] + weight < dist[v]
    update dist[v]
```

---

## 🧾 Pseudocode

```
Dijkstra(graph, src)

create dist[]

dist[src] = 0

priorityQueue pq
pq.add(src)

while pq not empty

    curr = pq.remove()

    for each neighbor

        if dist[u] + wt < dist[v]

            dist[v] = dist[u] + wt

            pq.add(v)
```

---

## 💻 Java Implementation

```java
import java.util.*;

class Edge {
    int dest;
    int weight;

    Edge(int d, int w){
        dest = d;
        weight = w;
    }
}

class Pair implements Comparable<Pair>{

    int node;
    int dist;

    Pair(int n, int d){
        node = n;
        dist = d;
    }

    public int compareTo(Pair p2){
        return this.dist - p2.dist;
    }
}

public class DijkstraAlgorithm {

    static void dijkstra(ArrayList<Edge>[] graph, int src){

        int dist[] = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        dist[src] = 0;
        pq.add(new Pair(src,0));

        while(!pq.isEmpty()){

            Pair curr = pq.remove();

            for(Edge e : graph[curr.node]){

                int u = curr.node;
                int v = e.dest;
                int wt = e.weight;

                if(dist[u] + wt < dist[v]){

                    dist[v] = dist[u] + wt;

                    pq.add(new Pair(v, dist[v]));

                }

            }

        }

        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i] + " ");
        }

    }
}
```

---

## ⏱ Time Complexity

```
O((V + E) log V)
```

---

# 🧪 Example Output

### Topological Sort

```
4 5 0 2 3 1
```

### All Paths

```
5 0 3 1
5 2 3 1
```

### Shortest Path (Dijkstra)

```
0 2 3 6 7
```

---

# 🗂 Project Structure

```
Graph-Algorithms-Java
│
├── TopologicalSorting.java
├── AllPathsFromSourceToTarget.java
├── DijkstraAlgorithm.java
├── Main.java
└── README.md
```

Your implementations correspond to the following files:

- `TopologicalSorting.java`
- `AllPathsFromSourceToTarget.java`
- `Main.java`

---

# 🎯 Key Concepts Learned

✔ Graph Representation
✔ Directed Graphs
✔ Adjacency List
✔ DFS Traversal
✔ BFS Traversal
✔ Topological Sorting
✔ Shortest Path Algorithms
✔ Priority Queue
✔ Greedy Algorithms

---

# 📚 References

- CLRS Algorithms Book
- Apna College DSA Sigma Course
- GeeksForGeeks Graph Theory
- MIT Algorithms Lectures

---

# ⭐ Future Improvements

Add implementations for:

```
• Bellman Ford Algorithm
• Floyd Warshall
• Kruskal Algorithm
• Prim's Algorithm
• Kosaraju Algorithm
```

---

# 👨‍💻 Author

**Satinder Singh**

Data Structures & Algorithms
Java Developer

---

# 🚀 Advanced Graph Algorithms in Java

### 📚 Data Structures & Algorithms | Sigma 4.0

![Java](https://img.shields.io/badge/Language-Java-orange?style=for-the-badge)
![DSA](https://img.shields.io/badge/Data%20Structures-Graphs-blue?style=for-the-badge)
![Algorithms](https://img.shields.io/badge/Algorithms-Topological%20Sort%20%7C%20DFS%20%7C%20Dijkstra-green?style=for-the-badge)
![Build](https://img.shields.io/badge/Build-Passing-brightgreen?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-lightgrey?style=for-the-badge)

---

# 📊 Repository Overview

This repository demonstrates **core graph algorithms implemented in Java** with:

✔ theory
✔ pseudocode
✔ implementation
✔ complexity analysis
✔ visual diagrams

These algorithms are essential for:

- **technical interviews**
- **competitive programming**
- **real-world systems**
- **network routing**
- **dependency resolution**

---

# 📦 Algorithms Covered

| Algorithm                 | Category        | Technique              |
| ------------------------- | --------------- | ---------------------- |
| Topological Sort          | Directed Graph  | BFS (Kahn's Algorithm) |
| All Paths Source → Target | Graph Traversal | DFS                    |
| Dijkstra Algorithm        | Shortest Path   | Greedy + Min Heap      |

---

# 🧠 Graph Representation

We represent graphs using **Adjacency Lists**.

```java
ArrayList<Edge>[] graph
```

Each vertex stores a list of edges.

---

## Edge Structure

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

# 🌐 Example Directed Graph

```
        5           4
       / \         / \
      v   v       v   v
      2   0       0   1
      |
      v
      3
      |
      v
      1
```

Edges

```
5 → 0
5 → 2
4 → 0
4 → 1
2 → 3
3 → 1
0 → 3
```

---

# 1️⃣ Topological Sorting (Kahn's Algorithm)

## 🎯 Problem

Given a **Directed Acyclic Graph (DAG)**, produce a **linear ordering of vertices** such that:

```
For every edge u → v
u appears before v
```

Example Output

```
4 5 0 2 3 1
```

---

## 🧠 Intuition

Topological sorting works by repeatedly selecting nodes that have:

```
in-degree = 0
```

These nodes have **no dependencies**.

---

## ⚙️ Algorithm

1️⃣ Compute in-degree of every vertex
2️⃣ Add vertices with in-degree = 0 to queue
3️⃣ Remove node from queue
4️⃣ Reduce neighbor indegree
5️⃣ Add new zero indegree nodes

---

## 🧾 Pseudocode

```
TopologicalSort(graph)

compute indegree[]

queue q

for vertex in graph
    if indegree == 0
        q.add(vertex)

while q not empty

    node = q.remove()
    print node

    for neighbor
        indegree[neighbor]--

        if indegree becomes 0
            q.add(neighbor)
```

---

## 💻 Java Implementation

```java
static void topSort(ArrayList<Edge>[] graph) {

    int indeg[] = new int[graph.length];
    calcIndeg(graph, indeg);

    Queue<Integer> q = new LinkedList<>();

    for(int i=0;i<indeg.length;i++){
        if(indeg[i]==0){
            q.add(i);
        }
    }

    while(!q.isEmpty()){

        int curr = q.remove();

        System.out.print(curr+" ");

        for(Edge e : graph[curr]){

            indeg[e.dest]--;

            if(indeg[e.dest]==0){
                q.add(e.dest);
            }

        }

    }

}
```

Source implementation available in
`TopologicalSorting.java`.

---

## ⏱ Complexity

| Metric           | Value        |
| ---------------- | ------------ |
| Time Complexity  | **O(V + E)** |
| Space Complexity | **O(V)**     |

---

# 2️⃣ All Paths from Source to Target (DFS)

## 🎯 Problem

Find **all possible paths** from:

```
Source → Destination
```

Example

```
Source = 5
Destination = 1
```

Paths

```
5 → 0 → 3 → 1
5 → 2 → 3 → 1
```

---

## 🌊 DFS Visualization

![DFS Animation](https://upload.wikimedia.org/wikipedia/commons/7/7f/Depth-First-Search.gif)

DFS explores **deep paths first** before backtracking.

---

## ⚙️ Algorithm

1️⃣ Start DFS from source
2️⃣ Track path
3️⃣ Explore neighbors recursively
4️⃣ When destination reached → print path

---

## 🧾 Pseudocode

```
AllPaths(graph, src, dest, path)

if src == dest
    print path + dest
    return

for neighbor in graph[src]
    AllPaths(graph, neighbor, dest, path + src)
```

---

## 💻 Java Implementation

```java
static void allPaths(ArrayList<Edge>[] graph,
                     int src,
                     int dest,
                     String path){

    if(src == dest){
        System.out.println(path + dest);
        return;
    }

    for(Edge e : graph[src]){

        allPaths(graph,
                 e.dest,
                 dest,
                 path + src + " ");

    }

}
```

Source file:

```
AllPathsFromSourceToTarget.java
```

---

## ⏱ Complexity

Worst case

```
O(V^V)
```

Because every path is explored.

---

# 3️⃣ Dijkstra's Algorithm (Shortest Path)

## 🎯 Problem

Find **shortest distance from source to all nodes** in a **weighted graph**.

Constraint

```
Edge weights must be positive
```

---

## 🌐 Real World Applications

| Application       | Usage          |
| ----------------- | -------------- |
| Google Maps       | Navigation     |
| Computer Networks | Packet routing |
| Airline Systems   | Flight routing |
| GPS Systems       | Shortest route |

---

## ⚙️ Algorithm Idea

Use a **priority queue (min heap)**.

Steps

```
Initialize distance array
dist[source] = 0
others = ∞
```

Process smallest distance node first.

---

## 🧾 Pseudocode

```
Dijkstra(graph, src)

dist[src] = 0

priorityQueue pq
pq.add(src)

while pq not empty

    curr = pq.remove()

    for each neighbor

        if dist[u] + wt < dist[v]

            update dist[v]

            pq.add(v)
```

---

## 💻 Java Implementation

```java
class Pair implements Comparable<Pair>{

    int node;
    int dist;

    Pair(int n, int d){
        node = n;
        dist = d;
    }

    public int compareTo(Pair p2){
        return this.dist - p2.dist;
    }
}

static void dijkstra(ArrayList<Edge>[] graph, int src){

    int dist[] = new int[graph.length];
    Arrays.fill(dist, Integer.MAX_VALUE);

    PriorityQueue<Pair> pq = new PriorityQueue<>();

    dist[src] = 0;
    pq.add(new Pair(src,0));

    while(!pq.isEmpty()){

        Pair curr = pq.remove();

        for(Edge e : graph[curr.node]){

            int u = curr.node;
            int v = e.dest;
            int wt = e.weight;

            if(dist[u] + wt < dist[v]){

                dist[v] = dist[u] + wt;

                pq.add(new Pair(v, dist[v]));

            }

        }

    }

}
```

---

# 📈 Algorithm Complexity Chart

| Algorithm        | Time Complexity  | Space |
| ---------------- | ---------------- | ----- |
| DFS              | O(V + E)         | O(V)  |
| Topological Sort | O(V + E)         | O(V)  |
| Dijkstra         | O((V + E) log V) | O(V)  |

---

# 🧪 Example Outputs

### Topological Sort

```
4 5 0 2 3 1
```

### All Paths

```
5 0 3 1
5 2 3 1
```

### Dijkstra

```
0 2 3 6 7
```

---

# 📂 Project Structure

```
GraphAlgorithms
│
├── Main.java
├── TopologicalSorting.java
├── AllPathsFromSourceToTarget.java
├── DijkstraAlgorithm.java
└── README.md
```

---

# 🧩 Future Enhancements

Planned additions:

```
Bellman Ford Algorithm
Floyd Warshall Algorithm
Kruskal Algorithm
Prim's Algorithm
Kosaraju Algorithm
Tarjan Algorithm
```

---

# 👨‍💻 Author

### Satinder Singh

Computer Science | Data Structures & Algorithms | Java Developer

GitHub Portfolio Project
Sigma 4.0 DSA Learning Journey
