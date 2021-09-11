package tier1.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CustomerViewController extends ViewController
{
  @FXML private Button cancelButton;
  @FXML private Button withdrawButton;
  @FXML private TextField accountNumberTextField;
  @FXML private TextField withdrawTextField;
  @FXML Label errorLabel;

  @Override protected void init() throws InterruptedException
  {
    accountNumberTextField.textProperty().bindBidirectional(super.getViewModelFactory().getCustomerViewmodel().accountNumberPropertyProperty());
    withdrawTextField.textProperty().bindBidirectional(super.getViewModelFactory().getCustomerViewmodel().amountPropertyProperty());
    errorLabel.textProperty().bind(super.getViewModelFactory().getCustomerViewmodel().errorPropertyProperty());
  }

  @Override public void reset() throws InterruptedException
  {

  }
}
