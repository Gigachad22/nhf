package view;

import javax.swing.*;


public class MenuBar extends JMenuBar {
    private JMenuItem aPoint, aEdge, rPoint, rEdge;
    private JMenuItem k4, k5, k6, savegraph, more;
    private JMenuItem BFS, Dijkstra;

    public MenuBar(){

// Creating all the objects
        rEdge = new JMenuItem("Edge"); rPoint = new JMenuItem("Point");
        aEdge = new JMenuItem("Edge"); aPoint = new JMenuItem("Point");
        more = new JMenuItem("More...");
        k4 = new JMenuItem("K4"); k5 = new JMenuItem("K5"); k6 = new JMenuItem("K6");
        savegraph = new JMenuItem("Save current graph");
        BFS = new JMenuItem("BFS"); Dijkstra = new JMenuItem("Dijkstra");
        fileMenu(); editMenu(); runMenu();
    }
    public void fileMenu() {

// Creating "File" menu components
        JMenu file = new JMenu("File");
        JMenu load = new JMenu("Load graph");
        load.add(k4);
        load.add(k5);
        load.add(k6);
        load.add(more);
        file.add(load);
        file.add(savegraph);
        add(file);
    }
    public void editMenu(){

// Creating "Edit" menu components
        JMenu edit = new JMenu("Edit");
        JMenu submenu_new = new JMenu("New");
        JMenu submenu_remove = new JMenu("Remove");
        submenu_new.add(aPoint);
        submenu_new.add(aEdge);
        submenu_remove.add(rPoint);
        submenu_remove.add(rEdge);
        edit.add(submenu_new);
        edit.add(submenu_remove);
        add(edit);
    }
    public void runMenu(){
        JMenu run = new JMenu("Run");
        run.add(BFS);
        run.add(Dijkstra);
        add(run);
    }

    public JMenuItem getaddPoint() {
        return aPoint;
    }
    public JMenuItem getaddEdge() {
        return aEdge;
    }
    public JMenuItem getremovePoint() {
        return rPoint;
    }
    public JMenuItem getremoveEdge() {
        return rEdge;
    }
    public JMenuItem getK4() {
        return k4;
    }
    public JMenuItem getK5() {
        return k5;
    }
    public JMenuItem getK6() {
        return k6;
    }
    public JMenuItem getBFS(){return BFS;}
    public JMenuItem getDijkstra(){return Dijkstra;}
    public JMenuItem getMore() {
        return more;
    }
    public JMenuItem getSavegraph() {return savegraph;}
}
