package Task1;

public class DbLogger extends Logger {

    @Override
    public void log(String message) {
        System.out.println("Log into database: " + message);
    }

}