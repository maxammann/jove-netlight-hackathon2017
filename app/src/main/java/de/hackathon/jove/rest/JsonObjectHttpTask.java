package de.hackathon.jove.rest;

import java.net.URL;

public class JsonObjectHttpTask<T> extends JsonHttpTask<T> {

    private final Class<? extends T> type;

    protected JsonObjectHttpTask(String url, Class<? extends T> type) {
        super(url);
        this.type = type;
    }

    protected JsonObjectHttpTask(URL url, Class<? extends T> type) {
        super(url);
        this.type = type;
    }

    @Override
    public T transformResponse(String response) throws Exception {
        return getMapper().treeToValue(getResult(response), type);
    }
}
