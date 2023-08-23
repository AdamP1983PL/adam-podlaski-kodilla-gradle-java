package com.kodilla.rps;

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
        Winner winner = new Winner();

        rules.showRules();

        IntroduceYourself.introduceYourself();

        targetWinsToWin.enterTargetNumOfWinsToWin();

        while(!endGame) {
            rules.showMoves();

            String playerCurrentMove = playerMove.getPlayerMove();

            String computerCurrentMove = computerMove.getComputerMove();

            result.checkResult(player, computer, playerCurrentMove, computerCurrentMove, score);

            winner.determineTheWinner(player, computer);

            System.out.println("\n-------------------------------------------------------------------------------------------\n");
        }
    }
}
