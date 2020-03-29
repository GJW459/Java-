/**
 * FileName: WindowsTest
 * Author:   郭经伟
 * Date:     2020/3/29 12:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.javathread;
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
