package gui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import servicios.ServiciosVideoclub;

import java.net.URL;
import java.util.ResourceBundle;

public class VerSocios implements Initializable {

  @FXML
  private ListView listViewSocios;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    cargarSocios();
  }

  @FXML
  private void cargarSocios(ActionEvent actionEvent) {
    cargarSocios();
  }

  private void cargarSocios() {
    ServiciosVideoclub sv = new ServiciosVideoclub();
    listViewSocios.getItems().clear();
    listViewSocios.getItems().addAll(sv.getSocios());
  }

}
