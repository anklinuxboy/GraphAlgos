package traversal;

import representation.GraphAdjList;

import java.util.*;

public class BreadthFirstSearch<T> implements Search<T> {

    private GraphAdjList<T> graph;
    private HashSet<T> discovered;
    private HashSet<T> processed;

    public BreadthFirstSearch(GraphAdjList<T> graph) {
        this.graph = graph;
        discovered = new HashSet<>();
        processed = new HashSet<>();
    }

    @Override
    public void search(T start,
                       ProcessVertex<T> processVertexStart,
                       ProcessVertex<T> processVertexLate,
                       ProcessEdge<T> processEdge) {
        Queue<T> queue = new LinkedList<>();
        T currentVertex;

        queue.add(start);
        processed.add(start);

        while (!queue.isEmpty()) {
            currentVertex = queue.remove();
            processVertexStart.process(currentVertex);

            List<T> neighbors = graph.getVertexNeighbors(currentVertex);
            for (T neighbor : neighbors) {
                if (!processed.contains(neighbor) || graph.isDirected()) {
                    processEdge.process(currentVertex, neighbor);
                }

                if (!discovered.contains(neighbor)) {
                    queue.add(neighbor);
                    discovered.add(neighbor);
                }
            }

            processVertexLate.process(currentVertex);
        }
    }
}
