package L3.task3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("/home/ww/IdeaProjects/x5/JavaCore/homework/src/L3/task3/file.md");
        FileWriter writer = new FileWriter(file);
        for(int i=0;i<3;i++){
            new Thread(new WriterThread(writer)).start();
        }
    }
}
