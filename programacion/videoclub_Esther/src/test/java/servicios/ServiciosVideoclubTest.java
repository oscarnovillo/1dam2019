package servicios;

import dao.DaoAlquileres;
import dao.modelo.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.time.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;


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





