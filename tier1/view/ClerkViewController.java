package tier1.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ClerkViewController extends ViewController
{
  @FXML private Label accountNumberLabel;
  @FXML private Label errorLabel;
  @FXML private TextField withdrawTextField;
  @FXML private TextField depositTextField;

  @Override protected void init() throws InterruptedException
  {
    errorLabel.textProperty().bind(super.getViewModelFactory().getClerkViewModel().errorLabelPropertyProperty());
    accountNumberLabel.textProperty().bindBidirectional(super.getViewModelFactory().getClerkViewModel().accountLabelPropertyProperty());
  }

  @Override public void reset() throws InterruptedException
  {
    errorLabel.setText("");
    withdrawTextField.setText("");
    depositTextField.setText("");

  }
  public void submitButtonHandle(ActionEvent actionEvent) throws IOException
  {
    super.getViewHandler().openView("LoginView.fxml");
  }

  public void cancelButtonHandle(ActionEvent actionEvent) throws IOException
  {
    super.getViewHandler().openView("LoginView.fxml");
  }

}
