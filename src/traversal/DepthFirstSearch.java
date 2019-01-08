package traversal;

import representation.GraphAdjList;

import java.util.HashMap;
import java.util.HashSet;

public class DepthFirstSearch<T> implements Search<T> {

    private GraphAdjList<T> graph;
    private HashSet<T> discovered;
    private HashSet<T> processed;
    private HashMap<T, T> parent;
    private HashMap<T, Timestamp> timestamps;
    private long time;

    public DepthFirstSearch(GraphAdjList<T> graph) {
        this.graph = graph;
        this.discovered = new HashSet<>();
        this.processed = new HashSet<>();
        this.parent = new HashMap<>();
        this.timestamps = new HashMap<>();
        time = 0;
    }

    @Override
    public void search(T vertex,
                       ProcessVertex<T> processVertexEarly,
                       ProcessVertex<T> processVertexLate,
                       ProcessEdge<T> processEdge) {
        time += 1;
        discovered.add(vertex);
        processVertexEarly.process(vertex);
        Timestamp timestamp = new Timestamp();
        timestamp.start = time;

        for (T neighbor : graph.getVertexNeighbors(vertex)) {
            if (!discovered.contains(neighbor)) {
                processEdge.process(vertex, neighbor);
                parent.put(neighbor, vertex);
                search(neighbor, processVertexEarly, processVertexLate, processEdge);
            }
        }

        processed.add(vertex);
        time += 1;
        timestamp.finish = time;
        timestamps.put(vertex, timestamp);
    }

    public HashMap<T, Timestamp> getTimestamps() {
        return timestamps;
    }

    public class Timestamp {
        private long start;
        private long finish;

        public long getStart() {
            return start;
        }

        public long getFinish() {
            return finish;
        }
    }
}
