package com.kodilla.rps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Run {
    private boolean endGame = false;

    public boolean isEndGame() {
        return endGame;
    }

    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }

    public void run(){
        Player player = new Player();
        Computer computer = new Computer();
        PlayerMove playerMove = new PlayerMove();
        ComputerMove computerMove = new ComputerMove();
        Score score = new Score();
        TargetWinsToWin targetWinsToWin = new TargetWinsToWin();
        Rules rules = new Rules();
        Result result = new Result();
        CheckWinningConditions checkWinningConditions = new CheckWinningConditions();

        rules.showRules();

        IntroduceYourself.introduceYourself();

        targetWinsToWin.enterTargetNumOfWinsToWin();

        while(!endGame) {
            rules.showMoves();
            
            String playerCurrentMove = playerMove.getPlayerMove(player, computer);

            if(playerCurrentMove.equals(Moves.EXIT)) break;

            if(playerCurrentMove.equals(Moves.RESET)){
                continue;
            }
            String computerCurrentMove = computerMove.getComputerMove();

            result.checkResult(player, computer, playerCurrentMove, computerCurrentMove, score);

            checkWinningConditions.determineTheWinner(player, computer, targetWinsToWin);

            System.out.println("\n-------------------------------------------------------------------------------------------\n");
        }
    }
}
