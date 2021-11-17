package main.java.com.models.pieces;

import main.java.com.interfaces.Piece;

public class Rook extends Piece {

    public Rook(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove() {
        return false;
    }
}
