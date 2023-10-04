package com.kodilla.patterns.singleton_youtube;

enum PrinterManager {
    INSTANCE;

    public void print(){
        System.out.println("Printing Singleton");
    }
}
