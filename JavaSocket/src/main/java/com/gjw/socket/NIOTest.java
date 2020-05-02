package com.gjw.socket;


/**
 * 新IO也是非阻塞IO:避免同步IO通讯效率过低
 * 一个线程可以管理多个连接
 * 减轻线程多的压力
 * 1.4引入的NIO,1.7变成NIO2.0(同时引入了AIO),在java.nio包中
 * 主要类
 * -Buffer 缓存区
 * -Channel 通道
 * -Selector多路选择器
 *
 * 缓冲区,一个可以读写的内存区域
 * ByteBuffer,CharBuffer,DoubleBuffer,IntBuffer,LongBuffer,ShortBuffer
 * StringBuffer不是Buffer缓冲区
 * 四个主要属性
 *  -capacity主要容量,position 读写位置
 *  -limit 界限,mark 标记,用于重复一个读写操作
 *  Channel通道
 *  -全双工的,支持读写(Stream流是单向的)
 *  -支持异步读写
 *  -和Buffer配合,提高效率
 *  -ServerSocketChannel 服务器TCP Socket接入通道,接收客户端
 *  -SocketChannel TCP Socket通道,可以支持阻塞/非阻塞通讯
 *  -DatagramChannel UDP通道
 *  FileChannel 文件通道
 *  Selector多路选择器
 *  -每隔一段时间,不断轮询注册在其上的Channel
 *  -如果有一个Channel有接入,读写操作,就会被轮询出来
 *  -根据SelectionKey可以获得相应的Channel,进行后续的IO操作
 *  -避免过多的线程
 *  -SelectionKey四种类型
 *  OP_CONNECT
 *  OP_ACCEPT
 *  OP_READ
 *  OP_WRITE
 */
public class NIOTest {
}
