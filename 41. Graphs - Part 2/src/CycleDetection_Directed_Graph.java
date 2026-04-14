// Graphs: Cycle Detection in Directed Graph using DFS Algorithm.

import java.util.ArrayList;

public class CycleDetection_Directed_Graph {

    // Edge class represents a directed edge from src -> dest
    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    // Function to create the graph using Adjacency List
    public static void createGraph(ArrayList<Edge>[] graph) {

        // Initialize each vertex with an empty ArrayList
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        /*
            Graph Diagram (Directed Graph)

                 0
                 ↓
                 1
                 ↓
                 2
                 ↘
                  0

            Edges:
            0 → 1
            1 → 2
            2 → 0

            This forms a cycle:
            0 → 1 → 2 → 0
        */

        graph[0].add(new Edge(0,1));
        graph[1].add(new Edge(1,2));
        graph[2].add(new Edge(2,0)); // Back edge → creates cycle
    }


    /*
        DFS Helper Function

        vis[]   → tracks visited nodes
        stack[] → tracks nodes currently in recursion stack

        If we encounter a node that is already in the recursion stack,
        it means a back edge exists → cycle detected.
    */

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph,
                                          boolean vis[],
                                          boolean stack[],
                                          int curr) {

        // Mark current node as visited
        vis[curr] = true;

        // Add node to recursion stack
        stack[curr] = true;

        // Traverse all neighbors of current node
        for(Edge e : graph[curr]) {

            // Case 1: If neighbor already exists in recursion stack
            // → cycle detected
            if(stack[e.dest]) {
                return true;
            }

            // Case 2: If neighbor not visited → DFS on that node
            if(!vis[e.dest] &&
                    detectCycleUtil(graph, vis, stack, e.dest)) {
                return true;
            }
        }

        // Remove node from recursion stack before returning
        stack[curr] = false;

        return false;
    }


    // Main function to detect cycle in the directed graph
    public static boolean detectCycle(ArrayList<Edge>[] graph) {

        boolean vis[] = new boolean[graph.length];   // visited array
        boolean stack[] = new boolean[graph.length]; // recursion stack

        // Run DFS for all components of the graph
        for(int i = 0; i < graph.length; i++) {

            if(!vis[i]) {
                if(detectCycleUtil(graph, vis, stack, i)) {
                    return true; // Cycle found
                }
            }
        }

        return false; // No cycle found
    }


    public static void main(String[] args) {
        System.out.println("Graphs: Cycle Detection in Directed Graph using DFS Algorithm.");

        /*
            Example Directed Graph

                 0
                 ↓
                 1
                 ↓
                 2
                 ↘
                  0

            Cycle:
            0 → 1 → 2 → 0
        */

        int v = 3; // number of vertices

        ArrayList<Edge>[] graph = new ArrayList[v];

        // Create graph
        createGraph(graph);

        // Check for cycle
        System.out.println(detectCycle(graph)); // Output: true
    }
}
