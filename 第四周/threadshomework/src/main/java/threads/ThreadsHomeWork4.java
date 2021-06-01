package threads;

import java.util.concurrent.Semaphore;

/**
 * @Author: renqiang
 * @Date: 2021-06-01 23:15
 * @Description: TODO
 */
public class ThreadsHomeWork4 {

    private static int result;
    public static void main(String[] args) throws InterruptedException {
        final Semaphore semaphore = new Semaphore(0);
        Thread subThread = new Thread(new Runnable() {
            public void run() {
                result = sum(2);
                System.out.println("子线程： " + result + " timestamp " + System.currentTimeMillis());
                semaphore.release();
            }
        });
        subThread.start();
        semaphore.acquire();
        System.out.println("主线程：" + result+ " timestamp " + System.currentTimeMillis());
    }

    private static int sum(int i){
        return i + 1;
    }
}
