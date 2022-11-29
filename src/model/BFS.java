package model;
import java.util.*;

public class BFS {
    /**
     * Visszaadja az paraméterként kapott gráf, szintén paraméterként kapott csúcsbol indított BFS-fáját.
     * source: https://www.baeldung.com/java-graphs
     * @param graph A Graph amin futtatva lesz az algoritmus.
     * @param root Node, az algoritmus gyökérpontja.
     * @return  Graph, a paraméterként kapott Graph feszítőfája.
     */
    public Graph breadthFirstTraversal(Graph graph, Node root) {
        Graph BFS = new Graph();
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