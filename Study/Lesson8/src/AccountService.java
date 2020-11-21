import java.io.FileNotFoundException;
import java.sql.SQLException;

public interface AccountService {


    void withdraw(int accountId, int amount) throws NotEnoughMoneyException, UnknownAccountException, FileNotFoundException, SQLException;

    void balance(int accountId) throws UnknownAccountException, FileNotFoundException;

    void deposit(int accountId, int amount) throws NotEnoughMoneyException, UnknownAccountException, FileNotFoundException, SQLException;

    void transfer(int from, int to, int amount) throws NotEnoughMoneyException, UnknownAccountException, FileNotFoundException, SQLException;


}
