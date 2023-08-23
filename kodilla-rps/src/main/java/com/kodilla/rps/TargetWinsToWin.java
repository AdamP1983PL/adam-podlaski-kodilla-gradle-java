package com.kodilla.rps;

import java.util.Scanner;

public class TargetWinsToWin {

    private int targetWins;

    public int getTargetWins() {
        return targetWins;
    }

    public void setTargetWins(int targetWins) {
        this.targetWins = targetWins;
    }

    public int enterTargetNumOfWinsToWin() {

        boolean correctUserInput = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter target number of wins to Win the Game: ");

        while (!correctUserInput) {
            try {
                targetWins = Integer.parseInt(scanner.nextLine());
                if (targetWins <= 0 || targetWins > 50) {
                    System.out.println("Invalid target number. Choose between 1 and 50 wins to Win the Game");
                } else {
                    System.out.println("Target wins to Win the Game is: " + targetWins);
                    correctUserInput = true;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Invalid input. Choose between 1 and 50 wins to Win the Game");
            }
        }
        return targetWins;
    }
}

