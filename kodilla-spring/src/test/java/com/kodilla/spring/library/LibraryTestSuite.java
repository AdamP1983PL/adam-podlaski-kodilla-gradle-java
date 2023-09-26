package com.kodilla.spring.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LibraryTestSuite {

    @Test
    void testLoadFromDb(){
        // given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Library library = context.getBean(Library.class);

        // when
        library.loadFromDb();

        // then
        // do nothing
    }

    @Autowired
    private Library library;

    @Test
    void testSaveToDb(){
        // given
        // when
        library.saveToDb();

        // then
        // do nothing
    }

}
