package dao.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Armario {

  private int id;
  private String ubicacion;
  private int size;
  private List<Ropa> prendas;
  private Cajonera cajonera;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Armario armario = (Armario) o;
    return getId() == armario.getId();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  public Armario(String ubicacion, int size, List<Ropa> prendas, Cajonera cajonera) {
    this.ubicacion = ubicacion;
    this.size = size;

    //this.prendas = prendas;
    this.cajonera = cajonera;
    this.prendas = new ArrayList<>(prendas);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  @Override
  public String toString() {
    return "Armario{" +
        "id=" + id +
        ", ubicacion='" + ubicacion + '\'' +
        ", size=" + size +
        ", prendas=" + prendas +
        ", cajonera=" + cajonera +
        '}';
  }
}
