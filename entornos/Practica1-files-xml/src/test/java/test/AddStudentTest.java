package test;


import com.github.javafaker.Faker;
import fx.controllers.PantallaInicioController;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Student;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import services.StudentServices;

import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(ApplicationExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddStudentTest {


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
            Logger.getLogger(AddStudentTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        primaryStage.show();
    }

    @BeforeEach
    public void setUp() {
        Platform.runLater(() -> rootController.loadSceneAddStudents());
    }

    @Test
    @Order(1)
    public void addStudentSinDatos(FxRobot robot) {
        //Given
        ((TextField) robot.lookup("#newNif").query()).setText("");
        ((TextField) robot.lookup("#newName").query()).setText("");
        ((TextField) robot.lookup("#newPhone").query()).setText("");
        ((DatePicker) robot.lookup("#newDoB").query()).setValue(LocalDate.of(2019,01,01));

        //when
        robot.clickOn("#fxBtAdd");
        robot.sleep(100);

        //Then
        assertTrue(rootController.getControllerAdd().getAlert().isShowing());
        assertTrue(rootController.getControllerAdd().getAlert().getAlertType().equals(Alert.AlertType.ERROR));
        assertTrue(rootController.getControllerAdd().getAlert().getContentText().equals("Please fill all data"));
        robot.clickOn("#alertOK");

    }

    @Test
    @Order(2)
    public void addStudentExiste(FxRobot robot) {
        //Given
        StudentServices ss = new StudentServices();
        Student student = ss.getAllStudents().get(0);
        ((TextField) robot.lookup("#newNif").query()).setText(student.getId());
        ((TextField) robot.lookup("#newName").query()).setText(student.getName());
        ((TextField) robot.lookup("#newPhone").query()).setText(student.getPhone());
        ((DatePicker) robot.lookup("#newDoB").query()).setValue(student.getDateOfBirth());

        robot.sleep(100);
        //when
        robot.clickOn("#fxBtAdd");
        robot.sleep(100);

        //Then
        assertTrue(rootController.getControllerAdd().getAlert().isShowing());
        assertTrue(rootController.getControllerAdd().getAlert().getAlertType().equals(Alert.AlertType.ERROR));
        assertTrue(rootController.getControllerAdd().getAlert().getContentText().equals("Student already exists"));
        robot.clickOn("#alertOK");


    }



    @Test
    @Order(0)
    public void addStudent(FxRobot robot) {
        //Given
        Faker f = new Faker();
        ((TextField) robot.lookup("#newNif").query()).setText(f.idNumber().ssnValid());
        ((TextField) robot.lookup("#newName").query()).setText("test");
        ((TextField) robot.lookup("#newPhone").query()).setText("test1");
        ((DatePicker) robot.lookup("#newDoB").query()).setValue(LocalDate.of(2019,01,01));

        //when
        robot.clickOn("#fxBtAdd");

        //Then
        assertTrue(rootController.getControllerAdd().getAlert().isShowing());
        assertTrue(rootController.getControllerAdd().getAlert().getAlertType().equals(Alert.AlertType.INFORMATION));
        assertTrue(rootController.getControllerAdd().getAlert().getContentText().equals("New student saved"));
        robot.clickOn("#alertOK");


    }


}
