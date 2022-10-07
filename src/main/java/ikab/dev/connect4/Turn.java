package ikab.dev.connect4;

public class Turn {

    private Board board;

    private static final int NUMBER_PLAYERS = 2;

    private Player[] players;

    private int activePlayer;

    public Turn(Board board) {
        assert board != null;
        this.board = board;
        this.players = new Player[Turn.NUMBER_PLAYERS];
        this.reset();
    }

    public void play() {
        this.players[this.activePlayer].play();
        if (!this.board.isConnect4(this.getActiveColor())){
            toggleActivePlayer();
        }

    }

    private void toggleActivePlayer() {
        this.activePlayer = (this.activePlayer+1) % Turn.NUMBER_PLAYERS;
    }

    public Color getActiveColor() {
        return this.players[this.activePlayer].getColor();
    }

    public void writeWinner() {
        this.players[this.activePlayer].writeWinner();
    }

    public void reset() {
        for (int i = 0; i < NUMBER_PLAYERS; i++) {
            this.players[i] = new Player(Color.get(i), this.board);
        }
        this.activePlayer = 0;
    }
}
