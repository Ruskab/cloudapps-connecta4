package ikab.dev.connect4.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Memento {

    private int activePlayer;
    private Map<Color, List<Coordinate>> boardColors;

    Memento(Board board, Turn turn) {
        Map<Color, List<Coordinate>> colorCoordinates = new HashMap<>();
        for (Map.Entry<Color, List<Coordinate>> colorListEntry : board.getColorCoordinates().entrySet()) {
            List<Coordinate> lista = new ArrayList<>();
            for (Coordinate coordinate : colorListEntry.getValue()) {
                lista.add(coordinate);
            }
            colorCoordinates.put(colorListEntry.getKey(), lista);
        }
        this.boardColors = colorCoordinates;

        this.activePlayer = turn.getActiveColor().ordinal();
    }

    Board getBoard() {
        Board board = new Board();
        for (Map.Entry<Color, List<Coordinate>> colorListEntry : boardColors.entrySet()) {
            for (Coordinate coordinate : colorListEntry.getValue()) {
                board.putToken(new Column(coordinate.getColumn()), colorListEntry.getKey());
            }
        }
        return board;
    }

    int getActivePlayer() {
        return this.activePlayer;
    }



}
