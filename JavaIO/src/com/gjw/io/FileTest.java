/**
 * FileName: FileTest
 * Author:   郭经伟
 * Date:     2020/4/10 20:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.io;

import org.junit.Test;

import java.io.File;

/**
 * 计算机中，文件是非常重要的储存系统
 * java.io包提供了File对象操作文件和目录
 * Java标准库的java.io.File对象表示一个文件或者目录：
 * 创建File对象本身不涉及IO操作；
 * 可以获取路径／绝对路径／规范路径：getPath()/getAbsolutePath()/getCanonicalPath()；
 * 可以获取目录的文件和子目录：list()/listFiles()；
 * 可以创建或删除文件和目录。
 */
public class FileTest {

    @Test
    public void test1(){
        //新建一个文件
        File file=new File("C:\\Users\\Administrator\\Desktop\\每日问题总结");
        File[] files = file.listFiles();
        String[] list = file.list();
        for (String string : list) {
            System.out.println(string);
        }
        for (File file1 : files) {
            System.out.println(file1.getAbsolutePath());
        }
    }
}
