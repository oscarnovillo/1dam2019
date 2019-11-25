/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author oscar
 */
public class EjercicioExamen21b {

  public static void main(String[] args) {
    int numeros[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int operaciones[] = {1, 1, 1, 1, 3, 1, 2, 1, 4, 1};
    int resultado = numeros[0];
    boolean error = false;

    for (int i = 1; i < numeros.length; i++) {
      switch (operaciones[i - 1]) {
        case 1:
          resultado += numeros[i];
          break;
        case 2:
          resultado -= numeros[i];
          break;
        case 3:
          resultado *= numeros[i];
          break;
        case 4:
          if (numeros[i] == 0) {
            error = true;
            i = numeros.length;
          } else {
            resultado /= numeros[i];
          }
          break;
      }

    }

    if (!error) {
      System.out.println(resultado);
    } else {
      System.out.println("ERROR DIVIDE BY 0");
    }

  }
}
