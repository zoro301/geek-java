package threads;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: renqiang
 * @Date: 2021-06-01 23:15
 * @Description: TODO
 */
public class ThreadsHomeWork5 {

    private static int result;
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Thread subThread = new Thread(new Runnable() {
            public void run() {
                result = sum(2);
                System.out.println("子线程： " + result + " timestamp " + System.currentTimeMillis());
                countDownLatch.countDown();
            }
        });
        subThread.start();
        countDownLatch.await();
        System.out.println("主线程：" + result+ " timestamp " + System.currentTimeMillis());
    }

    private static int sum(int i){
        return i + 1;
    }
}
