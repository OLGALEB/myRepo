package webservices;

import java.io.IOException;

public class AppRunner {

    public static void main(String[] args) throws IOException {
        HttpMethods workWithClient = new HttpMethods();

        workWithClient.createClient();

        User user = new User(String.format("test%s@test.com", System.currentTimeMillis()), "test234");

        UserService userAuthAndRegistration = new UserService();
        System.out.println("Created user: " + userAuthAndRegistration.createUser(user));
        AccessToken userToken = userAuthAndRegistration.tokenTake(user);

        Note noteToCreate = new Note("test");
        NotesService notesService = new NotesService();

        Note note = notesService.createNote(userToken, noteToCreate);
        System.out.println("Сreated Note1" + note);
        System.out.println("Сreated Note2" + notesService.createNote(userToken, noteToCreate));
        System.out.println("Get all notesService:" + notesService.getAllCreatedNotes(userToken));
        System.out.println("Get notesService by id:" + notesService.getNoteById(note.getId(), userToken));
        System.out.println("Update note by id:" + notesService.updateNoteById(note.getId(), userToken));
        System.out.println("Delete note by id: " + notesService.deleteNote(note.getId(), userToken));
        workWithClient.closeClient();
    }
}