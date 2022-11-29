package view;

import javax.swing.*;


public class MenuBar extends JMenuBar {
    private final JMenuItem aPoint, aEdge, rPoint, rEdge, rGraph;
    private final JMenuItem k4, k5, k6, savegraph, more;
    private final JMenuItem BFS, Dijkstra;

    /**
     * Konstruktor. Tagváltozók létrehozása.
     */
    public MenuBar(){

// Creating all the objects
        rEdge = new JMenuItem("Edge"); rPoint = new JMenuItem("Point");
        rGraph = new JMenuItem("Graph");
        aEdge = new JMenuItem("Edge"); aPoint = new JMenuItem("Point");
        more = new JMenuItem("More...");
        k4 = new JMenuItem("K4"); k5 = new JMenuItem("K5"); k6 = new JMenuItem("K6");
        savegraph = new JMenuItem("Save current graph");
        BFS = new JMenuItem("BFS"); Dijkstra = new JMenuItem("Dijkstra");
        fileMenu(); editMenu(); runMenu();
    }

    /**
     * File menü létrehozása.
     */
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

    /**
     * Edit menü létrehozása.
     */
    public void editMenu(){

// Creating "Edit" menu components
        JMenu edit = new JMenu("Edit");
        JMenu submenu_new = new JMenu("New");
        JMenu submenu_remove = new JMenu("Remove");
        submenu_new.add(aPoint);
        submenu_new.add(aEdge);
        submenu_remove.add(rPoint);
        submenu_remove.add(rEdge);
        submenu_remove.add(rGraph);
        edit.add(submenu_new);
        edit.add(submenu_remove);
        add(edit);
    }

    /**
     * Run menü létrehozása.
     */
    public void runMenu(){
        JMenu run = new JMenu("Run");
        run.add(BFS);
        run.add(Dijkstra);
        add(run);
    }

    /**
     * Tagváltozó visszaadása.
     * @return JMenuItem
     */
    public JMenuItem getaddPoint() {
        return aPoint;
    }
    /**
     * Tagváltozó visszaadása.
     * @return JMenuItem
     */
    public JMenuItem getaddEdge() {
        return aEdge;
    }
    /**
     * Tagváltozó visszaadása.
     * @return JMenuItem
     */
    public JMenuItem getremovePoint() {
        return rPoint;
    }
    /**
     * Tagváltozó visszaadása.
     * @return JMenuItem
     */
    public JMenuItem getremoveEdge() {
        return rEdge;
    }
    /**
     * Tagváltozó visszaadása.
     * @return JMenuItem
     */
    public JMenuItem getK4() {
        return k4;
    }
    /**
     * Tagváltozó visszaadása.
     * @return JMenuItem
     */
    public JMenuItem getK5() {
        return k5;
    }
    /**
     * Tagváltozó visszaadása.
     * @return JMenuItem
     */
    public JMenuItem getK6() {
        return k6;
    }
    /**
     * Tagváltozó visszaadása.
     * @return JMenuItem
     */
    public JMenuItem getBFS(){return BFS;}
    /**
     * Tagváltozó visszaadása.
     * @return JMenuItem
     */
    public JMenuItem getDijkstra(){return Dijkstra;}
    /**
     * Tagváltozó visszaadása.
     * @return JMenuItem
     */
    public JMenuItem getMore() {
        return more;
    }
    /**
     * Tagváltozó visszaadása.
     * @return JMenuItem
     */
    public JMenuItem getSavegraph() {return savegraph;}
    /**
     * Tagváltozó visszaadása.
     * @return JMenuItem
     */
    public JMenuItem getrGraph(){
        return rGraph;
    }
}
