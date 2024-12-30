import javax.swing.*;
import java.awt.*;

public class ChessBoardPanel extends JPanel {
    private JButton[][] buttons = new JButton[5][8];

    public ChessBoardPanel() {
        setLayout(new GridLayout(5, 8));
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 8; col++) {
                buttons[row][col] = new JButton();
                buttons[row][col].setPreferredSize(new Dimension(80, 80));
                add(buttons[row][col]);
            }
        }
    }

    public JButton getButton(int row, int col) {
        return buttons[row][col];
    }

    public void updateBoard(Board board) {
        // Logic to update the board UI based on the Board model
    }
}
