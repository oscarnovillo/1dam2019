package gui.controllers;

import dao.DaoSocios;
import dao.implentaciones.DaoSociosImpl;
import dao.modelo.Socio;
import dao.modelo.Videojuego;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import servicios.ServiciosVideoclub;

import java.net.URL;
import java.util.ResourceBundle;

public class TestController implements Initializable {


  private ServiciosVideoclub sv;

  @FXML
  private ListView<Socio> listSocios;
  @FXML
  private TextField textFabricante;
  @FXML
  private Label labelFabricante;
  @FXML
  private CheckBox checkPrueba;
  @FXML
  private RadioButton radioTonto;
  @FXML
  private RadioButton radioListo;
  @FXML
  private ToggleGroup capacidad;
  @FXML
  private ComboBox<Socio> comboPersonas;
  @FXML
  private Label labelCaja;
  @FXML
  private TextField textCaja;
  public TestController() {

    sv = new ServiciosVideoclub();
    sv.addSocio(new Socio("nif1", "hh", "diur", "tel", 12));
    sv.addSocio(new Socio("nif2", "hh", "diur", "tel", 12));
  }

  @FXML
  private void pinchaBoton(ActionEvent actionEvent) {
    Videojuego v = new Videojuego(textCaja.getText(), 12, "", "");
    labelCaja.setText(textCaja.getText());
    Alert a = new Alert(Alert.AlertType.INFORMATION);
    if (checkPrueba.isSelected()) {
      if (comboPersonas.getSelectionModel().getSelectedItem() != null) {
        a.setContentText(comboPersonas.getSelectionModel().getSelectedItem().getNif());
      } else {
        a.setContentText("selecciona socio");
      }

      a.showAndWait();
    } else {
      comboPersonas.getItems().add(new Socio("nif2", "hh", "diur", "tel", 12));
    }

    a.setContentText(listSocios.getSelectionModel().getSelectedItem().getNif());
    a.showAndWait();
    labelCaja.setText("VENTANA FUERA");
  }


  @Override
  public void initialize(URL location, ResourceBundle resources) {
    textCaja.setText("hola");
    DaoSocios dao = new DaoSociosImpl();
    comboPersonas.getItems().addAll(dao.getSocios());
    listSocios.getItems().addAll(dao.getSocios());

    checkPrueba.setSelected(true);
  }

  public void cambiaPersona(ActionEvent actionEvent) {
    textCaja.setText(comboPersonas.getSelectionModel().getSelectedItem().getNif());
  }

  public void checkVideojuego(ActionEvent actionEvent) {
    if (checkPrueba.isSelected()) {
      labelFabricante.setVisible(true);
      textFabricante.setDisable(false);
    } else {
      labelFabricante.setVisible(false);
      textFabricante.setDisable(true);
    }

  }
}
