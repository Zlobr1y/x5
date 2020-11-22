package L3.task2;

public class SenderReciever implements Runnable{
    Object lock;
    String name;

    public SenderReciever(String name, Object lock) {
        this.name = name;
        this.lock = lock;
    }

    public void run() {
        while (true){
            if(name.equals("sender")){
                sendData();
            }else if(name.equals("reciever")){
                getData();
            }
        }
    }

    public void getData(){
        synchronized (lock){
            System.out.println(name+" get data");
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name+" get data finished.");
            lock.notify();
        }
    }

    public void sendData(){
        synchronized (lock){
            System.out.println(name+" send data");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sended.");
            lock.notify();
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
