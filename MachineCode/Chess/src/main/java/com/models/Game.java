package main.java.com.models;

import java.util.ArrayList;

enum GameStatus {
    ACTIVE,
    STALEMATE,
    BLACK_WIN,
    WHITE_WIN,
    FORFEIT
}

public class Game {
    private Player player1;
    private Player player2;
    private Board board;
    private GameStatus status;
    private ArrayList<Move> movesPlayed;

    public Game(Player player1, Player player2, Board board) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        status = GameStatus.ACTIVE;
    }

    public boolean isGameOver() {
        return status != GameStatus.ACTIVE;
    }

    public void blackWin() {
        status = GameStatus.BLACK_WIN;
    }

    public void whiteWin() {
        status = GameStatus.WHITE_WIN;
    }

    public void forfeitGame() {
        status = GameStatus.FORFEIT;
    }

    public void slateMate() {
        status = GameStatus.STALEMATE;
    }

}
