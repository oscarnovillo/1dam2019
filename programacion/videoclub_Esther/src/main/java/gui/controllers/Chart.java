package gui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class Chart implements Initializable {
  public LineChart chartEnfermos;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    XYChart.Series series = new XYChart.Series();
    series.setName("No of schools in an year");

    for (int i=0; i<100; i++) {
      series.getData().add(new XYChart.Data(i, Math.cos(i)));
    }

    chartEnfermos.getData().add(series);
    series.getNode().setStyle("-fx-stroke-width: 1px;");
  }

  public void crearPunto(ActionEvent actionEvent) {
    XYChart.Series series = new XYChart.Series();
    series.setName("set 2");


    for (int i=0; i<100; i++) {
      series.getData().add(new XYChart.Data(i, Math.sin(i)));
    }
    chartEnfermos.getData().add(series);

    series.getNode().setStyle("-fx-stroke-width: 1px;");
  }

  public void clear(ActionEvent actionEvent) {
    chartEnfermos.getData().clear();
  }
}
