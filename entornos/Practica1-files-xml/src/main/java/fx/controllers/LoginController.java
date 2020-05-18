/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import services.UserServices;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author dam2
 */
public class LoginController implements Initializable {

    private PantallaInicioController inicio;

    public void setInicio(PantallaInicioController inicio) {
        this.inicio = inicio;
    }

    private Alert alert;

    public Alert getAlert() {
        return alert;
    }

    @FXML
    private TextField fxUsuario;

    @FXML
    private PasswordField fxPass;

    @FXML
    public void clickLogin() throws InterruptedException {

        UserServices us = new UserServices();
        if (us.checkUser(fxUsuario.getText(), fxPass.getText())) {
            inicio.loadSceneGetStudents();
        } else {
            fxUsuario.clear();
            fxPass.clear();


            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Wrong user and/or password");
            Thread.sleep(1000);
            alert.showAndWait();

        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        alert = new Alert(Alert.AlertType.ERROR);
        alert.getDialogPane().lookupButton(ButtonType.OK).setId("alertOK");
    }

}
