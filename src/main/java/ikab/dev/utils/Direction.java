package ikab.dev.utils;

import java.util.Arrays;
import java.util.List;

public enum Direction {

	VERTICAL(1, 0),
	HORIZONTAL(0, 1),
	MAIN_DIAGONAL(1, 1),
	INVERSE_DIAGONAL(-1, 1),
	NULL(0, 0);


	private int rowMove;

	private int columnMove;

	Direction(int row, int column) {
		this.rowMove = row;
		this.columnMove = column;
	}


	public boolean isNull() {
		return this == Direction.NULL;
	}


	public static List<Direction> getDirections() {
		return Arrays.stream(values()).filter(direction -> !direction.isNull()).toList();
	}

	public int getRowMove() {
		return rowMove;
	}

	public int getColumnMove() {
		return columnMove;
	}
}
