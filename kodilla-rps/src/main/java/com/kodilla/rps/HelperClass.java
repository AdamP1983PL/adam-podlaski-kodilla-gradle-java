package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class HelperClass {

    public static void makeOneLineSpace(){
        System.out.println("");
    }

    public static void welcomeMessage() {
        System.out.println("\nWelcome to the Rock-Paper-Scissors game");
    }

    public static void printRules() {
        System.out.println("List of valid keys:");
        System.out.println("1 - Rock, 2 - Paper, 3 - Scissors, x - Quit the Game, n - New Game");
    }

    public static int validateNumberOfRounds(int rounds) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            if (rounds <= 0 || rounds > 100) {
                System.out.println("You can chose from 1 to 100 rounds.");
                System.out.println("Enter valid number of rounds: ");
                rounds = scanner.nextInt();
            } else {
                System.out.println("You have chosen " + rounds + " rounds.");
                flag = false;
            }
        }
        return rounds;
    }

    public static String validateName() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        boolean flag = true;
        while (flag) {
            if (name.length() < 3 || name.length() > 11) {
                System.out.println("Length of the name should be from 3 to 10 characters");
                System.out.println("Enter valid name: ");
                name = scanner.nextLine();
            } else {
                System.out.println("Welcome " + name + " in the game!");
                flag = false;
            }
        }
        return name;
    }

    private static String getMoveName(int move) {
        switch (move) {
            case 1:
                return "kamień";
            case 2:
                return "papier";
            case 3:
                return "nożyce";
            default:
                return "nieznany ruch";
        }
    }

    public static void tie(){
        System.out.println("Tie! No one wins!");
    }

    public static void playerWin(){
        System.out.println("Player have won!");
    }

    public static void computerWin(){
        System.out.println("Computer have won!");
    }


}
