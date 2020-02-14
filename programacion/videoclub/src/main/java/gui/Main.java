package gui;

import com.github.javafaker.Faker;
import config.Configuration;
import dao.DaoSocios;
import dao.modelo.*;
import servicios.ServiciosVideoclub;

import java.text.Normalizer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main {


  // cosas nuevas, Map, Fechas,
  // Estructura servicios dao, Config, herencia polimorfismo,

  public static void main(String[] args) {

    setup();
    System.out.println(Configuration.getPrecioAlquiler());

    Configuration.setDiasAlquilerPeliculas(34);

    Producto p = new Documental("" , 4 ,"",0,FormatoPelicula.DVD);
    Documental d = (Documental)p;
    Pelicula peli = new Pelicula("" , 4 ,"",0,FormatoPelicula.DVD);
    Documental docu = new Pelicula("" , 4 ,"",0,FormatoPelicula.DVD);

    p.toString();
    docu.toString();


    Producto p1 = peli;

    //Pelicula peli1 = (Pelicula)p;

    Faker f = new Faker();

//    VideoJuego v = new Pelicula();
//
//     Pelicula p1 = new Documental();

    LocalDate fecha = LocalDate.of(2010,10,1);
    LocalDate fechaMasUnDia = fecha.plus(1, ChronoUnit.DAYS);

    LocalDateTime time = LocalDateTime.of(2010,10,1,0,0,0);
    System.out.println(LocalDateTime.now().isAfter(time.plusYears(20)));

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


    Pelicula pe = new Pelicula("titutlo",10,
        "shooter",0, FormatoPelicula.VIDEO);

Documental d1 = new Documental("docuemntal de focas",200
    ,"animales",20,FormatoPelicula.DVD);



  DaoSocios socios = new DaoSocios();
  Socio sco = socios.getSocioPorNif("jj");
  if (sco!=null)
  {
  }
  else
  {
    System.out.println("no existe socio");
  }




  }


  public static void setup()
  {
    ServiciosVideoclub sv = new ServiciosVideoclub();
    sv.addSocio(new Socio("kk",90));
    //sv.addProducto(new Documental());


  }


}
