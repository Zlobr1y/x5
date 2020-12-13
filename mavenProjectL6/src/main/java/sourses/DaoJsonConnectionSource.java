package sourses;

import java.io.*;

public class DaoJsonConnectionSource {
    final File directorySource;


    public DaoJsonConnectionSource(String path) {
        directorySource = new File(path);
        if (!directorySource.exists()) {
            directorySource.mkdir();
        }
    }

    public File getDirectorySource() {
        return directorySource;
    }

    public void write(File file, String account) throws IOException {
        file.createNewFile();
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(account);
        }
    }

    public void delete(File file) throws IOException {
        file.delete();
    }

    public String read(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder object = new StringBuilder();
        while (reader.ready()) {
            object.append(reader.readLine());
        }
        return object.toString();
    }
}