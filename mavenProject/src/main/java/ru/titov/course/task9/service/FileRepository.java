package ru.titov.course.task9.service;

import java.io.*;

public class FileRepository {
    final File source;

    public File getSource() {
        return source;
    }

    public FileRepository() {
        this.source = new File("json/");
        if (!source.exists()) {
            source.mkdir();
        }
    }

    public void write(int id, String account) throws IOException {
        File newFile = getFile(id);
        if (newFile == null) {
            throw new IOException("File doesn't exist");
        }
        newFile.createNewFile();
        try (FileWriter writer = new FileWriter(newFile)) {
            writer.write(account);
        }
    }

    public void delete(int id) throws IOException {
        File toDel = getFile(id);
        if (toDel == null) {
            throw new IOException("Account is null");
        }
        if (!toDel.exists()) {
            throw new IOException(("File is not found"));
        }
        toDel.delete();
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
        File newAccount = new File(source + File.separator + id + ".json");
        return newAccount;
    }

    public boolean accountExists(int id) {
        return getFile(id).exists();
    }
}
