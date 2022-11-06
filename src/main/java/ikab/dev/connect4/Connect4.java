package ikab.dev.connect4;

import ikab.dev.connect4.controllers.AcceptorController;
import ikab.dev.connect4.controllers.Logic;
import ikab.dev.connect4.views.View;

 abstract class Connect4 {

    private View view;

    private Logic logic;

    Connect4() {
        this.logic = new Logic();
        this.view = this.createView();
    }

    protected abstract View createView();

     protected void play() {
         AcceptorController acceptorController;
         do {
             acceptorController = logic.getController();
             if (acceptorController != null)
                 acceptorController.accept(this.view);
         } while (acceptorController != null);
     }

}
