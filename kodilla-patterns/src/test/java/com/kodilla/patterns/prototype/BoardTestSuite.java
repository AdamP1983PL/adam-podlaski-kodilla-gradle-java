package com.kodilla.patterns.prototype;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BoardTestSuite {

    @Test
    void testToString(){
        // given
        // creating the task list for todos
        TasksList listToDo = new TasksList("To Do Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listToDo.getTasks().add(new Task("To Do Tusk number: " + n)));

        // creating task list for tasks in progress
        TasksList listInProgress = new TasksList("In Progress Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listInProgress.getTasks().add(new Task("In Progress Tasks number: " + n)));

        // creating task list for done tasks
        TasksList listDone = new TasksList("Done Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listDone.getTasks().add(new Task("Done Task number: " + n)));

        // creating the board and assigning the list
        Board board = new Board("Project number 1");
        board.getLists().add(listToDo);
        board.getLists().add(listInProgress);
        board.getLists().add(listDone);


        // making a shallow clone of object board
        Board cloneBoard = null;
        try{
            cloneBoard = board.shallowCopy();
            cloneBoard.setName("Project number 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        System.out.println(board);
        System.out.println(cloneBoard);

        // making a deep clone of object board
        Board deepClonedBoard = null;
        try{
            deepClonedBoard = board.deepCopy();
            deepClonedBoard.setName("Project number 3");
        } catch (CloneNotSupportedException e){
            System.out.println(e);
        }

        // when
        // NEW: removing elements
        board.getLists().remove(listToDo);

        // then
        System.out.println(board);
        System.out.println(cloneBoard);
        System.out.println(deepClonedBoard);

        assertEquals(2, board.getLists().size());
        assert cloneBoard != null;
        assertEquals(2, cloneBoard.getLists().size());
        assert deepClonedBoard != null;
        assertEquals(3, deepClonedBoard.getLists().size());
        assertEquals(cloneBoard.getLists(), board.getLists());
        assertNotEquals(deepClonedBoard.getLists(), board.getLists());


    }
}
