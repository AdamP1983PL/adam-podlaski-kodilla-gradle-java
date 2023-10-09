package com.kodilla.patterns.factory.tasks;

public class ShoppingTasks implements Tasks {

    private String taskName;
    public String whatToBuy;
    public double quantity;

    public ShoppingTasks(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public String executeTask() {
        return "Buy birthday present for my son";
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return false;
    }
}
