package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Tasks {

    private String taskName;
    private String color;
    private String whatToPaint;
    private boolean isTaskExecuted;

    public PaintingTask(String taskName, String color, String whatToPaint, boolean isTaskExecuted) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
        this.isTaskExecuted = isTaskExecuted;
    }

    @Override
    public String executeTask() {
        return "Paint yours son room";
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
