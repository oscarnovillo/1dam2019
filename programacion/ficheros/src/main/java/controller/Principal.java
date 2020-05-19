package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;

public class Principal implements Initializable {

  @FXML
  private BorderPane root;


  private Explorer explorerController;
  private Animale animalesController;


  public void abrirAnimales(Path pathFichero)
  {
    FXMLLoader loaderMenu = new FXMLLoader(
        getClass().getResource("/fxml/animales.fxml"));
    try {

      root.setCenter(loaderMenu.load());
      animalesController = loaderMenu.getController();
      animalesController.cargarAnimalesDesdeFichero(pathFichero);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    FXMLLoader loaderMenu = new FXMLLoader(
        getClass().getResource("/fxml/explorer.fxml"));
    try {
      root.setCenter(loaderMenu.load());
      explorerController = loaderMenu.getController();
      explorerController.setPrincipal(this);

    } catch (IOException e) {
      e.printStackTrace();
    }


  }
}
