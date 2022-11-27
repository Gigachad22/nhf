package controller;

import model.Dijsktra;
import model.Graph;
import model.Node;
import view.View;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Graph gr = new Graph("Alma");
        View v = new View();
        Controller cntrl = new Controller(gr, v);


        /*Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");

        gr.addPoint(A);
        gr.addPoint(B);
        gr.addPoint(C);
        gr.addPoint(D);
        gr.addPoint(E);

        gr.addEdge(A,B,3);
        gr.addEdge(A,D,4);
        gr.addEdge(E,B,2);
        gr.addEdge(C,B,7);
        gr.addEdge(D,E,5);

        Dijsktra dij = new Dijsktra();
        LinkedList<Node> seq = dij.calculateShortestPath(gr, A, C);*/
    }
}