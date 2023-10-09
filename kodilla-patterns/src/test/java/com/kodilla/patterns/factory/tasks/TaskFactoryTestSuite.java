package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    TaskFactory taskFactory = new TaskFactory();

    @Test
    void drivingTaskTest() {
        // when
        Tasks drivingTask = taskFactory.makeNewTask(TaskType.DRIVING_TASK);

        // when
        assertEquals("Drive your son to school", drivingTask.executeTask());
        assertEquals("Driving task", drivingTask.getTaskName());
        assertTrue(drivingTask.isTaskExecuted());
    }

    @Test
    void paintingTaskTest() {
        // when
        Tasks paintingTask = taskFactory.makeNewTask(TaskType.PAINTING_TASK);

        // when
        assertEquals("Paint yours son room", paintingTask.executeTask());
        assertEquals("Painting task", paintingTask.getTaskName());
        assertTrue(paintingTask.isTaskExecuted());
    }

    @Test
    void shoppingTaskTest() {
        // when
        Tasks shoppingTask = taskFactory.makeNewTask(TaskType.SHOPPING_TASK);

        // when
        assertEquals("Buy birthday present for my son", shoppingTask.executeTask());
        assertEquals("Shopping task", shoppingTask.getTaskName());
        assertFalse(shoppingTask.isTaskExecuted());
    }
}
