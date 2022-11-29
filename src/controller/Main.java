package controller;

import model.Graph;
import view.View;


public class Main {
    /**
     * A program futtatása
     * @param args parancssori argumentum, a program nem használja.
     */
    public static void main(String[] args) {
        Graph gr = new Graph();
        View v = new View();
        Controller cntrl = new Controller(gr, v);
    }
}