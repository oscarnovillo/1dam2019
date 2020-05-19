package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;


import java.util.stream.Collectors;


public class Explorer implements Initializable {

  private Logger log4jbotones = LogManager.getLogger("botones");
  private Logger log4jPantallas = LogManager.getLogger("pantallas");
  private Logger log4jGeneral = LogManager.getLogger(this.getClass().getName());
  private Principal principal;

  FileChooser f = new FileChooser();

  public Principal getPrincipal() {
    return principal;
  }

  public void setPrincipal(Principal principal) {
    this.principal = principal;
  }

  @FXML
  private TextArea textFile;



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
    log4jPantallas.info("entrando en pantalla explorer");

    listDirectorios.setCellFactory(list -> new ListCell<Path>() {

      @Override
      protected void updateItem(Path item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null) {
          setText(item.getFileName().toString());
          if (Files.isDirectory(item)) {
            setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/folder.png"))));
            setStyle("-fx-background-color:grey;");

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
    log4jbotones.info("se ha clickado en boton de cargar "+path.getFileName());
    try {
      listDirectorios.getItems().clear();
      listDirectorios.getItems().addAll(Files.list(path).collect(Collectors.toList()));
    } catch (IOException e) {
      log4jGeneral.error(e.getMessage(),e);
    }
  }

  @FXML
  private void subir(ActionEvent actionEvent) {

    actual = actual.getParent();
    cargarFicheros(actual);
  }

  @FXML
  private void cargarTexto(ActionEvent actionEvent) {

    Path file = listDirectorios.getSelectionModel().getSelectedItem();
    String nombre = file.getFileName().toString();
    int ultmopunto = nombre.lastIndexOf('.');
    String extension = nombre.substring(ultmopunto + 1);

    if (extension.equals("obj") &&  !Files.isDirectory(file))
      principal.abrirAnimales(file);
    else if (extension.equals("txt"))
    {
      try {
        String contenido = Files.readAllLines(file).stream()
            .collect(Collectors.joining("\n"));

        textFile.setText(contenido);

      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    else
    {
      Alert a = new Alert(Alert.AlertType.ERROR);
      a.setContentText("error de fichero");
      a.showAndWait();

    }
  }

  @FXML
  private void guardarTexto(ActionEvent actionEvent) {
    Path file = listDirectorios.getSelectionModel().getSelectedItem();
    try (BufferedWriter bw1 =
             Files.newBufferedWriter(file)) {
      bw1.write(textFile.getText());
    }
    catch(IOException e)
    {
      System.out.println("jojoj");
    }

  }
}
