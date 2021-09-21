package tier1.viewModel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import tier1.CustomerModel;

import java.rmi.RemoteException;

public class LoginViewModel
{
  private CustomerModel model;
  private IntegerProperty accountNumber;

  public LoginViewModel(CustomerModel model)
  {
    this.model = model;
    accountNumber = new SimpleIntegerProperty();
  }

  public boolean login() throws RemoteException
  {
    return model.login(accountNumber.get());
  }

  public CustomerModel getModel(){
    return model;
  }

  public IntegerProperty accountNumberProperty()
  {
    return accountNumber;
  }
}
