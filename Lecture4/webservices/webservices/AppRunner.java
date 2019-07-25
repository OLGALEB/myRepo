package webservices;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class AppRunner {

    public static void main(String[] args) throws IOException {
        CloseableHttpClient client = null;
        try {
            client = HttpClients.createDefault();

            HttpMethods httpMethod = new HttpMethods("https://taschool-notes-service.herokuapp.com", client);
            ObjectMapper objectMapper = new ObjectMapper();


            User user = new User(String.format("test%s@test.com", System.currentTimeMillis()), "test234");

            UserService userAuthAndRegistration = new UserService(httpMethod, objectMapper);
            System.out.println("Created user: " + userAuthAndRegistration.createUser(user));

            AccessToken userToken = userAuthAndRegistration.tokenTake(user);
            String userTokenField = userToken.getAccessToken();

            Note noteToCreate = new Note("test");
            NotesService notesService = new NotesService(httpMethod, objectMapper);

            Note note = notesService.createNote(userTokenField, noteToCreate);
            System.out.println("Сreated Note1" + note);
            System.out.println("Сreated Note2" + notesService.createNote(userTokenField, noteToCreate));
            System.out.println("Get all notesService:" + notesService.getAllCreatedNotes(userTokenField));
            System.out.println("Get notesService by id:" + notesService.getNoteById(note.getId(), userTokenField));
            System.out.println("Update note by id:" + notesService.updateNoteById(note.getId(), userTokenField, note));
            System.out.println("Delete note by id: " + notesService.deleteNote(note.getId(), userTokenField));
        } finally {
            if (client != null) {
                client.close();
            }
        }
    }
}