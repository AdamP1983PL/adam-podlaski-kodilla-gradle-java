package com.kodilla.patterns2.observer.homework;

import lombok.Data;

@Data
public class Mentor implements Observer {
    private String fullName;
    private int updateCount;

    public Mentor(String fullName) {
        this.fullName = fullName;
    }


    @Override
    public void update(StudentsTasks studentsTasks) {
        System.out.println(studentsTasks.getStudent().getFirstName() + " " + studentsTasks.getStudent().getSecondName()
                + " has send Task: " + studentsTasks.getTasks().size() + " for verification");
        updateCount++;
    }
}
