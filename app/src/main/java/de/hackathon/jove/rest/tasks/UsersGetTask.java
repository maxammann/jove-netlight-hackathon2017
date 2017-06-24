package de.hackathon.jove.rest.tasks;

import de.hackathon.jove.rest.JsonArrayHttpTask;
import de.hackathon.jove.rest.tasks.models.User;

public class UsersGetTask extends JsonArrayHttpTask<User> {

    protected UsersGetTask() {
        super("http://gametec.eu", User.class);
    }
}
