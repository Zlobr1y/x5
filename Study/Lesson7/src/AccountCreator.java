import java.io.FileNotFoundException;
import java.sql.SQLOutput;

public class AccountCreator implements AccountService {

    protected String accountInfo;
    protected String accountInfo2;
    protected int subTotal;
    protected int subTotal2;

    FileCreator fileCreator = new FileCreator();

    @Override
    public void withdraw(int accountId, int amount) throws NotEnoughMoneyException, UnknownAccountException, FileNotFoundException {
        accountInfo = fileCreator.findAccountInFile(accountId);
        if (accountInfo == null) {
            throw new UnknownAccountException();
        }
        System.out.println("Изымать (баланс до снятия): " + accountInfo);

        String words[] = accountInfo.split(" ");
        if (amount > Integer.parseInt(words[1])) {
            throw new NotEnoughMoneyException();
        }

        subTotal = Integer.parseInt(words[1]) - amount;
        System.out.println("Итоговый баланс: " + subTotal);

        fileCreator.updateAccountInFile(accountId, subTotal);
        System.out.println("Информация зафиксирована");
    }

    @Override
    public void balance(int accountId) throws UnknownAccountException, FileNotFoundException {
        accountInfo = fileCreator.findAccountInFile(accountId);
        if (accountInfo == null) {
            throw new UnknownAccountException();
        }
        System.out.println("Баланс: " + accountInfo);

    }

    @Override
    public void deposit(int accountId, int amount) throws UnknownAccountException, FileNotFoundException {
        accountInfo = fileCreator.findAccountInFile(accountId);
        System.out.println("Id и баланс до зачисления: " + accountInfo);
        String words[] = accountInfo.split(" ");
        subTotal = Integer.parseInt(words[1]) + amount;
        System.out.println("Итоговый баланс: " + subTotal);
        fileCreator.updateAccountInFile(accountId, subTotal);
        System.out.println("Информация зафиксирована");


    }

    @Override
    public void transfer(int from, int to, int amount) throws NotEnoughMoneyException, UnknownAccountException, FileNotFoundException {
        accountInfo = fileCreator.findAccountInFile(from);
        if (accountInfo == null) {
            throw new NotEnoughMoneyException();
        }
        System.out.println("ИД и баланс до списания: " + accountInfo);
        String words[] = accountInfo.split(" ");
        if (amount > Integer.parseInt(words[1])) {
            throw new NotEnoughMoneyException();
        }

        subTotal = Integer.parseInt(words[1]) - amount;
        fileCreator.updateAccountInFile(from, subTotal);

        accountInfo2 = fileCreator.findAccountInFile(to);
        if (accountInfo2 == null) {
            throw new UnknownAccountException();
        }
        System.out.println("ИД и баланс до зачисления: " + accountInfo2);
        String words2[] = accountInfo2.split(" ");
        subTotal2 = Integer.parseInt(words2[1])+ amount;
        fileCreator.updateAccountInFile(to, subTotal2);

        System.out.println("Информация зафиксирована");
        System.out.println("First: "+ from + " "+ subTotal);
        System.out.println("Second: "+ to + " "+ subTotal2);
    }
}
