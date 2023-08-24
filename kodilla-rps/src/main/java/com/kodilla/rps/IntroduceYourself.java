package com.kodilla.rps;

import java.util.Scanner;

public class IntroduceYourself {
    Player player = new Player();

    public static Player introduceYourself() {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        boolean flag = false;

        while (!flag) {
            System.out.println("Enter Your name: ");
            String name = scanner.nextLine();
            if (name.length() < 3 || name.length() > 10) {
                System.out.println("Invalid name length (Name length should be between 3 - 10).");
            } else {
                System.out.println("Welcome to the game " + name);
                player.setName(name);
                flag = true;
            }
        }
        return player;
    }
}
