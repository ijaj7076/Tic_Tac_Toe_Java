import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private View view;
    private Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;

        setupButtonListeners();
        view.addResetScoreListener(e -> resetScores());
        updateView();
    }

    private void setupButtonListeners() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int row = i;
                int col = j;
                view.addButtonListener(i, j, e -> handleButtonClick(row, col));
            }
        }
    }

    private void handleButtonClick(int row, int col) {
        if (model.makeMove(row, col)) {
            view.setButtonText(row, col, String.valueOf(model.getCurrentPlayer().getSymbol()));

            if (model.checkWin()) {
                model.getGame().updateScores(model.getCurrentPlayer(), model.getPlayers());
                view.showWinMessage(model.getCurrentPlayer().getName());
                view.updateScores(
                        model.getPlayers()[0].getScore(),
                        model.getPlayers()[1].getScore()
                );
                model.resetGame();
                view.resetBoard();
            } else if (model.isBoardFull()) {
                view.showDrawMessage();
                model.resetGame();
                view.resetBoard();
            } else {
                model.switchPlayer();
                updateView();
            }
        }
    }

    private void resetScores() {
        model.resetScores();
        view.updateScores(0, 0);
    }

    private void updateView() {
        view.setStatusText(model.getCurrentPlayer().getName() + "'s turn");
    }
}