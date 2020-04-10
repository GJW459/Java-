/**
 * FileName: SerializationTest
 * Author:   郭经伟
 * Date:     2020/4/10 21:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.io;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

/**
 * java序列化：通过将java对象变成2进制，也就是byte数组
 * 序列化成byte数组后就可以方便的存储到文件中，或者通过网络把byte传输到远程去
 * java反序列化：就是把2进制变成java对象
 * 反序列化就是从文件中读取byte数组转化成java对象，或者是从网络上读取byte数组转化成对象
 * 安全性
 * 因为Java的序列化机制可以导致一个实例能直接从byte[]数组创建，而不经过构造方法，因此，它存在一定的安全隐患。一个精心构造的byte[]数组被反序列化后可以执行特定的Java代码，从而导致严重的安全漏洞。
 * 实际上，Java本身提供的基于对象的序列化和反序列化机制既存在安全性问题，也存在兼容性问题。更好的序列化方法是通过JSON这样的通用数据结构来实现，只输出基本类型（包括String）的内容，而不存储任何与代码相关的信息。
 */
public class SerializationTest {

    //要序列化java对象，也要实现Serializable接口，这个是一个空接口，也就是标记接口，给上标记后，就说明这个java对象可以被序列化
    @Test
    public void test1() throws Exception {
        //序列化 输出成二进制文件
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (ObjectOutputStream output = new ObjectOutputStream(byteArrayOutputStream) ){
            //写入Object
            Person person = new Person(18, "郭经伟");
            output.writeObject(person);
        }
        System.out.println(Arrays.toString(byteArrayOutputStream.toByteArray()));
        byte[] bytes = byteArrayOutputStream.toByteArray();
        //反序列化成对象
        try (ObjectInputStream objectInputStream=new ObjectInputStream(new ByteArrayInputStream(bytes))){
            Person person = (Person) objectInputStream.readObject();
            System.out.println(person);
            /**
             * 为了避免这种class定义变动导致的不兼容，Java的序列化允许class定义一个特殊的serialVersionUID静态变量，用于标识Java类的序列化“版本”，
             * 通常可以由IDE自动生成。如果增加或修改了字段，可以改变serialVersionUID的值，这样就能自动阻止不匹配的class版本：
             */
        }
    }

}
