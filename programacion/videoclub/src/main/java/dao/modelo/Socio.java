package dao.modelo;

import java.util.Objects;

public class Socio {

  private String nif;
  private int tamañoCabeza;

  public Socio() {
  }

  public Socio(String nif, int tamañoCabeza) {
    this.nif = nif;
    this.tamañoCabeza = tamañoCabeza;
  }

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

  public String getNif() {
    return nif;
  }

  public void setNif(String nif) {
    this.nif = nif;
  }

  public int getTamañoCabeza() {
    return tamañoCabeza;
  }

  public void setTamañoCabeza(int tamañoCabeza) {
    this.tamañoCabeza = tamañoCabeza;
  }
}
