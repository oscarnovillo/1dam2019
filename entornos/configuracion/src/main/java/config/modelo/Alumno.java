package config.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Alumno {

  private String nombre;
  private String direccion;
  private LocalDate fecha;


  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public LocalDate getFecha() {
    return fecha;
  }

  public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
  }

  @Override
  public String toString() {
    return "Alumno{" +
        "nombre='" + nombre + '\'' +
        ", password='" + direccion + '\'' +
        ", fecha=" + fecha.plusMonths(1).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
        '}';
  }
}
