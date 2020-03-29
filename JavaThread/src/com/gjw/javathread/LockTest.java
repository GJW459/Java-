/**
 * FileName: LockTest
 * Author:   郭经伟
 * Date:     2020/3/29 17:29
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.javathread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三：lock锁   ---JDK5.0新增
 * 1.面试题 synchronized 和lock的异同
 * 2. 相同：都能解决线程安全的问题
 * 不同：synchronized机制在执行完相应的同步代码后，自动的释放同步监视器
 * Lock需要手动的启动同步(Lock)，结束同步手动的实现(unlock())
 * Lock只有代码块锁，synchronized有代码块锁和方法锁
 * 使用Lock锁，JVM将花费较少的时间来调度线程，性能更好，并且具有更好的扩展性
 * 有限考虑Lock-其次 同步代码块 -同步方法
 */
class windows4 implements Runnable {

    private int ticket = 100;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
         try {
             //锁住 下面的代码成单线程
             lock.lock();
             try {
                 Thread.sleep(100);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             if (ticket > 0) {
                 System.out.println(Thread.currentThread().getName() + ":" + ticket);
                 ticket--;
             } else {
                 break;
             }
         }finally {
             lock.unlock();
         }

        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Windows1 windows4=new Windows1();
        Thread thread1=new Thread(windows4);
        Thread thread2=new Thread(windows4);
        Thread thread3=new Thread(windows4);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
