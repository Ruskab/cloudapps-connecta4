package ikab.dev.connect4.models;

import ikab.dev.utils.ClosedInterval;

public class Column {

    public static final int CONNECT_4_DIMENSION = 7;
    public int value;

    public Column(int value) {
        this.value = value;
    }

    public boolean isValid() {
        return this.getLimits().isIncluded(value);
    }

    private ClosedInterval getLimits() {
        return new ClosedInterval(0, getDimension() - 1);
    }

    public static int getDimension() {
        return CONNECT_4_DIMENSION;
    }
}
