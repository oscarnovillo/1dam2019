package servicios;

import config.Configuration;
import dao.modelo.Encuesta;
import dao.modelo.FormatoPelicula;
import dao.modelo.Pelicula;
import dao.modelo.Socio;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ServiciosVideoclub.class)
public class PowerMockTest {

  @Test
  public void socioSancionado () {

    LocalDateTime dummy = LocalDateTime.of(2018, 8, 25, 0, 0);

    PowerMockito.mockStatic(LocalDateTime.class);
    PowerMockito.when(LocalDateTime.now()).thenReturn(dummy);

    ServiciosVideoclub sv = new ServiciosVideoclub();
    Pelicula p = new Pelicula("pelicula1",1,"", FormatoPelicula.DVD,"emilly","1");
    Socio s = new Socio("koko","asd","asd","aasd",12);
    sv.addProducto(p);
    sv.addSocio(s);
    sv.alquilarProducto(p,"koko");

    PowerMockito.when(LocalDateTime.now()).thenReturn(dummy.plusSeconds(Configuration.getDiasAlquilerPeliculas()+1));
    sv.devolverProducto("koko",new Encuesta(8,true));

    assertThat(s.isSancionado()).isTrue();

  }


}
