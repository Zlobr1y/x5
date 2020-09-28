import java.io.IOException;

public class Main {
    public static void main(String[] args) throws UnknownAccountException, NotEnoughMoneyException, IOException {
        AccountManagment accountManagment = new AccountManagment();
        accountManagment.startAccountManagment();

    }
}
