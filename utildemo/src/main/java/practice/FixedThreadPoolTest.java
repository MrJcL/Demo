package practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: Demo
 * @Date: 2019/8/27 22:19
 * @Author: JcLi
 * @Description: 创建包含多个线程的线程池
 */
public class FixedThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService e = Executors.newFixedThreadPool(2);//创建一个包含两个线程的线程池
        Runnable1 runnable1 = new Runnable1();
        Runnable2 runnable2 = new Runnable2();
        e.submit(runnable1);//获取线程池中的某一个线程对象，然后调用runnable接口中的run方法,run执行完后归还线程到线程池
        e.submit(runnable1);
        e.submit(runnable1);
        e.submit(runnable2);
        e.submit(runnable2);
        e.shutdown();
    }
}