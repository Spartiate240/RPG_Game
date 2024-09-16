public class TestGame {
    static Player player;



    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Multiple inputs detected. 1 input is expected.");
            System.out.println("Please compile again.");
        } else {

            // Verify that the player name has a file tied to it.
            String name = args[0];
            player = new Player(name, 100, 100, 10, 3, 1,0, null, 0);
            Fight.FightLoop(player);
        }
    }
}