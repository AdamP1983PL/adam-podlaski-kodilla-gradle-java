package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentsTaskTestSuite {

    @Test
    public void testUpdate() {
        // Given
        Student student1 = new Student(1, "Colt", "Steele",
                LocalDate.of(2023, 01, 02),
                LocalDate.of(2023, 12, 31), new ArrayList<>());
        Student student2 = new Student(2, "Tim", "Buchalka",
                LocalDate.of(2023, 06, 01),
                LocalDate.of(2024, 05, 31), new ArrayList<>());
        Mentor mentor1 = new Mentor("Mentor one");
        Mentor mentor2 = new Mentor("Mentor two");
        StudentsTasks student1Tasks = new StudentsTasks(student1);
        StudentsTasks student2Tasks = new StudentsTasks(student2);
        student1Tasks.registerObserver(mentor1);
        student2Tasks.registerObserver(mentor2);

        // When
        student1Tasks.addTask(new Task(1, "Task one"));
        student1Tasks.addTask(new Task(2, "Task two"));
        student1Tasks.addTask(new Task(3, "Task three"));
        student2Tasks.addTask(new Task(1, "Task one"));

        // Then
        assertEquals(3, mentor1.getUpdateCount());
        assertEquals(1, mentor2.getUpdateCount());
        assertEquals(1, student1Tasks.getObserverList().size());
        assertEquals(1, student2Tasks.getObserverList().size());
    }

    @Test
    public void testRemoveObserver() {
        // Given
        Student student1 = new Student(1, "Colt", "Steele",
                LocalDate.of(2023, 01, 02),
                LocalDate.of(2023, 12, 31), new ArrayList<>());
        Mentor mentor1 = new Mentor("Mentor one");
        Mentor mentor2 = new Mentor("Mentor two");
        StudentsTasks student1Tasks = new StudentsTasks(student1);
        student1Tasks.registerObserver(mentor1);
        student1Tasks.registerObserver(mentor2);
        student1Tasks.addTask(new Task());
        student1Tasks.addTask(new Task());

        // When
        student1Tasks.unregisterObserver(mentor2);
        student1Tasks.addTask(new Task());
        student1Tasks.addTask(new Task());

        // Then
        assertEquals(4, mentor1.getUpdateCount());
        assertEquals(2, mentor2.getUpdateCount());

    }
}
