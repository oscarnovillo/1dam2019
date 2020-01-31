package gui;

import config.Configuration;
import dao.modelo.Documental;
import dao.modelo.Pelicula;
import dao.modelo.Producto;
import dao.modelo.VideoJuego;

public class Main {


  //cosas nuevas, Map, Fechas,
  // Estructura servicios dao, Config, herencia polimorfismo,

  public static void main(String[] args) {
    System.out.println(Configuration.getPrecioAlquiler());

    Producto p = new Producto();
    Pelicula peli = new Pelicula();
    Documental docu = new Pelicula();

    Producto p1 = peli;


    Pelicula peli1 = (Pelicula)p;



//    VideoJuego v = new Pelicula();
//
//     Pelicula p1 = new Documental();



  }



}
