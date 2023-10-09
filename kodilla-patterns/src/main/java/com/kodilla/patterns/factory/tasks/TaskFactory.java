package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public Tasks makeNewTask(TaskType taskType) {
        return switch (taskType) {
            case DRIVING_TASK -> new DrivingTask("Driving task", "School", "Car");
            case SHOPPING_TASK -> new ShoppingTasks("Shopping task", "Laptop", 1.0);
            case PAINTING_TASK -> new PaintingTask("Painting task", "Blue", "Sons room");
        };
    }
}
