/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.modelo;

/**
 *
 * @author oscar
 */
public class Celda {

  private EstadoCelda estado;
  private String value;

  public EstadoCelda getEstado() {
    return estado;
  }

  public void setEstado(EstadoCelda estado) {
    this.estado = estado;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    if (estado == EstadoCelda.OCULTO) {
      return "---";
    } else {
      return value;
    }
  }

}
