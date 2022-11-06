package ikab.dev.connect4.controllers;

import ikab.dev.connect4.models.Color;
import ikab.dev.connect4.models.Column;
import ikab.dev.connect4.models.Error;
import ikab.dev.connect4.models.Session;

public class PlayController extends Controller implements AcceptorController {

    private ActionController actionController;
    private UndoController undoController;
    private RedoController redoController;

    public PlayController(Session session) {
        super(session);
        this.actionController = new ActionController(session);
        this.undoController = new UndoController(session);
        this.redoController = new RedoController(session);
        ;
    }

    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

    public void putToken(Column column) {
        this.actionController.putToken(column);
    }

    public Error getPutTokenError(Column column) {
        return this.actionController.getPutTokenError(column);
    }

    public void next() {
        this.actionController.next();
    }

    public boolean undoable() {
        return this.undoController.undoable();
    }

    public void redo(){
        this.redoController.redo();
    }

    public void undo() {
        this.undoController.undo();
    }

    public boolean redoable(){
        return this.redoController.redoable();
    }

    public boolean isEndGame() {
        return this.actionController.isEndGame();
    }

    public Color getActiveColor() {
        return this.actionController.getActiveColor();
    }
}
