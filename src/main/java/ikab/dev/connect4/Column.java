package ikab.dev.connect4;

import ikab.dev.utils.Console;

public class Column {

    private static final String COLUMN = "Column: ";
    public int value;
    public void read(String message) {
        assert message != null;

        boolean error;
        do {
            Console console = Console.getInstance();
            console.writeln(message);
            this.value = console.readInt(Column.COLUMN) - 1;
            error = !this.isValid();
            if (error) {
                Console.getInstance().writeln(this.getErrorMessage());
            }
        } while (error);
    }

    private String getErrorMessage() {
        return Error.WRONG_COORDINATES.toString();
    }

    private boolean isValid() {
        return true;
    }
}
