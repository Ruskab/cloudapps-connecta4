package ikab.dev.connect4.views.console;

import ikab.dev.connect4.controllers.PlayController;

public class UndoCommand extends Command {
    public UndoCommand(PlayController playController) {
        super(Message.UNDO_COMMAND.toString(), playController);
    }

    @Override
    public void execute() {
        this.playController.undo();
        super.execute();
    }

    @Override
    public boolean isActive() {
        return this.playController.undoable();
    }
}
