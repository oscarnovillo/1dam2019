package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFXChart extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws IOException {
    FXMLLoader loaderMenu = new FXMLLoader(
        getClass().getResource("/fxml/chart.fxml"));
    AnchorPane root = loaderMenu.load();
    Scene scene = new Scene(root);
    primaryStage.setTitle("HOLA SOY YO");
    primaryStage.setScene(scene);
    primaryStage.show();
    primaryStage.setResizable(false);
  }
}
