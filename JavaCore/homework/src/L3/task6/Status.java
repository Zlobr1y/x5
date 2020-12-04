package L3.task6;

import java.io.Closeable;

public class Status extends Thread implements Closeable {

    private boolean isRun;
    private int timer = 1000;
    private Kitchen kitchen;

    public Status(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    @Override
    public void run() {
        isRun = true;
        while (isRun) {
            try {
                int breadCount = kitchen.getBreadsCount();
                int meatCount = kitchen.getMeatsCount();
                int burgersCount = 0;
                if (Math.floorDiv(breadCount, 2) < meatCount) {
                    burgersCount = Math.floorDiv(breadCount, 2);
                } else breadCount = meatCount;

                System.out.println("Status: bread - " + breadCount + "  meat - " + meatCount + "  can cook " + burgersCount + " burgers");
                sleep(timer);
            } catch (InterruptedException e) {
                System.out.println("Status is interrupted");
            }
        }
        System.out.println("Status: work done");
    }

    @Override
    public void close() {
        System.out.println("Status: stopping work...");
        isRun = false;
    }
}
