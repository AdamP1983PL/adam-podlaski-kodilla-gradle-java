package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Tasks {

    private String taskName;
    private String where;
    private String using;
    private boolean isTaskExecuted;

    public DrivingTask(String taskName, String where, String using, boolean isTaskCompleted) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
        this.isTaskExecuted = isTaskCompleted;
    }

    @Override
    public String executeTask() {
        return "Drive your son to school";
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return isTaskExecuted;
    }
}
