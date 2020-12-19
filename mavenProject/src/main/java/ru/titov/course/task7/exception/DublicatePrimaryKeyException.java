package ru.titov.course.task7.exception;

public class DublicatePrimaryKeyException extends Exception {
    public DublicatePrimaryKeyException(String msg) {
        super(msg);
    }
}
