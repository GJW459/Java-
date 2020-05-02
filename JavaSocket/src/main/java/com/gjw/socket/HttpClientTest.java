package com.gjw.socket;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;

public class HttpClientTest {

    @Test
    public void testdoGet(){
        //获得客户端
        CloseableHttpClient build = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        //响应体
        CloseableHttpResponse httpResponse=null;
        try {
            httpResponse=build.execute(httpGet);
            //返回响应实体
            HttpEntity entity = httpResponse.getEntity();
            System.out.println(httpResponse.getStatusLine());
            if (entity!=null){
                System.out.println(entity.getContentType());
                System.out.println(entity.getContentEncoding());
                System.out.println(entity.getContentLength());
            }
            httpResponse.close();
            build.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
