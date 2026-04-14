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

import java.util.ArrayList;
import java.util.Stack;

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
        for (int i = 0; i < graph.length; i ++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    // Method for Topological Sorting Helper Utility in a Graph.
    public static void topologicalSortingUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], Stack<Integer> stack) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i ++) {
            Edge e = graph[curr].get(i);

            if (!vis[e.dest]) {
                topologicalSortingUtil(graph, e.dest, vis, stack);
            }
        }

        stack.push(curr);
    }

    // Method for Topological Sorting in a Graph: Time Complexity - O(V+E)
    public static void topologicalSorting(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < graph.length; i ++) {
            if (!vis[i]) {
                topologicalSortingUtil(graph, i, vis, stack); // Modified DFS Method.
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        System.out.println("Graphs: Topological Sorting.");

        int v = 6;

        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        topologicalSorting(graph);
    }
}
