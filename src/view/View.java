package view;
import model.Graph;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private MenuBar menu;

    Drawing dr;
    public View() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("JGraph");
        setSize(800,800);
        setLocationRelativeTo(null);
        menu =  new MenuBar();
        setJMenuBar(menu);
        setResizable(false);
        dr = new Drawing();
        add(dr, BorderLayout.CENTER);
        setVisible(true);
    }

    public void printGraph(Graph g){
        dr.update(g);
        dr.repaint();
        setVisible(true);
    }
    public MenuBar getMenu() {
        setVisible(true);
        return menu;
    }

}
