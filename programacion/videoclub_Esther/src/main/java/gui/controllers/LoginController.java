package gui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

  @FXML
  private Button boton;


  private PrincipalController principalController;
  private String mensaje;

  public LoginController() {
    this.mensaje = "kk";

  }

  public void setPrincipalController(PrincipalController principalController) {
    this.principalController = principalController;
  }

  // funciona para que la llame el principal
  public void cambiarBoton(String mensaje) {

    boton.setText(mensaje);
  }

  @FXML
  private void login(ActionEvent actionEvent) throws IOException {
    principalController.despuesLogin("Conseguido");
  }


  @Override
  public void initialize(URL location, ResourceBundle resources) {
    boton.setText(mensaje);
  }
}
