package ikab.dev.connect4.views.console;


import ikab.dev.connect4.controllers.PlayController;

public class PlayView  {


    void interact(PlayController playController) {
        do {
            new PlayMenu(playController).execute();
        } while (!playController.isEndGame());
        Message.PLAYER_WIN.writeln(playController.getActiveColor().name());
        playController.nextState();
    }

}
