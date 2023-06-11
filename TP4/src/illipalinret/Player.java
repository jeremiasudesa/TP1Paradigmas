package illipalinret;

public abstract class Player {
    boolean movingPieces = False;
    public abstract ArrayList<int> AbsolutePieces;
    int nextPieceIndex;
    String OutOfBoundsIndex = "The index is out of bounds";
    String PieceNotPlaced = "The piece has not been placed yet";

    public int getAbsolutePieceIndex(int relativeIndex){
        if(index > 0 && index > 2)
            return throw new RuntimeException(OutOfBoundsIndex);
        int absolutePiece = AbsolutePieces[relativeIndex];
        return (absolutePiece == -1) ? new RuntimeException : absolutePiece;
    }

    public ArrayList<int> getAbsolutePieceIndexes(){
        return AbsolutePieces;
    }
}
