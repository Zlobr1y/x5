package ru.titov.course.task7.exception;

public class NotEnoughMoneyException extends Exception{
    public NotEnoughMoneyException(){
        System.out.println("Недостаточно средств на балансе");
    }
}
