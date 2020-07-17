package mySynchronizded;

/**
 * Synchronized的可重入性
 *
 * 1、定义一个线程类。
 * 2、在线程run方法嵌套2个synchronized方法。
 * 3、用2个线程来执行。
 */
public class ReentrantDomo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new ReentrantThread();
        Thread thread2 = new ReentrantThread();
        thread.start();
        thread2.start();
    }
}
class ReentrantThread extends Thread{
    @Override
    public void run() {
        synchronized (ReentrantThread.class){
            System.out.println(getName()+"进入了同步代码块1");
            synchronized (ReentrantThread.class){
                System.out.println(getName()+"进入了同步代码块2");
            }
        }
    }
}