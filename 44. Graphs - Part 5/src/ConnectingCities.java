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
