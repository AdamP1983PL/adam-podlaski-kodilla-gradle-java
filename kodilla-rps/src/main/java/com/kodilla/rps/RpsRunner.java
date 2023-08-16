package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

import static com.kodilla.rps.HelperClass.*;

public class RpsRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        welcomeMessage();

        System.out.print("Enter Your name: ");
        String playerName = scanner.nextLine();

        System.out.print("Enter number of rounds:");
        int roundsToWin = scanner.nextInt();
        scanner.nextLine();

        int playerScore = 0;
        int computerScore = 0;
        int roundCount = 0;
        boolean flag = false;

        printRules();

        while (!flag) {

            System.out.print(playerName + " enter Your move: ");
            String playerMove = scanner.nextLine();

            if (playerMove.equals("x")) {
                System.out.println("Quit the Game? \"Y\" for yes, \"any other button\" for no.");
                if (scanner.nextLine().equalsIgnoreCase("y")) {
                    break;
                }
            } else if (playerMove.equals("n")) {
                System.out.println("Start new Game? \"Y\" for yes, \"any other button\" for no.");
                if (scanner.nextLine().equalsIgnoreCase("y")) {
                    playerScore = 0;
                    computerScore = 0;
                    roundCount = 0;
                }
            } else if (playerMove.equals("1") || playerMove.equals("2") || playerMove.equals("3")) {
                int computerChoice = random.nextInt(3) + 1;
                if (playerMove.equals(Integer.toString(computerChoice))) {
                    tie();
                    roundCount++;
                } else if (playerMove.equals("1") && computerChoice == 3 || playerMove.equals("2") && computerChoice == 1 || playerMove.equals("3") && computerChoice == 2) {
                    playerScore++;
                    roundCount++;
                    playerWin();
                } else {
                    computerScore++;
                    roundCount++;
                    computerWin();
                }
                System.out.println("Round count: " + roundCount + " vs " + playerName + ": " + playerScore + " vs Computer: " + computerScore);

                if (roundCount == roundsToWin) {
                    if (playerScore == computerScore) {
                        tie();
                    } else if (playerScore > computerScore) {
                        playerWin();
                    } else {
                        computerWin();
                    }
                }
                if (roundCount == roundsToWin) {
                    flag = true;
                    break;
                }
            }
        }
    }
}


