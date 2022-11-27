package model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Dijsktra {

    public LinkedList<Node> calculateShortestPath(Graph g, Node source, Node dest){
        LinkedList<Node> path = new LinkedList<>();

        LinkedList<Node> sequence = new LinkedList<>();
        Node current = source;
        sequence.add(current);
        //setup sequence
        while(sequence.size() != g.sizeofPoints()){
            for(Node n : g.getNeighbours(current)){
                if (!sequence.contains(n)){
                    current = n;
                    sequence.add(current);
                    break;
                }
                else break;
            }
        }
        return path;
    }
}
