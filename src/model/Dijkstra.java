package model;

import java.util.*;

public class Dijkstra extends Graph{
    /**
     * Beállítja a paraméterként kapott adatszerkezetet tagváltozóba.
     * @param map
     */
    public Dijkstra(LinkedHashMap<Node, LinkedHashMap<Node, Integer>> map){
        setMap(map);
    }

    /**
     * Dijkstra algoritmus. A paraméterként kapott két csúcs között visszaadja egy láncolt listában a visszafelé vezető,
     * legrövidebb utat.
     * @param source
     * @param dest
     * @return
     */
    public LinkedList<Node> calculateShortestPath(Node source, Node dest){
        class Prev {
            Node node;
            Integer distance;
        }
        LinkedList<Node> path = new LinkedList<>();
        path.add(dest);
        HashSet<Node> visited = new HashSet<>();
        Node active = source;
        LinkedHashMap<Node, Prev> table = new LinkedHashMap<>();
        for (Node n : map.keySet()){
            Prev prev = new Prev();
            if (n.compareTo(source) > 0){
                prev.node = active;
                prev.distance = 0;
            }
            else {
                prev.node = active;
                prev.distance = Integer.MAX_VALUE;
            }
            table.put(n, prev);
        }

        while (visited.size() != map.size()){
            for (Node n : map.keySet()){
                Integer prev_dist = table.get(n).distance;
                //Node prev_node = table.get(n).node;
                if (isNeighbours(n, active) && (prev_dist > table.get(active).distance + getWeight(n, active)) && !visited.contains(n)) {
                    table.get(n).distance = table.get(active).distance + getWeight(active, n);
                    table.get(n).node = active;
                }
            }
            visited.add(active);
            // következő active
            Integer min = Integer.MAX_VALUE;
            for (Node m : table.keySet()){
                if (!visited.contains(m) && table.get(m).distance < min){
                    min = table.get(m).distance;
                    active = m;
                }
            }
        }
        // visszafejtése az útvonalnak
        Node current = dest;
        while(table.get(current).node != source){
            path.add(table.get(current).node);
            current = table.get(current).node;
        }
        path.add(source);

        return path;
    }
}
