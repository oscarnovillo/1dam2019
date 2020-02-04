package servicios;

import config.Configuration;
import dao.modelo.*;

import java.util.List;

public class ServiciosVideoclub {

  // add socio
  public boolean addSocio(Socio socio) {
    return true;
  }

  // borrarSocio
  public boolean borrarSocio(Socio socio) {
    return true;
  }

  public Socio getSocio(String nif) {
    return null;
  }

  public boolean addProducto(Producto producto) {
    return true;
  }

  public void actualizarStockProducto(Producto p, int cantidad) {

  }

  public boolean devolverProducto(Producto p, Socio socio, Encuesta e) {
    return true;
  }

  public boolean alquilarProducto(Producto p, Socio s) {

    double precio = Configuration.getPrecioAlquiler();

    return true;
  }

  public List<Pelicula> getTodasPeliculas()
  {
    return null;
  }

  public List<Documental> getTodosDocumentales()
  {
    return null;
  }

  public List<Videojuego> getTodosVideoJuegos()
  {
    return null;
  }



  public List<Documental> getPeliculasPorGenero(String genero)
  {
    return null;
  }

  public List<Documental> getVideojuegosPorGenero(String genero)
  {
    return null;
  }

  public List<Documental> getPeliculasPorDirector(String genero)
  {
    return null;
  }


  public List<Documental> getMejoresPeliculas() {
    return null;
  }


  public List<Videojuego> getMejoresVideojuegos() {
    return null;
  }


}
