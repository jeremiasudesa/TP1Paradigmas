package illipalinret;

public class PlacingGameState extends GameState{
    
    public PlacingGameState() {
        super();
    }

    public void putPlayerAt(Player player, Position position){
        player.addPosition(position);  
    }
    
    @Override
    public void slidePlayerTo(Player player, Position oldPosition, Position newPosition) {wrongGameState();}

}
