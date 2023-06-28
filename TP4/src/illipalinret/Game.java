package illipalinret;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class Game {

    Player player;
    Player X;
    Player O;
    ArrayList<GameState> stateList = new ArrayList<>();
    GameState state;
    static String notYourTurn = "It's not that player's turn!!";
    static String WrongGameState = "Wrong game state!";
    static String positionIsTakenError = "The position is taken";
    static String invalidMove = "The move is not valid";
    static String positionDoesntBelongToPlayer = "Position doesn't belong to player!!";
    static String positionNotInBoard = "The position is outside the board's limits";

    public Game() {
        X = new PLayerX();
        O = new PlayerO();
        player = X;
        stateList.add(new PlacingGameState());
        stateList.add(new SlidingGameState());
        stateList.add(new OverState());
    }

    private void slidePlayerTo(Player player, Position position1, Position position2) {
        changeStateIfNeeded();
        checkPositionIsInBoard(position2);
        positionTakenCheck(position2);
        checkPositionBelongsToPlayer(player, position1);
        state.slidePlayerTo(player, position1, position2);
    }

    public Game slideXto(Position position1, Position position2) {
        player.isPlayingX();
        slidePlayerTo(player, position1, position2);
        player = O;
        return this;
    }

    public Game slideOto(Position position1, Position position2) {
        player.isPlayingO();
        slidePlayerTo(player, position1, position2);
        player = X;
        return this;
    }

    private void putPlayerAt(Player player, Position position) {
        changeStateIfNeeded();
        checkPositionIsInBoard(position);
        checkPositionOccupied(position);
        state.putPlayerAt(player, position);
    }

    public void checkPositionBelongsToPlayer(Player player, Position position) {
        if (!player.positionSet.contains(position))
            throw new RuntimeException(Game.positionDoesntBelongToPlayer);
    }

    public void checkPositionOccupied(Position position) {
        if (X.positionSet.contains(position) || O.positionSet.contains(position))
            throw new RuntimeException(positionIsTakenError);
    }

    public Game putXAt(Position position) {
        player.isPlayingX();
        putPlayerAt(player, position);
        player = O;
        return this;
    }

    public Game putOAt(Position position) {
        player.isPlayingO();
        putPlayerAt(player, position);
        player = X;
        return this;
    }
    public void changeStateIfNeeded() {
        // if (O.movingPieces && state instanceof PlacingGameState)
        //     state = new SlidingGameState();
        // if (isOver())
        //     state = new OverState();
        state = stateList.stream().filter( (state) -> state.canHandle( gameStateID() )).findFirst().get();
    }

    public int gameStateID(){
        return (isOver()) ? -1 : O.positionSet.size();
    }

    public boolean isOver() {
        boolean Ow = (O.positionSet.size() == 3) && OWon() == true;
        boolean Xw = (X.positionSet.size() == 3) && XWon() == true;
        return Ow || Xw;
    }

    public boolean isTied() {
        return !isOver();
    }

    private void positionTakenCheck(Position position) {
        if (positionTaken(position))
            throw new RuntimeException(Game.positionIsTakenError);
    }

    public boolean positionTaken(Position position) {
        return X.containsPosition(position) || O.containsPosition(position);
    }

    public boolean checkPlayerWon(Player player) {
        return checkStraight(player.positionSet) || checkDiagonal(player.positionSet);
    }

    public boolean checkPositionIsInBoard(Position position) {
        if (!state.isInBoard(position))
            throw new RuntimeException(positionNotInBoard);
        return true;
    }

    public boolean XWon() {
        return checkStraight(X.positionSet) || checkDiagonal(X.positionSet);
    }

    public boolean OWon() {
        return checkStraight(O.positionSet) || checkDiagonal(O.positionSet);
    }

    public boolean checkStraight(Set<Position> positionSet) {
        boolean allColumnsSame = true;
        boolean allRowsSame = true;
        Iterator<Position> iterator = positionSet.iterator();
        Position firstPosition = iterator.next();
        int firstRow = firstPosition.row;
        int firstCol = firstPosition.col;
        while (iterator.hasNext()) {
            Position position = iterator.next();
            allRowsSame &= firstRow == position.row;
            allColumnsSame &= firstCol == position.col;
        }
        return allColumnsSame || allRowsSame;
    }

    public boolean checkDiagonal(Set<Position> positionSet) {
        ArrayList<Position> mainDiagonal = new ArrayList<>(
                Arrays.asList(new Position(0, 0), new Position(1, 1), new Position(2, 2)));
        ArrayList<Position> inverseDiagonal = new ArrayList<>(
                Arrays.asList(new Position(2, 0), new Position(1, 1), new Position(0, 2)));
        boolean mainDiagonalBool = mainDiagonal.stream().allMatch(positionSet::contains);
        boolean inverseDiagonalBool = inverseDiagonal.stream().allMatch(positionSet::contains);
        return mainDiagonalBool || inverseDiagonalBool;
    }

}
