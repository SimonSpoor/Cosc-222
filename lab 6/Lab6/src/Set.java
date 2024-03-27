import java.util.HashMap;

// Contains a set of nodes and their connections
public class Set {
    HashMap<Integer, Node> nodes = new HashMap<>();

    // Populate set based on representative node
    public Set(Node rep){
        nodes.put(rep.getIndex(), rep);
        for (Node n: rep.getFriends().values()){
            this.nodes.put(n.getIndex(), n);
        }
    }

    public void addConnection(Node n){
        this.nodes.put(n.getIndex(), n);
        updateNodeConnections();
    }

    public HashMap<Integer, Node> getNodes() { return nodes; }

    public boolean isUnionCompatible(Set s){
        // expected case: O(n)
        // worst case: O(n^2)

        // Return true if the sets share a node
        for (Integer n: s.getNodes().keySet()){
            if (this.getNodes().containsKey(n)) return true;
        }
        return false;
    }



    public void union(Set s){
        // Collision is not a concern here
        this.nodes.putAll(s.getNodes());
    }

    public void updateNodeConnections(){
        // expected case O(n)

        for (Node n: nodes.values()){
            // Prevent a node from connecting to itself
            HashMap<Integer, Node> tmp = new HashMap<>(nodes);
            tmp.remove(n.getIndex());

            n.setConnections(tmp);
        }
    }

    public String toString(){
        String s = "";
        for (Node n: nodes.values()){
            s += n.toString() + " ";
        }
        return s;
    }
}
