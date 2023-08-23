package com.kodilla.rps;

public class Player {
    private String name;
    private int playerScore;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int incrementPlayerScore(){
        return playerScore++;
    }
}
