/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import controllers.Principal;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
@DisplayName("probando testing")
public class InicioTest {

    public InicioTest() {
    }

    private Principal rootController;
    private BorderPane root;

    @Start
    private void start(Stage primaryStage) throws IOException {

        try {
            if (root == null) {
                FXMLLoader loaderMenu = new FXMLLoader(InicioTest.class.getResource("/fxml/principal.fxml"));
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



    @Test
    @DisplayName("porbando por primera vez")
    public void loginCorrecto(FxRobot robot) {

        robot.clickOn("#boton");
        //Then
        assertTrue(rootController.getAlert().isShowing());
        assertTrue(rootController.getAlert().getAlertType().equals(Alert.AlertType.INFORMATION));
        assertEquals("hola pepe desarrollo 7",rootController.getAlert().getContentText());
        robot.clickOn("#alertOK");

    }


}

