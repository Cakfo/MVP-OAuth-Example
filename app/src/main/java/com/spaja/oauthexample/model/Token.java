package com.spaja.oauthexample.model;

/**
 * Created by Spaja on 31-Jul-17.
 */

public class Token {

    private String access_token;
    private String expires_in;
    private String token_type;
    private String scope;

    public String getAccessToken() {
        return access_token;
    }

    public String getExpiresIn() {
        return expires_in;
    }

    public String getTokenType() {
        return token_type;
    }

    public String getScope() {
        return scope;
    }
}
