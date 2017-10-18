package com.spaja.oauthexample.model;

/**
 * Created by Spaja on 31-Jul-17.
 */

public class Response {

    private String action;
    private boolean success;
    private String message;
    private String data;

    public String getAction() {
        return action;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getData() {
        return data;
    }
}
