package com.gjw.reflect2;

/**
 * 静态代理
 * 特点:代理类和被代理类在编译期间就确定下来了
 */
interface ClothFactory{
    void produceCloth();
}
//代理类
class ProxyClothFactory implements ClothFactory{

    //用被代理类进行实例化
    private ClothFactory clothFactory;

    public ProxyClothFactory(ClothFactory clothFactory){
        this.clothFactory=clothFactory;
    }
    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        clothFactory.produceCloth();
        System.out.println("代理工厂做一些收尾工作");
    }
}
//被代理类
class NickClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("耐克工厂生产一批运动鞋");
    }
}
public class StaticProxyTest {
    public static void main(String[] args) {

        //创建被代理对象
        NickClothFactory nickClothFactory = new NickClothFactory();
        //创建代理对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nickClothFactory);
        proxyClothFactory.produceCloth();
    }
}
