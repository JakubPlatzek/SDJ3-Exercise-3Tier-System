package tier1.viewModel;

import tier1.CustomerModel;

import java.rmi.RemoteException;

public class ViewModelFactory
{
  private CustomerViewModel customerViewmodel;
  private AdministratorViewModel administratorViewModel;
  private ClerkViewModel clerkViewModel;
  private LoginViewModel loginViewModel;

  public ViewModelFactory(CustomerModel cm) throws RemoteException
  {
    ViewState vs = new ViewState();
    customerViewmodel = new CustomerViewModel(cm, vs);
    administratorViewModel = new AdministratorViewModel();
    clerkViewModel = new ClerkViewModel();
    loginViewModel = new LoginViewModel(cm, vs);
  }
  public CustomerViewModel getCustomerViewmodel()
  {
    return customerViewmodel;
  }

  public AdministratorViewModel getAdministratorViewModel()
  {
    return administratorViewModel;
  }

  public ClerkViewModel getClerkViewModel()
  {
    return clerkViewModel;
  }

  public LoginViewModel getLoginViewModel()
  {
    return loginViewModel;
  }
}
