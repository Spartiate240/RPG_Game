import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestPlayer {

    @Test
    public void testCreatePlayerFromTxt() {
        Player player = PlayerFile.createPlayer("Example");
        // Verify player attributes
        assertEquals("XXX", player.getName());
        assertEquals(12, player.getLevel());
        assertEquals(10, player.getXP());
        assertEquals(10, player.getMaxHealth());
        assertEquals(10, player.getDamage());
        assertEquals(10, player.getDefense());

        // Verify gear
        assertEquals("Worn_Down_Cap", player.getHead().getName());
        assertEquals("Torn_Leggings", player.getLeg().getName());
        assertEquals("Worn_Down_Sandals", player.getFeet().getName());
        assertEquals("Worn_Down_Chestplate", player.getChest().getName());
        assertEquals("Damaged_Sword", player.getWeapon1().getName());
        assertEquals("Damaged_Sword", player.getWeapon2().getName());

        // Verify inventory
        assertEquals(2, player.getInventory().size());
        assertEquals("Small Health Potion", player.getInventory().get(0).getName());
        assertEquals(2, player.getInventory().get(0).getQuantity());
    }

        // Verify level up    
    @Test
    public void testCheckLvlUP() {
        Player player = PlayerFile.createPlayer("Example");
        player.setXP(3601);
        assertEquals(3601, player.getXP(), 0);
        player.checkLevelUp();
    
        assertEquals(1, player.getXP());
        assertEquals(13, player.getLevel());
    }
}
