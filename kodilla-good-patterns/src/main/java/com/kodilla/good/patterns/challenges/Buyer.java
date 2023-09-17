package com.kodilla.good.patterns.challenges;

public class Buyer {

    private String firstName;
    private String lastName;
    private String email;
    private long id;

    public Buyer(String firstName, String lastName, String email, long id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public long getId() {
        return id;
    }
}
