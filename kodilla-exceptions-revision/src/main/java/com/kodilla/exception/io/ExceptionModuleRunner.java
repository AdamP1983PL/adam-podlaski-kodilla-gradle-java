package com.kodilla.exception.io;

import java.io.IOException;

public class ExceptionModuleRunner {
    public static void main(String[] args) {

//        FileReaderWithoutHandling fileReaderWithoutHandling = new FileReaderWithoutHandling();
//        try {
//            fileReaderWithoutHandling.readFile();
//        } catch (FileReaderException e) {
//            System.out.println("Problem while reading file");
//        }

        FileReader fileReader = new FileReader();
//
//        try {
//            fileReader.readFile();
//        } catch (FileReaderException e) {
//            System.out.println("Problem while reading a file!!!");
//        }

        try {
            fileReader.readFile("names.txt");
        } catch (FileReaderException e) {
            System.out.println("Problem while reading a file");
        }




    }
}
