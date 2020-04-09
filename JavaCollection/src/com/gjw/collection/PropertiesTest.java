/**
 * FileName: PropertiesTest
 * Author:   郭经伟
 * Date:     2020/4/9 16:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.collection;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * 1、类路径下
 * 就是项目的src下。
 * maven项目的 java下 和 resources下。
 * 2、获取类路径下的资源
 * 使用类加载器：
 * Demo.class.getClassLoader() //获取一个类加载器
 * Demo.class.getClassLoader().getResourceAsStream("druid.properties"); //获取src下的资源
 */
public class PropertiesTest {

    //获取properties
    @Test
    public void test1() throws Exception {
        //可以从文件系统读取这个.properties文件：
        Properties properties=new Properties();
        properties.load(new FileInputStream("setting.properties"));
        String name = properties.getProperty("name");
        System.out.println(name);
        //从类路径下回去properties文件
        Properties properties1=new Properties();
//        properties1.load(PropertiesTest.class.getClassLoader().getResourceAsStream("my.properties"));
//        properties1.load(this.getClass().getClassLoader().getResourceAsStream("my.properties"));
        properties1.load(this.getClass().getResourceAsStream("/my.properties"));
        String name1 = properties1.getProperty("name");
        System.out.println(name1);

    }
    @Test
    //写配置文件
    public void test2() throws Exception {

        Properties properties=new Properties();
        properties.setProperty("name","小郭i");
        properties.setProperty("xx","xx");
        properties.store(new FileOutputStream("xx.properties"),"");
    }


}
