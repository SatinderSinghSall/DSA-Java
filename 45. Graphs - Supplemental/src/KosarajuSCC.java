// Graphs: Strongly Connected Components (Kosaraju Algorithm)

import java.util.*;

public class KosarajuSCC {

    static class Edge {

        int src;
        int dest;

        Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    // Step 1: DFS for Topological Order
    public static void dfs(ArrayList<Edge>[] graph, int curr,
                           boolean vis[], Stack<Integer> stack) {

        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++) {

            Edge e = graph[curr].get(i);

            if(!vis[e.dest]) {
                dfs(graph, e.dest, vis, stack);
            }
        }

        stack.push(curr);
    }

    // Step 3: DFS on Transposed Graph
    public static void dfsTranspose(ArrayList<Edge>[] graph,
                                    int curr, boolean vis[]) {

        vis[curr] = true;

        System.out.print(curr + " ");

        for(int i=0;i<graph[curr].size();i++) {

            Edge e = graph[curr].get(i);

            if(!vis[e.dest]) {
                dfsTranspose(graph, e.dest, vis);
            }
        }
    }

    public static void kosaraju(ArrayList<Edge>[] graph, int V) {

        Stack<Integer> stack = new Stack<>();

        boolean vis[] = new boolean[V];

        // Step 1
        for(int i=0;i<V;i++) {
            if(!vis[i]) {
                dfs(graph, i, vis, stack);
            }
        }

        // Step 2: Transpose Graph
        ArrayList<Edge>[] transpose = new ArrayList[V];

        for(int i=0;i<V;i++) {
            transpose[i] = new ArrayList<>();
            vis[i] = false;
        }

        for(int i=0;i<V;i++) {

            for(int j=0;j<graph[i].size();j++) {

                Edge e = graph[i].get(j);

                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // Step 3
        while(!stack.isEmpty()) {

            int curr = stack.pop();

            if(!vis[curr]) {

                dfsTranspose(transpose, curr, vis);

                System.out.println();
            }
        }
    }

    public static void main(String args[]) {

        int V = 5;

        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i=0;i<V;i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,1));
        graph[3].add(new Edge(3,4));

        kosaraju(graph, V);
    }
}
