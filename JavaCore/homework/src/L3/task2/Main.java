package L3.task2;

public class Main {

    public static void main(String[] args) {
        Object lock = new Object();
        Thread sender = new Thread(new SenderReciever("sender",lock));
        Thread reciever = new Thread(new SenderReciever("reciever",lock));

        reciever.start();
        sender.start();

    }
}
