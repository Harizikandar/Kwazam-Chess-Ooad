package Assignment.Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.board.Board;
import model.board.GridSquare;
import model.piece.Piece;

/**
 * MouseController class that handles mouse interactions in the Kwazam Chess game.
 * Responsible for selecting, dragging, and moving pieces on the board.
 */
public class MouseController extends MouseAdapter {
    private final Board board; // Reference to the game board (model)
    private Piece selectedPiece; // The piece currently being dragged
    private boolean pressed; // Tracks whether the mouse is pressed
    private int squareSize = 80; // Size of each square on the board (adjustable)
    private int x, y; // Current mouse coordinates

    /**
     * Constructor for the MouseController.
     * @param board The game board (model) containing the grid and piece logic.
     */
    public MouseController(Board board) {
        this.board = board;
    }

    /**
     * Handles mouse press events.
     * Identifies the piece at the clicked position for dragging.
     * @param e The mouse event triggered by pressing the mouse button.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        pressed = true;

        // Convert pixel coordinates to grid coordinates
        int gridRow = y / squareSize;
        int gridCol = x / squareSize;

        // Check if a piece exists at the clicked position
        if (gridRow < board.getBoardRow() && gridCol < board.getBoardCol() && board.getGrid()[gridRow][gridCol].isOccupied()) {
            selectedPiece = board.getGrid()[gridRow][gridCol].getPiece();
            System.out.println("Selected piece: " + selectedPiece.getName());
        } else {
            System.out.println("No piece selected.");
            selectedPiece = null;
        }
    }

    /**
     * Handles mouse drag events.
     * Updates the position of the selected piece for visual feedback.
     * @param e The mouse event triggered by dragging the mouse.
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        if (pressed && selectedPiece != null) {
            x = e.getX();
            y = e.getY();

            // Optional: Update the view with real-time dragging visuals
            System.out.println("Dragging piece to: (" + x + ", " + y + ")");
        }
    }

    /**
     * Handles mouse release events.
     * Validates and finalizes the move of the selected piece.
     * @param e The mouse event triggered by releasing the mouse button.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        if (selectedPiece != null) {
            // Convert pixel coordinates to grid coordinates
            int gridRow = y / squareSize;
            int gridCol = x / squareSize;

            if (gridRow >= 0 && gridRow < board.getBoardRow() && gridCol >= 0 && gridCol < board.getBoardCol()) {
                GridSquare targetSquare = board.getGrid()[gridRow][gridCol];

                // Validate the move using the piece's move logic
                selectedPiece.setMoves(board.getGrid()[selectedPiece.getRow()][selectedPiece.getCol()], board.getGrid());
                if (selectedPiece.getMoves().contains(targetSquare)) {
                    // Perform the move
                    targetSquare.setPiece(selectedPiece, true);
                    board.getGrid()[selectedPiece.getRow()][selectedPiece.getCol()].setPiece(null, false);

                    // Update the board state
                    board.incrementCounter();
                    board.switchTeam();

                    System.out.println("Move successful!");
                } else {
                    System.out.println("Invalid move.");
                }
            }

            // Clear selected piece after the move is finalized
            selectedPiece = null;
        }
        pressed = false;
    }
}
