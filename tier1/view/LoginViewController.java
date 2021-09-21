package tier1.view;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import tier1.CustomerModel;
import tier1.viewModel.LoginViewModel;

import java.io.IOException;
import java.rmi.RemoteException;

public class LoginViewController extends ViewController
{
  @FXML private TextField accountNumberField;
  @FXML private CheckBox clerk;
  private LoginViewModel loginViewModel;

  @Override protected void init() throws InterruptedException
  {
    loginViewModel = super.getViewModelFactory().getLoginViewModel();
    Bindings.bindBidirectional(accountNumberField.textProperty(), loginViewModel.accountNumberProperty(),new NumberStringConverter());
  }

  @Override public void reset() throws InterruptedException
  {
    accountNumberField.setText("");
  }

  @FXML
  private void login(ActionEvent actionEvent) throws IOException
  {
    if (loginViewModel.login()){
      if (clerk.isSelected()){
        super.getViewHandler().openView("ClerkView.fxml");
      }
      else {
        super.getViewHandler().openView("CustomerView.fxml");
      }
    }
  }
}
