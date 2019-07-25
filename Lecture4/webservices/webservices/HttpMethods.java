package webservices;

import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.Map;

public class HttpMethods {
    private CloseableHttpClient client;

    public void createClient() {
        client = HttpClients.createDefault();
    }

    public void closeClient() throws IOException {
        client.close();
    }

    public CloseableHttpResponse post(String json, String uri, Map<String, String> headers) throws IOException {
        HttpPost httpPost = new HttpPost(uri);
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        headers.forEach((key, value) -> httpPost.setHeader(key, value));
        return client.execute(httpPost);
    }

    public CloseableHttpResponse get(String uri, Map<String, String> headers) throws IOException {
        HttpGet httpGet = new HttpGet(uri);
        headers.forEach((key, value) -> httpGet.setHeader(key, value));
        return client.execute(httpGet);
    }

    public CloseableHttpResponse put(String json, String uri, Map<String, String> headers) throws IOException {
        HttpPut httpPut = new HttpPut(uri);
        StringEntity entity = new StringEntity(json);
        httpPut.setEntity(entity);
        headers.forEach((key, value) -> httpPut.setHeader(key, value));
        return client.execute(httpPut);
    }

    public CloseableHttpResponse delete(String uri, Map<String, String> headers) throws IOException {
        HttpDelete httpDelete = new HttpDelete(uri);
        headers.forEach((key, value) -> httpDelete.setHeader(key, value));
        return client.execute(httpDelete);
    }
}