package illipalinret;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PLayerX extends Player {
    boolean movingPieces = false;
    Set<Position> positionSet = new HashSet<>();

    public PLayerX() {
    }

    public boolean isPlayingX() {
        return true;
    }

    public boolean isPlayingO() {
        throw new RuntimeException(Game.notYourTurn);
    }
}