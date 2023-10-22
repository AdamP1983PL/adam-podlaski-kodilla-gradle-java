package com.kodilla.kodillahibernate2.tasklist.dao;

import com.kodilla.kodillahibernate2.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    @Test
    void testFindByListName(){
        // given
        TaskList taskList = new TaskList("Name 1", "Description 1");
        taskListDao.save(taskList);
        String name = taskList.getListName();

        // when
        List<TaskList> taskLists = taskListDao.findByListName(name);

        // then
        assertEquals(1, taskLists.size());
        assertEquals(name, taskList.getListName());

        // clean up
        int id = taskLists.get(0).getId();
        taskListDao.deleteById(id);
    }

}
