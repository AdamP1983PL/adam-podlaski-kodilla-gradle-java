package com.kodilla.rps;

public class CheckWinningConditions {

    public void determineTheWinner(Player player, Computer computer, TargetWinsToWin targetWinsToWin) {

        int targetScore = targetWinsToWin.getTargetWins();
        int playerScore = player.getPlayerScore();
        int computerScore = computer.getComputerScore();

        if (playerScore == targetScore) {
            System.out.println("Player has Won the Game!!!!!!!");
            System.exit(0);
        }
        if (computerScore == targetScore) {
            System.out.println("Computer has Won the Game!!!");
            System.exit(0);
        }
    }
}
