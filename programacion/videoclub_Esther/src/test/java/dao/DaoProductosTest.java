package dao;

import dao.modelo.Documental;
import dao.modelo.FormatoPelicula;
import dao.modelo.Pelicula;
import dao.modelo.Videojuego;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DaoProductosTest {

  @Test
  void addProducto() {
  }

  @Test
  void borrarProducto() {
  }

  @Test
  void getTodasPeliculas() {
    //Given
    DaoProductos dao = new DaoProductos();
    Pelicula p = new Pelicula("pelicula1",1,"", FormatoPelicula.DVD,"emilly","1");
    Documental d = new Documental("pelicula1",1,"", FormatoPelicula.DVD,"emilly","1");
    Videojuego v = new Videojuego("pelicula1",1,"","");

    dao.addProducto(p);
    dao.addProducto(d);
    dao.addProducto(v);

    //when
    List<Pelicula> pelis = dao.getTodasPeliculas();

    //then
    assertEquals(pelis.get(0),p);
    assertEquals(pelis.size(),1);


  }

  @Test
  void getTodosVideojuegos() {
  }

  @Test
  void getTodosDocumentales() {
  }
}