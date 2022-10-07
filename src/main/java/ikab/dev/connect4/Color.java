package ikab.dev.connect4;


import ikab.dev.utils.Console;

enum Color {

	RED("°"),
	YELLOW("•"),
	NULL(" ");

	private String display;

	Color(String display) {

		this.display = display;
	}

	static Color get(int ordinal){
		assert ordinal >= 0 && ordinal < Color.NULL.ordinal();

		return Color.values()[ordinal];
	}

	void write() {
		String string = this.display;
		if (this.isNull()) {
			string = " ";
		}
		Console.getInstance().write(string);
	}

	boolean isNull() {
		return this == Color.NULL;
	}
}
