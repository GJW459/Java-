/**
 * FileName: InputStreamTest
 * Author:   郭经伟
 * Date:     2020/4/10 20:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Java标准库的java.io.InputStream定义了所有输入流的超类：
 * FileInputStream实现了文件流输入；
 * ByteArrayInputStream在内存中模拟一个字节流输入。
 * 总是使用try(resource)来保证InputStream正确关闭。
 */
public class InputStreamTest {

    //测试InputStream
    @Test
    public void test1() throws Exception {
        //File对象实际上是没有涉及IO流，他只是获取一个File文件的基本信息，比如说文件名，后缀名，路径
        //操作系统中的文件系统，我们可以通过以流的方式读入文件
        //读取文件会有IOException 我们需要捕获异常或者抛出异常 字节流，read方法每次读取一个字节，并返回一个int数，如果返回值为-1那就是读完了
        //1，通过try catch 捕获异常
//        InputStream inputStream=null;
//        try {
//            inputStream=new FileInputStream("readme.txt");
//            //开始读数据
//            int n;
//            while ((n=inputStream.read())!=-1){
//                System.out.println(n);
//            }
//
//        }finally {
//            if (inputStream!=null){
//                inputStream.close();
//            }
//        }
        //通过try(resource)读文件
//        try (InputStream stream=new FileInputStream("readme.txt")){
//
//            int n;
//            while ((n=stream.read())!=-1){
//                System.out.println(n);
//            }
//        }
        //一个字节一个字节的读效率太低了 每次读入一个byte数组里面 也就是缓冲
        try (InputStream stream=new FileInputStream("readme.txt")){

            byte[] bytes=new byte[100];
            int n;
            //返回实际读取了多少个字节
            //必须执行完read才能执行后面的代码
            while ((n=stream.read(bytes))!=-1){
                System.out.println("read " + n + " bytes.");
            }
        }
    }
}
