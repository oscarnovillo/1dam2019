package gui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Chart implements Initializable {

  @FXML
  private Button button;
  @FXML
  private Button clear;
  @FXML
  private LineChart chartEnfermos;


  XYChart.Series series = new XYChart.Series();
  private int i =5;

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    series.setName("No of schools in an year");


    series.getData().add(new XYChart.Data(1, 100));
    series.getData().add(new XYChart.Data(2, 10));
    series.getData().add(new XYChart.Data(3, -190));
    series.getData().add(new XYChart.Data(4, -1));
//    for (int i=0; i<10000; i++) {
//      series.getData().add(new XYChart.Data(i, 2+i)));
//    }

    chartEnfermos.getData().add(series);

    series.getNode().setStyle("-fx-stroke-width: 1px;");

    button.setStyle("-fx-background-color: #3fffe7");
    clear.setStyle("-fx-background-color: #25ff76");
  }

  public void crearPunto(ActionEvent actionEvent) {

//    series.setName("set 2");
//
//
//    for (int i=0; i<100; i++) {
//      series.getData().add(new XYChart.Data(i, Math.sin(i)));
//    }
//    chartEnfermos.getData().add(series);
//
//    series.getNode().setStyle("-fx-stroke-width: 1px;");
  }

  public void clear(ActionEvent actionEvent) {

    series.getData().add(new XYChart.Data(i,10+i));
    i++;

    //chartEnfermos.getData().clear();
  }
}
