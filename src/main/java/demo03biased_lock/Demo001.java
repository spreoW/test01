package demo03biased_lock;

import org.openjdk.jol.info.ClassLayout;

public class Demo001 {
    public static void main(String[] args) {
        MyThread02 t = new MyThread02();
        t.start();
    }
}
class MyThread02 extends Thread{
    Object obj = new Object();
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (obj){
                System.out.println(ClassLayout.parseInstance(obj).toPrintable());
                System.out.println("bbb");
                System.out.println("ccc");
            }
        }
    }
}
