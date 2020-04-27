package gui.ejercicio.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class LoginController {

  @FXML
  private TextField textUsuario;
  @FXML
  private ToggleGroup tipoUsuario;

  private PrincipalController principalController;

  public void setPrincipalController(PrincipalController principalController) {
    this.principalController = principalController;
  }

  public void reset() {
    textUsuario.setText("");
    tipoUsuario.getSelectedToggle().setSelected(false);
  }

  @FXML
  private void loginClick(ActionEvent actionEvent) {
    if (textUsuario.getText().isEmpty() || tipoUsuario.getSelectedToggle() == null) {
      Alert a = new Alert(Alert.AlertType.ERROR);
      a.setContentText("Rellena bien los datos");
      a.showAndWait();
    } else {
      ((RadioButton)tipoUsuario.getSelectedToggle()).getText();

      principalController.configMenu(textUsuario.getText(),
          tipoUsuario.getSelectedToggle().getUserData().toString());
    }
  }
}
