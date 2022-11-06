package ikab.dev.connect4.views.console;

import ikab.dev.connect4.controllers.ResumeController;
import ikab.dev.connect4.views.console.Message;
import ikab.dev.utils.YesNoDialog;

public class ResumeView  {

    boolean interact(ResumeController resumeController) {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Message.RESUME.toString());
        if (isResumed.isAffirmative()) {
            resumeController.reset();
        } else {
            resumeController.nextState();
        }
        return isResumed.isAffirmative();
    }

}
