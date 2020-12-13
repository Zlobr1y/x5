package exception;

public class UnknownAccountException extends Exception{
    public UnknownAccountException(String неизвестный_аккаунт){
        System.out.println("Аккаунт с таким id не найден");
    }
}
