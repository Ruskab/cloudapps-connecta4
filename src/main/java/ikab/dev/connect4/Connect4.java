package ikab.dev.connect4;


import ikab.dev.utils.YesNoDialog;

public class Connect4 {

    private Board board;
    private Turn turn;

    public Connect4() {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    private void play() {
        do {
            this.playGame();
        } while (this.isResumeGame());
    }

    private void playGame() {
        Message.TITLE.writeln();
        this.board.write();
        do {
            this.turn.play();
            this.board.write();
        } while (!this.isConnect4());
        this.turn.writeWinner();
    }

    private boolean isConnect4() {
        return board.isConnect4(this.turn.getActiveColor());
    }

    private boolean isResumeGame() {
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(Message.RESUME.toString());
        if (yesNoDialog.isAffirmative()) {
            this.board.reset();
            this.turn.reset();
        }
        return yesNoDialog.isAffirmative();
    }


    public static void main(String... args) {
        new Connect4().play();
    }
}

