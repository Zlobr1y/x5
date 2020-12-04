package L3.task6;

import javax.naming.ConfigurationException;
import java.io.Closeable;
import java.util.Random;

public class Deliver extends Thread implements Closeable {

    private Random random = new Random();
    private String mode;
    private boolean isRun;

    private Kitchen kitchen;
    private int timer;
    private String name;

    public Deliver(Kitchen kitchen, String mode, int timer, String name) throws ConfigurationException {
        if (!mode.equals("meat") && !mode.equals("bread")) {
            throw new ConfigurationException("Deliver: Bad mode, possible values: meat, bread");
        }

        this.kitchen = kitchen;
        this.mode = mode;
        this.timer = timer;
        this.name = name;
    }

    @Override
    public void run() {
        isRun = true;
        while (isRun) {
            try {
                if (mode.equals("meat")) {
                    System.out.println(name + ": adding meat...");
                    kitchen.addMeat("meat");
                } else if (mode.equals("bread")) {
                    System.out.println(name + ": adding bread...");
                    kitchen.addBread("bread");
                }
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
