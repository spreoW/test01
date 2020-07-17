package synchronizedPrinciple;

public class SynchronizedDemo1 {
    static Object obj = new Object();
    public static void main(String[] args) {
        synchronized (obj){
            System.out.println("123");
        }
    }
    public synchronized void test(){
        System.out.println("456");
    }
}
