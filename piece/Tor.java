package model.piece;

import model.board.*;
import java.util.ArrayList;

/**
 * Represents the Tor piece in the Kwazam Chess game.
 * This piece moves orthogonally any number of squares but cannot skip over other pieces.
 */
public class Tor extends Piece {

    public Tor(String team) {
        super("Tor", team);
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

        // Calculate orthogonal moves
        calculateOrthogonalMoves(moves, grid, currentRow, currentCol, boardRow, boardCol);

        this.moves = moves;
    }

    // Helper method to calculate orthogonal moves
    private void calculateOrthogonalMoves(ArrayList<GridSquare> moves, GridSquare[][] grid,
                                          int currentRow, int currentCol, int boardRow, int boardCol) {
        // Move up
        for (int row = currentRow - 1; row >= 0; row--) {
            if (!addMoveIfValid(moves, grid[row][currentCol])) break;
        }

        // Move down
        for (int row = currentRow + 1; row < boardRow; row++) {
            if (!addMoveIfValid(moves, grid[row][currentCol])) break;
        }

        // Move left
        for (int col = currentCol - 1; col >= 0; col--) {
            if (!addMoveIfValid(moves, grid[currentRow][col])) break;
        }

        // Move right
        for (int col = currentCol + 1; col < boardCol; col++) {
            if (!addMoveIfValid(moves, grid[currentRow][col])) break;
        }
    }

    // Helper method to validate a move
    private boolean addMoveIfValid(ArrayList<GridSquare> moves, GridSquare targetSquare) {
        if (targetSquare.isOccupied()) {
            // Allow move if occupied by an opponent's piece, then stop
            if (!targetSquare.getPiece().getTeam().equals(this.getTeam())) {
                moves.add(targetSquare);
            }
            return false; // Stop further movement in this direction
        }
        moves.add(targetSquare);
        return true; // Continue checking further squares
    }

    @Override
    public ArrayList<GridSquare> getMoves() {
        return this.moves;
    }
}
