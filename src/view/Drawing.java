package view;

import model.Graph;
import model.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.lang.Math;
import java.util.LinkedHashMap;


public class Drawing extends JPanel {
    LinkedHashMap<Node, Coordinate> points = new LinkedHashMap<>();
    Graph graph;

    /**
     * Kirajzolja az elmentett gráfot.
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        // drawing nodes
        for (Node n : points.keySet()) {
            g2d.setColor(Color.black);
            Ellipse2D.Double circle = new Ellipse2D.Double(points.get(n).X, points.get(n).Y, 10, 10);
            g2d.fill(circle);
            g2d.drawString(n.toString(), points.get(n).X + 20, points.get(n).Y -5);
            // drawing edges
            for (Node m : graph.getNeighbours(n)){
                g2d.setColor(Color.BLUE);
                drawLine(n, m, g2d);
            }
        }
    }

    /**
     * Paraméterként kapott két csúcs koordinátáit megkeresi majd vonalat húz közé
     * @param n Az egyik Node
     * @param m A másik Node
     * @param g2d Graphics objektum
     */
    public void drawLine(Node n, Node m, Graphics2D g2d){
        g2d.drawLine(points.get(m).X + 5, points.get(m).Y + 5, points.get(n).X + 5, points.get(n).Y + 5);
        g2d.drawString(String.valueOf(graph.getWeight(m, n)), (points.get(m).X + points.get(n).X)/2 + 20, (points.get(m).Y + points.get(n).Y)/2 + 20);
    }

    /**
     * Megnézi, hány csúcs van a kapott gráfban, majd kiszámolja az ezekhez tartozó koordinátákat és elmenti tagváltozóba.
     * Elmenti a kapott gráfot.
     * @param g Graph, a megjeleníteni kívánt gráf
     */
    public void update(Graph g){
        graph = g;
        double d = Math.PI*2 / graph.sizeofPoints();
        Object[] nodes = graph.getNodes().toArray();
        points = new LinkedHashMap<>();
        for(int i = 0; i < graph.sizeofPoints(); i++){
            points.put((Node)nodes[i],new Coordinate(parametricX(d*i), parametricY(d*i)));
        }
    }

    /**
     * Kiszámolja és visszaadja a paraméterként kapott szöghöz tartozó X koordinátát.
     * @param angle double, X tengellyel bezárt szög
     * @return Integer, az elforgatott pont X koordinátája
     */
    public Integer parametricX(double angle){
        Double d = 400 + (300 * Math.cos(angle));
        return d.intValue();
    }

    /**
     * Kiszámolja és visszaadja a paraméterként kapott szöghöz tartozó Y koordinátát.
     * @param angle double, X tengellyel bezárt szög
     * @return Integer, az elforgatott pont Y koordinátája
     */
    public Integer parametricY(double angle){
        Double d = 350 + (300 * Math.sin(angle));
        return d.intValue();
    }
}

