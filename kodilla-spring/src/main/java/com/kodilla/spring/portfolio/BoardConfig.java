package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {

    @Bean(name = "toDoList")
    public TaskList toDoList() {
        return new TaskList();
    }

    @Bean(name = "inProgressList")
    public TaskList inProgressList() {
        return new TaskList();
    }

    @Bean(name = "doneList")
    public TaskList doneList() {
        return new TaskList();
    }

    @Bean
    public Board board(@Qualifier("toDoList") TaskList toDoList,
                       @Qualifier("inProgressList") TaskList inProgressList,
                       @Qualifier("doneList") TaskList doneList) {
        return new Board(toDoList, inProgressList, doneList);
    }
}
