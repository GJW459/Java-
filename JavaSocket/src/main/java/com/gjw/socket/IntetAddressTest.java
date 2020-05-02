package com.gjw.socket;

import org.junit.Test;

/**
 * 一,网络编程的两个问题
 * 1.如何定位网络上的一台主机或者多台主机,定位主机上的特定应用
 * 2.找到主机之后如何可靠高效地实现数据传输
 *
 * 二,网络编程的两大要素
 * 1.对应问题一:IP和port
 * 2.对于问题二:提供网络通信协议:TCP/IP参考模型(应用层,传输层,网络层,物理+数据链路层)
 *
 * 三,通信的要素:IP和port
 * 1.IP:唯一的标识网络上的计算机
 * 2.在Java中使用InetAddress类表示IP=>类比于File类
 * 3.IP分类:IPv4和IPv6;万维网,互联网(公网)和局域网(内网)
 * 网络是分层的
 * 最外层的是公网/互联网
 * 底下的每层都是内网(大路看成公网,大路里面很多小路看成内网)
 * ip地址可以在每个层次的网重用
 *
 * 通信协议 osi7层模型 tcp/ip 4层协议
 * 传输层:TCP和UDP
 * TCP：传输控制协议,面向连接的协议
 * - 两台机器的可靠无差错的数据传输
 * - 双向字节流传递
 * UDP:用户数据报协议,面向无连接的协议
 * 不保证可靠的数据传输
 * 速度快,在较差网络下使用
 * qq就是UDP协议:当时就是网络比较差
 * @author 郭经伟
 */
public class IntetAddressTest {

    @Test
    public void test1(){

    }
}
