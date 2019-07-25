package webservices;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class AppRunner {

    private static HttpMethods httpMethod = new HttpMethods();
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        httpMethod.createClient();

        User user = new User(String.format("test%s@test.com", System.currentTimeMillis()), "test234");

        UserService userAuthAndRegistration = new UserService(httpMethod, objectMapper);
        System.out.println("Created user: " + userAuthAndRegistration.createUser(user));

        AccessToken userToken = userAuthAndRegistration.tokenTake(user);
        String userTokenField = userToken.getAccess_token();

        Note noteToCreate = new Note("test");
        NotesService notesService = new NotesService(httpMethod, objectMapper);

        Note note = notesService.createNote(userTokenField, noteToCreate);
        System.out.println("Сreated Note1" + note);
        System.out.println("Сreated Note2" + notesService.createNote(userTokenField, noteToCreate));
        System.out.println("Get all notesService:" + notesService.getAllCreatedNotes(userTokenField));
        System.out.println("Get notesService by id:" + notesService.getNoteById(note.getId(), userTokenField));
        System.out.println("Update note by id:" + notesService.updateNoteById(note.getId(), userTokenField, note));
        System.out.println("Delete note by id: " + notesService.deleteNote(note.getId(), userTokenField));
        httpMethod.closeClient();
    }
}