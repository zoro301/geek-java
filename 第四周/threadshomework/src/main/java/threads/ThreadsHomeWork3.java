package threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: renqiang
 * @Date: 2021-06-01 23:02
 * @Description: TODO
 */
public class ThreadsHomeWork3 {

    private static int result;
    public static void main(String[] args){
        final Lock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();

        final Thread subThread = new Thread(new Runnable() {
            public void run() {
                result = sum(2);
                System.out.println("子线程： " + result);
                try {
                    lock.lock();
                    condition.signal();
                }finally {
                    lock.unlock();
                }
            }
        });
        subThread.start();

        try{
            lock.lock();
            condition.await();
            System.out.println("主线程：" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private static int sum(int i){
        return i + 1;
    }
}
