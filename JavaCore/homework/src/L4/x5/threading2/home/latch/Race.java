package L4.x5.threading2.home.latch;

import java.util.concurrent.CountDownLatch;

public class Race {

    //Условная длина гоночной трассы
    private static final int trackLength = 500000;
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        CountDownLatch start = new CountDownLatch(3);
        for (int i = 1; i <= 5; i++) {
            new Thread(new Car(start, countDownLatch, i, (int) (Math.random() * 100 + 50))).start();
            Thread.sleep(1000);
        }
        System.out.println("На старт!");
        Thread.sleep(1000);
        start.countDown();
        System.out.println("Внимание!");
        Thread.sleep(1000);
        start.countDown();
        System.out.println("Марш!");
        start.countDown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class Car implements Runnable {
        private int carNumber;
        private int carSpeed;//считаем, что скорость автомобиля постоянная
        private CountDownLatch start;
        private CountDownLatch countDownLatch;

        public Car(CountDownLatch start, CountDownLatch countDownLatch, int carNumber, int carSpeed) {
            this.carNumber = carNumber;
            this.carSpeed = carSpeed;
            this.start = start;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                System.out.printf("Автомобиль №%d подъехал к стартовой прямой.\n", carNumber);
                countDownLatch.countDown();
                countDownLatch.await();
                start.await();
                Thread.sleep(trackLength / carSpeed);//ждем пока проедет трассу
                System.out.printf("Автомобиль №%d финишировал!\n", carNumber);
            } catch (InterruptedException e) {
            }
        }
    }
}
