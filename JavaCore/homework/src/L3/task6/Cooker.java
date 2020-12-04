package L3.task6;

import java.io.Closeable;
import java.util.Random;

public class Cooker extends Thread implements Closeable {

    private Random random = new Random();
    private boolean isRun;

    private Kitchen kitchen;
    private String name;
    private int timer;

    public Cooker(Kitchen kitchen, String name, int timer) {
        this.kitchen = kitchen;
        this.name = name;
        this.timer = timer;
    }

    @Override
    public void run() {
        isRun = true;
        while (isRun) {
            try {
                System.out.println(name + ": starting cook");
                Object bread1 = null;
                Object bread2 = null;
                Object meat = null;

                while (bread1 == null) {
                    System.out.println(name + ": getting first bread...");
                    bread1 = kitchen.getBread();
                    if (bread1 == null) {
                        sleep(random.nextInt(timer));
                    }
                }
                System.out.println(name + ": got first bread");

                while (bread2 == null) {
                    System.out.println(name + ": getting second bread...");
                    bread2 = kitchen.getBread();
                    if (bread2 == null) {
                        sleep(random.nextInt(timer));
                    }
                }
                System.out.println(name + ": got second bread");

                while (meat == null) {
                    System.out.println(name + ": getting meat...");
                    meat = kitchen.getMeat();
                    if (meat == null) {
                        sleep(random.nextInt(timer));
                    }
                }
                System.out.println(name + ": got meat");

                System.out.println(name + ": cooking");
                sleep(random.nextInt(timer));
                System.out.println(name + ": cooking done");

                sleep(random.nextInt(timer));
            } catch (InterruptedException e) {
                System.out.println(name + " is interrupted");
            }
        }
        System.out.println(name + ": work done");
    }

    @Override
    public void close() {
        System.out.println(name + ": stopping work...");
        isRun = false;
    }
}
