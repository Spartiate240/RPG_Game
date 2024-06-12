
public class TestGame {
    static Player player;



    public static void main(String[] args) {
        player = new Player("Test", 100, 100, 10, 3, 1,0, null);
        Fight.FightLoop(player);
    }
}