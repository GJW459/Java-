## 多线程

基本概念：

- 程序，进程，线程
- 程序：完成特定任务，用某种语言编写的一组指令的集合。即指一段的静态的代码，静态代码
- 进程：程序执行的过程，正在运行的一个程序，资源分配的单位
- 线程：一个进程里面有一个线程=>单线程，同理一个进程里面有多个线程就是多线程，每个线程有独立的运行栈和程序计数器，线程的切换开销小
- 一个进程的多个线程共享相同的内存单元/内存地址空间->从同一个堆中分配对象，可以访问相同的变量与对象。通信的时候很高效，多个线程操作共享数据，就会有安全隐患
- 并行和并发：
- 并行：多个CPU同时执行多个任务。比如：多个人同时做不同的事
- 并发：单个CPU（时间片）同时执行多个任务，比如：秒杀，多个人做一个事情

多线程优点

1. 提高计算机的CPU利用率
2. 改善程序结构。复杂的进程分为多个单独的线程去执行

什么时候需要多线程

- 程序需要同时执行两个或多个任务
- 程序需要实现一些需要等待的任务时，如用户输入，文件读写操作，网络操作，搜索等。
- 需要一些后台运行的程序时

### 线程的创建和使用

#### 方式1

```java
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
                System.out.println(i);
            }
        }
    }
}
public class ThreadTest {
    public static void main(String[] args) {
        //主线程调用子线程
        MyThread myThread=new MyThread();//主线程做的
        //调用start方法
        myThread.start();//主线程,启动当前线程，调用当前线程的run
        //调用后子线程就开始独立执行
        for (int i=0;i<100;i++){
            if (i%2==0){
                System.out.println(i+"****************");
            }
        }
    }
}
//问题一：我们不能通过调用run方法启动线程
//问题二：再启动一个线程，遍历100以内的偶数 myThread.start(); 会抛异常，要想创建多个线程，创建多个Thread对象
 public synchronized void start() {
        if (threadStatus != 0)
            throw new IllegalThreadStateException();
        group.add(this);

        boolean started = false;
        try {
            start0();
            started = true;
        } finally {
            try {
                if (!started) {
                    group.threadStartFailed(this);
                }
            } catch (Throwable ignore) {
                /* do nothing. If start0 threw a Throwable then
                  it will be passed up the call stack */
            }
        }
    }

  //创建Thread类的匿名子类去创建
        new Thread(){
            @Override
            public void run() {
                super.run();
            }
        }.start();
```

- 线程的常用方法

```java
/**
 * 1.start()：启动当前线程，调用当前线程的run方法
 * 2.run():通常需要重写Thread类的，创建的线程需要执行的操作放在run方法里面
 * 3.currentThread():静态方法，获取当前的线程
 * 4.getName:setName
 * yield():释放当前cpu的执行权
 * join():在线程a中调用b的线程方法，此时线程a阻塞了，知道线程b完全执行完以后，线程a才结束阻塞状态
 * sleep(long ) 当前线程休眠，也就是当前线程阻塞
 * isAlive当前线程是否存活
 */
public class ThreadMethodTest {
}

```

#### 线程的调度

- 调度策略

- 时间片
- 抢占式：高优先级的线程抢占CPU
- Java调度方法

1. 同优先级线程组成先进先出队列（先到先服务）

```java
   public final static int MIN_PRIORITY = 1;

    public final static int NORM_PRIORITY = 5;

    public final static int MAX_PRIORITY = 10;
//获取线程优先级:getPriority()
//设置线程优先级:setPriority()
```

```java
/**
 * 实现三个窗口同时买票，总票数100张
 * 现在还是会出现线程安全的问题
 */
class Windows extends Thread{
    private static int tikets=100;
    @Override
    public void run() {
        while (true){
            if (tikets>0){
                tikets--;
                System.out.println(currentThread().getName()+"，票数:"+tikets);
            }else {
                break;
            }
        }
    }
}
public class WindowsTest {
    public static void main(String[] args) {
        Windows windows1=new Windows();
        Windows windows2=new Windows();
        Windows windows3=new Windows();
        windows1.start();
        windows2.start();
        windows3.start();
    }
}
```

#### 方式二

```java
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
```

- 比较两种方式

实现的方式比较好，继承的方式单继承就是局限性

原因：1，实现的方式没有类单继承性的局限性

​	    2，实现的方式更适合来处理多个线程有共享数据的情况

联系：

```java
public
class Thread implements Runnable 
```

相同点：两种方式都需要重写run，将线程需要执行的任务放在run方法中

## 线程的生命周期



![线程的生命周期](线程的生命周期 (1).png)


## 线程的安全问题

两个人同时取钱就会发生线程的安全问题，也就是读取共享数据的问题

### 方式一：同步块

通过实现Runnable接口实现多线程的方式实现线程安全

```java
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

```

通过继承Thread类的方式实现多线程的方式实现线程安全

```java
class Windows2 extends Thread{
    private static int ticket=100;
    @Override
    public void run() {
        while (true){
           synchronized (Windows2.class){
               if (ticket>0){
                   try {
                       Thread.sleep(100);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println(Thread.currentThread().getName() + ":" + ticket);
                   ticket--;
               }else {
                   break;
               }
           }
        }
    }
}
public class ThreadSafe2 {
    public static void main(String[] args) {
        Windows2 windows1=new Windows2();
        Windows2 windows2=new Windows2();
        Windows2 windows3=new Windows2();
        windows1.start();
        windows2.start();
        windows3.start();

    }
}

```

### 方式二：同步方法解决线程安全问题

run方法出用synchronized修饰方法

非静态同步方法的同步监视器是this

静态同步方法的同步监视器是xx.class

在使用继承Thread类的方式下使用同步方法需要改为静态方法

### 线程安全的单例模式懒汉式

```java
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
```

### 死锁的问题

锁住出不来了，不同的线程分别占用对方需要的同步资源不放弃，都在等待对方放弃自己需要的同步资源，就形成了线程的死锁

出现死锁后，不会出现提示，而是所有的线程都发送阻塞的状态

```java
package com.gjw.javathread;

/**
 * 锁住出不来了，不同的线程分别占用对方需要的同步资源不放弃，都在等待对方放弃自己需要的同步资源，就形成了线程的死锁
 * 出现死锁后，不会出现提示，而是所有的线程都发送阻塞的状态
 * 尽量少嵌套
 */
public class ThreadLock {
    public static void main(String[] args) {
        StringBuilder s1=new StringBuilder();
        StringBuilder s2=new StringBuilder();
        new Thread(){
            @Override
            public void run() {
                 synchronized (s1){
                     s1.append("a");
                     s2.append("1");
                     try {
                         Thread.sleep(1000);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     synchronized (s2){
                         s1.append("b");
                         s2.append("2");
                         System.out.println(s1);
                         System.out.println(s2);
                     }
                 }
            }
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2){
                    s1.append("c");
                    s2.append("3");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (s1){
                        s1.append("d");
                        s2.append("4");
                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }).start();
    }

}

```

### 方式三

#### Lock(锁)

Lock接口，得用他的实现类

jdk5.0的新功能

```java
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

```



