package tier1.viewModel;

import javafx.beans.property.*;
import tier1.CustomerModel;

import java.rmi.RemoteException;

public class CustomerViewModel
{
  private IntegerProperty accountNumberProperty;
  private DoubleProperty amountProperty;
  private DoubleProperty balance;
  private StringProperty errorProperty;
  private CustomerModel cm;
  private ViewState vs;

  public CustomerViewModel(CustomerModel cm, ViewState vs)
      throws RemoteException
  {
    this.cm = cm;
    this.vs = vs;
    accountNumberProperty = new SimpleIntegerProperty(vs.getAccountNumber());
    amountProperty = new SimpleDoubleProperty();
    errorProperty = new SimpleStringProperty();
    balance = new SimpleDoubleProperty(cm.getBalance(vs.getAccountNumber()));
  }

  public void clear() throws RemoteException
  {
    accountNumberProperty.setValue(vs.getAccountNumber());
    balance.setValue(cm.getBalance(vs.getAccountNumber()));
  }

  public void withdraw(){
    cm.withdraw(vs.getAccountNumber(), amountProperty.get());
    amountProperty.setValue(0);
  }

  public void logout(){
    cm.logout(vs.getAccountNumber());
    vs.setAccountNumber(0);
  }

  public DoubleProperty balanceProperty()
  {
    return balance;
  }

  public IntegerProperty accountNumberPropertyProperty()
  {
    return accountNumberProperty;
  }


  public DoubleProperty amountPropertyProperty()
  {
    return amountProperty;
  }


  public StringProperty errorPropertyProperty()
  {
    return errorProperty;
  }
}
