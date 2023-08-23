package com.kodilla.rps;

public class Result {

    public void checkResult(Player player, Computer computer, String playerCurrentMove, String computerCurrentMove, Score score){

        if (playerCurrentMove.equals(computerCurrentMove)){
            System.out.println("It is a Tie!!!");
            score.incrementTargetWinsToWinTheGame();
            score.gameScore(player, computer);
        }

        if (playerCurrentMove.equals("Rock")){
            if (computerCurrentMove.equals("Paper")){
                score.incrementTargetWinsToWinTheGame();
                score.computerWonRound(computer);
                score.gameScore(player, computer);
            } else if (computerCurrentMove.equals("Scissors")){
                score.incrementTargetWinsToWinTheGame();
                score.playerWonRound(player);
                score.gameScore(player, computer);
            }
        } else if (playerCurrentMove.equals("Paper")){
            if (computerCurrentMove.equals("Rock")){
                score.incrementTargetWinsToWinTheGame();
                score.playerWonRound(player);
                score.gameScore(player, computer);
            } else if (computerCurrentMove.equals("Scissors")){
                score.incrementTargetWinsToWinTheGame();
                score.computerWonRound(computer);
                score.gameScore(player, computer);
            }
        } else if (playerCurrentMove.equals("Scissors")){
            if(computerCurrentMove.equals("Rock")){
                score.incrementTargetWinsToWinTheGame();
                score.computerWonRound(computer);
                score.gameScore(player, computer);
            } else if (computerCurrentMove.equals("Paper")){
                score.incrementTargetWinsToWinTheGame();
                score.playerWonRound(player);
                score.gameScore(player, computer);
            }
        }
    }
}
