package com.kodilla.rps;

import java.util.Random;

public class ComputerMove {

    public String getComputerMove(){
        Random random = new Random();
        String computerMove = "";
        int temp = random.nextInt(3) + 1;

        switch (temp) {
            case 1 -> {
                computerMove = "Rock";
                System.out.println("Computer move: " + computerMove);
            }
            case 2 -> {
                computerMove = "Paper";
                System.out.println("Computer move: " + computerMove);
            }
            case 3 -> {
                computerMove = "Scissors";
                System.out.println("Computer move: " + computerMove);
            }
        }
        return computerMove;
    }
}
