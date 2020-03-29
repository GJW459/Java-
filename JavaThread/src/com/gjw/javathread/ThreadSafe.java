/**
 * FileName: ThreadSafe
 * Author:   郭经伟
 * Date:     2020/3/29 15:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.javathread;

/**
 * 例子：三个窗口卖100张票
 * 1.问题：买票的过程中出现了重票，错票
 * 2.问题出现的原因：当某个线程操作车票的过程中，尚未操作完成的情况下，其他线程参与进来，也操作车票
 * 共享数据：ticket
 * 3.如何解决：加锁，当一个线程在操作共享数据的时候，其他线程不能参与进来，知道此线程操作完共享数据的时，其他线程才可以开始操作
 * 共享数据，及时在这种情况下此线程出现了阻塞，也不能被改变
 * 4.z在java中我们通过同步机制来解决线程安全的问题
 * 方式一：同步代码块
 *  synchronized(同步监视器){
 *      //需要同步的代码
 *  }
 *  说明：操作共享数据的代码，即为需要被同步的代码-->不能包含代码多了，也不能包含代码少了
 *  共享数据，多个线程共同操作的变量
 *  同步监视器：俗称：锁 任何一个类的对象，都可以作为锁
 *  要求：多个线程必须共用同一把锁
 *  补充:在实现Runnable接口创建多线程的方式中，我们可以考虑使用this充当同步监视器
 * 方式二：同步方法
 *
 * 同步的方式解决了线程的的安全问题
 * 操作同步代码时，只能有一个线程参与，其他线程等待，相当于是一个单线程的过程，效率低。
 */
class Windows1 implements Runnable {

    private int ticket = 100;
    private Object object=new Object();
    @Override
    public void run() {
        while (true) {
          synchronized(object){
              try {
                  Thread.sleep(100);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              if (ticket > 0) {
                  System.out.println(Thread.currentThread().getName() + ":" + ticket);
                  ticket--;
              }else {
                  break;
              }
          }
        }
    }
}

public class ThreadSafe {
    public static void main(String[] args) {
        Windows1 windows1=new Windows1();
        Thread thread1=new Thread(windows1);
        Thread thread2=new Thread(windows1);
        Thread thread3=new Thread(windows1);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
