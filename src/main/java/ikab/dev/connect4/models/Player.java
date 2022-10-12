package ikab.dev.connect4.models;



public class Player {

    private final Color color;
    private final Board board;

    public Player(Color color, Board board) {
        assert !color.isNull();
        assert board != null;

        this.color = color;
        this.board = board;
    }

    public void putToken(Column column) {
        this.board.putToken(column, this.color);
    }


    public Error getPutTokenError(Column column) {
        assert column != null;

        if (!this.board.isInsideBoard(column)) {
            return Error.WRONG_COLUMN;
        }

        if (this.board.isFullColum(column)) {
            return Error.NOT_EMPTY;
        }
        return Error.NULL;
    }

    public Color getColor() {
        return this.color;
    }

}
