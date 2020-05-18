package test;


import config.ConfigurationProperties;
import dao.TeacherDAO;
import fx.controllers.PantallaInicioController;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Student;
import model.Teacher;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.testfx.assertions.api.Assertions.assertThat;


@ExtendWith(ApplicationExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddStudentsTeachersTest{
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
      Logger.getLogger(AddStudentsTeachersTest.class.getName()).log(Level.SEVERE, null, ex);
    }

    primaryStage.show();
  }

  @BeforeEach
  public void setUp() {
    Platform.runLater(() -> rootController.loadSceneUpdateTeachers());
  }


  @Test
  @Order(1)
  public void getStudentsTeachers(FxRobot robot) {
    //Given
    robot.sleep(100);
    ComboBox<Teacher> lista = robot.lookup("#fxTeachers").queryComboBox();
    ListView<Teacher> listaStudents = robot.lookup("#fxStudentsAssigned").queryListView();

    Teacher teacher = lista.getItems()
        .stream().filter(t -> t.getStudents().size() > 0)
        .findFirst().orElse(lista.getItems().get(0));

    //when
    robot.interact(() -> lista.getSelectionModel().select(teacher));


    //Then
    assertThat(listaStudents).hasExactlyNumItems(teacher.getStudents().size());
  }

  @Test
  @Order(2)
  public void addExistentStudentToTeacher(FxRobot robot) {
    //Given
    robot.sleep(100);
    ComboBox<Teacher> lista = robot.lookup("#fxTeachers").queryComboBox();
    final Teacher teacher = 
            lista.getItems().stream().filter(teacher1 -> teacher1.getStudents().size() > 1).findFirst().get();
    ListView<Student> listaStudents = 
            robot.lookup("#fxAllStudents").queryListView();

    Student s = 
            listaStudents.getItems().stream()
                    .filter(student -> teacher.getStudents().contains(student))
                    .findFirst().get();

    //when

    Platform.runLater(() -> lista.getSelectionModel().select(teacher));
    listaStudents.getSelectionModel().select(s);
    robot.clickOn("#fxBtAssingStudent");

    //Then
    assertTrue(rootController.getControllerUpdateTeacher().getAlert().isShowing());
    assertTrue(rootController.getControllerUpdateTeacher().getAlert().getAlertType().equals(Alert.AlertType.ERROR));
    assertTrue(rootController.getControllerUpdateTeacher().getAlert().getContentText().equals("Student already added"));


    robot.clickOn("#alertOK");


  }

  @Test
  @Order(3)
  public void addStudentToTeacher(FxRobot robot) {
    //Given
    robot.sleep(100);
    ComboBox<Teacher> lista = robot.lookup("#fxTeachers").queryComboBox();
    ListView<Student> listaStudents = robot.lookup("#fxAllStudents").queryListView();
    final Teacher teacher = lista.getItems().get(0);
    Student s = listaStudents.getItems().stream()
            .filter(student -> !teacher.getStudents().contains(student)).findFirst().get();


    //when
    robot.interact(() -> {
      lista.getSelectionModel().select(teacher);}
    );
    //Platform.runLater(() -> );

    listaStudents.getSelectionModel().select(s);
    robot.clickOn("#fxBtAssingStudent");

    //Then

    assertTrue(teacher.getStudents().contains(listaStudents.getSelectionModel().getSelectedItem()));
  }


    @Test
    @Order(3)
    public void delStudentFromTeacher(FxRobot robot) {
        //Given
        robot.sleep(100);
        ComboBox<Teacher> lista = robot.lookup("#fxTeachers").queryComboBox();
        ListView<Student> listaStudents = robot.lookup("#fxStudentsAssigned").queryListView();
        final Teacher teacher = lista.getItems().stream().filter(teacher1 -> teacher1.getStudents().size() > 1).findFirst().get();

        //when
        Platform.runLater(() -> lista.getSelectionModel().select(teacher));
        robot.sleep(100);
        robot.clickOn((ListCell) robot.from(listaStudents).lookup(".list-cell").nth(0).query());

        robot.clickOn("#fxBtUnAssingStudent");

        //Then
        assertTrue(teacher.getStudents().size() == listaStudents.getItems().size() +1);
        assertEquals(teacher.getStudents().size(),listaStudents.getItems().size() +1);
        assertThat(teacher.getStudents()).hasSize(listaStudents.getItems().size() +1);
    }


    @Test
  @Order(0)
  public void getTeachers(FxRobot robot) {
    //Given
    robot.sleep(100);
    ComboBox<Teacher> listaTeachers = robot.lookup("#fxTeachers").queryComboBox();
    ListView<Teacher> listaStudents = robot.lookup("#fxAllStudents").queryListView();

    //when
    List<Teacher> t = new TeacherDAO().getAllTeachers();

    //Then
    Assertions.assertEquals(listaTeachers.getItems().size(),
        t.size());
    try {
      assertEquals(listaStudents.getItems().size(),
          Files.readAllLines(Paths.get(ConfigurationProperties.
              getInstance().getStudentFile())).size());
    } catch (Exception ex) {
      Logger.getLogger(AddStudentsTeachersTest.class.getName()).log(Level.SEVERE, null, ex);
    }
    assertAll("botones",
        () -> assertThat(robot.lookup("#fxBtAssingStudent").queryButton()).isDisabled(),
        () -> assertThat(robot.lookup("#fxBtUnAssingStudent").queryButton()).isDisabled());

  }

}
