/**
 * FileName: OutPutStreamTest
 * Author:   郭经伟
 * Date:     2020/4/10 20:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.io;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Java标准库的java.io.OutputStream定义了所有输出流的超类：
 * FileOutputStream实现了文件流输出；
 * ByteArrayOutputStream在内存中模拟一个字节流输出。
 * 某些情况下需要手动调用OutputStream的flush()方法来强制输出缓冲区。
 * 总是使用try(resource)来保证OutputStream正确关闭。
 */
public class OutPutStreamTest {
    public static void main(String[] args) throws IOException {
        try (OutputStream output = new FileOutputStream("readme1.txt")) {
            output.write("Hello".getBytes("UTF-8")); // Hello
        } // 编译器在此自动为我们写入finally并调用close()
    }
}
