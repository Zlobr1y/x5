package L3.task3;

import java.io.FileWriter;
import java.io.IOException;

public class WriterThread implements Runnable{

    private FileWriter fileWriter;

    public WriterThread(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public void run() {
        while(true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                synchronized (fileWriter) {
                    for (int i = 0; i < 10; i++) {
                        fileWriter.write(Thread.currentThread().getName() + "writing line " + (i + 1) + "\n");
                    }
                    fileWriter.flush();
                    fileWriter.notifyAll();

                    try {
                        fileWriter.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
