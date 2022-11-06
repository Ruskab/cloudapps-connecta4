package ikab.dev.connect4.views.console;

import ikab.dev.connect4.controllers.PlayController;
import ikab.dev.utils.views.Menu;


class PlayMenu extends Menu {

    PlayMenu(PlayController playController) {
        this.addCommand(new ActionCommand(playController));
        this.addCommand(new UndoCommand(playController));
        this.addCommand(new RedoCommand(playController));
    }

}
