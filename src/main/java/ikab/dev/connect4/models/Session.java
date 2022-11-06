package ikab.dev.connect4.models;

public class Session {

    private State state;
    private Game game;
    private Registry registry;

    public Session() {
        this.state = new State();
        this.game = new Game();
        this.registry = new Registry(game);
    }


    public void reset() {
        this.game.reset();
        this.state.reset();
        this.registry.reset();
    }

    public void next() {
        this.game.next();
        this.registry.register();
    }

    public void nextState() {
        this.state.next();
    }

    public Color getColor(Coordinate coordinate) {
        return this.game.getColor(coordinate);
    }

    public void putToken(Column column) {
        this.game.putToken(column);
    }

    public StateValue getValueState() {
        return this.state.getValueState();
    }

    public void undo() {
        this.registry.undo();
    }

    public boolean undoable() {
        return this.registry.undoable();
    }

    public void redo() {
        this.registry.redo();
    }

    public boolean redoable() {
        return this.registry.redoable();
    }

    public boolean isEndGame() {
        return this.game.isEndGame();
    }

    public Color getActiveColor() {
        return this.game.getActiveColor();
    }

    public Error getPutTokenError(Column column) {
        return this.game.getPutTokenError(column);
    }
}
