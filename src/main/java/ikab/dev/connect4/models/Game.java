package ikab.dev.connect4.models;



public class Game {

    private Board board;
    private Turn turn;

    public Game() {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    public void reset() {
        this.board.reset();
        this.turn.reset();
    }

    public Color getActiveColor() {
        return this.turn.getActiveColor();
    }

    public boolean isEndGame() {
        return this.board.isEndGame();
    }

    public Color getColor(Coordinate coordinate) {
        return this.board.getColor(coordinate);
    }

    public void putToken(Column column) {
        this.turn.putToken(column);
    }

    public Error getPutTokenError(Column column) {
        return this.turn.getPutTokenError(column);
    }

    public void next() {
        this.turn.next();
    }



}

