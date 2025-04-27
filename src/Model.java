public class Model {
    private Board board;
    private Game game;
    private Player[] players;
    private int currentPlayerIndex;

    public Model() {
        this.board = new Board();
        this.players = new Player[2];
        this.players[0] = new Player("Player X", 'X');
        this.players[1] = new Player("Player O", 'O');
        this.currentPlayerIndex = 0;
        this.game = new Game();
    }

    public Board getBoard() { return board; }
    public Player getCurrentPlayer() { return players[currentPlayerIndex]; }
    public Player[] getPlayers() { return players; }
    public Game getGame() { return game; }

    public void switchPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % 2;
    }

    public boolean makeMove(int row, int col) {
        if (board.isCellEmpty(row, col)) {
            board.setCell(row, col, getCurrentPlayer().getSymbol());
            return true;
        }
        return false;
    }

    public boolean checkWin() {
        return game.checkWin(board, getCurrentPlayer().getSymbol());
    }

    public boolean isBoardFull() {
        return board.isFull();
    }

    public void resetGame() {
        board.reset();
    }

    public void resetScores() {
        for (Player player : players) {
            player.resetScore();
        }
    }
}