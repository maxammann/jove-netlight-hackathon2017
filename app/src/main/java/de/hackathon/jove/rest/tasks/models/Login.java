package de.hackathon.jove.rest.tasks.models;

public class Login {
    private String token;

    public Login() {

    }

    public Login(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
