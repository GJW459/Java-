package com.gjw.socket;

/**
 * AIO编程:
 * NIO不是真异步是同步非阻塞
 * 异步IO 在nio包中
 * 采用回调的方法进行处理读写操作=>回调方法就是读写操作完了之后自动处理一下操作
 * 主要类
 * AsynchronousServerSocketChannel :服务端接收请求通道
 * bind方法绑定一个端口, accept 接收客户端请求
 * AsynchronousSocketChannel :Socket通讯通道
 * read 读数据 write写数据
 * CompletionHandler异步处理类
 * completed操作完成后异步调用方法 failed操作失败后异步调用方法
 */
public class AIOTest {
}
