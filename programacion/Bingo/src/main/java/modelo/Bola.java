/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author oscar
 */
public class Bola {
  
  private int valor;
  private boolean marcado;

  public Bola(int valor) {
    this.valor = valor;
    this.marcado =false;
  }
  
  public int getValor() {
    return valor;
  }

  public void setValor(int valor) {
    this.valor = valor;
  }

  public boolean isMarcado() {
    return marcado;
  }

  public void setMarcado(boolean marcado) {
    this.marcado = marcado;
  }
  
  
  
}
