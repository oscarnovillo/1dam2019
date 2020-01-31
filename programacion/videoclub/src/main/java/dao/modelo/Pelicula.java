package dao.modelo;

import java.util.List;

public class Pelicula extends Documental{

  private List<String> actores;

  public List<String> getActores() {
    return actores;
  }

  public void setActores(List<String> actores) {
    this.actores = actores;
  }
}
