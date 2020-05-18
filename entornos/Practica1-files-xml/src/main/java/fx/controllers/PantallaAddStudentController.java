/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import services.StudentServices;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author dam2
 */
public class PantallaAddStudentController implements Initializable {

    private PantallaInicioController inicio;

    private Alert alert;

    public Alert getAlert() {
        return alert;
    }

    @FXML
    private TextField newNif;

    @FXML
    private TextField newName;

    @FXML
    private TextField newPhone;

    @FXML
    private DatePicker newDoB;

    public void setInicio(PantallaInicioController inicio) {
        this.inicio = inicio;
    }

    public void cleanValues() {
        newNif.clear();
        newName.clear();
        newPhone.clear();
        newDoB.setValue(null);

    }

    public boolean checkEmptyFields() {
        return newNif.getText().isEmpty() || newName.getText().isEmpty()
                || newPhone.getText().isEmpty() || newDoB.getValue() == null;
    }

    @FXML
    public void addStudent() {

        StudentServices ss = new StudentServices();

        if (checkEmptyFields()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.getDialogPane().lookupButton(ButtonType.OK).setId("alertOK");
            alert.setContentText("Please fill all data");
            alert.showAndWait();

        } else {

            if (ss.addStudent(newNif.getText(), newName.getText(), newPhone.getText(), newDoB.getValue())) {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.getDialogPane().lookupButton(ButtonType.OK).setId("alertOK");
                alert.setContentText("New student saved");

                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.getDialogPane().lookupButton(ButtonType.OK).setId("alertOK");
                alert.setContentText("Student already exists");
                alert.showAndWait();
            }
        }
        cleanValues();
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        alert = new Alert(Alert.AlertType.ERROR);
        alert.getDialogPane().lookupButton(ButtonType.OK).setId("alertOK");
    }

}
