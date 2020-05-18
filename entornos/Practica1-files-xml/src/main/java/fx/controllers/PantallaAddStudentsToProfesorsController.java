package fx.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Student;
import model.Teacher;
import services.StudentServices;
import services.TeacherServices;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author oscar
 */
public class PantallaAddStudentsToProfesorsController implements Initializable {

    private PantallaInicioController inicio;
    @FXML
    private ComboBox<Teacher> fxTeachers;
    @FXML
    private ListView<Student> fxAllStudents;
    @FXML
    private ListView<Student> fxStudentsAssigned;
    @FXML
    private Button fxBtAssingStudent;
    @FXML
    private Button fxBtUnAssingStudent;

    private Alert alert;

    public Alert getAlert() {
        return alert;
    }

    public void setInicio(PantallaInicioController inicio) {
        this.inicio = inicio;
    }

    public void loadTeachers() {
        fxTeachers.getItems().clear();
        TeacherServices ts = new TeacherServices();
        List<Teacher> teachersList;

        teachersList = ts.getAllTeachers();

        if (teachersList != null) {
            fxTeachers.getItems().addAll(teachersList);
        } else {
            Alert alert3 = new Alert(Alert.AlertType.ERROR);
            alert3.setTitle("Info");
            alert3.setHeaderText(null);
            alert3.setContentText("Teachers file couldn`t be loaded");

            alert3.showAndWait();
        }

    }

    public void loadStudents() {
        fxAllStudents.getItems().clear();
        StudentServices ts = new StudentServices();
        List<Student> students;

        students = ts.getAllStudents();

        if (null != students) {
            fxAllStudents.getItems().addAll(students);
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.getDialogPane().lookupButton(ButtonType.OK).setId("alertOK");
            alert.setTitle("Info");
            alert.setHeaderText(null);
            alert.setContentText("Students file couldn`t be loaded");

            alert.showAndWait();
        }

    }

    public void allStudentSelected() {
        if (fxTeachers.getSelectionModel().getSelectedItem() != null)
            fxBtAssingStudent.setDisable(false);
    }

    public void studentSelected() {
        fxBtUnAssingStudent.setDisable(false);
    }

    public void assignedStudent() {
        Teacher t = fxTeachers.getSelectionModel().getSelectedItem();
        Student s = fxAllStudents.getSelectionModel().getSelectedItem();

        if (!t.getStudents().contains(s)) {
            fxStudentsAssigned.getItems().add(s);
            t.addStudent(s);
            TeacherServices ts = new TeacherServices();
            ts.updateTeacher(t);
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.getDialogPane().lookupButton(ButtonType.OK).setId("alertOK");
            alert.setHeaderText(null);
            alert.setContentText("Student already added");
            alert.showAndWait();
        }
    }

    public void unAssignedStudent() {
        Teacher t = fxTeachers.getSelectionModel().getSelectedItem();
        Student s = fxStudentsAssigned.getSelectionModel().getSelectedItem();
        fxStudentsAssigned.getItems().remove(s);
        t.getStudents().remove(s);
        if (t.getStudents().size() == 0) {
            fxBtUnAssingStudent.setDisable(false);
        }
        TeacherServices ts = new TeacherServices();
        ts.updateTeacher(t);
    }

    public void selectTeacher() {
        fxStudentsAssigned.getItems().clear();
        Teacher t = fxTeachers.getSelectionModel().getSelectedItem();
        if (t != null) {
            if (fxAllStudents.getSelectionModel().getSelectedItems() != null) {
                fxBtAssingStudent.setDisable(false);
            }
            if (t.getStudents() != null && t.getStudents().size() > 0) {
                fxStudentsAssigned.getItems().addAll(t.getStudents());
            } else {
                fxBtUnAssingStudent.setDisable(true);
            }
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fxBtAssingStudent.setDisable(true);
        fxBtUnAssingStudent.setDisable(true);
        loadTeachers();
        loadStudents();
    }

}
