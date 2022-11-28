package view;

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
        setVisible(true);
    }

    public void addDrawing(Drawing dr){
        add(dr, BorderLayout.CENTER);
        dr.repaint();
        setVisible(true);
    }
    public MenuBar getMenu() {
        setVisible(true);
        return menu;
    }

}
