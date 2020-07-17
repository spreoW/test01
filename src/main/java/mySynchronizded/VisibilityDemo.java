package mySynchronizded;

/**
 * 可见性
 */
public class VisibilityDemo {
    static boolean flag = true;
    static Object object = new Object();
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            public void run() {
                while (flag){
                    System.out.println(" ");
                }
            }
        }).start();
        Thread.sleep(2000);
        new Thread(new Runnable() {
            public void run() {
                flag = false;
                System.out.println("flag = false");
            }
        }).start();
    }

}
