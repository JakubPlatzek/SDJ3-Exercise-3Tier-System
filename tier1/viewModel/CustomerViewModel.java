package tier1.viewModel;

import javafx.beans.property.*;

public class CustomerViewModel
{
  private IntegerProperty accountNumberProperty;
  private IntegerProperty amountProperty;
  private StringProperty errorProperty;

  public CustomerViewModel(){
    accountNumberProperty = new SimpleIntegerProperty();
    amountProperty = new SimpleIntegerProperty();
    errorProperty = new SimpleStringProperty();
  }


  public IntegerProperty accountNumberPropertyProperty()
  {
    return accountNumberProperty;
  }


  public IntegerProperty amountPropertyProperty()
  {
    return amountProperty;
  }


  public StringProperty errorPropertyProperty()
  {
    return errorProperty;
  }
}
