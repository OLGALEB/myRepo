package webservices;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class NotesService {
    private static String urlBeginning = "https://taschool-notes-service.herokuapp.com";
    HttpMethods httpMethod = new HttpMethods();
    ObjectMapper objectMapper = new ObjectMapper();

    public Note createNote(AccessToken token, Note note) throws IOException {

        String uri = urlBeginning + ConstantsForMethods.GET_ALL_NOTES.getEndpoint();
        String json = objectMapper.writeValueAsString(note);
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-type", "application/json");
        headers.put("Authorization", "Bearer" + token.getAccess_token());
        CloseableHttpResponse response = httpMethod.post(json, uri, headers);
        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity);
        return objectMapper.readValue(content, Note.class);
    }

    public String getAllCreatedNotes(AccessToken token) throws IOException {

        String uri = urlBeginning + ConstantsForMethods.GET_ALL_NOTES.getEndpoint();
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-type", "application/json");
        headers.put("Authorization", "Bearer" + token.getAccess_token());
        CloseableHttpResponse response = httpMethod.get(uri, headers);
        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity);
        return content;
    }


    public String getNoteById(int id, AccessToken token) throws IOException {
        String uri = urlBeginning + ConstantsForMethods.GET_ALL_NOTES.getEndpoint() + "/" + id;
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-type", "application/json");
        headers.put("Authorization", "Bearer" + token.getAccess_token());
        CloseableHttpResponse response = httpMethod.get(uri, headers);
        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity);
        return content;
    }

    public String updateNoteById(int id, AccessToken token) throws IOException {
        String uri = urlBeginning + ConstantsForMethods.GET_ALL_NOTES.getEndpoint() + "/" + id;
        Map<String, String> headers = new HashMap<>();
        String json = "{\"content\":\"TEST\"}";
        headers.put("Content-type", "application/json");
        headers.put("Authorization", "Bearer" + token.getAccess_token());
        CloseableHttpResponse response = httpMethod.put(json, uri, headers);
        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity);
        return content;
    }

    public CloseableHttpResponse deleteNote(int id, AccessToken token) throws IOException {
        String uri = urlBeginning + ConstantsForMethods.GET_ALL_NOTES.getEndpoint() + "/" + id;
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-type", "application/json");
        headers.put("Authorization", "Bearer" + token.getAccess_token());
        CloseableHttpResponse response = httpMethod.delete(uri, headers);
        return response;
    }
}