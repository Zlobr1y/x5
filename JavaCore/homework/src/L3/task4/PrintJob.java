package L3.task4;

import java.util.ArrayList;

public class PrintJob extends Job{
    public PrintJob(MFU mfu, ArrayList<Integer> job) {
        super(mfu, job);
    }

    @Override
    public void run() {
        mfu.print(job);
    }
}
