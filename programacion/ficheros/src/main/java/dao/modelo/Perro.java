package dao.modelo;

import java.time.LocalDate;

public class Perro extends Animal{

  private int numeroHuesosDiario;


  public Perro(String nombre, int numeroPatas, LocalDate fecha) {
    super(nombre, numeroPatas, fecha);
  }
}
