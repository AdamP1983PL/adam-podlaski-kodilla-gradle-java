package com.kodilla.rps;

public class Computer {
    private final String name = "Computer";
    private int computerScore;

    public int getComputerScore() {
        return computerScore;
    }

    public void setComputerScore(int computerScore) {
        this.computerScore = computerScore;
    }

    public int incrementComputerScore(){
        return computerScore++;
    }
}
