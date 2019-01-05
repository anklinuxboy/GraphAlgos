package traversal;

import org.junit.jupiter.api.Test;
import representation.GraphAdjList;

public class BreadthFirstSearchTest {

    @Test
    public void testBFS() {
        GraphAdjList<Integer> graph = new GraphAdjList<>(10, false);
        graph.insertEdge(0, 1);
        graph.insertEdge(1, 2);
        graph.insertEdge(2, 5);
        graph.insertEdge(1, 4);
        graph.insertEdge(1, 3);
        graph.insertEdge(2, 3);

        BreadthFirstSearch<Integer> breadthFirstSearch = new BreadthFirstSearch<>(graph);
        ProcessVertex<Integer> processVertexStart = System.out::println;
        ProcessVertex<Integer> processVertexLate = (Integer vertex) -> System.out.println("Processed Already");
        ProcessEdge<Integer> processEdge = (Integer vertex, Integer neighbor) -> System.out.println("Edge: " + vertex + ", " + neighbor);

        breadthFirstSearch.search(1, processVertexStart, processVertexLate, processEdge);
    }
}
