package ikab.dev.connect4;


public class Player {

    private final Color color;
    private final Board board;

    public Player(Color color, Board board) {
        assert !color.isNull();
        assert board != null;

        this.color = color;
        this.board = board;
    }

    public void play() {
        this.putToken();
    }

    private void putToken() {
        Error error;
        Column column;
        do {
            column = this.getColumn(Message.ENTER_COLUMN_TO_PUT);
            error = this.getPutTokenError(column);
        } while (!error.isNull());
        this.board.putToken(column, this.color);
    }

    private Column getColumn(Message message) {
        assert message != null;

        Column column = new Column();
        column.read(message.toString());
        return column;
    }

    private Error getPutTokenError(Column column) {
        assert column != null;

        Error error = Error.NULL;
        if (this.board.isFullColum(column)) {
            error = Error.NOT_EMPTY;
        }
        error.writeln();
        return error;
    }

    public Color getColor() {
        return this.color;
    }

    public void writeWinner() {
        Message.PLAYER_WIN.writeln(this.color.name());
    }
}
