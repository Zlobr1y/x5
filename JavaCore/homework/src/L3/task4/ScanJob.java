package L3.task4;

import java.util.ArrayList;

public class ScanJob extends Job {
    public ScanJob(MFU mfu, ArrayList<Integer> job) {
        super(mfu, job);
    }

    @Override
    public void run() {
        mfu.scan(job);
    }
}
