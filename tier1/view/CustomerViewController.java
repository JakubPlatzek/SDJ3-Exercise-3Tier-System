package tier1.view;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CustomerViewController extends ViewController
{
  @FXML private Button cancelButton;
  @FXML private Button withdrawButton;
  @FXML private Label accountNumberLabel;
  @FXML private Label balanceLabel;
  @FXML private TextField withdrawTextField;
  @FXML private Label errorLabel;

  @Override protected void init() throws InterruptedException
  {
    Bindings.bindBidirectional(withdrawTextField.textProperty(),
        super.getViewModelFactory().getCustomerViewmodel().amountPropertyProperty(), new NumberStringConverter());
    Bindings.bindBidirectional(accountNumberLabel.textProperty(),
        super.getViewModelFactory().getCustomerViewmodel().accountNumberPropertyProperty(),new NumberStringConverter());
    Bindings.bindBidirectional(balanceLabel.textProperty(),
        super.getViewModelFactory().getCustomerViewmodel().balanceProperty(), new NumberStringConverter());
    errorLabel.textProperty().bind(super.getViewModelFactory().getCustomerViewmodel().errorPropertyProperty());
  }

  @Override public void reset() throws InterruptedException
  {
    try{
      super.getViewModelFactory().getCustomerViewmodel().clear();
    }catch (Exception e){
      System.err.println(e);
    }
  }

  @FXML
  private void withdrawButtonHandle(ActionEvent actionEvent)
  {
    super.getViewModelFactory().getCustomerViewmodel().withdraw();
    try{
      super.getViewModelFactory().getCustomerViewmodel().clear();
    }catch (Exception e){
      System.err.println(e);
    }
  }

  @FXML
  private void cancelButtonHandle(ActionEvent actionEvent) throws IOException
  {
    super.getViewModelFactory().getCustomerViewmodel().logout();
    super.getViewHandler().openView("loginView.fxml");
  }
}
