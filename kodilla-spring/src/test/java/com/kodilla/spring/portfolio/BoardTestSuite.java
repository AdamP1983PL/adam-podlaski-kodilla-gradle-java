package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BoardTestSuite {

    @Test
    void testTaskAdd() {
        // given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Board board = context.getBean(Board.class);

        // when
        TaskList toDoList = board.getToDoList();
        TaskList inProgressList = board.getInProgressList();
        TaskList doneList = board.getDoneList();

        toDoList.getTasks().add("To do one");
        inProgressList.getTasks().add("In progress one");
        doneList.getTasks().add("Done one");

        // then
        assertEquals(1, toDoList.getTasks().size());
        assertEquals(1, inProgressList.getTasks().size());
        assertEquals(1, doneList.getTasks().size());
    }
}
