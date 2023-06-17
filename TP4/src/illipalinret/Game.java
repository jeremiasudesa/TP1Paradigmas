package illipalinret;
import java.util.HashMap;
import java.util.ArrayList;

public class Game {
    //Board board;
    Player X = new Player();
    Player O = new Player();
    int turnIndex = 0;
    ArrayList<Player> turnsList = new ArrayList<>();
//    HashMap<Player, Integer> turnsMap = new HashMap<>();
    String playerHasPiecesLeftError = "The player has unplaced pieces";
    String playerHasPutAllHisPieces = "Player has put all his pieces!!";
    String playerHasntPutAllHisPieces = "Player hasn't put all his pieces!!";
    String positionIsTakenError = "The position is taken";
    String invalidMove = "The move is not valid";
    static String notYourTurn = "It's not that player's turn!!";
    
    public Game() {
    	turnsList.add(X);
    	turnsList.add(O);
    }

    public void putPlayerAt(Player player, Position position){
        if(player.movingPieces)
            throw new RuntimeException(playerHasPutAllHisPieces);
        if(positionTaken(position))
            throw new RuntimeException(positionIsTakenError);
        checkTurn(player);
        player.addPosition(position);
        
    }

    public void putXAt(Position position){
        putPlayerAt(X, position);
    }

    public void putOAt(Position position){
        putPlayerAt(O, position);
    }

    public boolean positionTaken(Position position){
        return X.containsPosition(position) || O.containsPosition(position);
    }

    public void slidePlayer(Player player, Position oldPosition, Position newPosition){
        if(!player.movingPieces)
            throw new RuntimeException();
        if(positionTaken(newPosition))
            throw new RuntimeException(positionIsTakenError);
        if(!validSlide(oldPosition, newPosition))
            throw new RuntimeException(invalidMove);
        checkTurn(player);
        player.replacePosition(oldPosition, newPosition);
    }
    
    public void checkTurn(Player player){

        if (turnsList.get(turnIndex) != player)
        	throw new RuntimeException(notYourTurn);
        turnIndex = 1 - turnIndex;
    }

    public boolean isInScreen(Position position) { return (position.col >= 0 || position.col <= 2) && (position.row >= 0 || position.row <= 2) ;}

    public boolean validSlide(Position oldPosition, Position newPosition){//lo maximo que me puedo mover en una coordenada es 1
    	
        int dx = Math.abs(oldPosition.col - newPosition.col);
        int dy = Math.abs(oldPosition.row - newPosition.row);
        boolean valid = Math.max(dx, dy) < 2 ;
        return valid && isInScreen(newPosition);
    }
    
//    private boolean playerWon(Player player){
//        //actualizar informacion
//    }
}
