package tier3.persistence;

import model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDB implements AccountPersistence{
    @Override
    public void updateAccount(Account account) {
        try (Connection connection = ConnectionDB.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE account SET balance = ? WHERE id= ?");
            statement.setDouble(1, account.getBalance());
            statement.setInt(2, account.getNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account getAccount(int accountNumber) {
        try (Connection connection = ConnectionDB.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM account WHERE id= ?");
            statement.setInt(1, accountNumber);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
               int id=  resultSet.getInt("id");
               double balance = resultSet.getDouble("balance");
               Account account = new Account(id, balance);
               return account;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addAccount(Account account) {
        try (Connection connection = ConnectionDB.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO account (id, balance) VALUES(?, ?)");
            statement.setInt(1, account.getNumber());
            statement.setDouble(2, account.getBalance());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
