package de.hackathon.jove.rest.tasks;


import de.hackathon.jove.rest.JsonObjectHttpTask;
import de.hackathon.jove.rest.tasks.models.Account;

public class LoginTask extends JsonObjectHttpTask<Account> {

    public LoginTask() {
        super("https://httpbin.org/get", Account.class);
    }
}
