public class Game {

    public static void main(String[] args) {
        

        if (args.length != 1) {
            System.out.println("Multiple inputs detected. 1 input is expected.");
            System.out.println("Please compile again.");
        } else {
            String name = args[0];
            Player player = PlayerFile.createPlayer(name);
            MenuSystem.displayMenu();
    }
}
}
