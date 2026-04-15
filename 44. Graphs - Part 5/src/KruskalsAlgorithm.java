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
