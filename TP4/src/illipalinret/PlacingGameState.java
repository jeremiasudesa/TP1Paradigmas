package illipalinret;

public class PlacingGameState extends GameState {

    public PlacingGameState() {
        super();
    }

    public boolean canHandle(int i){
        return (i>=0) && (i<3);
    }

    public void putPlayerAt(Player player, Position position) {
        player.addPosition(position);
    }

    @Override
    public void slidePlayerTo(Player player, Position oldPosition, Position newPosition) {
        wrongGameState();
    }

}
