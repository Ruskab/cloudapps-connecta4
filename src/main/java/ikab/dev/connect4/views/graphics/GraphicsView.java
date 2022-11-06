package ikab.dev.connect4.views.graphics;


import ikab.dev.connect4.controllers.PlayController;
import ikab.dev.connect4.controllers.ResumeController;
import ikab.dev.connect4.controllers.StartController;
import ikab.dev.connect4.views.View;

public class GraphicsView implements View {

    public void visit(StartController startController) {
    }

    public void visit(PlayController playController) {
    }

    public boolean visit(ResumeController resumeController) {
        return true;
    }

}
