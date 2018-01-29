package kon.blats.rest;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by k.blatsoukas on 10/24/2017.
 */

public class Client {

    public static void main(String[] args) throws IOException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
        Runnable task = () -> {
            try {
                sendTransaction();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        scheduledExecutorService.scheduleAtFixedRate(task, 0, 13, TimeUnit.MINUTES);
    }

    public static void sendTransaction() throws IOException {
        try {
            CredentialsProvider provider = new BasicCredentialsProvider();
            UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("apiuser@ola.com", "kostas");
            provider.setCredentials(AuthScope.ANY, credentials);
            HttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
            HttpPost httpPost = new HttpPost("http://localhost:80/v5/nikos");
            String json = getJsonExample();
            StringEntity entity = new StringEntity(json, "application/json","UTF-8");
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            System.out.println("Transaction sent!!");
            HttpResponse response = client.execute(httpPost);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String getJsonExample() {
        return "{\n" +
                " \"id\": \"string\",\n" +
                "}";
    }

}
