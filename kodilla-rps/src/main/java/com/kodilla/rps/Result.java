package com.kodilla.rps;

public class Result {

    public void checkResult(Player player, Computer computer, String playerCurrentMove, String computerCurrentMove, Score score) {
        if (playerCurrentMove.equals(computerCurrentMove)) {
            System.out.println("It's a Tie!!!");
            score.incrementTargetWinsToWinTheGame();
        } else if (
                (playerCurrentMove.equals(Moves.ROCK) && computerCurrentMove.equals(Moves.PAPER)) ||
                        (playerCurrentMove.equals(Moves.PAPER) && computerCurrentMove.equals(Moves.SCISSORS)) ||
                        (playerCurrentMove.equals(Moves.SCISSORS) && computerCurrentMove.equals(Moves.ROCK))
        ) {
            score.computerWonRound(computer);
            score.incrementTargetWinsToWinTheGame();
        } else {
            score.playerWonRound(player);
            score.incrementTargetWinsToWinTheGame();
        }
        score.gameScore(player, computer);
    }
}
