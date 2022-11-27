package controller;

import model.BFS;
import model.Graph;
import model.Node;
import view.View;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;

import java.io.*;


public class Controller {
    private Graph g;
    private View v;
    public Controller(Graph gr, View view) {
        g = gr;
        v = view;
        init();
        v.printGraph(g);
    }
    public void init() {
        addPointMenu();
        addEdgeMenu();
        saveMenu();
        loadMoreMenu();
        removePointMenu();
        removeEdgeMenu();
        BFSMenu();
        K4Menu();
        K5Menu();
        K6Menu();
    }
    public void addPointMenu() {
        v.getMenu().getaddPoint().addActionListener(e -> {
            // create and setup a dialog Box
            JDialog d = new JDialog();
            JLabel l = new JLabel("Please type in the name of the point!");
            JTextField txt = new JTextField();
            txt.setPreferredSize(new Dimension(150, 20));
            JButton b = new JButton("Add point");
            JPanel p = new JPanel();
            p.add(l);
            p.add(txt);
            p.add(b);
            d.add(p);
            d.setSize(300, 100);
            d.setLocationRelativeTo(null);
            d.setVisible(true);
            // add the point to the graph and close
            b.addActionListener(j -> {
                g.addPoint(new model.Node(txt.getText()));
                d.dispose();
                v.printGraph(g);
            });
        });
    }
    public void addEdgeMenu() {
        v.getMenu().getaddEdge().addActionListener(e -> {
            JDialog dialog = new JDialog();
            JLabel label = new JLabel("Please select the points for the edge:");
            Node[] nodes = g.getNodes().toArray(new Node[0]);
            JComboBox<Node> box1 = new JComboBox<>(nodes);
            box1.setPreferredSize(new Dimension(100, 25));
            JComboBox<Node> box2 = new JComboBox<>(nodes);
            box2.setPreferredSize(new Dimension(100, 25));

            JPanel main_panel = new JPanel();
            main_panel.setLayout(new GridLayout(4, 1));
            JPanel second_row = new JPanel(new FlowLayout());
            second_row.add(box1);
            second_row.add(box2);


            main_panel.add(label);
            main_panel.add(second_row);
            main_panel.add(new JLabel("Please enter the weight of the edge:"));
            JButton button = new JButton("Ok");

            JPanel fourth_row = new JPanel(new FlowLayout());
            JTextField weight_in = new JTextField();
            weight_in.setPreferredSize(new Dimension(50, 20));
            fourth_row.add(weight_in);
            fourth_row.add(button);

            main_panel.add(fourth_row);
            dialog.add(main_panel);
            dialog.setSize(300, 200);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
            button.addActionListener(j -> {
                if (box1.getSelectedItem() != box2.getSelectedItem() && weight_in.getText().matches("[0-9]+")) {
                    g.addEdge((Node) box1.getSelectedItem(), (Node) box2.getSelectedItem(), Integer.parseInt(weight_in.getText()));
                    dialog.dispose();
                    v.printGraph(g);
                }
            });
        });
    }
    public void GraphToFile(String filename) throws IOException {
        FileOutputStream file_out = new FileOutputStream(filename + ".ser");
        ObjectOutputStream osw = new ObjectOutputStream(file_out);
        osw.writeObject(g);
        osw.close();
    }
    public void GraphFromFile(String filename) throws IOException, ClassNotFoundException {
        File f = new File(filename);
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream in = new ObjectInputStream(fis);
        g = (Graph) in.readObject();
        in.close();
    }
    public void saveMenu() {
        v.getMenu().getSavegraph().addActionListener(e -> {
            JDialog d = new JDialog();
            JLabel l = new JLabel("Name of the file");
            JTextField txt = new JTextField();
            txt.setPreferredSize(new Dimension(150, 20));
            JButton b = new JButton("Save file");
            JPanel p = new JPanel();
            p.add(l);
            p.add(txt);
            p.add(b);
            d.add(p);
            d.setSize(300, 100);
            d.setLocationRelativeTo(null);
            d.setVisible(true);
            b.addActionListener(j -> {
                try {
                    GraphToFile(txt.getText());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    GraphToFile(txt.getText());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                d.dispose();
                v.printGraph(g);
            });

        });
    }
    public void loadMoreMenu() {
        v.getMenu().getMore().addActionListener(e -> {
            File workingDirectory = new File(System.getProperty("user.dir"));
            JFileChooser chooser = new JFileChooser(workingDirectory);
            chooser.setApproveButtonText("Open selected file");
            chooser.setAcceptAllFileFilterUsed(false);
            chooser.setDialogTitle("Select a .ser file");
            chooser.addChoosableFileFilter(new FileNameExtensionFilter("Only .SER type", "ser"));
            chooser.showDialog(v, "Load file");
            try {
                GraphFromFile(chooser.getSelectedFile().getName());
                v.printGraph(g);
                v.setVisible(true);
            } catch (IOException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
    public void removePointMenu(){
        v.getMenu().getremovePoint().addActionListener(e -> {
            JDialog dialog = new JDialog();
            dialog.setSize(new Dimension(300, 180));
            dialog.setLayout(new GridLayout(2, 1));
            dialog.add(new JLabel("Please select the point you want to remove"));
            JPanel panel = new JPanel();
            Node[] nodes = g.getNodes().toArray(new Node[0]);
            JComboBox<Node> box = new JComboBox<>(nodes);
            box.setPreferredSize(new Dimension(100, 25));
            JButton button = new JButton("Remove");
            panel.setLayout(new FlowLayout());
            panel.add(box); panel.add(button); dialog.add(panel);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
            button.addActionListener(j -> {
                g.removePoint((Node)box.getSelectedItem());
                dialog.dispose();
                v.printGraph(g);
            });
        });
    }
    public void removeEdgeMenu(){
        v.getMenu().getremoveEdge().addActionListener(e -> {
            JDialog dialog = new JDialog();
            dialog.setSize(new Dimension(300, 180));
            dialog.setLayout(new GridLayout(3, 1));
            dialog.add(new JLabel("Please select the begin- and endpoint you want to remove"));
            Node[] nodes1 = g.getNodes().toArray(new Node[0]);
            Node[] nodes2 = g.getNodes().toArray(new Node[0]);
            JComboBox<Node> box1 = new JComboBox<>(nodes1);
            JComboBox<Node> box2 = new JComboBox<>(nodes2);
            box1.setPreferredSize(new Dimension(100, 25));
            box2.setPreferredSize(new Dimension(100, 25));
            JPanel panel1 = new JPanel();
            panel1.setLayout(new FlowLayout());
            panel1.add(box1); panel1.add(box2); dialog.add(panel1);
            JPanel panel2 = new JPanel();
            panel2.setLayout(new FlowLayout());
            JButton button = new JButton("Remove");
            panel2.add(button); dialog.add(panel2);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
            button.addActionListener(j -> {
                if (box1.getSelectedItem() != box2.getSelectedItem()){
                    g.removeEdge((Node) box1.getSelectedItem(), (Node)box2.getSelectedItem());
                    dialog.dispose();
                    v.printGraph(g);
                }
            });
        });
    }
    public void BFSMenu(){
        v.getMenu().getBFS().addActionListener( e -> {
            JDialog dialog = new JDialog();
            dialog.setSize(new Dimension(300, 200));
            dialog.setLayout(new GridLayout(2, 1));
            dialog.add(new JLabel("Please select the root point"));
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());
            Node[] nodes = g.getNodes().toArray(new Node[0]);
            JComboBox<Node> box = new JComboBox<>(nodes);
            box.setPreferredSize(new Dimension(100,25));
            JButton button = new JButton("Ok");
            panel.add(box); panel.add(button); dialog.add(panel);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
            button.addActionListener( j -> {
                dialog.dispose();
                BFS b = new BFS();
                Graph bfs = b.breadthFirstTraversal(g, (Node)box.getSelectedItem());
                View bfs_view = new View();
                bfs_view.printGraph(bfs);
                bfs_view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            });
        });
    }
    public Graph createK4(){
        Graph graph = new Graph("K4");
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");

        graph.addPoint(A);
        graph.addPoint(B);
        graph.addPoint(C);
        graph.addPoint(D);

        graph.addEdge(A, B, 3);
        graph.addEdge(A, C, 3);
        graph.addEdge(A, D, 3);
        graph.addEdge(B, C, 3);
        graph.addEdge(B, D, 3);
        graph.addEdge(C, D, 3);
        return graph;
    }
    public void K4Menu(){
        v.getMenu().getK4().addActionListener(e -> {
            g = createK4();
            v.printGraph(g);
        });
    }
    public void K5Menu(){
        v.getMenu().getK5().addActionListener(e -> {
            g = createK4();
            Node E = new Node("E");
            g.addPoint(E);
            g.addEdge(g.getNodeByName("A"), E, 3);
            g.addEdge(g.getNodeByName("B"), E, 3);
            g.addEdge(g.getNodeByName("C"), E, 3);
            g.addEdge(g.getNodeByName("D"), E, 3);
            v.printGraph(g);
        });
    }
    public void K6Menu(){
        v.getMenu().getK6().addActionListener(e -> {
            g = createK4();
            Node E = new Node("E");
            Node F = new Node("F");
            g.addPoint(E); g.addPoint(F);
            g.addEdge(g.getNodeByName("A"), E, 3);
            g.addEdge(g.getNodeByName("B"), E, 3);
            g.addEdge(g.getNodeByName("C"), E, 3);
            g.addEdge(g.getNodeByName("D"), E, 3);
            g.addEdge(g.getNodeByName("A"), F, 3);
            g.addEdge(g.getNodeByName("B"), F, 3);
            g.addEdge(g.getNodeByName("C"), F, 3);
            g.addEdge(g.getNodeByName("D"), F, 3);
            g.addEdge(E, F, 3);
            v.printGraph(g);
        });
    }
}
