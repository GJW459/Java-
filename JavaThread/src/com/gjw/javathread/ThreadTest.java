/**
 * FileName: ThreadTest
 * Author:   郭经伟
 * Date:     2020/3/29 11:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.javathread;

/**
 * 多线程的创建，方式一：继承于Thread类
 * 1.创建一个进程于Thread类的子类
 * 2.重写Thread类的Run方法 -->此线程执行的操作声明在run()方法中
 * 3.创建Thread类的子类对象
 * 4.通过此对象调用start()
 * 例子：遍历100以内的所有整数
 */
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
public class ThreadTest {
    public static void main(String[] args) {
        //主线程调用子线程
        MyThread myThread=new MyThread();//主线程做的
        //调用start方法
//        myThread.start();//主线程
//        myThread.run();
        myThread.start();
        MyThread myThread1=new MyThread();
        myThread1.start();
        //调用后子线程就开始独立执行
        for (int i=0;i<100;i++){
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
        //创建Thread类的匿名子类去创建
        new Thread(){
            @Override
            public void run() {
                super.run();
            }
        }.start();
    }
}
