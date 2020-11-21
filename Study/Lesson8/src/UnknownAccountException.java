public class UnknownAccountException extends Exception{
    public UnknownAccountException(){
        System.out.println("Аккаунт с таким id не найден");
    }
}
