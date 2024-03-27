import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {
    Node n1 = new Node(1);
    Node n2 = new Node(2);

    @Test
    void testAddFriend() {
        n1.addFriend(n2);

        // Assert friend has been added
        assertTrue(n1.friends.containsKey(2));
    }

    @Test
    void testIsConnectedNoConnections() {
        // Assert n1 has no connections
        assertEquals(0, n1.getConnections().size());
    }

    @Test
    void testIsConnectedWithConnection() {
        n1.friends.put(2, n2);

        Set s = new Set(n1);
        s.updateNodeConnections();

        // Assert n1 is connected to n2
        assertTrue(n1.isConnected(n2));
    }
    @Test
    void testToString(){
        assertEquals("1", n1.toString());
    }
}