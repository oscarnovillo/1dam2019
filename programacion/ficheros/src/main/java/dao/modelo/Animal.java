package dao.modelo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.beans.Transient;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Animal implements Comparable,Guardable {

  private String nombre;

  private String rutaFoto;

  private int numeroPatas;

  private LocalDate birth;

  public Animal() {
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getNumeroPatas() {
    return numeroPatas;
  }

  public void setNumeroPatas(int numeroPatas) {
    this.numeroPatas = numeroPatas;
  }

  public LocalDate getBirth() {
    return birth;
  }

  public void setBirth(LocalDate birth) {
    this.birth = birth;
  }


  public Animal(String nombre,int numeroPatas, LocalDate fecha) {
    this.nombre = nombre;
    this.numeroPatas = numeroPatas;
    this.birth = fecha;
  }


  @Override
  public String toString() {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    return "Animal{" +
        "nombre='" + nombre + '\'' +
        ", numeroPatas=" + numeroPatas +
        ", birth=" + formatter.format(birth) +
        '}';
  }

  @Override
  public int compareTo(Object o) {
    int comparacion = 0;
    if (o instanceof Animal) {
      comparacion = this.nombre.compareTo(((Animal) o).nombre);
      if (comparacion == 0)
      {
        comparacion  = (this.numeroPatas -  ((Animal) o).numeroPatas);
      }
    }
    return comparacion;

  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Animal animal = (Animal) o;
    return nombre.equals(animal.nombre);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nombre);
  }

  @Override
  public String guardar() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return nombre + "," +numeroPatas+","+formatter.format(birth);
  }

  @Override
  public void cargar(String linea) {
    String []campos = linea.split(",");

    this.numeroPatas = Integer.parseInt(campos[1]);
    this.nombre = campos[0];
    this.birth = LocalDate.parse(campos[2],
        DateTimeFormatter.ofPattern("dd/MM/yyyy"));
  }
}
