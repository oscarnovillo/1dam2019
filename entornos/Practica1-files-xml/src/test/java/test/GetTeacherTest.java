package test;


import dao.TeacherDAO;
import fx.controllers.PantallaInicioController;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Teacher;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(ApplicationExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GetTeacherTest {

    private PantallaInicioController rootController;
    private BorderPane root;

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
        } catch (IOException e) {
            e.printStackTrace();
        }

        primaryStage.show();
    }

    @BeforeEach
    public void setUp() {
        Platform.runLater(() -> rootController.loadSceneGetTeachers());
    }

    @Test
    @Order(0)
    public void getTeachers(FxRobot robot) {
        //Given
        robot.sleep(100);
        ListView<Teacher> lista;
        lista = robot.lookup("#fxListView").queryListView();
        //when

        List<Teacher> t = new TeacherDAO().getAllTeachers();

        //Then
        assertThat(lista.getItems()).hasSameElementsAs(t);
//        Assertions.assertEquals(lista.getItems().size(),
//                t.size());

    }


}
