/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Arrays;

/**
 *
 * @author oscar
 */
public class Examen22Chiquitistan {

  public static void main(String[] args) {
    int numeros[] = {-6, -6, -5, -3, -2, -1, 4, 6, 7, 9};

    if (validarArray(numeros)) {
      System.out.println(Arrays.toString(numeros));

      for (int i = 0; i < numeros.length; i++) {
        if (numeros[i] < 0) {
          for (int j = 0; j < numeros.length - 1; j++) {
            if (Math.abs(numeros[j]) > Math.abs(numeros[j + 1])) {
              int swap = numeros[j];
              numeros[j] = numeros[j + 1];
              numeros[j + 1] = swap;
            } 
          }
        }
      }

      System.out.println(Arrays.toString(numeros));
      for (int i = 0; i < numeros.length; i++) {
        
          for (int j = 0; j < numeros.length - 1; j++) {
            if (numeros[j] > numeros[j + 1]) {
              int swap = numeros[j];
              numeros[j] = numeros[j + 1];
              numeros[j + 1] = swap;
            } 
          }
        
      }
      System.out.println(Arrays.toString(numeros));

    } else {
      System.out.println("array no valido");
    }

  }

  public static boolean validarArray(int numeros[]) {
    boolean valido = true;
    boolean positivo = false;
    for (int i = 0; i < numeros.length && valido; i++) {
      if (numeros[i] == 0) {
        valido = false;
      } else if ((i < numeros.length - 1)
              && (numeros[i] > numeros[i + 1])) {
        valido = false;
      } else if (numeros[i] > 0) {
        positivo = true;
      }
    }
    if (!positivo) {
      valido = false;
    }

    return valido;
  }
}
