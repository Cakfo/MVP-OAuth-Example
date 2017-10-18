package com.spaja.oauthexample.model;

/**
 * Created by Spaja on 31-Jul-17.
 */

public class Token {

    private String access_token;
    private String expires_in;
    private String token_type;
    private String scope;

    public String getAccess_token() {
        return access_token;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public String getToken_type() {
        return token_type;
    }

    public String getScope() {
        return scope;
    }
}
