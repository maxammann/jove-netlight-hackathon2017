package de.hackathon.jove.rest;

import java.net.URL;

class Input<T> {
    private final HttpContext httpContext;
    private final URL url;
    private final Callback<T> callback;

    Input(HttpContext httpContext, URL url, Callback<T> callback) {
        this.httpContext = httpContext;
        this.url = url;
        this.callback = callback;
    }

    URL getUrl() {
        return url;
    }

    Callback<T> getCallback() {
        return callback;
    }

    public HttpContext getHttpContext() {
        return httpContext;
    }
}
