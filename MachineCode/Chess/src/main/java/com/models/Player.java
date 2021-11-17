package main.java.com.models;

public class Player {
    private String name;
    private Integer id;
    private boolean isWhite;
    private Integer totalGamesPlayed;
    private static Integer counter = 1;

    public Player(String name) {
        this.name = name;
        this.id = counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public Integer getTotalGamesPlayed() {
        return totalGamesPlayed;
    }

    public void incrementTotalGamesPlayed() {
        totalGamesPlayed = totalGamesPlayed+1;
    }
}
