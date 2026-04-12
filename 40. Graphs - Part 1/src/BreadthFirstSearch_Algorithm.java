// Graphs: Breadth First Search Algorithm. (BFS)

/*
Graph Structure
        1 -------- 3
       /           | \
      /            |  \
     0             |   5 -------- 6
      \            |  /
       \           | /
        2 -------- 4
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch_Algorithm {
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void  createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i ++) {
            graph[i] = new ArrayList<>();
        }

        // 0 - Vertex:
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // 1 - Vertex:
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // 2 - Vertex:
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // 3 - Vertex:
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // 4 - Vertex:
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        // 5 - Vertex:
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        // 6 - Vertex:
        graph[6].add(new Edge(6, 5, 1));
    }

    // Method for Breath First Search Algorithm:
    public static void BFS_Algorithm(ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0); // source = 0

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!vis[curr]) { // visit -> curr
                System.out.print(curr + " ");
                vis[curr] = true;

                for (int i = 0; i < graph[curr].size(); i ++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.destination);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Graphs: Breadth First Search Algorithm. (BFS)");

        int V = 7;

        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        BFS_Algorithm(graph);
    }
}
