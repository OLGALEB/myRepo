
package webservices;

import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.Map;


public class HttpMethods {
    private static CloseableHttpClient client;

    public static void createClient() {
        client = HttpClients.createDefault();
    }

    public static void closeClient() throws IOException {
        client.close();
    }

    public static CloseableHttpResponse post(String json, String uri, Map<String, String> headers) throws IOException {
        HttpPost httpPost = new HttpPost(uri);
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        for (String i : headers.keySet()) {
            httpPost.setHeader(i, headers.get(i));
        }
        return client.execute(httpPost);
    }

    public static CloseableHttpResponse get(String uri, Map<String, String> headers) throws IOException {
        HttpGet httpGet = new HttpGet(uri);

        for (String i : headers.keySet()) {
            httpGet.setHeader(i, headers.get(i));
        }
        return client.execute(httpGet);
    }

    public static CloseableHttpResponse put(String json, String uri, Map<String, String> headers) throws IOException {
        HttpPut httpPut = new HttpPut(uri);
        StringEntity entity = new StringEntity(json);
        httpPut.setEntity(entity);
        for (String i : headers.keySet()) {
            httpPut.setHeader(i, headers.get(i));
        }
        return client.execute(httpPut);
    }

    public static CloseableHttpResponse delete(String uri, Map<String, String> headers) throws IOException {
        HttpDelete httpDelete = new HttpDelete(uri);
        for (String i : headers.keySet()) {
            httpDelete.setHeader(i, headers.get(i));
        }
        return client.execute(httpDelete);
    }
}