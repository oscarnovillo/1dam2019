package main;

import java.util.Scanner;

public class Menu {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int opcion = 0;


    do {
      System.out.println("1. ejercicio19 pag2 ");
      System.out.println("2. ejercici20 pag2 ");
      System.out.println("0. salir");
      System.out.println("dame opcion");
      opcion = sc.nextInt();
      sc.nextLine();

      switch (opcion) {
        case 1:
          String nombre = sc.nextLine();
          System.out.println(nombre);
          break;
        case 2:
          nombre = "jj";
          int numero = sc.nextInt();
          System.out.println(numero);
          break;

      }

    } while (opcion != 0);

    System.out.println("!ADIOS!");

  }
}
