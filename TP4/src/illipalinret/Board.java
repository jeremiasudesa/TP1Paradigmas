package illipalinret;

import java.util.ArrayList;

public class Board {
    ArrayList<Piece> pieces;

    public void changePiecePosition(int pieceIndex, Position position){
        pieces[pieceIndex].changePosition(position);
    }

    public void addPiece(Player player, Piece piece){


    }
}