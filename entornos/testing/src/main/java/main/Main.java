/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import calculadora.Calculadora;

import java.util.Scanner;

/**
 * @author oscar
 */
public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("dame primer numero");
    int num1 = sc.nextInt();
    System.out.println("dame segundo numero");
    int num2 = sc.nextInt();

    System.out.println("que quieres hacer??");
    int opcion = sc.nextInt();
    Calculadora c = new Calculadora();
    switch (opcion) {
      case 1:
        System.out.println(" lasuma de los numeros es=" + c.suma(num1, num2));
        break;
      case 2:
        break;
      case 3:
        break;
      case 4:
        break;

    }
    sc.close();


  }
}
