package illipalinret;

import java.util.ArrayList;

public class Board {
    ArrayList<Piece> pieces;

    public void changePiecePosition(int pieceIndex, Position position){
        pieces[pieceIndex].changePosition(position);
    }

    public void addPiece(Player player, Piece piece){
        this.checkOccupiedPosition(piece.position);
        pieces[player.nextPieceIndex] = piece
    }

    public boolean checkOccupiedPosition(Position position){
        pieces.stream().reduce(False, (pieces) -> pieces.position == position);
    }
}