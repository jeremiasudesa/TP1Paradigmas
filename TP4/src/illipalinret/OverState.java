package illipalinret;

public class OverState {

    static String gameOver = "Game Over";

    public OverState() {
    }

    // metodos a implementar
    public void slidePlayerTo(Player player, Position oldPosition, Position newPosition){
        throw new RuntimeException(gameOver);
    }

    public void putPlayerAt(Player player, Position position){
        throw new RuntimeException(gameOver);
    }

}
