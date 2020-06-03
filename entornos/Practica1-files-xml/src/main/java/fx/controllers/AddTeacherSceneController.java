package fx.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import services.TeacherServices;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author Lucia
 */
public class AddTeacherSceneController implements Initializable {

    private PantallaInicioController inicio;

    @FXML
    private TextField newNif;

    @FXML
    private TextField newName;

    private Alert alertError;
    private Alert alertInformacion;

    public Alert getAlertError() {
        return alertError;
    }

    public Alert getAlertInformacion() {
        return alertInformacion;
    }

    public void setInicio(PantallaInicioController inicio) {
        this.inicio = inicio;
    }

    public void cleanValues() {
        newNif.clear();
        newName.clear();
    }

    public boolean checkEmptyFields() {
        return newNif.getText().isEmpty() ||  newName.getText().isEmpty();
    }

    @FXML
    public void addTeacher() {

        TeacherServices ts = new TeacherServices();

        if (checkEmptyFields()) {
            alertError.setContentText("Please fill all data");
            alertError.getDialogPane().lookupButton(ButtonType.OK).setId("alertOK");
            alertError.showAndWait();
        } else {
            if (ts.addTeacher(newNif.getText(), newName.getText())) {
                alertInformacion.setContentText("New teacher saved");
                alertInformacion.getDialogPane().lookupButton(ButtonType.OK).setId("alertOK");
                alertInformacion.showAndWait();
            } else {
                alertError.setContentText("Teacher already exists");

                alertError.getDialogPane().lookupButton(ButtonType.OK).setId("alertOK");
                alertError.showAndWait();
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
        alertError = new Alert(Alert.AlertType.ERROR);
        alertInformacion = new Alert(Alert.AlertType.INFORMATION);
        alertInformacion.setTitle("Confirmación");
        alertInformacion.setHeaderText(null);
    }

    public void hazAlgo(ActionEvent actionEvent) {

        newNif.setText("despues de seleccionar");
    }
}
