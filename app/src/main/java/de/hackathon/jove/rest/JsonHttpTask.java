package de.hackathon.jove.rest;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

abstract class JsonHttpTask<T> extends HttpTask<T> {

    private ObjectMapper mapper = new ObjectMapper();
    private JsonFactory jsonFactory = new JsonFactory();

    JsonHttpTask(String url) {
        super(url);
        ;
    }

    JsonHttpTask(URL url) {
        super(url);
    }

    ObjectMapper getMapper() {
        return mapper;
    }

    public TreeNode getResult(String response) throws IOException {
        JsonParser parser = jsonFactory.createParser(response);
        return mapper.readTree(parser).path("result");
    }
}
