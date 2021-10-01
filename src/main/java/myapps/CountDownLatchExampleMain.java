package myapps;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExampleMain {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        Runtime.getRuntime().addShutdownHook(new Thread("test"){
            @Override
            public void run() {
                System.out.println("Chauuu");
                countDownLatch.countDown();
            }
        });

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        System.exit(0);
    }
}
