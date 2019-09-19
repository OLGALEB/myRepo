import com.braintreegateway.util.Sha1Hasher;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CreatedSignature {
    private static InputStream inputStream;

    public String getPublicKey() throws IOException {
        String publicKey = getKey("braintree_public_key");
        return publicKey;
    }

    public String getPrivateKey() throws IOException {
        String privateKey = getKey("braintree_private_key");
        return privateKey;
    }

    private String getKey(String key) throws IOException {
        Properties properties = new Properties();
        String propertiesFileName = "Keys.properties";
        inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);

        if (inputStream != null) {
            properties.load(inputStream);
        } else {
            throw new FileNotFoundException("File was not found!Check file name or file path");
        }
        String keyValue = properties.getProperty(key);

        return keyValue;
    }

    public String signatureGenerate(String encodedXml) throws IOException {
        String signature = String.format("%s|%s",
                getPublicKey(),
                (new Sha1Hasher()).hmacHash(getPrivateKey(), encodedXml));
        return signature;
    }
}