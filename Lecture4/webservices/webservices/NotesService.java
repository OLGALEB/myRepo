package webservices;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class NotesService {

    public Notes createNote(User user) throws IOException {

        String uri = ConstantsForMethods.GET_ALL_NOTES.getEndpoint();
        String json = "{\"content\":\"test\"}";
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-type", "application/json");
        headers.put("Authorization", "Bearer" + user.getToken());
        CloseableHttpResponse response = HttpMethods.post(json, uri, headers);
        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity);
        ObjectMapper objectMapper = new ObjectMapper();
        Notes note = objectMapper.readValue(content, Notes.class);
        return note;
    }


    public String getAllCreatedNotes(User user) throws IOException {

        String uri = ConstantsForMethods.GET_ALL_NOTES.getEndpoint();
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-type", "application/json");
        headers.put("Authorization", "Bearer" + user.getToken());
        CloseableHttpResponse response = HttpMethods.get(uri, headers);
        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity);
        return content;
    }


    public String getNoteById(int id, User user) throws IOException {
        String uri = ConstantsForMethods.GET_ALL_NOTES.getEndpoint() + "/" + id;
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-type", "application/json");
        headers.put("Authorization", "Bearer" + user.getToken());
        CloseableHttpResponse response = HttpMethods.get(uri, headers);
        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity);
        return content;
    }

    public String updateNoteById(int id, User user) throws IOException {
        String uri = ConstantsForMethods.GET_ALL_NOTES.getEndpoint() + "/" + id;
        Map<String, String> headers = new HashMap<>();
        String json = "{\"content\":\"TEST\"}";
        headers.put("Content-type", "application/json");
        headers.put("Authorization", "Bearer" + user.getToken());
        CloseableHttpResponse response = HttpMethods.put(json, uri, headers);
        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity);
        return content;

    }

    public CloseableHttpResponse deleteNote(int id, User user) throws IOException {
        String uri = ConstantsForMethods.GET_ALL_NOTES.getEndpoint() + "/" + id;
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-type", "application/json");
        headers.put("Authorization", "Bearer" + user.getToken());
        CloseableHttpResponse response = HttpMethods.delete(uri, headers);
        return response;
    }
}