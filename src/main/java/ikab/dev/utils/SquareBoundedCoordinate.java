package ikab.dev.utils;


public abstract class SquareBoundedCoordinate {

    private Coordinate adaptee;

    protected abstract int getHorizontalDimension();

    protected abstract int getVerticalDimension();


    public boolean isNull() {
        return this.adaptee.isNull();
    }

    public SquareBoundedCoordinate(int row, int column) {
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


    public int getRow() {
        assert !this.adaptee.isNull();

        return ((ConcreteCoordinate) this.adaptee).getRow();
    }

    public int getColumn() {
        assert !this.adaptee.isNull();

        return ((ConcreteCoordinate) this.adaptee).getColumn();
    }

}
