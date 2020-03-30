/**
 * FileName: ThreadPool
 * Author:   郭经伟
 * Date:     2020/3/30 17:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.javathread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        //指定数量的线程池数量
        ExecutorService service = Executors.newFixedThreadPool(10);
//        service.execute();//适合Runnable
//        service.submit();//适合Callable
        //关闭线程池
        service.shutdown();
    }
}
