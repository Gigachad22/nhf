package view;

import model.Node;

import java.awt.*;
import java.util.LinkedList;

public class DrawDijkstra extends Drawing{
    LinkedList<Node> shortest_path = new LinkedList<>();
    public void getShortestPath(LinkedList<Node> list){
        shortest_path = list;
    }
    @Override
    public void paintComponent(Graphics g) {
        drawGraph(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        if(shortest_path.size() > 1){
            for (int i = shortest_path.size() - 1; i > 0; i--){
                Node n = shortest_path.get(i);
                Node m = shortest_path.get(i-1);
                drawLine(n, m, g2d);
            }
        }
    }
    public void drawGraph(Graphics g){
        super.paintComponent(g);
    }
}
