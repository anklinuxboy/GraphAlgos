package traversal;

public interface ProcessEdge<T> {
    void process(T vertex, T neighbor);
}
