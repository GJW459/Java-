/**
 * FileName: CallableTest
 * Author:   郭经伟
 * Date:     2020/3/30 17:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.javathread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程方式三：实现Callable接口 --JDK5.0新增
 *
 * 如何理解实现Callable接口的方式创建的多线程比之前的强大
 * 1.call方法可以有返回值
 * 2.可以抛出异常
 * 3.支持泛型
 * 1.创建一个实现Callable的实现类
 * 2.实现call方法
 * 3.创建Callable接口实现类的对象
 * 4.将此Callable实现类的对象传递到FutureTask构造器中，创建FutureTask对象
 * 5.将FutureTask对象传入Thread启动线程
 */
class NumThread implements Callable{

    @Override
    public Object call() throws Exception {
        int sum=0;
        for (int i = 0; i <=100 ; i++) {
            if (i%2==0){
                System.out.println(i);
                sum+=i;
            }

        }
        return sum;
    }
}
public class CallableTest {
    public static void main(String[] args) {
        NumThread numThread=new NumThread();
        FutureTask futureTask = new FutureTask(numThread);
        new Thread(futureTask).start();
        try {
            //get方法返回值为FutureTask构造器参数Callable实现类重写的call()的返回值
            Object sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
