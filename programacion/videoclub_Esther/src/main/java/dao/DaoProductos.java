package dao;

import dao.modelo.Documental;
import dao.modelo.Pelicula;
import dao.modelo.Producto;
import dao.modelo.Videojuego;

import java.util.List;

public interface DaoProductos {
  boolean addProducto(Producto producto);

  List<Pelicula> getTodasPeliculas();

  List<Videojuego> getTodosVideojuegos();

  List<Documental> getTodosDocumentales();
}
