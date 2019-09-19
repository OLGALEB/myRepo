import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderUtil {

    public static String readXml() throws IOException {
        File file = new File("Dispute/src/test/resources/Dispute.xml");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        String result = "";
        while ((line = bufferedReader.readLine()) != null) {
            result = result + line;
        }
        return result;
    }
}