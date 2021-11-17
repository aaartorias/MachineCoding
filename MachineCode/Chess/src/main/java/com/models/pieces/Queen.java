package main.java.com.models.pieces;

import main.java.com.interfaces.Piece;

public class Queen extends Piece {

    public Queen(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove() {
        return false;
    }
}
