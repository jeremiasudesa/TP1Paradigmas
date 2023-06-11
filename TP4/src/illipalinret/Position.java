package illipalinret;

class Position{
    public int row, col;
    Position(int _row, int _col){
        row = _row;
        col = _col;
    }

@Override
public boolean equals(Object obj) { return this == obj ? true : obj == null || getClass() != obj.getClass() ? false : row == ((Position)obj).row && col == ((Position)obj).col; }

}