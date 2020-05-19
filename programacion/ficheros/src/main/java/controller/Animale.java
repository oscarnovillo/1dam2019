package controller;

import dao.modelo.Animal;
import dao.modelo.Armario;
import dao.modelo.Ropa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Animale implements Initializable {


  private Logger log4j = LogManager.getLogger("botones");
  private Logger log4jPantallas = LogManager.getLogger("pantallas");

  @FXML
  private TextField textNuevoFichero;
  @FXML
  private TextField textNombre;
  @FXML
  private TextField textNumeroPatas;
  @FXML
  private DatePicker fecha;
  @FXML
  private ListView<Animal> listAnimales;

  private Set<Animal> animales = new TreeSet<>();

  private ListView<Ropa> ropa;


  private List<Ropa> ropas = new ArrayList<>();
  private List<Armario> armario = new ArrayList<>();

  public void cargarRopa()
  {
    ropas = new ArrayList<>();

    ropa.getItems().addAll(armario.get(0).getPrendas());
  }


  private Path pathFichero;


  public Path getPathFichero() {
    return pathFichero;
  }


  @Override
  public void initialize(URL location, ResourceBundle resources) {


  }


  public void cargarAnimalesDesdeFichero(Path fichero)
  {
    this.pathFichero = fichero;
    try {
      log4jPantallas.info("se ha cargado el fichero "+fichero.getFileName());
      Files.readAllLines(this.pathFichero).stream().forEach(s -> {
        Animal animal = new Animal();
        animal.cargar(s);
        animales.add(animal);
      });
    } catch (IOException e) {
      e.printStackTrace();
    }

    cargarAnimales();

  }


  private void cargarAnimales()
  {
    listAnimales.getItems().clear();
    listAnimales.getItems().addAll(animales);
  }

  @FXML
  private void guardarFichero(ActionEvent actionEvent) {
    try  (BufferedWriter bw =
              Files.newBufferedWriter(this.pathFichero))
    {

      PrintWriter pw = new PrintWriter(bw);
      animales.forEach(animal -> pw.println(animal.guardar()));
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  @FXML
  private void addAnimal(ActionEvent actionEvent) {
    log4j.info("pulsado boton add animal");
    Animal a = new Animal(textNombre.getText(),
        Integer.parseInt(textNumeroPatas.getText()),
        fecha.getValue());

    animales.add(a);
    cargarAnimales();

  }

  @FXML
  private void guardarNuevoFichero(ActionEvent actionEvent) {

    String ruta = this.pathFichero.getParent().toAbsolutePath()+"\\"+textNuevoFichero.getText();
    try  (BufferedWriter bw =
              Files.newBufferedWriter(Paths.get(ruta)))
    {
      PrintWriter pw = new PrintWriter(bw);
      animales.forEach(animal -> pw.println(animal.guardar()));
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }


  public void editAnimal(ActionEvent actionEvent) {
    Animal a = listAnimales.getSelectionModel().getSelectedItem();
    animales.remove(a);

    a.setNombre(textNombre.getText());
    a.setNumeroPatas(Integer.parseInt(textNumeroPatas.getText()));
    animales.add(a);
    cargarAnimales();
  }

  public void cargarAnimal(ActionEvent actionEvent) {
    Animal a = listAnimales.getSelectionModel().getSelectedItem();
    textNombre.setText(a.getNombre());
    textNumeroPatas.setText(a.getNumeroPatas()+"");

  }
}
