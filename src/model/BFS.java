package model;
import java.util.*;

public class BFS {

    // source: https://www.baeldung.com/java-graphs
    public Graph breadthFirstTraversal(Graph graph, Node root) {
        Graph BFS = new Graph("BFS of: " + graph.getName());
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        BFS.addPoint(root);
        while (!queue.isEmpty()) {
            Node a = queue.poll();
            for (Node n : graph.getNeighbours(a)) {
                if (!BFS.getNodes().contains(n)) {
                    BFS.addPoint(n);
                    BFS.addEdge(a, n, 1);
                    queue.add(n);
                }
            }
        }
        return BFS;
    }
}