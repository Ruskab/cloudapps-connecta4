package ikab.dev.connect4.models;

import ikab.dev.utils.ClosedInterval;
import ikab.dev.utils.Direction;

import java.util.*;
import java.util.stream.IntStream;


public class Board {

    public static final int CONNECT_4_LINE_LIMIT = 4;

    private Map<Color, List<Coordinate>> colorCoordinates;


    public Board() {
        this.colorCoordinates = Map.of(
                Color.RED, new ArrayList<>(),
                Color.YELLOW, new ArrayList<>());
        this.reset();
    }

    public Color getColor(Coordinate coordinate) {
        assert !coordinate.isNull();

        for (Color color : Color.values()) {
            if (colorCoordinates.containsKey(color) && colorCoordinates.get(color).contains(coordinate)) {
                return color;
            }
        }
        return Color.NULL;
    }

    public void putToken(Column column, Color color) {
        assert !color.isNull();
        int row = getNextFreeRowBy(column);
        Coordinate coordinate = new Coordinate(row, column.value);
        this.colorCoordinates.get(color).add(coordinate);
    }

    public void reset() {
        for (Color color : colorCoordinates.keySet()) {
            colorCoordinates.get(color).clear();
        }
    }

    public boolean isFullColum(Column column) {
        Coordinate coordinate = new Coordinate(Coordinate.VERTICAL_DIMENSION - 1, column.value);
        return !this.isOccupied(coordinate, Color.NULL);
    }

    private boolean isOccupied(Coordinate coordinate, Color color) {
        return this.getColor(coordinate) == color;
    }

    public boolean isInsideBoard(Column column) {
        return new ClosedInterval(0, Coordinate.HORIZONTAL_DIMENSION - 1).isIncluded(column.value);
    }

    public boolean isInsideBoard(Coordinate coordinate) {
        return new ClosedInterval(0, Coordinate.HORIZONTAL_DIMENSION - 1).isIncluded(coordinate.getRow()) && new ClosedInterval(0, Coordinate.VERTICAL_DIMENSION - 1).isIncluded(coordinate.getColumn());
    }

    public boolean isEndGame() {
        return this.isTie() || this.isConnect4();
    }

    public boolean isTie() {
        return !this.isConnect4() && IntStream.range(0, Column.getDimension()).allMatch(i -> isFullColum(new Column(i)));
    }

    private boolean isConnect4() {
        return Color.getPlayerColors().stream().anyMatch(this::isConnect4);
    }

    public boolean isConnect4(Color color) {
        assert !color.isNull();

        List<Coordinate> colorCoordinates = this.colorCoordinates.get(color);
        for (Coordinate coordinate : colorCoordinates) {
            for (Direction direction : Direction.getDirections()) {
                if (is4CoordinatesInLine(coordinate, direction)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean is4CoordinatesInLine(Coordinate coordinate, Direction direction) {
        return IntStream.range(1, CONNECT_4_LINE_LIMIT).allMatch(i -> {
            var otherCoordinate = new Coordinate(coordinate.getRow() + (i * direction.getRowMove()), coordinate.getColumn() + (i * direction.getColumnMove()));
            return isConnected(coordinate, otherCoordinate);
        });
    }

    private boolean isConnected(Coordinate coordinate, Coordinate otherCoordinate) {
        if (!this.isInsideBoard(otherCoordinate)) {
            return false;
        }
        return this.getColor(coordinate) == this.getColor(otherCoordinate);
    }


    private int getNextFreeRowBy(Column column) {
        return getHighestCoordinateInColumn(column)
                .map(coordinate -> coordinate.getRow() + 1)
                .orElse(0);
    }
    private Optional<Coordinate> getHighestCoordinateInColumn(Column column) {
        return getFilledCoordinatesInColumn(column).stream().max(Comparator.comparing(Coordinate::getRow));
    }

    private List<Coordinate> getFilledCoordinatesInColumn(Column column) {
        List<Coordinate> columnCoordinates = new ArrayList<>();
        for (List<Coordinate> coordinates : colorCoordinates.values()) {
            for (Coordinate coordinate : coordinates) {
                if (coordinate.getColumn() == column.value) {
                    columnCoordinates.add(coordinate);
                }
            }
        }
        return columnCoordinates;
    }

    public Map<Color, List<Coordinate>> getColorCoordinates() {
        return colorCoordinates;
    }

}
