package dao;

import dao.modelo.Documental;
import dao.modelo.Pelicula;
import dao.modelo.Producto;
import dao.modelo.Videojuego;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DaoProductos {


  private static Map<String, Producto> productosGenero;


  public List<Pelicula> getTodasPeliculas(){
    return productosGenero.values().stream().filter(producto -> producto instanceof  Pelicula).map(producto -> (Pelicula)producto).collect(Collectors.toList());
  }

  public List<Videojuego> getTodosVideojuegos() {
    return null;
  }


  public List<Documental> getTodosDocumentales() {
    return productosGenero.values().stream()
        .filter(producto -> !(producto instanceof  Pelicula) && (producto instanceof  Documental))
        .map(producto -> (Documental)producto).collect(Collectors.toList());
  }


}
