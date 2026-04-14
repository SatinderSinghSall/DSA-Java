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

    public static void main(String[] args) {
        System.out.println("Graph: Bipartite Graph.");

        int v = 5;

        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
    }
}
