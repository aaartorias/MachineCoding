package main.java.com.models.pieces;

import main.java.com.interfaces.Piece;

public class Pawn extends Piece {
    private Integer id;

    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove() {
        return false;
    }


}
