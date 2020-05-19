package dao.modelo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;

public class Gato extends Animal {


  private int cantidadLecheDiaria;

  public Logger log4j = LogManager.getLogger(this.getClass().getName());


  public Gato(String nombre, int numeroPatas, LocalDate fecha) {
    super(nombre, numeroPatas, fecha);
  }
}
