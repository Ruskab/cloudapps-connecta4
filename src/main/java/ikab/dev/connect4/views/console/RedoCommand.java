package ikab.dev.connect4.views.console;

import ikab.dev.connect4.controllers.PlayController;

public class RedoCommand extends Command {
    public RedoCommand(PlayController playController) {
        super(Message.REDO_COMMAND.toString(), playController);
    }

    @Override
    public void execute() {
        this.playController.redo();
        super.execute();
    }

    @Override
    public boolean isActive() {
        return this.playController.redoable();
    }
}
