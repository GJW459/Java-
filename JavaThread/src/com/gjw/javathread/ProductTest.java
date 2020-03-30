/**
 * FileName: ProductTest
 * Author:   郭经伟
 * Date:     2020/3/30 17:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.javathread;

/**
 * 生产者消费者经典问题
 */
class Clerk{

}
//生产者
class Producer extends Thread{
    private Clerk clerk;
    public Producer(Clerk clerk){
        this.clerk=clerk;
    }

}
//消费者
class Consumer extends Thread{
    private Clerk clerk;
    public Consumer(Clerk clerk){
        this.clerk=clerk;
    }

}
public class ProductTest {
}
