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
