package ikab.dev.connect4.models;


public enum Error {
	NOT_EMPTY,
	WRONG_COORDINATES,
	WRONG_COLUMN,
	NULL;


	Error(){
	}

	public boolean isNull() {
		return this == Error.NULL;
	}

}
