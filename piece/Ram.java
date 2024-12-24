package model.piece;

import model.board.*;
import java.util.ArrayList;

/**
 * Represents the Ram piece in the Kwazam Chess game.
 */
public class Ram extends Piece {

    private boolean movingForward;

    public Ram(String team) {
        super("Ram", team);
        this.movingForward = team.equals("blue") ; // blue moves up, red moves down initially
        //this.pieceImageName = team + "_" + name;
    }

    @Override
    public void setMoves(GridSquare currentSquare, GridSquare[][] grid) {
        ArrayList<GridSquare> moves = new ArrayList<>();
        Board board = new Board();

        int boardRow = board.getBoardRow();

        int currentRow = currentSquare.getRow();
        int currentCol = currentSquare.getCol();

        int nextRow = movingForward ? currentRow - 1 : currentRow + 1;

        if (nextRow >= 0 && nextRow < boardRow) {
            GridSquare targetSquare = grid[nextRow][currentCol];

            // Check if the target square is unoccupied
            if (!targetSquare.isOccupied()) {
               moves.add(targetSquare);
            }
        } else {
            // Reverse direction if the Ram reaches the end of the board
            movingForward = !movingForward;
        }

        this.moves = moves;
    }

    @Override
    public ArrayList<GridSquare> getMoves() {
        return this.moves;
    }
}
