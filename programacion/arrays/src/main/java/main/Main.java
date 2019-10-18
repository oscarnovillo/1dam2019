/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author oscar
 */
public class Main {

  public static void main(String[] args) {

    //crea
    int numeritos[] = new int[10];

    int numeritosCreados[] = {1, -2, 3, 40, 5};

    int tamaño = 20;

    int numeritosCantidadVariable[]
            = new int[tamaño];

    numeritos[5] = 100;
    
    System.out.println(numeritos[5]);

    System.out.println(numeritosCreados[2]);
    
    for (int i=0; i<numeritosCreados.length; i++)
    {
      System.out.println(numeritosCreados[i]);
    }

    for (int i=numeritosCreados.length-1; 
            i>=0; i--)
    {
      System.out.println(numeritosCreados[i]);
    }

    
    
    
    
    
    Arrays.stream(numeritosCreados).parallel()
            .sorted()
            .filter((value) -> value<10)
            .forEachOrdered(System.out::println);
    
    
  }

}
