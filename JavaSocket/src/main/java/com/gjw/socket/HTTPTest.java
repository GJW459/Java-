package com.gjw.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * 网络访问是一种特殊的网络服务
 * 在浏览器中输入一个URL
 * 浏览器就和远程服务器建立连接(ip+port)
 * 请求从远程服务器上下载HTML文件存储到本地临时文件中
 * 浏览器显示HTML页面
 *
 * HTTP协议:超文本传输协议
 * 用于从万维网下载HTML文件到本地的传输协议
 * 资源文件以HTML文件编写,以URL形式向外暴露
 * http访问方式
 * GET:从服务器上获取资源
 * POST:向服务器提供数据
 * URL代表一个资源
 * URLConnection获取资源的连接器
 * connect方法,建立和资源的连接通道
 * getInputStream获取资源内容
 */
public class HTTPTest {
    public static void main(String[] args) {

        String urlName="http://www.baidu.com";
        try {
            URL url = new URL(urlName);
            URLConnection urlConnection = url.openConnection();
            //建立连接
            urlConnection.connect();
            //打开http头部信息
            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
            for (Map.Entry<String,List<String>> entry: headerFields.entrySet()){
                String key = entry.getKey();
                for (String value : entry.getValue()) {
                    System.out.println(key+":"+value);
                }
            }
            //输出将要收到的内容属性信息
            System.out.println("-------------");
            System.out.println(urlConnection.getContentType());
            System.out.println(urlConnection.getContentLength());
            System.out.println(urlConnection.getContentEncoding());
            System.out.println(urlConnection.getDate());
            System.out.println(urlConnection.getExpiration());
            System.out.println(urlConnection.getLastModified());
            System.out.println("--------------");
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            //输出收到内容
            String line="";
            while ((line=reader.readLine())!=null){
                System.out.println(line);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
