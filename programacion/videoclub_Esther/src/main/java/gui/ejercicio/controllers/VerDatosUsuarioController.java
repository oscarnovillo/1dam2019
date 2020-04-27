package gui.ejercicio.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class VerDatosUsuarioController {
  @FXML
  private Label labelUsuario;
  @FXML
  private Label labelTipo;

  private PrincipalController principalController;

  public void setPrincipalController(PrincipalController principalController) {
    this.principalController = principalController;
  }

  @FXML
  private void volverBienvenida(ActionEvent actionEvent) {
    principalController.ponerPantallaBienvenida();
  }

  public void setDatos(String usuario,String tipo)
  {
    labelUsuario.setText("el Usuario es "+usuario);
    labelTipo.setText("el tipo del usuario es "+tipo);
  }

}
