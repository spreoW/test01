package mySynchronizded;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Synchronized是不可中断锁
 */
public class NotInterrupt2 {
    private static Object  obj = new Object();
    static Lock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        Runnable run = () -> {
            String name = Thread.currentThread().getName();
            try {
                lock.lock();
                System.out.println(name + "获得锁,进入锁执行");
                Thread.sleep(88888);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println(name + "释放锁");
            }
        };
        Thread t1 = new Thread(run);
        t1.start();
        Thread.sleep(1000);
        Thread t2 = new Thread(run);
        t2.start();
        System.out.println("停止t2线程前");
        t2.interrupt();
        System.out.println("停止t2线程后");
        Thread.sleep(1000);
        System.out.println(t1.getState());
        System.out.println(t2.getState());

    }
}
