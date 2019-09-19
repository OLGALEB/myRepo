import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PpsClient {
    private CloseableHttpClient client = HttpClients.createDefault();
    private final static String PPS_URL = "http://sh-qa-prasappv-01.cloud.playtika.com/payment-service";

    public CloseableHttpResponse sendDisputeToPPS(String payload, String signature, Map<String, String> headers) throws IOException {
        List<NameValuePair> requestForm = new ArrayList<>();
        requestForm.add(new BasicNameValuePair("bt_payload", payload));
        requestForm.add(new BasicNameValuePair("bt_signature", signature));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(requestForm, Consts.UTF_8);
        HttpPost httpPost = new HttpPost(PPS_URL);
        httpPost.setEntity(entity);
        headers.put("Content-type", "application/x-www-form-urlencoded");
        return client.execute(httpPost);
    }
}