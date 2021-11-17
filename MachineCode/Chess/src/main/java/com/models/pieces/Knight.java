package main.java.com.models.pieces;

import main.java.com.interfaces.Piece;

public class Knight extends Piece {

    public Knight(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove() {
        return false;
    }
}
