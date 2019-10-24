/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author oscar
 */
public class Ejercico78 {

  public static void main(String[] args) {

    int numeros[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    int contadorCreciente = 0;
    int contadorDecreciente = 0;

    for (int i = 0; i < numeros.length - 1; i++) {
      if (numeros[i] <= numeros[i + 1]) {
        contadorCreciente++;
      } else if (numeros[i] > numeros[i + 1]) {
        contadorDecreciente++;
      }

    }

    if (contadorCreciente == numeros.length - 1) {
      System.out.println(" creciente");
    } else if (contadorDecreciente == numeros.length - 1) {
      System.out.println(" Decreciente");
    }

    for (int i=0; i<5;i++)
    {
      shift1(numeros);
    }
    
    int []nums = IntStream.generate(() -> {
      Random r = new Random();
      return r.nextInt(); //To change body of generated lambdas, choose Tools | Templates.
    }).limit(10).sorted().toArray();
    
    IntStream.range(0, numeros.length).filter((value) -> {
      return (numeros[value] %2) == 0; 
    }).map((value) -> {
      return numeros[value]; //To change body of generated lambdas, choose Tools | Templates.
    }).sorted().forEach(System.out::println);
    
    
    System.out.println("{"+ Arrays.stream(numeros)
            .mapToObj((value) -> {
       return value+""; //To change body of generated lambdas, choose Tools | Templates.
     }).collect(Collectors.joining(",")) + "}");

    
    
    
  }

  
  public static void shift1(int []numeros)
  {
    int ultimoNumero = numeros[numeros.length - 1];
    for (int i = numeros.length - 1; i >= 1; i--) {
      numeros[i] = numeros[i - 1];
    }
    numeros[0] = ultimoNumero;
  }
          
}
