package ikab.dev.connect4.views.console;


import ikab.dev.connect4.controllers.PlayController;

public abstract class Command extends ikab.dev.utils.models.Command {

	protected PlayController playController;

	protected Command(String title, PlayController playController) {
		super(title);
		this.playController = playController;
	}

	@Override
	public void execute() {
		new BoardView().write(this.playController);
	}
	
}
