package illipalinret;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Player {
    boolean movingPieces = false;
    Set<Position> positionSet = new HashSet<>();

    public Player() {
    }

    public void erasePosition(Position newPosition) {

        positionSet.remove(newPosition);
    }

    public void addPosition(Position newPosition) {

        positionSet.add(newPosition);

        if (positionSet.size() == 3) {
            movingPieces = true;
        }

    }

    public boolean containsPosition(Position position) {
        return positionSet.contains(position);
    }

    public void replacePosition(Position oldPosition, Position newPosition) {
        erasePosition(oldPosition);
        addPosition(newPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionSet);
    }

    @Override
    public boolean equals(Object object) {
        return ((object != null) && this.getClass() == object.getClass())
                && (this.positionSet.equals(((Player) object).positionSet));
    }

}
