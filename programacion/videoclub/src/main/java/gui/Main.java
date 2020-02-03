package gui;

import com.github.javafaker.Faker;
import config.Configuration;
import dao.modelo.Documental;
import dao.modelo.Pelicula;
import dao.modelo.Producto;

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

    System.out.println(Configuration.getPrecioAlquiler());

    Configuration.setDiasAlquilerPeliculas(34);

    Producto p = new Documental();
    Documental d = (Documental)p;
    Pelicula peli = new Pelicula();
    Documental docu = new Pelicula();

    Producto p1 = peli;

    Pelicula peli1 = (Pelicula)p;

    Faker f = new Faker();

//    VideoJuego v = new Pelicula();
//
//     Pelicula p1 = new Documental();

    LocalDate fecha = LocalDate.of(2010,10,1);
    LocalDate fechaMasUnDia = fecha.plus(1, ChronoUnit.DAYS);

    LocalDateTime time = LocalDateTime.of(2010,10,1,0,0,0);
    System.out.println(time.plusYears(20).isAfter(LocalDateTime.now()));


    Calendar c = Calendar.getInstance();
    Date date = new Date();




  }



}
