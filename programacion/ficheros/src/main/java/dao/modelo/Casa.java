package dao.modelo;

public class Casa {

  private int id;
  private String direccion;

  public Casa(int id, String direccion) {
    this.id = id;
    this.direccion = direccion;
  }

  public Casa() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }
}
