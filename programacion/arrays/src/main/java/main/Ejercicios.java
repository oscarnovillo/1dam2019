/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;

/**
 *
 * @author oscar
 */
public class Ejercicios {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int numeritosCreados[] = new int[5];

    for (int i = 0; i < numeritosCreados.length; i++) {
      System.out.println("dame numero "+(i+1)+" de 5");
      numeritosCreados[i] = sc.nextInt();
    }

    for (int i = 0; i < numeritosCreados.length; i++) {
      System.out.println(numeritosCreados[i]);
    }
    for (int i = numeritosCreados.length - 1;
            i >= 0; i--) {
      System.out.println(numeritosCreados[i]);
    }

  }

}
