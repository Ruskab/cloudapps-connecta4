package ikab.dev.connect4.models;

import ikab.dev.utils.Direction;

import java.util.stream.IntStream;

public class BoardLine {
    public static final int CONNECT_4_LINE_LIMIT = 4;
    private final Board board;
    private final Direction direction;
    private final Coordinate coordinate;

    public BoardLine(Direction direction, Coordinate coordinate, Board board) {
        this.board = board;
        this.direction = direction;
        this.coordinate = coordinate;
    }

    public boolean has4Connect() {
        return switch (direction) {
            case VERTICAL -> is4VerticalLine(coordinate);
            case HORIZONTAL -> isHorizontalLine(coordinate);
            case MAIN_DIAGONAL -> isMainDiagonal(coordinate);
            case INVERSE_DIAGONAL -> isInverseDiagonal(coordinate);
            case NULL -> false;
        };
    }

    private boolean isInverseDiagonal(Coordinate coordinate) {
        return IntStream.range(1, CONNECT_4_LINE_LIMIT).allMatch(i -> isConnected(coordinate, new Coordinate(coordinate.getRow() - i, coordinate.getColumn() + i)));
    }

    private boolean isMainDiagonal(Coordinate coordinate) {
        return IntStream.range(1, CONNECT_4_LINE_LIMIT).allMatch(i -> isConnected(coordinate, new Coordinate(coordinate.getRow() + i, coordinate.getColumn() + i)));
    }

    private boolean is4VerticalLine(Coordinate coordinate) {
        return IntStream.range(1, CONNECT_4_LINE_LIMIT).allMatch(i -> isConnected(coordinate, new Coordinate(coordinate.getRow() + i, coordinate.getColumn())));
    }

    private boolean isHorizontalLine(Coordinate coordinate) {
        return IntStream.range(1, CONNECT_4_LINE_LIMIT).allMatch(i -> isConnected(coordinate, new Coordinate(coordinate.getRow(), coordinate.getColumn() + i)));
    }

    private boolean isConnected(Coordinate coordinate, Coordinate otherCoordinate) {
        if (!board.isInsideBoard(otherCoordinate)) {
            return false;
        }
        return board.getColor(coordinate) == board.getColor(otherCoordinate);
    }
}