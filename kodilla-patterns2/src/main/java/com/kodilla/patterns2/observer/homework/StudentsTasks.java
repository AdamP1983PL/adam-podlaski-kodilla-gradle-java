package com.kodilla.patterns2.observer.homework;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StudentsTasks implements Observable {
    private final List<Observer> observerList;
    private final List<Task> tasks;
    private final Student student;

    public StudentsTasks(Student student) {
        this.observerList = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.student = student;
    }

    public void addTask(Task task) {
        tasks.add(task);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer ob : observerList) {
            ob.update(this);
        }
    }

}
