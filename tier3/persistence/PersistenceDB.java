package tier3.persistence;

import model.Account;

public class PersistenceDB implements Persistence{
    AccountPersistence accountDB;

    public PersistenceDB(){
        accountDB = new AccountDB();
    }

    @Override
    public void updateAccount(Account account) {
        accountDB.updateAccount(account);
    }

    @Override
    public Account getAccount(int accountNumber) {
        return accountDB.getAccount(accountNumber);
    }

    @Override
    public void addAccount(Account account) {
        accountDB.addAccount(account);
    }
}
