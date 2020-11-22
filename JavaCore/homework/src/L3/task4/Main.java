package L3.task4;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        MFU mfu = new MFU();
        ArrayList<Integer> job1 = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            job1.add(i+1);
        }
        ArrayList<Integer> job2 = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            job2.add(i+1);
        }
        ArrayList<Integer> job3 = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            job3.add(i+1);
        }

        ArrayList<Integer> scan1 = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            scan1.add(i+1);
        }
        ArrayList<Integer> scan2 = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            scan2.add(i+1);
        }
        ArrayList<Integer> scan3 = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            scan3.add(i+1);
        }

        PrintJob pJob1 = new PrintJob(mfu,job1);
        PrintJob pJob2 = new PrintJob(mfu,job2);
        PrintJob pJob3 = new PrintJob(mfu,job3);

        ScanJob sJob1 = new ScanJob(mfu,scan1);
        ScanJob sJob2 = new ScanJob(mfu,scan2);
        ScanJob sJob3 = new ScanJob(mfu,scan3);

        new Thread(pJob3).start();
        new Thread(sJob3).start();
        new Thread(pJob2).start();
        new Thread(pJob1).start();
        new Thread(sJob2).start();
        new Thread(sJob1).start();
    }
}

