package L3.task1;

public class PingThread implements Runnable {

    private String echo;
    private Object lock;

    public PingThread(String echo, Object lock) {
        this.echo = echo;
        this.lock = lock;
    }

    public void run() {

        while (true) {
            synchronized (lock) {
                System.out.println(echo);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                lock.notify();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
