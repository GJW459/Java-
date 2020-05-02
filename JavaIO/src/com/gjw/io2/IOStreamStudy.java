package com.gjw.io2;

import org.junit.Test;

import java.io.*;

/**
 * IO流分类和原理
 * IO是 input 和output的缩写 ,IO技术是非常实用的技术,用于处理设备之间的数据传输,如：读写文件，网络通讯等
 * 数据的输入输出都是以流的方式传输
 * 流按照流向的不同，分为输出流和输入流
 * 流按照数据单位的不同，分为字符流和字节流
 * 按照流的角色不同分为：字节流和处理流
 * 四个抽象类: InputStream OutputStream Reader Writer 其他的类都是这四个类的派生类
 * IO类体系
 * 抽象基类 上面四个
 * 访问文件 File~前面四个 =>节点流 可以直接对流进行操作
 * 访问数组 ByteArray~ CharArray~
 * 访问管道 Piped~
 * 访问字符串 StringReader StringWriter
 * 缓存流 BufferedInputStream ...
 * 转换流 InputStreamReader OutputStreamWriter
 * 对象流 ObjectInputStream ObjectOutputStream 上面的文件流4个
 * 打印流 PrintStream
 * 数据流 DataInputStream DataOutputStream 操作基本数据类型和String
 *
 * InputStreamReader:将一个字节输入流转换成字符输入流
 * OutputStreamWriter:将一个字符输出流转换成字节输出流
 * 转换流的作用:提供字符流和字节流之间的转换
 * 解码:字节,字节数组=>字符数组和字符串
 * 编码:字符数组和字符串=>字节和字节数组
 *
 * 编码集
 * ASCII:美国标准信息交换码:用一个字节的七位可以表示
 * IOS8859-1:拉丁码表.欧洲码表:用一个字节的8位可以表示
 * GB2312:中国的中文编码表，最多两个字节编码所有的字符
 * GBK:GB2312的升级版,融合了跟多的中文符号,最多两个字节编码
 * Unicode:(世界上所有语言的编码表的统一)国际标准码,融合了所有的字符,为每一个字符分配一个字符码.所有的文字都有两个字节来表示
 * UTF-8:变长的编码方式,用1-4个字符来表示 UTF-8就是每8个位传输数据,UTF-16就是每16个位传输数据
 *
 * 文本文件尽量使用字符流处理(txt,java,c,cpp...)
 * 对于非文本文件尽量使用字节流处理(jpg,mp4....)
 */
public class IOStreamStudy {

