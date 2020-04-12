package com.luheng.thread;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 项目启动后,创建线程池
 */
@Component
public class CreateThreadPool implements CommandLineRunner {

    public static ThreadPoolExecutor pool;

    @Override
    public void run(String... strings) throws Exception {
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(1);
        pool = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, workQueue,new MyRejected());
        System.out.println("=========<线程池被创建>=========");
        System.out.println("=========线程池参数:[核心线程数:2]-[最大线程数:8]-[失效时间:1秒]-[失效时间单位:秒]-[工作队列大小:"+workQueue.size()+"]");
        // 添加在jvm关闭前调用的钩子方法,在方法中关闭线程池.
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程池正在关闭.");
                pool.shutdown();
                try {
                    // 等待1秒执行关闭
                    if (!pool.awaitTermination(1, TimeUnit.SECONDS)) {
                        System.out.println("由于等待超时，线程池强制立刻关闭.");
                        pool.shutdownNow();
                    }
                } catch (InterruptedException e) {
                    System.out.println("线程池关闭中断.");
                    pool.shutdownNow();
                }
                System.out.println("线程池关闭完成");
            }
        }));
    }

    public static ThreadPoolExecutor getPool() {
        return pool;
    }
}
