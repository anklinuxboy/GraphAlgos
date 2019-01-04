package representation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GraphAdjListTest {

    @Test
    public void testGraphInt() {
        GraphAdjList<Integer> graph = new GraphAdjList<>(10, false);
        graph.insertEdge(0, 1);
        graph.insertEdge(1, 2);
        graph.insertEdge(2, 5);
        graph.insertEdge(1, 4);
        graph.insertEdge(1, 3);
        graph.insertEdge(2, 3);

        graph.print();
        Assertions.assertEquals(6, graph.getEdges());
    }
}
