package illipalinret;

public class OverState extends GameState {

    static String gameOver = "Game Over";

    public OverState() {
    }

    public boolean canHandle(int i) {
        return (i == -1);
    }

    public void slidePlayerTo(Player player, Position oldPosition, Position newPosition) {
        throw new RuntimeException(gameOver);
    }

    public void putPlayerAt(Player player, Position position) {
        throw new RuntimeException(gameOver);
    }

}