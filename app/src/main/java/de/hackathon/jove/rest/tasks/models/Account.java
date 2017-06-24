package de.hackathon.jove.rest.tasks.models;

public class Account {
    private final String username;

    public Account(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
