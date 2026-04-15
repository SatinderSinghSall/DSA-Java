# Data Structure and Algorithms: DSA - Java

---

# Graphs Data Structure using Java (DSA - Sigma 4.0 / 43. Graphs - Part 4)

![Java](https://img.shields.io/badge/Language-Java-orange)
![DSA](https://img.shields.io/badge/Topic-Graphs-blue)
![Level](https://img.shields.io/badge/Level-Beginner%20to%20Advanced-green)
![Status](https://img.shields.io/badge/Status-Completed-success)

---

# Graph Algorithms in Java

### Shortest Path & Minimum Spanning Tree Algorithms

![Java](https://img.shields.io/badge/Language-Java-red)
![DSA](https://img.shields.io/badge/Topic-Data%20Structures%20%26%20Algorithms-blue)
![Graphs](https://img.shields.io/badge/Algorithms-Graphs-green)
![License](https://img.shields.io/badge/License-MIT-yellow)
![Status](https://img.shields.io/badge/Status-Learning-orange)

---

## Strongly Connected Components (SCC) — Kosaraju’s Algorithm

![Image](https://images.openai.com/static-rsc-4/nWQN6uRNd4vjd975jcydwHkOJooeeWhSkDE7A5_Py68FhHgILUfUoQtfeRQlzwyD2M9jmcsy2DZonJ9FzsXPkjI47RYeaPLIh8nbfF9H9X8bCeoMR2MlRrXBkIZAUzp9AiZYQKFASHT7T6w8B8bcaZg_U8g3-LbR4W3rD5kloCxzoMP6uPBdr_AhcoxOCCkL?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/_Uk5uNT7Qp7oZuj5y3J9U1S4mdxKHUH_t05VJne6oesQ0vYDtKfy_5RjTdsESbLILdLLkaUQU6qDOEGodUxq01Nk1rn6t3anev3sJC8_pLMnJNYcgDTNL1nQdUksfAoGpjK2Q08s4MQRq9wDTe_phU3SytPvj89x-hi-p0OEbDACv8b3fNBu9a7nwCW2qQlp?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/OChJXXs9nhrX0n7FvZ0jLBnJsMfMMwtSfpt5-0qvNcwl8157q5draUe2BV7oLvmdyCUf3HygkSpTcwqjtprT7yaQ9T_lC9WQEANf82t9jYOcU6ptxtmeG-UUUwStZAZJ_vSuAOd1zAUpcRwHwOQnQyMpItRYtnrbmroSbYXUH3VLO7kBZyurpoWAIAHaJvJ7?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/ZgW3IV_nG6FrEEpAU-M96OWqQIzR6fLCgflApCWQ1tC791muiXDUgY5lDhwIm2bdSSsP6seOGWU_mkEWguvvxMDO73eRK8vEUpmM8R4igcXv9roSQ4GU0cp1iXuR2lFJy2d_SwBlPlFrdd9emSBTu2S7zntg5CjgoHrT9BtFCo0_fWPY7MdZ0SdjQKZS0je5?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/EdsMJst4iW1YLlqQuMMZPs1PNt8vTyWTItNIBJTPX6jxrXgWgUpZabOdPkvZy3t6CEc8G_b74Z15rubD1jIe4hr78gZ56cO3pF_0PsLfxE0J2Xl4HE-tLcYVKnSS0b11SG_GYXuVQNCgaW7LfH5u6a2xS6DR1H3UfNVq2LqnFgHW67U83zKIAY1vENF_-K0u?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/FsZjTROwFZFPfriyUjqfBrVOLlOisX370T9j86kCqvu-omTvaur5iINaWWybyacVuBCQANtrCe5fAlJZ6uvz4z_GFPU4Gj9qc7nZV_FZwEM_B3L7p4cgFQWGHWYI9yzAOvn_CHMmQNCMLyP9tu6vhZ76KV04jV2j3ET99sifuA-r9uz06d9GMi-B_5CxFbRV?purpose=fullsize)

---

# 1. Problem Definition

In a **directed graph**, a **Strongly Connected Component (SCC)** is a group of vertices where:

```
Every vertex is reachable from every other vertex in the same component.
```

Example:

If nodes **1 → 2 → 3 → 1**, then:

```
{1,2,3}
```

forms a **Strongly Connected Component**.

---

# 2. Example Graph

From the diagram in your lecture:

Edges:

```
1 → 0
0 → 2
2 → 1
0 → 3
3 → 4
```

Graph structure:

```
1 → 0 → 3 → 4
↑   ↓
2 ←
```

SCC groups:

```
{0,1,2}
{3}
{4}
```

---

# 3. Key Idea

Kosaraju’s algorithm uses **two DFS traversals**.

Steps:

1️⃣ Perform **DFS and store nodes in stack based on finishing time**

2️⃣ **Reverse the graph**

3️⃣ Perform **DFS in order of stack**

Each DFS traversal gives **one SCC**.

---

# 4. Why It Works

If a node finishes **later in DFS**, it means:

```
It belongs to a deeper dependency chain.
```

By reversing the graph, we isolate SCC components.

---

# 5. Algorithm Steps

### Step 1 — Topological DFS

Run DFS and push nodes into stack.

```
Stack stores nodes by finishing time.
```

---

### Step 2 — Transpose Graph

Reverse all edges.

Example:

```
A → B
```

becomes

```
B → A
```

---

### Step 3 — DFS using stack order

Pop nodes from stack.

If node not visited → run DFS.

That DFS tree = **one SCC**.

---

# 6. Pseudocode

### DFS

```
DFS(node):

mark visited

for neighbors

    if not visited
        DFS(neighbor)

push node to stack
```

---

### Transpose Graph

```
for each edge (u,v)

add edge (v,u)
```

---

### Second DFS

```
while stack not empty

node = pop()

if not visited

    DFS(node)

    print SCC
```

---

# 7. Java Implementation

_(Same comment style used in your previous graph codes)_

```java
// Graphs: Strongly Connected Components (Kosaraju Algorithm)

import java.util.*;

public class KosarajuSCC {

    static class Edge {

        int src;
        int dest;

        Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    // Step 1: DFS for Topological Order
    public static void dfs(ArrayList<Edge>[] graph, int curr,
                           boolean vis[], Stack<Integer> stack) {

        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++) {

            Edge e = graph[curr].get(i);

            if(!vis[e.dest]) {
                dfs(graph, e.dest, vis, stack);
            }
        }

        stack.push(curr);
    }

    // Step 3: DFS on Transposed Graph
    public static void dfsTranspose(ArrayList<Edge>[] graph,
                                    int curr, boolean vis[]) {

        vis[curr] = true;

        System.out.print(curr + " ");

        for(int i=0;i<graph[curr].size();i++) {

            Edge e = graph[curr].get(i);

            if(!vis[e.dest]) {
                dfsTranspose(graph, e.dest, vis);
            }
        }
    }

    public static void kosaraju(ArrayList<Edge>[] graph, int V) {

        Stack<Integer> stack = new Stack<>();

        boolean vis[] = new boolean[V];

        // Step 1
        for(int i=0;i<V;i++) {
            if(!vis[i]) {
                dfs(graph, i, vis, stack);
            }
        }

        // Step 2: Transpose Graph
        ArrayList<Edge>[] transpose = new ArrayList[V];

        for(int i=0;i<V;i++) {
            transpose[i] = new ArrayList<>();
            vis[i] = false;
        }

        for(int i=0;i<V;i++) {

            for(int j=0;j<graph[i].size();j++) {

                Edge e = graph[i].get(j);

                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // Step 3
        while(!stack.isEmpty()) {

            int curr = stack.pop();

            if(!vis[curr]) {

                dfsTranspose(transpose, curr, vis);

                System.out.println();
            }
        }
    }

    public static void main(String args[]) {

        int V = 5;

        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i=0;i<V;i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,1));
        graph[3].add(new Edge(3,4));

        kosaraju(graph, V);
    }
}
```

---

# 8. Output

```
0 1 2
3
4
```

These represent the **Strongly Connected Components**.

---

# 9. Time Complexity

| Step       | Complexity |
| ---------- | ---------- |
| DFS        | O(V + E)   |
| Transpose  | O(V + E)   |
| Second DFS | O(V + E)   |

Total:

```
O(V + E)
```

---

# 10. Real World Applications

Strongly Connected Components are used in:

- **Deadlock detection**
- **Web page link analysis**
- **Compiler optimization**
- **Circuit analysis**
- **Social network communities**

---

# 11. Interview Insights

Important SCC algorithms:

| Algorithm | Use                   |
| --------- | --------------------- |
| Kosaraju  | Simple SCC detection  |
| Tarjan    | Faster single DFS SCC |
| Gabow     | Stack-based SCC       |

Most interviews expect **Kosaraju or Tarjan**.

---

## Bridge in Graph (Tarjan’s Algorithm)

![Image](https://images.openai.com/static-rsc-4/7tezofXGY_p24CHGO4pExFJfSo0s85_Aj9O1SrpzkR-rbyewGZ_GZakHKmDc2iQY5UDQNY6hlzEvGE_TX7rzlctIfGW00FG59rP-LfnTd2TY5ZXIT_6b2-4MEs8zbUD61Ww2EmxcUxml-ucU6BJFZ1QEHsf6aCx2SB_6utVwPX3AzNCfUus0XVgAv8wtfa_M?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/rxKP86GvptOMAwL-Njub5dyYVDCIlBdV57q2DXWb5k6LJ2BJr4Jt5WeECH-ER0asA3Ssz4kIM3fFISAT9CXw8hD6a08I8ipfe5wpGwjvgJ6j8Jke7iu3LwTatuX5v2gxNU4k35VKktSlu5h2RFHYOKa4-5L-ZbnDAwqxbV4tGkCeUGlfIVUZhu8VTOJoE9nU?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/7_6NF8Mo92i51t6gEIsvESvbBRxQa1m9uzV3ErAgndlNgLbEbxaWIkLAypvAnuGPeTpzjjVgbhwqZjEzGKZweF8JvE0iIuFepZoHFuel4irbOvH0wXZBhnDIffiSPyIXWIDlIsFqT4nEsjILdaL55q4AHq2DolQJRu0N9eIKjcTAyRAT0UAOeOd1NjC1AL9i?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/HwS7uUID4RDnBiGq_eZe9nxnKDpS4SQeYm8u0Re1WlQaC3npr7K0pBpEvhXHttVpkUXdezsRqjX1h7nU9vYPU0WDGE6qLkhiHZs7E1Ekv763JAfC14rts5Bh5SK7Wx4ASRenoiAPy66eSRGNXArJMpkkZ8d-rYnjJiF0JwzeokVfFeya2K9WRZmO3nyctADv?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/YDNh_VASE8GYjqFxm-MMoCzCspaNF-r8sNHpPNB5PPh9ApmnWKmIDVerqrjQJS9uMwB0A4aPrr81w5SxEpaZfuASq1DNhT5dWvY8R0o4vq4x34N42v4OooEdHtSHtrlhIepi86_k1fkOOKQj4tJkhfYPTOYZYt6bcjkhpUl7do6Gruojn3wNCdaF46UU4QLo?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/Y5akV9bIJ2FnPfL0ifE7Y0VuX4qeWh7z5AxR-5gAynewccW0eM685ALaUxhyAqao4XnaX-MEnH44xtar_Okk4QfRTxSFst7xFEzAWLLIS-3UpIA5uvrDz-i_ErMeGKR9A_Ds-bM8Ex1lzNSrivgY8xZRlfjlIU7TyHsBhY34VRxp17kd0LvQOM_6lPqMQ4-O?purpose=fullsize)

---

# 1. Problem Definition

A **Bridge (or Critical Edge)** in a graph is:

```text
An edge whose removal increases the number of connected components.
```

In simple terms:

```text
If removing an edge disconnects the graph,
that edge is called a bridge.
```

---

# 2. Example

From your lecture screenshot:

Graph:

```
1 —— 0 —— 3 —— 4
|   /
2
```

Edges:

```
1-0
1-2
2-0
0-3
3-4
```

Bridges:

```
0-3
3-4
```

Why?

Removing **0-3** separates the graph into two parts.

---

# 3. Why Normal DFS Cannot Directly Detect Bridges

If we simply remove each edge and check connectivity:

```
Time Complexity = O(E × (V+E))
```

This is inefficient.

Instead we use **Tarjan's Algorithm**.

---

# 4. Core Idea (Tarjan's Algorithm)

During DFS we track two values:

### Discovery Time

```
dt[node]
```

Time when node was first visited.

---

### Lowest Reachable Time

```
low[node]
```

The earliest discovered node reachable from that subtree.

---

# 5. Bridge Condition

An edge **(u → v)** is a bridge if:

```
dt[u] < low[v]
```

Meaning:

```
v cannot reach u or any ancestor of u
```

So removing edge breaks connectivity.

---

# 6. Visualization

Example DFS tree:

```
0
|
1
|
2
```

If node **2 cannot reach any ancestor**, then:

```
edge (1,2) is a bridge
```

---

# 7. Algorithm Steps

1. Initialize

```
visited[]
dt[]
low[]
time = 0
```

2. Run DFS

3. For each neighbor:

```
if not visited → DFS
update low[]

if dt[u] < low[v]
bridge found
```

---

# 8. Pseudocode

```
DFS(u, parent)

mark visited

dt[u] = low[u] = time++

for neighbor v

    if v == parent
        continue

    if not visited

        DFS(v)

        low[u] = min(low[u], low[v])

        if dt[u] < low[v]
            (u,v) is bridge

    else

        low[u] = min(low[u], dt[v])
```

---

# 9. Java Implementation

_(Same comment style as your previous graph codes)_

```java
// Graphs: Bridge in Graph (Tarjan's Algorithm)

import java.util.*;

public class BridgesTarjan {

    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    static int time = 0;

    public static void dfs(ArrayList<Edge>[] graph,
                           int curr,
                           int parent,
                           int dt[],
                           int low[],
                           boolean vis[]) {

        vis[curr] = true;

        dt[curr] = low[curr] = ++time;

        for(int i=0;i<graph[curr].size();i++) {

            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            if(neigh == parent) {
                continue;
            }

            if(!vis[neigh]) {

                dfs(graph, neigh, curr, dt, low, vis);

                low[curr] = Math.min(low[curr], low[neigh]);

                // Bridge Condition
                if(dt[curr] < low[neigh]) {
                    System.out.println("Bridge : " + curr + " --- " + neigh);
                }
            }
            else {

                low[curr] = Math.min(low[curr], dt[neigh]);
            }
        }
    }

    public static void getBridges(ArrayList<Edge>[] graph, int V) {

        int dt[] = new int[V];
        int low[] = new int[V];
        boolean vis[] = new boolean[V];

        for(int i=0;i<V;i++) {

            if(!vis[i]) {
                dfs(graph, i, -1, dt, low, vis);
            }
        }
    }

    public static void main(String args[]) {

        int V = 5;

        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i=0;i<V;i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[1].add(new Edge(1,0));

        graph[1].add(new Edge(1,2));
        graph[2].add(new Edge(2,1));

        graph[2].add(new Edge(2,0));
        graph[0].add(new Edge(0,2));

        graph[0].add(new Edge(0,3));
        graph[3].add(new Edge(3,0));

        graph[3].add(new Edge(3,4));
        graph[4].add(new Edge(4,3));

        getBridges(graph, V);
    }
}
```

---

# 10. Output

```
Bridge : 0 --- 3
Bridge : 3 --- 4
```

---

# 11. Time Complexity

| Operation     | Complexity   |
| ------------- | ------------ |
| DFS Traversal | **O(V + E)** |

Very efficient for large graphs.

---

# 12. Real World Applications

Bridge detection is used in:

- Network reliability analysis
- Detecting weak links in infrastructure
- Internet routing analysis
- Critical connection detection

Example:

```
Google network outage detection
```

---

# 13. Interview Insight

Bridge problems appear as:

```
Critical Connections in Network (Leetcode 1192)
```

Which is **exactly Tarjan’s Bridge Algorithm**.

---

## Articulation Point (Tarjan’s Algorithm)

![Image](https://images.openai.com/static-rsc-4/nMycBI6NrOPgSHpQBMhVQ6khfwbaNM8JIJhRDvW-WyUlG4spknHK0Ay6QFk5J9sgSHY4oD65koP3qwrnTT4psOMxhMGcBpC6fe35KQEepSLg30cbF1fwF-BwMSlhaA8nQR54wgvmA8grwaVdztwuKKTDtxH_66jgFaW-52bFW-J-BWlcrMe946vl0p9GeXh2?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/OVEQiSrqi-yWK05mugPWF5jSV3aD943ti3qllCysqrZm8tN5CH5WLdxWOhHCffmmVvD-_t3gGpEcnLmCmidw98DqoD-lzjSjALb0AXopG_0t-Bdn_w_WW8gJcNbZ47kxAZTvHgCuK29pc2oYKYRGpP342ebtr7HTMxaWO2MKmez6ciRi0qu5Zowv9b4spnFW?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/59oi2tLJkyW-l_0UN8WPXGGdJZmdBGKWAdkIC8iG2mq080uHPYo2Qb6EfHb0vRbjbKYP6uNacz6IySsgEb9PQvw4LbOq_AkNEcyeC3jBaZy0ZgCyjdydl5UTx7P84xMOzbwR5Lraxl1BppDal3j_j823YOiT9JXO73neJG0obUexaZgQrYbhtWs4mrieh7GQ?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/ekR9pr_4xzNW8n0Y29nyR1Le5rDGas2gHe-zS-LNx6Kbq4zVpSsyxAv75cjgzsbCg-0QgvlqeZefWWmwfJcGvmgC2EEnLvYPD9mv34wWoxXRQXE__Igz9pnfN5mCi-_fETkkorjwjyb-sDM39YOVAHuIrEt4kYnhnfrLrz95XcitGf5G4f5GKEKNNO1SeYAz?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/aFfzKO00vpzCZPbSz1a1Oi_Qi7OATFC-bqDOi2TAEfJ1c0YwwFUHMRyttNXatbEJAxRYg6UkLWLPyZz7_DIByYhfqZele46ZT2DrGjGUmUjeJSNyNKJwRTEBXfaEY_f68g0OoLp1U6V-ls69xVy4vK9G7UMmpwpcvmb_nwmbtUmVHYaYOzmTwPsROLZl6rob?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/IU5GkKhp7nFsF3MWRADYD1sv8ioVpNGw2CdD95wF3CuOKZioZaUUW0hdII-hSTyHGVnvsVo0pKadBqDq6HN2bdtUr0wXOljK0OyW21PyKy7FACe-C5ESOkZ4wWeG2bU36wlB718NGw3FEpt-KdXzQmBvK7DBzOvV5gTC8YsQvxfu8hQLv_UtNZFIobywgrw1?purpose=fullsize)

---

# 1. Problem Definition

An **Articulation Point (Cut Vertex)** is:

```text
A vertex whose removal increases the number of connected components in the graph.
```

In simple words:

```text
If removing a node disconnects the graph,
that node is an articulation point.
```

---

# 2. Example

From your lecture screenshot:

Graph:

```
1 —— 0 —— 3 —— 4
|   /
2
```

Vertices:

```
0,1,2,3,4
```

Articulation Points:

```
0
3
```

Why?

- Removing **0** disconnects `{1,2}` from `{3,4}`
- Removing **3** disconnects `{4}`

---

# 3. Why We Need Tarjan’s Algorithm

Naive approach:

```
Remove every vertex
Check connectivity
```

Complexity:

```
O(V × (V+E))
```

Too slow.

Tarjan’s algorithm solves this in:

```
O(V + E)
```

---

# 4. Core Idea

Similar to **Bridge Detection**.

We track two values during DFS:

### Discovery Time

```
dt[node]
```

When node was first visited.

---

### Lowest Reachable Time

```
low[node]
```

Earliest visited node reachable from that subtree.

---

# 5. Articulation Point Conditions

A node **u** is an articulation point if:

### Case 1 — Root Node

```
Root has more than 1 child in DFS tree
```

---

### Case 2 — Non-root Node

```
dt[u] ≤ low[v]
```

Where **v is a DFS child of u**.

Meaning:

```
v cannot reach any ancestor of u
```

So removing **u** disconnects the graph.

---

# 6. Visualization

Example DFS tree:

```
    0
   / \
  1   3
 /     \
2       4
```

If:

```
low[child] ≥ dt[parent]
```

Then parent is articulation point.

---

# 7. Algorithm Steps

1. Initialize

```
visited[]
dt[]
low[]
time
```

2. Run DFS

3. Track children of each node

4. Apply articulation point conditions

---

# 8. Pseudocode

```
DFS(u, parent)

visited[u] = true

dt[u] = low[u] = time++

children = 0

for neighbor v

    if v == parent
        continue

    if not visited

        DFS(v)

        low[u] = min(low[u], low[v])

        if parent != -1 AND dt[u] ≤ low[v]
            u is articulation point

        children++

    else

        low[u] = min(low[u], dt[v])

if parent == -1 AND children > 1
    u is articulation point
```

---

# 9. Java Implementation

_(Following your same graph code style)_

```java
// Graphs: Articulation Point (Tarjan's Algorithm)

import java.util.*;

public class ArticulationPoint {

    static class Edge {

        int src;
        int dest;

        Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    static int time = 0;

    public static void dfs(ArrayList<Edge>[] graph,
                           int curr,
                           int parent,
                           int dt[],
                           int low[],
                           boolean vis[],
                           boolean ap[]) {

        vis[curr] = true;

        dt[curr] = low[curr] = ++time;

        int children = 0;

        for(int i=0;i<graph[curr].size();i++) {

            Edge e = graph[curr].get(i);

            int neigh = e.dest;

            if(neigh == parent) {
                continue;
            }

            if(!vis[neigh]) {

                dfs(graph, neigh, curr, dt, low, vis, ap);

                low[curr] = Math.min(low[curr], low[neigh]);

                if(parent != -1 && dt[curr] <= low[neigh]) {
                    ap[curr] = true;
                }

                children++;
            }
            else {

                low[curr] = Math.min(low[curr], dt[neigh]);
            }
        }

        if(parent == -1 && children > 1) {
            ap[curr] = true;
        }
    }

    public static void getAP(ArrayList<Edge>[] graph, int V) {

        int dt[] = new int[V];
        int low[] = new int[V];
        boolean vis[] = new boolean[V];
        boolean ap[] = new boolean[V];

        for(int i=0;i<V;i++) {

            if(!vis[i]) {
                dfs(graph, i, -1, dt, low, vis, ap);
            }
        }

        for(int i=0;i<V;i++) {

            if(ap[i]) {
                System.out.println("Articulation Point : " + i);
            }
        }
    }

    public static void main(String args[]) {

        int V = 5;

        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i=0;i<V;i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[1].add(new Edge(1,0));

        graph[1].add(new Edge(1,2));
        graph[2].add(new Edge(2,1));

        graph[2].add(new Edge(2,0));
        graph[0].add(new Edge(0,2));

        graph[0].add(new Edge(0,3));
        graph[3].add(new Edge(3,0));

        graph[3].add(new Edge(3,4));
        graph[4].add(new Edge(4,3));

        getAP(graph, V);
    }
}
```

---

# 10. Output

```
Articulation Point : 0
Articulation Point : 3
```

---

# 11. Time Complexity

| Operation     | Complexity   |
| ------------- | ------------ |
| DFS Traversal | **O(V + E)** |

Efficient for large graphs.

---

# 12. Real World Applications

Articulation points are used in:

- **Network vulnerability detection**
- **Road network analysis**
- **Power grid reliability**
- **Communication networks**
- **Social network analysis**

Example:

```
Find critical routers in an internet network.
```

---

# 13. Interview Insight

Common interview problems:

```
Critical Connections in Network
Network Reliability
Minimum Node Failure Analysis
```

These are variations of:

```
Tarjan's Articulation Point Algorithm
```

---

## Summary of the Final Graph Module

| Algorithm             | Purpose                           |
| --------------------- | --------------------------------- |
| Dijkstra              | Shortest path                     |
| Bellman-Ford          | Shortest path with negative edges |
| Prim                  | Minimum Spanning Tree             |
| Kruskal               | Minimum Spanning Tree             |
| Disjoint Set          | Connectivity                      |
| Kosaraju              | Strongly Connected Components     |
| Tarjan (Bridge)       | Critical edges                    |
| Tarjan (Articulation) | Critical vertices                 |
| Flood Fill            | Grid traversal                    |

---

- Algorithm explanations
- Problem definitions
- Pseudocode
- Java code structure
- Complexity tables
- Visual diagrams placeholders
- Interview cheat sheet

You can paste this directly into **README.md** in your Graph repository.

---

# Graph Algorithms in Java

### Sigma 4.0 Data Structures & Algorithms – Graph Module

![Java](https://img.shields.io/badge/Language-Java-red)
![Algorithms](https://img.shields.io/badge/Topic-Graph%20Algorithms-blue)
![DSA](https://img.shields.io/badge/Course-Sigma%204.0-green)
![Status](https://img.shields.io/badge/Progress-Complete-brightgreen)

---

# Overview

This repository contains my implementations and notes for the **Graph Algorithms module** from the **Sigma 4.0 DSA course**.

Graphs are one of the most important data structures in computer science and are used in:

- Network routing
- Social networks
- Flight route optimization
- Web crawling
- Infrastructure design
- Image processing

This module covers algorithms ranging from **basic traversal to advanced graph theory concepts**.

---

# Topics Covered

## Graph Basics

- Graph Representation
- Adjacency List
- Adjacency Matrix

## Shortest Path Algorithms

- Dijkstra’s Algorithm
- Bellman Ford Algorithm

## Minimum Spanning Tree

- Prim’s Algorithm
- Kruskal’s Algorithm

## Connectivity Algorithms

- Disjoint Set (Union Find)
- Strongly Connected Components (Kosaraju)

## Critical Graph Structures

- Bridge in Graph (Tarjan)
- Articulation Points (Tarjan)

## Graph Traversal Applications

- Flood Fill Algorithm
- Cheapest Flights Within K Stops
- Connecting Cities with Minimum Cost

---

# Graph Representation

### Adjacency List

```java
ArrayList<Edge>[] graph = new ArrayList[V];
```

Advantages:

- Efficient for sparse graphs
- Uses less memory
- Faster traversal

---

# 1. Dijkstra’s Algorithm

## Problem

Find the **shortest distance from a source node to all other nodes** in a graph with **non-negative edge weights**.

---

## Algorithm Idea

Use a **Greedy approach** with a **Priority Queue**.

Steps:

1. Initialize distance array
2. Insert source node into priority queue
3. Repeatedly pick minimum distance node
4. Relax all outgoing edges

---

## Pseudocode

```
dist[source] = 0

priorityQueue.add(source)

while pq not empty

    node = remove minimum distance

    for neighbors

        if dist[u] + weight < dist[v]
            update distance
```

---

## Time Complexity

| Operation            | Complexity |
| -------------------- | ---------- |
| Using Priority Queue | O(E log V) |

---

# 2. Bellman Ford Algorithm

## Problem

Find shortest paths when the graph may contain **negative weight edges**.

---

## Algorithm Idea

Relax all edges **V-1 times**.

Why?

The longest path between two vertices contains at most **V-1 edges**.

---

## Pseudocode

```
initialize distances

repeat V-1 times

    for each edge (u,v)

        if dist[u] + weight < dist[v]

            update dist[v]
```

---

## Complexity

| Operation | Complexity |
| --------- | ---------- |
| Time      | O(V × E)   |
| Space     | O(V)       |

---

# 3. Prim’s Algorithm (Minimum Spanning Tree)

## Problem

Find a subset of edges that:

- Connects all vertices
- Has no cycles
- Has minimum total weight

---

## Algorithm Idea

Greedy algorithm that **grows the tree from a starting node**.

Uses a **Priority Queue**.

---

## Pseudocode

```
pq.add(start)

while pq not empty

    node = remove smallest edge

    if node not visited

        add cost to MST

        add neighbors
```

---

## Complexity

| Operation | Complexity |
| --------- | ---------- |
| Time      | O(E log V) |

---

# 4. Disjoint Set (Union Find)

## Problem

Efficiently manage **dynamic connectivity** between nodes.

Operations:

```
find(x)
union(a,b)
```

---

## Optimizations

### Path Compression

Flattens tree during find operation.

### Union by Rank

Attach smaller tree under larger tree.

---

## Pseudocode

```
find(x)

if parent[x] == x
    return x

parent[x] = find(parent[x])
```

---

# 5. Kruskal’s Algorithm

## Problem

Find **Minimum Spanning Tree** using **edge based greedy approach**.

---

## Algorithm Steps

1. Sort edges by weight
2. Pick smallest edge
3. If it does not form a cycle → add it
4. Use **Union Find** to detect cycles

---

## Pseudocode

```
sort edges

for edge in edges

    if find(u) != find(v)

        union(u,v)

        add edge to MST
```

---

## Complexity

| Operation | Complexity |
| --------- | ---------- |
| Time      | O(E log E) |

---

# 6. Cheapest Flights Within K Stops

## Problem

Find cheapest flight from **src → dst with at most K stops**.

---

## Algorithm Idea

Modified **BFS traversal with cost tracking**.

State includes:

```
node
cost
stops
```

---

## Complexity

| Operation | Complexity |
| --------- | ---------- |
| Time      | O(E)       |

---

# 7. Connecting Cities with Minimum Cost

## Problem

Given cost matrix of cities, find **minimum cost to connect all cities**.

---

## Solution

Apply **Prim's Algorithm**.

---

# 8. Flood Fill Algorithm

## Problem

Replace color of connected region in an image grid.

---

## Approach

DFS or BFS traversal.

---

## Pseudocode

```
DFS(r,c)

if out of bounds return

if color not match return

change color

DFS neighbors
```

---

## Complexity

| Operation | Complexity |
| --------- | ---------- |
| Time      | O(N × M)   |

---

# 9. Strongly Connected Components (Kosaraju)

## Problem

Find groups of vertices where **each vertex can reach every other vertex**.

---

## Algorithm Steps

1. DFS and push nodes to stack
2. Reverse graph
3. DFS in stack order

---

## Complexity

| Operation | Complexity |
| --------- | ---------- |
| Time      | O(V + E)   |

---

# 10. Bridge in Graph (Tarjan)

## Problem

Find edges whose removal disconnects the graph.

Condition:

```
dt[u] < low[v]
```

---

## Complexity

| Operation | Complexity |
| --------- | ---------- |
| Time      | O(V + E)   |

---

# 11. Articulation Points (Tarjan)

## Problem

Find vertices whose removal increases connected components.

Conditions:

Root case:

```
children > 1
```

Non-root case:

```
dt[u] ≤ low[v]
```

---

# Algorithm Complexity Comparison

| Algorithm           | Time Complexity |
| ------------------- | --------------- |
| Dijkstra            | O(E log V)      |
| Bellman Ford        | O(VE)           |
| Prim                | O(E log V)      |
| Kruskal             | O(E log E)      |
| Kosaraju SCC        | O(V+E)          |
| Tarjan Bridge       | O(V+E)          |
| Tarjan Articulation | O(V+E)          |

---

# Real World Applications

Graph algorithms power many real-world systems:

- Google Maps routing
- Internet network routing
- Social network analysis
- Power grid optimization
- Image segmentation
- Flight route planning

---

# Interview Cheat Sheet

| Problem Type          | Algorithm           |
| --------------------- | ------------------- |
| Shortest Path         | Dijkstra            |
| Negative edges        | Bellman Ford        |
| Minimum Spanning Tree | Prim / Kruskal      |
| Connectivity          | Union Find          |
| Strong Components     | Kosaraju            |
| Critical Edge         | Tarjan Bridge       |
| Critical Vertex       | Tarjan Articulation |
| Grid DFS              | Flood Fill          |

---

# Author

**Satinder Singh**

Data Structures & Algorithms
Sigma 4.0 Program
Java Implementation

---

# Future Improvements

Upcoming topics to add:

- Floyd Warshall Algorithm
- Topological Sort
- Strongly Connected Components (Tarjan)
- Network Flow Algorithms
- Graph Coloring

---
