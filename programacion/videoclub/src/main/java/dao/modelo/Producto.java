package dao.modelo;

import java.util.List;

public abstract class Producto {

  private String titulo;
  private List<Encuesta> encuestas;
  private int cantidad;
  private int cantidadAlquilada;
  private String genero;
  private double valoracionMedia;


  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public List<Encuesta> getEncuestas() {
    return encuestas;
  }

  public void setEncuestas(List<Encuesta> encuestas) {
    this.encuestas = encuestas;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {

    this.cantidad = cantidad;
  }

  public int getCantidadAlquilada() {
    return cantidadAlquilada;
  }

  public void setCantidadAlquilada(int cantidadAlquilada) {
    this.cantidadAlquilada = cantidadAlquilada;
  }

  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public double getValoracionMedia() {
    return valoracionMedia;
  }

  public void setValoracionMedia(double valoracionMedia) {
    this.valoracionMedia = valoracionMedia;
  }
}
