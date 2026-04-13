// Graphs: Cycle Detection in an Un-Directed Graph using DFS Algorithm.

import java.util.ArrayList;

public class CycleDetection_UnDirected_Graph {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void  createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i ++) {
            graph[i] = new ArrayList<>();
        }

        // 0 - Vertex:
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2)); // Comment this for 'false' o/p
        graph[0].add(new Edge(0, 3));

        // 1 - Vertex:
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        // 2 - Vertex:
        graph[2].add(new Edge(2, 0)); // Comment this for 'false' o/p
        graph[2].add(new Edge(2, 1));

        // 3 - Vertex:
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        // 4 - Vertex:
        graph[4].add(new Edge(4, 3));
    }

    // Method HELPER util for Cycle Detection in an Un-Directed Graph:
    public static boolean detectCycle_Util(ArrayList<Edge>[] graph, boolean vis[], int curr, int par) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i ++) {
            Edge e = graph[curr].get(i);

            // Cases to detect a Graph cycle:

            // Case - 1:
            if (!vis[e.dest]) {
                if (detectCycle_Util(graph, vis, e.dest, curr)) {
                    return true;
                }

                // Case - 2
            } else if (vis[e.dest] && e.dest != par) {
                return true;
            }

            // Case - 3: Do Nothing i.e. continue
        }

        return false;
    }

    // Method - Cycle Detection in an Un-Directed Graph using DFS Algorithm.
    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i ++) {
            if (!vis[i]) {
                if (detectCycle_Util(graph, vis, i, -1)) {
                    return true; // Cycle exists in one of the parts.
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("Graphs: Cycle Detection in a Graph.");

        /*
            0 ------- 3
           /|         |
          / |         |
         1  |         4
          \ |
           \|
            2
        */

        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        System.out.println(detectCycle(graph));
    }
}
