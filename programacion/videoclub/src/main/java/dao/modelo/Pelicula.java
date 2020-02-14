package dao.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pelicula extends Documental{

  private List<String> actores;


  public Pelicula(String titulo, int cantidad, String genero, double valoracionMedia, FormatoPelicula formato) {
    super(titulo, cantidad, genero, valoracionMedia, formato);
    this.actores = new ArrayList<>();
  }

  public List<String> getActores() {
    return actores;
  }


  @Override
  public String toString() {
    return super.toString()+
        "y ademas como Peli con los actores "
        + actores
        ;
  }
}
