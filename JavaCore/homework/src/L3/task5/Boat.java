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
            number = i + 1;
            takeBoat(number);
            count--;
            if (count == 0) {
                System.out.println(Thread.currentThread().getName() + "НАКАТАЛСЯ!");
                break;
            }
            if (i == 4) {
                i = 0;
            }

        }
    }

    public void takeBoat(int number) {
        int random;
        synchronized (lock) {
            random = (int) (200 + Math.random() * 800);
            System.out.println("Boat number " + this.number + " is sailing " + random + " time");
            try {
                Thread.sleep(random);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Boat number " + this.number + " is finish sail");
        }
        lock.notify();
        try {
            random = (int) (Math.random() * 1000);
            Thread.sleep(random);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
