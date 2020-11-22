package L3.task4;

import java.util.ArrayList;

public class Job implements Runnable {
    MFU mfu;
    ArrayList<Integer> job;

    public Job(MFU mfu, ArrayList<Integer> job) {
        this.mfu = mfu;
        this.job = job;
    }

    public void run() {
        mfu.print(job);
    }
}

