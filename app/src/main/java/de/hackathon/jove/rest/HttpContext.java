package de.hackathon.jove.rest;

public class HttpContext {
    private final CookieStore cookieStore;

    public HttpContext() {
        cookieStore = new CookieStore();
    }

    public CookieStore getCookieStore() {
        return cookieStore;
    }
}
