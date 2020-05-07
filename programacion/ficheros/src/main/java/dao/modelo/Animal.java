package dao.modelo;

import java.util.Objects;

public class Animal implements Comparable,Guardable {

  private String nombre;

  private int numeroPatas;

  public Animal() {
  }

  public Animal(String nombre, int numeroPatas) {
    this.nombre = nombre;
    this.numeroPatas = numeroPatas;
  }


  @Override
  public String toString() {
    return "Animal{" +
        "nombre='" + nombre + '\'' +
        ", numeroPatas=" + numeroPatas +
        '}';
  }

  @Override
  public int compareTo(Object o) {
    int comparacion = 0;
    if (o instanceof Animal) {
      comparacion = -1*this.nombre.compareTo(((Animal) o).nombre);
      if (comparacion == 0)
      {
        comparacion  = -1*(this.numeroPatas -  ((Animal) o).numeroPatas);
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
   return nombre + "," +numeroPatas;
  }

  @Override
  public void cargar(String linea) {

    String []campos = linea.split(",");

    this.numeroPatas = Integer.parseInt(campos[1]);
    this.nombre = campos[0];
  }
}
