/**
 * FileName: ThreadCommunicate
 * Author:   郭经伟
 * Date:     2020/3/30 17:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.javathread;

/**
 * 线程通信的例子：使用两个线程打印1-100，线程1和2交替打印
 * 涉及三个方法
 * wait():一旦执行此方法，当前线程就进入阻塞状态，并且是否同步监视器
 * notify():一旦执行此方法，一会唤醒被wait的一个线程，如果有多个线程，就唤醒优先级高的线程
 * notifyAll():一旦执行此方法，就会唤醒所有的被wait的线程
 * 这三个方法都得在同步代码块和同步方法里面，lock都不行
 * 三个方法的调用者必须时同步代码块和同步方法中的同步监视器
 * 否则会出现异常
 * 这三个方法定义在Object类中
 * 面试题：sleep()和wait()异同
 * 相同点：执行此方法都会使当前的线程进入阻塞状态
 * 不同点：1，位置不同 sleep类在Thread类中声明，Object类中声明的wait
 * 2，调用场景：sleep方法可以在任何地方使用，wait()方法只能在同步块和同步方法中使用
 * 3,关于是否是否同步监视器，如果两个都在同步块或者同步方法中，sleep不会是否，wait会释放
 */
class Number implements Runnable{

    private int number=1;
    @Override
    public void run() {
        //这里存在共享数据，所有会发生抢占共享资源的问题
        while (true){
            synchronized (this){
                notify();
                if (number<=100){
                    System.out.println(Thread.currentThread().getName()+":"+number);
                    number++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }

    }
}
public class ThreadCommunicate {
    public static void main(String[] args) {

        Number number=new Number();
        Thread thread1=new Thread(number);
        Thread thread2=new Thread(number);
        thread1.start();
        thread2.start();
    }


}
