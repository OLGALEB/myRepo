package webservices;

public enum ConstantsForMethods {

    REGISTER_USER("https://taschool-notes-service.herokuapp.com/v1/accounts"),
    GET_TOKEN("https://taschool-notes-service.herokuapp.com/oauth/token"),
    GET_ALL_NOTES("https://taschool-notes-service.herokuapp.com/v1/notes");

    String endpoint;

    ConstantsForMethods(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }
}