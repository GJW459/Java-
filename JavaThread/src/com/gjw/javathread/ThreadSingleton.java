/**
 * FileName: ThreadSingleton
 * Author:   郭经伟
 * Date:     2020/3/29 16:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.javathread;

/**
 * 通过同步机制将单例模式的懒汉式改写为线程安全的
 */
class Bank{
    private Bank(){

    }
    private static Bank instance=null;
    public static Bank getInstance(){
        //方式一：效率较差
//        synchronized (Bank.class){
//            if (instance==null){
//                instance=new Bank();
//            }
//            return instance;
//        }
        //方式二：效率更高
        if (instance==null){
            synchronized (Bank.class){
                if (instance==null){
                    instance=new Bank();
                }
            }
        }
        return instance;

    }
}
public class ThreadSingleton {
    public static void main(String[] args) {

    }
}
