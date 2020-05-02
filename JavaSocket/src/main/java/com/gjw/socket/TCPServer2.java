package com.gjw.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer2 {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(8081);
            while (true){
                Socket accept = serverSocket.accept();
                System.out.println("来了一个Client");
                new Thread(new Worker(accept)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
