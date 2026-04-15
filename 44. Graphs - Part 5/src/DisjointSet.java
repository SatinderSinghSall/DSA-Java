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
