package illipalinret;

public abstract class GameState {
    
    public GameState() {
    }

    //metodos a implementar
    public abstract void slidePlayerTo(Player player,  Position oldPosition, Position newPosition);
    public abstract void putPlayerAt(Player player, Position position);

    public boolean isInScreen(Position position) { return (position.col >= 0 || position.col <= 2) && (position.row >= 0 || position.row <= 2) ;}

    public void wrongGameState(){
        throw new RuntimeException(Game.WrongGameState);
    }

}
