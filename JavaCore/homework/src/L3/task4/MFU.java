package L3.task4;

import java.util.List;

public class MFU {
    private Object printerLock,scanerLock;

    public MFU() {
        this.printerLock = new Object();
        this.scanerLock = new Object();
    }

    public void print(List<Integer> pages){
        synchronized (printerLock){
            for(int i=0;i<pages.size();i++){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Напечатано: "+(i+1)+" страниц.");
            }
            printerLock.notify();
        }
    }

    public void scan(List<Integer> pages){
        synchronized (scanerLock){
            for(int i=0;i<pages.size();i++){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Отсканировано: "+(i+1)+" страниц.");
            }
            scanerLock.notify();
        }
    }
}
