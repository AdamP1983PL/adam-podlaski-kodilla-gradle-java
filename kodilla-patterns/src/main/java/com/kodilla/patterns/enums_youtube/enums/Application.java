package com.kodilla.patterns.enums_youtube.enums;

public class Application {
    public static void main(String[] args) {

        UserSelection userSelection = UserDialogs.getUserSelection();
        System.out.println(userSelection);
        if(userSelection == UserSelection.SCISSORS){
            System.out.println("Scissors");
        } else if (userSelection == UserSelection.ROCK){
            System.out.println("Rock");
        } else {
            System.out.println("Paper");
        }
    }
}
