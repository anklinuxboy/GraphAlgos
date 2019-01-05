package representation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

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

    public int getNumberOfEdges() {
        return edges;
    }

    public Set<T> getVertices() {
        return graph.keySet();
    }

    // TODO check for null list
    public List<Edge> getVertexEdges(T vertex) {
        return graph.get(vertex);
    }

    public List<T> getVertexNeighbors(T vertex) {
        List<T> neighbors = new ArrayList<>();

        for (Edge edge : getVertexEdges(vertex)) {
            neighbors.add(edge.vertex);
        }

        return neighbors;
    }

    public boolean isDirected() {
        return directed;
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

    public class Edge {
        T vertex;
        int weight;

        Edge(T vertex) {
            this.vertex = vertex;
            weight = 0;
        }
    }
}

