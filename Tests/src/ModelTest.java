import controller.Controller;
import model.BFS;
import model.Dijkstra;
import model.Graph;
import model.Node;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class ModelTest {
    Graph graph;
    Node X, Y;

    /**
     * Inicializáció
     */
    @Before
    public void setup(){
        graph = Controller.createK4();
        X = new Node("X");
        Y = new Node("Y");
    }

    /**
     * Graph-hoz csúcs hozzáadása tesz.
     */
    @Test
    public void testAddPoint(){
        graph.addPoint(new Node("E"));
        Assert.assertEquals(5, graph.sizeofPoints());
    }

    /**
     * Graph-ból csúcs lekérése név alapján teszt.
     */
    @Test
    public void testGetNode(){
        Node F = new Node("F");
        graph.addPoint(F);
        Assert.assertEquals(graph.getNodeByName("F"), F);
    }

    /**
     * Graph-hoz él hozzáadása teszt.
     */
    @Test
    public void testAddEdge(){
        Node A = graph.getNodeByName("A");
        Node E = new Node("E");
        graph.addPoint(E);
        graph.addEdge(A, E, 5);
        Assert.assertTrue(graph.isNeighbours(A, E));
    }

    /**
     * Csúcs törlése a gráfból.
     */
    @Test
    public void testRemovePoint(){
        graph.removePoint(graph.getNodeByName("A"));
        Assert.assertEquals(3, graph.sizeofPoints());
    }

    /**
     * Él törlése a gráfból.
     */
    @Test
    public void testRemoveEdge(){
        Node A = graph.getNodeByName("A");
        Node B = graph.getNodeByName("B");
        graph.removeEdge(A, B);
        Assert.assertFalse(graph.isNeighbours(A, B));
    }

    /**
     * Él súlyának lekérdezése a gráfból.
     */
    @Test
    public void testGetWeight(){
        int weight = 17;
        graph.addPoint(X);
        graph.addPoint(Y);
        graph.addEdge(X,Y, weight);
        Assert.assertEquals(weight, graph.getWeight(X, Y));
    }

    /**
     * Node komparálás név alapján.
     */
    @Test
    public void testNodeCompare(){
        Assert.assertEquals(-1, X.compareTo(Y));
        Assert.assertEquals(1, X.compareTo(X));
    }

    /**
     * BFS osztály tesztelése.
     */
    @Test
    public void testBFS(){
        graph.addPoint(X);
        graph.addEdge(X, graph.getNodeByName("B"), 5);
        BFS bfs = new BFS();
        Graph bfs_tree = bfs.breadthFirstTraversal(graph, X);
        Assert.assertEquals(graph.sizeofPoints(), bfs_tree.sizeofPoints());
        Assert.assertTrue(bfs_tree.isNeighbours(X, graph.getNodeByName("B")));
        Assert.assertFalse(bfs_tree.isNeighbours(X, graph.getNodeByName("A")));
        Assert.assertFalse(bfs_tree.isNeighbours(X, graph.getNodeByName("C")));
        Assert.assertFalse(bfs_tree.isNeighbours(X, graph.getNodeByName("D")));
    }

    /**
     * Dijkstra osztály tesztelése.
     */
    @Test
    public void testDijkstra(){
        Dijkstra dij = new Dijkstra(graph.getMap());
        Assert.assertEquals(graph.sizeofPoints(), dij.sizeofPoints());
        LinkedList<Node> path = dij.calculateShortestPath(dij.getNodeByName("A"), dij.getNodeByName("B"));
        Assert.assertTrue(path.contains(dij.getNodeByName("A")));
        Assert.assertTrue(path.contains(dij.getNodeByName("B")));
        Assert.assertFalse(path.contains(X));
        Assert.assertEquals(2, path.size());
        dij.addPoint(X);
        dij.addPoint(Y);
        dij.addEdge(X, Y, Integer.MAX_VALUE);
        dij.addEdge(X,dij.getNodeByName("A"), 1);
        dij.addEdge(Y, dij.getNodeByName("A"), 1);
        LinkedList<Node> path2 = dij.calculateShortestPath(X, Y);
        Assert.assertEquals(3, path2.size());
        Assert.assertTrue(path2.contains(X));
        Assert.assertTrue(path2.contains(Y));
        Assert.assertTrue(path2.contains(dij.getNodeByName("A")));
    }
}
