package main.java.ru.titov.course.task8;


import java.util.concurrent.CountDownLatch;

public class Harvester implements Runnable {
    Storage storage;
    CountDownLatch countDownLatch;
    int randomTimeForWork = getRandomTime();
    int appleCount = getAppleCount();

    public Harvester(Storage storage, CountDownLatch countDownLatch){
        this.storage = storage;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run(){
        try {
            Thread.sleep(randomTimeForWork); //собираем яблоки
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        storage.setHarvesterCount(Thread.currentThread(), appleCount);
        countDownLatch.countDown();
        synchronized (storage){
            try {
                storage.wait();
                System.out.println("Время сборки: " + randomTimeForWork + ", количество яблок: " + appleCount+ ", скорость сборки: "+ appleCount/randomTimeForWork);
                System.out.println(Thread.currentThread().getName()+ " получил зарплату: "+ getSalary());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    private int getRandomTime(){
        return (int) (900 + Math.random() * 2600);
    }

    private int getAppleCount(){
        return (int) (randomTimeForWork * 10 * Math.PI * (800 + Math.random() * 700));
    }

    private double getSalary(){
        return appleCount*7;
    }



}