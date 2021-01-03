package main.java.ru.titov.course.task8;

import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class Report implements Runnable {
    Storage storage;
    CountDownLatch countDownLatch;

    public Report(Storage storage, CountDownLatch countDownLatch) {
        this.storage = storage;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (storage) {
//            storage.getHarvesterCount().entrySet();
            StringBuilder builder = new StringBuilder();
            for (Map.Entry<Thread, Integer> pair : storage.getHarvesterCount().entrySet()) {
                builder.append(pair.getKey().getName() + " " + pair.getValue() + ",");
            }
            System.out.println(builder.toString());
            storage.notifyAll();
        }
    }

}

