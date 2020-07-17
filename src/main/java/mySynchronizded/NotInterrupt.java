package mySynchronizded;

/**
 * Synchronized是不可中断锁
 */
public class NotInterrupt {
    private static Object  obj = new Object();
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + "开始查锁");
                synchronized (obj){
                    try {
                        System.out.println(Thread.currentThread().getName() + "开始执行");
                        Thread.sleep(80000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t0 = new Thread(runnable);
        Thread t1 = new Thread(runnable);
        t0.start();
        Thread.sleep(1000);
        t1.start();
        t1.interrupt();
        Thread.sleep(1000);
        System.out.println("t0" + t0.getState());
        System.out.println("t1 " +t1.getState());

    }
}
