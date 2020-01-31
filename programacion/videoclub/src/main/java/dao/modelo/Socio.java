package dao.modelo;

import java.util.Objects;

public class Socio {

  private String nif;
  private int tamañoCabeza;


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Socio socio = (Socio) o;
    return Objects.equals(nif, socio.nif);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nif);
  }
}
