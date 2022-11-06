package ikab.dev.connect4.views.console;

import ikab.dev.connect4.controllers.PlayController;
import ikab.dev.connect4.models.Column;
import ikab.dev.connect4.models.Game;
import ikab.dev.connect4.models.Error;

class PlayerView {

    private PlayController playController;

    PlayerView(PlayController playController) {
        this.playController = playController;
    }

    void interact() {
        this.putToken();
    }

    private void putToken() {
        Error error;
        Column column;
        do {
            column = this.getColumn();
            error = this.getPutTokenError(column);
        } while (!error.isNull());
        this.playController.putToken(column);
    }

    private Column getColumn() {
        ColumnView columnView = new ColumnView();
        return columnView.read(Message.ENTER_COLUMN_TO_PUT.toString());
    }

    private Error getPutTokenError(Column column) {
        assert column != null;

        Error error = this.playController.getPutTokenError(column);
        new ErrorView().writeln(error);
        return error;
    }

}
