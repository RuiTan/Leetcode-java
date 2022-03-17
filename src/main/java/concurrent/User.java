package concurrent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class User implements Runnable{

    private static Integer number = 100;

    @Getter
    @Setter
    private String name;

    @Override
    public void run() {
        try {
            Thread.sleep(500);
            synchronized (number){
                number--;
                System.out.println(name + "submitted, " + number + " remained.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5, 10, 100,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(100), new ThreadPoolExecutor.CallerRunsPolicy()
        );
        for (int i = 0; i < number; i++) {
            final String message = i + " submitted!";
            threadPoolExecutor.execute(() -> {
                synchronized (number){
                    number--;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        countDownLatch.countDown();
                        System.out.println(message);
                    }
                }
            });
        }
        countDownLatch.await();
        System.out.println("剩余：" + number);
        System.out.println("开始发公告！");
        threadPoolExecutor.shutdown();
        while (!threadPoolExecutor.isTerminated()) {}
        System.out.println("全部完成！");
    }
}
