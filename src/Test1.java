
public class Test1 {

    public static void main(String[] args) {
        Player player = new Player();
        player = PlayerFile.createPlayer("Example");
        player.getInventory().displayInventory();
    }
}