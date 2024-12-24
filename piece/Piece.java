package model.piece;

// to do: add image??
import model.board.*;

import java.util.ArrayList;
/**
 * Abstarct base class for all pieces in the game to inherit from
 * Represents a generic chess piece in the Kwazam Chess game.
 * unique movements will be implemented in each piece.
 */

public abstract class Piece {
    protected String name;
    protected String team; // "blue" or "red"
    protected ArrayList<GridSquare> moves;
    /**
     * Constructor to initialize a piece
     * including: name, team..?
     */
    public Piece(String name, String team) {
        this.name = name;
        this.team = team;
    }

    // Getters
    public String getTeam() {
        return team;
    }

    public String getName() {
        return name;
    }

    // Setters
    public void setTeam(String team) {
        this.team = team;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void setMoves(GridSquare currentSquare, GridSquare[][] grid);

    public abstract ArrayList<GridSquare> getMoves();



}
