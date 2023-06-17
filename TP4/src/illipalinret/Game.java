package illipalinret;

import java.util.ArrayList;
import java.util.TreeSet;

public class Game {

    Player X;
    Player O;
    int turnIndex;
    ArrayList<Player> turnsList = new ArrayList<>();
    GameState state;
    static String notYourTurn = "It's not that player's turn!!";
    static String WrongGameState = "Wrong game state!";
    static String positionIsTakenError = "The position is taken";
    static String invalidMove = "The move is not valid";

    public Game(){
        X = new Player();
        O = new Player();
        turnIndex = 0;
        turnsList.add(X);
        turnsList.add(O);
        state = new PlacingGameState();
    }
    //Slide PLayer
    private void slidePlayerTo(Player player, Position position1, Position position2){
        if (!player.movingPieces)
            throw new RuntimeException();
        checkTurn(player);
        positionTakenCheck(position2);
        state.slidePlayerTo(player, position1, position2);
    }
    
    public void slideXto(Position position1, Position position2){ 
        slidePlayerTo(X, position1, position2);
    }
    public void slideOto(Position position1, Position position2){
        state.slidePlayerTo( O, position1, position2);
    }

    //Put PLayer
    private void putPlayerAt(Player player, Position position){

        checkTurn(player);
        state.putPlayerAt(player, position);
        changeStateIfNeeded();
    }
    
    public void putXAt(Position position) {
        putPlayerAt(X, position);
    }

    public void changeStateIfNeeded(){
        if (O.movingPieces && state instanceof PlacingGameState)
            state = new SlidingGameState();
    }


    public void putOAt(Position position) {
        putPlayerAt(O, position);
    }

    public boolean isPlayingX() { return turnsList.get(turnIndex) == X; }
    public boolean isPlayingO() { return turnsList.get(turnIndex) == O; }
    public boolean isOver() { return hasPlayerXWon() || hasPlayerOWon(); }
    public boolean isTied() { return !isOver(); }
    public boolean hasPlayerXWon() { return XWon(); }
    public boolean hasPlayerOWon() { return OWon(); }

    private void positionTakenCheck(Position position){
        if(positionTaken(position))
            throw new RuntimeException(Game.positionIsTakenError);
    }
    
    public void checkTurn(Player player){
        if (turnsList.get(turnIndex) != player)
        	throw new RuntimeException(notYourTurn);
        turnIndex = 1 - turnIndex;
    }

    public boolean positionTaken(Position position){
        return X.containsPosition(position) || O.containsPosition(position);
    }

    public boolean checkPlayerWon(Player player){
        return checkStraight(player.positionSet) || checkDiagonal(player.positionSet);
    }

    public boolean XWon(){
        return checkStraight(X.positionSet) || checkDiagonal(X.positionSet);
    }

    public boolean OWon() {
        return checkStraight(O.positionSet) || checkDiagonal(O.positionSet);
    }

    public boolean checkStraight(TreeSet<Position> positionSet){
        boolean allColumnsSame = false;
        boolean allRowsSame = false;
        int firstRow = positionSet.first().row;
        int firstCol = positionSet.first().col;
        for(Position i : positionSet){
            allRowsSame &= firstRow == i.row;
            allColumnsSame &= firstCol == i.col;
        }
        return allColumnsSame || allRowsSame;
    }

    public boolean checkDiagonal(TreeSet<Position> positionSet){
        boolean ret = false;
        Position previous = new Position(-1, -1);
        for(Position i : positionSet)ret &= previous.lessThan(i);
        return ret;
    }
}
