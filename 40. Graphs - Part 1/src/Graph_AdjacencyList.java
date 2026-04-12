// Graphs: Graph Implementation using Adjacency List.

import java.util.ArrayList;

public class Graph_AdjacencyList {
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

    public static void main(String[] args) {
        System.out.println("Graphs: Graph Implementation using Adjacency List.");

        int vertices = 5;

        ArrayList<Edge>[] graph = new ArrayList[vertices];

        for (int i = 0; i < vertices; i ++) {
            graph[i] = new ArrayList<>();
        }

        // 0 - Vertex:
        graph[0].add(new Edge(0, 1, 5));

        // 1 - Vertex:
        graph[1].add(new  Edge(1, 0, 5));
        graph[1].add(new  Edge(1, 1, 2));
        graph[1].add(new  Edge(1, 3, 3));

        // 2 - Vertex:
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        // 3 - Vertex:
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // 4 - Vertex:
        graph[4].add(new Edge(4, 2, 2));

        // To find out the '2s' Neighbours:
        for (int i = 0; i < graph[2].size(); i ++) {
            Edge e = graph[2].get(i); // s, d, w
            System.out.println(e.destination);
        }
    }
}
