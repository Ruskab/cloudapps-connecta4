package ikab.dev.connect4.models;


import ikab.dev.utils.SquareBoundedCoordinate;

public class Coordinate extends SquareBoundedCoordinate {

    public static final int HORIZONTAL_DIMENSION = 7;
    public static final int VERTICAL_DIMENSION = 6;

    public Coordinate(int row, int column) {
        super(row, column);
    }

    @Override
    protected int getHorizontalDimension() {
        return HORIZONTAL_DIMENSION;
    }

    @Override
    protected int getVerticalDimension() {
        return VERTICAL_DIMENSION;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordinate other = (Coordinate) obj;
        if (!other.isNull()) {
            if (this.getRow() != other.getRow())
                return false;
          return this.getColumn() == other.getColumn();
        }
        return true;
    }

}
