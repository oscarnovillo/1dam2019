/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import model.Teacher;
import services.TeacherServices;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author dam2
 */
public class GetTeacherSceneController implements Initializable {

    private PantallaInicioController inicio;

    @FXML
    private DatePicker filtroFecha;

    public DatePicker getFiltroFecha() {
        return filtroFecha;
    }

    @FXML
    private ListView<Teacher> fxListView;

    public void setInicio(PantallaInicioController inicio) {
        this.inicio = inicio;
    }

    public void loadTeachers() {
        fxListView.getItems().clear();
        TeacherServices ts = new TeacherServices();
        List<Teacher> teachers;

        teachers = ts.getAllTeachers();


        if (teachers != null) {
            fxListView.getItems().addAll(teachers);
        } else {
            Alert alert3 = new Alert(Alert.AlertType.ERROR);
            alert3.setTitle("Info");
            alert3.setHeaderText(null);
            alert3.setContentText("Teachers file couldn`t be loaded");

            alert3.showAndWait();
        }

    }

    @FXML
    public void showTeachers() {

        loadTeachers();

    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        loadTeachers();
    }

}
