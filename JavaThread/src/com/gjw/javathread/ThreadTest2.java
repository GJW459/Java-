/**
 * FileName: ThreadTest2
 * Author:   郭经伟
 * Date:     2020/3/29 12:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.javathread;

/**
 * 创建多线程的方式二：实现Runnable接口
 * 1,创建一个实现了Runnable接口的类
 * 2.实现类去实现Runnable接口的抽象方法，run
 * 3.创建实现类的对象
 * 4.通过将这个实现类的对象传到Thread类的构造器中，创建Thread类对象
 * 5.Thread类的对象调用start()方法
 */
class MyRunableThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadTest2 {
    public static void main(String[] args) {
        MyRunableThread myRunableThread = new MyRunableThread();
        Thread thread=new Thread(myRunableThread);
        thread.start();
        Thread thread1=new Thread(myRunableThread);
        thread1.start();
        Thread thread2=new Thread(myRunableThread);
        thread2.start();
    }

}
