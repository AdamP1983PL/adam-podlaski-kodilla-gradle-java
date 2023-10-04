package com.kodilla.patterns.enums_youtube.enums;

import java.util.Scanner;

public class UserDialogs {
    public static UserSelection getUserSelection() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your choice: (S)cissors, (R)ock, (P)apper");
            String s = scanner.nextLine();
            switch (s) {
                case "s":
                    return UserSelection.SCISSORS;
                case "p":
                    return UserSelection.PAPER;
                case "r":
                    return UserSelection.ROCK;
                default:
                    System.out.println("Invalid input.");
            }
        }
    }
}
