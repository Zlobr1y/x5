package exception;

public class DublicatePrimaryKeyException extends Exception {
    public DublicatePrimaryKeyException(){
        System.out.println("Данный акаунт уже есть в БД. Проверьте правильность написания номера аккаунта");
    }
}
