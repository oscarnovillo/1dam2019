package gui.controllers;

import com.github.javafaker.Faker;
import dao.modelo.Socio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import servicios.ServiciosVideoclub;

import javax.inject.Inject;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class CrearSocio implements Initializable {

  @FXML
  private TextField textDni;
  @FXML
  private TextField textNombre;
  @FXML
  private TextField textDireccion;
  @FXML
  private TextField textTelefono;
  @FXML
  private TextField textEdad;




  @Inject
  private ServiciosVideoclub sv;

  private Alert a;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    a = new Alert(Alert.AlertType.INFORMATION);
  }


  private String comprobarSocio() {
    if (!textDni.getText().isEmpty() && !textNombre.getText().isEmpty() && !textDireccion.getText().isEmpty()
        && !textTelefono.getText().isEmpty() && !textEdad.getText().isEmpty()) {

      textEdad.getText().chars().allMatch(Character::isDigit);

      try {
        Integer.parseInt(textEdad.getText());
      } catch (Exception e) {
        return "Edad no es un numero";
      }
    } else {
      return "algun campo vacio";
    }
    return null;
  }

  @FXML
  private void crearSocio(ActionEvent actionEvent) {
    //sv = new ServiciosVideoclub();
    boolean creado = false;
    String error = comprobarSocio();
    if (error == null) {
//      ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//      Validator val = factory.getValidator();
//      val.validate(book).stream().forEach(bookConstraintViolation ->
//          System.out.println(bookConstraintViolation.getMessage()));
      creado = sv.addSocio(new Socio(textDni.getText(), textNombre.getText(), textDireccion.getText(),
          textTelefono.getText(), Integer.parseInt(textEdad.getText())));
      if (creado) {
        a.setContentText("socio creado");
      } else {
        a.setContentText("socio ya existia");
      }
    } else {
      a.setContentText(error);
    }
    a.showAndWait();
  }

  @FXML
  private void limpiar(ActionEvent actionEvent) {
    textDni.setText("");
    textNombre.setText("");
    textDireccion.setText("");
    textTelefono.setText("");
    textEdad.setText("");
  }

  public void rellenarConFaker(ActionEvent actionEvent) {
    Faker f = new Faker();
    String dni = f.phoneNumber().extension();
    String nombre = f.gameOfThrones().character();
    String direccion = f.gameOfThrones().city();
    String tel = f.phoneNumber().toString();
    int edad = f.number().numberBetween(1, 99);
    textDni.setText(dni);
    textNombre.setText(nombre);
    textDireccion.setText(direccion);
    textTelefono.setText(tel);
    textEdad.setText(""+edad);

  }
}
