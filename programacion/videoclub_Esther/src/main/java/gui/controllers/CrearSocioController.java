package gui.controllers;

import com.github.javafaker.Faker;
import dao.modelo.Socio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;
import org.controlsfx.validation.decoration.StyleClassValidationDecoration;
import servicios.ServiciosVideoclub;

import java.net.URL;
import java.util.ResourceBundle;

public class CrearSocioController implements Initializable {

  ValidationSupport validationSupport;
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
  private Alert a;

  public void setTextDni(String texto) {
    this.textDni.setText(texto);
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    a = new Alert(Alert.AlertType.INFORMATION);
    validationSupport = new ValidationSupport();
    validationSupport.setErrorDecorationEnabled(false);
    validationSupport.setValidationDecorator(new StyleClassValidationDecoration("error","warning"));
    validationSupport.registerValidator(textDni, Validator.createEmptyValidator("Tiene q tener texto"));

    validationSupport.registerValidator(textEdad, Validator.combine(
        Validator.createEmptyValidator("Tiene q tener texto"),
        Validator.createPredicateValidator(o -> ((String) o).chars().allMatch(Character::isDigit) || ((String) o).isEmpty(), "solo numeros")));
  }


  private String comprobarSocio() {
    validationSupport.setErrorDecorationEnabled(true);
    if (!validationSupport.getValidationResult().getMessages().isEmpty()) {
      return "error de decoracion";
    }
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
    ServiciosVideoclub sv = new ServiciosVideoclub();
    String creado = "";

    String error = comprobarSocio();
    if (error == null) {
      creado = sv.addSocio(new Socio(textDni.getText(), textNombre.getText(), textDireccion.getText(),
          textTelefono.getText(), Integer.parseInt(textEdad.getText())));
      if (creado.isEmpty()) {
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
    textEdad.setText("" + edad);

  }
}
