package ikab.dev.connect4.views;


import ikab.dev.connect4.models.Game;

abstract class WithGameView {

    protected Game game;

    WithGameView(Game game) {
        this.game = game;
    }
    
}
