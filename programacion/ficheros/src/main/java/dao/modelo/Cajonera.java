package dao.modelo;

public class Cajonera {

  private int numCajones;
  private int alto;
  private int ancho;


  public Cajonera(int numCajones, int alto, int ancho) {
    this.numCajones = numCajones;
    this.alto = alto;
    this.ancho = ancho;
  }

  public Cajonera() {
  }

  public int getNumCajones() {
    return numCajones;
  }

  public void setNumCajones(int numCajones) {
    this.numCajones = numCajones;
  }

  public int getAlto() {
    return alto;
  }

  public void setAlto(int alto) {
    this.alto = alto;
  }

  public int getAncho() {
    return ancho;
  }

  public void setAncho(int ancho) {
    this.ancho = ancho;
  }
}
