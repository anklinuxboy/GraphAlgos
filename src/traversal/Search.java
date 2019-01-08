package traversal;

public interface Search<T> {
    void search(T vertex,
                ProcessVertex<T> processVertexEarly,
                ProcessVertex<T> processVertexLate,
                ProcessEdge<T> processEdge);
}
