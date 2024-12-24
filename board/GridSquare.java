package model.board;

// to do: place piece + add piece !! + get team??

import model.piece.*;

/*
 * this class represents a singular square in the final
 * game board
 */
public class GridSquare {
    protected int row, col;
    protected boolean isOccupied;
    protected Piece piece;

    // 2 constructors, 1 for unoccupide squares
    public GridSquare (int row, int col){
        this.row = row;
        this.col = col;
        this.isOccupied = false;
        this.piece = null;
    }

    // a constructor for occupied squares
    public GridSquare (int row, int col, Piece piece){
        this.row = row;
        this.col = col;
        this.isOccupied = true;
        this.piece = piece;
    }

    //getters
    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public boolean isOccupied(){
        return isOccupied;
    }

    public Piece getPiece(){
        return piece;
    }

    //setters

    public void setRow(int row){
        this.row=row;
    }

    public void setCol(int col){
        this.col=col;
    }

    public void setOccupied(boolean occupied){
        this.isOccupied = occupied;
    }

    public void setPiece(Piece piece, boolean isOccupied){
        this.piece = piece;
        this.isOccupied = isOccupied;
    }

    //method to place pieces in the grid
    public void placePiece (String name, String team){
        //this.piece = addPiece(name, team);
        this.isOccupied = true;

    }

    //private Piece addPiece(String name, String team){
        //retrun piece;
    //}
}
