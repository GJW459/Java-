package com.gjw.reflect2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理设计模式的原理
 * 使用一个代理将对象包装起来,然后这个代理对象取代原始对象,所有对原始对象的操作和调用都
 * 要通过代理。代理对象决定是否以及何时将方法调用转到原始对象上
 * 静态代理和动态代理的区别
 * 静态代理:代理类和目标对象的类都是在编译期就确定下来了,缺点:不适合程序的扩展,每一个代理类只能为一个接口服务
 * 动态代理:代理类和目标对象的类都是在运行期才确定下来:实现一个通用的代理类,实现所有的代理功能=>一个代理类搞定所有的被代理类
 * 使用场合:调试和远程方法调用
 *
 * 动态代理举例
 */
interface Human{
    String getBelief();
    void eat(String food);
}
//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃"+food);
    }

}

/**
 * 要想实现动态代理,需要解决什么问题
 * 问题1:如何根据加载到内存的被代理类动态的创建一个代理类及其对象
 * 问题2:当通过代理类的对象调用方法时,如何动态的去调用被代理类的同名方法
 */
class ProxyFactory{

    //形参obj:被代理类对象 调用此方法返回一个代理类对象
    public static Object getObjectInstance(Object object){
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        myInvocationHandler.bind(object);
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),myInvocationHandler);
    }
}
class MyInvocationHandler implements InvocationHandler{

    //使用被代理类的方法
    private Object object;

    public void bind(Object o){
        this.object=o;
    }
    /**
     * 当我们通过代理类的对象,调用方法a时,就会动态的调用此方法
     * 被代理类要执行的方法a的功能就声明在此方法里
     * @param proxy 代理类对象
     * @param method 代理类对象的方法
     * @param args 方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //method 即为代理类调用的方法,此方法也就作为被代理类所调用的方法
        Object invoke = method.invoke(object, args);
        return invoke;
    }
}
public class ProxyTest {
    public static void main(String[] args) {

        SuperMan superMan = new SuperMan();
        Human human = (Human) ProxyFactory.getObjectInstance(superMan);
        String belief = human.getBelief();
        System.out.println(belief);
        human.eat("四川麻辣烫");
        System.out.println("****************");
        NickClothFactory nickClothFactory = new NickClothFactory();
        ClothFactory objectInstance = (ClothFactory) ProxyFactory.getObjectInstance(nickClothFactory);
        objectInstance.produceCloth();
    }
}
