package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies(){
        // given
        User john = new Millenials("John");
        User jeremy = new YGeneration("Jeremy");
        User jerry = new ZGeneration("Jerry");

        // when
        String johnFavouriteSocial = john.sharePost();
        System.out.println("John favourite social: " + johnFavouriteSocial);
        String jeremyFavouriteSocial = jeremy.sharePost();
        System.out.println("Jeremy favourite social: " + jeremyFavouriteSocial);
        String jerryFavouriteSocial = jerry.sharePost();
        System.out.println("Jerry favourite social: " + jerryFavouriteSocial);

        // then
        assertEquals("Love to use Facebook", johnFavouriteSocial);
        assertEquals("Love to use Twitter", jeremyFavouriteSocial);
        assertEquals("Love to use Snapchat", jerryFavouriteSocial);
    }

    @Test
    void testIndividualSharingStrategy(){
        // given
        User john = new Millenials("John");

        // when
        String johnFavouriteSocial = john.sharePost();
        System.out.println("John favourite social: " + johnFavouriteSocial);
        john.setSocialPublisher(new TwitterPublisher());
        johnFavouriteSocial = john.sharePost();
        System.out.println("John favourite social: " + johnFavouriteSocial);

        // then
        assertEquals("Love to use Twitter", johnFavouriteSocial);
    }
}
