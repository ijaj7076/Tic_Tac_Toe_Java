public class Game {
    public boolean checkWin(Board board, char symbol) {
        char[][] grid = board.getGrid();

        // Check rows
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == symbol && grid[i][1] == symbol && grid[i][2] == symbol) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (grid[0][j] == symbol && grid[1][j] == symbol && grid[2][j] == symbol) {
                return true;
            }
        }

        // Check diagonals
        if (grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol) {
            return true;
        }

        if (grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol) {
            return true;
        }

        return false;
    }

    public void updateScores(Player winner, Player[] players) {
        if (winner != null) {
            winner.incrementScore();
        }
    }
}