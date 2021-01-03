package main.java.ru.titov.course.task8;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(500);
        Storage storage = new Storage();
        Report report = new Report(storage, countDownLatch);


        for (int i = 0; i < 500; i++){
            new Thread(new Harvester(storage, countDownLatch)).start();
        }
        new Thread(report).start();
        
    }
}
