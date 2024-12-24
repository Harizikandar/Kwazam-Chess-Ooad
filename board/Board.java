package model.board;

import model.piece.*;

/**
 * Represents the game board for Kwazam Chess.
 */
public class Board {
    private static final int COLS = 5;
    private static final int ROWS = 8;
    private int counter = 0;
    private final GridSquare[][] grid;
    private String currentTeam;


    //Constructor to initialize the 5x8 board.
    public Board() {
        grid = new GridSquare[ROWS][COLS];
        resetBoard();
        currentTeam = "blue";
    }

    public String getCurrenTeam() {
        return currentTeam;
    }

    public int getBoardRow(){
        return ROWS;
    }

    public int getBoardCol(){
        return COLS;
    }

    public GridSquare[][] getGrid() {
        return grid;
    }

    public void resetBoard() {
        for (int row = 0; row < ROWS; row++){
            for (int col = 0; col < COLS; col++){
                grid [row][col] = new GridSquare(row, col);
            }
        }

        counter = 0;

        grid[0][0] = new GridSquare(0,0,new Tor("red"));
        grid[0][1] = new GridSquare(0,1, new Biz("red"));
        grid[0][2] = new GridSquare(0,2,new Sau("red"));
        grid[0][3] = new GridSquare(0,3, new Biz("red"));
        grid[0][4] = new GridSquare(0,4,new Xor("red"));
        grid[1][0] = new GridSquare(1,0, new Ram("red"));
        grid[1][1] = new GridSquare(1,1, new Ram("red"));
        grid[1][2] = new GridSquare(1,2, new Ram("red"));
        grid[1][3] = new GridSquare(1,3, new Ram("red"));
        grid[1][4] = new GridSquare(1,4, new Ram("red"));

        grid[6][0] = new GridSquare(6,0, new Ram("blue"));
        grid[6][1] = new GridSquare(6,1, new Ram("blue"));
        grid[6][2] = new GridSquare(6,2, new Ram("blue"));
        grid[6][3] = new GridSquare(6,3, new Ram("blue"));
        grid[6][4] = new GridSquare(6,4, new Ram("blue"));
        grid[7][0] = new GridSquare(7,0, new Xor("blue"));
        grid[7][1] = new GridSquare(7,1, new Biz("blue"));
        grid[7][2] = new GridSquare(7,2, new Sau("blue"));
        grid[7][3] = new GridSquare(7,3, new Biz("blue"));
        grid[7][4] = new GridSquare(7,4, new Tor("blue"));

    }

    public void incrementCounter(){
        counter++;
        XorTorSwitch();
    }

    public void switchTeam(){
        currentTeam = (currentTeam =="blue")? currentTeam = "red" : (currentTeam = "blue");
    }

    public void XorTorSwitch(){
        if (counter % 4 == 0){
            for (int row = 0; row < ROWS; row++) {
                for (int col = 0; col < COLS; col++) {
                    GridSquare square = grid[row][col];
                    if (square.isOccupied()) {
                        Piece currentPiece = square.getPiece();
                        // Check if piece is  Time or Plus
                        if (currentPiece instanceof Tor) {
                            // Replace Time with Plus
                            grid[row][col].setPiece(new Xor(currentPiece.getTeam()), true);
                        } else if (currentPiece instanceof Xor) {
                            // Replace Plus with Time
                            grid[row][col].setPiece(new Tor(currentPiece.getTeam()), true);
                        }
                    }
                }
            }
        }
    }

    public String winner(){
        boolean BlueSauAlive = false;
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (getGrid()[row][col].getPiece() != null &&
                        getGrid()[row][col].getPiece().getName().equals("Sau") &&
                        getGrid()[row][col].getPiece().getTeam() == "blue") {
                    BlueSauAlive = true;
                    break;
                }
            }
            if (BlueSauAlive) {
                break;
            }
        }

        boolean RedSauAlive = false; //boolean to verify Dark Sun Piece existence
        for(int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (getGrid()[row][col].getPiece() != null &&
                        getGrid()[row][col].getPiece().getName().equals("Sau") &&
                        getGrid()[row][col].getPiece().getTeam() == "red") {
                    RedSauAlive = true;
                    break;
                }
            }
            if (RedSauAlive) {
                break;
            }
        }

        if (!RedSauAlive && BlueSauAlive) {
            return "blue";
        } else if (RedSauAlive && !BlueSauAlive) {
            return "red";
        } else {
            return null; // if both still present continue game
        }

    }

    // to implement 
    public void saveBoard() {

    }

    








}

