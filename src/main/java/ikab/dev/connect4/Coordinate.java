package ikab.dev.connect4;


import ikab.dev.utils.RectangularBoundedCoordinate;

class Coordinate extends RectangularBoundedCoordinate {

    public static final int HORIZONTAL_DIMENSION = 7;
    public static final int VERTICAL_DIMENSION = 6;

    Coordinate(int row, int column) {
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
    protected String getErrorMessage() {
        return Error.WRONG_COORDINATES.toString();
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
