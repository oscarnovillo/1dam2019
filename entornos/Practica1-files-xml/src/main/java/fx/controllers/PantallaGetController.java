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
import model.Student;
import services.StudentServices;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author dam2
 */
public class PantallaGetController implements Initializable {

    private PantallaInicioController inicio;

    @FXML
    private DatePicker filtroFecha;

    public DatePicker getFiltroFecha() {
        return filtroFecha;
    }

    @FXML
    private ListView<Student> fxListView;

    public void setInicio(PantallaInicioController inicio) {
        this.inicio = inicio;
    }

    public void loadStudents() {
        fxListView.getItems().clear();
        StudentServices cs = new StudentServices();
        List<Student> students;

        students = cs.getAllStudents();


        if (students != null) {
            fxListView.getItems().addAll(students);
        } else {
            Alert alert3 = new Alert(Alert.AlertType.ERROR);
            alert3.setHeaderText(null);
            alert3.setContentText("Students file couldn`t be loaded");
            alert3.showAndWait();
        }

    }

    @FXML
    public void showStudents() {

        loadStudents();

    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        loadStudents();
    }

}
