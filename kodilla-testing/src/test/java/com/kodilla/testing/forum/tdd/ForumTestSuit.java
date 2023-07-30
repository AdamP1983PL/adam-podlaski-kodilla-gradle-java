package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.jupiter.api.*;

@DisplayName("TDD: Forum Test Suit")
public class ForumTestSuit {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests(){
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTest(){
        System.out.println("All tests all finished");
    }

    @BeforeEach
    public void beforeEveryTest(){
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    void testAddPost(){
        //given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");

        //when
        forumUser.addPost("Hello everyone, " +
                "this is my first contribution here!", "mrsmith");

        //then
        Assertions.assertEquals(1, forumUser.getPostsQuantity());
    }

    @Test
    void testAddComment(){
        //given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone, " +
                "this is my first contribution here!", "mrsmith");

        //when
        forumUser.addComment(thePost, "mrsmith", "Thank You..." );

        //then
        Assertions.assertEquals(1, forumUser.getCommentsQuantity());
    }

    @Test
    void testGetPost(){
        //given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone, " +
                "this is my first contribution here!", "mrsmith");
        forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());

        //when
        ForumPost retrievedPost;
        retrievedPost = forumUser.getPost(0);

        //then
        Assertions.assertEquals(thePost, retrievedPost);
    }

    @Test
    void testGetComment(){
        //given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone, " +
                "this is my first contribution here!", "mrsmith");
        ForumComment theComment = new ForumComment(thePost, "Thank you for all good words!",
                "mrsmith");
        forumUser.addComment(thePost, theComment.getAuthor(),
                theComment.getCommentBody());

        //when
        ForumComment retrievedComment = forumUser.getComment(0);

        //then
        Assertions.assertEquals(theComment, retrievedComment);
    }

    @Test
    void testRemovePostNotExisting() {
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone, " +
                "this is my first contribution here!", "mrsmith");

        //When
        boolean result = forumUser.removePost(thePost);

        //Then
        Assertions.assertFalse(result);
    }

    @Test
    void testRemoveCommentNotExisting(){
        //given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone, " +
                "this is my first contribution here!", "mrsmith");
        ForumComment theComment = new ForumComment(thePost,
                "Thank you for all good words!",
                "mrsmith");

        //when
        boolean result = forumUser.removeComment(theComment);

        //then
        Assertions.assertFalse(result);
    }

    @Test
    void testRemovePost(){
        //given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone, " +
                "this is my first contribution here!", "mrsmith");
        forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());

        //when
        boolean result = forumUser.removePost(thePost);

        //then
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, forumUser.getPostsQuantity());
    }

    @Test
    void testRemoveComment() {
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone, " +
                "this is my first contribution here!", "mrsmith");
        ForumComment theComment = new ForumComment(thePost,
                "Thank you for all good words!",
                "mrsmith");
        forumUser.addComment(thePost, theComment.getAuthor(),
                theComment.getCommentBody());

        //When
        boolean result = forumUser.removeComment(theComment);

        //Then
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, forumUser.getCommentsQuantity());
    }




















}























