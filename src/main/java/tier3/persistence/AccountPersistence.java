package tier3.persistence;

import model.Account;

public interface AccountPersistence {
    void updateAccount(Account account);
    Account getAccount(int accountNumber);
    void addAccount(Account account);
}
