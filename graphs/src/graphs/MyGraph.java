package graphs;

import org.w3c.dom.Node;

import java.util.*;

//directed, unweighted graph (based on adjacency lists)
public class MyGraph<V> implements IGraph<V> {
    private Map<V, Node> adjLists = new HashMap<>();
    private int edgeSize;

    @Override
    public boolean addVertex(V vertex) {
        if (adjLists.containsKey(vertex)) {
            return false; //a duplicate vertex (not allowed)
        }
        adjLists.put(vertex, null);
        return true;
    }

    @Override
    public boolean addEdge(V source, V dest) {
        if (!adjLists.containsKey(source) ||
            !adjLists.containsKey(dest)) {
            return false; //vertices not in the map!
        }
        if (containsEdge(source, dest)) {
            return false; //edge already exists!
        }

        //look up the source in the map, place dest in the adjacency list
        Node current = adjLists.get(source);
        if (current == null) {
            //first adjacent vertex
            adjLists.put(source, new Node(dest));
        } else {
            //place a new node in the adjacency list
            Node destNode = new Node(dest);
            destNode.next = current;
            adjLists.put(source, destNode);
        }

        edgeSize++;
        return true;
    }

    @Override
    public boolean containsVertex(V vertex) {
        return adjLists.containsKey(vertex); //O(1)
    }

    @Override
    public boolean containsEdge(V source, V dest) {
        //preconditions
        if (!containsVertex(source) || !containsVertex(dest)) {
            return false;
        }

        Node list = adjLists.get(source);
        while (list != null) {
            if (list.data.equals(dest)) {
                return true; //found other end of the edge
            }
            list = list.next;
        }

        return false;
    }

    @Override
    public boolean removeVertex(V vertex) {
        return false;
    }

    @Override
    public boolean removeEdge(V source, V dest) {
        return false;
    }

    @Override
    public int vertexSize() {
        return adjLists.size();
    }

    @Override
    public int edgeSize() {
        return edgeSize;
    }

    @Override
    public boolean isEmpty() {
        return adjLists.isEmpty();
    }

    @Override
    public void clear() {
        adjLists = new HashMap<>();
        edgeSize = 0;
    }

    @Override
    public List<V> dfs(V source) {
        List<V> traversal = new ArrayList<>();
        Set<V> seen = new HashSet<>();
        dfs(source, traversal, seen);
        return traversal;
    }

    //recursively search the graph
    private void dfs(V current, List<V> traversal, Set<V> seen) {
        if (seen.contains(current)) {
            return; //exit!
        }

        //"visit" the vertex
        traversal.add(current);
        seen.add(current);

        //look through neighbors
        Node adjacents = adjLists.get(current);
        while (adjacents != null) {
            V otherVertex = adjacents.data;
            dfs(otherVertex, traversal, seen);
            adjacents = adjacents.next;
        }
    }

    @Override
    public List<V> bfs(V source) {
        return null;
    }

    @Override
    public String toString() {
        String result = "";

        Set<V> keys = adjLists.keySet();
        for (V vertex : keys) {
            result += vertex + " -> ";
            result += adjLists.get(vertex) + "\n";
        }

        return result;
    }

    private class Node {
        private V data;
        private Node next;

        public Node(V data) {
            this.data = data;
        }

        public String toString() {
            String result = data.toString();

            if (next == null) {
                return result + " -> null";
            } else {
                return result + " -> " + next.toString();
            }
        }
    }
}
