package illipalinret;

public class Game {
    Board board;
    Player X;
    Player O;
    String playerHasPiecesLeftError = "The player has unplaced pieces";
    String playerHasPutAllItsPieces = 'player has put all its pieces!!'
    
    public void movePiecePlayer(Player player, int pieceIndex, Position position){
        if(!player.movingPieces)
            return throw new RuntimeException(playerHasPiecesLeftError)
        board.changePiecePosition(player.getAbsolutePieceIndex(pieceIndex), position);
        if(board.checkWin(player.getPieceIndexes))
            playerWon(player);
    }

    public void movePieceX(int pieceIndex, Position position){
        movePiecePlayer(X, pieceIndex, position);
    }
    
    public void movePieceY(int pieceIndex, Position position){
        movePiecePlayer(Y, pieceIndex, position);
    }

    public void putXat(Position position){
        // me fijo que x no haya puesto todo
        if(player.movingPieces){
            return throw new RuntimeException(playerHasPutAllItsPieces);
        }
        // creo una piece y la agrego a board
        board.addPiece(X, Piece(position));
        // sumo el next index del player x
        X.increaseIndex();
    }
    
    private playerWon(Player player){
        //actualizar informacion
    }
}
