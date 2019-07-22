package webservices;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;

public class AppRunner {

    public static void main(String[] args) throws IOException {

        HttpMethods.createClient();
        User user = new User(String.format("test%s@test.com", System.currentTimeMillis()), "test234");

        UserService userAuthAndRegistration = new UserService();
        System.out.println("Created user: " + userAuthAndRegistration.createUser(user));
        System.out.println("User registration info:" + userAuthAndRegistration.tokenTake(user));

        NotesService notes = new NotesService();
        Notes note = notes.createNote(user);
        System.out.println("Сreated Note1" + note);
        System.out.println("Сreated Note2" + notes.createNote(user));
        System.out.println("Get all notes:" + notes.getAllCreatedNotes(user));
        System.out.println("Get notes by id:" + notes.getNoteById(note.getId(), user));
        System.out.println("Update note by id:" + notes.updateNoteById(note.getId(), user));
        System.out.println("Delete note by id: " + notes.deleteNote(note.getId(), user));

        HttpMethods.closeClient();
    }
}