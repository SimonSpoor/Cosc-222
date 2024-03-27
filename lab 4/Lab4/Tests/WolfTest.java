import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WolfTest {

    Wolf wolf = new Wolf(2,3,new int[]{2,3}, 1);

    @Test
    void testToString() {
        assertTrue(wolf.toString().equals("Wolf " + 1 + " Moved to " + Arrays.toString(new int[]{2,3})));
    }
}