public class AccountCreator implements AccountService {

    protected int subTotal;
    protected int subTotal2;


    DbConnectController dbConnectController = new DbConnectController();


    @Override
    public void withdraw(int accountId, int amount) throws NotEnoughMoneyException, UnknownAccountException {
        try {
            subTotal = (dbConnectController.findAccountInDb(accountId) - amount);
        } catch (NullPointerException | NumberFormatException e) {
            throw new UnknownAccountException();
        }
        if (amount > dbConnectController.findAccountInDb(accountId)) {
            throw new NotEnoughMoneyException();
        }
        dbConnectController.updateAccountInDb(accountId, subTotal);
        System.out.println("Balance " + accountId + ": " + subTotal);
    }


    @Override
    public void balance(int accountId) throws UnknownAccountException {

        try {
            System.out.println(accountId + " " + dbConnectController.findAccountInDb(accountId));
        } catch (NullPointerException | NumberFormatException e) {
            throw new UnknownAccountException();
        }

    }

    @Override
    public void deposit(int accountId, int amount) throws UnknownAccountException {
        try {
            subTotal = (dbConnectController.findAccountInDb(accountId) + amount);
        } catch (NullPointerException | NumberFormatException e) {
            throw new UnknownAccountException();
        }
        dbConnectController.updateAccountInDb(accountId, subTotal);
        System.out.println("Balance " + accountId + ": " + subTotal);


    }

    @Override
    public void transfer(int from, int to, int amount) throws NotEnoughMoneyException, UnknownAccountException {
        try {
            subTotal = (dbConnectController.findAccountInDb(from) - amount);
            subTotal2 = (dbConnectController.findAccountInDb(to) + amount);
        } catch (NullPointerException | NumberFormatException e) {
            throw new UnknownAccountException();
        }
        if (amount > dbConnectController.findAccountInDb(from)) {
            throw new NotEnoughMoneyException();
        }
        dbConnectController.updateAccountInDb(from, subTotal);
        dbConnectController.updateAccountInDb(to, subTotal2);
        System.out.println("Balance " + from + ": " + subTotal);
        System.out.println("Balance " + to + ": " + subTotal2);
    }
}

