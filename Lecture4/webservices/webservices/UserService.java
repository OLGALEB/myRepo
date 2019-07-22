package webservices;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserService {
    public String createUser(User user) throws IOException {
        String uri = ConstantsForMethods.REGISTER_USER.getEndpoint();
        String json = "{\"email\":\"" + user.getEmail() + "\", \"password\":\"" + user.getPassword() + "\"}";

        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        headers.put("Content-type", "application/json");
        CloseableHttpResponse response = HttpMethods.post(json, uri, headers);
        return String.valueOf(response);
    }

    public String tokenTake(User user) throws IOException {
        String uri = ConstantsForMethods.GET_TOKEN.getEndpoint();

        String json = "?grant_type=password&scope=read+write&username=" + user.getEmail() + "&password=" + user.getPassword();
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Basic Y2xpZW50OnNlY3JldA==");
        headers.put("Content-type", "application/x-www-form-urlencoded");
        CloseableHttpResponse response = HttpMethods.post(json, uri + json, headers);
        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity);
        ObjectMapper objectMapper = new ObjectMapper();
        AccessToken token = objectMapper.readValue(content, AccessToken.class);
        user.setToken(token.access_token);
        return String.valueOf(content);
    }
}