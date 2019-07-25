package webservices;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccessToken {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty ("token_type")
    private String tokenType;
    @JsonProperty("expires_in")
    private int expiresIn;
    private String scope;

    public String getAccess_token() {
        return accessToken;
    }

    public String getToken_type() {
        return tokenType;
    }

    public int getExpires_in() {
        return expiresIn;
    }

    public String getScope() {
        return scope;
    }
}