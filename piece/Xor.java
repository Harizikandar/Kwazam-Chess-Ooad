package model.piece;

import model.board.*;
import java.util.ArrayList;

/**
 * Represents the Xor piece in the Kwazam Chess game.
 * This piece can move diagonally any distance but cannot skip over other pieces.
 */
public class Xor extends Piece {

    public Xor(String team) {
        super("Xor", team);
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

        // Check all four diagonal directions
        addMovesInDirection(moves, grid, currentRow, currentCol, -1, -1, boardRow, boardCol); // Up-left
        addMovesInDirection(moves, grid, currentRow, currentCol, -1, 1, boardRow, boardCol);  // Up-right
        addMovesInDirection(moves, grid, currentRow, currentCol, 1, -1, boardRow, boardCol);  // Down-left
        addMovesInDirection(moves, grid, currentRow, currentCol, 1, 1, boardRow, boardCol);   // Down-right

        this.moves = moves;
    }

    private void addMovesInDirection(ArrayList<GridSquare> moves, GridSquare[][] grid, int startRow, int startCol,
                                     int rowDir, int colDir, int boardRow, int boardCol) {
        int currentRow = startRow;
        int currentCol = startCol;

        while (true) {
            currentRow += rowDir;
            currentCol += colDir;

            // Check if the new position is within bounds
            if (currentRow < 0 || currentRow >= boardRow || currentCol < 0 || currentCol >= boardCol) {
                break;
            }

            GridSquare targetSquare = grid[currentRow][currentCol];

            // If the square is unoccupied, it's a valid move
            if (!targetSquare.isOccupied()) {
                moves.add(targetSquare);
            } else {
                // If the square is occupied by an opponent, it's a valid move, but stop further movement
                if (!targetSquare.getPiece().getTeam().equals(this.getTeam())) {
                    moves.add(targetSquare);
                }
                break;
            }
        }
    }

    @Override
    public ArrayList<GridSquare> getMoves() {
        return this.moves;
    }
}

