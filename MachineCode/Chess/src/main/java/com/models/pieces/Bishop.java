package main.java.com.models.pieces;

import main.java.com.interfaces.Piece;

public class Bishop extends Piece {

    public Bishop(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove() {
        return false;
    }
}
