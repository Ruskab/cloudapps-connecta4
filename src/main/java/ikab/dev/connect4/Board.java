package ikab.dev.connect4;

import ikab.dev.utils.Console;
import ikab.dev.utils.Direction;

import java.util.*;
import java.util.stream.Collectors;

public class Board {

    private Map<Color, List<Coordinate>> colorCoordinates;

    public Board() {
        this.colorCoordinates = Map.of(
                Color.RED, new ArrayList<>(),
                Color.YELLOW, new ArrayList<>());
        this.reset();
    }

    public void write() {
        Message.HORIZONTAL_LINE.writeln();
        Message.HORIZONTAL_NUMBERS.writeln();
        for (int i = Coordinate.VERTICAL_DIMENSION - 1; i >= 0; i--) {
            Message.VERTICAL_LINE.write();
            for (int j = 0 ; j < Coordinate.HORIZONTAL_DIMENSION ; j++) {
                this.getColor(new Coordinate(i, j)).write();
                Message.VERTICAL_LINE.write();
            }
            Console.getInstance().writeln();
        }
        Message.HORIZONTAL_LINE.writeln();
    }

    private Color getColor(Coordinate coordinate) {
        assert !coordinate.isNull();

        if (colorCoordinates.get(Color.RED).contains(coordinate)) {
            return Color.RED;
        }
        if (colorCoordinates.get(Color.YELLOW).contains(coordinate)) {
            return Color.YELLOW;
        }
        return Color.NULL;
    }

    public void reset() {
        for (Color color : colorCoordinates.keySet()) {
            colorCoordinates.get(color).clear();
        }
    }

    public boolean isConnect4(Color color) {
        assert !color.isNull();
        List<Coordinate> colorCoordinates = this.colorCoordinates.get(color);
        if (colorCoordinates.size() < 4) {
            return false;
        }

        for (List<Direction> value : getAllNearDirections(colorCoordinates).stream().collect(Collectors.groupingBy(Enum::name)).values()) {
            if (value.size() == 3) {
                return true;
            }
        }
        return false;
    }

    private List<Direction> getAllNearDirections(List<Coordinate> colorCoordinates) {
        List<Direction> nearDirections = new ArrayList<>();
        for (Coordinate colorCoordinate : colorCoordinates) {
            for (Coordinate otherCoordinate : colorCoordinates) {
                Direction nearDirection = colorCoordinate.getNearDirection(otherCoordinate);
                if (!nearDirection.isNull()) {
                    nearDirections.add(nearDirection);
                }
            }
        }
        return nearDirections;
    }

    public boolean isFullColum(Column column) {
        Coordinate coordinate = new Coordinate(Coordinate.HORIZONTAL_DIMENSION - 1, column.value);
        return this.isOccupied(coordinate, Color.RED) || this.isOccupied(coordinate, Color.YELLOW);
    }

    private boolean isOccupied(Coordinate coordinate, Color color) {
        return this.getColor(coordinate) == color;
    }

    public void putToken(Column column, Color color) {
        assert !color.isNull();
        int row = getNextFreeRowBy(column);
        Coordinate coordinate = new Coordinate(row, column.value);
        this.colorCoordinates.get(color).add(coordinate);
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
}
