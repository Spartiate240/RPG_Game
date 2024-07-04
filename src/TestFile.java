public class TestFile {
    public static void main(String[] args) {
        Player player = PlayerFile.createPlayer("Example");
        PlayerFile.createFile(player,"PlayerFiles/TestExample");
    }
}
