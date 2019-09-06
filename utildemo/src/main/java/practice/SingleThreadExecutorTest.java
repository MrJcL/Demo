package practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: Demo
 * @Date: 2019/8/27 22:19
 * @Author: JcLi
 * @Description: 创建一个单线程的线程池
 */
public class SingleThreadExecutorTest {

    public static void main(String[] args) {
        ExecutorService e = Executors.newSingleThreadExecutor();//创建一个单线程的线程池
        e.submit(new Runnable1());
        e.submit(new Runnable2());
        e.submit(new Runnable1());
        e.submit(new Runnable2());
        e.submit(new Runnable1());
        e.submit(new Runnable2());
        e.shutdown();
    }
}

