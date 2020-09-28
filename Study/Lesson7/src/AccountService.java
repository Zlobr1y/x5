import java.io.FileNotFoundException;

public interface AccountService {


    void withdraw(int accountId, int amount) throws NotEnoughMoneyException, UnknownAccountException, FileNotFoundException;

    void balance(int accountId) throws UnknownAccountException, FileNotFoundException;

    void deposit(int accountId, int amount) throws NotEnoughMoneyException, UnknownAccountException, FileNotFoundException;

    void transfer(int from, int to, int amount) throws NotEnoughMoneyException, UnknownAccountException, FileNotFoundException;


}
