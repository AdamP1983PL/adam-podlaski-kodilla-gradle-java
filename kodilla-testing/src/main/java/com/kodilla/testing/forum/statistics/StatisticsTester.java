package com.kodilla.testing.forum.statistics;

import java.util.List;

public class StatisticsTester {

    private int numberOfUsers;
    private int numberOfPosts;
    private int numberOfComments;
    private double averagePostNumbersPerUser;
    private double averageCommentsNumberPerUser;
    private double averageCommentsNumberPerPost;



    public void calculateAdvStatistics(Statistics statistics) {
        List<String> userNames = statistics.usersNames();
        this.numberOfUsers = userNames.size();
        this.numberOfPosts = statistics.postsCount();
        this.numberOfComments = statistics.commentsCount();

        if (numberOfPosts > 0 && numberOfUsers > 0) {
            this.averagePostNumbersPerUser = (double) numberOfPosts / numberOfUsers;
        } else {
            this.averagePostNumbersPerUser = 0;
        }

        if (numberOfComments > 0 && numberOfUsers > 0) {
            this.averageCommentsNumberPerUser = (double) numberOfComments / numberOfUsers;
        } else {
            this.averageCommentsNumberPerUser = 0;
        }

        if (numberOfComments > 0 && numberOfPosts > 0) {
            this.averageCommentsNumberPerPost = (double) numberOfComments / numberOfPosts;
        } else {
            this.averageCommentsNumberPerPost = 0;
        }
    }

    public void showStatistics() {

    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public double getAveragePostNumbersPerUser() {
        return averagePostNumbersPerUser;
    }

    public double getAverageCommentsNumberPerUser() {
        return averageCommentsNumberPerUser;
    }

    public double getAverageCommentsNumberPerPost() {
        return averageCommentsNumberPerPost;
    }


    @Override
    public String toString() {
        return "StatisticsTester{" +
                "numberOfUsers=" + numberOfUsers +
                ", numberOfPosts=" + numberOfPosts +
                ", numberOfComments=" + numberOfComments +
                ", averagePostNumbersPerUser=" + averagePostNumbersPerUser +
                ", averageCommentsNumberPerUser=" + averageCommentsNumberPerUser +
                ", averageCommentsNumberPerPost=" + averageCommentsNumberPerPost +
                '}';
    }
}
