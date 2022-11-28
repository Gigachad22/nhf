package model;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.Set;

public class Graph implements Serializable {

    protected LinkedHashMap<Node, LinkedHashMap<Node, Integer>> map = new LinkedHashMap<>();

    /**
     * Paraméterként kapott adatszerkezetet elmenti tagváltozóba. Csak leszármazott osztályokban lehet meghívni.
     * @param map
     */
   protected void setMap(LinkedHashMap<Node, LinkedHashMap<Node, Integer>> map){
       this.map = map;
   }

    /**
     * Visszaadja a tagváltozóba elmentett adatszerkezet.
     * @return
     */
   public LinkedHashMap<Node, LinkedHashMap<Node, Integer>> getMap(){
       return map;
    }

    /**
     * Visszaadja a gráf csúcsait tartalmazó Set-et.
     * @return
     */
    public Set<Node> getNodes(){
        return map.keySet();
    }

    /**
     * Visszaadja a gráf csúcsainak számát.
     * @return
     */
    public int sizeofPoints(){return map.keySet().size();}

    /**
     * Hozzáadja a gráfhoz a paraméterként kapott csúcsot.
     * @param p
     */
    public void addPoint(Node p) {
        map.put(p, new LinkedHashMap<>());
    }

    /**
     * Hozzáadja a gráfhoz a paraméterként kapott csúcsok közötti, szintén paraméterként kapott súlyú gráfot.
     * @param b
     * @param e
     * @param weight
     */
    public void addEdge(Node b, Node e, int weight) {
        if (!map.containsKey(b) || !map.containsKey(e))
            System.out.println("baj volt");
        map.get(b).put(e, weight);
        map.get(e).put(b, weight);
    }

    /**
     * Visszaadja a paraméterként kapott két csúcs közötti él súlyát.
     * @param a
     * @param b
     * @return
     */
    public int getWeight(Node a, Node b){
        return map.get(a).get(b);
    }

    /**
     * Törli a gráfból a paraméterként kapott csúcsot és az összes hozzá kapcsolódó élet.
     * @param a
     */
    public void removePoint(Node a){
        map.remove(a);
        for (Node p : map.keySet()){
            map.get(p).remove(a);
        }
    }

    /**
     * Törli a gráfból a paraméterként kapott csúcsok közötti élet.
     * @param a
     * @param b
     */
    public void removeEdge(Node a, Node b){
        map.get(a).remove(b);
        map.get(b).remove(a);
    }

    /**
     * Visszaadja a paraméterként kapott csúcs szomszédos csúcsainak halmazát.
     * @param a
     * @return
     */
    public Set<Node> getNeighbours(Node a){
        return map.get(a).keySet();
    }

    /**
     * Visszaadja a gráfból azt a csúcsot amelynek a neve megegyezik a paraméterként kapott Stringgel.
     * @param str
     * @return
     */
    public Node getNodeByName(String str){
        Node r = null;
        for(Node n : map.keySet()){
            if (n.toString().equals(str)){
                r = n;
            }
        }
        return r;
    }

    /**
     * Visszaadja, hogy a paraméterként kapott csúcsok között van-e él.
     * @param n
     * @param m
     * @return
     */
    public boolean isNeighbours(Node n, Node m){
       return getNeighbours(n).contains(m);
    }
}

