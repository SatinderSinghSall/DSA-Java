// Graphs: Topological Sorting using BFS - by Khan's Algorithm.

// Graph Structure:
//
//        5           4
//       / \         / \
//      v   v       v   v
//      2   0       0   1
//      |
//      v
//      3
//      |
//      v
//      1
//
// Edges:
// 5 -> 0
// 5 -> 2
// 4 -> 0// 4 -> 1
// 2 -> 3
// 3 -> 1

// Graphs: Topological Sorting using BFS - Kahn's Algorithm

import java.util.*;

public class TopologicalSorting {

    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    // Calculate in-degree
    static void calcIndeg(ArrayList<Edge> graph[], int indeg[]) {
        for (int i = 0; i < graph.length; i++) {
            for (Edge e : graph[i]) {
                indeg[e.dest]++;
            }
        }
    }

    // Kahn's Algorithm
    static void topSort(ArrayList<Edge> graph[]) {
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg);

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for (Edge e : graph[curr]) {
                indeg[e.dest]--;
                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Graphs: Topological Sorting.");

        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];

        createGraph(graph);

        topSort(graph);
    }
}
