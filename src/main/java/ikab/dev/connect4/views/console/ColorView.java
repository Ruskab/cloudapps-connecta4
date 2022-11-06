package ikab.dev.connect4.views.console;


import ikab.dev.connect4.models.Color;
import ikab.dev.utils.Console;

class ColorView {

    void write(Color color) {
        var string = switch (color) {
            case RED -> "°";
            case YELLOW -> "•";
            case NULL -> " ";
        };
        Console.getInstance().write(string);
    }
    
}
