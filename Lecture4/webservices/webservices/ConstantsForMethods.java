package webservices;

public enum ConstantsForMethods {

    REGISTER_USER("/v1/accounts"),
    GET_TOKEN("/oauth/token"),
    GET_ALL_NOTES("/v1/notes");

    String endpoint;

    ConstantsForMethods(String endpoint) {

        this.endpoint = endpoint;
    }
    public String getEndpoint() {
        return endpoint;
    }
}