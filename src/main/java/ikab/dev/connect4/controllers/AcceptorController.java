package ikab.dev.connect4.controllers;

import ikab.dev.connect4.views.View;

public interface AcceptorController {
    public void accept(ControllersVisitor controllerVisitor);
}
