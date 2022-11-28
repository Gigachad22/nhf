package view;

import javax.swing.*;
import java.awt.*;


public class View extends JFrame {
    private MenuBar menu;

    /**
     * Létrehozza a Frame-et. Beállítja a Menüsort (Menubar).
     */
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

    /**
     * Hozzáadja a paraméterként kapott rajzot (Drawing) a Frame-hez.
     * @param dr
     */
    public void addDrawing(Drawing dr){
        add(dr, BorderLayout.CENTER);
        dr.repaint();
        setVisible(true);
    }

    /**
     * Visszaadja a MenuBart.
     * @return
     */
    public MenuBar getMenu() {
        setVisible(true);
        return menu;
    }

}
