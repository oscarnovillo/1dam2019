package dao.modelo;

public class Ropa {


  private String talla;
  private String tipo;

  public Ropa(String talla, String tipo) {
    this.talla = talla;
    this.tipo = tipo;
  }

  public Ropa() {
  }

  public String getTalla() {
    return talla;
  }

  public void setTalla(String talla) {
    this.talla = talla;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }
}
