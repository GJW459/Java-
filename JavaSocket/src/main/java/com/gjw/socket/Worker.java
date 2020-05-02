package com.gjw.socket;

import java.io.*;
import java.net.Socket;

public class Worker implements Runnable {

    private Socket socket;
    public Worker(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {

        try {
            System.out.println("服务人员启动");
            //获取客户端传过来的数据
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (true){
                String str = reader.readLine();
                System.out.println("client said:"+str+":"+str.length());
                if ("quit".equalsIgnoreCase(str)){
                    break;
                }
                String str2=str+"666";
                dataOutputStream.writeBytes(str2);

            }
            reader.close();
            dataOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
