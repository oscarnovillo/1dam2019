package gui;

import gui.conf.StartupScene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.io.IOException;

public class MainMultiPantallaFX {

//  public static void main(String[] args) {
//    launch(args);
//  }
//
//  private Weld weld ;
//  private WeldContainer container ;
//
//  @Override
//  public void init() {
//    weld = new Weld();
//    container = weld.initialize();
//  }
//
//  @Override
//  public void stop() {
//    weld.shutdown();
//  }

//  @Override
//  public void start(Stage primaryStage) throws IOException {
//    FXMLLoader loaderMenu = new FXMLLoader(
//        getClass().getResource("/fxml/principal.fxml"));
//    BorderPane root = loaderMenu.load();
//    Principal p = loaderMenu.getController();
//    p.start();
//
//    Scene scene = new Scene(root);
//    primaryStage.setTitle("HOLA SOY YO");
//    primaryStage.setScene(scene);
//    primaryStage.show();
//    primaryStage.setResizable(false);
//  }

  @Inject
  FXMLLoader fxmlLoader;

  public void start(@Observes @StartupScene Stage stage) {
    try {
      //fxmlLoader = new FXMLLoader();
      //URL arquivoFXML = getClass().getResource("./hello-world.fxml");
//			SeContainerInitializer initializer = SeContainerInitializer.newInstance();
//			final SeContainer container = initializer.initialize();
//			FXMLLoader loaderMenu = new FXMLLoader(
//					getClass().getResource("/hello-world.fxml"));
//			loaderMenu.setController(container.select(FXController.class).get());
      Parent fxmlParent = fxmlLoader.load(getClass().getResourceAsStream("/fxml/principal.fxml"));
      stage.setScene(new Scene(fxmlParent, 300, 100));
      stage.setTitle("Hello World FXML and JavaFX");
      stage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
