package illipalinret;

public class SlidingGameState extends GameState {

    public SlidingGameState() {
        super();
    }

    public boolean canHandle(int i) {
        return (i == 3);
    }
    
    public boolean validSlide(Position oldPosition, Position newPosition) {
        int dx = Math.abs(oldPosition.col - newPosition.col);
        int dy = Math.abs(oldPosition.row - newPosition.row);
        boolean valid = Math.max(dx, dy) < 2;
        return valid && isInBoard(newPosition);
    }

    @Override
    public void slidePlayerTo(Player player, Position oldPosition, Position newPosition) {
        if (!validSlide(oldPosition, newPosition))
            throw new RuntimeException(Game.invalidMove);
        player.replacePosition(oldPosition, newPosition);
    }

    @Override
    public void putPlayerAt(Player player, Position position) {
        wrongGameState();
    }

}
