import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SetTest {
    Node n0 = new Node(0);
    Node n1 = new Node(1);

    Set set0 = new Set(n0);
    Set set1 = new Set(n1);

    @Test
    void testAddConnection(){
        set0.addConnection(n1);

        // Assert correct set members
        assertTrue(set0.getNodes().containsKey(0) && set0.getNodes().containsKey(1));
        // Assert correct set size
        assertEquals(2, set0.getNodes().entrySet().size());
    }

    @Test
    void testAddConnectionDuplicate(){
        set0.addConnection(n0);

        // Assert correct set member
        assertTrue(set0.getNodes().containsKey(0));
        // Assert correct set size
        assertEquals(1, set0.getNodes().entrySet().size());
    }

    @Test
    void testIsUnionCompatibleIncompatible() {
        // Assert union between set0 and set1 is not possible
        assertFalse(set0.isUnionCompatible(set1));
    }

    @Test
    void testIsUnionCompatibleCompatible() {
        set0.nodes.put(1,n1);

        // Assert union between set0 and set1 is possible
        assertTrue(set0.isUnionCompatible(set1));
    }

    @Test
    void testUnionSingleInsertion() {
        set0.union(set1);

        // Assert union of set0 and set1 has both n0 and n1
        assertTrue(set0.getNodes().containsKey(0) && set0.getNodes().containsKey(1));
    }

    @Test
    void testUnionMultipleInsertion() {
        set1.nodes.put(2,new Node(2));

        set0.union(set1);

        // Assert union of set0 and set1 has both n0 and n1
        assertTrue(set0.getNodes().containsKey(0) && set0.getNodes().containsKey(1) && set0.getNodes().containsKey(2));
    }

    @Test
    void testUpdateNodeConnections() {
        set0.nodes.put(1, n1);
        set0.updateNodeConnections();

        assertTrue(n0.isConnected(n1));
    }

    @Test
    void testUpdateNodeConnectionsDuplicate() {
        set0.nodes.put(0, n0);
        set0.updateNodeConnections();

        assertEquals(n0.getConnections().size(), 0);
    }

    @Test
    void testToStringOneNode(){
        assertEquals(set0.toString(), "0 ");
    }

    @Test
    void testToStringMultipleNodes(){
        set0.nodes.put(1, n1);

        assertEquals(set0.toString(), "0 1 ");
    }
}