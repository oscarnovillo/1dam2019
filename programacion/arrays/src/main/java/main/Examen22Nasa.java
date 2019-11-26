/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author oscar
 */
public class Examen22Nasa {

  public static void main(String[] args) {
    int numeros[] = {5,20,11,10,8,15};
    int veces[] = { 2,1,0,1,3,1};
int posicionCambiar = 0;

    if (validarArray(numeros))
    {
      System.out.println(Arrays.toString(numeros));

      for (int i = 0; i < numeros.length; i++) {
        posicionCambiar = veces[i]+i;
        
        posicionCambiar %= numeros.length;
        
        int swap = numeros[i];
        numeros[i] = numeros[posicionCambiar];
        numeros[posicionCambiar] = swap;
      }
      
      System.out.println(Arrays.toString(numeros));
      for (int i = numeros.length-1; i >=0; i--) {
        posicionCambiar = veces[i]+i;
        
        posicionCambiar %= numeros.length;
        
        int swap = numeros[i];
        numeros[i] = numeros[posicionCambiar];
        numeros[posicionCambiar] = swap;
      }


      System.out.println(Arrays.toString(numeros));


    }
    else
    {
      System.out.println("ERROR");
    }

  }

  public static boolean validarArray(int numeros[]) {
    boolean valido = true;

    for (int i = 0; i < numeros.length && valido; i++) {

      if (numeros[i] < 5 || numeros[i] > 29) {
        valido = false;
      } else {
        for (int j = 0; j < numeros.length; j++) {
          if ((j != i) && (numeros[j] == numeros[i])) {
            valido = false;
          }
        }
      }

    }

    return valido;
  }
}
