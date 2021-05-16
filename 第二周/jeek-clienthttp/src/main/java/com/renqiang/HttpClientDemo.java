package com.renqiang;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Author: renqiang
 * @Date: 2021-05-16 21:42
 * @Description: TODO
 */
public class HttpClientDemo {

    public static void main(String[] args) throws IOException {
        String url = "http://localhost:8081";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            if(response.getStatusLine().getStatusCode() == 200){
                System.out.println(EntityUtils.toString(response.getEntity(),"UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(response != null){
                response.close();
            }

            httpClient.close();
        }
    }
}
