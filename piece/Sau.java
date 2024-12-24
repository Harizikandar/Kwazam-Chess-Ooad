package model.piece;

import model.board.*;
import java.util.ArrayList;

/**
 * Represents the Sau piece in the Kwazam Chess game.
 * This piece can move one step in any direction.
 */
public class Sau extends Piece {

    public Sau(String team) {
        super("Sau", team);
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

        // Define all possible one-step moves
        int[][] possibleOffsets = {
            {-1, 0}, {1, 0},  // Vertical moves (up, down)
            {0, -1}, {0, 1},  // Horizontal moves (left, right)
            {-1, -1}, {-1, 1}, // Diagonal moves (up-left, up-right)
            {1, -1}, {1, 1}   // Diagonal moves (down-left, down-right)
        };

        // Check each possible move
        for (int[] offset : possibleOffsets) {
            int newRow = currentRow + offset[0];
            int newCol = currentCol + offset[1];

            // Ensure the move is within the board boundaries
            if (newRow >= 0 && newRow < boardRow && newCol >= 0 && newCol < boardCol) {
                GridSquare targetSquare = grid[newRow][newCol];

                // Add the square to possible moves if it's empty or occupied by an opponent
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

