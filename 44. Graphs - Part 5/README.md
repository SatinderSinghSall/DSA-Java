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

# Code Explanation:

---

# Problem - 1

# Cheapest Flights Within K Stops

![Image](https://images.openai.com/static-rsc-4/-18lgpac3qKm-uOxGL8XIBhBfJ5TJlbBNY_7_SekzcvMTHCzjE6dvERXR9d42DjBixTLL1gvKMz4PCaPJqLgFlHkFMUi59HcxJyLP1HcoYTBEB3wu6aq-53-CrPh3KI3pOBtkPDGKT5sLraQe3WxMIIUEEg3bn_HO3EqlfGmljUNsU1nTC-9iWA6olQjbWRb?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/_zWHiOsw5Tdzagpxr-TEFrxIGbZdGn5NEThlsH7yKCrGKNryRVoS7H0X2InNY2jkED3OjDMURRTZQ6Z7FGjQnr-vM9PpFvmQfaTArYqZ7Go82QA86SFm-rFwvsmQlZ_QTUix1aWD9lzW3953b3ViB1ehlYjiEkCj1eQ-AILG63IuutQn5rANf2OPNWQz9g3V?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/xBoVGqZTGFQdtNrGYLTthRv4bMMcxtErNLp7VPA_IPm41J74adDazji7lChVrtJaCMHFx4AZxSE4a0PgQctU-svUpjvXemaBZGKVb79QE0DEosa4cR9FbHP5NY0fXWSSEe_IHyTH-ZQWxSFk5qP0g5UBJYPgrvlknvJzAwFgD2UeQL3uLgg-UG_3iPviGke5?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/qJDiOYnwDDnHxc-LRRqPLSr_ITnb-ViqWKhuDHxUt2REaguVSFrBeKxanm7TG0VAd5Cn8w2LCLVkaBPVcwL3_XA-dilWT0uqRiZB11V1wrysXqKMupn-F-R7V4uwuSj9v0l-q3BS5wVcXq7bLeEnddYlu5SAU0WbUUz7-nBXNEj1WIvGwbhMWRRVjydUBVw3?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/mD88beSz80sAq_WJx2e9z0XyXTcjMyvCH0SgIgP4JoVQ41YXBFbMq8Al4FV6TZJxdoGGHFhA8-5994-oAUh0-E7EShMIYCbVpQSiImZwWM7UB4gVE0Y3wAEjhasHzAf2-AtR3XPUFRXgUOVXnXmg3t7d0_g0YGBy-gqxFOuTFDUvN45BqwgoVmKxW12Gr0TN?purpose=fullsize)

## Problem Statement

There are **n cities** connected by flights.

You are given:

```
flights[i] = [from, to, price]
```

This means there is a flight from **city `from` → city `to`** with cost **price**.

You are also given:

```
src  = starting city
dst  = destination city
k    = maximum allowed stops
```

Return the **cheapest cost from src to dst with at most k stops**.

If no such route exists → return **-1**.

---

## Example

Input

```
flights = [[0,1,100], [1,2,100], [0,2,500]]

src = 0
dst = 2
k = 1
```

Graph

```
0 → 1 (100)
1 → 2 (100)
0 → 2 (500)
```

Possible routes:

| Path      | Stops | Cost |
| --------- | ----- | ---- |
| 0 → 2     | 0     | 500  |
| 0 → 1 → 2 | 1     | 200  |

Since **k = 1**, the valid cheapest route is:

```
0 → 1 → 2
```

Cost:

```
100 + 100 = 200
```

Answer:

```
200
```

---

# Key Idea

Normal **Dijkstra** cannot be directly used because:

```
Dijkstra ignores number of stops
```

But this problem restricts:

```
stops ≤ k
```

So we use a **Modified BFS (Level-wise traversal)**.

We track:

```
node
cost
stops
```

---

# Data Structures Used

```
Adjacency List
Queue (BFS)
Distance Array
```

Custom structure:

```
(node, cost, stops)
```

---

# Algorithm Steps

1️⃣ Convert flights into **adjacency list graph**

```
graph[u] → (v, cost)
```

2️⃣ Create a **queue**

```
Queue<(node, cost, stops)>
```

3️⃣ Start from source

```
(src, 0 cost, 0 stops)
```

4️⃣ Traverse neighbors

If:

```
newCost < dist[neighbor]
AND stops ≤ k
```

Update cost.

5️⃣ Continue BFS until queue empty.

---

# Pseudocode

```
create graph

dist[] = infinity
dist[src] = 0

queue.add(src, cost=0, stops=0)

while queue not empty

    remove current node

    if stops > k
        continue

    for each neighbor

        if cost + edgeCost < dist[neighbor]
            update dist
            push neighbor into queue

return dist[dst]
```

---

# Java Implementation

### (Same Comment Style As Your Previous Codes)

```java
// Graphs: Cheapest Flights Within K Stops

import java.util.*;

public class CheapestFlightsKStops {

    // Edge class
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

    // Create graph
    public static void createGraph(int flights[][], ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {

            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }

    // Create Info class (for Queue)
    static class Info {

        int node;
        int cost;
        int stops;

        public Info(int n, int c, int s) {
            this.node = n;
            this.cost = c;
            this.stops = s;
        }
    }

    // Method to find Cheapest Flight
    public static int cheapestFlight(int n, int flights[][], int src, int dst, int k) {

        ArrayList<Edge> graph[] = new ArrayList[n];

        createGraph(flights, graph);

        int dist[] = new int[n];

        for (int i = 0; i < n; i++) {

            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();

        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {

            Info curr = q.remove();

            if (curr.stops > k) {
                break;
            }

            for (int i = 0; i < graph[curr.node].size(); i++) {

                Edge e = graph[curr.node].get(i);

                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if (curr.cost + wt < dist[v] && curr.stops <= k) {

                    dist[v] = curr.cost + wt;

                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }

        if (dist[dst] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[dst];
        }
    }

    public static void main(String args[]) {

        int n = 3;

        int flights[][] = {
                {0,1,100},
                {1,2,100},
                {0,2,500}
        };

        int src = 0;
        int dst = 2;
        int k = 1;

        int ans = cheapestFlight(n, flights, src, dst, k);

        System.out.println("Cheapest Cost = " + ans);
    }
}
```

---

# Output

```
Cheapest Cost = 200
```

---

# Time Complexity

```
O(E)
```

Where

```
E = number of flights
```

---

# Important Interview Points

### Why not pure Dijkstra?

Because Dijkstra:

```
ignores stop constraint
```

But this problem requires:

```
stops ≤ k
```

---

### Type of Problem

This problem is a mix of:

```
Graph + BFS + Shortest Path
```

---

# Real-World Applications

This algorithm is similar to systems used in:

✈️ Flight booking systems
📦 Logistics route optimization
🚚 Delivery route planning
🌐 Network routing

---

# Problem - 2

## Connecting Cities with Minimum Cost (MST Problem)

![Image](https://images.openai.com/static-rsc-4/n-UQVyYOO4q4r8KOwEyePnVD-ytBScP9JU9hTCenyApE2ffkbaa3nRxI4H4STW0Exe4tssFSmM5tcFLF7t_ZXCuwltnj2Wonbp-yw1PQVYed2n7ZHcWmeVyh66_cyE3ZT3MTrjVBy6Q42XYjGeKd9G2slyRgXsVxW5Ofh_ZpoCvaUXvMEcKCARjshbq8GX3w?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/zM-B_NkC2Phk3gO8XlpBExjts3kUnbqSrZ0y438wEj2jqfY1GBdrXZgmXrgNPHZWFhAVzE6gVvefIrJL8MMlyOTZ9AGGCTlyYDbLPcRqIcTDyfzgaZf1wVCMQBuhSjaLxpBtoDnB-IPoprpXJIitPGm1poLNO_uNuxgbNvzX1Eyyq3yKXCdU0uvm8jp11AsA?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/uDuOZKSRiNZ6ms9-X8mtf3xiXq-mTXWXaftUSYY-PQu-PHLwH0ibckvokYqmpSD0_7eNVv4Ut_kl2fxRCO11dGWRoQoV3kX7fZEZl6ehW6OKT2HO-UFVGo_BgX56BCERy9w94DKo1nrXtaq6v0Fk9lZMy9LMxnJ24pPbQxn9z_wNKsqlwL8mOYAOyA2YA1pW?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/luSsTcRnf0TMKF3FiEWXci3SgT9_IJHydlRPKSbUkceo2rUC7rQrgW8G93ZPv4W4vMTFDCUnVS-9JiAJbJgL76LJwF-58Pj6Gmisq0GLFKse6K2sMLJEdQ-A_sERFumOlAjzLQQ927D99Rk1CM7a4zHWMOL5yHBBeTHAR7uSgiICrvfsXdDJ5deutrJl7xOG?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/pe_WXSJdPATvnUxTxTBFyoE1xBxpsEuP9hkTBzxeP_xfZuvmlvlOxsM9vbPNywGfx65AwJ1auIRLYpdJUrTqqOEk4j0RIVpf7qT5E6ZIjwkt50MBnfrFEyqKAK4PEebGPxIZD1Ryvx4O2qX8kMOdAXP0GRm4d5FNxABdoR5F_dtZHZRp4N9moyLAsLu1AbVL?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/tb5GwEyT4A0EziNt_IEkpn4j9s9ZzLQzT7EomySdl284uy2MG5bcgAD9Zck9RC3FYXqyS4vzZC-BKVwcCY43VBGzAWukDd6sM99ZNFs0U_P2E2BpD4fnKevLY_FZogyh3aaXaqSz8yRnS39gBYuafJb_KABLjpVFc_NbVSYISqJppWl6KoU7zNlkvcLwAxFQ?purpose=fullsize)

---

# 1. Problem Statement

You are given **n cities** and the **cost to connect each pair of cities**.

The data is given in a **matrix form**:

```text
cities[i][j] = cost to connect city i to city j
```

Goal:

```text
Find the minimum cost required to connect all cities.
```

Important conditions:

- Every city must be connected
- No unnecessary connections (avoid cycles)
- Total cost should be **minimum**

This is exactly the **Minimum Spanning Tree (MST)** problem.

---

# 2. Example

Input matrix:

```text
cities[][] = {
 {0,1,2,3,4},
 {1,0,5,0,7},
 {2,5,0,6,0},
 {3,0,6,0,0},
 {4,7,0,0,0}
}
```

Interpretation:

| From | To  | Cost |
| ---- | --- | ---- |
| 0    | 1   | 1    |
| 0    | 2   | 2    |
| 0    | 3   | 3    |
| 0    | 4   | 4    |
| 1    | 2   | 5    |
| 1    | 4   | 7    |
| 2    | 3   | 6    |

We must connect **all cities with minimum cost**.

---

# 3. Key Idea

This problem is solved using **Prim's Algorithm**.

Prim's Algorithm builds the **Minimum Spanning Tree (MST)** step by step.

Steps:

1. Start from any city
2. Choose the **minimum cost edge**
3. Add the connected city
4. Repeat until all cities are included

We use:

```text
Priority Queue (Min Heap)
```

to always pick the **smallest edge cost**.

---

# 4. Algorithm Steps

1. Create a **visited array**
2. Use a **Priority Queue**
3. Insert starting city with cost = 0
4. While PQ is not empty:
   - Pick minimum cost edge
   - If city not visited:
     - add cost
     - mark visited
     - add neighbors to PQ

---

# 5. Pseudocode

```text
visited[] = false
pq.add(startNode, cost=0)

totalCost = 0

while pq not empty
    remove smallest cost node

    if not visited
        mark visited
        add cost to totalCost

        for all neighbors
            if not visited
                pq.add(neighbor, cost)

return totalCost
```

---

# 6. Java Implementation

_(Following your same comment format used earlier)_

```java
// Graphs: Connecting Cities with Minimum Cost

import java.util.*;

public class ConnectingCities {

    // Pair class for Priority Queue
    static class Pair implements Comparable<Pair> {

        int node;
        int cost;

        public Pair(int n, int c) {
            this.node = n;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost; // ascending order
        }
    }

    // Method to find Minimum Cost to connect cities
    public static int connectingCities(int cities[][]) {

        int n = cities.length;

        boolean vis[] = new boolean[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(0,0));

        int finalCost = 0;

        while(!pq.isEmpty()) {

            Pair curr = pq.remove();

            if(!vis[curr.node]) {

                vis[curr.node] = true;

                finalCost += curr.cost;

                for(int i=0;i<n;i++) {

                    if(cities[curr.node][i] != 0) {

                        pq.add(new Pair(i, cities[curr.node][i]));
                    }

                }
            }
        }

        return finalCost;
    }

    public static void main(String args[]) {

        int cities[][] = {
                {0,1,2,3,4},
                {1,0,5,0,7},
                {2,5,0,6,0},
                {3,0,6,0,0},
                {4,7,0,0,0}
        };

        int ans = connectingCities(cities);

        System.out.println("Minimum Cost to Connect Cities = " + ans);
    }
}
```

---

# 7. Output

```text
Minimum Cost to Connect Cities = 10
```

---

# 8. Time Complexity

| Operation    | Complexity     |
| ------------ | -------------- |
| Building MST | **O(E log V)** |

Where:

```
V = number of cities
E = number of connections
```

---

# 9. Why This Works

Prim's Algorithm ensures:

✔ all cities connected
✔ no cycles
✔ minimum total cost

Which is exactly the definition of a **Minimum Spanning Tree (MST)**.

---

# 10. Interview Insight

This problem can appear in interviews as:

- Connecting cities with minimum cost
- Minimum cable length to connect networks
- Minimum road construction cost
- Minimum pipeline layout

All of these are **Minimum Spanning Tree problems**.

---

## Disjoint Set (Union–Find Data Structure)

![Image](https://images.openai.com/static-rsc-4/TG6UAE9UMyoGf3_-x03IIcIq8nWTLULIbsH2T-ZQ2lIatHrCkTbJLFl40pGqESRlhCiGi_QD2M1doVVhRsi0nw_Rzkiw-q94sii81ixRmoEjDFCOTGdSUhtdmuUdq6wHFhPg9CleQOGcp_EnfF8QxG_WOC_p2z8hsaXyuO2TIYCRNzg8B8XTj9l4k1p7st5A?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/aihaZvFP4MPooxHkH7k3ot4uy__SPQIfLe4u91flMOr97OTU3n7TcP_1FSN5Rqliz7kjgEiUYbYVCmjjduokox_a_PZXnzeL8VwINQm8CLhpoehceAr8ZGY_R-JZqjAA1VCSMDVMDhyPYalcN4oDTZ5AMGiQYcWZ16cEi2yKRHKHXuY-jHx-0aN4AMuQtFxO?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/LsE9B8xmMBYCPvuR5TGAfyRVjph9qBYz85MIDs_88kbX-ARE8ZNlrf8XYGwt4FEPzG-e4uhsALTzWCCZ9pwXJKJv5H_EqBFkQaebjxlx8QoL0HV2ZTtdqmzWUBNZxK4mgIYw3TuW1BxobyYEeWvZEh_FRKXo3cCDt3Z_VgEu2A7ondBRxmS4MaYcP9BGQZf3?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/IMGyLwUElskGzCTLoqlTyez30abXGfbpQ1WQVvLxTWmh8-YcpvVhm1lobPRuQL0NUm-H_s8msernsLP23I3-MZJjw4t2Pgs8c6vIJfcVUunonMVKo1965uwjU1q-jUPrbiebgDo9hH1ju2lTAYy1S83SU8MHPNgf5XS_RZko_hUZXyPnEitVo5Sa8t5sdpmp?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/qTXT-H9FIdUfM4OJsuaDPXjTuroVT24LQiHc2eXWTyimDvmREfAQvKKC9bLKY8zNZyTytDxJwuLWf5HDj4UayRb39cZs2ZFSkQf1S5p1elFAOpOX5N5XHyE7LrglbNDD6FFQKQWEhqqZ1rWRzX-KF0iGNFywLmqtTxdAqBp_MTWT8GMkYl763yC_jj8YK8nL?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/RnWteI0xxH_7vKTY9xG7P4ZFlU__AG94bpSqfQl6m8PqiIHkJ81I4qiFqmKAGmyWKwTs906g-OiGrsLz3yhSk_iX6Ed5C1D_RwVzAXcMAGixsMEwlGP7-92QH6m3JrM-BExDOSNuIKhfgMrp-8I7_PNYiKmrh4DEEzjUJwSh6rSNnj00wz0odmbmCRcimxdv?purpose=fullsize)

---

# 1. Problem / Motivation

Many graph problems require us to **track which nodes belong to the same connected component**.

Example situations:

- Detecting **cycles in a graph**
- Building **Minimum Spanning Trees (Kruskal's Algorithm)**
- Checking if two nodes are **connected**
- Network connectivity problems

Instead of repeatedly running BFS/DFS, we use a **Disjoint Set Data Structure (Union–Find)**.

---

# 2. What is a Disjoint Set?

A **Disjoint Set** is a data structure that maintains a collection of **non-overlapping sets**.

Each element belongs to **exactly one set**.

Example:

```text
Initial sets:

{1} {2} {3} {4} {5}
```

After some unions:

```text
{1,2,3} {4,5}
```

---

# 3. Core Operations

A Disjoint Set supports two main operations:

### 1️⃣ Find

```text
find(x)
```

Returns the **representative (leader/root)** of the set containing `x`.

Example:

```text
Set = {1,2,3}

find(2) → 1
```

---

### 2️⃣ Union

```text
union(a,b)
```

Merges the two sets containing `a` and `b`.

Example:

```text
union(1,2)

Before:
{1} {2}

After:
{1,2}
```

---

# 4. Internal Representation

Disjoint sets are implemented using **trees**.

Each node stores its **parent**.

Example:

```text
3 → 2 → 1
```

Root is:

```text
1
```

So:

```text
find(3) = 1
```

---

# 5. Optimizations

To make operations very fast we use:

## 1️⃣ Path Compression

When performing `find(x)` we **directly attach nodes to the root**.

Example:

Before:

```
4 → 3 → 2 → 1
```

After `find(4)`:

```
4
3
2
 \
  1
```

Tree becomes **flatter**.

---

## 2️⃣ Union by Rank

Attach the **smaller tree under the bigger tree**.

This keeps tree height small.

---

# 6. Time Complexity

| Operation | Complexity |
| --------- | ---------- |
| Find      | O(α(n))    |
| Union     | O(α(n))    |

Where:

```
α(n) = Inverse Ackermann Function
```

This grows **extremely slowly** → practically **O(1)**.

---

# 7. Algorithm Structure

We maintain two arrays:

```
parent[]
rank[]
```

Example:

```
parent[i] = parent of node i
rank[i] = depth of tree
```

---

# 8. Pseudocode

### Initialization

```
for each node i
    parent[i] = i
    rank[i] = 0
```

### Find

```
find(x)
    if parent[x] == x
        return x
    parent[x] = find(parent[x])
    return parent[x]
```

### Union

```
union(a,b)

rootA = find(a)
rootB = find(b)

if rank[rootA] < rank[rootB]
    parent[rootA] = rootB

else if rank[rootA] > rank[rootB]
    parent[rootB] = rootA

else
    parent[rootB] = rootA
    rank[rootA]++
```

---

# 9. Java Implementation

_(Following the same comment style as your previous graph codes)_

```java
// Graphs: Disjoint Set (Union Find)

import java.util.*;

public class DisjointSet {

    static int n = 8;

    static int parent[] = new int[n];
    static int rank[] = new int[n];

    // Initialize sets
    public static void init() {

        for(int i=0;i<n;i++) {
            parent[i] = i;
        }
    }

    // Find operation with Path Compression
    public static int find(int x) {

        if(parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    // Union operation using Rank
    public static void union(int a, int b) {

        int parA = find(a);
        int parB = find(b);

        if(rank[parA] == rank[parB]) {

            parent[parB] = parA;
            rank[parA]++;

        }
        else if(rank[parA] < rank[parB]) {

            parent[parA] = parB;

        }
        else {

            parent[parB] = parA;
        }
    }

    public static void main(String args[]) {

        init();

        union(1,3);
        union(2,4);
        union(3,6);
        union(1,4);

        System.out.println(find(3));
        System.out.println(find(4));
    }
}
```

---

# 10. Example Execution

Initial sets:

```
{1} {2} {3} {4} {5} {6} {7}
```

Operations:

```
union(1,3)
union(2,4)
union(3,6)
union(1,4)
```

Result:

```
{1,2,3,4,6}
{5}
{7}
```

---

# 11. Where Disjoint Set is Used

| Algorithm            | Usage               |
| -------------------- | ------------------- |
| Kruskal's Algorithm  | Detect cycle in MST |
| Connected Components | Graph clustering    |
| Network Connectivity | Union operations    |
| Image Processing     | Region merging      |

---

# 12. Interview Insights

Common questions:

### Detect cycle using Disjoint Set

```
if find(u) == find(v)
    cycle exists
else
    union(u,v)
```

---

### Used in Kruskal's MST

Next topic after this lecture.

Kruskal uses:

```
Disjoint Set + Edge Sorting
```

to build MST efficiently.

---

# Problem - 3

## Kruskal’s Algorithm (Minimum Spanning Tree – Greedy)

![Image](https://images.openai.com/static-rsc-4/yG24C0mmygLBp9mR7AabCyQ91T-1pXTkxgExYjzbMld61Nwp-3j8iRv3Lj4QkZWhd0iDqx-TFcdZc5s8pEk825TPQWo1MqCUor2MaNmaZcHRpxyTDVsfDIpJ4ouLJ47JF3KP1USuOZjIiU22sfg60tP1Y-Duby3QF7Mw92Z0f3KbCRcjsDbiKWiaa2L9_nVj?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/VgHVCKz61i7BRrLBeoiluCboZRSjew-tENmhPU5hwMHsY0atO3WJeSDOjb_czB1uQSuh9rPHJdEdMZpv-lJRmawSTcSOc0Uj0_XjAn9nzJKDOymPNsjuLPzp8dkcgq4A4QSsXGSLxra8NnkwVwu6_ZZOvB6X9zCoc4VuF5TiMnqXUzTx0FuLywvlODuguins?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/aeSfsjv85eaeTJ2G_D1id-hFFNeghpjlt2zy0TPz9NCBT5bVVxiMYULzRHT3Typv3CEaVQzi9EaTorWPr5I6b-H_oehU9YMdgm1NXPSdvdCRUuGKbuo6_IBqii5IF2zxbTHQ5AxouhRh89FGaPSQ-E1Tzb8jlahQ5uXkDtRBL4pQvBo3F90xvHxB7G5yonzZ?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/cVq_bns-1X5nEIyvC2Tf8xoIKfvU3RgrQ5djSqHjmwHXlMl0z3RHg9SmMz7BEBwUvFa5FLM4HaIPy1xvwE_wQPseCae9kQC9mywS-SGRICiQUJbgHb1WCJ4dclgi9xGBEutQbnAMizESKshvljW2gBWrWWW3FBDDxB6oXNkS7uCGA9v-gyrBzb_faBQtXsIU?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/2e1ys02Als_-TDMQn0jSr0mrJ1-1UPt3bgt1ZOtMSfoi4cDhMwVfqujec6Ahh5GfOV9Rp6JXQmz70l2NNF9R9AHHmE4tOvU50UYf6KAnLbZGVTJnDrlLKLDpFg4Q0lRQTSZw8B16DUsSutILZ5Hfh9wRTpQhozCLDepMc4dTf5kuDsDuORGEpm-wS_T1xhKm?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/Aa3IJsfKBztkQigFFWR9EAF9zG4FMt3JHz0bRRbOemN8tVVqlA5ZFatYAS4_TptNZsCbQkTtTqpkl1kbH1Tz7DYvvnTdn_8OeeeUkIYcsbmxVQ6043icnihRTAjoLyTd3EtobAtmTmRomhSfEUHxk-J_6ceGMUm51vWMyWuQxllko010qA9mAWY83sPOiZLH?purpose=fullsize)

---

# 1. Problem Statement

Given a **connected weighted graph**, find a **Minimum Spanning Tree (MST)**.

A **Minimum Spanning Tree**:

- Connects **all vertices**
- Contains **no cycles**
- Has the **minimum total edge weight**

Kruskal’s algorithm solves this using a **Greedy approach**.

---

# 2. Example Graph

Graph:

```
      0
    / | \
 10  30  15
  /      \
 1        2
  \      /
   40  50
     \ /
      3
```

Edges:

| Edge  | Weight |
| ----- | ------ |
| (0,1) | 10     |
| (0,2) | 15     |
| (0,3) | 30     |
| (1,3) | 40     |
| (2,3) | 50     |

---

# 3. Key Idea

Kruskal’s algorithm builds the MST by:

1️⃣ Sorting edges by **weight**
2️⃣ Adding the **smallest edge first**
3️⃣ Avoiding **cycles** using **Disjoint Set (Union-Find)**

---

# 4. Step-by-Step Process

### Step 1 — Sort Edges

```
(0,1) → 10
(0,2) → 15
(0,3) → 30
(1,3) → 40
(2,3) → 50
```

---

### Step 2 — Pick smallest edges

Add:

```
(0,1) → cost 10
```

---

### Step 3 — Next edge

Add:

```
(0,2) → cost 15
```

---

### Step 4 — Next edge

Add:

```
(0,3) → cost 30
```

Now all vertices are connected.

---

### Final MST

Edges:

```
(0,1)
(0,2)
(0,3)
```

Total cost:

```
10 + 15 + 30 = 55
```

---

# 5. Why Disjoint Set is Needed

When selecting edges we must avoid **cycles**.

Example:

```
if find(u) == find(v)
    skip edge
else
    union(u,v)
```

So we use:

```
Disjoint Set (Union-Find)
```

---

# 6. Algorithm Steps

1️⃣ Create list of edges
2️⃣ Sort edges by weight
3️⃣ Initialize **Disjoint Set**
4️⃣ Traverse edges:

```
if edge doesn't form cycle
    add to MST
```

Stop when:

```
MST edges = V - 1
```

---

# 7. Pseudocode

```
sort edges by weight

initialize disjoint set

mstCost = 0

for each edge (u,v)

    if find(u) != find(v)

        union(u,v)
        add weight to mstCost
```

---

# 8. Java Implementation

_(Same comment style as your previous codes)_

```java
// Graphs: Kruskal's Algorithm (Minimum Spanning Tree)

import java.util.*;

public class KruskalsAlgorithm {

    static class Edge implements Comparable<Edge> {

        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt; // ascending order
        }
    }

    static int n = 4;
    static int parent[] = new int[n];
    static int rank[] = new int[n];

    // Initialize Disjoint Set
    public static void init() {

        for(int i=0;i<n;i++) {
            parent[i] = i;
        }
    }

    // Find operation
    public static int find(int x) {

        if(parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    // Union operation
    public static void union(int a, int b) {

        int parA = find(a);
        int parB = find(b);

        if(rank[parA] == rank[parB]) {
            parent[parB] = parA;
            rank[parA]++;
        }
        else if(rank[parA] < rank[parB]) {
            parent[parA] = parB;
        }
        else {
            parent[parB] = parA;
        }
    }

    // Kruskal's Algorithm
    public static int kruskalsMST(ArrayList<Edge> edges, int V) {

        init();

        Collections.sort(edges);

        int mstCost = 0;

        for(int i=0;i<edges.size();i++) {

            Edge e = edges.get(i);

            if(find(e.src) != find(e.dest)) {

                union(e.src, e.dest);

                mstCost += e.wt;
            }
        }

        return mstCost;
    }

    public static void main(String args[]) {

        int V = 4;

        ArrayList<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0,1,10));
        edges.add(new Edge(0,2,15));
        edges.add(new Edge(0,3,30));
        edges.add(new Edge(1,3,40));
        edges.add(new Edge(2,3,50));

        int ans = kruskalsMST(edges, V);

        System.out.println("MST Cost = " + ans);
    }
}
```

---

# 9. Output

```
MST Cost = 55
```

---

# 10. Time Complexity

| Step                  | Complexity |
| --------------------- | ---------- |
| Sorting edges         | O(E log E) |
| Union-Find operations | O(E α(V))  |

Overall:

```
O(E log E)
```

---

# 11. Kruskal vs Prim

| Feature        | Kruskal       | Prim           |
| -------------- | ------------- | -------------- |
| Approach       | Edge based    | Vertex based   |
| Data Structure | Disjoint Set  | Priority Queue |
| Best for       | Sparse graphs | Dense graphs   |

---

# 12. Real World Applications

Kruskal is used in:

- Network design
- Road planning
- Electrical grid design
- Clustering algorithms
- Image segmentation

---
