package L4.x5.threading2.home.barrier;

import java.util.concurrent.CyclicBarrier;

public class Ferry {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new FerryBoat());
        for (int i = 0; i < 9; i++) {
            new Thread(new Car(cyclicBarrier, i+1)).start();
            Thread.sleep(400);
        }
    }

    //Таск, который будет выполняться при достижении сторонами барьера
    public static class FerryBoat implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(500);
                System.out.println("Паром переправил автомобили!");
            } catch (InterruptedException e) {
            }
        }
    }

    //Стороны, которые будут достигать барьера
    public static class Car implements Runnable {
        private CyclicBarrier cyclicBarrier;
        private int carNumber;

        public Car(CyclicBarrier cyclicBarrier, int carNumber) {
            this.cyclicBarrier = cyclicBarrier;
            this.carNumber = carNumber;
        }

        @Override
        public void run() {
            try {
                System.out.printf("Автомобиль №%d подъехал к паромной переправе.\n", carNumber);
                cyclicBarrier.await();
                System.out.printf("Автомобиль №%d продолжил движение.\n", carNumber);
            } catch (Exception e) {
            }
        }
    }
}
