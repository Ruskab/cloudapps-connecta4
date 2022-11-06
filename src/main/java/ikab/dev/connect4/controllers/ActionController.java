package ikab.dev.connect4.controllers;

import ikab.dev.connect4.models.Color;
import ikab.dev.connect4.models.Column;
import ikab.dev.connect4.models.Error;
import ikab.dev.connect4.models.Session;

public class ActionController extends Controller {

    public ActionController(Session session) {
        super(session);
    }

    public void next() {
        this.session.next();
    }

    public boolean isEndGame() {
        return this.session.isEndGame();
    }

    public Color getActiveColor() {
        return this.session.getActiveColor();
    }

    public Error getPutTokenError(Column column) {
        return this.session.getPutTokenError(column);
    }
    public void putToken(Column column) {
        this.session.putToken(column);
    }
}
