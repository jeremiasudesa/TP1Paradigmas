package illipalinret;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

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
    static String positionDoesntBelongToPlayer = "Position doesn't belong to player!!";
    static String positionNotInBoard = "The position is outside the board's limits";

    public Game() {
        X = new Player();
        O = new Player();
        turnIndex = 0;
        turnsList.add(X);
        turnsList.add(O);
        state = new PlacingGameState();
    }

    private void slidePlayerTo(Player player, Position position1, Position position2) {
        if (!player.movingPieces)
            throw new RuntimeException(WrongGameState);
        checkPositionIsInBoard(position2);
        checkTurn(player);
        positionTakenCheck(position2);
        checkPositionBelongsToPlayer(player, position1);
        state.slidePlayerTo(player, position1, position2);
        changeStateIfNeeded();
    }

    public Game slideXto(Position position1, Position position2) {
        slidePlayerTo(X, position1, position2);
        return this;
    }

    public Game slideOto(Position position1, Position position2) {
        slidePlayerTo(O, position1, position2);
        return this;
    }

    private void putPlayerAt(Player player, Position position) {
        checkPositionIsInBoard(position);
        checkPositionOccupied(position);
        checkTurn(player);
        state.putPlayerAt(player, position);
        changeStateIfNeeded();
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
        putPlayerAt(X, position);
        return this;
    }

    public void changeStateIfNeeded() {
        if (O.movingPieces && state instanceof PlacingGameState)
            state = new SlidingGameState();
        if (isOver())
            state = new OverState();
    }

    public Game putOAt(Position position) {
        putPlayerAt(O, position);
        return this;
    }

    public boolean isPlayingX() {
        return turnsList.get(turnIndex) == X;
    }

    public boolean isPlayingO() {
        return turnsList.get(turnIndex) == O;
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

    public void checkTurn(Player player) {
        if (turnsList.get(turnIndex) != player)
            throw new RuntimeException(notYourTurn);
        turnIndex = 1 - turnIndex;
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