    /**
     * FileReader直接读文件里面的数据
     */
    @Test
    public void test(){

        //通过节点流对文件进行操作
        //1.创建文件对象
        File file = new File("readme.txt");
        //2.创建流 节点字符输入流
        //使用try with resource 自动释放资源
        try (FileReader reader=new FileReader(file)){

            //读取文件中的数据
            char[] chars = new char[5];
            int len;
            while ((len=reader.read(chars))!=-1){

                String s = new String(chars, 0, len);
                System.out.print(s);
//                for (int i = 0; i < len; i++) {
//                    System.out.print(chars[i]);
//                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * FileWriter直接输出文件
     */
    @Test
    public void test2(){

        try(FileWriter writer=new FileWriter(new File("hello.txt"))){

            writer.write("哈哈哈哈");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * FileReader读取文件内容 FileWriter输出文件的内容到另一文件里面
     */
    @Test
    public void test3(){

        //使用FileReader读取一个文件的内容复制到另一文件
        try (FileReader fileReader=new FileReader(new File("readme.txt"));FileWriter fileWriter=new FileWriter(new File("hello2.txt"))){

            //读取readme.txt文件中的内容
            int len;
            char[] chars = new char[5];
            while ((len=fileReader.read(chars))!=-1){
                fileWriter.write(chars,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * FileInputStream 字节流 以字节读入
     */
    @Test
    public void test4(){

        try(FileInputStream fileInputStream=new FileInputStream(new File("readme.txt"))) {

            //读入的是byte数组 UTF-8一个汉字占三个字节
            byte[] bytes = new byte[3];
            int len;
            while ((len=fileInputStream.read(bytes))!=-1){
                System.out.print(new String(bytes,0,len));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字节流读取图片copy图片
     */
    @Test
    public void test5(){

        try (FileInputStream inputStream=new FileInputStream(new File("集合gif.gif"));FileOutputStream outputStream=new FileOutputStream(new File("集合.gif"))){
            byte[] bytes = new byte[100];
            int len;
            while ((len=inputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 缓冲流实现非文本文件复制 提供读写效率 处理流也就是包装流
     */
    @Test
    public void test6(){

        try (BufferedInputStream inputStream=new BufferedInputStream(new FileInputStream(new File("集合.gif")) );
        BufferedOutputStream outputStream=new BufferedOutputStream(new FileOutputStream(new File("集合2.gif")))){

            //字节流
            byte[] bytes = new byte[20];
            int len;
            while ((len=inputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 缓冲字符流
     */
    @Test
    public void test7(){

        try (BufferedReader reader=new BufferedReader(new FileReader(new File("readme.txt")) );
             BufferedWriter writer=new BufferedWriter(new FileWriter(new File("hello3.txt")))){

            char[] chars = new char[10];
            int len;
            while ((len=reader.read(chars))!=-1){
                writer.write(chars,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 转换流 字节流=>字符流 解码 字符流=>字节流 编码
     * 避免中文乱码 以什么编码方式写入 就以什么方式读取
     */
    @Test
    public void test8(){

        //默认是系统的当前编码方式
        try(InputStreamReader reader=new InputStreamReader(new FileInputStream(new File("readme.txt")),"UTF-8")) {

            char[] chars = new char[10];
            int len;
            while ((len=reader.read(chars))!=-1){
                System.out.println(new String(chars,0,len));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 对象流:用于存储和读取基本数据类型的数据和对象的处理流
     * 序列化:java对象序列化成byte数组=>二进制流 ObjectOutputStream
     * 反序列化:数组反序列化成java对象 ObjectInputStream
     * 不能序列化 static和transient的成员变量
     * 可以存到文件里也可以通过网络传输
     * .dat文件:二进制文件
     * java对象序列化需要实现Serializable接口并且他的字段也必须都实现Serializable接口
     */
    @Test
    public void test9(){

        try (ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream(new File("hello.dat")))){

            Person person = new Person();
            person.setAge(18);
            person.setName("张三");
            outputStream.writeObject(person);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 反序列化
     */
    @Test
    public void test10(){
        try (ObjectInputStream inputStream=new ObjectInputStream(new FileInputStream(new File("hello.dat")))){
            Person person = (Person) inputStream.readObject();
            System.out.println(person);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * RandomAccessFile类
     * 继承于Object 实现了DataInput,DataOutput既可以输入也可以输出
     * 既可以作为输入流也可以作为输出流
     * 如果RandomAccessFile作为输出流的时候,写出到的文件如果不存在,则在执行过程中自动创建
     * 如果存在,对原有文件进行覆盖,默认从头覆盖
     * 可以通过实现相关操作实现RandomAccessFile实现插入数据的效果
     */
    @Test
    public void test11(){

      try (  RandomAccessFile r = new RandomAccessFile(new File("集合.gif"), "r");
             RandomAccessFile r2 = new RandomAccessFile(new File("m.gif"), "rw")){

          byte[] bytes = new byte[1024];
          int len;
          while ((len=r.read(bytes))!=-1){
              r2.write(bytes,0,len);
          }
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void test12() throws IOException {

        RandomAccessFile rw = new RandomAccessFile(new File("hello.txt"), "rw");
        //指针调到角标为3的位置
        rw.seek(3);
        rw.write("xyz".getBytes());
        rw.close();
    }

    /**
     * RandomAccessFile实现插入
     */
    @Test
    public void test13() throws IOException {
        RandomAccessFile rw = new RandomAccessFile(new File("hello.txt"), "rw");
        //指针定位到3的位置 在此处插入数据
        rw.seek(3);
        //先将后面的数据存起来
        StringBuilder builder = new StringBuilder((int) new File("hello.txt").length());
        byte[] bytes = new byte[20];
        int len;
        while ((len=rw.read(bytes))!=-1){

            builder.append(new String(bytes,0,len));
        }
        //调回指针
        rw.seek(3);
        //插入数据
        rw.write("xyz".getBytes());
        //将StringBuilder中的数据插入
        rw.write(builder.toString().getBytes());

    }

    /**
     * Java NIO 非阻塞的IO new IO jdk1.4引入的io api 可以代替java io api
     * NIO面向缓存区的(IO面向流的),基于通道的操作 NIO更加高效的进行文件的读写
     * Java Api两套NIO API 1.针对输入输出的NIO 2. 网络的NIO
     * jdk7的NIO2
     * NIO2中的Path,Paths,Files
     * Path:替代File
     * Paths:获取Path
     * Files:文件的相关操作
     * apache-commons-io包实现数据的读写
     */
    @Test
    public void test14(){

    }


}
