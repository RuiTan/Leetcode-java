package concurrent;

import java.util.Date;
import java.util.concurrent.*;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        final int count = 10;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5, 10, 100,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.CallerRunsPolicy()
        );
        CountDownLatch countDownLatch = new CountDownLatch(count);
        for (int i = 0; i < 10; i++){
            threadPoolExecutor.execute(() -> {
                        try {
                            System.out.println(Thread.currentThread().getName() + " start time " + new Date());
                            Thread.sleep(2000);
                            System.out.println(Thread.currentThread().getName() + " end time " + new Date());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            System.out.println(countDownLatch.getCount());
                            countDownLatch.countDown();
                        }
                    }
            );
        }
        countDownLatch.await();
        threadPoolExecutor.shutdown();
        while (!threadPoolExecutor.isTerminated()){}
        System.out.println("Finished!");
    }
}
