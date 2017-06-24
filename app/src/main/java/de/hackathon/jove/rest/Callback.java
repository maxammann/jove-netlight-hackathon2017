package de.hackathon.jove.rest;

public interface Callback<T> {

    void onSuccess(T result);

    void onFailed(String error);
}
