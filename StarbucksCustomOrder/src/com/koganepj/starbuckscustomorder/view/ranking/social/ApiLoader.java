package com.koganepj.starbuckscustomorder.view.ranking.social;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

class ApiLoader {
    
    public static final String API_URL = "http://www1415uo.sakura.ne.jp/ranking.php";
    
    InputStream load() {
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(API_URL);
        
        try {
            HttpResponse response = client.execute(httpGet);
            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                return response.getEntity().getContent();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
}
