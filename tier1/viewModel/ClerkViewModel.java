package tier1.viewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ClerkViewModel
{
  private StringProperty errorLabelProperty;
  private StringProperty accountLabelProperty;

  public ClerkViewModel()
  {
    this.errorLabelProperty = new SimpleStringProperty();
    this.accountLabelProperty = new SimpleStringProperty();
  }

  public StringProperty errorLabelPropertyProperty()
  {
    return errorLabelProperty;
  }

  public StringProperty accountLabelPropertyProperty()
  {
    return accountLabelProperty;
  }
}
