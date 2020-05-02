package com.gjw.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        try {
            //服务端先开启一个通道
            Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 8081);
            //通道输入流 获取服务端发过来的数据
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                //读取输入的数据
                String s = reader1.readLine();
                if (s.equalsIgnoreCase("quit")){
                    break;
                }else {
                    System.out.println("我想传数据:"+s);
                    dataOutputStream.writeBytes(s+System.getProperty("line.separator"));
                    System.out.println("Server said:"+reader.readLine());
                }

            }
            dataOutputStream.close();
            reader.close();
            reader1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
