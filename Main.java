public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Board board = new Board();
            MainFrame mainFrame = new MainFrame();
            new ChessGameController(board, mainFrame.getChessBoardPanel());
            mainFrame.setVisible(true);
        });
    }
}
