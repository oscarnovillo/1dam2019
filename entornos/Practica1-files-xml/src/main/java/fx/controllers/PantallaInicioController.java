/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FXML Controller class
 *
 * @author dam2
 */
public class PantallaInicioController implements Initializable {

    @FXML
    private BorderPane fxRoot;

    @FXML
    private MenuBar fxMenu;

    private AnchorPane pantallaLogin;
    private LoginController controllerLogin;

    private AnchorPane pantallaAdd;
    private PantallaAddStudentController controllerAdd;

    private AnchorPane pantallaGet;
    private PantallaGetController controllerGet;

    private AnchorPane addTeacherScene;
    private AddTeacherSceneController controllerAddTeacher;

    private AnchorPane getTeacherScene;
    private GetTeacherSceneController controllerGetTeacher;

    private AnchorPane updateTeacherScene;
    private PantallaAddStudentsToProfesorsController controllerUpdateTeacher;


    public AnchorPane getPantallaLogin() {
        return pantallaLogin;
    }

    public LoginController getControllerLogin() {
        return controllerLogin;
    }

    public AnchorPane getPantallaAdd() {
        return pantallaAdd;
    }

    public PantallaAddStudentController getControllerAdd() {
        return controllerAdd;
    }

    public AnchorPane getPantallaGet() {
        return pantallaGet;
    }

    public PantallaGetController getControllerGet() {
        return controllerGet;
    }

    public AnchorPane getAddTeacherScene() {
        return addTeacherScene;
    }

    public AddTeacherSceneController getControllerAddTeacher() {
        return controllerAddTeacher;
    }

    public AnchorPane getGetTeacherScene() {
        return getTeacherScene;
    }

    public GetTeacherSceneController getControllerGetTeacher() {
        return controllerGetTeacher;
    }

    public AnchorPane getUpdateTeacherScene() {
        return updateTeacherScene;
    }

    public PantallaAddStudentsToProfesorsController getControllerUpdateTeacher() {
        return controllerUpdateTeacher;
    }

    @FXML
    public void cargarPantallaLogin() {
        fxRoot.setCenter(pantallaLogin);
    }

    private void preCargaLogin() {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/login.fxml"));
            pantallaLogin = loaderMenu.load();
            controllerLogin
                    = loaderMenu.getController();

            controllerLogin.setInicio(this);
        } catch (IOException ex) {

            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preCargaGet() {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/pantallaGetStudent.fxml"));
            pantallaGet = loaderMenu.load();
            controllerGet
                    = loaderMenu.getController();

            controllerGet.setInicio(this);

        } catch (IOException ex) {

            Logger.getLogger(PantallaGetController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preCargaAdd() {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/pantallaAddStudent.fxml"));
            pantallaAdd = loaderMenu.load();
            controllerAdd
                    = loaderMenu.getController();

            controllerAdd.setInicio(this);

        } catch (IOException ex) {

            Logger.getLogger(PantallaAddStudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preCargaGetTeacher() {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/getTeacherScene.fxml"));
            getTeacherScene = loaderMenu.load();
            controllerGetTeacher
                    = loaderMenu.getController();

            controllerGetTeacher.setInicio(this);

        } catch (IOException ex) {

            Logger.getLogger(GetTeacherSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void preCargaAddTeacher() {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/addTeacherScene.fxml"));
            addTeacherScene = loaderMenu.load();
            controllerAddTeacher
                    = loaderMenu.getController();

            controllerAddTeacher.setInicio(this);

        } catch (IOException ex) {

            Logger.getLogger(AddTeacherSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preCargaUpdateTeacher() {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/addStudentsToTeachers.fxml"));
            updateTeacherScene = loaderMenu.load();
            controllerUpdateTeacher
                    = loaderMenu.getController();

            controllerUpdateTeacher.setInicio(this);

        } catch (IOException ex) {

            Logger.getLogger(AddTeacherSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    public void loadSceneGetStudents() {
        fxMenu.setVisible(true);
        fxRoot.setCenter(pantallaGet);
        controllerGet.loadStudents();

    }

    @FXML
    public void loadSceneAddStudents() {
        fxRoot.setCenter(pantallaAdd);
    }

    @FXML
    public void loadSceneGetTeachers() {
        fxRoot.setCenter(getTeacherScene);
        controllerGetTeacher.loadTeachers();
    }

    @FXML
    public void loadSceneUpdateTeachers() {
        fxRoot.setCenter(updateTeacherScene);
        controllerUpdateTeacher.loadTeachers();
    }


    public void loadSceneAddTeachers() {
        fxRoot.setCenter(addTeacherScene);

    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        preCargaLogin();
        preCargaGet();
        preCargaAdd();
        preCargaUpdateTeacher();
        preCargaAddTeacher();
        preCargaGetTeacher();
        fxMenu.setVisible(false);
        cargarPantallaLogin();
    }

}
