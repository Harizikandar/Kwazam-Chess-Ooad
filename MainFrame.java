import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private ChessBoardPanel chessBoardPanel;
    private JMenuBar menuBar;

    public MainFrame() {
        setTitle("Kwazam Chess");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        chessBoardPanel = new ChessBoardPanel();
        add(chessBoardPanel, BorderLayout.CENTER);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu gameMenu = new JMenu("Game");
        menuBar.add(gameMenu);

        JMenuItem newGameItem = new JMenuItem("New Game");
        gameMenu.add(newGameItem);

        JMenuItem saveGameItem = new JMenuItem("Save Game");
        gameMenu.add(saveGameItem);

        JMenuItem loadGameItem = new JMenuItem("Load Game");
        gameMenu.add(loadGameItem);

        JMenuItem exitItem = new JMenuItem("Exit");
        gameMenu.add(exitItem);
    }

    public ChessBoardPanel getChessBoardPanel() {
        return chessBoardPanel;
    }
}
