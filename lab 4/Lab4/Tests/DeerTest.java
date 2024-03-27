import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DeerTest {

    Deer deer = new Deer(2,3,new int[]{2,3}, 1);

    @Test
    void testToString() {
        assertTrue(deer.toString().equals("Deer " + 1 + " Moved to " + Arrays.toString(new int[]{2,3})));
    }
}