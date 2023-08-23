package com.kodilla.rps;

import java.util.Scanner;

public class PlayerMove {

    private String playerMove;

    public void setPlayerMove(String playerMove) {
        this.playerMove = playerMove;
    }

    public String getPlayerMove() {
        Run run = new Run();
        Player player = new Player();
        Computer computer = new Computer();
//        Score score = new Score();
        Scanner scanner = new Scanner(System.in);
        String playerMove = "";
        String temp = scanner.nextLine();

        switch (temp) {
            case "1":
                playerMove = "Rock";
                System.out.println("Player move: " + playerMove);
                break;
            case "2":
                playerMove = "Paper";
                System.out.println("Player move: " + playerMove);
                break;
            case "3":
                playerMove = "Scissors";
                System.out.println("Player move: " + playerMove);
                break;
            case "x":
                boolean flag = false;
                while (!flag) {
                    System.out.println("End this Game Now?");
                    System.out.println("Type \"Y\" for Yes, \"N\" for No");
                    String decision = scanner.nextLine();
                    if (decision.equalsIgnoreCase("Y")) {
                        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx_END_GAME_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                        run.setEndGame(true);
                        flag = true;
                    } else if (decision.equalsIgnoreCase("N")) {
                        System.out.println("Lets continue current Game...");
                        break;
                    } else {
                        System.out.println("Invalid input. Type \"Y\" for Yes, \"N\" for No");
                    }
                }
                break;
            case "n":
                boolean flagOne = false;
                while (!flagOne) {
                    System.out.println("Restart Game Now?");
                    System.out.println("Type \"Y\" for Yes, \"N\" for No");
                    String decision = scanner.nextLine();
                    if (decision.equalsIgnoreCase("y")) {
                        player.setPlayerScore(0);
                        computer.setComputerScore(0);
                        System.out.println("Restarting game!!!");
                        System.out.println("Player score: " + player.getPlayerScore());
                        System.out.println("Computer score " + computer.getComputerScore());
                        flagOne = true;
                    } else if (decision.equalsIgnoreCase("n")) {
                        System.out.println("Lets continue current Game...");
                        break;
                    } else {
                        System.out.println("Invalid input. Type \"Y\" for Yes, \"N\" for No");
                    }
                }
                break;
            default:
                System.out.println("Invalid input. Please choose a valid option.");
                break;
        }
        return playerMove;
    }
}
