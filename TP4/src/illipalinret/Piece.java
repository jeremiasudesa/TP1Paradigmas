package illipalinret;

public abtract class Piece {
    public Position position;
    public Char team;

    public Piece(Position newPosition){
        position = newPosition;
    }

    public void movePiece(Position newPosition){
        position = newPosition;
    }

}
