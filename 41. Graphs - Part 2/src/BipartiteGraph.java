// Graph: Bipartite Graph.

/*

Graph: Bipartite Graph.

Graph Structure:

      0
     / \
    /   \
   1     2
   |     |
   |     |
   3 --- 4

Edges:
0 -- 1
0 -- 2
1 -- 3
2 -- 4
3 -- 4

*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.dest = d;
            this.src = s;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i ++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }

    // Method to find Bipartite Graph:
    public static boolean isBipartite(ArrayList<Edge>[] graph) {

        int col[] = new int[graph.length];

        // Step 1: Initialize all vertices with no-color.
        for (int i = 0; i < col.length; i++) {
            col[i] = -1; // no-color
        }

        // Queue for BFS Traversal.
        Queue<Integer> q = new LinkedList<>();

        // Step 2: Traverse all vertices (for disconnected graphs).
        for (int i = 0; i < graph.length; i++) {

            // If vertex is not visited (no-color).
            if (col[i] == -1) {

                q.add(i);
                col[i] = 0; // Assign first color (yellow)

                // BFS Traversal.
                while (!q.isEmpty()) {

                    int curr = q.remove(); // current vertex

                    // Visit all neighbours of current vertex.
                    for (int j = 0; j < graph[curr].size(); j++) {

                        Edge e = graph[curr].get(j); // neighbour vertex

                        // ------------------------------------------------
                        // Cases for Neighbour Vertices
                        // ------------------------------------------------

                        // Case 1: Neighbour has No Color.
                        if (col[e.dest] == -1) {

                            // Assign opposite color of current vertex.
                            int nextCol = (col[curr] == 0) ? 1 : 0;

                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        }

                        // Case 2: Neighbour already colored.
                        // If same color as current → Not Bipartite.
                        else if (col[e.dest] == col[curr]) {

                            return false; // Graph is NOT Bipartite
                        }

                        // Case 3: Neighbour already has opposite color.
                        // Valid situation → Continue BFS.
                    }
                }
            }
        }

        // If no conflicts found → Graph is Bipartite.
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Graph: Bipartite Graph.");

        int v = 5;

        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        System.out.println(isBipartite(graph));
    }
}
