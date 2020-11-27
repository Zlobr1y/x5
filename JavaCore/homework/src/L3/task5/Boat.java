package L3.task5;

public class Boat implements Runnable {
    Object lock;
    private int count;
    private int number;

    public Boat(Object lock, int count) {

        this.lock = lock;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            number = i;
            takeBoat(number);
            count--;
            if (count == 0){
                System.out.printf("Горшочек не ВАРИ!!!!!!!!!!");
            }
            if (i == 4) {
                i = 0;
            }

        }
    }

    public void takeBoat(int number) {
        synchronized (lock) {
            int random = (int) (200 + Math.random() * 800);
            System.out.println("Boat number " + this.number + " is sailing " + random + " time");
            try {
                Thread.sleep(random);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Boat number " + this.number + " is finish sail");
            lock.notify();
        }
    }
}
