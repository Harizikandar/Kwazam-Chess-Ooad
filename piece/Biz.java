package model.piece;

import model.board.*;
import java.util.ArrayList;

/**
 * Represents the Biz piece in the Kwazam Chess game.
 * This piece moves in an L-shape (3x2) in any orientation, similar to a knight in standard chess.
 * It can skip over other pieces.
 */
public class Biz extends Piece {

    public Biz(String team) {
        super("Biz", team);
    }

    @Override
    public void setMoves(GridSquare currentSquare, GridSquare[][] grid) {
        if (currentSquare == null || grid == null) {
            throw new IllegalArgumentException("Current square or grid cannot be null.");
        }

        ArrayList<GridSquare> moves = new ArrayList<>();
        int boardRow = grid.length;
        int boardCol = grid[0].length;

        int currentRow = currentSquare.getRow();
        int currentCol = currentSquare.getCol();

        // Define all possible L-shaped moves (3x2)
        int[][] possibleOffsets = {
            {-3, -2}, {-3, 2},
            {3, -2}, {3, 2},
            {-2, -3}, {-2, 3},
            {2, -3}, {2, 3}
        };

        // Check each possible move
        for (int[] offset : possibleOffsets) {
            int newRow = currentRow + offset[0];
            int newCol = currentCol + offset[1];

            // Ensure the move is within the board boundaries
            if (newRow >= 0 && newRow < boardRow && newCol >= 0 && newCol < boardCol) {
                GridSquare targetSquare = grid[newRow][newCol];

                // Add the square to possible moves (Biz can skip over pieces)
                if (!targetSquare.isOccupied() || !targetSquare.getPiece().getTeam().equals(this.getTeam())) {
                    moves.add(targetSquare);
                }
            }
        }

        this.moves = moves;
    }

    @Override
    public ArrayList<GridSquare> getMoves() {
        return this.moves;
    }
}

