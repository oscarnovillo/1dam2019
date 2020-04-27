package servicios;

import dao.modelo.*;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;



class ServiciosVideoclubTest {

  @Test
  void getTodasPeliculas() {
    //Given
    ServiciosVideoclub sv = new ServiciosVideoclub();
    Pelicula p = new Pelicula("pelicula1",1,"", FormatoPelicula.DVD,"emilly","1");
    p.setValoracionMedia(10);
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

    int i = 9;
    assertTrue(8<i && i>10);



    assertEquals(p,pelis.get(0));
    assertEquals(1,pelis.size());
  }


  @Test
  void probarDevolucionProducto()
  {
    //Given
    Instant.now(Clock.fixed(
        Instant.parse("2018-08-22T10:00:00Z"),
        ZoneOffset.UTC));
    ServiciosVideoclub sv = new ServiciosVideoclub();


  }


}





