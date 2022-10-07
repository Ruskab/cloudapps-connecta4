package ikab.dev.utils;

import java.util.Random;

public abstract class RectangularBoundedCoordinate {

    private Coordinate adaptee;

    protected abstract int getHorizontalDimension();

    protected abstract int getVerticalDimension();

    public RectangularBoundedCoordinate() {
        this.adaptee = NullCoordinate.getInstance();
    }

    public boolean isNull() {
        return this.adaptee.isNull();
    }

    public RectangularBoundedCoordinate(int row, int column) {
        this.adaptee = new ConcreteCoordinate(row, column);
        assert this.isValid();
    }

    private boolean isValid() {
        assert !this.adaptee.isNull();

        ConcreteCoordinate concreteCoordinate = (ConcreteCoordinate) this.adaptee;
        return this.getHorizontalLimits().isIncluded(concreteCoordinate.getRow())
                && this.getVerticalLimits().isIncluded(concreteCoordinate.getColumn());
    }

    protected ClosedInterval getHorizontalLimits() {
        return new ClosedInterval(0, this.getHorizontalDimension() - 1);
    }

    protected ClosedInterval getVerticalLimits() {
        return new ClosedInterval(0, this.getVerticalDimension() - 1);
    }

    public Direction getNearDirection(RectangularBoundedCoordinate coordinate) {
        if (this.equals(coordinate) || this.isNull() || coordinate.isNull()) {
            return Direction.NULL;
        }
        if (this.inInverseDiagonal(coordinate)) {
            return Direction.INVERSE_DIAGONAL;
        }
        return this.adaptee.getNearDirection(coordinate.adaptee);
    }

    private boolean inInverseDiagonal(RectangularBoundedCoordinate coordinate) {
        //TODO
        return false;
    }

    public void read(String message) {
        assert message != null;

        this.adaptee = new ConcreteCoordinate();
        ConcreteCoordinate coordinate = (ConcreteCoordinate) this.adaptee;
        boolean error;
        do {
            coordinate.read(message);
            error = !this.isValid();
            if (error) {
                Console.getInstance().writeln(this.getErrorMessage());
            }
        } while (error);
    }

    protected abstract String getErrorMessage();

    public void random() {
        Random random = new Random(System.currentTimeMillis());
        this.adaptee = new ConcreteCoordinate(random.nextInt(this.getHorizontalDimension()), random.nextInt(this.getVerticalDimension()));
    }

    public int getRow() {
        assert !this.adaptee.isNull();

        return ((ConcreteCoordinate) this.adaptee).getRow();
    }

    public int getColumn() {
        assert !this.adaptee.isNull();

        return ((ConcreteCoordinate) this.adaptee).getColumn();
    }

}
