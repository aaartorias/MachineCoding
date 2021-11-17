package main.java.com.models.pieces;

import main.java.com.interfaces.Piece;

public class King extends Piece {

    public King(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove() {
        return false;
    }
}
