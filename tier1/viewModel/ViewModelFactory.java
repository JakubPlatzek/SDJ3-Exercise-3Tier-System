package tier1.viewModel;

public class ViewModelFactory
{
  private CustomerViewModel customerViewmodel;
  private AdministratorViewModel administratorViewModel;
  private ClerkViewModel clerkViewModel;

  public ViewModelFactory(){
    customerViewmodel = new CustomerViewModel();
    administratorViewModel = new AdministratorViewModel();
    clerkViewModel = new ClerkViewModel();
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

}
