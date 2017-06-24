package de.hackathon.jove.rest;

class Output<T> {
    private final T result;
    private final String error;
    private final Callback<T> callback;

    Output(T result, Callback<T> callback) {
        this.result = result;
        this.error = null;
        this.callback = callback;
    }


    Output(String error, Callback<T> callback) {
        this.result = null;
        this.error = error;
        this.callback = callback;
    }

    void run() {
        if (error != null) {
            callback.onFailed(error);
        } else {
            callback.onSuccess(result);
        }
    }
}
