package graphs;

import java.util.List;

public interface IGraph<V> {
    boolean addVertex(V vertex);
    boolean addEdge(V source, V dest);

    boolean containsVertex(V vertex);
    boolean containsEdge(V source, V dest);

    boolean removeVertex(V vertex);
    boolean removeEdge(V source, V dest);

    int vertexSize();
    int edgeSize();
    boolean isEmpty();
    void clear();

    //traversals
    List<V> dfs(V source);
    List<V> bfs(V source);
}
