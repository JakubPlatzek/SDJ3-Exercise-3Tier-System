package tier1.view;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CustomerViewController extends ViewController
{
  @FXML private Button cancelButton;
  @FXML private Button withdrawButton;
  @FXML private Label accountNumberLabel;
  @FXML private TextField withdrawTextField;
  @FXML private Label errorLabel;

  @Override protected void init() throws InterruptedException
  {
    Bindings.bindBidirectional(withdrawTextField.textProperty(),
        super.getViewModelFactory().getCustomerViewmodel().amountPropertyProperty(), new NumberStringConverter());
    errorLabel.textProperty().bind(super.getViewModelFactory().getCustomerViewmodel().errorPropertyProperty());

  }

  @Override public void reset() throws InterruptedException
  {

  }

  @FXML
  private void withdrawButtonHandle(ActionEvent actionEvent)
  {

  }

  @FXML
  private void cancelButtonHandle(ActionEvent actionEvent)
  {

  }
}
