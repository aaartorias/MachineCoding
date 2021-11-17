package main.java.com.models;
import main.java.com.models.pieces.*;

public class Board {
    private Box[][] boxes;

    public Board() {
        resetBoard();
    }

    public void resetBoard() {
        initializeWhitePieces();
        initializeBlackPieces();
        initializeRemainingArena();
    }

    private void initializeRemainingArena() {
        for (int x = 0; x < 8; x++) {
            for (int y = 2; y < 6; y++) {
                boxes[x][y] = new Box(x,y,null);
            }
        }
    }

    private void initializeWhitePieces() {
        boxes[0][0] = new Box(0,0, new Rook(true));
        boxes[0][1] = new Box(0,1, new Knight(true));
        boxes[0][2] = new Box(0,2, new Bishop(true));
        boxes[0][3] = new Box(0,3, new Queen(true));
        boxes[0][4] = new Box(0,4, new King(true));
        boxes[0][5] = new Box(0,5, new Bishop(true));
        boxes[0][6] = new Box(0,6, new King(true));
        boxes[0][7] = new Box(0,7, new Rook(true));
        initializePawns(true);
    }

    private void initializeBlackPieces() {
        boxes[7][0] = new Box(7,0, new Rook(false));
        boxes[7][1] = new Box(7,1, new Knight(false));
        boxes[7][2] = new Box(7,2, new Bishop(false));
        boxes[7][3] = new Box(7,3, new Queen(false));
        boxes[7][4] = new Box(7,4, new King(false));
        boxes[7][5] = new Box(7,5, new Bishop(false));
        boxes[7][6] = new Box(7,6, new King(false));
        boxes[7][7] = new Box(7,7, new Rook(false));
        initializePawns(false);
    }

    private void initializePawns(boolean isWhite) {
        int x = 6;
        if (isWhite) x = 1;
        for (int i = 0; i < 8; i++) {
            boxes[x][i] = new Box(x, i, new Pawn(isWhite));
        }
    }

}
