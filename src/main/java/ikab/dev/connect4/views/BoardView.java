package ikab.dev.connect4.views;


import ikab.dev.connect4.models.Coordinate;
import ikab.dev.connect4.models.Game;
import ikab.dev.utils.Console;

class BoardView {

    void write(Game game) {
        Message.HORIZONTAL_LINE.writeln();
        Message.HORIZONTAL_NUMBERS.writeln();
        for (int i = Coordinate.VERTICAL_DIMENSION - 1; i >= 0; i--) {
            Message.VERTICAL_LINE.write();
            for (int j = 0 ; j < Coordinate.HORIZONTAL_DIMENSION ; j++) {
                new ColorView().write(game.getColor(new Coordinate(i, j)));
                Message.VERTICAL_LINE.write();
            }
            Console.getInstance().writeln();
        }
        Message.HORIZONTAL_LINE.writeln();


    }

}
