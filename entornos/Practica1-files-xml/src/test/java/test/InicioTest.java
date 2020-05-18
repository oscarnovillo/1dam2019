/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import fx.controllers.PantallaInicioController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author oscar
 */
@ExtendWith(ApplicationExtension.class)
@TestMethodOrder(OrderAnnotation.class)
public class InicioTest {

    public InicioTest() {
    }

    private  PantallaInicioController rootController;
    private  BorderPane root;

    @Start
    private void start(Stage primaryStage) throws IOException {

        try {
            if (root == null) {
                FXMLLoader loaderMenu = new FXMLLoader(InicioTest.class.getResource("/fxml/pantallaInicio.fxml"));
                root = loaderMenu.load();
                rootController = loaderMenu.getController();
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
            }
        } catch (Exception ex) {
            Logger.getLogger(InicioTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        primaryStage.show();
    }


    @BeforeEach
    public void setUp() {
        rootController.cargarPantallaLogin();
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    @Order(1)
    public void loginCorrecto(FxRobot robot) {
        //Given
        robot.lookup("#fxUsuario").queryText().setText("root");
        robot.lookup("#fxPass").queryText().setText("root");

        //when
        robot.clickOn("#fxBotonLogin");

        //Then
        assertTrue(robot.lookup("#fxListView") != null);

    }

    @Test
    @Order(0)
    public void loginIncorrecto(FxRobot robot) {
        //Given

        ((TextField) robot.lookup("#fxUsuario").query()).setText("root");
        ((TextField) robot.lookup("#fxPass").query()).setText("rsst");

        //when
        robot.clickOn("#fxBotonLogin");

        //Then
        assertTrue(rootController.getControllerLogin().getAlert().isShowing());
        robot.clickOn("#alertOK");

    }

}

