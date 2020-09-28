public class Account {
    private int accountId;
    private String accountHolder;
    private int amount;

    public Account() {
    }

    public Account(int accountId){
        this.accountId = accountId;
    }
    public Account(int accountId, String accountHolder, int amount){
        this.accountId = accountId;
        this.accountHolder = accountHolder;
        this.amount = amount;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
