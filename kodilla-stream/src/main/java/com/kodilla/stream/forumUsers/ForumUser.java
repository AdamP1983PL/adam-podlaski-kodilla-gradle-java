package com.kodilla.stream.forumUsers;

import java.time.LocalDate;
import java.util.Objects;

public final class ForumUser {

    private final int identityNumber;
    private final String userName;
    private final Sex sex;
    private final LocalDate dob;
    private final int postsCount;


    public ForumUser(int identityNumber, String userName, Sex sex, LocalDate dob, int postsCount) {
        this.identityNumber = identityNumber;
        this.userName = userName;
        this.sex = sex;
        this.dob = dob;
        this.postsCount = postsCount;
    }

    public int getIdentityNumber() {
        return identityNumber;
    }

    public String getUserName() {
        return userName;
    }

    public Sex getSex() {
        return sex;
    }

    public LocalDate getDob() {
        return dob;
    }

    public int getPostsCount() {
        return postsCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForumUser forumUser = (ForumUser) o;

        if (identityNumber != forumUser.identityNumber) return false;
        if (postsCount != forumUser.postsCount) return false;
        if (!Objects.equals(userName, forumUser.userName)) return false;
        if (sex != forumUser.sex) return false;
        return Objects.equals(dob, forumUser.dob);
    }

    @Override
    public int hashCode() {
        int result = identityNumber;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (dob != null ? dob.hashCode() : 0);
        result = 31 * result + postsCount;
        return result;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "identityNumber=" + identityNumber +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", dob=" + dob +
                ", postsCount=" + postsCount +
                '}';
    }
}
