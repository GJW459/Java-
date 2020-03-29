/**
 * FileName: ThreadMethodTest
 * Author:   郭经伟
 * Date:     2020/3/29 11:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.javathread;

/**
 * 1.start()：启动当前线程，调用当前线程的run方法
 * 2.run():通常需要重写Thread类的，创建的线程需要执行的操作放在run方法里面
 * 3.currentThread():静态方法，获取当前的线程
 * 4.getName:setName
 * yield():释放当前cpu的执行权
 * join():在线程a中调用b的线程方法，此时线程a阻塞了，知道线程b完全执行完以后，线程a才结束阻塞状态
 * sleep(long ) 当前线程休眠，也就是当前线程阻塞
 */
public class ThreadMethodTest {
}
