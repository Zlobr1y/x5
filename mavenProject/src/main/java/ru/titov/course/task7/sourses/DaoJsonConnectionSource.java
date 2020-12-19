package ru.titov.course.task7.sourses;

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

    public String read(int id) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(getFile(id)));
        StringBuilder object = new StringBuilder();
        while (reader.ready()) {
            object.append(reader.readLine());
        }
        return object.toString();
    }
    private File getFile(int id) {
        File newAcc = new File(directorySource + File.separator + id + ".json");
        return newAcc;
    }
    public boolean accountExists(int id) {
        return getFile(id).exists();
    }
}