package model;
import java.io.Serializable;

public class Node implements Serializable, Comparable<Node> {
    private String name;

    public Node(String n){
        name = n;
    }
    public String toString(){
        return name;
    }
    @Override
    public int compareTo(Node o) {
        return name.equals(o.toString()) ? 1 : -1;
    }
}
