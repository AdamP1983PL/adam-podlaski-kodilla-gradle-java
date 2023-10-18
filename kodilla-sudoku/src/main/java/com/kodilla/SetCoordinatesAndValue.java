package com.kodilla;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SetCoordinatesAndValue {

    public List<Integer> setCoordinatesAndValue() {
        List<Integer> coordinatesAndValue = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        String input;
        String inputInstruction = "Input comma separated row number, col number and Value from 1 to 9\n"
                + "Example: \"1,1,5\" means first row, first col, value 5";

        boolean flag = false;

        while (!flag) {
            System.out.println(inputInstruction);
            input = scanner.nextLine();
            String[] inputArray = input.split(",");

            if (inputArray.length == 3) {
                try {
                    int inputRowNumber = Integer.parseInt(inputArray[0]);
                    int inputColNumber = Integer.parseInt(inputArray[1]);
                    int inputValue = Integer.parseInt(inputArray[2]);

                    if (isValidNumber(inputRowNumber) && isValidNumber(inputColNumber) && isValidNumber(inputValue)) {
                        coordinatesAndValue.add(inputRowNumber);
                        coordinatesAndValue.add(inputColNumber);
                        coordinatesAndValue.add(inputValue);
                        flag = true;
                    } else {
                        System.out.println("Try again!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Try again!");
                }
            } else {
                System.out.println("Try again!");
            }
        }
        System.out.println("Row number: " + coordinatesAndValue.get(0)
                + ", Col number: " + coordinatesAndValue.get(1)
                + ", Value: " + coordinatesAndValue.get(2));
        return coordinatesAndValue;
    }

    private boolean isValidNumber(int number) {
        return number >= 1 && number <= 9;
    }
}

