package concurrent;

import lombok.AllArgsConstructor;
import sun.nio.ch.ThreadPool;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {
    @AllArgsConstructor
    static class MyRunnable implements Runnable {

        private String command;

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " start time = " + new Date());
            try {
                command();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " end time = " + new Date());
        }

        private void command() throws InterruptedException {
            Thread.sleep(2000);
        }

        @Override
        public String toString() {
            return this.command;
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5, 10, 1L,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(100), new ThreadPoolExecutor.CallerRunsPolicy()
        );
        for (int i = 0; i < 10; i++){
            Runnable worker = new MyRunnable("command " + i);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()){}
        System.out.println("Finished all threads");
    }

}
