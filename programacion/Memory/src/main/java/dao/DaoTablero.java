/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.modelo.Celda;

/**
 *
 * @author oscar
 */
public class DaoTablero {
  
  private Celda tablero[][];

  public Celda[][] getTablero() {
    return tablero;
  }

  public DaoTablero(int anchura,int altura) {
    
    this.tablero = new Celda[anchura][altura];
  }

  
  
  
  
  
  
}
