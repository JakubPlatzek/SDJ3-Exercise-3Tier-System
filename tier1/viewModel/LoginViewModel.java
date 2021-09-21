package tier1.viewModel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import tier1.CustomerModel;

import java.rmi.RemoteException;

public class LoginViewModel
{
  private CustomerModel model;
  private IntegerProperty accountNumber;
  private ViewState vs;

  public LoginViewModel(CustomerModel model, ViewState vs)
  {
    this.model = model;
    this.vs = vs;
    accountNumber = new SimpleIntegerProperty();
  }

  public boolean login() throws RemoteException
  {
    boolean result = model.login(accountNumber.get());
    vs.setAccountNumber(accountNumber.get());
    return result;
  }

  public CustomerModel getModel(){
    return model;
  }

  public IntegerProperty accountNumberProperty()
  {
    return accountNumber;
  }
}
