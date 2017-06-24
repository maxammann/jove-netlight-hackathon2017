package de.hackathon.jove.rest;

public class RESTClient {

    private final HttpContext context;

    public RESTClient() {
        context = new HttpContext();
    }

    public <T> HttpTask<T> execute(HttpTask<T> task, Callback<T> callback) {
        return task.exectute(context, callback);
    }

    public HttpContext getContext() {
        return context;
    }
}
