package ikab.dev.connect4.views.console;


import ikab.dev.connect4.models.Column;
import ikab.dev.connect4.models.Error;
import ikab.dev.utils.Console;

public class ColumnView {

    private static final String COLUMN = "Column: ";
    public Column read(String message) {
        assert message != null;

        boolean error;
        Column column;
        do {
            Console console = Console.getInstance();
            console.writeln(message);
            var input = console.readInt(COLUMN) - 1;
            column = new Column(input);
            error = !column.isValid();
            if (error) {
                Console.getInstance().writeln(this.getErrorMessage());
            }
        } while (error);
        return column;
    }

    private String getErrorMessage() {
        return Error.WRONG_COORDINATES.toString();
    }

}
