package ikab.dev.connect4.views.console;


import ikab.dev.utils.Console;

public enum Message {
	TITLE("--- CONNECT 4 ---"),
	RESUME("Do you want to continue"),
	HORIZONTAL_LINE("---------------"),
	HORIZONTAL_NUMBERS("---1---2---3---4---5---6---7---"),
	VERTICAL_LINE(" | "),
	ENTER_COLUMN_TO_PUT("Enter a column to put a token:"),
	COORDINATE_TO_PUT("Coordinate to put"),
	COORDINATE_TO_REMOVE("Origin coordinate to move"),
	COORDINATE_TO_MOVE("Target coordinate to move"),
	PLAYER_WIN("#player player: You win!!! :-)"),
	ACTION_COMMAND("Do a action"), UNDO_COMMAND("Undo previous action"), REDO_COMMAND("Redo previous action");

	private String message;

	Message(String message) {
		this.message = message;
	}

	public void write() {
		Console.getInstance().write(this.message);
	}

	public void writeln() {
		Console.getInstance().writeln(this.message);
	}

	void writeln(String player) {
		assert this == Message.PLAYER_WIN;
		
		Console.getInstance().writeln(this.message.replaceAll("#player", "" + player));
	}

	@Override
	public String toString() {
		return message;
	}
}
