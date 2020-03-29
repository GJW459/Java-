/**
 * FileName: ThreadSafe2
 * Author:   郭经伟
 * Date:     2020/3/29 16:24
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.javathread;

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
