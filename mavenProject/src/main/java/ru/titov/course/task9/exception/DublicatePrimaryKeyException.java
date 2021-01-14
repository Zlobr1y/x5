package ru.titov.course.task9.exception;

public class DublicatePrimaryKeyException extends Exception {
    public DublicatePrimaryKeyException(String msg) {
        super(msg);
    }
}
