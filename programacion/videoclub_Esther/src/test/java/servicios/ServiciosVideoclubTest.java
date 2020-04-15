package servicios;

import dao.modelo.Documental;
import dao.modelo.FormatoPelicula;
import dao.modelo.Pelicula;
import dao.modelo.Videojuego;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServiciosVideoclubTest {

  @Test
  void getTodasPeliculas() {
    //Given
    ServiciosVideoclub sv = new ServiciosVideoclub();
    Pelicula p = new Pelicula("pelicula1",1,"", FormatoPelicula.DVD,"emilly","1");
    Documental d = new Documental("pelicula1",1,"", FormatoPelicula.DVD,"emilly","1");
    Videojuego v = new Videojuego("pelicula1",1,"","");
    sv.addProducto(p);
    sv.addProducto(d);
    sv.addProducto(v);

    //when
    List<Pelicula> pelis = sv.getTodasPeliculas();

    //then
    assertAll( "ver peliculas",
        () -> assertEquals(p,pelis.get(0)),
        () -> assertEquals(1,pelis.size()));


    assertEquals(p,pelis.get(0));
    assertEquals(1,pelis.size());


  }
}