package controller;

import dao.modelo.Animal;
import dao.modelo.Gato;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;


import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;


public class Explorer implements Initializable {

  private Logger log4j = LogManager.getLogger("mongo");
  private Logger log4jGeneral = LogManager.getLogger(this.getClass().getName());

  @FXML
  private TextArea textFile;

  Set<Animal> animales = new TreeSet<>();

  @FXML
  private ListView<Path> listDirectorios;

  private Path actual;


  @FXML
  private void cargar(ActionEvent actionEvent) {

    if (!listDirectorios.getSelectionModel().isEmpty()) {
      if (Files.isDirectory(listDirectorios.getSelectionModel().getSelectedItem())) {
        actual = listDirectorios.getSelectionModel().getSelectedItem();
        cargarFicheros(actual);
      }
    }
    else
    {

    }

  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    actual = new File(Paths.get(".").toAbsolutePath().toString()).toPath();

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
              case "txt": case "log":
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

  private void cargarFicheros(Path path) {
    log4j.info("se ha clickado en boton de cargar "+path.getFileName());
    try {
      listDirectorios.getItems().clear();
      listDirectorios.getItems().addAll(Files.list(path).collect(Collectors.toList()));
    } catch (IOException e) {
      log4jGeneral.error(e.getMessage(),e);

    }
  }

  @FXML
  private void subir(ActionEvent actionEvent) {
    Gato g = new Gato();
    actual = actual.getParent();
    cargarFicheros(actual);
  }

  @FXML
  private void cargarTexto(ActionEvent actionEvent) {
    Path file = listDirectorios.getSelectionModel().getSelectedItem();

    try {
      String contenido = Files.readAllLines(file).stream().collect(Collectors.joining("\n"));
      textFile.setText(contenido);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
