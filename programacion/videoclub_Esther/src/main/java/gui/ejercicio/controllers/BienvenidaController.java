package gui.ejercicio.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BienvenidaController {
  @FXML
  private Label labelBienvenida;

  public void cambiarLabel(String mensaje)
  {
    this.labelBienvenida.setText(mensaje);
  }
}
