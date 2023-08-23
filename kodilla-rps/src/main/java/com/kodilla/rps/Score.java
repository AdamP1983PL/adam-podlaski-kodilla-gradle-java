package com.kodilla.rps;

public class Score {
    private int targetWinsToWinTheGame;

    void gameScore(Player player, Computer computer){
        System.out.println("Player Score: " + player.getPlayerScore());
        System.out.println("Computer Score: " + computer.getComputerScore());
    }

    public void playerWonRound(Player player){
        player.incrementPlayerScore();
        System.out.println("Player has won the Round!");
    }

    public void computerWonRound(Computer computer){
        computer.incrementComputerScore();
        System.out.println("Computer has won the Round!");
    }

    public int incrementTargetWinsToWinTheGame(){
        return targetWinsToWinTheGame++;
    }


    public int getTargetWinsToWinTheGame() {
        return targetWinsToWinTheGame;
    }

    public void setTargetWinsToWinTheGame(int targetWinsToWinTheGame) {
        this.targetWinsToWinTheGame = targetWinsToWinTheGame;
    }
}
