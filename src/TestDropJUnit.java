import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import mobs.*;

public class TestDropJUnit {

        @Test
        public void testDrop() {
            Spider mob = new Spider();
            // Verify player attributes

            assertTrue(mob.getInventory() != null);
        }
}
    