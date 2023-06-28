package illipalinret;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PlayerO extends Player{
    boolean movingPieces = false;
    Set<Position> positionSet = new HashSet<>();

    public PlayerO() {
    }
    
    public boolean isPlayingO(){
        return true;
    }

    public boolean isPlayingX(){
        throw new RuntimeException(Game.notYourTurn);
    }
}
