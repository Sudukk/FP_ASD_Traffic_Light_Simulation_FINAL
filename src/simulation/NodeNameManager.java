package simulation;

import java.util.*;

public class NodeNameManager {
    private HashMap<String, Integer> map = new HashMap<>(); // Map nama node -> index
    private ArrayList<String> names = new ArrayList<>(); // List index -> nama node

    public void add(String name) {
        map.put(name, names.size()); //simpan mapping nama -> index
        names.add(name);
    }

    public int indexOf(String name) {
        if(map.containsKey(name)){
            return map.get(name);
        }else{
            return -1;
        }
    }

    public String nameOf(int index) {
        if (index < 0 || index >= names.size()) return null;
        return names.get(index);
    }

    public void printNodes() {
        System.out.println("\n=== LIST OF JUNCTIONS ===");
        for (String n : names){
            System.out.println("[" + n + "]");// Cetak node
        }

    }
}

