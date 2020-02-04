package gui;

import com.github.javafaker.Faker;
import config.Configuration;
import dao.modelo.Documental;
import dao.modelo.Pelicula;
import dao.modelo.Producto;
import dao.modelo.Socio;
import servicios.ServiciosVideoclub;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;

public class Main {


  // cosas nuevas, Map, Fechas,
  // Estructura servicios dao, Config, herencia polimorfismo,

  public static void main(String[] args) {

    setup();
    System.out.println(Configuration.getPrecioAlquiler());

    Configuration.setDiasAlquilerPeliculas(34);

    Producto p = new Documental();
    Documental d = (Documental)p;
    Pelicula peli = new Pelicula();
    Documental docu = new Pelicula();

    Producto p1 = peli;

    //Pelicula peli1 = (Pelicula)p;

    Faker f = new Faker();

//    VideoJuego v = new Pelicula();
//
//     Pelicula p1 = new Documental();

    LocalDate fecha = LocalDate.of(2010,10,1);
    LocalDate fechaMasUnDia = fecha.plus(1, ChronoUnit.DAYS);

    LocalDateTime time = LocalDateTime.of(2010,10,1,0,0,0);
    System.out.println(time.plusYears(20).isAfter(LocalDateTime.now()));

    // addSocio
    Socio socio = new Socio("",100);

    Socio socio2 = new Socio();
    socio2.setNif("89898");
    socio2.setTamañoCabeza(10);

    ServiciosVideoclub sv = new ServiciosVideoclub();

    boolean añadido = sv.addSocio(socio);
    if (!añadido )
    {
      System.out.println("soico ya existe");
    }
    añadido = sv.addSocio(socio);
    if (!añadido )
    {
      System.out.println("soico ya existe a la segunda");
    }

    // add Producto









  }


  public static void setup()
  {
    ServiciosVideoclub sv = new ServiciosVideoclub();
    sv.addSocio(new Socio("kk",90));
    sv.addProducto(new Documental());


  }


}
