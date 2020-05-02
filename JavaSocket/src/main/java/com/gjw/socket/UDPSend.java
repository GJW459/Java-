package com.gjw.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class UDPSend {

    public static void main(String[] args) throws Exception {

        DatagramSocket datagramSocket = new DatagramSocket();
        String str="hello java";
        DatagramPacket datagramPacket = new DatagramPacket(str.getBytes(),str.length(), InetAddress.getByName("127.0.0.1"),3000);
        System.out.println("我要开始发消息了");
        datagramSocket.send(datagramPacket);
        System.out.println("消息发完了");
        Thread.sleep(1000);
        //接收消息
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket1 = new DatagramPacket(bytes, 1024);
        System.out.println("开始接收消息");
        datagramSocket.receive(datagramPacket1);
        System.out.println("消息接收完成");
        String s = new String(datagramPacket1.getData(),0,datagramPacket1.getLength())+"from"+datagramPacket1.getAddress().getHostAddress()
                +":"+datagramPacket1.getPort();
        System.out.println(s);
    }
}
