package gui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Principal implements Initializable {

  @FXML
  private BorderPane pantallaPrincipal;
  @FXML
  private ImageView imagenBienvenida;


  private Alert a;

  private AnchorPane pantallaCrearSocio;
  private AnchorPane pantallaVerSocio;
  private AnchorPane pantallaSecundaria;


  @FXML
  private void verSocios(ActionEvent actionEvent) throws IOException {
    if (pantallaVerSocio == null) {
      FXMLLoader loaderMenu = new FXMLLoader(
          getClass().getResource("/fxml/verSocios.fxml"));
      pantallaVerSocio = loaderMenu.load();
    }
    pantallaPrincipal.setCenter(pantallaVerSocio);
  }

  @FXML
  private void menuCrearSocio(ActionEvent actionEvent) throws IOException {

    if (pantallaCrearSocio == null) {
      FXMLLoader loaderMenu = new FXMLLoader(
          getClass().getResource("/fxml/crearSocio.fxml"));
      pantallaCrearSocio = loaderMenu.load();
    }
    pantallaPrincipal.setCenter(pantallaCrearSocio);
  }

  @FXML
  private void menuCrearVideojuego(ActionEvent actionEvent) throws IOException {

    if (pantallaSecundaria == null) {
      FXMLLoader loaderMenu = new FXMLLoader(
          getClass().getResource("/fxml/segundaVentana.fxml"));
      pantallaSecundaria = loaderMenu.load();
    }
    pantallaPrincipal.setCenter(pantallaSecundaria);
  }


  @Override
  public void initialize(URL location, ResourceBundle resources) {
    a = new Alert(Alert.AlertType.INFORMATION);


    imagenBienvenida.setImage(new Image(Principal.class.getResourceAsStream("/images/m1.jpg")));
  }
}
