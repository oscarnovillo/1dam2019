package main;

import servicios.ServiciosTablero;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oscar
 */
public class MainMemory {
  
  public static void main(String[] args) {
    
    int anchura= 2;
    int altura = 2;
    
    ServiciosTablero st = new ServiciosTablero(anchura,altura);
    
    System.out.println(st.mostrarTablero());
    
    ServiciosTablero st1 = new ServiciosTablero(3,3);
    
    System.out.println(st1.mostrarTablero());
    
  }
  
}
