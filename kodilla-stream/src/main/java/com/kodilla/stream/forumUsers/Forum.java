package com.kodilla.stream.forumUsers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {

    private final List<ForumUser> forumUsersList = new ArrayList<>();

    public Forum() {
        forumUsersList.add(new ForumUser(1, "Robo_xyz", Sex.M, LocalDate.of(1985, 1, 23), 26));
        forumUsersList.add(new ForumUser(2, "Marta", Sex.F, LocalDate.of(2012, 1, 23), 226));
        forumUsersList.add(new ForumUser(3, "User777", Sex.M, LocalDate.of(1990, 1, 23), 6));
        forumUsersList.add(new ForumUser(4, "FunUser", Sex.F, LocalDate.of(1985, 1, 23), 22226));
        forumUsersList.add(new ForumUser(5, "Robo_abc", Sex.M, LocalDate.of(1970, 11, 23), 26234));
    }

    public List<ForumUser> getForumUsersList(){
        return new ArrayList<>(forumUsersList);
    }
}
