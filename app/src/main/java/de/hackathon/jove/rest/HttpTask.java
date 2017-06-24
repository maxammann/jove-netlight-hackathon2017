package de.hackathon.jove.rest;

import android.os.AsyncTask;

import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public abstract class HttpTask<T> extends AsyncTask<Input<T>, Integer, Output<T>> {

    private final URL url;


    protected HttpTask(String url) {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException();
        }
    }

    protected HttpTask(URL url) {
        this.url = url;
    }

    @SuppressWarnings("unchecked")
    public HttpTask<T> exectute(HttpContext httpContext, Callback<T> callback) {
        execute(new Input<>(httpContext, url, callback));
        return this;
    }

    @SafeVarargs
    @Override
    protected final Output<T> doInBackground(Input<T>... inputs) {
        Input<T> input = inputs[0];

        try {
            OkHttpClient client = new OkHttpClient.Builder()
                    .cookieJar(input.getHttpContext().getCookieStore())
                    .build();
            Request request = new Request.Builder()
                    .url(input.getUrl())
                    .build();

            Response response = client.newCall(request).execute();
            ResponseBody body = response.body();
            if (body == null) {
                return new Output<>("Request failed", input.getCallback());
            }
            T result = transformResponse(body.string());
            return new Output<>(result, input.getCallback());
        } catch (Exception e) {
            return new Output<>(e.getMessage(), input.getCallback());
        }
    }

    public abstract T transformResponse(String response) throws Exception;

    @Override
    protected void onPostExecute(Output<T> output) {
        output.run();
    }

}
