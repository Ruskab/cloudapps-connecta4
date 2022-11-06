package ikab.dev.connect4.views.console;

import ikab.dev.connect4.controllers.PlayController;

class ActionCommand extends Command {

	ActionCommand(PlayController playController) {
		super(Message.ACTION_COMMAND.toString(), playController);
	}

	@Override
	public void execute() {
		new PlayerView(this.playController).interact();
 	   this.playController.next();
		super.execute();
	}

	@Override
	public boolean isActive() {
		return true;
	}

}
