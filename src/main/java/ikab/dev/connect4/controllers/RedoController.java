package ikab.dev.connect4.controllers;

import ikab.dev.connect4.models.Session;

public class RedoController extends Controller {
    RedoController(Session session) {
        super(session);
    }

    void redo() {
        this.session.redo();
    }

    boolean redoable() {
        return this.session.redoable();
    }
}
