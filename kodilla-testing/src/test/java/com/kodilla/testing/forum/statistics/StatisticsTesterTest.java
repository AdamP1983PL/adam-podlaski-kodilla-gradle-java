package com.kodilla.testing.forum.statistics;

import forum.statistics.Statistics;
import forum.statistics.StatisticsTester;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StatisticsTesterTest {

    Statistics statisticsMock = mock(Statistics.class);
    StatisticsTester statisticsTester;

    @BeforeEach
    void prepareData() {
        Statistics statisticsMock = mock(Statistics.class);
        statisticsTester = new StatisticsTester();
    }

    @Test
    @DisplayName("Condition: Zero Posts Test.")
    void calculateAdvStatisticsWithZeroPosts() {
        //given
        //@BeforeEach
        // prepareData()
        List<String> forumUsers = new ArrayList<>();
        forumUsers.add("One");
        forumUsers.add("Two");

        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(forumUsers);

        //when
        statisticsTester.calculateAdvStatistics(statisticsMock);

        //then
        Assertions.assertEquals(0, statisticsTester.getAveragePostNumbersPerUser());
    }

    @Test
    @DisplayName("Condition: 1000 Posts Test.")
    void calculateAdvStatisticsWith1000Posts() {
        //given
        //@BeforeEach
        // prepareData()

        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(3000);

        //when
        statisticsTester.calculateAdvStatistics(statisticsMock);

        //then
        Assertions.assertEquals(3, statisticsTester.getAverageCommentsNumberPerPost());
    }

    @Test
    @DisplayName("Condition: 0 Comments Test")
    void calculateAdvStatisticsWithZeroCommentsTest() {
        //given
        //@BeforeEach
        // prepareData()
        List<String> forumUsers = new ArrayList<>();
        forumUsers.add("One");
        forumUsers.add("Two");

        when(statisticsMock.commentsCount()).thenReturn(0);

        //when
        statisticsTester.calculateAdvStatistics(statisticsMock);

        //then
        Assertions.assertEquals(0, statisticsTester.getAverageCommentsNumberPerUser());
        Assertions.assertEquals(0, statisticsTester.getAverageCommentsNumberPerPost());
    }

    @Test
    @DisplayName("Condition: numberOfComments < numberOfPosts")
    void averageCommentsNumberPerPostShouldReturnNumberBetweenZeroAndOne() {
        //given
        //@BeforeEach
        // prepareData()

        when(statisticsMock.commentsCount()).thenReturn(500);
        when(statisticsMock.postsCount()).thenReturn(1000);

        //when
        statisticsTester.calculateAdvStatistics(statisticsMock);

        //then
        Assertions.assertEquals(0.5, statisticsTester.getAverageCommentsNumberPerPost());
    }

    @Test
    @DisplayName("Condition: numberOfComments > numberOfPosts")
    void averageCommentsNumberPerPostShouldReturnNumberGreaterThanOne() {
        //given
        //@BeforeEach
        // prepareData()

        when(statisticsMock.commentsCount()).thenReturn(5000);
        when(statisticsMock.postsCount()).thenReturn(1000);

        //when
        statisticsTester.calculateAdvStatistics(statisticsMock);

        //then
        Assertions.assertEquals(5, statisticsTester.getAverageCommentsNumberPerPost());
    }

    @Test
    @DisplayName("Condition: numberOfUsers = 0")
    void calculateAdvStatisticsWithZeroUsers() {
        //given
        //@BeforeEach
        // prepareData()
        List<String> forumUser = new ArrayList<>();


        when(statisticsMock.usersNames()).thenReturn(forumUser);
        when(statisticsMock.postsCount()).thenReturn(8);

        //when
        statisticsTester.calculateAdvStatistics(statisticsMock);

        //then
        Assertions.assertEquals(0, statisticsTester.getAveragePostNumbersPerUser());
    }

    @Test
    @DisplayName("Condition: numberOfUsers = 100")
    void calculateAdvStatisticsWith100Users() {
        //given
        //@BeforeEach
        // prepareData()
        List<String> forumUser = prepareGivenNumberOfUsers(100);

        when(statisticsMock.commentsCount()).thenReturn(200);
        when(statisticsMock.usersNames()).thenReturn(forumUser);

        //when
        statisticsTester.calculateAdvStatistics(statisticsMock);

        //then
        Assertions.assertEquals(2, statisticsTester.getAverageCommentsNumberPerUser());
    }

    public List<String> prepareGivenNumberOfUsers(int number) {
        List<String> forumUsers = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            forumUsers.add("User_" + i);
        }
        return forumUsers;
    }


}
