package illipalinret;

import java.util.Objects;

class Position{
    public int row, col;
    public Position(int _row, int _col){
        row = _row;
        col = _col;
    }

	@Override
	public boolean equals(Object obj) {
		return this == obj ? true
				: obj == null || getClass() != obj.getClass() ? false
						: row == ((Position) obj).row && col == ((Position) obj).col;
	}

	public boolean lessThan(Position o){
		return row < o.row && col < o.col; 
	}

	@Override
	public int hashCode() {
		return Objects.hash(row, col);
	}

}

