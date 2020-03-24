/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 * hacer una calculadora de numeros naturales.
 * solo positivos
 *
 *
 * @author oscar
 */
public class Calculadora {

  // que si algun numero es negativo o 0 da error -1
  public int suma(int a, int b) {
    int resultado = a + b;

    if (a < 1 || b < 1) {
      resultado = -1;
    }

    return resultado;
  }


  public int resta(int a, int b) {

    return a - b;
  }
}
