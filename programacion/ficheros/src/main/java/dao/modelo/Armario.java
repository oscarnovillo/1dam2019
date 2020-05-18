package dao.modelo;

import java.util.ArrayList;
import java.util.List;


public class Armario {

  private String ubicacion;
  private int size;
  private List<Ropa> prendas;
  private Cajonera cajonera;

  public Armario(String ubicacion, int size, List<Ropa> prendas, Cajonera cajonera) {
    this.ubicacion = ubicacion;
    this.size = size;
    //this.prendas = prendas;
    this.cajonera = cajonera;
    this.prendas = new ArrayList<>(prendas);
  }

  public Armario() {
  }

  public String getUbicacion() {
    return ubicacion;
  }

  public void setUbicacion(String ubicacion) {
    this.ubicacion = ubicacion;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public List<Ropa> getPrendas() {
    return prendas;
  }

  public void setPrendas(List<Ropa> prendas) {
    this.prendas = prendas;
  }

  public Cajonera getCajonera() {
    return cajonera;
  }

  public void setCajonera(Cajonera cajonera) {
    this.cajonera = cajonera;
  }
}
