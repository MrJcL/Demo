package practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: Demo
 * @Date: 2019/8/27 21:40
 * @Author: JcLi
 * @Description: 创建线程的几种方式：
 */
public class ThreadTest {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            try {
                System.out.println("线程名称："+ Thread.currentThread().getName());
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 10; i++) {
//            new Thread(runnable).start();
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("耗时1：" + (end-start));

        long start1 = System.currentTimeMillis();
        ExecutorService e = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            e.submit(runnable);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("耗时2：" + (end1-start1));
        e.shutdown();

//        int poolSize = Runtime.getRuntime().availableProcessors() * 2;
//        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(512);
//        RejectedExecutionHandler policy = new ThreadPoolExecutor.DiscardPolicy();
//        ExecutorService executorService = new ThreadPoolExecutor(poolSize, poolSize,
//                0, TimeUnit.SECONDS,
//                queue,
//                policy);
    }
}

class Runnable1 implements Runnable {
    @Override
    public void run() {
        System.out.println("1-获取线程:" + Thread.currentThread().getName());
        try {
            // 休眠2秒
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("1-归还到线程池:" + Thread.currentThread().getName());
    }
}

class Runnable2 implements Runnable {
    @Override
    public void run() {
        System.out.println("2-获取线程:" + Thread.currentThread().getName());
        try {
            // 休眠2秒
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("2-归还到线程池:" + Thread.currentThread().getName());
    }
}