package threads;

/**
 * @Author: renqiang
 * @Date: 2021-06-01 22:32
 * @Description: TODO
 */
public class ThreadsHomeWork1 {

    private static int result;

    public static void main(String[] args) throws InterruptedException {
        Thread subThread = new Thread(new Runnable() {
            public void run() {
                result = sum(1) ;
                System.out.println("子线程 "+ result );
            }
        });

        subThread.start();
        subThread.join();
        System.out.println("主线程 "+ result );
    }

    private static int sum(int i){
        return i + 1;
    }
}
