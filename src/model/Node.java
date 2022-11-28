package model;
import java.io.Serializable;

public class Node implements Serializable, Comparable<Node> {
    private String name;

    /**
     * Elmenti tagváltozóba a paraméterként kapott Stringet.
     * @param n
     */
    public Node(String n){
        name = n;
    }

    /**
     * Visszaadja a tagváltozó értékét.
     * @return
     */
    public String toString(){
        return name;
    }

    /**
     * Két Node-ot komparál név alapján. Ha egyezik a név 1-et ad vissza, ha különbözik akkor -1-et.
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Node o) {
        return name.equals(o.toString()) ? 1 : -1;
    }
}
