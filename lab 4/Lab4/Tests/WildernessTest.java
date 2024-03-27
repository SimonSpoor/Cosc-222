import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


class WildernessTest {
    ArrayList<Animal> testArray = new ArrayList<>();

    Deer deer = new Deer(1,1,new int[]{2,3}, 1);
    Deer deer2 = new Deer(2,1,new int[]{2,3}, 1);
    Wolf wolf = new Wolf(2,3,new int[]{2,3}, 1);

    @Test
    void doTimestepTestRemoval() {
        testArray.add(deer);    // Hashmap created with only one animal
        Wilderness w = new Wilderness(testArray);

        w.remove.add(Arrays.toString(deer.position));
        w.doTimestep();

        assertTrue(w.remove.isEmpty());     // Hashmap is empty after removing deer
        assertTrue(w.map.isEmpty());        // Remove arraylist is empty
    }

    @Test
    void moveTest() {
        testArray.add(deer);
        Wilderness w = new Wilderness(testArray);

        w.move(deer, 0);    // Move North
        assertTrue(Arrays.equals(deer.getPosition(), new int[]{1,2}));

        w.move(deer, 1);    // Move East
        assertTrue(Arrays.equals(deer.getPosition(), new int[]{2,2}));

        w.move(deer, 2);    // Move South
        assertTrue(Arrays.equals(deer.getPosition(), new int[]{2,1}));

        w.move(deer, 3);    // Move West
        assertTrue(Arrays.equals(deer.getPosition(), new int[]{1,1}));
    }

    @Test
    void checkWildernessTestKill() {
        testArray.add(deer);
        testArray.add(deer2);
        testArray.add(wolf);

        Wilderness w = new Wilderness(testArray);
        w.checkWilderness(wolf, deer.getPosition());
        w.checkWilderness(deer2, wolf.getPosition());

        assertTrue(deer.isDead);    // Deer is killed by wolf moving into it's space
        assertTrue(deer2.isDead);   // Deer is killed by moving into wolf's space

    }
    @Test
    public void testCheckWildernessOccupation() {
        testArray.add(deer);
        testArray.add(wolf);

        Wilderness w = new Wilderness(testArray);

        assertFalse(w.checkWilderness(wolf, deer.getPosition()));   // Wolf kills deer
        assertFalse(w.checkWilderness(deer, new int[] { 0, 2 }));   // Nothing is in 0,2
        assertTrue(w.checkWilderness(wolf, new int[] { 2, 3 }));    // Wolf cannot occupy itself
    }


    @Test
    public void testCheckWildernessBlockActionOnOccupation() {
        testArray.add(deer);
        testArray.add(deer2);

        int[] deerbefore = deer.getPosition();
        int[] deer2before = deer2.getPosition();

        Wilderness w = new Wilderness(testArray);
        w.checkWilderness(deer, deer2.getPosition());

        assertTrue(Arrays.equals(deer.getPosition(), deerbefore));      // First deer stays in place after being blocked
        assertTrue(Arrays.equals(deer2.getPosition(), deer2before));    // Second deer stays in place after being blocked
    }

    @Test
    public void testToString(){
        testArray.add(deer);
        testArray.add(wolf);

        Wilderness w = new Wilderness(testArray);
        String s = "Deer " + 1 + " Moved to " + Arrays.toString(new int[]{1,1}) + "\n" + "Wolf " + 1 + " Moved to " + Arrays.toString(new int[]{2,3}) + "\n";
        assertEquals(w.toString(), s);      // Check accuracy of toString statement
    }
}