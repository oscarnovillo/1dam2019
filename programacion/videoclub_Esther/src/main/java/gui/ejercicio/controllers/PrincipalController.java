package gui.ejercicio.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrincipalController implements Initializable {

  @FXML
  private Menu menuUsuario;
  @FXML
  private MenuItem menuLogout;
  @FXML
  private MenuItem menuComunAdmin;
  @FXML
  private MenuItem menuComunUsuario;
  @FXML
  private Menu menuAdmin;
  @FXML
  private MenuBar menuPrincipal;
  @FXML
  private BorderPane pantallaPrincipal;


  private String usuario;
  private String tipo;

  private Alert a;

  private AnchorPane pantallaBienvenida;
  private BienvenidaController bienvenidaController;

  private AnchorPane pantallaVerDatosUsuario;
  private VerDatosAdminController verDatosAdminController;

  private AnchorPane pantallaVerDatosAdmin;
  private VerDatosUsuarioController verDatosUsuarioController;

  private AnchorPane pantallaLogin;
  private LoginController loginController;


  public void configMenu(String usuario,String tipo){
    this.usuario = usuario;
    this.tipo = tipo;
    menuPrincipal.setVisible(true);
    menuAdmin.setVisible(false);
    menuUsuario.setVisible(false);
    menuComunAdmin.setVisible(false);
    menuComunUsuario.setVisible(false);

    switch (tipo) {
      case "admin":
        menuAdmin.setVisible(true);
        menuComunAdmin.setVisible(true);

        break;
      case "usuario":
        menuUsuario.setVisible(true);
        menuComunUsuario.setVisible(true);
        break;
    }

    ponerPantallaBienvenida();

  }

  public void ponerPantallaBienvenida()
  {
    bienvenidaController.cambiarLabel("Bienvenido "+usuario);
    pantallaPrincipal.setCenter(pantallaBienvenida);

  }

  private void preCargaVerDatosUsuario()
  {
    try {
      FXMLLoader loaderMenu = new FXMLLoader(
          getClass().getResource("/fxml/ejercicio/verDatosUsuario.fxml"));
      pantallaVerDatosUsuario = loaderMenu.load();
      verDatosUsuarioController = loaderMenu.getController();
      verDatosUsuarioController.setPrincipalController(this);

    } catch (Exception e) {
      Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE,"no se pudo cargar pantalla ver Datos Usuario",e);
    }
  }

  private void preCargaVerDatosAdmin()
  {
    try {
      FXMLLoader loaderMenu = new FXMLLoader(
          getClass().getResource("/fxml/ejercicio/verDatosAdmin.fxml"));
      pantallaVerDatosAdmin = loaderMenu.load();
      verDatosAdminController = loaderMenu.getController();
      verDatosAdminController.setPrincipalController(this);
    } catch (Exception e) {
      Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE,"no se pudo cargar pantalla ver Datos Admin",e);
    }
  }

  private void preCargaBienvenida()
  {
    try {
      FXMLLoader loaderMenu = new FXMLLoader(
          getClass().getResource("/fxml/ejercicio/bienvenida.fxml"));
      pantallaBienvenida = loaderMenu.load();
      bienvenidaController = loaderMenu.getController();
    } catch (Exception e) {
      Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE,"no se pudo cargar pantalla bienvenida",e);
    }
  }


  private void preCargaLogin()
  {
    try {
      FXMLLoader loaderMenu = new FXMLLoader(
          getClass().getResource("/fxml/ejercicio/login.fxml"));
      pantallaLogin = loaderMenu.load();
      loginController = loaderMenu.getController();
      loginController.setPrincipalController(this);
    } catch (Exception e) {
      Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE,"no se pudo cargar pantalla login",e);
    }
  }


  @Override
  public void initialize(URL location, ResourceBundle resources) {
      a = new Alert(Alert.AlertType.INFORMATION);
      preCargaLogin();
      preCargaBienvenida();
      pantallaPrincipal.setCenter(pantallaLogin);
  }




  @FXML
  private void menuVerDatosAdmin(ActionEvent actionEvent) {
    if (pantallaVerDatosAdmin == null)
    {
      preCargaVerDatosAdmin();
    }
    verDatosAdminController.setDatos(usuario,tipo);
    pantallaPrincipal.setCenter(pantallaVerDatosAdmin);


  }

  @FXML
  private void menuLogout(ActionEvent actionEvent) {
    menuPrincipal.setVisible(false);
    loginController.reset();
    pantallaPrincipal.setCenter(pantallaLogin);
  }

  @FXML
  private void menuVerDatosUsuario(ActionEvent actionEvent) {
    if (pantallaVerDatosUsuario == null)
    {
      preCargaVerDatosUsuario();
    }
    verDatosUsuarioController.setDatos(usuario,tipo);
    pantallaPrincipal.setCenter(pantallaVerDatosUsuario);


  }
}
