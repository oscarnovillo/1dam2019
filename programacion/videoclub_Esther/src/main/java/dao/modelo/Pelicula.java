package dao.modelo;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class Pelicula extends Documental{

  @Size(min=1)
  private List<String> actores;

  public Pelicula(String titulo, int cantidad, String genero, FormatoPelicula formato, String director, String duracion) {
    super(titulo, cantidad, genero, formato, director, duracion);
    this.actores = new ArrayList<>();
  }

  public List<String> getActores() {
    return actores;
  }

  @Override
  public String toString() {
    return "Pelicula: (" + super.toString() + ")";
  }


}
