// Graphs: Articulation Point (Tarjan's Algorithm)

import java.util.*;

public class ArticulationPoint {

    static class Edge {

        int src;
        int dest;

        Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    static int time = 0;

    public static void dfs(ArrayList<Edge>[] graph,
                           int curr,
                           int parent,
                           int dt[],
                           int low[],
                           boolean vis[],
                           boolean ap[]) {

        vis[curr] = true;

        dt[curr] = low[curr] = ++time;

        int children = 0;

        for(int i=0;i<graph[curr].size();i++) {

            Edge e = graph[curr].get(i);

            int neigh = e.dest;

            if(neigh == parent) {
                continue;
            }

            if(!vis[neigh]) {

                dfs(graph, neigh, curr, dt, low, vis, ap);

                low[curr] = Math.min(low[curr], low[neigh]);

                if(parent != -1 && dt[curr] <= low[neigh]) {
                    ap[curr] = true;
                }

                children++;
            }
            else {

                low[curr] = Math.min(low[curr], dt[neigh]);
            }
        }

        if(parent == -1 && children > 1) {
            ap[curr] = true;
        }
    }

    public static void getAP(ArrayList<Edge>[] graph, int V) {

        int dt[] = new int[V];
        int low[] = new int[V];
        boolean vis[] = new boolean[V];
        boolean ap[] = new boolean[V];

        for(int i=0;i<V;i++) {

            if(!vis[i]) {
                dfs(graph, i, -1, dt, low, vis, ap);
            }
        }

        for(int i=0;i<V;i++) {

            if(ap[i]) {
                System.out.println("Articulation Point : " + i);
            }
        }
    }

    public static void main(String args[]) {

        int V = 5;

        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i=0;i<V;i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[1].add(new Edge(1,0));

        graph[1].add(new Edge(1,2));
        graph[2].add(new Edge(2,1));

        graph[2].add(new Edge(2,0));
        graph[0].add(new Edge(0,2));

        graph[0].add(new Edge(0,3));
        graph[3].add(new Edge(3,0));

        graph[3].add(new Edge(3,4));
        graph[4].add(new Edge(4,3));

        getAP(graph, V);
    }
}
