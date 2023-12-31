package com.kodilla.patterns2.observer.homework;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private int id;
    private String firstName;
    private String secondName;
    private LocalDate startingDate;
    private LocalDate endingDate;
    private List<Task> tasks;

}
