package com.bhargav;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * Created by Bhargav on 04/03/2019.
 */
public class HTTPClient {

    public String get(String url) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpclient.execute(httpGet);
        StringBuilder responseString = new StringBuilder();
        try {
            HttpEntity entity = response.getEntity();
            BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent()));
            String line = br.readLine();
            while(line != null) {
                responseString.append(line);
                responseString.append("\n");
                line = br.readLine();
            }
            EntityUtils.consume(entity);
        } finally {
            response.close();
        }

        return responseString.toString();
    }


}
