package com.kodilla.testing.forum;

import com.kodilla.testing.user.SimpleUser;
import org.junit.jupiter.api.*;

@DisplayName("Forum Test Suite")
public class ForumTestSuite {

    @BeforeEach
    public void before(){
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after(){
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("Test Suite: end");
    }

    @DisplayName("When create SimpleUser with realName, " +
            "then getRealNAme should return user name")
    @Test
    void testCaseRealName(){
        //given
        SimpleUser simpleUser = new SimpleUser("theForumName", "John Smith");

        //when
        String result = simpleUser.getRealName();
        System.out.println("Testing " + result);

        //then
        Assertions.assertEquals("John Smith", result);


    }

    @DisplayName("When created SimpleUser with name, "
            + "then getUsername should return correct name")
    @Test
    void testCaseUsername() {
        //given
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        //when
        String result = simpleUser.getUserName();
        String expectedResult = "theForumUser";

        //then
        Assertions.assertEquals(expectedResult, result);
    }
}
