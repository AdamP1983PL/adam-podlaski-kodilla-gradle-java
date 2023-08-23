package com.kodilla.rps;

public class Rules {

    public void showRules(){
        System.out.println("""
                <<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>
                <<<Welcome to Rock - Paper - Scissors Game>>>
                <<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>
                
                Rock - Paper - Scissors game rules:
                Each round you must choose:
                Rock - by pressing "1"
                Paper - by pressing "2"
                Scissors - by pressing "3".
                
                Your selection will be compared with computer's selection.
                The score will be displayed on the screen after each round.
                The first player to reach the target number of wins wins the game.
                
                You can end the game at any time by pressing "X"
                or reset the game score by pressing "n".
                                
                At the start of the game, you will be asked to enter your name 
                and your target number of wins until the end of the game.
                """);
    }

    public void showMoves(){
        System.out.println("Choose \"1\" for Rock, \"2\" for Paper, \"3\" for Scissors," +
                " \"x\" for End Game and \"n\" for Reset Game");
    }
}
