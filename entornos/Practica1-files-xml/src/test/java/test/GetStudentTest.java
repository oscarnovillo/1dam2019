package test;

import config.ConfigurationProperties;
import fx.controllers.PantallaInicioController;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ApplicationExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GetStudentTest {

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
        }catch (Exception ex) {
            Logger.getLogger(GetStudentTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        primaryStage.show();
    }

    @BeforeEach
    public void setUp() {
        Platform.runLater(() -> rootController.loadSceneGetStudents());

//        rootController.loadSceneGetStudents();
    }


    @Test
    @Order(0)
    @DisplayName("")
    public void cargaListViewStudents(FxRobot robot) {
        //Given
       // robot.sleep(100);
        try {
            assertEquals(robot.lookup("#fxListView").queryListView().getItems().size(),
                    Files.readAllLines(Paths.get(ConfigurationProperties.
                            getInstance().getStudentFile())).size());
        } catch (Exception ex) {
            Logger.getLogger(GetStudentTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    @Order(1)
    public void pruebaListViewStudents(FxRobot robot) {
        //Given
        robot.interact(() ->  rootController.loadSceneGetStudents());

        robot.sleep(100);
        robot.interact(() -> {
            robot.lookup("#fxListView").queryListView().scrollTo(20);
            robot.sleep(1000);
            robot.lookup("#fxListView").queryListView().getSelectionModel().select(20);
            robot.sleep(1000);
        });
        robot.sleep(1000);
    }

    @Test
    @Order(1)
    public void pruebaFicheroDownStudents(FxRobot robot) {
        //Given
        ConfigurationProperties.getInstance().setStudentFile("kjashdakjsd");
        robot.interact(() ->  rootController.loadSceneGetStudents());

        robot.sleep(100);
        robot.interact(() -> {
            robot.lookup("#fxListView").queryListView().scrollTo(20);
            robot.sleep(1000);
            robot.lookup("#fxListView").queryListView().getSelectionModel().select(20);
            robot.sleep(1000);
        });
        robot.sleep(1000);
    }

}
