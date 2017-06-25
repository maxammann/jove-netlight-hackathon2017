package de.hackathon.jove.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;

import org.apache.commons.collections4.IteratorUtils;

import java.net.URL;
import java.util.Iterator;
import java.util.List;


public class JsonArrayHttpTask<T> extends JsonHttpTask<List<T>> {

    private final Class<? extends T> type;

    protected JsonArrayHttpTask(String url, Class<? extends T> type) {
        super(url);
        this.type = type;
    }

    protected JsonArrayHttpTask(URL url, Class<? extends T> type) {
        super(url);
        this.type = type;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> transformResponse(String response) throws Exception {
        JavaType jt = getMapper().getTypeFactory().constructCollectionType(List.class, type);
        Object values = getMapper().readValue(getMapper().treeAsTokens(getResult(response)), jt);
        return (List<T>) values;
    }
}
