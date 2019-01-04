package representation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphAdjList<T> {

    private HashMap<T, List<Edge>> graph;
    private int edges;
    private boolean directed;

    public GraphAdjList(int maxVertices, boolean directed) {
        this.graph = new HashMap<>(maxVertices + 1);
        edges = 0;
        this.directed = directed;
    }

    public void insertEdge(T vertex, T edgeVertex) {
        insertEdge(vertex, edgeVertex, directed);
    }

    private void insertEdge(T vertex, T edgeVertex, boolean directed) {
        Edge edge = new Edge(edgeVertex);

        if (graph.containsKey(vertex)) {
            List<Edge> vertexEdges = graph.get(vertex);
            vertexEdges.add(edge);
        } else {
            List<Edge> vertexEdges = new ArrayList<>();
            vertexEdges.add(edge);
            graph.put(vertex, vertexEdges);
        }

        if (!directed) {
            insertEdge(edgeVertex, vertex, true);
        } else {
            edges++;
        }
    }

    public int getEdges() {
        return edges;
    }

    public void print() {
        for (T key : graph.keySet()) {
            List<Edge> edges = graph.get(key);
            System.out.print(key.toString() + ": ");
            for (Edge edge : edges) {
                System.out.print(" " + edge.vertex.toString());
            }
            System.out.println();
        }
    }

    private class Edge {
        T vertex;
        int weight;

        Edge(T vertex) {
            this.vertex = vertex;
            weight = 0;
        }
    }
}

