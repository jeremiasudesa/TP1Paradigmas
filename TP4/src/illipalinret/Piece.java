package illipalinret;

public class Piece {
    public int row, column;
    public Char team;

    public Piece(int row_, int column_, Char team_){
        row = row_;
        column = column_;
        team = team_;
    }

    public void movePiece(int row_, int column_){
        row = row_;
        column = column_;
    }

}
