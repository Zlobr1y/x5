package L3.task1;

public class Main {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread pingTh = new Thread(new PingThread("ping",lock));
        Thread pongTh = new Thread(new PingThread("pong",lock));


        pingTh.start();
        pongTh.start();
    }
}
