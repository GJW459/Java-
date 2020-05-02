package com.gjw.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * UDP是用户数据协议:面向无连接的协议,数据从一个ip的port出发,运输到另一个ip的port
 * 如果这个接受者,刚刚在目的地,就接收到数据,否则数据消失,因此发送者也不知道数据发到没有
 * UDP好处: 经济,简单
 * 核心类
 * DatagramSocket:通讯的数据管道
 * - send和receive方法
 * -绑定一个ip和port
 * DatagramPacket 集装箱:封装数据
 * 地址标签:目的地IP+Port
 * 实例
 * -无主次之分
 * 接收方必须早于发起方执行
 * 默认的IO为BIO 阻塞IO
 */
public class UDPRec {
    //通过UDP编程接收UDP协议传过来的数据

    public static void main(String[] args) throws Exception {
        //接收方的数据通信管道 端口号为3000的通道
        DatagramSocket datagramSocket = new DatagramSocket(3000);
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 1024);
        System.out.println("UDPRec正在等待消息:");
        //如果一直没有UDP数据传送过来就会一直阻塞
        datagramSocket.receive(datagramPacket);
        System.out.println("UDPRec接收到数据");
        String str = new String(datagramPacket.getData(), 0, datagramPacket.getLength())+"from"
                +datagramPacket.getAddress().getHostAddress()+":"+datagramPacket.getPort();
        System.out.println(str);
        Thread.sleep(1000);
        System.out.println("UDPRecv:我要发送消息");
        String str2="hello world222";
        DatagramPacket datagramPacket1 = new DatagramPacket(str2.getBytes(),str2.length(), InetAddress.getByName("127.0.0.1"),datagramPacket.getPort());
        datagramSocket.send(datagramPacket1);
        System.out.println("UDPRec发送消息完成");
        datagramSocket.close();

    }
}
