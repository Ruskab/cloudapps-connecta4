package ikab.dev.connect4;


import ikab.dev.utils.Console;

enum Error {

	NOT_EMPTY("The square is not empty"),
	WRONG_COORDINATES("The coordinates are wrong"),
	WRONG_COLUMN("The column is wrong"),
	NULL;

	private String message;

	Error(){
	}

	Error(String message){
		this.message = message;
	}

	void writeln() {
		if (!this.isNull()) {
			Console.getInstance().writeln(this.message);
		}
	}

	public boolean isNull() {
		return this == Error.NULL;
	}

}
