package de.hackathon.jove.rest.tasks;


import de.hackathon.jove.rest.JsonArrayHttpTask;
import de.hackathon.jove.rest.JsonObjectHttpTask;
import de.hackathon.jove.rest.tasks.models.Company;
import de.hackathon.jove.rest.tasks.models.Login;

public class AllCompaniesTask extends JsonArrayHttpTask<Company> {

    public AllCompaniesTask() {
        super("http://185.26.156.39:61601/companies/all", Company.class);
    }
}
