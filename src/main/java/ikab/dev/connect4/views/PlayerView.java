package ikab.dev.connect4.views;

import ikab.dev.connect4.models.Column;
import ikab.dev.connect4.models.Game;
import ikab.dev.connect4.models.Error;

class PlayerView {

    private Game game;

    PlayerView(Game game) {
        this.game = game;
    }

    void interact() {
        this.putToken();
        this.game.next();
    }

    private void putToken() {
        Error error;
        Column column;
        do {
            column = this.getColumn();
            error = this.getPutTokenError(column);
        } while (!error.isNull());
        this.game.putToken(column);
    }

    private Column getColumn() {
        ColumnView columnView = new ColumnView();
        return columnView.read(Message.ENTER_COLUMN_TO_PUT.toString());
    }

    private Error getPutTokenError(Column column) {
        assert column != null;

        Error error = this.game.getPutTokenError(column);
        new ErrorView().writeln(error);
        return error;
    }

}
