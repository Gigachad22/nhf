package model;
import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class Graph implements Serializable {
    private String name;
    private LinkedHashMap<Node, HashMap<Node, Integer>> map;

    public Graph(String n) {
        map = new LinkedHashMap<>();
        name = n;
    }
    public String getName() {return name;}
    public Set<Node> getNodes(){
        return map.keySet();
    }
    public int sizeofPoints(){return map.keySet().size();}
    public void addPoint(Node p) {
        map.put(p, new HashMap<>());
    }
    public void addEdge(Node b, Node e, int weight) {
        if (!map.containsKey(b) || !map.containsKey(e))
            System.out.println("baj volt");
        map.get(b).put(e, weight);
        map.get(e).put(b, weight);
    }
    public int getWeight(Node a, Node b){
        return map.get(a).get(b);
    }
    public void removePoint(Node a){
        map.remove(a);
        for (Node p : map.keySet()){
            map.get(p).remove(a);
        }
    }
    public void removeEdge(Node a, Node b){
        map.get(a).remove(b);
        map.get(b).remove(a);
    }
    public Set<Node> getNeighbours(Node a){
        return map.get(a).keySet();
    }
    public Node getNodeByName(String str){
        Node r = null;
        for(Node n : map.keySet()){
            if (n.toString().equals(str)){
                r = n;
            }
        }
        return r;
    }
}

