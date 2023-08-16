package com.kodilla.testing.forum;

import com.kodilla.testing.user.SimpleUser;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Forum Test Suite")
public class ForumTestSuite {

    @BeforeEach
    void before(){
        System.out.println("@BeforeEach");
    }

    @AfterEach
    void after(){
        System.out.println("@AfterEach");
    }

    @BeforeAll
    static void beforeAll(){
        System.out.println("@BeforeAll");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("@AfterAll");
    }

    @DisplayName(
            "When created SimpleUser with name, " +
                    "then getUsername should return correct name"
    )
    @Test
    void testCaseUserName() {
        //given
        SimpleUser simpleUser = new SimpleUser("theForumUser", "John Smith");

        //when
        String result = simpleUser.getUsername();
        String expectedResult = "theForumUser";

        //then
        assertEquals(expectedResult, result);
    }

    @Test
    void testCaseRealName(){
        //given
        SimpleUser simpleUser = new SimpleUser("theForumUser", "John Smith");

        //when
        String result = simpleUser.getRealName();
        String expectedResult = "John Smith";

        //then
        assertEquals(expectedResult, result);
    }
}
