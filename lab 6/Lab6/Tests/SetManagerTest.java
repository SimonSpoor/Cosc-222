import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SetManagerTest {
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    List<Node> nodes = Arrays.asList(n1, n2, n3);

    @Test
    void testCollapseSetsEmptyInput() {
        List<Node> empty = new ArrayList<>();
        SetManager sm = new SetManager(empty);

        sm.collapseSets();

        // Assert that the resulting sets are empty
        assertEquals(0, sm.getSets().size());
    }

    @Test
    public void testCollapseSetsNoUnions() {
        SetManager sm = new SetManager(nodes);
        sm.collapseSets();

        // Assert that no unions have occurred
        assertEquals(nodes.size(), sm.getSets().size());
    }

    @Test
    public void testCollapseSetsSingleUnion() {
        n1.addFriend(n2);

        SetManager sm = new SetManager(nodes);
        sm.collapseSets();

        // Assert that only one union has occurred
        assertEquals(2, sm.getSets().size());

        // Assert correct union members
        assertTrue(sm.getSets().get(1).getNodes().containsKey(1) && sm.getSets().get(1).getNodes().containsKey(2));
    }

    @Test
    public void testCollapseSetsMultipleUnions() {
        List<Node> nodes = Arrays.asList(n1,n2,n3);
        n1.addFriend(n2);
        n2.addFriend(n3);

        SetManager sm = new SetManager(nodes);
        sm.collapseSets();

        // Assert that both unions have occurred
        assertEquals(1, sm.getSets().size());

        // Assert correct union members
        assertTrue(sm.getSets().get(0).getNodes().containsKey(1) && sm.getSets().get(0).getNodes().containsKey(2) && sm.getSets().get(0).getNodes().containsKey(3));
    }
}