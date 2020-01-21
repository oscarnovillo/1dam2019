/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quevedo.strings;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author oscar
 */
public class Ahorcado {

  public static void main(String[] args) {

    String palabra = "jarandilla";
    StringBuilder sb = new StringBuilder();

    palabra.chars().forEach((value) -> {
      sb.append("_ ");
    });

    boolean fin = false;
    Scanner sc = new Scanner(System.in);
    while (!fin) {
      char letra = sc.nextLine().charAt(0);
      //String letra = sc.nextLine().substring(0,1);

      // ver si la letra esta en la palabra
      int indice = palabra.indexOf(letra);
      
      if (indice >= 0) {
         sb.replace(indice*2, indice*2+ 1, "" + letra);
        for (int i = indice; i < palabra.length(); i++) {
          i = palabra.indexOf("" + letra, i+1);
          if (i != -1) {
            sb.replace(i*2, i*2 + 1, "" + letra);
          }
          else
          {
            i = palabra.length();
          }
            
        }
        System.out.println("letra esta");
        System.out.println(sb);
      } else {
        System.out.println("letra no esta");
      }
      fin = sb.indexOf("_") == -1;
    }

  }

}
