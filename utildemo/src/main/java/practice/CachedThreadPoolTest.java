package practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @program: Demo
 * @Date: 2019/8/27 22:48
 * @Author: JcLi
 * @Description: 创建一个最大线程数为int最大值的线程池，如果线程池中已有线程，则重用，没有则创建新的线程并添加到线程池，缓存默认时间60s
 */
public class CachedThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService e = Executors.newCachedThreadPool();
        Runnable1 runnable1 = new Runnable1();
        e.submit(runnable1);//获取线程池中的某一个线程对象，然后调用runnable接口中的run方法,run执行完后归还线程到线程池
        Thread.sleep(3000);
        e.submit(runnable1);
        System.out.println("当前线程数："+ ((ThreadPoolExecutor)e).getPoolSize());
        e.submit(runnable1);
        System.out.println("当前线程数："+ ((ThreadPoolExecutor)e).getPoolSize());
        Thread.sleep(70*1000);
        System.out.println("当前线程数："+ ((ThreadPoolExecutor)e).getPoolSize());
        e.submit(runnable1);
        e.submit(runnable1);
        System.out.println("当前线程数："+ ((ThreadPoolExecutor)e).getPoolSize());
        e.shutdown();
    }
}
