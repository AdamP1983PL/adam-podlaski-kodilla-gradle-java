package com.kodilla.patterns2.observer.homework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Task {

    private int taskNumber;
    private String taskDescription;

}
