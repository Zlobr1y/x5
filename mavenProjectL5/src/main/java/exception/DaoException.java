package exception;

public class DaoException extends Exception {
    public DaoException(String msg, Throwable e) {
        super(msg, e);
    }
}
