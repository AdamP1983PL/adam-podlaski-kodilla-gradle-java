package com.kodilla.spring.library;

import com.kodilla.spring.reader.ReaderConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@SpringBootTest
class LibraryTestSuite {

    @Test
    void testLoadFromDb() {
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
    void testSaveToDb() {
        // given
        // when
        library.saveToDb();

        // then
        // do nothing
    }

    @Test
    void testContext() {
        // given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");

        // when
        // then
        System.out.println("=====<<<<<<Beans List>>>>>>====");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        System.out.println("=====<<<<<<End of List>>>>>>=====");
    }

    @Test
    void testConditional() {
        // given
        ApplicationContext context = new AnnotationConfigApplicationContext(ReaderConfig.class);

        // when
        boolean book2Exists = context.containsBean("book2");

        // then
        System.out.println("Book2 was found in the container: " + book2Exists);
    }
}
