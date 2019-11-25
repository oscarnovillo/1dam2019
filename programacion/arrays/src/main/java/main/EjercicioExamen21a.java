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
public class EjercicioExamen21a {

  public static void main(String[] args) {
    int numeros[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int veces[] = {1, 1, 1, 1, 1, 1, 1, 1, 2, 3};
    int numeroVeces = 0;
    for (int i = 0; i < veces.length; i++) {
      numeroVeces += veces[i];
    }

    int solucion[] = new int[numeroVeces];

    int indiceSolucion =0;
    for (int i = 0; i < numeros.length; i++) {
      for (int j = 0; j < veces[i]; j++) {
        solucion[indiceSolucion] = numeros[i];
        indiceSolucion++;
      }
    }

    System.out.println(Arrays.toString(solucion));
    
  }

}
