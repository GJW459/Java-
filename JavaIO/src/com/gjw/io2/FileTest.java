package com.gjw.io2;

import org.junit.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * Java IO 流 也就是输入输出
 * 从内存输出到磁盘上，从磁盘读入到内存
 * @author 郭经伟
 * java.io.File类:文件和文件路径的抽象代表形式，与平台无关
 */
public class FileTest {

    /**
     * File代表一个文件和一个文件目录
     * java.io的包下
     */
    @Test
    public void test(){
        //相对路径 相对于某个路径下，指明的路径
        //windows下的分隔符 \=>字符串中需要转义 linux mac下的分隔符 /
        File file = new File("readme.txt");//=>内存中的一个对象
        //File类的获取功能
        String absolutePath = file.getAbsolutePath();//获取绝对路径
        String path = file.getPath();//获取路径
        String name = file.getName();//获取名称
        String parent = file.getParent();//获取上级目录
        long length = file.length();//获取文件长度
        long l = file.lastModified();//文件最后一次修改的时间
        System.out.println(absolutePath);
        System.out.println(path);
        System.out.println(name);
        System.out.println(parent);
        System.out.println(length);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(l)));
        File file1 = new File("C:\\Users\\Administrator\\Desktop\\JavaHighLevel\\JavaIO\\src\\com\\gjw\\io");//文件目录
        String[] list = file1.list();
        for (String s : list) {
            System.out.println(s);
        }
        File[] files = file1.listFiles();
        for (File file2 : files) {
            System.out.println(file2.toString());
        }

    }

    /**
     * file.renameTo重命名文件
     * 需要保证file1存在file2不存在
     */
    @Test
    public void test2(){
        File file = new File("readme.txt");
        //File的判断功能
        boolean directory = file.isDirectory();//是不是目录
        boolean file1 = file.isFile();//是不是文件
        boolean exists = file.exists();//判断是否存在
        boolean b = file.canRead();//可以读不
        boolean b1 = file.canWrite();//可以写不
        boolean hidden = file.isHidden();//文件是否隐藏
        //File的创建功能
        //boolean newFile = file.createNewFile();创建文件
        boolean mkdirs = file.mkdirs();//创建文件目录 多个
        boolean mkdir = file.mkdir();//创建文件目录
        boolean delete = file.delete();//删除文件 不走回收站

    }
}
