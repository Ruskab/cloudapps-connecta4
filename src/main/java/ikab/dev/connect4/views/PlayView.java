package ikab.dev.connect4.views;


import ikab.dev.connect4.models.Game;

class PlayView extends WithGameView {

    PlayView(Game game) {
        super(game);
    }

    void interact() {
        do {
            new PlayerView(this.game).interact();
            new BoardView().write(this.game);
        } while (!this.game.isEndGame());
        Message.PLAYER_WIN.writeln(this.game.getActiveColor().name());
    }

}
