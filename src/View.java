import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View {
    private JFrame mainFrame;
    private JButton[][] buttons;
    private JLabel statusLabel;
    private JLabel scoreLabel;
    private JFrame loginFrame;
    private JButton resetScoreButton;

    public View() {
        createLoginWindow();
        createMainWindow();
    }

    private void createLoginWindow() {
        loginFrame = new JFrame("Login");
        loginFrame.setSize(400, 150);
        loginFrame.setLayout(new GridLayout(3, 2));

        JLabel userLabel = new JLabel("Username:");
        JTextField userText = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passText = new JPasswordField();
        JButton loginButton = new JButton("Login");

        loginFrame.add(userLabel);
        loginFrame.add(userText);
        loginFrame.add(passLabel);
        loginFrame.add(passText);
        loginFrame.add(new JLabel());
        loginFrame.add(loginButton);



        loginButton.addActionListener(e -> {
            String username = userText.getText();
            String password = new String(passText.getPassword());

            if (username.equals("20230657076@juniv.edu") && password.equals("657076")) {
                loginFrame.dispose();
                mainFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(loginFrame, "Invalid credentials!");
            }
        });
    }

    private void createMainWindow() {
        mainFrame = new JFrame("Tic Tac Toe");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 500);
        mainFrame.setLayout(new BorderLayout());

        // Score panel (keeping your existing score functionality)
        JPanel scorePanel = new JPanel(new BorderLayout());
        scoreLabel = new JLabel("X: 0 | O: 0", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        resetScoreButton = new JButton("Reset Scores");
        scorePanel.add(scoreLabel, BorderLayout.CENTER);
        scorePanel.add(resetScoreButton, BorderLayout.EAST);

        // Game board with your preferred colors
        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        //boardPanel.setBackground(new Color(240, 240, 240)); // Light gray background
        buttons = new JButton[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 60));

                // Set your preferred colors:
                buttons[i][j].setBackground(Color.BLACK); // White cell color
                buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); // Black grid lines
                buttons[i][j].setFocusPainted(false); // Remove focus border
                buttons[i][j].setContentAreaFilled(true);
                buttons[i][j].setOpaque(true);

                boardPanel.add(buttons[i][j]);
            }
        }

        statusLabel = new JLabel("Player X's turn", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 20));

        mainFrame.add(scorePanel, BorderLayout.NORTH);
        mainFrame.add(boardPanel, BorderLayout.CENTER);
        mainFrame.add(statusLabel, BorderLayout.SOUTH);
    }

    public void showLoginWindow() {
        loginFrame.setVisible(true);
    }

    public void setButtonText(int row, int col, String text) {
        buttons[row][col].setText(text);
    }

    public void setStatusText(String text) {
        statusLabel.setText(text);
    }

    public void addButtonListener(int row, int col, ActionListener listener) {
        buttons[row][col].addActionListener(listener);
    }

    public void addResetScoreListener(ActionListener listener) {
        resetScoreButton.addActionListener(listener);
    }

    public void showWinMessage(String winner) {
        JOptionPane.showMessageDialog(mainFrame, winner + " wins!");
    }

    public void showDrawMessage() {
        JOptionPane.showMessageDialog(mainFrame, "It's a draw!");
    }

    public void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
    }

    public void updateScores(int xScore, int oScore) {
        scoreLabel.setText("X: " + xScore + " | O: " + oScore);
    }
}