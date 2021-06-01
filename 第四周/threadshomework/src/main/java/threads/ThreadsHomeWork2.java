package threads;

/**
 * @Author: renqiang
 * @Date: 2021-06-01 22:36
 * @Description: TODO
 */
public class ThreadsHomeWork2 {

    private static int result;
    public static void main(String[] args){
        final Object lockObject = new Object();


        Thread subThread = new Thread(new Runnable() {
            public void run() {
                result = sum(1);
                System.out.println("子线程： "+ result);
                synchronized (lockObject){
                    lockObject.notify();
                }
            }
        });
        subThread.start();

        synchronized (lockObject){
            try {
                lockObject.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("主线程： "+ result);



    }

    private static int sum(int i){
        return i + 1;
    }
}
