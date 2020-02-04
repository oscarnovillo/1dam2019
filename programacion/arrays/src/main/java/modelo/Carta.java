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
public class Carta {

  @Override
  public String toString() {
    String sPalo = "";
    switch(palo)
    {
      case 0: sPalo = "oros";break;
      case 1:sPalo = "copas";break;
      case 2:sPalo = "espadas";break;
      case 3:sPalo = "bastos";break;
    }
    return "("+valor + " " + sPalo+")";
  }
  
  private int valor;
  private int palo;

  public int getValor() {
    return valor;
  }

  public void setValor(int valor) {
    this.valor = valor;
  }

  public int getPalo() {
    return palo;
  }

  public void setPalo(int palo) {
    this.palo = palo;
  }

    @Override
    public String toString() {
        return String.format("(%2d,%2d) ",valor ,palo);
    }

 
  
}
