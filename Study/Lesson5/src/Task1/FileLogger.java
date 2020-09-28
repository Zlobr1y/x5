package Task1;

public class FileLogger extends Logger {

    @Override
    public void log(String message) {
        System.out.println("Log into file: " + message);
    }

}