package webservices;

import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;
import java.util.Map;

public class HttpMethods {


    private CloseableHttpClient client;
    private String urlBeginning;


    public HttpMethods(String urlBeginning, CloseableHttpClient client) {
        this.urlBeginning = urlBeginning;
        this.client = client;
    }

    public CloseableHttpResponse post(String json, String path, Map<String, String> headers) throws IOException {
        String baseUrl = urlBeginning + path;
        HttpPost httpPost = new HttpPost(baseUrl);
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        headers.forEach((key, value) -> httpPost.setHeader(key, value));
        return client.execute(httpPost);
    }

    public CloseableHttpResponse get(String path, Map<String, String> headers) throws IOException {
        String baseUrl = urlBeginning + path;
        HttpGet httpGet = new HttpGet(baseUrl);
        headers.forEach((key, value) -> httpGet.setHeader(key, value));
        return client.execute(httpGet);
    }

    public CloseableHttpResponse put(String json, String path, Map<String, String> headers) throws IOException {
        String baseUrl = urlBeginning + path;
        HttpPut httpPut = new HttpPut(baseUrl);
        StringEntity entity = new StringEntity(json);
        httpPut.setEntity(entity);
        headers.forEach((key, value) -> httpPut.setHeader(key, value));
        return client.execute(httpPut);
    }

    public CloseableHttpResponse delete(String path, Map<String, String> headers) throws IOException {
        String baseUrl = urlBeginning + path;
        HttpDelete httpDelete = new HttpDelete(baseUrl);
        headers.forEach((key, value) -> httpDelete.setHeader(key, value));
        return client.execute(httpDelete);
    }
}