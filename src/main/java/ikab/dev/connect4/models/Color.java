package ikab.dev.connect4.models;


import java.util.Arrays;
import java.util.List;

public enum Color {

	RED,
	YELLOW,
	NULL;


	public static Color get(int ordinal){
		assert ordinal >= 0 && ordinal < Color.NULL.ordinal();

		return Color.values()[ordinal];
	}

	public boolean isNull() {
		return this == Color.NULL;
	}

	public static List<Color> getPlayerColors() {
		return Arrays.stream(values()).filter(color -> !color.isNull()).toList();
	}
}
