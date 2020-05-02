package com.gjw.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP:面向连接,保证可靠性传输的协议
 * 1.服务器:创建一个ServerSocket,等待连接:BIO阻塞的
 * 2.客户机:创建一个Socket,连接到服务器
 * 3.服务器:ServerSocket接收到连接,创建一个Socket和客户建立专线连接,后续服务器和客户机的对话
 * 会在一个单独的线程上运行
 * 4.服务器的ServerSocket继续等待连接
 * ServerSocket 服务器码头:需要绑定port和ip
 * Socket:运输通道
 * 客户端需要绑定服务器的地址和port
 * 客户端往Socket输入流写入数据,送到服务端
 * 客户端从Socket输出流取出服务端传过来的数据
 * 服务端反之亦然
 * Server等待响应:处于阻塞状态
 * 服务端可以同时响应多个客户端
 * 服务端每接收一个客户端,就会开启一个新的线程
 * 客户端或者服务器可以选择关闭这对Socket通道
 *
 * 实例
 * 服务端先启动,且一直保留
 * 客户端后启动,可以先退出
 */
public class TCPServer {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(8081);//驻留在8081端口
            Socket accept = serverSocket.accept();//阻塞,知道有客户端连接上来
            InputStream inputStream = accept.getInputStream();//有人连接上来打开输入流
            OutputStream outputStream = accept.getOutputStream();//打开输出流
            //同一个通道,服务器的输出流就是客户端的输入流,服务器的输入流就是客户端的输出流
            outputStream.write("hello,client".getBytes());//发给客户端
            //接收客户端的数据
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            //从客户端读取
            System.out.println("Client said:"+reader.readLine());
            outputStream.close();
            inputStream.close();
            accept.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
