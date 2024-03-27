import java.util.HashMap;

// Contains a single node and its connections
public class Node {
	int index;

	HashMap<Integer, Node> friends = new HashMap<>();
	HashMap<Integer, Node> connections = new HashMap<>();

	public Node(int index){ this.index = index; }

	public int getIndex() { return index; }

	public HashMap<Integer, Node> getConnections() { return connections; }
	public void setConnections(HashMap<Integer, Node> connections) { this.connections = connections; }


	public HashMap<Integer, Node> getFriends() { return friends; }
	public void addFriend(Node n) { this.friends.put(n.getIndex(), n); }


	boolean isConnected(Node n) {
		// expected case: O(1)
		// worst case: O(n)

		return this.getConnections().containsKey(n.getIndex());
	}

	public String toString(){ return this.index + ""; }
}
