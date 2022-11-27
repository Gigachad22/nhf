package model;
import java.io.Serializable;
import java.util.ArrayList;

public class Node implements Serializable {
    private String name;

    public Node(String n){
        name = n;

    }
    public String toString(){
        return name;
    }

}
