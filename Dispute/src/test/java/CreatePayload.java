import java.io.IOException;
import java.util.Base64;
import java.util.Map;

public class CreatePayload {
    public static String decodeXmlNotificationToPayload(Map<String, String> replaceValue) throws IOException, ClassNotFoundException {
        String replacedXml;
        String baseXml = FileReaderUtil.readXml();
        for (Map.Entry<String, String> entry : replaceValue.entrySet()) {
            baseXml = baseXml.replace(entry.getKey(), entry.getValue());
        }
        replacedXml = Base64.getEncoder().encodeToString(baseXml.getBytes()).replace("\r", "");
        return replacedXml;
    }
}