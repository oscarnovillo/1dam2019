package test;


import com.github.javafaker.Faker;
import fx.controllers.PantallaInicioController;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Teacher;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import services.TeacherServices;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(ApplicationExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddTeacherTest {


    private static PantallaInicioController rootController;
    private static BorderPane root;

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
            Logger.getLogger(AddTeacherTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        primaryStage.show();
    }

    @BeforeEach
    public void setUp() {
        Platform.runLater(() -> rootController.loadSceneAddTeachers());
    }

    @Test
    @Order(1)
    public void addTeacherSinDatos(FxRobot robot) {
        //Given
        ((TextField) robot.lookup("#newNif").query()).setText("");
        ((TextField) robot.lookup("#newName").query()).setText("");

        //when
        robot.clickOn("#fxBtAdd");
        robot.sleep(100);

        //Then
        assertTrue(rootController.getControllerAddTeacher().getAlertError().isShowing());
        assertTrue(rootController.getControllerAddTeacher().getAlertError().getAlertType().equals(Alert.AlertType.ERROR));
        assertTrue(rootController.getControllerAddTeacher().getAlertError().getContentText().equals("Please fill all data"));
        robot.clickOn("#alertOK");

    }
    @Test
    @Order(2)
    public void addTeacherExiste(FxRobot robot) {
        //Given
        TeacherServices ss = new TeacherServices();
        Teacher teacher = ss.getAllTeachers().get(0);
        ((TextField) robot.lookup("#newNif").query()).setText(teacher.getNif());
        ((TextField) robot.lookup("#newName").query()).setText(teacher.getName());

        //when
        robot.clickOn("#fxBtAdd");
        robot.sleep(100);

        //Then
        assertTrue(rootController.getControllerAddTeacher().getAlertError().isShowing());
        assertTrue(rootController.getControllerAddTeacher().getAlertError().getAlertType().equals(Alert.AlertType.ERROR));
        assertTrue(rootController.getControllerAddTeacher().getAlertError().getContentText().equals("Teacher already exists"));
        robot.clickOn("#alertOK");


    }


    @Test
    @Order(0)
    public void addTeacher(FxRobot robot) {
        //Given
        Faker f = new Faker();
        ((TextField) robot.lookup("#newNif").query()).setText(f.idNumber().ssnValid());
        ((TextField) robot.lookup("#newName").query()).setText("test");

        //when
        robot.clickOn("#fxBtAdd");
        robot.sleep(100);
        //Then
        assertTrue(rootController.getControllerAddTeacher().getAlertInformacion().isShowing());
        assertTrue(rootController.getControllerAddTeacher().getAlertInformacion().getAlertType().equals(Alert.AlertType.INFORMATION));
        assertTrue(rootController.getControllerAddTeacher().getAlertInformacion().getContentText().equals("New teacher saved"));
        robot.clickOn("#alertOK");
    }


}
