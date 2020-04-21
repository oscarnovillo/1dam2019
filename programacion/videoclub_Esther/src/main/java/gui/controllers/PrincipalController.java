package gui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import javax.inject.Inject;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrincipalController implements Initializable {


  @FXML
  private MenuBar menu;
  @FXML
  private BorderPane pantallaPrincipal;
  @FXML
  private ImageView imagenBienvenida;

  @Inject
  FXMLLoader fxmlLoader;

  private Alert a;

  private AnchorPane pantallaCrearSocio;
  private CrearSocioController crearSocioController;

  private AnchorPane pantallaVerSocio;
  private AnchorPane pantallaSecundaria;

  private AnchorPane pantallaLogin;
  private LoginController loginController;




  public void despuesLogin(String mensaje) throws IOException {
    menu.setVisible(true);
    crearSocioController.setTextDni(mensaje);
    menuCrearSocio();
  }

  @FXML
  private void verSocios() throws IOException {
    if (pantallaVerSocio == null) {
      FXMLLoader loaderMenu = new FXMLLoader(
          getClass().getResource("/fxml/verSocios.fxml"));
      pantallaVerSocio = loaderMenu.load();
    }
    pantallaPrincipal.setCenter(pantallaVerSocio);
  }

  @FXML
  private void sacarLogin() throws IOException {

    if (pantallaLogin == null) {
      FXMLLoader loaderMenu = new FXMLLoader(
          getClass().getResource("/fxml/login.fxml"));
      pantallaLogin = loaderMenu.load();
      loginController = loaderMenu.getController();
      loginController.cambiarBoton("mensaje cambiado");
      loginController.setPrincipalController(this);
    }
    pantallaPrincipal.setCenter(pantallaLogin);
  }

  @FXML
  private void menuCrearSocio() throws IOException {

    if (pantallaCrearSocio == null) {
      FXMLLoader loaderMenu = new FXMLLoader(
          getClass().getResource("/fxml/crearSocio.fxml"));
      pantallaCrearSocio = loaderMenu.load();
      crearSocioController = loaderMenu.getController();
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


  private void preCargaCrearSocio()
  {
    try {
      FXMLLoader loaderMenu = new FXMLLoader(
          getClass().getResource("/fxml/crearSocio.fxml"));
      pantallaCrearSocio = loaderMenu.load();
      crearSocioController = loaderMenu.getController();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  @Override
  public void initialize(URL location, ResourceBundle resources) {



    try {
      a = new Alert(Alert.AlertType.INFORMATION);
      preCargaCrearSocio();
      sacarLogin();
      a.setContentText("todo bien");
    } catch (Exception e) {
      System.out.println(e.getMessage());
      a.setContentText("No encuentro el fichero");
    }
    finally{
      a.showAndWait();
    }
  }
}
