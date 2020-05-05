package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Explorer implements Initializable {

  public Logger logger = Logger.getLogger(this.getClass().getName());

  @FXML
  private ListView<Path> listDirectorios;

  private Path actual ;


  @FXML
  private void cargar(ActionEvent actionEvent) {

    if (Files.isDirectory(listDirectorios.getSelectionModel().getSelectedItem()))
    {
      actual = listDirectorios.getSelectionModel().getSelectedItem();
      cargarFicheros(actual);
    }

  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
      actual= new File(Paths.get(".").toAbsolutePath().toString()).toPath();

    listDirectorios.setCellFactory(list -> new ListCell<Path>() {

      @Override
      protected void updateItem(Path item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null) {
          setText(item.getFileName().toString());
          if (Files.isDirectory(item)) {
            setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/folder.png"))));
            //setStyle("-fx-background-color:grey;");

          } else {
            String nombre = item.getFileName().toString();

            int primerpunto = nombre.indexOf('.');
            int ultmopunto = nombre.lastIndexOf('.');

            String extension = nombre.substring(ultmopunto + 1);
            switch (extension) {
              case "pdf":
                setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/pdf.png"))));
                break;
              default:
                setGraphic(null);

            }

            setStyle("-fx-text-fill:black;");
          }
        } else {
          setText("");
          setGraphic(null);
          setStyle("-fx-text-fill:black;-fx-background-color:white");
        }
      }
    });
    cargarFicheros(actual);
  }

  private void cargarFicheros(Path path)
  {
    try {
      listDirectorios.getItems().clear();
      listDirectorios.getItems().addAll(Files.list(path).collect(Collectors.toList()));
    } catch (IOException e) {
      logger.log(Level.SEVERE,"mensaje",e);
    }
  }

  @FXML
  private void subir(ActionEvent actionEvent) {
    actual = actual.getParent();
    cargarFicheros(actual);
  }
}
