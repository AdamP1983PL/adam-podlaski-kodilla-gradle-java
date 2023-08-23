package com.kodilla.rps;

public class Winner {

    public void determineTheWinner(Player player, Computer computer) {
        Run run = new Run();
        TargetWinsToWin targetWinsToWin = new TargetWinsToWin();

        int targetScore = targetWinsToWin.getTargetWins();
        int playerScore = player.getPlayerScore();
        int computerScore = computer.getComputerScore();

        if (playerScore > computerScore && playerScore == targetScore) {
            System.out.println("Player has Won the Game!!!!!!!");
            run.setEndGame(true);
        }
        if (computerScore > playerScore && computerScore == targetScore) {
            System.out.println("Computer has Won the Game!!!");
            run.setEndGame(true);
        }
    }
}
