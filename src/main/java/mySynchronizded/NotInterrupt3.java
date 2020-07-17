package mySynchronizded;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Synchronized是不可中断锁
 */
public class NotInterrupt3 {
    static Lock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
       Runnable runnable = new Runnable() {
           @Override
           public void run() {
               System.out.println(Thread.currentThread().getName() + "开始查锁");
               boolean b = false;
               try {
                   b = lock.tryLock(3, TimeUnit.SECONDS);
                   if (b){
                        System.out.println(Thread.currentThread().getName() + "开始执行");
                        Thread.sleep(80000);
                    }else {
                        System.out.println(Thread.currentThread().getName()+"在规定时间没获得锁，做其他操作");
                    }
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }finally {
                    if(b){
                        lock.unlock();
                    }
                }
           }
       };
        Thread t0 = new Thread(runnable);
        t0.start();
        Thread.sleep(1000);
        Thread t1 = new Thread(runnable);
        t1.start();

    }
}
