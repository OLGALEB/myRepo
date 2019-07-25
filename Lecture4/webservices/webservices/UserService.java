package webservices;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserService {
    private static String urlBeginning = "https://taschool-notes-service.herokuapp.com";
    HttpMethods httpMethod;
    ObjectMapper objectMapper;

    public UserService(HttpMethods httpMethod, ObjectMapper objectMapper) {
        this.httpMethod = httpMethod;
        this.objectMapper = objectMapper;
    }

    public User createUser(User user) throws IOException {
        String uri = urlBeginning + ConstantsForMethods.REGISTER_USER.getEndpoint();
        String json = objectMapper.writeValueAsString(user);
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        headers.put("Content-type", "application/json");
        CloseableHttpResponse response = httpMethod.post(json, uri, headers);
        String userResponse = EntityUtils.toString(response.getEntity());
        return objectMapper.readValue(userResponse, User.class);
    }

    public AccessToken tokenTake(User user) throws IOException {
        String uri = urlBeginning + ConstantsForMethods.GET_TOKEN.getEndpoint();
        String json = "?grant_type=password&scope=read+write&username=" + user.getEmail() + "&password=" + user.getPassword();
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Basic Y2xpZW50OnNlY3JldA==");
        headers.put("Content-type", "application/x-www-form-urlencoded");
        CloseableHttpResponse response = httpMethod.post(json, uri + json, headers);
        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity);
        return objectMapper.readValue(content, AccessToken.class);
    }
}