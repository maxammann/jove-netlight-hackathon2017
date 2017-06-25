package de.hackathon.jove.rest.tasks;


import de.hackathon.jove.rest.JsonObjectHttpTask;
import de.hackathon.jove.rest.tasks.models.Login;

public class LoginTask extends JsonObjectHttpTask<Login> {

    public LoginTask(String username, String password) {
        super("http://185.26.156.39:61601/accounts/login?username=" + username + "&password=" + password, Login.class);
    }
}
