package ikab.dev.connect4.views;

import ikab.dev.connect4.models.Error;
import ikab.dev.utils.Console;

public class ErrorView {

    public void writeln(Error error) {
        if (!error.isNull()) {
            var errorMessage = switch (error) {
                case NOT_EMPTY -> "not empty";
                case WRONG_COORDINATES -> "wrong coordinates:";
                case WRONG_COLUMN -> "wrong column";
                case NULL -> "no error";
            };
            Console.getInstance().writeln(errorMessage);
        }
    }

}
