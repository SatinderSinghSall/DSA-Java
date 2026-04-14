// Graphs: Print All Paths from Source to Destination using DFS Algorithm.

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
// 4 -> 0
// 4 -> 1
// 2 -> 3
// 3 -> 1
// 0 -> 3

import java.util.*;

public class AllPathsFromSourceToTarget {

    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Create Graph
    static void createGraph(ArrayList<Edge> graph[]) {

        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 3));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    // DFS to print all paths
    static void allPaths(ArrayList<Edge> graph[], int src, int dest, String path) {

        if(src == dest) {
            System.out.println(path + dest);
            return;
        }

        for(int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            allPaths(graph, e.dest, dest, path + src + " ");
        }
    }

    public static void main(String args[]) {

        System.out.println("Graphs: All Paths from Source to Target");

        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        int src = 5;
        int dest = 1;

        allPaths(graph, src, dest, "");
    }
}
