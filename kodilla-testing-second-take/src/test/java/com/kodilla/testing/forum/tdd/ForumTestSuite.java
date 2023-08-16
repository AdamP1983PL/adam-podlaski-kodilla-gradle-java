package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Forum Test Suite")
public class ForumTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    static void beforeAll(){
        System.out.println("@BeforeAll");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("@AfterAll");
    }

    @BeforeEach
    void beforeEachTest(){
        testCounter++;
        System.out.println("Test number #" + testCounter);
    }

    @Test
    void testAddPost(){
        //given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");

        //when
        forumUser.addPost("mrsmith", "Hello everyone!!!");

        //then
        assertEquals(1, forumUser.getPostsQuantity());
    }

    @Test
    void testAddComment(){
        //given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone", "mrsmith");

        //when
        forumUser.addComment(thePost, "mrsmith", "Thank You");

        //then
        assertEquals(1, forumUser.getCommentsQuantity());
    }

    @Test
    void testGetPost(){
        //given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone", "mrsmith");
        forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());

        //when
        ForumPost retrievedPost = forumUser.getPost(0);

        //then
        assertEquals(thePost, retrievedPost);
    }

    @Test
    void testGetComment() {
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone, " +
                "this is my first contribution here!", "mrsmith");
        ForumComment theComment = new ForumComment(thePost, "mrsmith",
                "Thank you for all good words!");
        forumUser.addComment(thePost, theComment.getAuthor(),
                theComment.getCommentBody());

        //When
        ForumComment retrievedComment = forumUser.getComment(0);

        //Then
        Assertions.assertEquals(theComment, retrievedComment);
    }

    @Test
    void testRemovePostNotExisting(){
        //given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone", "mrsmith");

        //when
        boolean result = forumUser.removePost(thePost);

        //then
        Assertions.assertFalse(result);
    }

    @Test
    void testRemoveCommentNotExisting(){
        //given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone", "mrsmith");
        ForumComment theComment = new ForumComment(thePost, "mrsmith",
                "Thank you for all good words!");

        //when
        boolean result = forumUser.removeComment(theComment);

        //
        Assertions.assertFalse(result);
    }

    @Test
    void testRemovePost(){
        //given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone", "mrsmith");
        forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());

        //when
        boolean result = forumUser.removePost(thePost);

        //then
        assertTrue(result);
        assertEquals(0, forumUser.getPostsQuantity());
    }

    @Test
    void testRemoveComment() {
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone, " +
                "this is my first contribution here!", "mrsmith");
        ForumComment theComment = new ForumComment(thePost, "mrsmith",
                "Thank you for all good words!");
        forumUser.addComment(thePost, theComment.getAuthor(),
                theComment.getCommentBody());

        //When
        boolean result = forumUser.removeComment(theComment);

        //Then
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, forumUser.getCommentsQuantity());
    }
}
