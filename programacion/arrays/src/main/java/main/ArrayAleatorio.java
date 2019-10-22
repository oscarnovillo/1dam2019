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
public class ArrayAleatorio {

  public static void main(String[] args) {

    int numeros[] = new int[20];

    rellenaRandomArray(numeros, 10);
    imprimirArray(numeros);
   
    for (int i=0;i<numeros.length-1; i++)
    {
      changePosition(numeros, i, i+1);
    }
    
    
    System.out.println(Arrays.toString(numeros));

  }

  public static void changePosition(int array[],int origen,int destino)
  {
    int swap = array[destino];
    array[destino] = array[origen];
    array[origen] = swap;
    
  }
  
  public static int[] rellenaArray(int size, int bound) {
    int[] array = new int[size];
    Random r = new Random();
    for (int i = 0; i < array.length; i++) {
      array[i] = r.nextInt(bound);
    }

    return array;
  }

  public static void rellenaRandomArray(int array[], int bound) {

    Random r = new Random();
    for (int i = 0; i < array.length; i++) {
      array[i] = r.nextInt(bound);
    }
  }

  public static void imprimirArray(int array[]) {

    System.out.print("{");

    for (int i = 0; i < array.length; i++) {
      if (i != 0) {
        System.out.print(",");
      }
      System.out.print(array[i]);
    }
    System.out.println("}");
  }

}
