/**
 * FileName: ProxyTest
 * Author:   郭经伟
 * Date:     2020/4/8 21:06
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.reflect;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 我们来比较Java的class和interface的区别：
 * 可以实例化class（非abstract）；
 * 不能实例化interface。
 * JDK动态代理 :运行期间动态创建代理对象
 */
interface Hello{
    void morning(String name);
}

public class ProxyTest {

    @Test
    public void test1(){

        InvocationHandler invocationHandler=new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                //动态实现接口的方法
                if (method.getName().equals("morning")){
                    System.out.println("Good morning"+args[0]);
                }
                return null;
            }
        };
        //获取代理对象
        Object o = Proxy.newProxyInstance(Hello.class.getClassLoader(), new Class[]{Hello.class}, invocationHandler);
        Hello o1 = (Hello) o;
        //调用接口的方法，动态实现接口的方法
        o1.morning("a wei");

    }
}
