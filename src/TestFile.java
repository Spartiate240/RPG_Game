public class TestFile {
    public static void main(String[] args) {
        Player player = PlayerFile.createPlayer("src/PlayerFiles/Example.txt");
        PlayerFile.createFile(player,"PlayerFiles/TestExample.txt");
    }
}
