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
